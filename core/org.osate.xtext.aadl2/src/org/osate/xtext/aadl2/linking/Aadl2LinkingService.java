/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.annexsupport.AnnexLinkingServiceRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

public class Aadl2LinkingService extends PropertiesLinkingService {

	AnnexLinkingServiceRegistry annexlinkingserviceregistry ;
	
	protected void Aadl2linkingService(){
		initAnnexLinkingServiceRegistry();
	}
	
	protected void initAnnexLinkingServiceRegistry(){
		if (annexlinkingserviceregistry == null){
		annexlinkingserviceregistry = (AnnexLinkingServiceRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_LINKINGSERVICE_EXT_ID);
		}
	}
	
	

	
	@Override
	public List<EObject> getLinkedObjects(EObject context,
			EReference reference, INode node) throws IllegalNodeException {
		NamedElement annex = AadlUtil.getContainingAnnex(context);
		if (annex != null){
			String annexName = annex.getName();
			if (annexName != null ){
				if (annexlinkingserviceregistry == null) initAnnexLinkingServiceRegistry();
				if (annexlinkingserviceregistry != null){
					AnnexLinkingService linkingservice = annexlinkingserviceregistry.getAnnexLinkingService(annexName);
					if (linkingservice != null){
						List<EObject> result = linkingservice.resolveAnnexReference(annexName,context, reference, node);
						if (!result.isEmpty()) return result;
// XXX drop through to call on linking service for resolving Aadl2 references
//					} else {
//						return super.getLinkedObjects(context, reference, node);
					}
				}
// XXX drop through to call on linking service for resolving Aadl2 references
//			} else {
//				return super.getLinkedObjects(context, reference, node);
			}
		}
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();
		
		final EClass pt = Aadl2Package.eINSTANCE.getPropertyType();
		final EClass cl = Aadl2Package.eINSTANCE.getClassifier();
		final EClass sct = Aadl2Package.eINSTANCE.getSubcomponentType();
		final String name = getCrossRefNodeAsString(node);
		if (sct.isSuperTypeOf(requiredType) || cl.isSuperTypeOf(requiredType)) {
			// XXX: this code can be replicated in Aadl2LinkingService as it is called often in the core
			// resolve classifier reference
			EObject e = findClassifier(context, reference,  name);
			if (e != null ) {
				// the result satisfied the expected class
				return Collections.singletonList((EObject) e);
			}
			if (!(context instanceof Generalization) && sct.isSuperTypeOf(requiredType)){
				// need to resolve prototype
				EObject res = AadlUtil.getContainingClassifier(context)
						.findNamedElement(name);
				if (Aadl2Package.eINSTANCE.getDataPrototype()==reference ){
					if( res instanceof DataPrototype ){
						return Collections.singletonList(res);
					}
				} else if ( res instanceof ComponentPrototype) {
					return Collections.singletonList(res);
				}
			}
			return Collections.EMPTY_LIST;
		} else 
		if (Aadl2Package.eINSTANCE.getFeatureClassifier().isSuperTypeOf(requiredType)) {
			// prototype for feature or component, or data,bus,subprogram, subprogram group classifier
			EObject e = findClassifier(context, reference,  name);
			if (e == null &&!(context instanceof Generalization) &&  !Aadl2Package.eINSTANCE.getComponentType().isSuperTypeOf(requiredType)){
				// look for prototype
				e = AadlUtil.getContainingClassifier(context).findNamedElement(name);
				// TODO-phf: this can be removed if the FeatureClassifier class handles it
				if (! (e instanceof FeaturePrototype || e instanceof ComponentPrototype))
					e = null;
			}
			if (e!=null&&requiredType.isSuperTypeOf(e.eClass())){
				return Collections.singletonList((EObject) e);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getFeaturePrototype() == requiredType) {
				// look for prototype
				EObject e = AadlUtil.getContainingClassifier(context).findNamedElement(name);
				// TODO-phf: this can be removed if the FeatureClassifier class handles it
				if (e instanceof FeaturePrototype )
					return Collections.singletonList((EObject) e);
				return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getConnectionEnd() == requiredType) {
			// resolve connection end
			Context cxt = ((ConnectedElement) context).getContext();
			Connection conn = (Connection) context.eContainer();
			ConnectionEnd ce = null;
			if (conn instanceof PortConnection) {
				ce = findPortConnectionEnd(
						(PortConnection) context.eContainer(), cxt, name);
			} else if (conn instanceof AccessConnection) {
				ce = findAccessConnectionEnd(
						(AccessConnection) context.eContainer(), cxt, name);
			} else if (conn instanceof FeatureGroupConnection) {
				ce = findFeatureGroupConnectionEnd(
						(FeatureGroupConnection) context.eContainer(), cxt, name);
			} else if (conn instanceof FeatureConnection) {
				ce = findFeatureConnectionEnd(
						(FeatureConnection) context.eContainer(), cxt, name);
			} else if (conn instanceof ParameterConnection) {
				ce = findParameterConnectionEnd(
						(ParameterConnection) context.eContainer(), cxt, name);
			}
			if (ce != null) {
				return Collections.singletonList((EObject) ce);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getPort().isSuperTypeOf(requiredType)) {
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof Feature) {
				// we need to resolve a  feature refinement, thus look up the feature in the 
				// component being extended
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			} else if (context instanceof TriggerPort){
				// we are a trigger port
				Context TPContext = ((TriggerPort)context).getContext();
				if (TPContext instanceof Subcomponent){
					// look up the feature in the ComponentType
					ComponentType ct = ((Subcomponent)TPContext).getComponentType();
					if (ct != null)
						ns = ct;
				}
			}
			EObject searchResult = AadlUtil.findNamedElementInList(ns.getAllFeatures(), name);
			if (searchResult != null && searchResult instanceof Port) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getContext() == requiredType) {
			// represents connection source/dest context as well as flowspec
			// context
			// also used in triggerport
			EObject searchResult = AadlUtil.getContainingClassifier(context)
					.findNamedElement(name);
			if (context instanceof ConnectedElement) {
				// connection context
				EObject conn = context.eContainer();
				if (((conn instanceof FeatureGroupConnection
						|| conn instanceof FeatureConnection ) 
						&& (searchResult instanceof Subcomponent || searchResult instanceof FeatureGroup))
					|| ((conn instanceof AccessConnection) 
						&& (searchResult instanceof Subcomponent 
							|| searchResult instanceof FeatureGroup
							|| searchResult instanceof SubprogramCall))
					|| ((conn instanceof ParameterConnection) 
						&& (searchResult instanceof Parameter
							|| searchResult instanceof SubprogramCall
							|| searchResult instanceof DataPort
							|| searchResult instanceof EventDataPort || searchResult instanceof FeatureGroup))
					|| ((conn instanceof PortConnection) 
						&& (searchResult instanceof FeatureGroup
							|| searchResult instanceof Subcomponent || searchResult instanceof SubprogramCall
							|| searchResult instanceof DataPort || searchResult instanceof EventDataPort)))
					return Collections.singletonList((EObject) searchResult);
			} else if (context instanceof TriggerPort
					|| context instanceof FlowEnd
					|| context instanceof FlowSegment
					|| context instanceof EndToEndFlowSegment) {
				if (searchResult instanceof Subcomponent
						|| searchResult instanceof FeatureGroup
						|| searchResult instanceof SubprogramCall)
					return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getCallContext() == requiredType) {
			EObject searchResult = AadlUtil.getContainingClassifier(context)
					.findNamedElement(name);
			if (searchResult != null
					&& requiredType.isSuperTypeOf(searchResult.eClass())) {
				return Collections.singletonList((EObject) searchResult);
			}
			searchResult = findClassifier(context, reference, name);
			if (searchResult != null ) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getCalledSubprogram() == requiredType) {
			// full name comes here
			// first check whether it is a reference to a classifier
			Classifier ns = AadlUtil.getContainingClassifier(context);
			EObject searchResult = findClassifier(context, reference,  name);
			if (searchResult != null
					&& requiredType.isSuperTypeOf(searchResult.eClass())) {
				((SubprogramCall) context).setContext(null); 
				return Collections.singletonList((EObject) searchResult);
			}
			int idx = name.lastIndexOf(".");
			if (idx < 0){
				// name without dot
				// if it was a qualified component type name it would have been found before
				if (!name.contains("::")){
					// no package qualifier. Look up in local name space
					searchResult = ns.findNamedElement(name);
					if (searchResult != null
							&& requiredType.isSuperTypeOf(searchResult.eClass())) {
						return Collections.singletonList((EObject) searchResult);
					}
				}
				return Collections.<EObject> emptyList();
			}
			// we have a name with a dot that is not a component implementation
			// lets find the context and the calledSubprogram
			String contextName = name.substring(0, idx);
			String callName = name.substring(idx+1);
			EReference contextReference = Aadl2Package.eINSTANCE.getSubprogramCall_Context();
			searchResult = findClassifier(context, contextReference,  contextName);
			if (searchResult == null){
				searchResult = ns.findNamedElement(contextName);
			}
			if (searchResult instanceof CallContext) {
				// we have a context
				// lets set it and find the called subprogram
				CallContext callContext = (CallContext)searchResult;
				if (context instanceof SubprogramCall){
					((SubprogramCall)context).setContext(callContext);
				} else {
					return Collections.<EObject> emptyList();
				}
				if (callContext instanceof ComponentType){
					ns = (ComponentType)callContext;
				} else if (callContext instanceof SubprogramGroupSubcomponent){
					ns = ((SubprogramGroupSubcomponent)callContext).getComponentType();
					if (ns == null) {
						return Collections.<EObject> emptyList();
					}
				} else if (callContext instanceof SubprogramGroupAccess && ((SubprogramGroupAccess)callContext).getKind() == AccessType.REQUIRES){
					SubprogramGroupSubcomponentType sst = ((SubprogramGroupAccess)callContext).getSubprogramGroupFeatureClassifier();
					if (sst instanceof Classifier)
						ns = (Classifier) sst;;
					if (ns == null) {
						return Collections.<EObject> emptyList();
					}
				} else if (callContext instanceof FeatureGroup ){
					ns = ((FeatureGroup)callContext).getFeatureGroupType();
					if (ns == null) {
						return Collections.<EObject> emptyList();
					}
				}
				searchResult = ns.findNamedElement(callName);
				if (searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
					return Collections.singletonList((EObject) searchResult);
				}
			}

  			////			CallContext callContext = ((SubprogramCall) context).getContext();
//  			if (callContext == null){
//				// look for prototype, subprogramsubcomponent
//				searchResult = ns.findNamedElement(name);
//				if (searchResult == null){
//					// look for subprogramclassifier
//					searchResult = findClassifier(context, reference,  name);
//				}
//				if (searchResult != null
//						&& requiredType.isSuperTypeOf(searchResult.eClass())) {
//					return Collections.singletonList((EObject) searchResult);
//				}
//			} else {
//				if (callContext.eIsProxy()){
//					INode n = node.getPreviousSibling();
//					INode n1 = n.getPreviousSibling();
//					String s1 = NodeModelUtils.getTokenText(n1);
//					String implname = s1+"."+name;
//					searchResult = findClassifier(context, reference,  s1);
//					searchResult = findClassifier(context, reference,  implname);
//					if (searchResult != null
//							&& requiredType.isSuperTypeOf(searchResult.eClass())) {
//						((SubprogramCall) context).setContext(null); 
//						return Collections.singletonList((EObject) searchResult);
//					}
//				} else
//				if (callContext instanceof ComponentType){
//					ns = (ComponentType)callContext;
//				} else if (callContext instanceof SubprogramGroupSubcomponent){
//					ns = ((SubprogramGroupSubcomponent)callContext).getComponentType();
//					if (ns == null) {
//						return Collections.<EObject> emptyList();
//					}
//				} else if (callContext instanceof SubprogramGroupAccess && ((SubprogramGroupAccess)callContext).getKind() == AccessType.REQUIRED){
//					SubprogramGroupSubcomponentType sst = ((SubprogramGroupAccess)callContext).getSubprogramGroupFeatureClassifier();
//					if (sst instanceof Classifier)
//						ns = (Classifier) sst;;
//					if (ns == null) {
//						return Collections.<EObject> emptyList();
//					}
//				} else if (callContext instanceof FeatureGroup ){
//					ns = ((FeatureGroup)callContext).getFeatureGroupType();
//					if (ns == null) {
//						return Collections.<EObject> emptyList();
//					}
//				}
//				searchResult = ns.findNamedElement(name);
//				if (searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
//					return Collections.singletonList((EObject) searchResult);
//				}
//			}
 
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getPrototype() == requiredType) {
			// if context prototype then find in extension source (refined)
			// prototype binding as context
			EObject searchResult = null;
			Classifier ns = null;
			if (context.eContainer() instanceof Subcomponent){
				Subcomponent sub = (Subcomponent) context.eContainer();
				ns = sub.getAllClassifier();
				searchResult = ns.findNamedElement(name);
			} else {
				ns = AadlUtil.getContainingClassifier(context);
				if (context instanceof Prototype) {
					// we need to resolve a refinement
					if (ns.getExtended() != null) {
						ns = ns.getExtended();
					} else {
						return Collections.emptyList();
					}
				}
				searchResult = ns.findNamedElement(name);
			}
			if (searchResult != null && searchResult instanceof Prototype) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getFlowElement() == requiredType) {
			// look for flow element in flow segment
			FlowSegment fs = (FlowSegment) context;
			Context flowContext = fs.getContext();
			if (flowContext == null){
				ComponentImplementation cc = fs.getContainingComponentImpl();
				if (Aadl2Util.isNull(cc)) return Collections.<EObject> emptyList();;
				EObject searchResult = cc.findNamedElement(name);
				if (searchResult instanceof FlowElement){
					return Collections.singletonList((EObject) searchResult);
				}
			} else {
				if (flowContext instanceof Subcomponent){
					ComponentType cc = ((Subcomponent)flowContext).getComponentType();
					if (Aadl2Util.isNull(cc)) 
						return Collections.<EObject> emptyList();;
					EObject searchResult = cc.findNamedElement(name);
					if (searchResult instanceof FlowSpecification){
						return Collections.singletonList( searchResult);
					}
				}  
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getEndToEndFlowElement() == requiredType) {
			// look for flow element in flow segment
			EndToEndFlowSegment fs = (EndToEndFlowSegment) context;
			Context flowContext = fs.getContext();
			if (flowContext == null){
				ComponentImplementation cc = fs.getContainingComponentImpl();
				EObject searchResult = cc.findNamedElement(name);
				if (searchResult instanceof EndToEndFlowElement){
					return Collections.singletonList((EObject) searchResult);
				}
			} else {
				if (flowContext instanceof Subcomponent){
					ComponentType cc = ((Subcomponent)flowContext).getComponentType();
					if (Aadl2Util.isNull(cc)) 
						return Collections.<EObject> emptyList();
					EObject searchResult = cc.findNamedElement(name);
					if (searchResult instanceof FlowSpecification){
						return Collections.singletonList( searchResult);
					}
				}  
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getModeTransition() == requiredType) {
			// referenced by in modes
			EObject searchResult = AadlUtil.getContainingClassifier(context)
					.findNamedElement(name);
			if (searchResult != null && searchResult instanceof ModeTransition) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getModeFeature() == requiredType) {
			// referenced by mode transition and inmodes
			EObject searchResult = AadlUtil.getContainingClassifier(context)
					.findNamedElement(name);
			if (searchResult != null && searchResult instanceof ModeFeature) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getFlowSpecification() == requiredType) {
			// refined flow spec
			// referenced by flow implementation
			// also referenced in flow elements in impl and etef
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof FlowSpecification) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(name);
			if (searchResult != null
					&& searchResult instanceof FlowSpecification) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getEndToEndFlow() == requiredType) {
			// refined flow spec
			// referenced by flow implementation
			// also referenced in flow elements in impl and etef
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof EndToEndFlow) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(name);
			if (searchResult != null && searchResult instanceof EndToEndFlow) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getConnection() == requiredType) {
			// refined to, flow elements
			Classifier ns = AadlUtil.getContainingClassifier(context);
			if (context instanceof Connection) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(name);
			if (searchResult != null && searchResult instanceof Connection) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getFeatureType() == requiredType) {
			// feature group type or prototype
			FeatureGroupType fgt = findFeatureGroupType(context, name, reference);
			if (fgt == null){
				// need to resolve prototype
				EObject res = AadlUtil.getContainingClassifier(context)
						.findNamedElement(name);
				 if ( res instanceof FeatureGroupPrototype) {
					return Collections.singletonList(res);
				}
			} else{
				return Collections.singletonList((EObject) fgt);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getArraySizeProperty() == requiredType) {
			// reference to a property constant or property
			// look for property definition in property set
			List<EObject> result = findPropertyDefinitionAsList(context, reference, name);
			if (result.isEmpty()){
				result = findPropertyConstant(context, reference, name);

			}
			return result;
		} else {
			
 			List<EObject> res = super.getLinkedObjects(context, reference, node);
 			return res;
//			Activator.logErrorMessage("Unhandled reference in Aadl2LinkingService: "+reference.getName()+" to "+requiredType.getName());
		}

//		return Collections.emptyList();
	}
	

	private static Aadl2LinkingService eInstance = null;

	@Deprecated
	public static Aadl2LinkingService getAadl2LinkingService(){
		if (eInstance == null) {
			PredeclaredProperties.initPluginContributedAadl();
			Resource rsrc = OsateResourceUtil.getResource(URI.createPlatformResourceURI(PredeclaredProperties.PLUGIN_RESOURCES_DIRECTORY_NAME+"/AADL_Project.aadl"));
			eInstance = (Aadl2LinkingService)((LazyLinkingResource)rsrc).getLinkingService();
		}
		return eInstance;
	}

	

}
