/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.instantiation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.ModelingProperties;

class ValidateConnectionsSwitch extends AadlProcessingSwitchWithProgress {

	Map<InstanceObject, InstantiatedClassifier> classifierCache;

	public ValidateConnectionsSwitch(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Map<InstanceObject, InstantiatedClassifier> classifierCache) {
		super(monitor, errManager);
		this.classifierCache = classifierCache;
	}

	@Override
	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {

			@Override
			public String caseComponentInstance(final ComponentInstance ci) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				validateConnections(ci);
				return DONE;
			}
		};
	}

	private void validateConnections(ComponentInstance ci) {
		removeShortAccessConnections(ci);

		checkEndPointClassifiers(ci);
		// more
	}

	/**
	 * If a feature group contains access and port features we may have created incomplete access connections that
	 * end, e.g., on a thread, but for which there is also a complete connection to a subcomponent of this thread.
	 * This method finds these connections and deletes them from the instance model.
	 *
	 * @param ci - Validate connections owned by ci
	 */
	private void removeShortAccessConnections(ComponentInstance ci) {
		List<ConnectionInstance> connis = ci.getConnectionInstances();
		List<ConnectionInstance> toRemove = new ArrayList<>();
		Map<ConnectionInstanceEnd, List<ConnectionInstance>> bySrc = connis.stream()
				.collect(Collectors.groupingBy(ConnectionInstance::getSource));
		Map<ConnectionInstanceEnd, List<ConnectionInstance>> byDst = connis.stream()
				.collect(Collectors.groupingBy(ConnectionInstance::getSource));

		connis.stream().forEach(conni -> {
			if (conni.getKind() != ConnectionKind.ACCESS_CONNECTION) {
				return;
			}
			ConnectionInstanceEnd src = conni.getSource();
			ConnectionInstanceEnd dst = conni.getDestination();

			boolean remove = bySrc.getOrDefault(src, Collections.emptyList())
					.stream()
					.anyMatch(test -> shouldCompare(test, conni) && startsWith(test, conni));
			remove |= bySrc.getOrDefault(dst, Collections.emptyList())
					.stream()
					.anyMatch(test -> shouldCompare(test, conni) && startsWithReverse(test, conni));
			remove |= byDst.getOrDefault(dst, Collections.emptyList())
					.stream()
					.anyMatch(test -> shouldCompare(test, conni) && endsWith(test, conni));
			remove |= byDst.getOrDefault(src, Collections.emptyList())
					.stream()
					.anyMatch(test -> shouldCompare(test, conni) && endsWithReverse(test, conni));
			if (remove) {
				toRemove.add(conni);
			}
		});
		connis.removeAll(toRemove);
	}

	private boolean shouldCompare(ConnectionInstance test, ConnectionInstance conni) {
		return test != conni && test.getKind() == ConnectionKind.ACCESS_CONNECTION;
	}

	private boolean startsWith(ConnectionInstance test, ConnectionInstance conni) {
		List<ConnectionReference> testRefs = test.getConnectionReferences();
		List<ConnectionReference> connRefs = conni.getConnectionReferences();
		if (connRefs.size() >= testRefs.size()) {
			return false;
		}

		Iterator<ConnectionReference> testing = testRefs.iterator();
		Iterator<ConnectionReference> prefix = connRefs.iterator();

		while (prefix.hasNext()) {
			ConnectionReference t = testing.next();
			ConnectionReference p = prefix.next();
			if (t.getConnection() != p.getConnection()) {
				return false;
			}
			if (!prefix.hasNext()) {
				return t.getDestination() == p.getDestination();
			}
		}
		return false;
	}

	private boolean startsWithReverse(ConnectionInstance test, ConnectionInstance conni) {
		List<ConnectionReference> testRefs = test.getConnectionReferences();
		List<ConnectionReference> connRefs = conni.getConnectionReferences();
		if (connRefs.size() >= testRefs.size()) {
			return false;
		}

		Iterator<ConnectionReference> testing = testRefs.iterator();
		ListIterator<ConnectionReference> prefix = connRefs.listIterator(connRefs.size());

		while (prefix.hasPrevious()) {
			ConnectionReference t = testing.next();
			ConnectionReference p = prefix.previous();
			if (t.getConnection() != p.getConnection()) {
				return false;
			}
			if (!prefix.hasPrevious()) {
				return t.getDestination() == p.getSource();
			}
		}
		return false;
	}

	private boolean endsWith(ConnectionInstance test, ConnectionInstance conni) {
		List<ConnectionReference> testRefs = test.getConnectionReferences();
		List<ConnectionReference> connRefs = conni.getConnectionReferences();
		if (connRefs.size() >= testRefs.size()) {
			return false;
		}

		ListIterator<ConnectionReference> testing = test.getConnectionReferences()
				.listIterator(test.getConnectionReferences().size());
		ListIterator<ConnectionReference> prefix = connRefs.listIterator(connRefs.size());

		while (prefix.hasPrevious()) {
			ConnectionReference t = testing.previous();
			ConnectionReference p = prefix.previous();
			if (t.getConnection() != p.getConnection()) {
				return false;
			}
			if (!prefix.hasPrevious()) {
				return t.getSource() == p.getSource();
			}
		}
		return false;
	}

	private boolean endsWithReverse(ConnectionInstance test, ConnectionInstance conni) {
		List<ConnectionReference> testRefs = test.getConnectionReferences();
		List<ConnectionReference> connRefs = conni.getConnectionReferences();
		if (connRefs.size() >= testRefs.size()) {
			return false;
		}

		ListIterator<ConnectionReference> testing = test.getConnectionReferences()
				.listIterator(test.getConnectionReferences().size());
		Iterator<ConnectionReference> prefix = connRefs.iterator();

		while (prefix.hasNext()) {
			ConnectionReference t = testing.previous();
			ConnectionReference p = prefix.next();
			if (t.getConnection() != p.getConnection()) {
				return false;
			}
			if (!prefix.hasNext()) {
				return t.getSource() == p.getDestination();
			}
		}
		return false;
	}

	private void checkEndPointClassifiers(final ComponentInstance ci) {
		final List<ConnectionInstance> connis = ci.getConnectionInstances();
		for (final ConnectionInstance conni : connis) {
			final ConnectionInstanceEnd srcEnd = conni.getSource();
			final ConnectionInstanceEnd destEnd = conni.getDestination();
			if (!(srcEnd instanceof ModeTransitionInstance) && !(destEnd instanceof ModeTransitionInstance)) {
				final boolean sourceIsSubcomponent = srcEnd instanceof ComponentInstance;
				final boolean destIsSubcomponent = destEnd instanceof ComponentInstance;
				final Classifier srcClassifier = getConnectionEndClassifier(srcEnd);
				final Classifier destClassifier = getConnectionEndClassifier(destEnd);
				if (srcClassifier == null && destClassifier != null) {
					if (!isAbstractFeature(srcEnd)) {
						warning(conni,
								"Expected " + (sourceIsSubcomponent ? "subcomponent \'" : "feature \'")
										+ srcEnd.getComponentInstancePath() + "' to have classifier '"
										+ destClassifier.getQualifiedName() + '\'');
					}
				} else if (srcClassifier != null && destClassifier == null) {
					if (!isAbstractFeature(destEnd)) {
						warning(conni,
								"Expected " + (destIsSubcomponent ? "subcomponent \'" : "feature \'")
										+ destEnd.getComponentInstancePath() + "' to have classifier '"
										+ srcClassifier.getQualifiedName() + '\'');
					}
				} else {
					checkEndPointClassifierMatching(conni, srcEnd, destEnd, srcClassifier, destClassifier);
				}
			}
		}
	}

	private void checkEndPointClassifierMatching(final ConnectionInstance conni, final ConnectionInstanceEnd srcEnd,
			final ConnectionInstanceEnd destEnd, final Classifier srcClassifier, final Classifier destClassifier) {
		String classifierMatchingRuleValue = GetProperties.getClassifierMatchingRuleProperty(conni);
		if (ModelingProperties.CLASSIFIER_MATCH.equalsIgnoreCase(classifierMatchingRuleValue)) {
			if (!testClassifierMatchRule(conni, srcEnd, srcClassifier, destEnd, destClassifier)) {
				error(conni, '\'' + srcEnd.getComponentInstancePath() + "' and '" + destEnd.getComponentInstancePath()
						+ "' have incompatible classifiers.");
			}
		} else if (ModelingProperties.EQUIVALENCE.equalsIgnoreCase(classifierMatchingRuleValue)) {
			if (!testClassifierMatchRule(conni, srcEnd, srcClassifier, destEnd,
					destClassifier)
					&& !classifiersFoundInSupportedClassifierEquivalenceMatchesProperty(conni, srcClassifier,
							destClassifier)) {
				error(conni, "The types of '" + srcEnd.getComponentInstancePath() + "' and '"
						+ destEnd.getComponentInstancePath() + "' ('" + srcClassifier.getQualifiedName() + "' and '"
						+ destClassifier
								.getQualifiedName()
						+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
						+ AadlProject.SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES + "'.");
			}
		} else if (ModelingProperties.SUBSET.equalsIgnoreCase(classifierMatchingRuleValue)) {
			if (!classifiersFoundInSupportedClassifierSubsetMatchesProperty(conni, srcClassifier, destClassifier)
					&& !isDataSubset(srcClassifier, destClassifier)) {
				error(conni, "The data type of '" + srcEnd.getComponentInstancePath() + "' ('"
						+ srcClassifier
						.getQualifiedName()
						+ "') is not a subset of the data type of '" + destEnd.getComponentInstancePath() + "' ('"
						+ destClassifier
								.getQualifiedName()
								+ "') based on name matching or the property constant '"
								+ AadlProject.SUPPORTED_CLASSIFIER_SUBSET_MATCHES + "'.");
			}
		} else if (ModelingProperties.CONVERSION.equalsIgnoreCase(classifierMatchingRuleValue)) {
			if (!testClassifierMatchRule(conni, srcEnd, srcClassifier, destEnd,
					destClassifier)
					&& !classifiersFoundInSupportedTypeConversionsProperty(conni, srcClassifier, destClassifier)) {
				error(conni, "The types of '" + srcEnd.getComponentInstancePath() + "' and '"
						+ destEnd.getComponentInstancePath() + "' ('" + srcClassifier.getQualifiedName() + "' and '"
						+ destClassifier
								.getQualifiedName()
						+ "') are incompatible and they are not listed as matching classifiers in the property constant '"
						+ AadlProject.SUPPORTED_TYPE_CONVERSIONS + "'.");
			}
		}
	}

	private static boolean isAbstractFeature(final ConnectionInstanceEnd end) {
		return end instanceof FeatureInstance
				? (((FeatureInstance) end).getCategory() == FeatureCategory.ABSTRACT_FEATURE)
				: false;
	}

	private static Classifier getConnectionEndClassifier(final ConnectionInstanceEnd end) {
		return end instanceof ComponentInstance ? ((ComponentInstance) end).getClassifier()
				: ((FeatureInstance) end).getFeature().getClassifier();
	}

	// XXX How can I avoid duplicating this method for the instance and the declarative models?
	private boolean testClassifierMatchRule(final ConnectionInstance connection, ConnectionInstanceEnd source,
			Classifier sourceClassifier, ConnectionInstanceEnd destination, Classifier destinationClassifier) {
		if (sourceClassifier != destinationClassifier) {
			if (sourceClassifier instanceof ComponentImplementation
					&& destinationClassifier instanceof ComponentType) {
				if (!destinationClassifier.equals(((ComponentImplementation) sourceClassifier).getType())) {
					error(connection, "The types of '" + source.getComponentInstancePath()
							+ "' and '" + destination.getComponentInstancePath() + "' do not match.");
				}
			} else {
				return false;
			}
		}
		return true;
	}

	// XXX How can I avoid duplicating this method for the instance and the declarative models?
	private boolean classifiersFoundInSupportedClassifierEquivalenceMatchesProperty(final ConnectionInstance connection,
			Classifier source, Classifier destination) {
		final PropertyConstant matchesPropertyConstant = GetProperties
				.lookupPropertyConstant(connection,
				AadlProject.SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES);
		if (matchesPropertyConstant == null) {
			return false;
		}
		final PropertyExpression constantValue = matchesPropertyConstant.getConstantValue();
		if (!(constantValue instanceof ListValue)) {
			return false;
		}
		for (final PropertyExpression classifierPair : ((ListValue) constantValue).getOwnedListElements()) {
			if (classifierPair instanceof ListValue) {
				EList<PropertyExpression> innerListElements = ((ListValue) classifierPair).getOwnedListElements();
				if (innerListElements.size() == 2 && innerListElements.get(0) instanceof ClassifierValue
						&& innerListElements.get(1) instanceof ClassifierValue) {
					Classifier firstPairElement = ((ClassifierValue) innerListElements.get(0)).getClassifier();
					Classifier secondPairElement = ((ClassifierValue) innerListElements.get(1)).getClassifier();
					if ((firstPairElement == source && secondPairElement == destination)
							|| (firstPairElement == destination && secondPairElement == source)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// XXX How can I avoid duplicating this method for the instance and the declarative models?
	private boolean classifiersFoundInSupportedClassifierSubsetMatchesProperty(ConnectionInstance connection,
			Classifier source,
			Classifier destination) {
		PropertyConstant matchesPropertyConstant = GetProperties.lookupPropertyConstant(connection,
				AadlProject.SUPPORTED_CLASSIFIER_SUBSET_MATCHES);
		if (matchesPropertyConstant == null) {
			return false;
		}
		PropertyExpression constantValue = matchesPropertyConstant.getConstantValue();
		if (!(constantValue instanceof ListValue)) {
			return false;
		}
		for (PropertyExpression classifierPair : ((ListValue) constantValue).getOwnedListElements()) {
			if (classifierPair instanceof ListValue) {
				EList<PropertyExpression> innerListElements = ((ListValue) classifierPair).getOwnedListElements();
				if (innerListElements.size() == 2 && innerListElements.get(0) instanceof ClassifierValue
						&& innerListElements.get(1) instanceof ClassifierValue) {
					Classifier firstPairElement = ((ClassifierValue) innerListElements.get(0)).getClassifier();
					Classifier secondPairElement = ((ClassifierValue) innerListElements.get(1)).getClassifier();
					if (firstPairElement == source && secondPairElement == destination) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// XXX How can I avoid duplicating this method for the instance and the declarative models?
	private boolean isDataSubset(Classifier source, Classifier destination) {
		Boolean result = true;
		if (source instanceof DataImplementation && destination instanceof DataImplementation) {
			EList<Subcomponent> destElements = ((DataImplementation) destination).getAllSubcomponents();
			EList<Subcomponent> srcElements = ((DataImplementation) source).getAllSubcomponents();
			for (Subcomponent destSubcomponent : destElements) {
				result = result && containsNamedElement(destSubcomponent.getName(), srcElements);
			}
		}
		return result;
	}

	// XXX How can I avoid duplicating this method for the instance and the declarative models?
	private boolean containsNamedElement(String name, EList<Subcomponent> srcElements) {
		for (Subcomponent srcsubcomponent : srcElements) {
			if (name.equalsIgnoreCase(srcsubcomponent.getName())) {
				return true;
			}
		}
		return false;
	}

	// XXX How can I avoid duplicating this method for the instance and the declarative models?
	private boolean classifiersFoundInSupportedTypeConversionsProperty(ConnectionInstance connection,
			Classifier source,
			Classifier destination) {
		PropertyConstant conversionsPropertyConstant = GetProperties.lookupPropertyConstant(connection,
				AadlProject.SUPPORTED_TYPE_CONVERSIONS);
		if (conversionsPropertyConstant == null) {
			return false;
		}
		PropertyExpression constantValue = conversionsPropertyConstant.getConstantValue();
		if (!(constantValue instanceof ListValue)) {
			return false;
		}
		for (PropertyExpression classifierPair : ((ListValue) constantValue).getOwnedListElements()) {
			if (classifierPair instanceof ListValue) {
				EList<PropertyExpression> innerListElements = ((ListValue) classifierPair).getOwnedListElements();
				if (innerListElements.size() == 2 && innerListElements.get(0) instanceof ClassifierValue
						&& innerListElements.get(1) instanceof ClassifierValue) {
					Classifier firstPairElement = ((ClassifierValue) innerListElements.get(0)).getClassifier();
					Classifier secondPairElement = ((ClassifierValue) innerListElements.get(1)).getClassifier();
					if (firstPairElement == source && secondPairElement == destination) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
