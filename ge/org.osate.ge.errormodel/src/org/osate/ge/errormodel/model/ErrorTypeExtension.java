/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.model;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.EmfContainerProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

public class ErrorTypeExtension implements EmfContainerProvider {
	private final ErrorType supertype;
	private final ErrorType subtype;
	
	public ErrorTypeExtension(final ErrorType supertype, final ErrorType subtype) {
		this.supertype = Objects.requireNonNull(supertype, "supertype must not be null");
		this.subtype = Objects.requireNonNull(subtype, "subtype must not be null");
	}
	
	public final ErrorType getSupertype() {
		return supertype;
	}
	
	public final ErrorType getSubtype() {
		return subtype;
	}

	@Override
	public EObject getEmfContainer() {
		return subtype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subtype == null) ? 0 : subtype.hashCode());
		result = prime * result + ((supertype == null) ? 0 : supertype.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ErrorTypeExtension other = (ErrorTypeExtension) obj;
		if (subtype == null) {
			if (other.subtype != null) {
				return false;
			}
		} else if (!subtype.equals(other.subtype)) {
			return false;
		}
		if (supertype == null) {
			if (other.supertype != null) {
				return false;
			}
		} else if (!supertype.equals(other.supertype)) {
			return false;
		}
		return true;
	}
}
