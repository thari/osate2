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
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.osate.expr.services.ExprGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractExprSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ExprGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Declarations_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_NamedElementRef___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_4_0_a;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_4_0_p;
	protected AbstractElementAlias match_SelectExpression___LeftParenthesisKeyword_1_0_3_0_RightParenthesisKeyword_1_0_3_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ExprGrammarAccess) access;
		match_Declarations_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getDeclarationsAccess().getSemicolonKeyword_2());
		match_NamedElementRef___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getNamedElementRefAccess().getLeftParenthesisKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getNamedElementRefAccess().getRightParenthesisKeyword_2_2()));
		match_PrimaryExpression_LeftParenthesisKeyword_4_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
		match_PrimaryExpression_LeftParenthesisKeyword_4_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
		match_SelectExpression___LeftParenthesisKeyword_1_0_3_0_RightParenthesisKeyword_1_0_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSelectExpressionAccess().getLeftParenthesisKeyword_1_0_3_0()), new TokenAlias(false, false, grammarAccess.getSelectExpressionAccess().getRightParenthesisKeyword_1_0_3_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getAppliesToKeywordsRule())
			return getAppliesToKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInBindingKeywordsRule())
			return getInBindingKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInModesKeywordsRule())
			return getInModesKeywordsToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * AppliesToKeywords:
	 * 	'applies' 'to'
	 * ;
	 */
	protected String getAppliesToKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "applies to";
	}
	
	/**
	 * InBindingKeywords:
	 * 	'in' 'binding'
	 * ;
	 */
	protected String getInBindingKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "in binding";
	}
	
	/**
	 * InModesKeywords:
	 * 	'in' 'modes'
	 * ;
	 */
	protected String getInModesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "in modes";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_Declarations_SemicolonKeyword_2_q.equals(syntax))
				emit_Declarations_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_NamedElementRef___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q.equals(syntax))
				emit_NamedElementRef___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PrimaryExpression_LeftParenthesisKeyword_4_0_a.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_4_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PrimaryExpression_LeftParenthesisKeyword_4_0_p.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_4_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SelectExpression___LeftParenthesisKeyword_1_0_3_0_RightParenthesisKeyword_1_0_3_2__q.equals(syntax))
				emit_SelectExpression___LeftParenthesisKeyword_1_0_3_0_RightParenthesisKeyword_1_0_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decls+=EDeclaration (ambiguity) (rule end)
	 */
	protected void emit_Declarations_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     ref=[NamedElement|QCREF] (ambiguity) (rule end)
	 */
	protected void emit_NamedElementRef___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '[' minimum=Expression
	 *     (rule start) (ambiguity) 'bag' '(' ')' (rule start)
	 *     (rule start) (ambiguity) 'bag' '(' elements+=Expression
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'if' if=Expression
	 *     (rule start) (ambiguity) 'list' '(' ')' (rule start)
	 *     (rule start) (ambiguity) 'list' '(' elements+=Expression
	 *     (rule start) (ambiguity) 'map' (rule start)
	 *     (rule start) (ambiguity) 'record' '(' ')' (rule start)
	 *     (rule start) (ambiguity) 'record' '(' fieldValues+=FieldValue
	 *     (rule start) (ambiguity) 'set' '(' ')' (rule start)
	 *     (rule start) (ambiguity) 'set' '(' elements+=Expression
	 *     (rule start) (ambiguity) 'tuple' '(' ')' (rule start)
	 *     (rule start) (ambiguity) 'tuple' '(' elements+=Expression
	 *     (rule start) (ambiguity) 'union' '(' fieldValue=FieldValue
	 *     (rule start) (ambiguity) '{' decls+=VarDecl
	 *     (rule start) (ambiguity) '{' result=Expression
	 *     (rule start) (ambiguity) core?='^'
	 *     (rule start) (ambiguity) operator=OpUnary
	 *     (rule start) (ambiguity) ref=[NamedElement|QCREF]
	 *     (rule start) (ambiguity) value=INTVALUE
	 *     (rule start) (ambiguity) value=NoQuoteString
	 *     (rule start) (ambiguity) value=SignedReal
	 *     (rule start) (ambiguity) value?='true'
	 *     (rule start) (ambiguity) {BinaryOperation.left=}
	 *     (rule start) (ambiguity) {PropertyExpression.modelElement=}
	 *     (rule start) (ambiguity) {Selection.receiver=}
	 *     (rule start) (ambiguity) {UnitExpression.expression=}
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_4_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '{' decls+=VarDecl
	 *     (rule start) (ambiguity) '{' result=Expression
	 *     (rule start) (ambiguity) operator=OpUnary
	 *     (rule start) (ambiguity) {BinaryOperation.left=}
	 *     (rule start) (ambiguity) {PropertyExpression.modelElement=}
	 *     (rule start) (ambiguity) {Selection.receiver=}
	 *     (rule start) (ambiguity) {UnitExpression.expression=}
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_4_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     ref=[NamedElement|QCREF] (ambiguity) ')' (rule end)
	 */
	protected void emit_SelectExpression___LeftParenthesisKeyword_1_0_3_0_RightParenthesisKeyword_1_0_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
