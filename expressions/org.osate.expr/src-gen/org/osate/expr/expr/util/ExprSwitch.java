/**
 * *
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *  *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *  *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *  *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *  *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.expr.expr.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Type;

import org.osate.expr.expr.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.expr.expr.ExprPackage
 * @generated
 */
public class ExprSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ExprPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ExprPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ExprPackage.EXPR_MODEL:
      {
        ExprModel exprModel = (ExprModel)theEObject;
        T result = caseExprModel(exprModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EDECLARATION:
      {
        EDeclaration eDeclaration = (EDeclaration)theEObject;
        T result = caseEDeclaration(eDeclaration);
        if (result == null) result = caseNamedElement(eDeclaration);
        if (result == null) result = caseElement(eDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.TYPE_DECL:
      {
        TypeDecl typeDecl = (TypeDecl)theEObject;
        T result = caseTypeDecl(typeDecl);
        if (result == null) result = caseEDeclaration(typeDecl);
        if (result == null) result = caseNamedElement(typeDecl);
        if (result == null) result = caseElement(typeDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.VAR_DECL:
      {
        VarDecl varDecl = (VarDecl)theEObject;
        T result = caseVarDecl(varDecl);
        if (result == null) result = caseEDeclaration(varDecl);
        if (result == null) result = caseNamedElement(varDecl);
        if (result == null) result = caseElement(varDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.FUN_DECL:
      {
        FunDecl funDecl = (FunDecl)theEObject;
        T result = caseFunDecl(funDecl);
        if (result == null) result = caseEDeclaration(funDecl);
        if (result == null) result = caseNamedElement(funDecl);
        if (result == null) result = caseElement(funDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.ARGUMENT:
      {
        Argument argument = (Argument)theEObject;
        T result = caseArgument(argument);
        if (result == null) result = caseNamedElement(argument);
        if (result == null) result = caseElement(argument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.ASSERTION:
      {
        Assertion assertion = (Assertion)theEObject;
        T result = caseAssertion(assertion);
        if (result == null) result = caseEDeclaration(assertion);
        if (result == null) result = caseNamedElement(assertion);
        if (result == null) result = caseElement(assertion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.ENUMBER_TYPE:
      {
        ENumberType eNumberType = (ENumberType)theEObject;
        T result = caseENumberType(eNumberType);
        if (result == null) result = caseType(eNumberType);
        if (result == null) result = caseNamedElement(eNumberType);
        if (result == null) result = caseElement(eNumberType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EINTEGER:
      {
        EInteger eInteger = (EInteger)theEObject;
        T result = caseEInteger(eInteger);
        if (result == null) result = caseENumberType(eInteger);
        if (result == null) result = caseType(eInteger);
        if (result == null) result = caseNamedElement(eInteger);
        if (result == null) result = caseElement(eInteger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EREAL:
      {
        EReal eReal = (EReal)theEObject;
        T result = caseEReal(eReal);
        if (result == null) result = caseENumberType(eReal);
        if (result == null) result = caseType(eReal);
        if (result == null) result = caseNamedElement(eReal);
        if (result == null) result = caseElement(eReal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.RANGE_TYPE:
      {
        RangeType rangeType = (RangeType)theEObject;
        T result = caseRangeType(rangeType);
        if (result == null) result = caseType(rangeType);
        if (result == null) result = caseNamedElement(rangeType);
        if (result == null) result = caseElement(rangeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.CATEGORY:
      {
        Category category = (Category)theEObject;
        T result = caseCategory(category);
        if (result == null) result = caseType(category);
        if (result == null) result = caseNamedElement(category);
        if (result == null) result = caseElement(category);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.META_CLASS:
      {
        MetaClass metaClass = (MetaClass)theEObject;
        T result = caseMetaClass(metaClass);
        if (result == null) result = caseType(metaClass);
        if (result == null) result = caseNamedElement(metaClass);
        if (result == null) result = caseElement(metaClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.RECORD_TYPE:
      {
        RecordType recordType = (RecordType)theEObject;
        T result = caseRecordType(recordType);
        if (result == null) result = caseType(recordType);
        if (result == null) result = caseNamedElement(recordType);
        if (result == null) result = caseElement(recordType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.FIELD:
      {
        Field field = (Field)theEObject;
        T result = caseField(field);
        if (result == null) result = caseNamedElement(field);
        if (result == null) result = caseElement(field);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.UNION_TYPE:
      {
        UnionType unionType = (UnionType)theEObject;
        T result = caseUnionType(unionType);
        if (result == null) result = caseType(unionType);
        if (result == null) result = caseNamedElement(unionType);
        if (result == null) result = caseElement(unionType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.TUPLE_TYPE:
      {
        TupleType tupleType = (TupleType)theEObject;
        T result = caseTupleType(tupleType);
        if (result == null) result = caseType(tupleType);
        if (result == null) result = caseNamedElement(tupleType);
        if (result == null) result = caseElement(tupleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.LIST_TYPE:
      {
        ListType listType = (ListType)theEObject;
        T result = caseListType(listType);
        if (result == null) result = caseType(listType);
        if (result == null) result = caseNamedElement(listType);
        if (result == null) result = caseElement(listType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.SET_TYPE:
      {
        SetType setType = (SetType)theEObject;
        T result = caseSetType(setType);
        if (result == null) result = caseType(setType);
        if (result == null) result = caseNamedElement(setType);
        if (result == null) result = caseElement(setType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.BAG_TYPE:
      {
        BagType bagType = (BagType)theEObject;
        T result = caseBagType(bagType);
        if (result == null) result = caseType(bagType);
        if (result == null) result = caseNamedElement(bagType);
        if (result == null) result = caseElement(bagType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.MAP_TYPE:
      {
        MapType mapType = (MapType)theEObject;
        T result = caseMapType(mapType);
        if (result == null) result = caseType(mapType);
        if (result == null) result = caseNamedElement(mapType);
        if (result == null) result = caseElement(mapType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.ENUM_TYPE:
      {
        EnumType enumType = (EnumType)theEObject;
        T result = caseEnumType(enumType);
        if (result == null) result = caseType(enumType);
        if (result == null) result = caseNamedElement(enumType);
        if (result == null) result = caseElement(enumType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.ENUM_LITERAL:
      {
        EnumLiteral enumLiteral = (EnumLiteral)theEObject;
        T result = caseEnumLiteral(enumLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.TYPE_REF:
      {
        TypeRef typeRef = (TypeRef)theEObject;
        T result = caseTypeRef(typeRef);
        if (result == null) result = caseType(typeRef);
        if (result == null) result = caseNamedElement(typeRef);
        if (result == null) result = caseElement(typeRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseAadl2_PropertyExpression(expression);
        if (result == null) result = caseElement(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.NAMED_ELEMENT_REF:
      {
        NamedElementRef namedElementRef = (NamedElementRef)theEObject;
        T result = caseNamedElementRef(namedElementRef);
        if (result == null) result = caseExpression(namedElementRef);
        if (result == null) result = caseAadl2_PropertyExpression(namedElementRef);
        if (result == null) result = caseElement(namedElementRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = caseExpression(literal);
        if (result == null) result = caseValue(literal);
        if (result == null) result = caseAadl2_PropertyExpression(literal);
        if (result == null) result = caseElement(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.VALUE:
      {
        Value value = (Value)theEObject;
        T result = caseValue(value);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.WRAPPED_NAMED_ELEMENT:
      {
        WrappedNamedElement wrappedNamedElement = (WrappedNamedElement)theEObject;
        T result = caseWrappedNamedElement(wrappedNamedElement);
        if (result == null) result = caseValue(wrappedNamedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.NUMBER_LITERAL:
      {
        NumberLiteral numberLiteral = (NumberLiteral)theEObject;
        T result = caseNumberLiteral(numberLiteral);
        if (result == null) result = caseLiteral(numberLiteral);
        if (result == null) result = caseExpression(numberLiteral);
        if (result == null) result = caseValue(numberLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(numberLiteral);
        if (result == null) result = caseElement(numberLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.FIELD_VALUE:
      {
        FieldValue fieldValue = (FieldValue)theEObject;
        T result = caseFieldValue(fieldValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EXPR_LIBRARY:
      {
        ExprLibrary exprLibrary = (ExprLibrary)theEObject;
        T result = caseExprLibrary(exprLibrary);
        if (result == null) result = caseAnnexLibrary(exprLibrary);
        if (result == null) result = caseNamedElement(exprLibrary);
        if (result == null) result = caseElement(exprLibrary);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EXPR_SUBCLAUSE:
      {
        ExprSubclause exprSubclause = (ExprSubclause)theEObject;
        T result = caseExprSubclause(exprSubclause);
        if (result == null) result = caseAnnexSubclause(exprSubclause);
        if (result == null) result = caseModalElement(exprSubclause);
        if (result == null) result = caseNamedElement(exprSubclause);
        if (result == null) result = caseElement(exprSubclause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EBOOLEAN:
      {
        EBoolean eBoolean = (EBoolean)theEObject;
        T result = caseEBoolean(eBoolean);
        if (result == null) result = caseType(eBoolean);
        if (result == null) result = caseNamedElement(eBoolean);
        if (result == null) result = caseElement(eBoolean);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.ESTRING:
      {
        EString eString = (EString)theEObject;
        T result = caseEString(eString);
        if (result == null) result = caseType(eString);
        if (result == null) result = caseNamedElement(eString);
        if (result == null) result = caseElement(eString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.BLOCK:
      {
        Block block = (Block)theEObject;
        T result = caseBlock(block);
        if (result == null) result = caseExpression(block);
        if (result == null) result = caseAadl2_PropertyExpression(block);
        if (result == null) result = caseElement(block);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.BINARY_OPERATION:
      {
        BinaryOperation binaryOperation = (BinaryOperation)theEObject;
        T result = caseBinaryOperation(binaryOperation);
        if (result == null) result = caseExpression(binaryOperation);
        if (result == null) result = caseAadl2_PropertyExpression(binaryOperation);
        if (result == null) result = caseElement(binaryOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.UNARY_OPERATION:
      {
        UnaryOperation unaryOperation = (UnaryOperation)theEObject;
        T result = caseUnaryOperation(unaryOperation);
        if (result == null) result = caseExpression(unaryOperation);
        if (result == null) result = caseAadl2_PropertyExpression(unaryOperation);
        if (result == null) result = caseElement(unaryOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.UNIT_EXPRESSION:
      {
        UnitExpression unitExpression = (UnitExpression)theEObject;
        T result = caseUnitExpression(unitExpression);
        if (result == null) result = caseExpression(unitExpression);
        if (result == null) result = caseAadl2_PropertyExpression(unitExpression);
        if (result == null) result = caseElement(unitExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.PROPERTY_EXPRESSION:
      {
        PropertyExpression propertyExpression = (PropertyExpression)theEObject;
        T result = casePropertyExpression(propertyExpression);
        if (result == null) result = caseExpression(propertyExpression);
        if (result == null) result = caseAadl2_PropertyExpression(propertyExpression);
        if (result == null) result = caseElement(propertyExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.SELECTION:
      {
        Selection selection = (Selection)theEObject;
        T result = caseSelection(selection);
        if (result == null) result = caseExpression(selection);
        if (result == null) result = caseAadl2_PropertyExpression(selection);
        if (result == null) result = caseElement(selection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.RANGE:
      {
        Range range = (Range)theEObject;
        T result = caseRange(range);
        if (result == null) result = caseExpression(range);
        if (result == null) result = caseAadl2_PropertyExpression(range);
        if (result == null) result = caseElement(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.CONDITIONAL:
      {
        Conditional conditional = (Conditional)theEObject;
        T result = caseConditional(conditional);
        if (result == null) result = caseExpression(conditional);
        if (result == null) result = caseAadl2_PropertyExpression(conditional);
        if (result == null) result = caseElement(conditional);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EBOOLEAN_LITERAL:
      {
        EBooleanLiteral eBooleanLiteral = (EBooleanLiteral)theEObject;
        T result = caseEBooleanLiteral(eBooleanLiteral);
        if (result == null) result = caseLiteral(eBooleanLiteral);
        if (result == null) result = caseExpression(eBooleanLiteral);
        if (result == null) result = caseValue(eBooleanLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(eBooleanLiteral);
        if (result == null) result = caseElement(eBooleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EINTEGER_LITERAL:
      {
        EIntegerLiteral eIntegerLiteral = (EIntegerLiteral)theEObject;
        T result = caseEIntegerLiteral(eIntegerLiteral);
        if (result == null) result = caseNumberLiteral(eIntegerLiteral);
        if (result == null) result = caseLiteral(eIntegerLiteral);
        if (result == null) result = caseExpression(eIntegerLiteral);
        if (result == null) result = caseValue(eIntegerLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(eIntegerLiteral);
        if (result == null) result = caseElement(eIntegerLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.EREAL_LITERAL:
      {
        ERealLiteral eRealLiteral = (ERealLiteral)theEObject;
        T result = caseERealLiteral(eRealLiteral);
        if (result == null) result = caseNumberLiteral(eRealLiteral);
        if (result == null) result = caseLiteral(eRealLiteral);
        if (result == null) result = caseExpression(eRealLiteral);
        if (result == null) result = caseValue(eRealLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(eRealLiteral);
        if (result == null) result = caseElement(eRealLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.ESTRING_LITERAL:
      {
        EStringLiteral eStringLiteral = (EStringLiteral)theEObject;
        T result = caseEStringLiteral(eStringLiteral);
        if (result == null) result = caseLiteral(eStringLiteral);
        if (result == null) result = caseExpression(eStringLiteral);
        if (result == null) result = caseValue(eStringLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(eStringLiteral);
        if (result == null) result = caseElement(eStringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.LIST_LITERAL:
      {
        ListLiteral listLiteral = (ListLiteral)theEObject;
        T result = caseListLiteral(listLiteral);
        if (result == null) result = caseLiteral(listLiteral);
        if (result == null) result = caseExpression(listLiteral);
        if (result == null) result = caseValue(listLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(listLiteral);
        if (result == null) result = caseElement(listLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.SET_LITERAL:
      {
        SetLiteral setLiteral = (SetLiteral)theEObject;
        T result = caseSetLiteral(setLiteral);
        if (result == null) result = caseLiteral(setLiteral);
        if (result == null) result = caseExpression(setLiteral);
        if (result == null) result = caseValue(setLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(setLiteral);
        if (result == null) result = caseElement(setLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.RECORD_LITERAL:
      {
        RecordLiteral recordLiteral = (RecordLiteral)theEObject;
        T result = caseRecordLiteral(recordLiteral);
        if (result == null) result = caseLiteral(recordLiteral);
        if (result == null) result = caseExpression(recordLiteral);
        if (result == null) result = caseValue(recordLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(recordLiteral);
        if (result == null) result = caseElement(recordLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.UNION_LITERAL:
      {
        UnionLiteral unionLiteral = (UnionLiteral)theEObject;
        T result = caseUnionLiteral(unionLiteral);
        if (result == null) result = caseLiteral(unionLiteral);
        if (result == null) result = caseExpression(unionLiteral);
        if (result == null) result = caseValue(unionLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(unionLiteral);
        if (result == null) result = caseElement(unionLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.TUPLE_LITERAL:
      {
        TupleLiteral tupleLiteral = (TupleLiteral)theEObject;
        T result = caseTupleLiteral(tupleLiteral);
        if (result == null) result = caseLiteral(tupleLiteral);
        if (result == null) result = caseExpression(tupleLiteral);
        if (result == null) result = caseValue(tupleLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(tupleLiteral);
        if (result == null) result = caseElement(tupleLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.BAG_LITERAL:
      {
        BagLiteral bagLiteral = (BagLiteral)theEObject;
        T result = caseBagLiteral(bagLiteral);
        if (result == null) result = caseLiteral(bagLiteral);
        if (result == null) result = caseExpression(bagLiteral);
        if (result == null) result = caseValue(bagLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(bagLiteral);
        if (result == null) result = caseElement(bagLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExprPackage.MAP_LITERAL:
      {
        MapLiteral mapLiteral = (MapLiteral)theEObject;
        T result = caseMapLiteral(mapLiteral);
        if (result == null) result = caseLiteral(mapLiteral);
        if (result == null) result = caseExpression(mapLiteral);
        if (result == null) result = caseValue(mapLiteral);
        if (result == null) result = caseAadl2_PropertyExpression(mapLiteral);
        if (result == null) result = caseElement(mapLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExprModel(ExprModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EDeclaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EDeclaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEDeclaration(EDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeDecl(TypeDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarDecl(VarDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fun Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fun Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunDecl(FunDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Argument</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Argument</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgument(Argument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assertion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assertion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssertion(Assertion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ENumber Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ENumber Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseENumberType(ENumberType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EInteger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EInteger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEInteger(EInteger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EReal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EReal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEReal(EReal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRangeType(RangeType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCategory(Category object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Meta Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Meta Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMetaClass(MetaClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordType(RecordType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseField(Field object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Union Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Union Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnionType(UnionType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleType(TupleType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListType(ListType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSetType(SetType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBagType(BagType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Map Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Map Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapType(MapType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumType(EnumType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumLiteral(EnumLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeRef(TypeRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElementRef(NamedElementRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteral(Literal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValue(Value object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Wrapped Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Wrapped Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWrappedNamedElement(WrappedNamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberLiteral(NumberLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFieldValue(FieldValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Library</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExprLibrary(ExprLibrary object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subclause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subclause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExprSubclause(ExprSubclause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EBoolean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EBoolean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEBoolean(EBoolean object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EString</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EString</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEString(EString object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlock(Block object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryOperation(BinaryOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryOperation(UnaryOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitExpression(UnitExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyExpression(PropertyExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelection(Selection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRange(Range object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditional(Conditional object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EBoolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EBoolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEBooleanLiteral(EBooleanLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EInteger Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EInteger Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEIntegerLiteral(EIntegerLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EReal Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EReal Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseERealLiteral(ERealLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EString Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EString Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEStringLiteral(EStringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListLiteral(ListLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Set Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Set Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSetLiteral(SetLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordLiteral(RecordLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Union Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Union Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnionLiteral(UnionLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleLiteral(TupleLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bag Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bag Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBagLiteral(BagLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Map Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Map Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapLiteral(MapLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAadl2_PropertyExpression(org.osate.aadl2.PropertyExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annex Library</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annex Library</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnexLibrary(AnnexLibrary object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Modal Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Modal Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModalElement(ModalElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annex Subclause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annex Subclause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnexSubclause(AnnexSubclause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ExprSwitch
