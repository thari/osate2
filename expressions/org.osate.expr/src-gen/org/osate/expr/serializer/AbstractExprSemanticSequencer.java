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
package org.osate.expr.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.expr.expr.Argument;
import org.osate.expr.expr.Assertion;
import org.osate.expr.expr.BagLiteral;
import org.osate.expr.expr.BagType;
import org.osate.expr.expr.BinaryOperation;
import org.osate.expr.expr.Block;
import org.osate.expr.expr.Category;
import org.osate.expr.expr.Conditional;
import org.osate.expr.expr.EBoolean;
import org.osate.expr.expr.EBooleanLiteral;
import org.osate.expr.expr.EInteger;
import org.osate.expr.expr.EIntegerLiteral;
import org.osate.expr.expr.EReal;
import org.osate.expr.expr.ERealLiteral;
import org.osate.expr.expr.EString;
import org.osate.expr.expr.EStringLiteral;
import org.osate.expr.expr.EnumLiteral;
import org.osate.expr.expr.EnumType;
import org.osate.expr.expr.ExprLibrary;
import org.osate.expr.expr.ExprModel;
import org.osate.expr.expr.ExprPackage;
import org.osate.expr.expr.ExprSubclause;
import org.osate.expr.expr.Field;
import org.osate.expr.expr.FieldValue;
import org.osate.expr.expr.FunDecl;
import org.osate.expr.expr.ListLiteral;
import org.osate.expr.expr.ListType;
import org.osate.expr.expr.MapLiteral;
import org.osate.expr.expr.MapType;
import org.osate.expr.expr.MetaClass;
import org.osate.expr.expr.NamedElementRef;
import org.osate.expr.expr.PropertyExpression;
import org.osate.expr.expr.Range;
import org.osate.expr.expr.RangeType;
import org.osate.expr.expr.RecordLiteral;
import org.osate.expr.expr.RecordType;
import org.osate.expr.expr.Selection;
import org.osate.expr.expr.SetLiteral;
import org.osate.expr.expr.SetType;
import org.osate.expr.expr.TupleLiteral;
import org.osate.expr.expr.TupleType;
import org.osate.expr.expr.TypeDecl;
import org.osate.expr.expr.TypeRef;
import org.osate.expr.expr.UnaryOperation;
import org.osate.expr.expr.UnionLiteral;
import org.osate.expr.expr.UnionType;
import org.osate.expr.expr.UnitExpression;
import org.osate.expr.expr.VarDecl;
import org.osate.expr.expr.WrappedNamedElement;
import org.osate.expr.services.ExprGrammarAccess;
import org.osate.xtext.aadl2.properties.serializer.PropertiesSemanticSequencer;

@SuppressWarnings("all")
public abstract class AbstractExprSemanticSequencer extends PropertiesSemanticSequencer {

	@Inject
	private ExprGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Aadl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Aadl2Package.ARRAY_RANGE:
				sequence_ArrayRange(context, (ArrayRange) semanticObject); 
				return; 
			case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
				sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject); 
				return; 
			case Aadl2Package.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Aadl2Package.CLASSIFIER_VALUE:
				sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject); 
				return; 
			case Aadl2Package.COMPUTED_VALUE:
				sequence_ComputedTerm(context, (ComputedValue) semanticObject); 
				return; 
			case Aadl2Package.CONTAINED_NAMED_ELEMENT:
				sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject); 
				return; 
			case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
				sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject); 
				return; 
			case Aadl2Package.INTEGER_LITERAL:
				sequence_IntegerTerm(context, (IntegerLiteral) semanticObject); 
				return; 
			case Aadl2Package.LIST_VALUE:
				sequence_ListTerm(context, (ListValue) semanticObject); 
				return; 
			case Aadl2Package.MODAL_PROPERTY_VALUE:
				if (rule == grammarAccess.getModalPropertyValueRule()) {
					sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOptionalModalPropertyValueRule()) {
					sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyValueRule()) {
					sequence_PropertyValue(context, (ModalPropertyValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.NAMED_VALUE:
				if (rule == grammarAccess.getConstantValueRule()
						|| rule == grammarAccess.getNumAltRule()) {
					sequence_ConstantValue(context, (NamedValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getLiteralorReferenceTermRule()) {
					sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.OPERATION:
				sequence_SignedConstant(context, (Operation) semanticObject); 
				return; 
			case Aadl2Package.PROPERTY_ASSOCIATION:
				if (rule == grammarAccess.getBasicPropertyAssociationRule()) {
					sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPModelRule()
						|| rule == grammarAccess.getContainedPropertyAssociationRule()) {
					sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPropertyAssociationRule()) {
					sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.RANGE_VALUE:
				sequence_NumericRangeTerm(context, (RangeValue) semanticObject); 
				return; 
			case Aadl2Package.REAL_LITERAL:
				sequence_RealTerm(context, (RealLiteral) semanticObject); 
				return; 
			case Aadl2Package.RECORD_VALUE:
				if (rule == grammarAccess.getOldRecordTermRule()) {
					sequence_OldRecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRecordTermRule()) {
					sequence_RecordTerm(context, (RecordValue) semanticObject); 
					return; 
				}
				else break;
			case Aadl2Package.REFERENCE_VALUE:
				sequence_ReferenceTerm(context, (ReferenceValue) semanticObject); 
				return; 
			case Aadl2Package.STRING_LITERAL:
				sequence_StringTerm(context, (StringLiteral) semanticObject); 
				return; 
			}
		else if (epackage == ExprPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ExprPackage.ARGUMENT:
				sequence_Argument(context, (Argument) semanticObject); 
				return; 
			case ExprPackage.ASSERTION:
				sequence_Assertion(context, (Assertion) semanticObject); 
				return; 
			case ExprPackage.BAG_LITERAL:
				sequence_BagLiteral_ExpressionList(context, (BagLiteral) semanticObject); 
				return; 
			case ExprPackage.BAG_TYPE:
				sequence_BagType(context, (BagType) semanticObject); 
				return; 
			case ExprPackage.BINARY_OPERATION:
				sequence_AdditiveExpression_AndExpression_EqualityExpression_MultiplicativeExpression_OrExpression_RelationalExpression(context, (BinaryOperation) semanticObject); 
				return; 
			case ExprPackage.BLOCK:
				sequence_BlockExpression(context, (Block) semanticObject); 
				return; 
			case ExprPackage.CATEGORY:
				sequence_Category(context, (Category) semanticObject); 
				return; 
			case ExprPackage.CONDITIONAL:
				sequence_IfExpression(context, (Conditional) semanticObject); 
				return; 
			case ExprPackage.EBOOLEAN:
				sequence_PrimitiveType(context, (EBoolean) semanticObject); 
				return; 
			case ExprPackage.EBOOLEAN_LITERAL:
				sequence_EBooleanLiteral(context, (EBooleanLiteral) semanticObject); 
				return; 
			case ExprPackage.EINTEGER:
				sequence_EInteger(context, (EInteger) semanticObject); 
				return; 
			case ExprPackage.EINTEGER_LITERAL:
				sequence_EIntegerLiteral(context, (EIntegerLiteral) semanticObject); 
				return; 
			case ExprPackage.EREAL:
				sequence_EReal(context, (EReal) semanticObject); 
				return; 
			case ExprPackage.EREAL_LITERAL:
				sequence_ERealLiteral(context, (ERealLiteral) semanticObject); 
				return; 
			case ExprPackage.ESTRING:
				sequence_PrimitiveType(context, (EString) semanticObject); 
				return; 
			case ExprPackage.ESTRING_LITERAL:
				sequence_EStringLiteral(context, (EStringLiteral) semanticObject); 
				return; 
			case ExprPackage.ENUM_LITERAL:
				sequence_EnumLiteral(context, (EnumLiteral) semanticObject); 
				return; 
			case ExprPackage.ENUM_TYPE:
				sequence_EnumType(context, (EnumType) semanticObject); 
				return; 
			case ExprPackage.EXPR_LIBRARY:
				sequence_Declarations_ExprLibrary(context, (ExprLibrary) semanticObject); 
				return; 
			case ExprPackage.EXPR_MODEL:
				sequence_ExprModel(context, (ExprModel) semanticObject); 
				return; 
			case ExprPackage.EXPR_SUBCLAUSE:
				sequence_Declarations_ExprSubclause(context, (ExprSubclause) semanticObject); 
				return; 
			case ExprPackage.FIELD:
				if (rule == grammarAccess.getNamedElementRule()
						|| rule == grammarAccess.getFieldRule()) {
					sequence_Field(context, (Field) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTupleFieldRule()) {
					sequence_TupleField(context, (Field) semanticObject); 
					return; 
				}
				else break;
			case ExprPackage.FIELD_VALUE:
				sequence_FieldValue(context, (FieldValue) semanticObject); 
				return; 
			case ExprPackage.FUN_DECL:
				sequence_Args_FunDecl(context, (FunDecl) semanticObject); 
				return; 
			case ExprPackage.LIST_LITERAL:
				sequence_ExpressionList_ListLiteral(context, (ListLiteral) semanticObject); 
				return; 
			case ExprPackage.LIST_TYPE:
				sequence_ListType(context, (ListType) semanticObject); 
				return; 
			case ExprPackage.MAP_LITERAL:
				sequence_MapLiteral(context, (MapLiteral) semanticObject); 
				return; 
			case ExprPackage.MAP_TYPE:
				sequence_MapType(context, (MapType) semanticObject); 
				return; 
			case ExprPackage.META_CLASS:
				sequence_MetaClass(context, (MetaClass) semanticObject); 
				return; 
			case ExprPackage.NAMED_ELEMENT_REF:
				sequence_NamedElementRef(context, (NamedElementRef) semanticObject); 
				return; 
			case ExprPackage.PROPERTY_EXPRESSION:
				sequence_PropertyExpression(context, (PropertyExpression) semanticObject); 
				return; 
			case ExprPackage.RANGE:
				sequence_RangeExpression(context, (Range) semanticObject); 
				return; 
			case ExprPackage.RANGE_TYPE:
				sequence_RangeType(context, (RangeType) semanticObject); 
				return; 
			case ExprPackage.RECORD_LITERAL:
				sequence_RecordLiteral(context, (RecordLiteral) semanticObject); 
				return; 
			case ExprPackage.RECORD_TYPE:
				sequence_RecordType(context, (RecordType) semanticObject); 
				return; 
			case ExprPackage.SELECTION:
				sequence_SelectExpression(context, (Selection) semanticObject); 
				return; 
			case ExprPackage.SET_LITERAL:
				sequence_ExpressionList_SetLiteral(context, (SetLiteral) semanticObject); 
				return; 
			case ExprPackage.SET_TYPE:
				sequence_SetType(context, (SetType) semanticObject); 
				return; 
			case ExprPackage.TUPLE_LITERAL:
				sequence_ExpressionList_TupleLiteral(context, (TupleLiteral) semanticObject); 
				return; 
			case ExprPackage.TUPLE_TYPE:
				sequence_TupleType(context, (TupleType) semanticObject); 
				return; 
			case ExprPackage.TYPE_DECL:
				sequence_TypeDecl(context, (TypeDecl) semanticObject); 
				return; 
			case ExprPackage.TYPE_REF:
				sequence_TypeRef(context, (TypeRef) semanticObject); 
				return; 
			case ExprPackage.UNARY_OPERATION:
				sequence_UnaryOperation(context, (UnaryOperation) semanticObject); 
				return; 
			case ExprPackage.UNION_LITERAL:
				sequence_UnionLiteral(context, (UnionLiteral) semanticObject); 
				return; 
			case ExprPackage.UNION_TYPE:
				sequence_UnionType(context, (UnionType) semanticObject); 
				return; 
			case ExprPackage.UNIT_EXPRESSION:
				sequence_UnitExpression(context, (UnitExpression) semanticObject); 
				return; 
			case ExprPackage.VAR_DECL:
				sequence_VarDecl(context, (VarDecl) semanticObject); 
				return; 
			case ExprPackage.WRAPPED_NAMED_ELEMENT:
				sequence_WrappedNamedElement(context, (WrappedNamedElement) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Expression returns BinaryOperation
	 *     OrExpression returns BinaryOperation
	 *     OrExpression.BinaryOperation_1_0_0_0 returns BinaryOperation
	 *     AndExpression returns BinaryOperation
	 *     AndExpression.BinaryOperation_1_0_0_0 returns BinaryOperation
	 *     EqualityExpression returns BinaryOperation
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns BinaryOperation
	 *     RelationalExpression returns BinaryOperation
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns BinaryOperation
	 *     AdditiveExpression returns BinaryOperation
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns BinaryOperation
	 *     MultiplicativeExpression returns BinaryOperation
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns BinaryOperation
	 *     UnaryOperation returns BinaryOperation
	 *     UnitExpression returns BinaryOperation
	 *     UnitExpression.UnitExpression_1_0 returns BinaryOperation
	 *     PropertyExpression returns BinaryOperation
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns BinaryOperation
	 *     SelectExpression returns BinaryOperation
	 *     SelectExpression.Selection_1_0_0 returns BinaryOperation
	 *     PrimaryExpression returns BinaryOperation
	 *
	 * Constraint:
	 *     (
	 *         (left=OrExpression_BinaryOperation_1_0_0_0 operator=OpOr right=AndExpression) | 
	 *         (left=AndExpression_BinaryOperation_1_0_0_0 operator=OpAnd right=EqualityExpression) | 
	 *         (left=EqualityExpression_BinaryOperation_1_0_0_0 operator=OpEquality right=RelationalExpression) | 
	 *         (left=RelationalExpression_BinaryOperation_1_0_0_0 operator=OpCompare right=AdditiveExpression) | 
	 *         (left=AdditiveExpression_BinaryOperation_1_0_0_0 operator=OpAdd right=MultiplicativeExpression) | 
	 *         (left=MultiplicativeExpression_BinaryOperation_1_0_0_0 operator=OpMulti right=UnaryOperation)
	 *     )
	 */
	protected void sequence_AdditiveExpression_AndExpression_EqualityExpression_MultiplicativeExpression_OrExpression_RelationalExpression(ISerializationContext context, BinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns FunDecl
	 *     EDeclaration returns FunDecl
	 *     FunDecl returns FunDecl
	 *
	 * Constraint:
	 *     (name=ID (args+=Argument args+=Argument*)? resultType=Type ((java?='java' fqn=JavaFQN) | exp=Expression)?)
	 */
	protected void sequence_Args_FunDecl(ISerializationContext context, FunDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns Argument
	 *     Argument returns Argument
	 *
	 * Constraint:
	 *     (name=ID type=Type)
	 */
	protected void sequence_Argument(ISerializationContext context, Argument semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.ARGUMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.ARGUMENT__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getArgumentAccess().getTypeTypeParserRuleCall_3_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns Assertion
	 *     EDeclaration returns Assertion
	 *     Assertion returns Assertion
	 *
	 * Constraint:
	 *     (name=ID assert=Expression)
	 */
	protected void sequence_Assertion(ISerializationContext context, Assertion semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.ASSERTION__ASSERT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.ASSERTION__ASSERT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAssertionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAssertionAccess().getAssertExpressionParserRuleCall_3_0(), semanticObject.getAssert());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns BagLiteral
	 *     OrExpression returns BagLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns BagLiteral
	 *     AndExpression returns BagLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns BagLiteral
	 *     EqualityExpression returns BagLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns BagLiteral
	 *     RelationalExpression returns BagLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns BagLiteral
	 *     AdditiveExpression returns BagLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns BagLiteral
	 *     MultiplicativeExpression returns BagLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns BagLiteral
	 *     UnaryOperation returns BagLiteral
	 *     UnitExpression returns BagLiteral
	 *     UnitExpression.UnitExpression_1_0 returns BagLiteral
	 *     PropertyExpression returns BagLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns BagLiteral
	 *     SelectExpression returns BagLiteral
	 *     SelectExpression.Selection_1_0_0 returns BagLiteral
	 *     PrimaryExpression returns BagLiteral
	 *     Literal returns BagLiteral
	 *     Value returns BagLiteral
	 *     BagLiteral returns BagLiteral
	 *
	 * Constraint:
	 *     (elements+=Expression elements+=Expression*)?
	 */
	protected void sequence_BagLiteral_ExpressionList(ISerializationContext context, BagLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns BagType
	 *     BagType returns BagType
	 *
	 * Constraint:
	 *     type=Type
	 */
	protected void sequence_BagType(ISerializationContext context, BagType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.BAG_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.BAG_TYPE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBagTypeAccess().getTypeTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Block
	 *     BlockExpression returns Block
	 *     OrExpression returns Block
	 *     OrExpression.BinaryOperation_1_0_0_0 returns Block
	 *     AndExpression returns Block
	 *     AndExpression.BinaryOperation_1_0_0_0 returns Block
	 *     EqualityExpression returns Block
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns Block
	 *     RelationalExpression returns Block
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns Block
	 *     AdditiveExpression returns Block
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns Block
	 *     MultiplicativeExpression returns Block
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns Block
	 *     UnaryOperation returns Block
	 *     UnitExpression returns Block
	 *     UnitExpression.UnitExpression_1_0 returns Block
	 *     PropertyExpression returns Block
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns Block
	 *     SelectExpression returns Block
	 *     SelectExpression.Selection_1_0_0 returns Block
	 *     PrimaryExpression returns Block
	 *
	 * Constraint:
	 *     (decls+=VarDecl* result=Expression)
	 */
	protected void sequence_BlockExpression(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns Category
	 *     Category returns Category
	 *
	 * Constraint:
	 *     category=ComponentCategory
	 */
	protected void sequence_Category(ISerializationContext context, Category semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.CATEGORY__CATEGORY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.CATEGORY__CATEGORY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCategoryAccess().getCategoryComponentCategoryParserRuleCall_0(), semanticObject.getCategory());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ExprLibrary returns ExprLibrary
	 *     NamedElement returns ExprLibrary
	 *
	 * Constraint:
	 *     (decls+=EDeclaration decls+=EDeclaration*)?
	 */
	protected void sequence_Declarations_ExprLibrary(ISerializationContext context, ExprLibrary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ExprSubclause returns ExprSubclause
	 *     NamedElement returns ExprSubclause
	 *
	 * Constraint:
	 *     (decls+=EDeclaration decls+=EDeclaration*)?
	 */
	protected void sequence_Declarations_ExprSubclause(ISerializationContext context, ExprSubclause semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns EBooleanLiteral
	 *     OrExpression returns EBooleanLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns EBooleanLiteral
	 *     AndExpression returns EBooleanLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns EBooleanLiteral
	 *     EqualityExpression returns EBooleanLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns EBooleanLiteral
	 *     RelationalExpression returns EBooleanLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns EBooleanLiteral
	 *     AdditiveExpression returns EBooleanLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns EBooleanLiteral
	 *     MultiplicativeExpression returns EBooleanLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns EBooleanLiteral
	 *     UnaryOperation returns EBooleanLiteral
	 *     UnitExpression returns EBooleanLiteral
	 *     UnitExpression.UnitExpression_1_0 returns EBooleanLiteral
	 *     PropertyExpression returns EBooleanLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns EBooleanLiteral
	 *     SelectExpression returns EBooleanLiteral
	 *     SelectExpression.Selection_1_0_0 returns EBooleanLiteral
	 *     PrimaryExpression returns EBooleanLiteral
	 *     Literal returns EBooleanLiteral
	 *     Value returns EBooleanLiteral
	 *     EBooleanLiteral returns EBooleanLiteral
	 *
	 * Constraint:
	 *     value?='true'?
	 */
	protected void sequence_EBooleanLiteral(ISerializationContext context, EBooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns EIntegerLiteral
	 *     OrExpression returns EIntegerLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns EIntegerLiteral
	 *     AndExpression returns EIntegerLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns EIntegerLiteral
	 *     EqualityExpression returns EIntegerLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns EIntegerLiteral
	 *     RelationalExpression returns EIntegerLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns EIntegerLiteral
	 *     AdditiveExpression returns EIntegerLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns EIntegerLiteral
	 *     MultiplicativeExpression returns EIntegerLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns EIntegerLiteral
	 *     UnaryOperation returns EIntegerLiteral
	 *     UnitExpression returns EIntegerLiteral
	 *     UnitExpression.UnitExpression_1_0 returns EIntegerLiteral
	 *     PropertyExpression returns EIntegerLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns EIntegerLiteral
	 *     SelectExpression returns EIntegerLiteral
	 *     SelectExpression.Selection_1_0_0 returns EIntegerLiteral
	 *     PrimaryExpression returns EIntegerLiteral
	 *     Literal returns EIntegerLiteral
	 *     Value returns EIntegerLiteral
	 *     NumberLiteral returns EIntegerLiteral
	 *     EIntegerLiteral returns EIntegerLiteral
	 *
	 * Constraint:
	 *     value=INTVALUE
	 */
	protected void sequence_EIntegerLiteral(ISerializationContext context, EIntegerLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.EINTEGER_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.EINTEGER_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEIntegerLiteralAccess().getValueINTVALUEParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Type returns EInteger
	 *     PrimitiveType returns EInteger
	 *     ENumberType returns EInteger
	 *     EInteger returns EInteger
	 *
	 * Constraint:
	 *     {EInteger}
	 */
	protected void sequence_EInteger(ISerializationContext context, EInteger semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ERealLiteral
	 *     OrExpression returns ERealLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns ERealLiteral
	 *     AndExpression returns ERealLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns ERealLiteral
	 *     EqualityExpression returns ERealLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns ERealLiteral
	 *     RelationalExpression returns ERealLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns ERealLiteral
	 *     AdditiveExpression returns ERealLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns ERealLiteral
	 *     MultiplicativeExpression returns ERealLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns ERealLiteral
	 *     UnaryOperation returns ERealLiteral
	 *     UnitExpression returns ERealLiteral
	 *     UnitExpression.UnitExpression_1_0 returns ERealLiteral
	 *     PropertyExpression returns ERealLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns ERealLiteral
	 *     SelectExpression returns ERealLiteral
	 *     SelectExpression.Selection_1_0_0 returns ERealLiteral
	 *     PrimaryExpression returns ERealLiteral
	 *     Literal returns ERealLiteral
	 *     Value returns ERealLiteral
	 *     NumberLiteral returns ERealLiteral
	 *     ERealLiteral returns ERealLiteral
	 *
	 * Constraint:
	 *     value=SignedReal
	 */
	protected void sequence_ERealLiteral(ISerializationContext context, ERealLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.EREAL_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.EREAL_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getERealLiteralAccess().getValueSignedRealParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Type returns EReal
	 *     PrimitiveType returns EReal
	 *     ENumberType returns EReal
	 *     EReal returns EReal
	 *
	 * Constraint:
	 *     {EReal}
	 */
	protected void sequence_EReal(ISerializationContext context, EReal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns EStringLiteral
	 *     OrExpression returns EStringLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns EStringLiteral
	 *     AndExpression returns EStringLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns EStringLiteral
	 *     EqualityExpression returns EStringLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns EStringLiteral
	 *     RelationalExpression returns EStringLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns EStringLiteral
	 *     AdditiveExpression returns EStringLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns EStringLiteral
	 *     MultiplicativeExpression returns EStringLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns EStringLiteral
	 *     UnaryOperation returns EStringLiteral
	 *     UnitExpression returns EStringLiteral
	 *     UnitExpression.UnitExpression_1_0 returns EStringLiteral
	 *     PropertyExpression returns EStringLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns EStringLiteral
	 *     SelectExpression returns EStringLiteral
	 *     SelectExpression.Selection_1_0_0 returns EStringLiteral
	 *     PrimaryExpression returns EStringLiteral
	 *     Literal returns EStringLiteral
	 *     Value returns EStringLiteral
	 *     EStringLiteral returns EStringLiteral
	 *
	 * Constraint:
	 *     value=NoQuoteString
	 */
	protected void sequence_EStringLiteral(ISerializationContext context, EStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.ESTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.ESTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEStringLiteralAccess().getValueNoQuoteStringParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     EnumLiteral returns EnumLiteral
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_EnumLiteral(ISerializationContext context, EnumLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.ENUM_LITERAL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.ENUM_LITERAL__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Type returns EnumType
	 *     EnumType returns EnumType
	 *
	 * Constraint:
	 *     (literals+=EnumLiteral literals+=EnumLiteral*)?
	 */
	protected void sequence_EnumType(ISerializationContext context, EnumType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ExprModel returns ExprModel
	 *
	 * Constraint:
	 *     (annex=ExprLibrary | annex=ExprSubclause)
	 */
	protected void sequence_ExprModel(ISerializationContext context, ExprModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ListLiteral
	 *     OrExpression returns ListLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns ListLiteral
	 *     AndExpression returns ListLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns ListLiteral
	 *     EqualityExpression returns ListLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns ListLiteral
	 *     RelationalExpression returns ListLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns ListLiteral
	 *     AdditiveExpression returns ListLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns ListLiteral
	 *     MultiplicativeExpression returns ListLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns ListLiteral
	 *     UnaryOperation returns ListLiteral
	 *     UnitExpression returns ListLiteral
	 *     UnitExpression.UnitExpression_1_0 returns ListLiteral
	 *     PropertyExpression returns ListLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns ListLiteral
	 *     SelectExpression returns ListLiteral
	 *     SelectExpression.Selection_1_0_0 returns ListLiteral
	 *     PrimaryExpression returns ListLiteral
	 *     Literal returns ListLiteral
	 *     Value returns ListLiteral
	 *     ListLiteral returns ListLiteral
	 *
	 * Constraint:
	 *     (elements+=Expression elements+=Expression*)?
	 */
	protected void sequence_ExpressionList_ListLiteral(ISerializationContext context, ListLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns SetLiteral
	 *     OrExpression returns SetLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns SetLiteral
	 *     AndExpression returns SetLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns SetLiteral
	 *     EqualityExpression returns SetLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns SetLiteral
	 *     RelationalExpression returns SetLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns SetLiteral
	 *     AdditiveExpression returns SetLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns SetLiteral
	 *     MultiplicativeExpression returns SetLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns SetLiteral
	 *     UnaryOperation returns SetLiteral
	 *     UnitExpression returns SetLiteral
	 *     UnitExpression.UnitExpression_1_0 returns SetLiteral
	 *     PropertyExpression returns SetLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns SetLiteral
	 *     SelectExpression returns SetLiteral
	 *     SelectExpression.Selection_1_0_0 returns SetLiteral
	 *     PrimaryExpression returns SetLiteral
	 *     Literal returns SetLiteral
	 *     Value returns SetLiteral
	 *     SetLiteral returns SetLiteral
	 *
	 * Constraint:
	 *     (elements+=Expression elements+=Expression*)?
	 */
	protected void sequence_ExpressionList_SetLiteral(ISerializationContext context, SetLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns TupleLiteral
	 *     OrExpression returns TupleLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns TupleLiteral
	 *     AndExpression returns TupleLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns TupleLiteral
	 *     EqualityExpression returns TupleLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns TupleLiteral
	 *     RelationalExpression returns TupleLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns TupleLiteral
	 *     AdditiveExpression returns TupleLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns TupleLiteral
	 *     MultiplicativeExpression returns TupleLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns TupleLiteral
	 *     UnaryOperation returns TupleLiteral
	 *     UnitExpression returns TupleLiteral
	 *     UnitExpression.UnitExpression_1_0 returns TupleLiteral
	 *     PropertyExpression returns TupleLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns TupleLiteral
	 *     SelectExpression returns TupleLiteral
	 *     SelectExpression.Selection_1_0_0 returns TupleLiteral
	 *     PrimaryExpression returns TupleLiteral
	 *     Literal returns TupleLiteral
	 *     Value returns TupleLiteral
	 *     TupleLiteral returns TupleLiteral
	 *
	 * Constraint:
	 *     (elements+=Expression elements+=Expression*)?
	 */
	protected void sequence_ExpressionList_TupleLiteral(ISerializationContext context, TupleLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FieldValue returns FieldValue
	 *
	 * Constraint:
	 *     (name=ID value=Expression)
	 */
	protected void sequence_FieldValue(ISerializationContext context, FieldValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.FIELD_VALUE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.FIELD_VALUE__NAME));
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.FIELD_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.FIELD_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFieldValueAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFieldValueAccess().getValueExpressionParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns Field
	 *     Field returns Field
	 *
	 * Constraint:
	 *     (name=ID type=Type)
	 */
	protected void sequence_Field(ISerializationContext context, Field semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Aadl2Package.eINSTANCE.getNamedElement_Name()));
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.FIELD__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.FIELD__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_3_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Conditional
	 *     OrExpression returns Conditional
	 *     OrExpression.BinaryOperation_1_0_0_0 returns Conditional
	 *     AndExpression returns Conditional
	 *     AndExpression.BinaryOperation_1_0_0_0 returns Conditional
	 *     EqualityExpression returns Conditional
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns Conditional
	 *     RelationalExpression returns Conditional
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns Conditional
	 *     AdditiveExpression returns Conditional
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns Conditional
	 *     MultiplicativeExpression returns Conditional
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns Conditional
	 *     UnaryOperation returns Conditional
	 *     UnitExpression returns Conditional
	 *     UnitExpression.UnitExpression_1_0 returns Conditional
	 *     PropertyExpression returns Conditional
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns Conditional
	 *     SelectExpression returns Conditional
	 *     SelectExpression.Selection_1_0_0 returns Conditional
	 *     PrimaryExpression returns Conditional
	 *     IfExpression returns Conditional
	 *
	 * Constraint:
	 *     (if=Expression then=Expression else=Expression?)
	 */
	protected void sequence_IfExpression(ISerializationContext context, Conditional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns ListType
	 *     ListType returns ListType
	 *
	 * Constraint:
	 *     type=Type
	 */
	protected void sequence_ListType(ISerializationContext context, ListType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.LIST_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.LIST_TYPE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns MapLiteral
	 *     OrExpression returns MapLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns MapLiteral
	 *     AndExpression returns MapLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns MapLiteral
	 *     EqualityExpression returns MapLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns MapLiteral
	 *     RelationalExpression returns MapLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns MapLiteral
	 *     AdditiveExpression returns MapLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns MapLiteral
	 *     MultiplicativeExpression returns MapLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns MapLiteral
	 *     UnaryOperation returns MapLiteral
	 *     UnitExpression returns MapLiteral
	 *     UnitExpression.UnitExpression_1_0 returns MapLiteral
	 *     PropertyExpression returns MapLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns MapLiteral
	 *     SelectExpression returns MapLiteral
	 *     SelectExpression.Selection_1_0_0 returns MapLiteral
	 *     PrimaryExpression returns MapLiteral
	 *     Literal returns MapLiteral
	 *     Value returns MapLiteral
	 *     MapLiteral returns MapLiteral
	 *
	 * Constraint:
	 *     {MapLiteral}
	 */
	protected void sequence_MapLiteral(ISerializationContext context, MapLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns MapType
	 *     MapType returns MapType
	 *
	 * Constraint:
	 *     (domain=Type image=Type)
	 */
	protected void sequence_MapType(ISerializationContext context, MapType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.MAP_TYPE__DOMAIN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.MAP_TYPE__DOMAIN));
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.MAP_TYPE__IMAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.MAP_TYPE__IMAGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMapTypeAccess().getDomainTypeParserRuleCall_1_0(), semanticObject.getDomain());
		feeder.accept(grammarAccess.getMapTypeAccess().getImageTypeParserRuleCall_3_0(), semanticObject.getImage());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Type returns MetaClass
	 *     MetaClass returns MetaClass
	 *
	 * Constraint:
	 *     class=MetaClassEnum
	 */
	protected void sequence_MetaClass(ISerializationContext context, MetaClass semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.META_CLASS__CLASS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.META_CLASS__CLASS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMetaClassAccess().getClassMetaClassEnumEnumRuleCall_0(), semanticObject.getClass_());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns NamedElementRef
	 *     OrExpression returns NamedElementRef
	 *     OrExpression.BinaryOperation_1_0_0_0 returns NamedElementRef
	 *     AndExpression returns NamedElementRef
	 *     AndExpression.BinaryOperation_1_0_0_0 returns NamedElementRef
	 *     EqualityExpression returns NamedElementRef
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns NamedElementRef
	 *     RelationalExpression returns NamedElementRef
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns NamedElementRef
	 *     AdditiveExpression returns NamedElementRef
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns NamedElementRef
	 *     MultiplicativeExpression returns NamedElementRef
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns NamedElementRef
	 *     UnaryOperation returns NamedElementRef
	 *     UnitExpression returns NamedElementRef
	 *     UnitExpression.UnitExpression_1_0 returns NamedElementRef
	 *     PropertyExpression returns NamedElementRef
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns NamedElementRef
	 *     SelectExpression returns NamedElementRef
	 *     SelectExpression.Selection_1_0_0 returns NamedElementRef
	 *     PrimaryExpression returns NamedElementRef
	 *     NamedElementRef returns NamedElementRef
	 *
	 * Constraint:
	 *     (core?='^'? ref=[NamedElement|QCREF] (args+=Expression args+=Expression*)?)
	 */
	protected void sequence_NamedElementRef(ISerializationContext context, NamedElementRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns EBoolean
	 *     PrimitiveType returns EBoolean
	 *
	 * Constraint:
	 *     {EBoolean}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, EBoolean semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns EString
	 *     PrimitiveType returns EString
	 *
	 * Constraint:
	 *     {EString}
	 */
	protected void sequence_PrimitiveType(ISerializationContext context, EString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns PropertyExpression
	 *     OrExpression returns PropertyExpression
	 *     OrExpression.BinaryOperation_1_0_0_0 returns PropertyExpression
	 *     AndExpression returns PropertyExpression
	 *     AndExpression.BinaryOperation_1_0_0_0 returns PropertyExpression
	 *     EqualityExpression returns PropertyExpression
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns PropertyExpression
	 *     RelationalExpression returns PropertyExpression
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns PropertyExpression
	 *     AdditiveExpression returns PropertyExpression
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns PropertyExpression
	 *     MultiplicativeExpression returns PropertyExpression
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns PropertyExpression
	 *     UnaryOperation returns PropertyExpression
	 *     UnitExpression returns PropertyExpression
	 *     UnitExpression.UnitExpression_1_0 returns PropertyExpression
	 *     PropertyExpression returns PropertyExpression
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns PropertyExpression
	 *     SelectExpression returns PropertyExpression
	 *     SelectExpression.Selection_1_0_0 returns PropertyExpression
	 *     PrimaryExpression returns PropertyExpression
	 *
	 * Constraint:
	 *     (modelElement=PropertyExpression_PropertyExpression_1_0_0_0 property=[AbstractNamedValue|QPREF])
	 */
	protected void sequence_PropertyExpression(ISerializationContext context, PropertyExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.PROPERTY_EXPRESSION__MODEL_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.PROPERTY_EXPRESSION__MODEL_ELEMENT));
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.PROPERTY_EXPRESSION__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.PROPERTY_EXPRESSION__PROPERTY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPropertyExpressionAccess().getPropertyExpressionModelElementAction_1_0_0_0(), semanticObject.getModelElement());
		feeder.accept(grammarAccess.getPropertyExpressionAccess().getPropertyAbstractNamedValueQPREFParserRuleCall_1_1_0_1(), semanticObject.eGet(ExprPackage.Literals.PROPERTY_EXPRESSION__PROPERTY, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Range
	 *     OrExpression returns Range
	 *     OrExpression.BinaryOperation_1_0_0_0 returns Range
	 *     AndExpression returns Range
	 *     AndExpression.BinaryOperation_1_0_0_0 returns Range
	 *     EqualityExpression returns Range
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns Range
	 *     RelationalExpression returns Range
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns Range
	 *     AdditiveExpression returns Range
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns Range
	 *     MultiplicativeExpression returns Range
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns Range
	 *     UnaryOperation returns Range
	 *     UnitExpression returns Range
	 *     UnitExpression.UnitExpression_1_0 returns Range
	 *     PropertyExpression returns Range
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns Range
	 *     SelectExpression returns Range
	 *     SelectExpression.Selection_1_0_0 returns Range
	 *     PrimaryExpression returns Range
	 *     RangeExpression returns Range
	 *
	 * Constraint:
	 *     (minimum=Expression maximum=Expression delta=Expression?)
	 */
	protected void sequence_RangeExpression(ISerializationContext context, Range semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns RangeType
	 *     RangeType returns RangeType
	 *
	 * Constraint:
	 *     type=Type
	 */
	protected void sequence_RangeType(ISerializationContext context, RangeType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.RANGE_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.RANGE_TYPE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRangeTypeAccess().getTypeTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns RecordLiteral
	 *     OrExpression returns RecordLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns RecordLiteral
	 *     AndExpression returns RecordLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns RecordLiteral
	 *     EqualityExpression returns RecordLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns RecordLiteral
	 *     RelationalExpression returns RecordLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns RecordLiteral
	 *     AdditiveExpression returns RecordLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns RecordLiteral
	 *     MultiplicativeExpression returns RecordLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns RecordLiteral
	 *     UnaryOperation returns RecordLiteral
	 *     UnitExpression returns RecordLiteral
	 *     UnitExpression.UnitExpression_1_0 returns RecordLiteral
	 *     PropertyExpression returns RecordLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns RecordLiteral
	 *     SelectExpression returns RecordLiteral
	 *     SelectExpression.Selection_1_0_0 returns RecordLiteral
	 *     PrimaryExpression returns RecordLiteral
	 *     Literal returns RecordLiteral
	 *     Value returns RecordLiteral
	 *     RecordLiteral returns RecordLiteral
	 *
	 * Constraint:
	 *     (fieldValues+=FieldValue fieldValues+=FieldValue*)?
	 */
	protected void sequence_RecordLiteral(ISerializationContext context, RecordLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns RecordType
	 *     RecordType returns RecordType
	 *
	 * Constraint:
	 *     (fields+=Field fields+=Field*)?
	 */
	protected void sequence_RecordType(ISerializationContext context, RecordType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Selection
	 *     OrExpression returns Selection
	 *     OrExpression.BinaryOperation_1_0_0_0 returns Selection
	 *     AndExpression returns Selection
	 *     AndExpression.BinaryOperation_1_0_0_0 returns Selection
	 *     EqualityExpression returns Selection
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns Selection
	 *     RelationalExpression returns Selection
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns Selection
	 *     AdditiveExpression returns Selection
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns Selection
	 *     MultiplicativeExpression returns Selection
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns Selection
	 *     UnaryOperation returns Selection
	 *     UnitExpression returns Selection
	 *     UnitExpression.UnitExpression_1_0 returns Selection
	 *     PropertyExpression returns Selection
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns Selection
	 *     SelectExpression returns Selection
	 *     SelectExpression.Selection_1_0_0 returns Selection
	 *     PrimaryExpression returns Selection
	 *
	 * Constraint:
	 *     (receiver=SelectExpression_Selection_1_0_0 ref=[NamedElement|QCREF] (args+=Expression args+=Expression*)?)
	 */
	protected void sequence_SelectExpression(ISerializationContext context, Selection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns SetType
	 *     SetType returns SetType
	 *
	 * Constraint:
	 *     type=Type
	 */
	protected void sequence_SetType(ISerializationContext context, SetType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.SET_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.SET_TYPE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSetTypeAccess().getTypeTypeParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TupleField returns Field
	 *
	 * Constraint:
	 *     type=Type
	 */
	protected void sequence_TupleField(ISerializationContext context, Field semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.FIELD__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.FIELD__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Type returns TupleType
	 *     TupleType returns TupleType
	 *
	 * Constraint:
	 *     (fields+=TupleField fields+=TupleField*)?
	 */
	protected void sequence_TupleType(ISerializationContext context, TupleType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns TypeDecl
	 *     EDeclaration returns TypeDecl
	 *     TypeDecl returns TypeDecl
	 *
	 * Constraint:
	 *     (name=ID type=Type (ownedPropertyAssociations+=PropertyAssociation ownedPropertyAssociations+=PropertyAssociation*)?)
	 */
	protected void sequence_TypeDecl(ISerializationContext context, TypeDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Type returns TypeRef
	 *     TypeRef returns TypeRef
	 *
	 * Constraint:
	 *     ref=[NamedElement|QCREF]
	 */
	protected void sequence_TypeRef(ISerializationContext context, TypeRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.TYPE_REF__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.TYPE_REF__REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeRefAccess().getRefNamedElementQCREFParserRuleCall_0_1(), semanticObject.eGet(ExprPackage.Literals.TYPE_REF__REF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns UnaryOperation
	 *     OrExpression returns UnaryOperation
	 *     OrExpression.BinaryOperation_1_0_0_0 returns UnaryOperation
	 *     AndExpression returns UnaryOperation
	 *     AndExpression.BinaryOperation_1_0_0_0 returns UnaryOperation
	 *     EqualityExpression returns UnaryOperation
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns UnaryOperation
	 *     RelationalExpression returns UnaryOperation
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns UnaryOperation
	 *     AdditiveExpression returns UnaryOperation
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns UnaryOperation
	 *     MultiplicativeExpression returns UnaryOperation
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns UnaryOperation
	 *     UnaryOperation returns UnaryOperation
	 *     UnitExpression returns UnaryOperation
	 *     UnitExpression.UnitExpression_1_0 returns UnaryOperation
	 *     PropertyExpression returns UnaryOperation
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns UnaryOperation
	 *     SelectExpression returns UnaryOperation
	 *     SelectExpression.Selection_1_0_0 returns UnaryOperation
	 *     PrimaryExpression returns UnaryOperation
	 *
	 * Constraint:
	 *     (operator=OpUnary operand=UnitExpression)
	 */
	protected void sequence_UnaryOperation(ISerializationContext context, UnaryOperation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.UNARY_OPERATION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.UNARY_OPERATION__OPERATOR));
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.UNARY_OPERATION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.UNARY_OPERATION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getUnaryOperationAccess().getOperandUnitExpressionParserRuleCall_0_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns UnionLiteral
	 *     OrExpression returns UnionLiteral
	 *     OrExpression.BinaryOperation_1_0_0_0 returns UnionLiteral
	 *     AndExpression returns UnionLiteral
	 *     AndExpression.BinaryOperation_1_0_0_0 returns UnionLiteral
	 *     EqualityExpression returns UnionLiteral
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns UnionLiteral
	 *     RelationalExpression returns UnionLiteral
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns UnionLiteral
	 *     AdditiveExpression returns UnionLiteral
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns UnionLiteral
	 *     MultiplicativeExpression returns UnionLiteral
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns UnionLiteral
	 *     UnaryOperation returns UnionLiteral
	 *     UnitExpression returns UnionLiteral
	 *     UnitExpression.UnitExpression_1_0 returns UnionLiteral
	 *     PropertyExpression returns UnionLiteral
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns UnionLiteral
	 *     SelectExpression returns UnionLiteral
	 *     SelectExpression.Selection_1_0_0 returns UnionLiteral
	 *     PrimaryExpression returns UnionLiteral
	 *     Literal returns UnionLiteral
	 *     Value returns UnionLiteral
	 *     UnionLiteral returns UnionLiteral
	 *
	 * Constraint:
	 *     fieldValue=FieldValue
	 */
	protected void sequence_UnionLiteral(ISerializationContext context, UnionLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.UNION_LITERAL__FIELD_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.UNION_LITERAL__FIELD_VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnionLiteralAccess().getFieldValueFieldValueParserRuleCall_3_0(), semanticObject.getFieldValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Type returns UnionType
	 *     UnionType returns UnionType
	 *
	 * Constraint:
	 *     (fields+=Field fields+=Field*)?
	 */
	protected void sequence_UnionType(ISerializationContext context, UnionType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns UnitExpression
	 *     OrExpression returns UnitExpression
	 *     OrExpression.BinaryOperation_1_0_0_0 returns UnitExpression
	 *     AndExpression returns UnitExpression
	 *     AndExpression.BinaryOperation_1_0_0_0 returns UnitExpression
	 *     EqualityExpression returns UnitExpression
	 *     EqualityExpression.BinaryOperation_1_0_0_0 returns UnitExpression
	 *     RelationalExpression returns UnitExpression
	 *     RelationalExpression.BinaryOperation_1_0_0_0 returns UnitExpression
	 *     AdditiveExpression returns UnitExpression
	 *     AdditiveExpression.BinaryOperation_1_0_0_0 returns UnitExpression
	 *     MultiplicativeExpression returns UnitExpression
	 *     MultiplicativeExpression.BinaryOperation_1_0_0_0 returns UnitExpression
	 *     UnaryOperation returns UnitExpression
	 *     UnitExpression returns UnitExpression
	 *     UnitExpression.UnitExpression_1_0 returns UnitExpression
	 *     PropertyExpression returns UnitExpression
	 *     PropertyExpression.PropertyExpression_1_0_0_0 returns UnitExpression
	 *     SelectExpression returns UnitExpression
	 *     SelectExpression.Selection_1_0_0 returns UnitExpression
	 *     PrimaryExpression returns UnitExpression
	 *
	 * Constraint:
	 *     (expression=UnitExpression_UnitExpression_1_0 (convert?='%' | drop?='in')? unit=[UnitLiteral|ID])
	 */
	protected void sequence_UnitExpression(ISerializationContext context, UnitExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamedElement returns VarDecl
	 *     EDeclaration returns VarDecl
	 *     VarDecl returns VarDecl
	 *
	 * Constraint:
	 *     (const?='val'? name=ID declType=Type? value=Expression?)
	 */
	protected void sequence_VarDecl(ISerializationContext context, VarDecl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Value returns WrappedNamedElement
	 *     WrappedNamedElement returns WrappedNamedElement
	 *
	 * Constraint:
	 *     elem=[NamedElement|ID]
	 */
	protected void sequence_WrappedNamedElement(ISerializationContext context, WrappedNamedElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ExprPackage.Literals.WRAPPED_NAMED_ELEMENT__ELEM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExprPackage.Literals.WRAPPED_NAMED_ELEMENT__ELEM));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getWrappedNamedElementAccess().getElemNamedElementIDTerminalRuleCall_1_0_1(), semanticObject.eGet(ExprPackage.Literals.WRAPPED_NAMED_ELEMENT__ELEM, false));
		feeder.finish();
	}
	
	
}
