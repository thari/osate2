/*
 * generated by Xtext
 */
package org.osate.expr.validation;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.osate.expr.expr.ExprPackage;
import org.osate.expr.expr.VarDecl;

/**
 * This class contains custom validation rules.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class ExprJavaValidator extends org.osate.expr.validation.AbstractExprJavaValidator {

	@Override
	protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		// default test is by language name, but it's set to aadl2 in default validation
		return eObject.eClass().getEPackage() == ExprPackage.eINSTANCE;
	}

	@Check
	public void checkVarDeclHasTypeOrAssignment(VarDecl varDecl) {
		if (!varDecl.isConst()) {
			if (varDecl.getType() == null && varDecl.getValue() == null) {
				error("Variable declaration must have a type or a value");
			}
		} else {
			if (varDecl.getValue() == null) {
				error("Constant must have a value");
			}
		}
	}

}
