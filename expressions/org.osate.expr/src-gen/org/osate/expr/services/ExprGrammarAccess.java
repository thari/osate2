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
package org.osate.expr.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractEnumRuleElementFinder;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

@Singleton
public class ExprGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ExprModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ExprModel");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLibraryKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cAnnexAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cAnnexExprLibraryParserRuleCall_0_1_0 = (RuleCall)cAnnexAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cSubclauseKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cAnnexAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cAnnexExprSubclauseParserRuleCall_1_1_0 = (RuleCall)cAnnexAssignment_1_1.eContents().get(0);
		
		//// for testing
		//ExprModel:
		//	'library' annex=ExprLibrary
		//	| 'subclause' annex=ExprSubclause;
		@Override public ParserRule getRule() { return rule; }
		
		//'library' annex=ExprLibrary | 'subclause' annex=ExprSubclause
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'library' annex=ExprLibrary
		public Group getGroup_0() { return cGroup_0; }
		
		//'library'
		public Keyword getLibraryKeyword_0_0() { return cLibraryKeyword_0_0; }
		
		//annex=ExprLibrary
		public Assignment getAnnexAssignment_0_1() { return cAnnexAssignment_0_1; }
		
		//ExprLibrary
		public RuleCall getAnnexExprLibraryParserRuleCall_0_1_0() { return cAnnexExprLibraryParserRuleCall_0_1_0; }
		
		//'subclause' annex=ExprSubclause
		public Group getGroup_1() { return cGroup_1; }
		
		//'subclause'
		public Keyword getSubclauseKeyword_1_0() { return cSubclauseKeyword_1_0; }
		
		//annex=ExprSubclause
		public Assignment getAnnexAssignment_1_1() { return cAnnexAssignment_1_1; }
		
		//ExprSubclause
		public RuleCall getAnnexExprSubclauseParserRuleCall_1_1_0() { return cAnnexExprSubclauseParserRuleCall_1_1_0; }
	}
	public class ExprLibraryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ExprLibrary");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cExprLibraryAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cDeclarationsParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//ExprLibrary aadl2::AnnexLibrary:
		//	{ExprLibrary} Declarations?;
		@Override public ParserRule getRule() { return rule; }
		
		//{ExprLibrary} Declarations?
		public Group getGroup() { return cGroup; }
		
		//{ExprLibrary}
		public Action getExprLibraryAction_0() { return cExprLibraryAction_0; }
		
		//Declarations?
		public RuleCall getDeclarationsParserRuleCall_1() { return cDeclarationsParserRuleCall_1; }
	}
	public class ExprSubclauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ExprSubclause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cExprSubclauseAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cDeclarationsParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//ExprSubclause aadl2::AnnexSubclause:
		//	{ExprSubclause} Declarations?;
		@Override public ParserRule getRule() { return rule; }
		
		//{ExprSubclause} Declarations?
		public Group getGroup() { return cGroup; }
		
		//{ExprSubclause}
		public Action getExprSubclauseAction_0() { return cExprSubclauseAction_0; }
		
		//Declarations?
		public RuleCall getDeclarationsParserRuleCall_1() { return cDeclarationsParserRuleCall_1; }
	}
	public class NamedElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.NamedElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cExprLibraryParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cExprSubclauseParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cEDeclarationParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cArgumentParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cFieldParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//NamedElement aadl2::NamedElement:
		//	ExprLibrary | ExprSubclause | EDeclaration | Argument | Field;
		@Override public ParserRule getRule() { return rule; }
		
		//ExprLibrary | ExprSubclause | EDeclaration | Argument | Field
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ExprLibrary
		public RuleCall getExprLibraryParserRuleCall_0() { return cExprLibraryParserRuleCall_0; }
		
		//ExprSubclause
		public RuleCall getExprSubclauseParserRuleCall_1() { return cExprSubclauseParserRuleCall_1; }
		
		//EDeclaration
		public RuleCall getEDeclarationParserRuleCall_2() { return cEDeclarationParserRuleCall_2; }
		
		//Argument
		public RuleCall getArgumentParserRuleCall_3() { return cArgumentParserRuleCall_3; }
		
		//Field
		public RuleCall getFieldParserRuleCall_4() { return cFieldParserRuleCall_4; }
	}
	public class DeclarationsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Declarations");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Assignment cDeclsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cDeclsEDeclarationParserRuleCall_0_0 = (RuleCall)cDeclsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cSemicolonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cDeclsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cDeclsEDeclarationParserRuleCall_1_1_0 = (RuleCall)cDeclsAssignment_1_1.eContents().get(0);
		private final Keyword cSemicolonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//fragment Declarations *:
		//	decls+=EDeclaration (';' decls+=EDeclaration)* ';'?;
		@Override public ParserRule getRule() { return rule; }
		
		//decls+=EDeclaration (';' decls+=EDeclaration)* ';'?
		public Group getGroup() { return cGroup; }
		
		//decls+=EDeclaration
		public Assignment getDeclsAssignment_0() { return cDeclsAssignment_0; }
		
		//EDeclaration
		public RuleCall getDeclsEDeclarationParserRuleCall_0_0() { return cDeclsEDeclarationParserRuleCall_0_0; }
		
		//(';' decls+=EDeclaration)*
		public Group getGroup_1() { return cGroup_1; }
		
		//';'
		public Keyword getSemicolonKeyword_1_0() { return cSemicolonKeyword_1_0; }
		
		//decls+=EDeclaration
		public Assignment getDeclsAssignment_1_1() { return cDeclsAssignment_1_1; }
		
		//EDeclaration
		public RuleCall getDeclsEDeclarationParserRuleCall_1_1_0() { return cDeclsEDeclarationParserRuleCall_1_1_0; }
		
		//';'?
		public Keyword getSemicolonKeyword_2() { return cSemicolonKeyword_2; }
	}
	public class EDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EDeclaration");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cTypeDeclParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cVarDeclParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cFunDeclParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cAssertionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//EDeclaration:
		//	TypeDecl | VarDecl | FunDecl | Assertion;
		@Override public ParserRule getRule() { return rule; }
		
		//TypeDecl | VarDecl | FunDecl | Assertion
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//TypeDecl
		public RuleCall getTypeDeclParserRuleCall_0() { return cTypeDeclParserRuleCall_0; }
		
		//VarDecl
		public RuleCall getVarDeclParserRuleCall_1() { return cVarDeclParserRuleCall_1; }
		
		//FunDecl
		public RuleCall getFunDeclParserRuleCall_2() { return cFunDeclParserRuleCall_2; }
		
		//Assertion
		public RuleCall getAssertionParserRuleCall_3() { return cAssertionParserRuleCall_3; }
	}
	public class TypeDeclElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.TypeDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTypeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTypeTypeParserRuleCall_3_0 = (RuleCall)cTypeAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_1_0 = (RuleCall)cOwnedPropertyAssociationsAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cSemicolonKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cOwnedPropertyAssociationsAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_2_1_0 = (RuleCall)cOwnedPropertyAssociationsAssignment_4_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		
		//TypeDecl:
		//	'type' name=ID /*('extends' baseType=Type)?*/ ':' type=Type ('{'
		//	ownedPropertyAssociations+=PropertyAssociation (';' ownedPropertyAssociations+=PropertyAssociation)*
		//	'}')?;
		@Override public ParserRule getRule() { return rule; }
		
		//'type' name=ID /*('extends' baseType=Type)?*/ ':' type=Type ('{' ownedPropertyAssociations+=PropertyAssociation (';'
		//ownedPropertyAssociations+=PropertyAssociation)* '}')?
		public Group getGroup() { return cGroup; }
		
		//'type'
		public Keyword getTypeKeyword_0() { return cTypeKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		///*('extends' baseType=Type)?*/ ':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//type=Type
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_3_0() { return cTypeTypeParserRuleCall_3_0; }
		
		//('{' ownedPropertyAssociations+=PropertyAssociation (';' ownedPropertyAssociations+=PropertyAssociation)* '}')?
		public Group getGroup_4() { return cGroup_4; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4_0() { return cLeftCurlyBracketKeyword_4_0; }
		
		//ownedPropertyAssociations+=PropertyAssociation
		public Assignment getOwnedPropertyAssociationsAssignment_4_1() { return cOwnedPropertyAssociationsAssignment_4_1; }
		
		//PropertyAssociation
		public RuleCall getOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_1_0() { return cOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_1_0; }
		
		//(';' ownedPropertyAssociations+=PropertyAssociation)*
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//';'
		public Keyword getSemicolonKeyword_4_2_0() { return cSemicolonKeyword_4_2_0; }
		
		//ownedPropertyAssociations+=PropertyAssociation
		public Assignment getOwnedPropertyAssociationsAssignment_4_2_1() { return cOwnedPropertyAssociationsAssignment_4_2_1; }
		
		//PropertyAssociation
		public RuleCall getOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_2_1_0() { return cOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_2_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4_3() { return cRightCurlyBracketKeyword_4_3; }
	}
	public class VarDeclElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.VarDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cConstAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cConstValKeyword_0_0_0 = (Keyword)cConstAssignment_0_0.eContents().get(0);
		private final Keyword cVarKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cDeclTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cDeclTypeTypeParserRuleCall_2_1_0 = (RuleCall)cDeclTypeAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cEqualsSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cValueAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cValueExpressionParserRuleCall_3_1_0 = (RuleCall)cValueAssignment_3_1.eContents().get(0);
		
		//VarDecl:
		//	(const?='val' | 'var') name=ID (':' declType=Type)? ('=' value=Expression)?;
		@Override public ParserRule getRule() { return rule; }
		
		//(const?='val' | 'var') name=ID (':' declType=Type)? ('=' value=Expression)?
		public Group getGroup() { return cGroup; }
		
		//(const?='val' | 'var')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//const?='val'
		public Assignment getConstAssignment_0_0() { return cConstAssignment_0_0; }
		
		//'val'
		public Keyword getConstValKeyword_0_0_0() { return cConstValKeyword_0_0_0; }
		
		//'var'
		public Keyword getVarKeyword_0_1() { return cVarKeyword_0_1; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//(':' declType=Type)?
		public Group getGroup_2() { return cGroup_2; }
		
		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }
		
		//declType=Type
		public Assignment getDeclTypeAssignment_2_1() { return cDeclTypeAssignment_2_1; }
		
		//Type
		public RuleCall getDeclTypeTypeParserRuleCall_2_1_0() { return cDeclTypeTypeParserRuleCall_2_1_0; }
		
		//('=' value=Expression)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'='
		public Keyword getEqualsSignKeyword_3_0() { return cEqualsSignKeyword_3_0; }
		
		//value=Expression
		public Assignment getValueAssignment_3_1() { return cValueAssignment_3_1; }
		
		//Expression
		public RuleCall getValueExpressionParserRuleCall_3_1_0() { return cValueExpressionParserRuleCall_3_1_0; }
	}
	public class FunDeclElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.FunDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDefKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cArgsParserRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cResultTypeAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cResultTypeTypeParserRuleCall_6_0 = (RuleCall)cResultTypeAssignment_6.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cEqualsSignKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Alternatives cAlternatives_7_1 = (Alternatives)cGroup_7.eContents().get(1);
		private final Group cGroup_7_1_0 = (Group)cAlternatives_7_1.eContents().get(0);
		private final Assignment cJavaAssignment_7_1_0_0 = (Assignment)cGroup_7_1_0.eContents().get(0);
		private final Keyword cJavaJavaKeyword_7_1_0_0_0 = (Keyword)cJavaAssignment_7_1_0_0.eContents().get(0);
		private final Keyword cColonKeyword_7_1_0_1 = (Keyword)cGroup_7_1_0.eContents().get(1);
		private final Assignment cFqnAssignment_7_1_0_2 = (Assignment)cGroup_7_1_0.eContents().get(2);
		private final RuleCall cFqnJavaFQNParserRuleCall_7_1_0_2_0 = (RuleCall)cFqnAssignment_7_1_0_2.eContents().get(0);
		private final Assignment cExpAssignment_7_1_1 = (Assignment)cAlternatives_7_1.eContents().get(1);
		private final RuleCall cExpExpressionParserRuleCall_7_1_1_0 = (RuleCall)cExpAssignment_7_1_1.eContents().get(0);
		
		//FunDecl:
		//	'def' name=ID '(' Args ')' ':' resultType=Type ('=' (java?='java' ':' fqn=JavaFQN | exp=Expression))?;
		@Override public ParserRule getRule() { return rule; }
		
		//'def' name=ID '(' Args ')' ':' resultType=Type ('=' (java?='java' ':' fqn=JavaFQN | exp=Expression))?
		public Group getGroup() { return cGroup; }
		
		//'def'
		public Keyword getDefKeyword_0() { return cDefKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//Args
		public RuleCall getArgsParserRuleCall_3() { return cArgsParserRuleCall_3; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//':'
		public Keyword getColonKeyword_5() { return cColonKeyword_5; }
		
		//resultType=Type
		public Assignment getResultTypeAssignment_6() { return cResultTypeAssignment_6; }
		
		//Type
		public RuleCall getResultTypeTypeParserRuleCall_6_0() { return cResultTypeTypeParserRuleCall_6_0; }
		
		//('=' (java?='java' ':' fqn=JavaFQN | exp=Expression))?
		public Group getGroup_7() { return cGroup_7; }
		
		//'='
		public Keyword getEqualsSignKeyword_7_0() { return cEqualsSignKeyword_7_0; }
		
		//(java?='java' ':' fqn=JavaFQN | exp=Expression)
		public Alternatives getAlternatives_7_1() { return cAlternatives_7_1; }
		
		//java?='java' ':' fqn=JavaFQN
		public Group getGroup_7_1_0() { return cGroup_7_1_0; }
		
		//java?='java'
		public Assignment getJavaAssignment_7_1_0_0() { return cJavaAssignment_7_1_0_0; }
		
		//'java'
		public Keyword getJavaJavaKeyword_7_1_0_0_0() { return cJavaJavaKeyword_7_1_0_0_0; }
		
		//':'
		public Keyword getColonKeyword_7_1_0_1() { return cColonKeyword_7_1_0_1; }
		
		//fqn=JavaFQN
		public Assignment getFqnAssignment_7_1_0_2() { return cFqnAssignment_7_1_0_2; }
		
		//JavaFQN
		public RuleCall getFqnJavaFQNParserRuleCall_7_1_0_2_0() { return cFqnJavaFQNParserRuleCall_7_1_0_2_0; }
		
		//exp=Expression
		public Assignment getExpAssignment_7_1_1() { return cExpAssignment_7_1_1; }
		
		//Expression
		public RuleCall getExpExpressionParserRuleCall_7_1_1_0() { return cExpExpressionParserRuleCall_7_1_1_0; }
	}
	public class JavaFQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.JavaFQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//JavaFQN:
		//	ID ('.' ID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('.' ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('.' ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	public class ArgsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Args");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Assignment cArgsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cArgsArgumentParserRuleCall_0_0 = (RuleCall)cArgsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cArgsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cArgsArgumentParserRuleCall_1_1_0 = (RuleCall)cArgsAssignment_1_1.eContents().get(0);
		
		//fragment Args *:
		//	(args+=Argument (',' args+=Argument)*)?;
		@Override public ParserRule getRule() { return rule; }
		
		//(args+=Argument (',' args+=Argument)*)?
		public Group getGroup() { return cGroup; }
		
		//args+=Argument
		public Assignment getArgsAssignment_0() { return cArgsAssignment_0; }
		
		//Argument
		public RuleCall getArgsArgumentParserRuleCall_0_0() { return cArgsArgumentParserRuleCall_0_0; }
		
		//(',' args+=Argument)*
		public Group getGroup_1() { return cGroup_1; }
		
		//','
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }
		
		//args+=Argument
		public Assignment getArgsAssignment_1_1() { return cArgsAssignment_1_1; }
		
		//Argument
		public RuleCall getArgsArgumentParserRuleCall_1_1_0() { return cArgsArgumentParserRuleCall_1_1_0; }
	}
	public class ArgumentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Argument");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cArgumentAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTypeTypeParserRuleCall_3_0 = (RuleCall)cTypeAssignment_3.eContents().get(0);
		
		//Argument:
		//	{Argument} name=ID ':' type=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//{Argument} name=ID ':' type=Type
		public Group getGroup() { return cGroup; }
		
		//{Argument}
		public Action getArgumentAction_0() { return cArgumentAction_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//type=Type
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_3_0() { return cTypeTypeParserRuleCall_3_0; }
	}
	public class AssertionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Assertion");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAssertKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cAssertAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cAssertExpressionParserRuleCall_3_0 = (RuleCall)cAssertAssignment_3.eContents().get(0);
		
		//Assertion:
		//	'assert' name=ID ':' assert=Expression;
		@Override public ParserRule getRule() { return rule; }
		
		//'assert' name=ID ':' assert=Expression
		public Group getGroup() { return cGroup; }
		
		//'assert'
		public Keyword getAssertKeyword_0() { return cAssertKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//assert=Expression
		public Assignment getAssertAssignment_3() { return cAssertAssignment_3; }
		
		//Expression
		public RuleCall getAssertExpressionParserRuleCall_3_0() { return cAssertExpressionParserRuleCall_3_0; }
	}
	public class TypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Type");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPrimitiveTypeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRangeTypeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cCategoryParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cMetaClassParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cRecordTypeParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cUnionTypeParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cTupleTypeParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cListTypeParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cSetTypeParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cBagTypeParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cMapTypeParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		private final RuleCall cEnumTypeParserRuleCall_11 = (RuleCall)cAlternatives.eContents().get(11);
		private final RuleCall cTypeRefParserRuleCall_12 = (RuleCall)cAlternatives.eContents().get(12);
		
		//// Types
		//Type aadl2::Type:
		//	PrimitiveType | RangeType | Category | MetaClass
		//	| RecordType | UnionType | TupleType | ListType | SetType | BagType | MapType
		//	| EnumType | TypeRef;
		@Override public ParserRule getRule() { return rule; }
		
		//PrimitiveType | RangeType | Category | MetaClass | RecordType | UnionType | TupleType | ListType | SetType | BagType |
		//MapType | EnumType | TypeRef
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//PrimitiveType
		public RuleCall getPrimitiveTypeParserRuleCall_0() { return cPrimitiveTypeParserRuleCall_0; }
		
		//RangeType
		public RuleCall getRangeTypeParserRuleCall_1() { return cRangeTypeParserRuleCall_1; }
		
		//Category
		public RuleCall getCategoryParserRuleCall_2() { return cCategoryParserRuleCall_2; }
		
		//MetaClass
		public RuleCall getMetaClassParserRuleCall_3() { return cMetaClassParserRuleCall_3; }
		
		//RecordType
		public RuleCall getRecordTypeParserRuleCall_4() { return cRecordTypeParserRuleCall_4; }
		
		//UnionType
		public RuleCall getUnionTypeParserRuleCall_5() { return cUnionTypeParserRuleCall_5; }
		
		//TupleType
		public RuleCall getTupleTypeParserRuleCall_6() { return cTupleTypeParserRuleCall_6; }
		
		//ListType
		public RuleCall getListTypeParserRuleCall_7() { return cListTypeParserRuleCall_7; }
		
		//SetType
		public RuleCall getSetTypeParserRuleCall_8() { return cSetTypeParserRuleCall_8; }
		
		//BagType
		public RuleCall getBagTypeParserRuleCall_9() { return cBagTypeParserRuleCall_9; }
		
		//MapType
		public RuleCall getMapTypeParserRuleCall_10() { return cMapTypeParserRuleCall_10; }
		
		//EnumType
		public RuleCall getEnumTypeParserRuleCall_11() { return cEnumTypeParserRuleCall_11; }
		
		//TypeRef
		public RuleCall getTypeRefParserRuleCall_12() { return cTypeRefParserRuleCall_12; }
	}
	public class PrimitiveTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.PrimitiveType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cEBooleanAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cBoolKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cENumberTypeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cEStringAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Keyword cStringKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		
		//PrimitiveType aadl2::Type:
		//	{EBoolean} 'bool' | ENumberType | {EString} 'string';
		@Override public ParserRule getRule() { return rule; }
		
		//{EBoolean} 'bool' | ENumberType | {EString} 'string'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{EBoolean} 'bool'
		public Group getGroup_0() { return cGroup_0; }
		
		//{EBoolean}
		public Action getEBooleanAction_0_0() { return cEBooleanAction_0_0; }
		
		//'bool'
		public Keyword getBoolKeyword_0_1() { return cBoolKeyword_0_1; }
		
		//ENumberType
		public RuleCall getENumberTypeParserRuleCall_1() { return cENumberTypeParserRuleCall_1; }
		
		//{EString} 'string'
		public Group getGroup_2() { return cGroup_2; }
		
		//{EString}
		public Action getEStringAction_2_0() { return cEStringAction_2_0; }
		
		//'string'
		public Keyword getStringKeyword_2_1() { return cStringKeyword_2_1; }
	}
	public class ENumberTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ENumberType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEIntegerParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cERealParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//ENumberType:
		//	EInteger | EReal;
		@Override public ParserRule getRule() { return rule; }
		
		//EInteger | EReal
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//EInteger
		public RuleCall getEIntegerParserRuleCall_0() { return cEIntegerParserRuleCall_0; }
		
		//EReal
		public RuleCall getERealParserRuleCall_1() { return cERealParserRuleCall_1; }
	}
	public class EIntegerElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EInteger");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEIntegerAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cIntKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//EInteger:
		//	{EInteger} 'int';
		@Override public ParserRule getRule() { return rule; }
		
		//{EInteger} 'int'
		public Group getGroup() { return cGroup; }
		
		//{EInteger}
		public Action getEIntegerAction_0() { return cEIntegerAction_0; }
		
		//'int'
		public Keyword getIntKeyword_1() { return cIntKeyword_1; }
	}
	public class ERealElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EReal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cERealAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cRealKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//EReal:
		//	{EReal} 'real';
		@Override public ParserRule getRule() { return rule; }
		
		//{EReal} 'real'
		public Group getGroup() { return cGroup; }
		
		//{EReal}
		public Action getERealAction_0() { return cERealAction_0; }
		
		//'real'
		public Keyword getRealKeyword_1() { return cRealKeyword_1; }
	}
	public class RangeTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.RangeType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRangeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cOfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeTypeParserRuleCall_2_0 = (RuleCall)cTypeAssignment_2.eContents().get(0);
		
		//RangeType:
		//	'range' 'of' type=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//'range' 'of' type=Type
		public Group getGroup() { return cGroup; }
		
		//'range'
		public Keyword getRangeKeyword_0() { return cRangeKeyword_0; }
		
		//'of'
		public Keyword getOfKeyword_1() { return cOfKeyword_1; }
		
		//type=Type
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_2_0() { return cTypeTypeParserRuleCall_2_0; }
	}
	public class CategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Category");
		private final Assignment cCategoryAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cCategoryComponentCategoryParserRuleCall_0 = (RuleCall)cCategoryAssignment.eContents().get(0);
		
		//Category:
		//	category=ComponentCategory;
		@Override public ParserRule getRule() { return rule; }
		
		//category=ComponentCategory
		public Assignment getCategoryAssignment() { return cCategoryAssignment; }
		
		//ComponentCategory
		public RuleCall getCategoryComponentCategoryParserRuleCall_0() { return cCategoryComponentCategoryParserRuleCall_0; }
	}
	public class ComponentCategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ComponentCategory");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAbstractKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cBusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cDataKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cDeviceKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cMemoryKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cProcessKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cProcessorKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cSubprogramKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Group cGroup_8 = (Group)cAlternatives.eContents().get(8);
		private final Keyword cSubprogramKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cGroupKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cSystemKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Group cGroup_10 = (Group)cAlternatives.eContents().get(10);
		private final Keyword cThreadKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Keyword cGroupKeyword_10_1 = (Keyword)cGroup_10.eContents().get(1);
		private final Keyword cThreadKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Group cGroup_12 = (Group)cAlternatives.eContents().get(12);
		private final Keyword cVirtualKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Keyword cBusKeyword_12_1 = (Keyword)cGroup_12.eContents().get(1);
		private final Group cGroup_13 = (Group)cAlternatives.eContents().get(13);
		private final Keyword cVirtualKeyword_13_0 = (Keyword)cGroup_13.eContents().get(0);
		private final Keyword cProcessorKeyword_13_1 = (Keyword)cGroup_13.eContents().get(1);
		
		//ComponentCategory aadl2::ComponentCategory:
		//	'abstract' | 'bus' | 'data' | 'device' | 'memory' | 'process' | 'processor' | 'subprogram'
		//	| 'subprogram' 'group' | 'system' | 'thread' 'group' | 'thread'
		//	| 'virtual' 'bus' | 'virtual' 'processor';
		@Override public ParserRule getRule() { return rule; }
		
		//'abstract' | 'bus' | 'data' | 'device' | 'memory' | 'process' | 'processor' | 'subprogram' | 'subprogram' 'group' |
		//'system' | 'thread' 'group' | 'thread' | 'virtual' 'bus' | 'virtual' 'processor'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'abstract'
		public Keyword getAbstractKeyword_0() { return cAbstractKeyword_0; }
		
		//'bus'
		public Keyword getBusKeyword_1() { return cBusKeyword_1; }
		
		//'data'
		public Keyword getDataKeyword_2() { return cDataKeyword_2; }
		
		//'device'
		public Keyword getDeviceKeyword_3() { return cDeviceKeyword_3; }
		
		//'memory'
		public Keyword getMemoryKeyword_4() { return cMemoryKeyword_4; }
		
		//'process'
		public Keyword getProcessKeyword_5() { return cProcessKeyword_5; }
		
		//'processor'
		public Keyword getProcessorKeyword_6() { return cProcessorKeyword_6; }
		
		//'subprogram'
		public Keyword getSubprogramKeyword_7() { return cSubprogramKeyword_7; }
		
		//'subprogram' 'group'
		public Group getGroup_8() { return cGroup_8; }
		
		//'subprogram'
		public Keyword getSubprogramKeyword_8_0() { return cSubprogramKeyword_8_0; }
		
		//'group'
		public Keyword getGroupKeyword_8_1() { return cGroupKeyword_8_1; }
		
		//'system'
		public Keyword getSystemKeyword_9() { return cSystemKeyword_9; }
		
		//'thread' 'group'
		public Group getGroup_10() { return cGroup_10; }
		
		//'thread'
		public Keyword getThreadKeyword_10_0() { return cThreadKeyword_10_0; }
		
		//'group'
		public Keyword getGroupKeyword_10_1() { return cGroupKeyword_10_1; }
		
		//'thread'
		public Keyword getThreadKeyword_11() { return cThreadKeyword_11; }
		
		//'virtual' 'bus'
		public Group getGroup_12() { return cGroup_12; }
		
		//'virtual'
		public Keyword getVirtualKeyword_12_0() { return cVirtualKeyword_12_0; }
		
		//'bus'
		public Keyword getBusKeyword_12_1() { return cBusKeyword_12_1; }
		
		//'virtual' 'processor'
		public Group getGroup_13() { return cGroup_13; }
		
		//'virtual'
		public Keyword getVirtualKeyword_13_0() { return cVirtualKeyword_13_0; }
		
		//'processor'
		public Keyword getProcessorKeyword_13_1() { return cProcessorKeyword_13_1; }
	}
	public class MetaClassElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.MetaClass");
		private final Assignment cClassAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cClassMetaClassEnumEnumRuleCall_0 = (RuleCall)cClassAssignment.eContents().get(0);
		
		//// TODO: should support real meta class references
		//MetaClass:
		//	class=MetaClassEnum;
		@Override public ParserRule getRule() { return rule; }
		
		//class=MetaClassEnum
		public Assignment getClassAssignment() { return cClassAssignment; }
		
		//MetaClassEnum
		public RuleCall getClassMetaClassEnumEnumRuleCall_0() { return cClassMetaClassEnumEnumRuleCall_0; }
	}
	public class RecordTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.RecordType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRecordTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cRecordKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cFieldsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cFieldsFieldParserRuleCall_3_0_0 = (RuleCall)cFieldsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cFieldsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cFieldsFieldParserRuleCall_3_1_1_0 = (RuleCall)cFieldsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//RecordType:
		//	{RecordType} 'record' '{' (fields+=Field (',' fields+=Field)*)?
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{RecordType} 'record' '{' (fields+=Field (',' fields+=Field)*)? '}'
		public Group getGroup() { return cGroup; }
		
		//{RecordType}
		public Action getRecordTypeAction_0() { return cRecordTypeAction_0; }
		
		//'record'
		public Keyword getRecordKeyword_1() { return cRecordKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(fields+=Field (',' fields+=Field)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//fields+=Field
		public Assignment getFieldsAssignment_3_0() { return cFieldsAssignment_3_0; }
		
		//Field
		public RuleCall getFieldsFieldParserRuleCall_3_0_0() { return cFieldsFieldParserRuleCall_3_0_0; }
		
		//(',' fields+=Field)*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//fields+=Field
		public Assignment getFieldsAssignment_3_1_1() { return cFieldsAssignment_3_1_1; }
		
		//Field
		public RuleCall getFieldsFieldParserRuleCall_3_1_1_0() { return cFieldsFieldParserRuleCall_3_1_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class FieldElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Field");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cFieldAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTypeTypeParserRuleCall_3_0 = (RuleCall)cTypeAssignment_3.eContents().get(0);
		
		//Field:
		//	{Field} name=ID ':' type=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//{Field} name=ID ':' type=Type
		public Group getGroup() { return cGroup; }
		
		//{Field}
		public Action getFieldAction_0() { return cFieldAction_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//type=Type
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_3_0() { return cTypeTypeParserRuleCall_3_0; }
	}
	public class UnionTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.UnionType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUnionTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cUnionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cFieldsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cFieldsFieldParserRuleCall_3_0_0 = (RuleCall)cFieldsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cFieldsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cFieldsFieldParserRuleCall_3_1_1_0 = (RuleCall)cFieldsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//UnionType:
		//	{UnionType} 'union' '{' (fields+=Field (',' fields+=Field)*)?
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{UnionType} 'union' '{' (fields+=Field (',' fields+=Field)*)? '}'
		public Group getGroup() { return cGroup; }
		
		//{UnionType}
		public Action getUnionTypeAction_0() { return cUnionTypeAction_0; }
		
		//'union'
		public Keyword getUnionKeyword_1() { return cUnionKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(fields+=Field (',' fields+=Field)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//fields+=Field
		public Assignment getFieldsAssignment_3_0() { return cFieldsAssignment_3_0; }
		
		//Field
		public RuleCall getFieldsFieldParserRuleCall_3_0_0() { return cFieldsFieldParserRuleCall_3_0_0; }
		
		//(',' fields+=Field)*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//fields+=Field
		public Assignment getFieldsAssignment_3_1_1() { return cFieldsAssignment_3_1_1; }
		
		//Field
		public RuleCall getFieldsFieldParserRuleCall_3_1_1_0() { return cFieldsFieldParserRuleCall_3_1_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class TupleTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.TupleType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTupleTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cTupleKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cFieldsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cFieldsTupleFieldParserRuleCall_3_0_0 = (RuleCall)cFieldsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cFieldsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cFieldsTupleFieldParserRuleCall_3_1_1_0 = (RuleCall)cFieldsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//TupleType:
		//	{TupleType} 'tuple' '{' (fields+=TupleField (',' fields+=TupleField)*)?
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{TupleType} 'tuple' '{' (fields+=TupleField (',' fields+=TupleField)*)? '}'
		public Group getGroup() { return cGroup; }
		
		//{TupleType}
		public Action getTupleTypeAction_0() { return cTupleTypeAction_0; }
		
		//'tuple'
		public Keyword getTupleKeyword_1() { return cTupleKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(fields+=TupleField (',' fields+=TupleField)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//fields+=TupleField
		public Assignment getFieldsAssignment_3_0() { return cFieldsAssignment_3_0; }
		
		//TupleField
		public RuleCall getFieldsTupleFieldParserRuleCall_3_0_0() { return cFieldsTupleFieldParserRuleCall_3_0_0; }
		
		//(',' fields+=TupleField)*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//fields+=TupleField
		public Assignment getFieldsAssignment_3_1_1() { return cFieldsAssignment_3_1_1; }
		
		//TupleField
		public RuleCall getFieldsTupleFieldParserRuleCall_3_1_1_0() { return cFieldsTupleFieldParserRuleCall_3_1_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class TupleFieldElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.TupleField");
		private final Assignment cTypeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cTypeTypeParserRuleCall_0 = (RuleCall)cTypeAssignment.eContents().get(0);
		
		//TupleField Field:
		//	type=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//type=Type
		public Assignment getTypeAssignment() { return cTypeAssignment; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_0() { return cTypeTypeParserRuleCall_0; }
	}
	public class ListTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ListType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cListKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cOfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeTypeParserRuleCall_2_0 = (RuleCall)cTypeAssignment_2.eContents().get(0);
		
		//ListType:
		//	'list' 'of' type=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//'list' 'of' type=Type
		public Group getGroup() { return cGroup; }
		
		//'list'
		public Keyword getListKeyword_0() { return cListKeyword_0; }
		
		//'of'
		public Keyword getOfKeyword_1() { return cOfKeyword_1; }
		
		//type=Type
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_2_0() { return cTypeTypeParserRuleCall_2_0; }
	}
	public class SetTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.SetType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cOfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeTypeParserRuleCall_2_0 = (RuleCall)cTypeAssignment_2.eContents().get(0);
		
		//SetType:
		//	'set' 'of' type=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//'set' 'of' type=Type
		public Group getGroup() { return cGroup; }
		
		//'set'
		public Keyword getSetKeyword_0() { return cSetKeyword_0; }
		
		//'of'
		public Keyword getOfKeyword_1() { return cOfKeyword_1; }
		
		//type=Type
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_2_0() { return cTypeTypeParserRuleCall_2_0; }
	}
	public class BagTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.BagType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cBagKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cOfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTypeTypeParserRuleCall_2_0 = (RuleCall)cTypeAssignment_2.eContents().get(0);
		
		//BagType:
		//	'bag' 'of' type=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//'bag' 'of' type=Type
		public Group getGroup() { return cGroup; }
		
		//'bag'
		public Keyword getBagKeyword_0() { return cBagKeyword_0; }
		
		//'of'
		public Keyword getOfKeyword_1() { return cOfKeyword_1; }
		
		//type=Type
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }
		
		//Type
		public RuleCall getTypeTypeParserRuleCall_2_0() { return cTypeTypeParserRuleCall_2_0; }
	}
	public class MapTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.MapType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMapKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cDomainAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cDomainTypeParserRuleCall_1_0 = (RuleCall)cDomainAssignment_1.eContents().get(0);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cImageAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cImageTypeParserRuleCall_3_0 = (RuleCall)cImageAssignment_3.eContents().get(0);
		
		//MapType:
		//	'map' domain=Type '->' image=Type;
		@Override public ParserRule getRule() { return rule; }
		
		//'map' domain=Type '->' image=Type
		public Group getGroup() { return cGroup; }
		
		//'map'
		public Keyword getMapKeyword_0() { return cMapKeyword_0; }
		
		//domain=Type
		public Assignment getDomainAssignment_1() { return cDomainAssignment_1; }
		
		//Type
		public RuleCall getDomainTypeParserRuleCall_1_0() { return cDomainTypeParserRuleCall_1_0; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_2() { return cHyphenMinusGreaterThanSignKeyword_2; }
		
		//image=Type
		public Assignment getImageAssignment_3() { return cImageAssignment_3; }
		
		//Type
		public RuleCall getImageTypeParserRuleCall_3_0() { return cImageTypeParserRuleCall_3_0; }
	}
	public class EnumTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EnumType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEnumTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cEnumKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cLiteralsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cLiteralsEnumLiteralParserRuleCall_3_0_0 = (RuleCall)cLiteralsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cLiteralsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cLiteralsEnumLiteralParserRuleCall_3_1_1_0 = (RuleCall)cLiteralsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//EnumType:
		//	{EnumType} 'enum' '{' (literals+=EnumLiteral (',' literals+=EnumLiteral)*)?
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{EnumType} 'enum' '{' (literals+=EnumLiteral (',' literals+=EnumLiteral)*)? '}'
		public Group getGroup() { return cGroup; }
		
		//{EnumType}
		public Action getEnumTypeAction_0() { return cEnumTypeAction_0; }
		
		//'enum'
		public Keyword getEnumKeyword_1() { return cEnumKeyword_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(literals+=EnumLiteral (',' literals+=EnumLiteral)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//literals+=EnumLiteral
		public Assignment getLiteralsAssignment_3_0() { return cLiteralsAssignment_3_0; }
		
		//EnumLiteral
		public RuleCall getLiteralsEnumLiteralParserRuleCall_3_0_0() { return cLiteralsEnumLiteralParserRuleCall_3_0_0; }
		
		//(',' literals+=EnumLiteral)*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//literals+=EnumLiteral
		public Assignment getLiteralsAssignment_3_1_1() { return cLiteralsAssignment_3_1_1; }
		
		//EnumLiteral
		public RuleCall getLiteralsEnumLiteralParserRuleCall_3_1_1_0() { return cLiteralsEnumLiteralParserRuleCall_3_1_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class EnumLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EnumLiteral");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//EnumLiteral:
		//	name=ID;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class TypeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.TypeRef");
		private final Assignment cRefAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cRefNamedElementCrossReference_0 = (CrossReference)cRefAssignment.eContents().get(0);
		private final RuleCall cRefNamedElementQCREFParserRuleCall_0_1 = (RuleCall)cRefNamedElementCrossReference_0.eContents().get(1);
		
		//TypeRef:
		//	ref=[aadl2::NamedElement|QCREF];
		@Override public ParserRule getRule() { return rule; }
		
		//ref=[aadl2::NamedElement|QCREF]
		public Assignment getRefAssignment() { return cRefAssignment; }
		
		//[aadl2::NamedElement|QCREF]
		public CrossReference getRefNamedElementCrossReference_0() { return cRefNamedElementCrossReference_0; }
		
		//QCREF
		public RuleCall getRefNamedElementQCREFParserRuleCall_0_1() { return cRefNamedElementQCREFParserRuleCall_0_1; }
	}
	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Expression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cOrExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cBlockExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Expression:
		//	OrExpression
		//	| BlockExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//OrExpression | BlockExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//OrExpression
		public RuleCall getOrExpressionParserRuleCall_0() { return cOrExpressionParserRuleCall_0; }
		
		//BlockExpression
		public RuleCall getBlockExpressionParserRuleCall_1() { return cBlockExpressionParserRuleCall_1; }
	}
	public class BlockExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.BlockExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBlockAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cDeclsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cDeclsVarDeclParserRuleCall_2_0_0 = (RuleCall)cDeclsAssignment_2_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Assignment cResultAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cResultExpressionParserRuleCall_3_0 = (RuleCall)cResultAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//BlockExpression Expression:
		//	{Block} '{' (decls+=VarDecl ';')*
		//	result=Expression
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//{Block} '{' (decls+=VarDecl ';')* result=Expression '}'
		public Group getGroup() { return cGroup; }
		
		//{Block}
		public Action getBlockAction_0() { return cBlockAction_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }
		
		//(decls+=VarDecl ';')*
		public Group getGroup_2() { return cGroup_2; }
		
		//decls+=VarDecl
		public Assignment getDeclsAssignment_2_0() { return cDeclsAssignment_2_0; }
		
		//VarDecl
		public RuleCall getDeclsVarDeclParserRuleCall_2_0_0() { return cDeclsVarDeclParserRuleCall_2_0_0; }
		
		//';'
		public Keyword getSemicolonKeyword_2_1() { return cSemicolonKeyword_2_1; }
		
		//result=Expression
		public Assignment getResultAssignment_3() { return cResultAssignment_3; }
		
		//Expression
		public RuleCall getResultExpressionParserRuleCall_3_0() { return cResultExpressionParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class OrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.OrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cBinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpOrParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAndExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//OrExpression Expression:
		//	AndExpression (=> ({BinaryOperation.left=current} operator=OpOr) right=AndExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//AndExpression (=> ({BinaryOperation.left=current} operator=OpOr) right=AndExpression)*
		public Group getGroup() { return cGroup; }
		
		//AndExpression
		public RuleCall getAndExpressionParserRuleCall_0() { return cAndExpressionParserRuleCall_0; }
		
		//(=> ({BinaryOperation.left=current} operator=OpOr) right=AndExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({BinaryOperation.left=current} operator=OpOr)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//({BinaryOperation.left=current} operator=OpOr)
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{BinaryOperation.left=current}
		public Action getBinaryOperationLeftAction_1_0_0_0() { return cBinaryOperationLeftAction_1_0_0_0; }
		
		//operator=OpOr
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }
		
		//OpOr
		public RuleCall getOperatorOpOrParserRuleCall_1_0_0_1_0() { return cOperatorOpOrParserRuleCall_1_0_0_1_0; }
		
		//right=AndExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//AndExpression
		public RuleCall getRightAndExpressionParserRuleCall_1_1_0() { return cRightAndExpressionParserRuleCall_1_1_0; }
	}
	public class OpOrElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.OpOr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cOrKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cVerticalLineVerticalLineKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpOr Operation:
		//	'or' | '||';
		@Override public ParserRule getRule() { return rule; }
		
		//'or' | '||'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'or'
		public Keyword getOrKeyword_0() { return cOrKeyword_0; }
		
		//'||'
		public Keyword getVerticalLineVerticalLineKeyword_1() { return cVerticalLineVerticalLineKeyword_1; }
	}
	public class AndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.AndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cEqualityExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cBinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpAndParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightEqualityExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//AndExpression Expression:
		//	EqualityExpression (=> ({BinaryOperation.left=current} operator=OpAnd) right=EqualityExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//EqualityExpression (=> ({BinaryOperation.left=current} operator=OpAnd) right=EqualityExpression)*
		public Group getGroup() { return cGroup; }
		
		//EqualityExpression
		public RuleCall getEqualityExpressionParserRuleCall_0() { return cEqualityExpressionParserRuleCall_0; }
		
		//(=> ({BinaryOperation.left=current} operator=OpAnd) right=EqualityExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({BinaryOperation.left=current} operator=OpAnd)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//({BinaryOperation.left=current} operator=OpAnd)
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{BinaryOperation.left=current}
		public Action getBinaryOperationLeftAction_1_0_0_0() { return cBinaryOperationLeftAction_1_0_0_0; }
		
		//operator=OpAnd
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }
		
		//OpAnd
		public RuleCall getOperatorOpAndParserRuleCall_1_0_0_1_0() { return cOperatorOpAndParserRuleCall_1_0_0_1_0; }
		
		//right=EqualityExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//EqualityExpression
		public RuleCall getRightEqualityExpressionParserRuleCall_1_1_0() { return cRightEqualityExpressionParserRuleCall_1_1_0; }
	}
	public class OpAndElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.OpAnd");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAndKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAmpersandAmpersandKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpAnd Operation:
		//	'and' | '&&';
		@Override public ParserRule getRule() { return rule; }
		
		//'and' | '&&'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'and'
		public Keyword getAndKeyword_0() { return cAndKeyword_0; }
		
		//'&&'
		public Keyword getAmpersandAmpersandKeyword_1() { return cAmpersandAmpersandKeyword_1; }
	}
	public class EqualityExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EqualityExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cRelationalExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cBinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpEqualityParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightRelationalExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//EqualityExpression Expression:
		//	RelationalExpression (=> ({BinaryOperation.left=current} operator=OpEquality) right=RelationalExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//RelationalExpression (=> ({BinaryOperation.left=current} operator=OpEquality) right=RelationalExpression)*
		public Group getGroup() { return cGroup; }
		
		//RelationalExpression
		public RuleCall getRelationalExpressionParserRuleCall_0() { return cRelationalExpressionParserRuleCall_0; }
		
		//(=> ({BinaryOperation.left=current} operator=OpEquality) right=RelationalExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({BinaryOperation.left=current} operator=OpEquality)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//({BinaryOperation.left=current} operator=OpEquality)
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{BinaryOperation.left=current}
		public Action getBinaryOperationLeftAction_1_0_0_0() { return cBinaryOperationLeftAction_1_0_0_0; }
		
		//operator=OpEquality
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }
		
		//OpEquality
		public RuleCall getOperatorOpEqualityParserRuleCall_1_0_0_1_0() { return cOperatorOpEqualityParserRuleCall_1_0_0_1_0; }
		
		//right=RelationalExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//RelationalExpression
		public RuleCall getRightRelationalExpressionParserRuleCall_1_1_0() { return cRightRelationalExpressionParserRuleCall_1_1_0; }
	}
	public class OpEqualityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.OpEquality");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cEqualsSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cExclamationMarkEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpEquality Operation:
		//	'==' | '!=';
		@Override public ParserRule getRule() { return rule; }
		
		//'==' | '!='
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'=='
		public Keyword getEqualsSignEqualsSignKeyword_0() { return cEqualsSignEqualsSignKeyword_0; }
		
		//'!='
		public Keyword getExclamationMarkEqualsSignKeyword_1() { return cExclamationMarkEqualsSignKeyword_1; }
	}
	public class RelationalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.RelationalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAdditiveExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cBinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpCompareParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAdditiveExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//RelationalExpression Expression:
		//	AdditiveExpression (=> ({BinaryOperation.left=current} operator=OpCompare) right=AdditiveExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		////	OtherOperatorExpression
		////	( =>({BinaryOperation.leftOperand=current} feature=OpCompare) rightOperand=OtherOperatorExpression)*;
		//AdditiveExpression (=> ({BinaryOperation.left=current} operator=OpCompare) right=AdditiveExpression)*
		public Group getGroup() { return cGroup; }
		
		////	OtherOperatorExpression
		////	( =>({BinaryOperation.leftOperand=current} feature=OpCompare) rightOperand=OtherOperatorExpression)*;
		//AdditiveExpression
		public RuleCall getAdditiveExpressionParserRuleCall_0() { return cAdditiveExpressionParserRuleCall_0; }
		
		//(=> ({BinaryOperation.left=current} operator=OpCompare) right=AdditiveExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({BinaryOperation.left=current} operator=OpCompare)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//({BinaryOperation.left=current} operator=OpCompare)
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{BinaryOperation.left=current}
		public Action getBinaryOperationLeftAction_1_0_0_0() { return cBinaryOperationLeftAction_1_0_0_0; }
		
		//operator=OpCompare
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }
		
		//OpCompare
		public RuleCall getOperatorOpCompareParserRuleCall_1_0_0_1_0() { return cOperatorOpCompareParserRuleCall_1_0_0_1_0; }
		
		//right=AdditiveExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//AdditiveExpression
		public RuleCall getRightAdditiveExpressionParserRuleCall_1_1_0() { return cRightAdditiveExpressionParserRuleCall_1_1_0; }
	}
	public class OpCompareElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.OpCompare");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cGreaterThanSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cLessThanSignEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cLessThanSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cGreaterThanSignLessThanSignKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		
		//OpCompare Operation:
		//	'>=' | '<=' | '>' | '<' | '><';
		@Override public ParserRule getRule() { return rule; }
		
		//'>=' | '<=' | '>' | '<' | '><'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'>='
		public Keyword getGreaterThanSignEqualsSignKeyword_0() { return cGreaterThanSignEqualsSignKeyword_0; }
		
		//'<='
		public Keyword getLessThanSignEqualsSignKeyword_1() { return cLessThanSignEqualsSignKeyword_1; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_2() { return cGreaterThanSignKeyword_2; }
		
		//'<'
		public Keyword getLessThanSignKeyword_3() { return cLessThanSignKeyword_3; }
		
		//'><'
		public Keyword getGreaterThanSignLessThanSignKeyword_4() { return cGreaterThanSignLessThanSignKeyword_4; }
	}
	public class AdditiveExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.AdditiveExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cMultiplicativeExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cBinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpAddParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightMultiplicativeExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		////OtherOperatorExpression returns aadl2::PropertyExpression:
		////	AdditiveExpression (=>({ABinaryOperation.leftOperand=current} feature=OpOther)
		////	rightOperand=AAdditiveExpression)*;
		////
		////OpOther:
		////	  '->' 
		////	| '..<'
		////	| '>' '..'
		////	| '..'
		////	| '=>' 
		////	| '>' (=>('>' '>') | '>') 
		////	| '<' (=>('<' '<') | '<' | '=>')
		////	| '<>'
		////	| '?:';
		//AdditiveExpression Expression:
		//	MultiplicativeExpression (=> ({BinaryOperation.left=current} operator=OpAdd) right=MultiplicativeExpression)*;
		@Override public ParserRule getRule() { return rule; }
		
		//MultiplicativeExpression (=> ({BinaryOperation.left=current} operator=OpAdd) right=MultiplicativeExpression)*
		public Group getGroup() { return cGroup; }
		
		//MultiplicativeExpression
		public RuleCall getMultiplicativeExpressionParserRuleCall_0() { return cMultiplicativeExpressionParserRuleCall_0; }
		
		//(=> ({BinaryOperation.left=current} operator=OpAdd) right=MultiplicativeExpression)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({BinaryOperation.left=current} operator=OpAdd)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//({BinaryOperation.left=current} operator=OpAdd)
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{BinaryOperation.left=current}
		public Action getBinaryOperationLeftAction_1_0_0_0() { return cBinaryOperationLeftAction_1_0_0_0; }
		
		//operator=OpAdd
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }
		
		//OpAdd
		public RuleCall getOperatorOpAddParserRuleCall_1_0_0_1_0() { return cOperatorOpAddParserRuleCall_1_0_0_1_0; }
		
		//right=MultiplicativeExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//MultiplicativeExpression
		public RuleCall getRightMultiplicativeExpressionParserRuleCall_1_1_0() { return cRightMultiplicativeExpressionParserRuleCall_1_1_0; }
	}
	public class OpAddElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.OpAdd");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPlusSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpAdd Operation:
		//	'+' | '-';
		@Override public ParserRule getRule() { return rule; }
		
		//'+' | '-'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'+'
		public Keyword getPlusSignKeyword_0() { return cPlusSignKeyword_0; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
	}
	public class MultiplicativeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.MultiplicativeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cUnaryOperationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cBinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpMultiParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightUnaryOperationParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//MultiplicativeExpression Expression:
		//	UnaryOperation (=> ({BinaryOperation.left=current} operator=OpMulti) right=UnaryOperation)*;
		@Override public ParserRule getRule() { return rule; }
		
		//UnaryOperation (=> ({BinaryOperation.left=current} operator=OpMulti) right=UnaryOperation)*
		public Group getGroup() { return cGroup; }
		
		//UnaryOperation
		public RuleCall getUnaryOperationParserRuleCall_0() { return cUnaryOperationParserRuleCall_0; }
		
		//(=> ({BinaryOperation.left=current} operator=OpMulti) right=UnaryOperation)*
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({BinaryOperation.left=current} operator=OpMulti)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//({BinaryOperation.left=current} operator=OpMulti)
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{BinaryOperation.left=current}
		public Action getBinaryOperationLeftAction_1_0_0_0() { return cBinaryOperationLeftAction_1_0_0_0; }
		
		//operator=OpMulti
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }
		
		//OpMulti
		public RuleCall getOperatorOpMultiParserRuleCall_1_0_0_1_0() { return cOperatorOpMultiParserRuleCall_1_0_0_1_0; }
		
		//right=UnaryOperation
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }
		
		//UnaryOperation
		public RuleCall getRightUnaryOperationParserRuleCall_1_1_0() { return cRightUnaryOperationParserRuleCall_1_1_0; }
	}
	public class OpMultiElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.OpMulti");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAsteriskKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cSolidusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cDivKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cModKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//OpMulti Operation:
		//	'*' | '/' | 'div' | 'mod';
		@Override public ParserRule getRule() { return rule; }
		
		//'*' | '/' | 'div' | 'mod'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'*'
		public Keyword getAsteriskKeyword_0() { return cAsteriskKeyword_0; }
		
		//'/'
		public Keyword getSolidusKeyword_1() { return cSolidusKeyword_1; }
		
		//'div'
		public Keyword getDivKeyword_2() { return cDivKeyword_2; }
		
		//'mod'
		public Keyword getModKeyword_3() { return cModKeyword_3; }
	}
	public class UnaryOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.UnaryOperation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cUnaryOperationAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cOperatorAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cOperatorOpUnaryParserRuleCall_0_1_0 = (RuleCall)cOperatorAssignment_0_1.eContents().get(0);
		private final Assignment cOperandAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cOperandUnitExpressionParserRuleCall_0_2_0 = (RuleCall)cOperandAssignment_0_2.eContents().get(0);
		private final RuleCall cUnitExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//UnaryOperation Expression:
		//	{UnaryOperation} => operator=OpUnary operand=UnitExpression
		//	| UnitExpression;
		@Override public ParserRule getRule() { return rule; }
		
		//{UnaryOperation} => operator=OpUnary operand=UnitExpression | UnitExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//{UnaryOperation} => operator=OpUnary operand=UnitExpression
		public Group getGroup_0() { return cGroup_0; }
		
		//{UnaryOperation}
		public Action getUnaryOperationAction_0_0() { return cUnaryOperationAction_0_0; }
		
		//=> operator=OpUnary
		public Assignment getOperatorAssignment_0_1() { return cOperatorAssignment_0_1; }
		
		//OpUnary
		public RuleCall getOperatorOpUnaryParserRuleCall_0_1_0() { return cOperatorOpUnaryParserRuleCall_0_1_0; }
		
		//operand=UnitExpression
		public Assignment getOperandAssignment_0_2() { return cOperandAssignment_0_2; }
		
		//UnitExpression
		public RuleCall getOperandUnitExpressionParserRuleCall_0_2_0() { return cOperandUnitExpressionParserRuleCall_0_2_0; }
		
		//UnitExpression
		public RuleCall getUnitExpressionParserRuleCall_1() { return cUnitExpressionParserRuleCall_1; }
	}
	public class OpUnaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.OpUnary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cNotKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cPlusSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		
		//OpUnary Operation:
		//	"not" | "-" | "+";
		@Override public ParserRule getRule() { return rule; }
		
		//"not" | "-" | "+"
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//"not"
		public Keyword getNotKeyword_0() { return cNotKeyword_0; }
		
		//"-"
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
		
		//"+"
		public Keyword getPlusSignKeyword_2() { return cPlusSignKeyword_2; }
	}
	public class UnitExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.UnitExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPropertyExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cUnitExpressionExpressionAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Assignment cConvertAssignment_1_1_0 = (Assignment)cAlternatives_1_1.eContents().get(0);
		private final Keyword cConvertPercentSignKeyword_1_1_0_0 = (Keyword)cConvertAssignment_1_1_0.eContents().get(0);
		private final Assignment cDropAssignment_1_1_1 = (Assignment)cAlternatives_1_1.eContents().get(1);
		private final Keyword cDropInKeyword_1_1_1_0 = (Keyword)cDropAssignment_1_1_1.eContents().get(0);
		private final Assignment cUnitAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cUnitUnitLiteralCrossReference_1_2_0 = (CrossReference)cUnitAssignment_1_2.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_2_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_2_0.eContents().get(1);
		
		//UnitExpression Expression:
		//	PropertyExpression ({UnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?;
		@Override public ParserRule getRule() { return rule; }
		
		//PropertyExpression ({UnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?
		public Group getGroup() { return cGroup; }
		
		//PropertyExpression
		public RuleCall getPropertyExpressionParserRuleCall_0() { return cPropertyExpressionParserRuleCall_0; }
		
		//({UnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?
		public Group getGroup_1() { return cGroup_1; }
		
		//{UnitExpression.expression=current}
		public Action getUnitExpressionExpressionAction_1_0() { return cUnitExpressionExpressionAction_1_0; }
		
		//(convert?='%' | drop?='in')?
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }
		
		//convert?='%'
		public Assignment getConvertAssignment_1_1_0() { return cConvertAssignment_1_1_0; }
		
		//'%'
		public Keyword getConvertPercentSignKeyword_1_1_0_0() { return cConvertPercentSignKeyword_1_1_0_0; }
		
		//drop?='in'
		public Assignment getDropAssignment_1_1_1() { return cDropAssignment_1_1_1; }
		
		//'in'
		public Keyword getDropInKeyword_1_1_1_0() { return cDropInKeyword_1_1_1_0; }
		
		//unit=[aadl2::UnitLiteral]
		public Assignment getUnitAssignment_1_2() { return cUnitAssignment_1_2; }
		
		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_1_2_0() { return cUnitUnitLiteralCrossReference_1_2_0; }
		
		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_2_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_2_0_1; }
	}
	public class PropertyExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.PropertyExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cSelectExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cPropertyExpressionModelElementAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Keyword cNumberSignKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Assignment cPropertyAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final CrossReference cPropertyAbstractNamedValueCrossReference_1_1_0 = (CrossReference)cPropertyAssignment_1_1.eContents().get(0);
		private final RuleCall cPropertyAbstractNamedValueQPREFParserRuleCall_1_1_0_1 = (RuleCall)cPropertyAbstractNamedValueCrossReference_1_1_0.eContents().get(1);
		
		//@Override
		//PropertyExpression Expression:
		//	SelectExpression (=> ({PropertyExpression.modelElement=current} '#') property=[aadl2::AbstractNamedValue|QPREF])?;
		@Override public ParserRule getRule() { return rule; }
		
		//SelectExpression (=> ({PropertyExpression.modelElement=current} '#') property=[aadl2::AbstractNamedValue|QPREF])?
		public Group getGroup() { return cGroup; }
		
		//SelectExpression
		public RuleCall getSelectExpressionParserRuleCall_0() { return cSelectExpressionParserRuleCall_0; }
		
		//(=> ({PropertyExpression.modelElement=current} '#') property=[aadl2::AbstractNamedValue|QPREF])?
		public Group getGroup_1() { return cGroup_1; }
		
		//=> ({PropertyExpression.modelElement=current} '#')
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//({PropertyExpression.modelElement=current} '#')
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }
		
		//{PropertyExpression.modelElement=current}
		public Action getPropertyExpressionModelElementAction_1_0_0_0() { return cPropertyExpressionModelElementAction_1_0_0_0; }
		
		//'#'
		public Keyword getNumberSignKeyword_1_0_0_1() { return cNumberSignKeyword_1_0_0_1; }
		
		//property=[aadl2::AbstractNamedValue|QPREF]
		public Assignment getPropertyAssignment_1_1() { return cPropertyAssignment_1_1; }
		
		//[aadl2::AbstractNamedValue|QPREF]
		public CrossReference getPropertyAbstractNamedValueCrossReference_1_1_0() { return cPropertyAbstractNamedValueCrossReference_1_1_0; }
		
		//QPREF
		public RuleCall getPropertyAbstractNamedValueQPREFParserRuleCall_1_1_0_1() { return cPropertyAbstractNamedValueQPREFParserRuleCall_1_1_0_1; }
	}
	public class SelectExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.SelectExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPrimaryExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Action cSelectionReceiverAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Keyword cFullStopKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Assignment cRefAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final CrossReference cRefNamedElementCrossReference_1_0_2_0 = (CrossReference)cRefAssignment_1_0_2.eContents().get(0);
		private final RuleCall cRefNamedElementQCREFParserRuleCall_1_0_2_0_1 = (RuleCall)cRefNamedElementCrossReference_1_0_2_0.eContents().get(1);
		private final Group cGroup_1_0_3 = (Group)cGroup_1_0.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_1_0_3_0 = (Keyword)cGroup_1_0_3.eContents().get(0);
		private final Group cGroup_1_0_3_1 = (Group)cGroup_1_0_3.eContents().get(1);
		private final Assignment cArgsAssignment_1_0_3_1_0 = (Assignment)cGroup_1_0_3_1.eContents().get(0);
		private final RuleCall cArgsExpressionParserRuleCall_1_0_3_1_0_0 = (RuleCall)cArgsAssignment_1_0_3_1_0.eContents().get(0);
		private final Group cGroup_1_0_3_1_1 = (Group)cGroup_1_0_3_1.eContents().get(1);
		private final Keyword cCommaKeyword_1_0_3_1_1_0 = (Keyword)cGroup_1_0_3_1_1.eContents().get(0);
		private final Assignment cArgsAssignment_1_0_3_1_1_1 = (Assignment)cGroup_1_0_3_1_1.eContents().get(1);
		private final RuleCall cArgsExpressionParserRuleCall_1_0_3_1_1_1_0 = (RuleCall)cArgsAssignment_1_0_3_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_0_3_2 = (Keyword)cGroup_1_0_3.eContents().get(2);
		
		//SelectExpression Expression:
		//	PrimaryExpression
		//	=> ({Selection.receiver=current} '.'
		//	ref=[aadl2::NamedElement|QCREF] ('(' (args+=Expression (',' args+=Expression)*)? ')')?)*;
		@Override public ParserRule getRule() { return rule; }
		
		//PrimaryExpression => ({Selection.receiver=current} '.' ref=[aadl2::NamedElement|QCREF] ('(' (args+=Expression (','
		//args+=Expression)*)? ')')?)*
		public Group getGroup() { return cGroup; }
		
		//PrimaryExpression
		public RuleCall getPrimaryExpressionParserRuleCall_0() { return cPrimaryExpressionParserRuleCall_0; }
		
		//=> ({Selection.receiver=current} '.' ref=[aadl2::NamedElement|QCREF] ('(' (args+=Expression (',' args+=Expression)*)?
		//')')?)*
		public Group getGroup_1() { return cGroup_1; }
		
		//({Selection.receiver=current} '.' ref=[aadl2::NamedElement|QCREF] ('(' (args+=Expression (',' args+=Expression)*)?
		//')')?)
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{Selection.receiver=current}
		public Action getSelectionReceiverAction_1_0_0() { return cSelectionReceiverAction_1_0_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0_1() { return cFullStopKeyword_1_0_1; }
		
		//ref=[aadl2::NamedElement|QCREF]
		public Assignment getRefAssignment_1_0_2() { return cRefAssignment_1_0_2; }
		
		//[aadl2::NamedElement|QCREF]
		public CrossReference getRefNamedElementCrossReference_1_0_2_0() { return cRefNamedElementCrossReference_1_0_2_0; }
		
		//QCREF
		public RuleCall getRefNamedElementQCREFParserRuleCall_1_0_2_0_1() { return cRefNamedElementQCREFParserRuleCall_1_0_2_0_1; }
		
		//('(' (args+=Expression (',' args+=Expression)*)? ')')?
		public Group getGroup_1_0_3() { return cGroup_1_0_3; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1_0_3_0() { return cLeftParenthesisKeyword_1_0_3_0; }
		
		//(args+=Expression (',' args+=Expression)*)?
		public Group getGroup_1_0_3_1() { return cGroup_1_0_3_1; }
		
		//args+=Expression
		public Assignment getArgsAssignment_1_0_3_1_0() { return cArgsAssignment_1_0_3_1_0; }
		
		//Expression
		public RuleCall getArgsExpressionParserRuleCall_1_0_3_1_0_0() { return cArgsExpressionParserRuleCall_1_0_3_1_0_0; }
		
		//(',' args+=Expression)*
		public Group getGroup_1_0_3_1_1() { return cGroup_1_0_3_1_1; }
		
		//','
		public Keyword getCommaKeyword_1_0_3_1_1_0() { return cCommaKeyword_1_0_3_1_1_0; }
		
		//args+=Expression
		public Assignment getArgsAssignment_1_0_3_1_1_1() { return cArgsAssignment_1_0_3_1_1_1; }
		
		//Expression
		public RuleCall getArgsExpressionParserRuleCall_1_0_3_1_1_1_0() { return cArgsExpressionParserRuleCall_1_0_3_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_0_3_2() { return cRightParenthesisKeyword_1_0_3_2; }
	}
	public class PrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.PrimaryExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cNamedElementRefParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cRangeExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cIfExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cLiteralParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final RuleCall cExpressionParserRuleCall_4_1 = (RuleCall)cGroup_4.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		
		//PrimaryExpression Expression:
		//	NamedElementRef
		//	| RangeExpression | IfExpression
		//	| Literal | '(' Expression ')';
		@Override public ParserRule getRule() { return rule; }
		
		//NamedElementRef | RangeExpression | IfExpression | Literal | '(' Expression ')'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//NamedElementRef
		public RuleCall getNamedElementRefParserRuleCall_0() { return cNamedElementRefParserRuleCall_0; }
		
		//RangeExpression
		public RuleCall getRangeExpressionParserRuleCall_1() { return cRangeExpressionParserRuleCall_1; }
		
		//IfExpression
		public RuleCall getIfExpressionParserRuleCall_2() { return cIfExpressionParserRuleCall_2; }
		
		//Literal
		public RuleCall getLiteralParserRuleCall_3() { return cLiteralParserRuleCall_3; }
		
		//'(' Expression ')'
		public Group getGroup_4() { return cGroup_4; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_4_0() { return cLeftParenthesisKeyword_4_0; }
		
		//Expression
		public RuleCall getExpressionParserRuleCall_4_1() { return cExpressionParserRuleCall_4_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4_2() { return cRightParenthesisKeyword_4_2; }
	}
	public class NamedElementRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.NamedElementRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCoreAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cCoreCircumflexAccentKeyword_0_0 = (Keyword)cCoreAssignment_0.eContents().get(0);
		private final Assignment cRefAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefNamedElementCrossReference_1_0 = (CrossReference)cRefAssignment_1.eContents().get(0);
		private final RuleCall cRefNamedElementQCREFParserRuleCall_1_0_1 = (RuleCall)cRefNamedElementCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Assignment cArgsAssignment_2_1_0 = (Assignment)cGroup_2_1.eContents().get(0);
		private final RuleCall cArgsExpressionParserRuleCall_2_1_0_0 = (RuleCall)cArgsAssignment_2_1_0.eContents().get(0);
		private final Group cGroup_2_1_1 = (Group)cGroup_2_1.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_1_0 = (Keyword)cGroup_2_1_1.eContents().get(0);
		private final Assignment cArgsAssignment_2_1_1_1 = (Assignment)cGroup_2_1_1.eContents().get(1);
		private final RuleCall cArgsExpressionParserRuleCall_2_1_1_1_0 = (RuleCall)cArgsAssignment_2_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		
		//NamedElementRef:
		//	core?='^'?
		//	ref=[aadl2::NamedElement|QCREF] ('(' (args+=Expression (',' args+=Expression)*)? ')')?;
		@Override public ParserRule getRule() { return rule; }
		
		//core?='^'? ref=[aadl2::NamedElement|QCREF] ('(' (args+=Expression (',' args+=Expression)*)? ')')?
		public Group getGroup() { return cGroup; }
		
		//core?='^'?
		public Assignment getCoreAssignment_0() { return cCoreAssignment_0; }
		
		//'^'
		public Keyword getCoreCircumflexAccentKeyword_0_0() { return cCoreCircumflexAccentKeyword_0_0; }
		
		//ref=[aadl2::NamedElement|QCREF]
		public Assignment getRefAssignment_1() { return cRefAssignment_1; }
		
		//[aadl2::NamedElement|QCREF]
		public CrossReference getRefNamedElementCrossReference_1_0() { return cRefNamedElementCrossReference_1_0; }
		
		//QCREF
		public RuleCall getRefNamedElementQCREFParserRuleCall_1_0_1() { return cRefNamedElementQCREFParserRuleCall_1_0_1; }
		
		//('(' (args+=Expression (',' args+=Expression)*)? ')')?
		public Group getGroup_2() { return cGroup_2; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }
		
		//(args+=Expression (',' args+=Expression)*)?
		public Group getGroup_2_1() { return cGroup_2_1; }
		
		//args+=Expression
		public Assignment getArgsAssignment_2_1_0() { return cArgsAssignment_2_1_0; }
		
		//Expression
		public RuleCall getArgsExpressionParserRuleCall_2_1_0_0() { return cArgsExpressionParserRuleCall_2_1_0_0; }
		
		//(',' args+=Expression)*
		public Group getGroup_2_1_1() { return cGroup_2_1_1; }
		
		//','
		public Keyword getCommaKeyword_2_1_1_0() { return cCommaKeyword_2_1_1_0; }
		
		//args+=Expression
		public Assignment getArgsAssignment_2_1_1_1() { return cArgsAssignment_2_1_1_1; }
		
		//Expression
		public RuleCall getArgsExpressionParserRuleCall_2_1_1_1_0() { return cArgsExpressionParserRuleCall_2_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }
	}
	public class RangeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.RangeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRangeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cMinimumAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cMinimumExpressionParserRuleCall_2_0 = (RuleCall)cMinimumAssignment_2.eContents().get(0);
		private final Keyword cFullStopFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cMaximumAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cMaximumExpressionParserRuleCall_4_0 = (RuleCall)cMaximumAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cDeltaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cDeltaAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cDeltaExpressionParserRuleCall_5_1_0 = (RuleCall)cDeltaAssignment_5_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//RangeExpression Expression:
		//	{Range} '[' minimum=Expression '..' maximum=Expression (=> 'delta' delta=Expression)? ']';
		@Override public ParserRule getRule() { return rule; }
		
		//{Range} '[' minimum=Expression '..' maximum=Expression (=> 'delta' delta=Expression)? ']'
		public Group getGroup() { return cGroup; }
		
		//{Range}
		public Action getRangeAction_0() { return cRangeAction_0; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }
		
		//minimum=Expression
		public Assignment getMinimumAssignment_2() { return cMinimumAssignment_2; }
		
		//Expression
		public RuleCall getMinimumExpressionParserRuleCall_2_0() { return cMinimumExpressionParserRuleCall_2_0; }
		
		//'..'
		public Keyword getFullStopFullStopKeyword_3() { return cFullStopFullStopKeyword_3; }
		
		//maximum=Expression
		public Assignment getMaximumAssignment_4() { return cMaximumAssignment_4; }
		
		//Expression
		public RuleCall getMaximumExpressionParserRuleCall_4_0() { return cMaximumExpressionParserRuleCall_4_0; }
		
		//(=> 'delta' delta=Expression)?
		public Group getGroup_5() { return cGroup_5; }
		
		//=> 'delta'
		public Keyword getDeltaKeyword_5_0() { return cDeltaKeyword_5_0; }
		
		//delta=Expression
		public Assignment getDeltaAssignment_5_1() { return cDeltaAssignment_5_1; }
		
		//Expression
		public RuleCall getDeltaExpressionParserRuleCall_5_1_0() { return cDeltaExpressionParserRuleCall_5_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}
	public class IfExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.IfExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cConditionalAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cIfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIfAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cIfExpressionParserRuleCall_2_0 = (RuleCall)cIfAssignment_2.eContents().get(0);
		private final Keyword cThenKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cThenAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cThenExpressionParserRuleCall_4_0 = (RuleCall)cThenAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cElseKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cElseAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cElseExpressionParserRuleCall_5_1_0 = (RuleCall)cElseAssignment_5_1.eContents().get(0);
		private final Keyword cEndifKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//IfExpression Expression:
		//	{Conditional} 'if' if=Expression 'then' then=Expression ('else' else=Expression)? 'endif';
		@Override public ParserRule getRule() { return rule; }
		
		//{Conditional} 'if' if=Expression 'then' then=Expression ('else' else=Expression)? 'endif'
		public Group getGroup() { return cGroup; }
		
		//{Conditional}
		public Action getConditionalAction_0() { return cConditionalAction_0; }
		
		//'if'
		public Keyword getIfKeyword_1() { return cIfKeyword_1; }
		
		//if=Expression
		public Assignment getIfAssignment_2() { return cIfAssignment_2; }
		
		//Expression
		public RuleCall getIfExpressionParserRuleCall_2_0() { return cIfExpressionParserRuleCall_2_0; }
		
		//'then'
		public Keyword getThenKeyword_3() { return cThenKeyword_3; }
		
		//then=Expression
		public Assignment getThenAssignment_4() { return cThenAssignment_4; }
		
		//Expression
		public RuleCall getThenExpressionParserRuleCall_4_0() { return cThenExpressionParserRuleCall_4_0; }
		
		//('else' else=Expression)?
		public Group getGroup_5() { return cGroup_5; }
		
		//'else'
		public Keyword getElseKeyword_5_0() { return cElseKeyword_5_0; }
		
		//else=Expression
		public Assignment getElseAssignment_5_1() { return cElseAssignment_5_1; }
		
		//Expression
		public RuleCall getElseExpressionParserRuleCall_5_1_0() { return cElseExpressionParserRuleCall_5_1_0; }
		
		//'endif'
		public Keyword getEndifKeyword_6() { return cEndifKeyword_6; }
	}
	public class LiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Literal");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEBooleanLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cNumberLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cEStringLiteralParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cListLiteralParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cSetLiteralParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cRecordLiteralParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cUnionLiteralParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cTupleLiteralParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cBagLiteralParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cMapLiteralParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		
		//// literal values
		//Literal:
		//	EBooleanLiteral | NumberLiteral | EStringLiteral
		//	| ListLiteral | SetLiteral | RecordLiteral | UnionLiteral | TupleLiteral
		//	| BagLiteral | MapLiteral;
		@Override public ParserRule getRule() { return rule; }
		
		//EBooleanLiteral | NumberLiteral | EStringLiteral | ListLiteral | SetLiteral | RecordLiteral | UnionLiteral |
		//TupleLiteral | BagLiteral | MapLiteral
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//EBooleanLiteral
		public RuleCall getEBooleanLiteralParserRuleCall_0() { return cEBooleanLiteralParserRuleCall_0; }
		
		//NumberLiteral
		public RuleCall getNumberLiteralParserRuleCall_1() { return cNumberLiteralParserRuleCall_1; }
		
		//EStringLiteral
		public RuleCall getEStringLiteralParserRuleCall_2() { return cEStringLiteralParserRuleCall_2; }
		
		//ListLiteral
		public RuleCall getListLiteralParserRuleCall_3() { return cListLiteralParserRuleCall_3; }
		
		//SetLiteral
		public RuleCall getSetLiteralParserRuleCall_4() { return cSetLiteralParserRuleCall_4; }
		
		//RecordLiteral
		public RuleCall getRecordLiteralParserRuleCall_5() { return cRecordLiteralParserRuleCall_5; }
		
		//UnionLiteral
		public RuleCall getUnionLiteralParserRuleCall_6() { return cUnionLiteralParserRuleCall_6; }
		
		//TupleLiteral
		public RuleCall getTupleLiteralParserRuleCall_7() { return cTupleLiteralParserRuleCall_7; }
		
		//BagLiteral
		public RuleCall getBagLiteralParserRuleCall_8() { return cBagLiteralParserRuleCall_8; }
		
		//MapLiteral
		public RuleCall getMapLiteralParserRuleCall_9() { return cMapLiteralParserRuleCall_9; }
	}
	public class ValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Value");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cWrappedNamedElementParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Value:
		//	Literal | WrappedNamedElement;
		@Override public ParserRule getRule() { return rule; }
		
		//Literal | WrappedNamedElement
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Literal
		public RuleCall getLiteralParserRuleCall_0() { return cLiteralParserRuleCall_0; }
		
		//WrappedNamedElement
		public RuleCall getWrappedNamedElementParserRuleCall_1() { return cWrappedNamedElementParserRuleCall_1; }
	}
	public class WrappedNamedElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.WrappedNamedElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cWrappedNamedElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cElemAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cElemNamedElementCrossReference_1_0 = (CrossReference)cElemAssignment_1.eContents().get(0);
		private final RuleCall cElemNamedElementIDTerminalRuleCall_1_0_1 = (RuleCall)cElemNamedElementCrossReference_1_0.eContents().get(1);
		
		//// dummy rule
		//WrappedNamedElement:
		//	{WrappedNamedElement} elem=[aadl2::NamedElement];
		@Override public ParserRule getRule() { return rule; }
		
		//{WrappedNamedElement} elem=[aadl2::NamedElement]
		public Group getGroup() { return cGroup; }
		
		//{WrappedNamedElement}
		public Action getWrappedNamedElementAction_0() { return cWrappedNamedElementAction_0; }
		
		//elem=[aadl2::NamedElement]
		public Assignment getElemAssignment_1() { return cElemAssignment_1; }
		
		//[aadl2::NamedElement]
		public CrossReference getElemNamedElementCrossReference_1_0() { return cElemNamedElementCrossReference_1_0; }
		
		//ID
		public RuleCall getElemNamedElementIDTerminalRuleCall_1_0_1() { return cElemNamedElementIDTerminalRuleCall_1_0_1; }
	}
	public class EBooleanLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EBooleanLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEBooleanLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cValueTrueKeyword_1_0_0 = (Keyword)cValueAssignment_1_0.eContents().get(0);
		private final Keyword cFalseKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		
		//EBooleanLiteral Literal:
		//	{EBooleanLiteral} (value?='true' | 'false');
		@Override public ParserRule getRule() { return rule; }
		
		//{EBooleanLiteral} (value?='true' | 'false')
		public Group getGroup() { return cGroup; }
		
		//{EBooleanLiteral}
		public Action getEBooleanLiteralAction_0() { return cEBooleanLiteralAction_0; }
		
		//(value?='true' | 'false')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//value?='true'
		public Assignment getValueAssignment_1_0() { return cValueAssignment_1_0; }
		
		//'true'
		public Keyword getValueTrueKeyword_1_0_0() { return cValueTrueKeyword_1_0_0; }
		
		//'false'
		public Keyword getFalseKeyword_1_1() { return cFalseKeyword_1_1; }
	}
	public class NumberLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.NumberLiteral");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cEIntegerLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cERealLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//NumberLiteral Literal:
		//	EIntegerLiteral | ERealLiteral;
		@Override public ParserRule getRule() { return rule; }
		
		//EIntegerLiteral | ERealLiteral
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//EIntegerLiteral
		public RuleCall getEIntegerLiteralParserRuleCall_0() { return cEIntegerLiteralParserRuleCall_0; }
		
		//ERealLiteral
		public RuleCall getERealLiteralParserRuleCall_1() { return cERealLiteralParserRuleCall_1; }
	}
	public class EIntegerLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EIntegerLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEIntegerLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueINTVALUEParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//EIntegerLiteral NumberLiteral:
		//	{EIntegerLiteral} value=INTVALUE
		//	//	('<'unit=UnitTerm'>')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{EIntegerLiteral} value=INTVALUE
		public Group getGroup() { return cGroup; }
		
		//{EIntegerLiteral}
		public Action getEIntegerLiteralAction_0() { return cEIntegerLiteralAction_0; }
		
		//value=INTVALUE
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//INTVALUE
		public RuleCall getValueINTVALUEParserRuleCall_1_0() { return cValueINTVALUEParserRuleCall_1_0; }
	}
	public class ERealLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ERealLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cERealLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSignedRealParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//ERealLiteral NumberLiteral:
		//	{ERealLiteral} value=SignedReal
		//	//	('<'unit=UnitTerm'>')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{ERealLiteral} value=SignedReal
		public Group getGroup() { return cGroup; }
		
		//{ERealLiteral}
		public Action getERealLiteralAction_0() { return cERealLiteralAction_0; }
		
		//value=SignedReal
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//SignedReal
		public RuleCall getValueSignedRealParserRuleCall_1_0() { return cValueSignedRealParserRuleCall_1_0; }
	}
	public class SignedRealElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.SignedReal");
		private final RuleCall cREAL_LITTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//@Override
		//SignedReal aadl2::Real:
		//	REAL_LIT;
		@Override public ParserRule getRule() { return rule; }
		
		//REAL_LIT
		public RuleCall getREAL_LITTerminalRuleCall() { return cREAL_LITTerminalRuleCall; }
	}
	public class EStringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.EStringLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEStringLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueNoQuoteStringParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//EStringLiteral Literal:
		//	{EStringLiteral} value=NoQuoteString;
		@Override public ParserRule getRule() { return rule; }
		
		//{EStringLiteral} value=NoQuoteString
		public Group getGroup() { return cGroup; }
		
		//{EStringLiteral}
		public Action getEStringLiteralAction_0() { return cEStringLiteralAction_0; }
		
		//value=NoQuoteString
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//NoQuoteString
		public RuleCall getValueNoQuoteStringParserRuleCall_1_0() { return cValueNoQuoteStringParserRuleCall_1_0; }
	}
	public class ExpressionListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ExpressionList");
		private final Group cGroup = (Group)rule.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cElementsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cElementsExpressionParserRuleCall_1_0_0 = (RuleCall)cElementsAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cCommaKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cElementsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cElementsExpressionParserRuleCall_1_1_1_0 = (RuleCall)cElementsAssignment_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//fragment ExpressionList *:
		//	'(' (elements+=Expression (',' elements+=Expression)*)? ')';
		@Override public ParserRule getRule() { return rule; }
		
		//'(' (elements+=Expression (',' elements+=Expression)*)? ')'
		public Group getGroup() { return cGroup; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }
		
		//(elements+=Expression (',' elements+=Expression)*)?
		public Group getGroup_1() { return cGroup_1; }
		
		//elements+=Expression
		public Assignment getElementsAssignment_1_0() { return cElementsAssignment_1_0; }
		
		//Expression
		public RuleCall getElementsExpressionParserRuleCall_1_0_0() { return cElementsExpressionParserRuleCall_1_0_0; }
		
		//(',' elements+=Expression)*
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//','
		public Keyword getCommaKeyword_1_1_0() { return cCommaKeyword_1_1_0; }
		
		//elements+=Expression
		public Assignment getElementsAssignment_1_1_1() { return cElementsAssignment_1_1_1; }
		
		//Expression
		public RuleCall getElementsExpressionParserRuleCall_1_1_1_0() { return cElementsExpressionParserRuleCall_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}
	public class ListLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.ListLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cListLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cListKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cExpressionListParserRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//ListLiteral Literal:
		//	{ListLiteral} 'list' ExpressionList;
		@Override public ParserRule getRule() { return rule; }
		
		//{ListLiteral} 'list' ExpressionList
		public Group getGroup() { return cGroup; }
		
		//{ListLiteral}
		public Action getListLiteralAction_0() { return cListLiteralAction_0; }
		
		//'list'
		public Keyword getListKeyword_1() { return cListKeyword_1; }
		
		//ExpressionList
		public RuleCall getExpressionListParserRuleCall_2() { return cExpressionListParserRuleCall_2; }
	}
	public class SetLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.SetLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSetLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSetKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cExpressionListParserRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//SetLiteral Literal:
		//	{SetLiteral} 'set' ExpressionList;
		@Override public ParserRule getRule() { return rule; }
		
		//{SetLiteral} 'set' ExpressionList
		public Group getGroup() { return cGroup; }
		
		//{SetLiteral}
		public Action getSetLiteralAction_0() { return cSetLiteralAction_0; }
		
		//'set'
		public Keyword getSetKeyword_1() { return cSetKeyword_1; }
		
		//ExpressionList
		public RuleCall getExpressionListParserRuleCall_2() { return cExpressionListParserRuleCall_2; }
	}
	public class RecordLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.RecordLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRecordLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cRecordKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cFieldValuesAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cFieldValuesFieldValueParserRuleCall_3_0_0 = (RuleCall)cFieldValuesAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cFieldValuesAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cFieldValuesFieldValueParserRuleCall_3_1_1_0 = (RuleCall)cFieldValuesAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//RecordLiteral Literal:
		//	{RecordLiteral} 'record' '(' (fieldValues+=FieldValue (',' fieldValues+=FieldValue)*)?
		//	')';
		@Override public ParserRule getRule() { return rule; }
		
		//{RecordLiteral} 'record' '(' (fieldValues+=FieldValue (',' fieldValues+=FieldValue)*)? ')'
		public Group getGroup() { return cGroup; }
		
		//{RecordLiteral}
		public Action getRecordLiteralAction_0() { return cRecordLiteralAction_0; }
		
		//'record'
		public Keyword getRecordKeyword_1() { return cRecordKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//(fieldValues+=FieldValue (',' fieldValues+=FieldValue)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//fieldValues+=FieldValue
		public Assignment getFieldValuesAssignment_3_0() { return cFieldValuesAssignment_3_0; }
		
		//FieldValue
		public RuleCall getFieldValuesFieldValueParserRuleCall_3_0_0() { return cFieldValuesFieldValueParserRuleCall_3_0_0; }
		
		//(',' fieldValues+=FieldValue)*
		public Group getGroup_3_1() { return cGroup_3_1; }
		
		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }
		
		//fieldValues+=FieldValue
		public Assignment getFieldValuesAssignment_3_1_1() { return cFieldValuesAssignment_3_1_1; }
		
		//FieldValue
		public RuleCall getFieldValuesFieldValueParserRuleCall_3_1_1_0() { return cFieldValuesFieldValueParserRuleCall_3_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}
	public class FieldValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.FieldValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueExpressionParserRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//FieldValue:
		//	name=ID ':' value=Expression;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID ':' value=Expression
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }
		
		//value=Expression
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }
		
		//Expression
		public RuleCall getValueExpressionParserRuleCall_2_0() { return cValueExpressionParserRuleCall_2_0; }
	}
	public class UnionLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.UnionLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUnionLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cUnionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cFieldValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFieldValueFieldValueParserRuleCall_3_0 = (RuleCall)cFieldValueAssignment_3.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//UnionLiteral Literal:
		//	{UnionLiteral} 'union' '('
		//	fieldValue=FieldValue
		//	')';
		@Override public ParserRule getRule() { return rule; }
		
		//{UnionLiteral} 'union' '(' fieldValue=FieldValue ')'
		public Group getGroup() { return cGroup; }
		
		//{UnionLiteral}
		public Action getUnionLiteralAction_0() { return cUnionLiteralAction_0; }
		
		//'union'
		public Keyword getUnionKeyword_1() { return cUnionKeyword_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }
		
		//fieldValue=FieldValue
		public Assignment getFieldValueAssignment_3() { return cFieldValueAssignment_3; }
		
		//FieldValue
		public RuleCall getFieldValueFieldValueParserRuleCall_3_0() { return cFieldValueFieldValueParserRuleCall_3_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}
	public class TupleLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.TupleLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTupleLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cTupleKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cExpressionListParserRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//TupleLiteral Literal:
		//	{TupleLiteral} 'tuple' ExpressionList;
		@Override public ParserRule getRule() { return rule; }
		
		//{TupleLiteral} 'tuple' ExpressionList
		public Group getGroup() { return cGroup; }
		
		//{TupleLiteral}
		public Action getTupleLiteralAction_0() { return cTupleLiteralAction_0; }
		
		//'tuple'
		public Keyword getTupleKeyword_1() { return cTupleKeyword_1; }
		
		//ExpressionList
		public RuleCall getExpressionListParserRuleCall_2() { return cExpressionListParserRuleCall_2; }
	}
	public class BagLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.BagLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBagLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cBagKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cExpressionListParserRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//BagLiteral Literal:
		//	{BagLiteral} 'bag' ExpressionList;
		@Override public ParserRule getRule() { return rule; }
		
		//{BagLiteral} 'bag' ExpressionList
		public Group getGroup() { return cGroup; }
		
		//{BagLiteral}
		public Action getBagLiteralAction_0() { return cBagLiteralAction_0; }
		
		//'bag'
		public Keyword getBagKeyword_1() { return cBagKeyword_1; }
		
		//ExpressionList
		public RuleCall getExpressionListParserRuleCall_2() { return cExpressionListParserRuleCall_2; }
	}
	public class MapLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.MapLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMapLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cMapKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//MapLiteral Literal:
		//	{MapLiteral} 'map';
		@Override public ParserRule getRule() { return rule; }
		
		//{MapLiteral} 'map'
		public Group getGroup() { return cGroup; }
		
		//{MapLiteral}
		public Action getMapLiteralAction_0() { return cMapLiteralAction_0; }
		
		//'map'
		public Keyword getMapKeyword_1() { return cMapKeyword_1; }
	}
	public class QCREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.QCREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		
		//@Override
		//QCREF:
		//	(ID '::')* ID (':' ID)?;
		@Override public ParserRule getRule() { return rule; }
		
		//(ID '::')* ID (':' ID)?
		public Group getGroup() { return cGroup; }
		
		//(ID '::')*
		public Group getGroup_0() { return cGroup_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }
		
		//'::'
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }
		
		//(':' ID)?
		public Group getGroup_2() { return cGroup_2; }
		
		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }
	}
	
	public class MetaClassEnumElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.MetaClassEnum");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cCOMPONENTEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cCOMPONENTComponentKeyword_0_0 = (Keyword)cCOMPONENTEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cFEATUREEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cFEATUREFeatureKeyword_1_0 = (Keyword)cFEATUREEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cCONNECTIONEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cCONNECTIONConnectionKeyword_2_0 = (Keyword)cCONNECTIONEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cFLOWEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cFLOWFlowKeyword_3_0 = (Keyword)cFLOWEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cMODEEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cMODEModeKeyword_4_0 = (Keyword)cMODEEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cPROPERTYEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cPROPERTYPropertyKeyword_5_0 = (Keyword)cPROPERTYEnumLiteralDeclaration_5.eContents().get(0);
		
		//enum MetaClassEnum:
		//	COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode'
		//	| PROPERTY='property';
		public EnumRule getRule() { return rule; }
		
		//COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode' | PROPERTY='property'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//COMPONENT='component'
		public EnumLiteralDeclaration getCOMPONENTEnumLiteralDeclaration_0() { return cCOMPONENTEnumLiteralDeclaration_0; }
		
		//'component'
		public Keyword getCOMPONENTComponentKeyword_0_0() { return cCOMPONENTComponentKeyword_0_0; }
		
		//FEATURE='feature'
		public EnumLiteralDeclaration getFEATUREEnumLiteralDeclaration_1() { return cFEATUREEnumLiteralDeclaration_1; }
		
		//'feature'
		public Keyword getFEATUREFeatureKeyword_1_0() { return cFEATUREFeatureKeyword_1_0; }
		
		//CONNECTION='connection'
		public EnumLiteralDeclaration getCONNECTIONEnumLiteralDeclaration_2() { return cCONNECTIONEnumLiteralDeclaration_2; }
		
		//'connection'
		public Keyword getCONNECTIONConnectionKeyword_2_0() { return cCONNECTIONConnectionKeyword_2_0; }
		
		//FLOW='flow'
		public EnumLiteralDeclaration getFLOWEnumLiteralDeclaration_3() { return cFLOWEnumLiteralDeclaration_3; }
		
		//'flow'
		public Keyword getFLOWFlowKeyword_3_0() { return cFLOWFlowKeyword_3_0; }
		
		//MODE='mode'
		public EnumLiteralDeclaration getMODEEnumLiteralDeclaration_4() { return cMODEEnumLiteralDeclaration_4; }
		
		//'mode'
		public Keyword getMODEModeKeyword_4_0() { return cMODEModeKeyword_4_0; }
		
		//PROPERTY='property'
		public EnumLiteralDeclaration getPROPERTYEnumLiteralDeclaration_5() { return cPROPERTYEnumLiteralDeclaration_5; }
		
		//'property'
		public Keyword getPROPERTYPropertyKeyword_5_0() { return cPROPERTYPropertyKeyword_5_0; }
	}
	public class TargetTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.TargetType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cCOMPONENTEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cCOMPONENTComponentKeyword_0_0 = (Keyword)cCOMPONENTEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cFEATUREEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cFEATUREFeatureKeyword_1_0 = (Keyword)cFEATUREEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cCONNECTIONEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cCONNECTIONConnectionKeyword_2_0 = (Keyword)cCONNECTIONEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cFLOWEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cFLOWFlowKeyword_3_0 = (Keyword)cFLOWEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cMODEEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cMODEModeKeyword_4_0 = (Keyword)cMODEEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cELEMENTEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cELEMENTElementKeyword_5_0 = (Keyword)cELEMENTEnumLiteralDeclaration_5.eContents().get(0);
		private final EnumLiteralDeclaration cROOTEnumLiteralDeclaration_6 = (EnumLiteralDeclaration)cAlternatives.eContents().get(6);
		private final Keyword cROOTRootKeyword_6_0 = (Keyword)cROOTEnumLiteralDeclaration_6.eContents().get(0);
		
		//enum TargetType:
		//	COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode' | ELEMENT='element' |
		//	ROOT='root';
		public EnumRule getRule() { return rule; }
		
		//COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode' | ELEMENT='element' |
		//ROOT='root'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//COMPONENT='component'
		public EnumLiteralDeclaration getCOMPONENTEnumLiteralDeclaration_0() { return cCOMPONENTEnumLiteralDeclaration_0; }
		
		//'component'
		public Keyword getCOMPONENTComponentKeyword_0_0() { return cCOMPONENTComponentKeyword_0_0; }
		
		//FEATURE='feature'
		public EnumLiteralDeclaration getFEATUREEnumLiteralDeclaration_1() { return cFEATUREEnumLiteralDeclaration_1; }
		
		//'feature'
		public Keyword getFEATUREFeatureKeyword_1_0() { return cFEATUREFeatureKeyword_1_0; }
		
		//CONNECTION='connection'
		public EnumLiteralDeclaration getCONNECTIONEnumLiteralDeclaration_2() { return cCONNECTIONEnumLiteralDeclaration_2; }
		
		//'connection'
		public Keyword getCONNECTIONConnectionKeyword_2_0() { return cCONNECTIONConnectionKeyword_2_0; }
		
		//FLOW='flow'
		public EnumLiteralDeclaration getFLOWEnumLiteralDeclaration_3() { return cFLOWEnumLiteralDeclaration_3; }
		
		//'flow'
		public Keyword getFLOWFlowKeyword_3_0() { return cFLOWFlowKeyword_3_0; }
		
		//MODE='mode'
		public EnumLiteralDeclaration getMODEEnumLiteralDeclaration_4() { return cMODEEnumLiteralDeclaration_4; }
		
		//'mode'
		public Keyword getMODEModeKeyword_4_0() { return cMODEModeKeyword_4_0; }
		
		//ELEMENT='element'
		public EnumLiteralDeclaration getELEMENTEnumLiteralDeclaration_5() { return cELEMENTEnumLiteralDeclaration_5; }
		
		//'element'
		public Keyword getELEMENTElementKeyword_5_0() { return cELEMENTElementKeyword_5_0; }
		
		//ROOT='root'
		public EnumLiteralDeclaration getROOTEnumLiteralDeclaration_6() { return cROOTEnumLiteralDeclaration_6; }
		
		//'root'
		public Keyword getROOTRootKeyword_6_0() { return cROOTRootKeyword_6_0; }
	}
	public class OperationElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.expr.Expr.Operation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cOREnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cOROrKeyword_0_0 = (Keyword)cOREnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cALT_OREnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cALT_ORVerticalLineVerticalLineKeyword_1_0 = (Keyword)cALT_OREnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cANDEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cANDAndKeyword_2_0 = (Keyword)cANDEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cALT_ANDEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cALT_ANDAmpersandAmpersandKeyword_3_0 = (Keyword)cALT_ANDEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cEQEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cEQEqualsSignEqualsSignKeyword_4_0 = (Keyword)cEQEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cNEQEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cNEQExclamationMarkEqualsSignKeyword_5_0 = (Keyword)cNEQEnumLiteralDeclaration_5.eContents().get(0);
		private final EnumLiteralDeclaration cGEQEnumLiteralDeclaration_6 = (EnumLiteralDeclaration)cAlternatives.eContents().get(6);
		private final Keyword cGEQGreaterThanSignEqualsSignKeyword_6_0 = (Keyword)cGEQEnumLiteralDeclaration_6.eContents().get(0);
		private final EnumLiteralDeclaration cLEQEnumLiteralDeclaration_7 = (EnumLiteralDeclaration)cAlternatives.eContents().get(7);
		private final Keyword cLEQLessThanSignEqualsSignKeyword_7_0 = (Keyword)cLEQEnumLiteralDeclaration_7.eContents().get(0);
		private final EnumLiteralDeclaration cGTEnumLiteralDeclaration_8 = (EnumLiteralDeclaration)cAlternatives.eContents().get(8);
		private final Keyword cGTGreaterThanSignKeyword_8_0 = (Keyword)cGTEnumLiteralDeclaration_8.eContents().get(0);
		private final EnumLiteralDeclaration cLTEnumLiteralDeclaration_9 = (EnumLiteralDeclaration)cAlternatives.eContents().get(9);
		private final Keyword cLTLessThanSignKeyword_9_0 = (Keyword)cLTEnumLiteralDeclaration_9.eContents().get(0);
		private final EnumLiteralDeclaration cINEnumLiteralDeclaration_10 = (EnumLiteralDeclaration)cAlternatives.eContents().get(10);
		private final Keyword cINGreaterThanSignLessThanSignKeyword_10_0 = (Keyword)cINEnumLiteralDeclaration_10.eContents().get(0);
		private final EnumLiteralDeclaration cPLUSEnumLiteralDeclaration_11 = (EnumLiteralDeclaration)cAlternatives.eContents().get(11);
		private final Keyword cPLUSPlusSignKeyword_11_0 = (Keyword)cPLUSEnumLiteralDeclaration_11.eContents().get(0);
		private final EnumLiteralDeclaration cMINUSEnumLiteralDeclaration_12 = (EnumLiteralDeclaration)cAlternatives.eContents().get(12);
		private final Keyword cMINUSHyphenMinusKeyword_12_0 = (Keyword)cMINUSEnumLiteralDeclaration_12.eContents().get(0);
		private final EnumLiteralDeclaration cMULTEnumLiteralDeclaration_13 = (EnumLiteralDeclaration)cAlternatives.eContents().get(13);
		private final Keyword cMULTAsteriskKeyword_13_0 = (Keyword)cMULTEnumLiteralDeclaration_13.eContents().get(0);
		private final EnumLiteralDeclaration cDIVEnumLiteralDeclaration_14 = (EnumLiteralDeclaration)cAlternatives.eContents().get(14);
		private final Keyword cDIVSolidusKeyword_14_0 = (Keyword)cDIVEnumLiteralDeclaration_14.eContents().get(0);
		private final EnumLiteralDeclaration cINTDIVEnumLiteralDeclaration_15 = (EnumLiteralDeclaration)cAlternatives.eContents().get(15);
		private final Keyword cINTDIVDivKeyword_15_0 = (Keyword)cINTDIVEnumLiteralDeclaration_15.eContents().get(0);
		private final EnumLiteralDeclaration cMODEnumLiteralDeclaration_16 = (EnumLiteralDeclaration)cAlternatives.eContents().get(16);
		private final Keyword cMODModKeyword_16_0 = (Keyword)cMODEnumLiteralDeclaration_16.eContents().get(0);
		private final EnumLiteralDeclaration cNOTEnumLiteralDeclaration_17 = (EnumLiteralDeclaration)cAlternatives.eContents().get(17);
		private final Keyword cNOTNotKeyword_17_0 = (Keyword)cNOTEnumLiteralDeclaration_17.eContents().get(0);
		
		//enum Operation:
		//	OR='or' | ALT_OR='||'
		//	| AND='and' | ALT_AND='&&'
		//	| EQ='==' | NEQ='!='
		//	| GEQ='>=' | LEQ='<=' | GT='>' | LT='<' | IN='><'
		//	| PLUS='+' | MINUS='-'
		//	| MULT='*' | DIV='/' | INTDIV='div' | MOD='mod'
		//	| NOT='not';
		public EnumRule getRule() { return rule; }
		
		//OR='or' | ALT_OR='||' | AND='and' | ALT_AND='&&' | EQ='==' | NEQ='!=' | GEQ='>=' | LEQ='<=' | GT='>' | LT='<' | IN='><'
		//| PLUS='+' | MINUS='-' | MULT='*' | DIV='/' | INTDIV='div' | MOD='mod' | NOT='not'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//OR='or'
		public EnumLiteralDeclaration getOREnumLiteralDeclaration_0() { return cOREnumLiteralDeclaration_0; }
		
		//'or'
		public Keyword getOROrKeyword_0_0() { return cOROrKeyword_0_0; }
		
		//ALT_OR='||'
		public EnumLiteralDeclaration getALT_OREnumLiteralDeclaration_1() { return cALT_OREnumLiteralDeclaration_1; }
		
		//'||'
		public Keyword getALT_ORVerticalLineVerticalLineKeyword_1_0() { return cALT_ORVerticalLineVerticalLineKeyword_1_0; }
		
		//AND='and'
		public EnumLiteralDeclaration getANDEnumLiteralDeclaration_2() { return cANDEnumLiteralDeclaration_2; }
		
		//'and'
		public Keyword getANDAndKeyword_2_0() { return cANDAndKeyword_2_0; }
		
		//ALT_AND='&&'
		public EnumLiteralDeclaration getALT_ANDEnumLiteralDeclaration_3() { return cALT_ANDEnumLiteralDeclaration_3; }
		
		//'&&'
		public Keyword getALT_ANDAmpersandAmpersandKeyword_3_0() { return cALT_ANDAmpersandAmpersandKeyword_3_0; }
		
		//EQ='=='
		public EnumLiteralDeclaration getEQEnumLiteralDeclaration_4() { return cEQEnumLiteralDeclaration_4; }
		
		//'=='
		public Keyword getEQEqualsSignEqualsSignKeyword_4_0() { return cEQEqualsSignEqualsSignKeyword_4_0; }
		
		//NEQ='!='
		public EnumLiteralDeclaration getNEQEnumLiteralDeclaration_5() { return cNEQEnumLiteralDeclaration_5; }
		
		//'!='
		public Keyword getNEQExclamationMarkEqualsSignKeyword_5_0() { return cNEQExclamationMarkEqualsSignKeyword_5_0; }
		
		//GEQ='>='
		public EnumLiteralDeclaration getGEQEnumLiteralDeclaration_6() { return cGEQEnumLiteralDeclaration_6; }
		
		//'>='
		public Keyword getGEQGreaterThanSignEqualsSignKeyword_6_0() { return cGEQGreaterThanSignEqualsSignKeyword_6_0; }
		
		//LEQ='<='
		public EnumLiteralDeclaration getLEQEnumLiteralDeclaration_7() { return cLEQEnumLiteralDeclaration_7; }
		
		//'<='
		public Keyword getLEQLessThanSignEqualsSignKeyword_7_0() { return cLEQLessThanSignEqualsSignKeyword_7_0; }
		
		//GT='>'
		public EnumLiteralDeclaration getGTEnumLiteralDeclaration_8() { return cGTEnumLiteralDeclaration_8; }
		
		//'>'
		public Keyword getGTGreaterThanSignKeyword_8_0() { return cGTGreaterThanSignKeyword_8_0; }
		
		//LT='<'
		public EnumLiteralDeclaration getLTEnumLiteralDeclaration_9() { return cLTEnumLiteralDeclaration_9; }
		
		//'<'
		public Keyword getLTLessThanSignKeyword_9_0() { return cLTLessThanSignKeyword_9_0; }
		
		//IN='><'
		public EnumLiteralDeclaration getINEnumLiteralDeclaration_10() { return cINEnumLiteralDeclaration_10; }
		
		//'><'
		public Keyword getINGreaterThanSignLessThanSignKeyword_10_0() { return cINGreaterThanSignLessThanSignKeyword_10_0; }
		
		//PLUS='+'
		public EnumLiteralDeclaration getPLUSEnumLiteralDeclaration_11() { return cPLUSEnumLiteralDeclaration_11; }
		
		//'+'
		public Keyword getPLUSPlusSignKeyword_11_0() { return cPLUSPlusSignKeyword_11_0; }
		
		//MINUS='-'
		public EnumLiteralDeclaration getMINUSEnumLiteralDeclaration_12() { return cMINUSEnumLiteralDeclaration_12; }
		
		//'-'
		public Keyword getMINUSHyphenMinusKeyword_12_0() { return cMINUSHyphenMinusKeyword_12_0; }
		
		//MULT='*'
		public EnumLiteralDeclaration getMULTEnumLiteralDeclaration_13() { return cMULTEnumLiteralDeclaration_13; }
		
		//'*'
		public Keyword getMULTAsteriskKeyword_13_0() { return cMULTAsteriskKeyword_13_0; }
		
		//DIV='/'
		public EnumLiteralDeclaration getDIVEnumLiteralDeclaration_14() { return cDIVEnumLiteralDeclaration_14; }
		
		//'/'
		public Keyword getDIVSolidusKeyword_14_0() { return cDIVSolidusKeyword_14_0; }
		
		//INTDIV='div'
		public EnumLiteralDeclaration getINTDIVEnumLiteralDeclaration_15() { return cINTDIVEnumLiteralDeclaration_15; }
		
		//'div'
		public Keyword getINTDIVDivKeyword_15_0() { return cINTDIVDivKeyword_15_0; }
		
		//MOD='mod'
		public EnumLiteralDeclaration getMODEnumLiteralDeclaration_16() { return cMODEnumLiteralDeclaration_16; }
		
		//'mod'
		public Keyword getMODModKeyword_16_0() { return cMODModKeyword_16_0; }
		
		//NOT='not'
		public EnumLiteralDeclaration getNOTEnumLiteralDeclaration_17() { return cNOTEnumLiteralDeclaration_17; }
		
		//'not'
		public Keyword getNOTNotKeyword_17_0() { return cNOTNotKeyword_17_0; }
	}
	
	private final ExprModelElements pExprModel;
	private final ExprLibraryElements pExprLibrary;
	private final ExprSubclauseElements pExprSubclause;
	private final NamedElementElements pNamedElement;
	private final DeclarationsElements pDeclarations;
	private final EDeclarationElements pEDeclaration;
	private final TypeDeclElements pTypeDecl;
	private final VarDeclElements pVarDecl;
	private final FunDeclElements pFunDecl;
	private final JavaFQNElements pJavaFQN;
	private final ArgsElements pArgs;
	private final ArgumentElements pArgument;
	private final AssertionElements pAssertion;
	private final TypeElements pType;
	private final PrimitiveTypeElements pPrimitiveType;
	private final ENumberTypeElements pENumberType;
	private final EIntegerElements pEInteger;
	private final ERealElements pEReal;
	private final RangeTypeElements pRangeType;
	private final CategoryElements pCategory;
	private final ComponentCategoryElements pComponentCategory;
	private final MetaClassElements pMetaClass;
	private final MetaClassEnumElements eMetaClassEnum;
	private final TargetTypeElements eTargetType;
	private final RecordTypeElements pRecordType;
	private final FieldElements pField;
	private final UnionTypeElements pUnionType;
	private final TupleTypeElements pTupleType;
	private final TupleFieldElements pTupleField;
	private final ListTypeElements pListType;
	private final SetTypeElements pSetType;
	private final BagTypeElements pBagType;
	private final MapTypeElements pMapType;
	private final EnumTypeElements pEnumType;
	private final EnumLiteralElements pEnumLiteral;
	private final TypeRefElements pTypeRef;
	private final OperationElements eOperation;
	private final ExpressionElements pExpression;
	private final BlockExpressionElements pBlockExpression;
	private final OrExpressionElements pOrExpression;
	private final OpOrElements pOpOr;
	private final AndExpressionElements pAndExpression;
	private final OpAndElements pOpAnd;
	private final EqualityExpressionElements pEqualityExpression;
	private final OpEqualityElements pOpEquality;
	private final RelationalExpressionElements pRelationalExpression;
	private final OpCompareElements pOpCompare;
	private final AdditiveExpressionElements pAdditiveExpression;
	private final OpAddElements pOpAdd;
	private final MultiplicativeExpressionElements pMultiplicativeExpression;
	private final OpMultiElements pOpMulti;
	private final UnaryOperationElements pUnaryOperation;
	private final OpUnaryElements pOpUnary;
	private final UnitExpressionElements pUnitExpression;
	private final PropertyExpressionElements pPropertyExpression;
	private final SelectExpressionElements pSelectExpression;
	private final PrimaryExpressionElements pPrimaryExpression;
	private final NamedElementRefElements pNamedElementRef;
	private final RangeExpressionElements pRangeExpression;
	private final IfExpressionElements pIfExpression;
	private final LiteralElements pLiteral;
	private final ValueElements pValue;
	private final WrappedNamedElementElements pWrappedNamedElement;
	private final EBooleanLiteralElements pEBooleanLiteral;
	private final NumberLiteralElements pNumberLiteral;
	private final EIntegerLiteralElements pEIntegerLiteral;
	private final ERealLiteralElements pERealLiteral;
	private final SignedRealElements pSignedReal;
	private final EStringLiteralElements pEStringLiteral;
	private final ExpressionListElements pExpressionList;
	private final ListLiteralElements pListLiteral;
	private final SetLiteralElements pSetLiteral;
	private final RecordLiteralElements pRecordLiteral;
	private final FieldValueElements pFieldValue;
	private final UnionLiteralElements pUnionLiteral;
	private final TupleLiteralElements pTupleLiteral;
	private final BagLiteralElements pBagLiteral;
	private final MapLiteralElements pMapLiteral;
	private final QCREFElements pQCREF;
	
	private final Grammar grammar;
	
	private final PropertiesGrammarAccess gaProperties;

	@Inject
	public ExprGrammarAccess(GrammarProvider grammarProvider,
			PropertiesGrammarAccess gaProperties) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaProperties = gaProperties;
		this.pExprModel = new ExprModelElements();
		this.pExprLibrary = new ExprLibraryElements();
		this.pExprSubclause = new ExprSubclauseElements();
		this.pNamedElement = new NamedElementElements();
		this.pDeclarations = new DeclarationsElements();
		this.pEDeclaration = new EDeclarationElements();
		this.pTypeDecl = new TypeDeclElements();
		this.pVarDecl = new VarDeclElements();
		this.pFunDecl = new FunDeclElements();
		this.pJavaFQN = new JavaFQNElements();
		this.pArgs = new ArgsElements();
		this.pArgument = new ArgumentElements();
		this.pAssertion = new AssertionElements();
		this.pType = new TypeElements();
		this.pPrimitiveType = new PrimitiveTypeElements();
		this.pENumberType = new ENumberTypeElements();
		this.pEInteger = new EIntegerElements();
		this.pEReal = new ERealElements();
		this.pRangeType = new RangeTypeElements();
		this.pCategory = new CategoryElements();
		this.pComponentCategory = new ComponentCategoryElements();
		this.pMetaClass = new MetaClassElements();
		this.eMetaClassEnum = new MetaClassEnumElements();
		this.eTargetType = new TargetTypeElements();
		this.pRecordType = new RecordTypeElements();
		this.pField = new FieldElements();
		this.pUnionType = new UnionTypeElements();
		this.pTupleType = new TupleTypeElements();
		this.pTupleField = new TupleFieldElements();
		this.pListType = new ListTypeElements();
		this.pSetType = new SetTypeElements();
		this.pBagType = new BagTypeElements();
		this.pMapType = new MapTypeElements();
		this.pEnumType = new EnumTypeElements();
		this.pEnumLiteral = new EnumLiteralElements();
		this.pTypeRef = new TypeRefElements();
		this.eOperation = new OperationElements();
		this.pExpression = new ExpressionElements();
		this.pBlockExpression = new BlockExpressionElements();
		this.pOrExpression = new OrExpressionElements();
		this.pOpOr = new OpOrElements();
		this.pAndExpression = new AndExpressionElements();
		this.pOpAnd = new OpAndElements();
		this.pEqualityExpression = new EqualityExpressionElements();
		this.pOpEquality = new OpEqualityElements();
		this.pRelationalExpression = new RelationalExpressionElements();
		this.pOpCompare = new OpCompareElements();
		this.pAdditiveExpression = new AdditiveExpressionElements();
		this.pOpAdd = new OpAddElements();
		this.pMultiplicativeExpression = new MultiplicativeExpressionElements();
		this.pOpMulti = new OpMultiElements();
		this.pUnaryOperation = new UnaryOperationElements();
		this.pOpUnary = new OpUnaryElements();
		this.pUnitExpression = new UnitExpressionElements();
		this.pPropertyExpression = new PropertyExpressionElements();
		this.pSelectExpression = new SelectExpressionElements();
		this.pPrimaryExpression = new PrimaryExpressionElements();
		this.pNamedElementRef = new NamedElementRefElements();
		this.pRangeExpression = new RangeExpressionElements();
		this.pIfExpression = new IfExpressionElements();
		this.pLiteral = new LiteralElements();
		this.pValue = new ValueElements();
		this.pWrappedNamedElement = new WrappedNamedElementElements();
		this.pEBooleanLiteral = new EBooleanLiteralElements();
		this.pNumberLiteral = new NumberLiteralElements();
		this.pEIntegerLiteral = new EIntegerLiteralElements();
		this.pERealLiteral = new ERealLiteralElements();
		this.pSignedReal = new SignedRealElements();
		this.pEStringLiteral = new EStringLiteralElements();
		this.pExpressionList = new ExpressionListElements();
		this.pListLiteral = new ListLiteralElements();
		this.pSetLiteral = new SetLiteralElements();
		this.pRecordLiteral = new RecordLiteralElements();
		this.pFieldValue = new FieldValueElements();
		this.pUnionLiteral = new UnionLiteralElements();
		this.pTupleLiteral = new TupleLiteralElements();
		this.pBagLiteral = new BagLiteralElements();
		this.pMapLiteral = new MapLiteralElements();
		this.pQCREF = new QCREFElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.expr.Expr".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public PropertiesGrammarAccess getPropertiesGrammarAccess() {
		return gaProperties;
	}

	
	//// for testing
	//ExprModel:
	//	'library' annex=ExprLibrary
	//	| 'subclause' annex=ExprSubclause;
	public ExprModelElements getExprModelAccess() {
		return pExprModel;
	}
	
	public ParserRule getExprModelRule() {
		return getExprModelAccess().getRule();
	}
	
	//ExprLibrary aadl2::AnnexLibrary:
	//	{ExprLibrary} Declarations?;
	public ExprLibraryElements getExprLibraryAccess() {
		return pExprLibrary;
	}
	
	public ParserRule getExprLibraryRule() {
		return getExprLibraryAccess().getRule();
	}
	
	//ExprSubclause aadl2::AnnexSubclause:
	//	{ExprSubclause} Declarations?;
	public ExprSubclauseElements getExprSubclauseAccess() {
		return pExprSubclause;
	}
	
	public ParserRule getExprSubclauseRule() {
		return getExprSubclauseAccess().getRule();
	}
	
	//NamedElement aadl2::NamedElement:
	//	ExprLibrary | ExprSubclause | EDeclaration | Argument | Field;
	public NamedElementElements getNamedElementAccess() {
		return pNamedElement;
	}
	
	public ParserRule getNamedElementRule() {
		return getNamedElementAccess().getRule();
	}
	
	//fragment Declarations *:
	//	decls+=EDeclaration (';' decls+=EDeclaration)* ';'?;
	public DeclarationsElements getDeclarationsAccess() {
		return pDeclarations;
	}
	
	public ParserRule getDeclarationsRule() {
		return getDeclarationsAccess().getRule();
	}
	
	//EDeclaration:
	//	TypeDecl | VarDecl | FunDecl | Assertion;
	public EDeclarationElements getEDeclarationAccess() {
		return pEDeclaration;
	}
	
	public ParserRule getEDeclarationRule() {
		return getEDeclarationAccess().getRule();
	}
	
	//TypeDecl:
	//	'type' name=ID /*('extends' baseType=Type)?*/ ':' type=Type ('{'
	//	ownedPropertyAssociations+=PropertyAssociation (';' ownedPropertyAssociations+=PropertyAssociation)*
	//	'}')?;
	public TypeDeclElements getTypeDeclAccess() {
		return pTypeDecl;
	}
	
	public ParserRule getTypeDeclRule() {
		return getTypeDeclAccess().getRule();
	}
	
	//VarDecl:
	//	(const?='val' | 'var') name=ID (':' declType=Type)? ('=' value=Expression)?;
	public VarDeclElements getVarDeclAccess() {
		return pVarDecl;
	}
	
	public ParserRule getVarDeclRule() {
		return getVarDeclAccess().getRule();
	}
	
	//FunDecl:
	//	'def' name=ID '(' Args ')' ':' resultType=Type ('=' (java?='java' ':' fqn=JavaFQN | exp=Expression))?;
	public FunDeclElements getFunDeclAccess() {
		return pFunDecl;
	}
	
	public ParserRule getFunDeclRule() {
		return getFunDeclAccess().getRule();
	}
	
	//JavaFQN:
	//	ID ('.' ID)*;
	public JavaFQNElements getJavaFQNAccess() {
		return pJavaFQN;
	}
	
	public ParserRule getJavaFQNRule() {
		return getJavaFQNAccess().getRule();
	}
	
	//fragment Args *:
	//	(args+=Argument (',' args+=Argument)*)?;
	public ArgsElements getArgsAccess() {
		return pArgs;
	}
	
	public ParserRule getArgsRule() {
		return getArgsAccess().getRule();
	}
	
	//Argument:
	//	{Argument} name=ID ':' type=Type;
	public ArgumentElements getArgumentAccess() {
		return pArgument;
	}
	
	public ParserRule getArgumentRule() {
		return getArgumentAccess().getRule();
	}
	
	//Assertion:
	//	'assert' name=ID ':' assert=Expression;
	public AssertionElements getAssertionAccess() {
		return pAssertion;
	}
	
	public ParserRule getAssertionRule() {
		return getAssertionAccess().getRule();
	}
	
	//// Types
	//Type aadl2::Type:
	//	PrimitiveType | RangeType | Category | MetaClass
	//	| RecordType | UnionType | TupleType | ListType | SetType | BagType | MapType
	//	| EnumType | TypeRef;
	public TypeElements getTypeAccess() {
		return pType;
	}
	
	public ParserRule getTypeRule() {
		return getTypeAccess().getRule();
	}
	
	//PrimitiveType aadl2::Type:
	//	{EBoolean} 'bool' | ENumberType | {EString} 'string';
	public PrimitiveTypeElements getPrimitiveTypeAccess() {
		return pPrimitiveType;
	}
	
	public ParserRule getPrimitiveTypeRule() {
		return getPrimitiveTypeAccess().getRule();
	}
	
	//ENumberType:
	//	EInteger | EReal;
	public ENumberTypeElements getENumberTypeAccess() {
		return pENumberType;
	}
	
	public ParserRule getENumberTypeRule() {
		return getENumberTypeAccess().getRule();
	}
	
	//EInteger:
	//	{EInteger} 'int';
	public EIntegerElements getEIntegerAccess() {
		return pEInteger;
	}
	
	public ParserRule getEIntegerRule() {
		return getEIntegerAccess().getRule();
	}
	
	//EReal:
	//	{EReal} 'real';
	public ERealElements getERealAccess() {
		return pEReal;
	}
	
	public ParserRule getERealRule() {
		return getERealAccess().getRule();
	}
	
	//RangeType:
	//	'range' 'of' type=Type;
	public RangeTypeElements getRangeTypeAccess() {
		return pRangeType;
	}
	
	public ParserRule getRangeTypeRule() {
		return getRangeTypeAccess().getRule();
	}
	
	//Category:
	//	category=ComponentCategory;
	public CategoryElements getCategoryAccess() {
		return pCategory;
	}
	
	public ParserRule getCategoryRule() {
		return getCategoryAccess().getRule();
	}
	
	//ComponentCategory aadl2::ComponentCategory:
	//	'abstract' | 'bus' | 'data' | 'device' | 'memory' | 'process' | 'processor' | 'subprogram'
	//	| 'subprogram' 'group' | 'system' | 'thread' 'group' | 'thread'
	//	| 'virtual' 'bus' | 'virtual' 'processor';
	public ComponentCategoryElements getComponentCategoryAccess() {
		return pComponentCategory;
	}
	
	public ParserRule getComponentCategoryRule() {
		return getComponentCategoryAccess().getRule();
	}
	
	//// TODO: should support real meta class references
	//MetaClass:
	//	class=MetaClassEnum;
	public MetaClassElements getMetaClassAccess() {
		return pMetaClass;
	}
	
	public ParserRule getMetaClassRule() {
		return getMetaClassAccess().getRule();
	}
	
	//enum MetaClassEnum:
	//	COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode'
	//	| PROPERTY='property';
	public MetaClassEnumElements getMetaClassEnumAccess() {
		return eMetaClassEnum;
	}
	
	public EnumRule getMetaClassEnumRule() {
		return getMetaClassEnumAccess().getRule();
	}
	
	//enum TargetType:
	//	COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode' | ELEMENT='element' |
	//	ROOT='root';
	public TargetTypeElements getTargetTypeAccess() {
		return eTargetType;
	}
	
	public EnumRule getTargetTypeRule() {
		return getTargetTypeAccess().getRule();
	}
	
	//RecordType:
	//	{RecordType} 'record' '{' (fields+=Field (',' fields+=Field)*)?
	//	'}';
	public RecordTypeElements getRecordTypeAccess() {
		return pRecordType;
	}
	
	public ParserRule getRecordTypeRule() {
		return getRecordTypeAccess().getRule();
	}
	
	//Field:
	//	{Field} name=ID ':' type=Type;
	public FieldElements getFieldAccess() {
		return pField;
	}
	
	public ParserRule getFieldRule() {
		return getFieldAccess().getRule();
	}
	
	//UnionType:
	//	{UnionType} 'union' '{' (fields+=Field (',' fields+=Field)*)?
	//	'}';
	public UnionTypeElements getUnionTypeAccess() {
		return pUnionType;
	}
	
	public ParserRule getUnionTypeRule() {
		return getUnionTypeAccess().getRule();
	}
	
	//TupleType:
	//	{TupleType} 'tuple' '{' (fields+=TupleField (',' fields+=TupleField)*)?
	//	'}';
	public TupleTypeElements getTupleTypeAccess() {
		return pTupleType;
	}
	
	public ParserRule getTupleTypeRule() {
		return getTupleTypeAccess().getRule();
	}
	
	//TupleField Field:
	//	type=Type;
	public TupleFieldElements getTupleFieldAccess() {
		return pTupleField;
	}
	
	public ParserRule getTupleFieldRule() {
		return getTupleFieldAccess().getRule();
	}
	
	//ListType:
	//	'list' 'of' type=Type;
	public ListTypeElements getListTypeAccess() {
		return pListType;
	}
	
	public ParserRule getListTypeRule() {
		return getListTypeAccess().getRule();
	}
	
	//SetType:
	//	'set' 'of' type=Type;
	public SetTypeElements getSetTypeAccess() {
		return pSetType;
	}
	
	public ParserRule getSetTypeRule() {
		return getSetTypeAccess().getRule();
	}
	
	//BagType:
	//	'bag' 'of' type=Type;
	public BagTypeElements getBagTypeAccess() {
		return pBagType;
	}
	
	public ParserRule getBagTypeRule() {
		return getBagTypeAccess().getRule();
	}
	
	//MapType:
	//	'map' domain=Type '->' image=Type;
	public MapTypeElements getMapTypeAccess() {
		return pMapType;
	}
	
	public ParserRule getMapTypeRule() {
		return getMapTypeAccess().getRule();
	}
	
	//EnumType:
	//	{EnumType} 'enum' '{' (literals+=EnumLiteral (',' literals+=EnumLiteral)*)?
	//	'}';
	public EnumTypeElements getEnumTypeAccess() {
		return pEnumType;
	}
	
	public ParserRule getEnumTypeRule() {
		return getEnumTypeAccess().getRule();
	}
	
	//EnumLiteral:
	//	name=ID;
	public EnumLiteralElements getEnumLiteralAccess() {
		return pEnumLiteral;
	}
	
	public ParserRule getEnumLiteralRule() {
		return getEnumLiteralAccess().getRule();
	}
	
	//TypeRef:
	//	ref=[aadl2::NamedElement|QCREF];
	public TypeRefElements getTypeRefAccess() {
		return pTypeRef;
	}
	
	public ParserRule getTypeRefRule() {
		return getTypeRefAccess().getRule();
	}
	
	//enum Operation:
	//	OR='or' | ALT_OR='||'
	//	| AND='and' | ALT_AND='&&'
	//	| EQ='==' | NEQ='!='
	//	| GEQ='>=' | LEQ='<=' | GT='>' | LT='<' | IN='><'
	//	| PLUS='+' | MINUS='-'
	//	| MULT='*' | DIV='/' | INTDIV='div' | MOD='mod'
	//	| NOT='not';
	public OperationElements getOperationAccess() {
		return eOperation;
	}
	
	public EnumRule getOperationRule() {
		return getOperationAccess().getRule();
	}
	
	//Expression:
	//	OrExpression
	//	| BlockExpression;
	public ExpressionElements getExpressionAccess() {
		return pExpression;
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}
	
	//BlockExpression Expression:
	//	{Block} '{' (decls+=VarDecl ';')*
	//	result=Expression
	//	'}';
	public BlockExpressionElements getBlockExpressionAccess() {
		return pBlockExpression;
	}
	
	public ParserRule getBlockExpressionRule() {
		return getBlockExpressionAccess().getRule();
	}
	
	//OrExpression Expression:
	//	AndExpression (=> ({BinaryOperation.left=current} operator=OpOr) right=AndExpression)*;
	public OrExpressionElements getOrExpressionAccess() {
		return pOrExpression;
	}
	
	public ParserRule getOrExpressionRule() {
		return getOrExpressionAccess().getRule();
	}
	
	//OpOr Operation:
	//	'or' | '||';
	public OpOrElements getOpOrAccess() {
		return pOpOr;
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}
	
	//AndExpression Expression:
	//	EqualityExpression (=> ({BinaryOperation.left=current} operator=OpAnd) right=EqualityExpression)*;
	public AndExpressionElements getAndExpressionAccess() {
		return pAndExpression;
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}
	
	//OpAnd Operation:
	//	'and' | '&&';
	public OpAndElements getOpAndAccess() {
		return pOpAnd;
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}
	
	//EqualityExpression Expression:
	//	RelationalExpression (=> ({BinaryOperation.left=current} operator=OpEquality) right=RelationalExpression)*;
	public EqualityExpressionElements getEqualityExpressionAccess() {
		return pEqualityExpression;
	}
	
	public ParserRule getEqualityExpressionRule() {
		return getEqualityExpressionAccess().getRule();
	}
	
	//OpEquality Operation:
	//	'==' | '!=';
	public OpEqualityElements getOpEqualityAccess() {
		return pOpEquality;
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}
	
	//RelationalExpression Expression:
	//	AdditiveExpression (=> ({BinaryOperation.left=current} operator=OpCompare) right=AdditiveExpression)*;
	public RelationalExpressionElements getRelationalExpressionAccess() {
		return pRelationalExpression;
	}
	
	public ParserRule getRelationalExpressionRule() {
		return getRelationalExpressionAccess().getRule();
	}
	
	//OpCompare Operation:
	//	'>=' | '<=' | '>' | '<' | '><';
	public OpCompareElements getOpCompareAccess() {
		return pOpCompare;
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}
	
	////OtherOperatorExpression returns aadl2::PropertyExpression:
	////	AdditiveExpression (=>({ABinaryOperation.leftOperand=current} feature=OpOther)
	////	rightOperand=AAdditiveExpression)*;
	////
	////OpOther:
	////	  '->' 
	////	| '..<'
	////	| '>' '..'
	////	| '..'
	////	| '=>' 
	////	| '>' (=>('>' '>') | '>') 
	////	| '<' (=>('<' '<') | '<' | '=>')
	////	| '<>'
	////	| '?:';
	//AdditiveExpression Expression:
	//	MultiplicativeExpression (=> ({BinaryOperation.left=current} operator=OpAdd) right=MultiplicativeExpression)*;
	public AdditiveExpressionElements getAdditiveExpressionAccess() {
		return pAdditiveExpression;
	}
	
	public ParserRule getAdditiveExpressionRule() {
		return getAdditiveExpressionAccess().getRule();
	}
	
	//OpAdd Operation:
	//	'+' | '-';
	public OpAddElements getOpAddAccess() {
		return pOpAdd;
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}
	
	//MultiplicativeExpression Expression:
	//	UnaryOperation (=> ({BinaryOperation.left=current} operator=OpMulti) right=UnaryOperation)*;
	public MultiplicativeExpressionElements getMultiplicativeExpressionAccess() {
		return pMultiplicativeExpression;
	}
	
	public ParserRule getMultiplicativeExpressionRule() {
		return getMultiplicativeExpressionAccess().getRule();
	}
	
	//OpMulti Operation:
	//	'*' | '/' | 'div' | 'mod';
	public OpMultiElements getOpMultiAccess() {
		return pOpMulti;
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}
	
	//UnaryOperation Expression:
	//	{UnaryOperation} => operator=OpUnary operand=UnitExpression
	//	| UnitExpression;
	public UnaryOperationElements getUnaryOperationAccess() {
		return pUnaryOperation;
	}
	
	public ParserRule getUnaryOperationRule() {
		return getUnaryOperationAccess().getRule();
	}
	
	//OpUnary Operation:
	//	"not" | "-" | "+";
	public OpUnaryElements getOpUnaryAccess() {
		return pOpUnary;
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}
	
	//UnitExpression Expression:
	//	PropertyExpression ({UnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?;
	public UnitExpressionElements getUnitExpressionAccess() {
		return pUnitExpression;
	}
	
	public ParserRule getUnitExpressionRule() {
		return getUnitExpressionAccess().getRule();
	}
	
	//@Override
	//PropertyExpression Expression:
	//	SelectExpression (=> ({PropertyExpression.modelElement=current} '#') property=[aadl2::AbstractNamedValue|QPREF])?;
	public PropertyExpressionElements getPropertyExpressionAccess() {
		return pPropertyExpression;
	}
	
	public ParserRule getPropertyExpressionRule() {
		return getPropertyExpressionAccess().getRule();
	}
	
	//SelectExpression Expression:
	//	PrimaryExpression
	//	=> ({Selection.receiver=current} '.'
	//	ref=[aadl2::NamedElement|QCREF] ('(' (args+=Expression (',' args+=Expression)*)? ')')?)*;
	public SelectExpressionElements getSelectExpressionAccess() {
		return pSelectExpression;
	}
	
	public ParserRule getSelectExpressionRule() {
		return getSelectExpressionAccess().getRule();
	}
	
	//PrimaryExpression Expression:
	//	NamedElementRef
	//	| RangeExpression | IfExpression
	//	| Literal | '(' Expression ')';
	public PrimaryExpressionElements getPrimaryExpressionAccess() {
		return pPrimaryExpression;
	}
	
	public ParserRule getPrimaryExpressionRule() {
		return getPrimaryExpressionAccess().getRule();
	}
	
	//NamedElementRef:
	//	core?='^'?
	//	ref=[aadl2::NamedElement|QCREF] ('(' (args+=Expression (',' args+=Expression)*)? ')')?;
	public NamedElementRefElements getNamedElementRefAccess() {
		return pNamedElementRef;
	}
	
	public ParserRule getNamedElementRefRule() {
		return getNamedElementRefAccess().getRule();
	}
	
	//RangeExpression Expression:
	//	{Range} '[' minimum=Expression '..' maximum=Expression (=> 'delta' delta=Expression)? ']';
	public RangeExpressionElements getRangeExpressionAccess() {
		return pRangeExpression;
	}
	
	public ParserRule getRangeExpressionRule() {
		return getRangeExpressionAccess().getRule();
	}
	
	//IfExpression Expression:
	//	{Conditional} 'if' if=Expression 'then' then=Expression ('else' else=Expression)? 'endif';
	public IfExpressionElements getIfExpressionAccess() {
		return pIfExpression;
	}
	
	public ParserRule getIfExpressionRule() {
		return getIfExpressionAccess().getRule();
	}
	
	//// literal values
	//Literal:
	//	EBooleanLiteral | NumberLiteral | EStringLiteral
	//	| ListLiteral | SetLiteral | RecordLiteral | UnionLiteral | TupleLiteral
	//	| BagLiteral | MapLiteral;
	public LiteralElements getLiteralAccess() {
		return pLiteral;
	}
	
	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}
	
	//Value:
	//	Literal | WrappedNamedElement;
	public ValueElements getValueAccess() {
		return pValue;
	}
	
	public ParserRule getValueRule() {
		return getValueAccess().getRule();
	}
	
	//// dummy rule
	//WrappedNamedElement:
	//	{WrappedNamedElement} elem=[aadl2::NamedElement];
	public WrappedNamedElementElements getWrappedNamedElementAccess() {
		return pWrappedNamedElement;
	}
	
	public ParserRule getWrappedNamedElementRule() {
		return getWrappedNamedElementAccess().getRule();
	}
	
	//EBooleanLiteral Literal:
	//	{EBooleanLiteral} (value?='true' | 'false');
	public EBooleanLiteralElements getEBooleanLiteralAccess() {
		return pEBooleanLiteral;
	}
	
	public ParserRule getEBooleanLiteralRule() {
		return getEBooleanLiteralAccess().getRule();
	}
	
	//NumberLiteral Literal:
	//	EIntegerLiteral | ERealLiteral;
	public NumberLiteralElements getNumberLiteralAccess() {
		return pNumberLiteral;
	}
	
	public ParserRule getNumberLiteralRule() {
		return getNumberLiteralAccess().getRule();
	}
	
	//EIntegerLiteral NumberLiteral:
	//	{EIntegerLiteral} value=INTVALUE
	//	//	('<'unit=UnitTerm'>')?
	//;
	public EIntegerLiteralElements getEIntegerLiteralAccess() {
		return pEIntegerLiteral;
	}
	
	public ParserRule getEIntegerLiteralRule() {
		return getEIntegerLiteralAccess().getRule();
	}
	
	//ERealLiteral NumberLiteral:
	//	{ERealLiteral} value=SignedReal
	//	//	('<'unit=UnitTerm'>')?
	//;
	public ERealLiteralElements getERealLiteralAccess() {
		return pERealLiteral;
	}
	
	public ParserRule getERealLiteralRule() {
		return getERealLiteralAccess().getRule();
	}
	
	//@Override
	//SignedReal aadl2::Real:
	//	REAL_LIT;
	public SignedRealElements getSignedRealAccess() {
		return pSignedReal;
	}
	
	public ParserRule getSignedRealRule() {
		return getSignedRealAccess().getRule();
	}
	
	//EStringLiteral Literal:
	//	{EStringLiteral} value=NoQuoteString;
	public EStringLiteralElements getEStringLiteralAccess() {
		return pEStringLiteral;
	}
	
	public ParserRule getEStringLiteralRule() {
		return getEStringLiteralAccess().getRule();
	}
	
	//fragment ExpressionList *:
	//	'(' (elements+=Expression (',' elements+=Expression)*)? ')';
	public ExpressionListElements getExpressionListAccess() {
		return pExpressionList;
	}
	
	public ParserRule getExpressionListRule() {
		return getExpressionListAccess().getRule();
	}
	
	//ListLiteral Literal:
	//	{ListLiteral} 'list' ExpressionList;
	public ListLiteralElements getListLiteralAccess() {
		return pListLiteral;
	}
	
	public ParserRule getListLiteralRule() {
		return getListLiteralAccess().getRule();
	}
	
	//SetLiteral Literal:
	//	{SetLiteral} 'set' ExpressionList;
	public SetLiteralElements getSetLiteralAccess() {
		return pSetLiteral;
	}
	
	public ParserRule getSetLiteralRule() {
		return getSetLiteralAccess().getRule();
	}
	
	//RecordLiteral Literal:
	//	{RecordLiteral} 'record' '(' (fieldValues+=FieldValue (',' fieldValues+=FieldValue)*)?
	//	')';
	public RecordLiteralElements getRecordLiteralAccess() {
		return pRecordLiteral;
	}
	
	public ParserRule getRecordLiteralRule() {
		return getRecordLiteralAccess().getRule();
	}
	
	//FieldValue:
	//	name=ID ':' value=Expression;
	public FieldValueElements getFieldValueAccess() {
		return pFieldValue;
	}
	
	public ParserRule getFieldValueRule() {
		return getFieldValueAccess().getRule();
	}
	
	//UnionLiteral Literal:
	//	{UnionLiteral} 'union' '('
	//	fieldValue=FieldValue
	//	')';
	public UnionLiteralElements getUnionLiteralAccess() {
		return pUnionLiteral;
	}
	
	public ParserRule getUnionLiteralRule() {
		return getUnionLiteralAccess().getRule();
	}
	
	//TupleLiteral Literal:
	//	{TupleLiteral} 'tuple' ExpressionList;
	public TupleLiteralElements getTupleLiteralAccess() {
		return pTupleLiteral;
	}
	
	public ParserRule getTupleLiteralRule() {
		return getTupleLiteralAccess().getRule();
	}
	
	//BagLiteral Literal:
	//	{BagLiteral} 'bag' ExpressionList;
	public BagLiteralElements getBagLiteralAccess() {
		return pBagLiteral;
	}
	
	public ParserRule getBagLiteralRule() {
		return getBagLiteralAccess().getRule();
	}
	
	//MapLiteral Literal:
	//	{MapLiteral} 'map';
	public MapLiteralElements getMapLiteralAccess() {
		return pMapLiteral;
	}
	
	public ParserRule getMapLiteralRule() {
		return getMapLiteralAccess().getRule();
	}
	
	//@Override
	//QCREF:
	//	(ID '::')* ID (':' ID)?;
	public QCREFElements getQCREFAccess() {
		return pQCREF;
	}
	
	public ParserRule getQCREFRule() {
		return getQCREFAccess().getRule();
	}
	
	//PModel aadl2::Element:
	//	ContainedPropertyAssociation //| BasicPropertyAssociation | PropertyAssociation
	//;
	public PropertiesGrammarAccess.PModelElements getPModelAccess() {
		return gaProperties.getPModelAccess();
	}
	
	public ParserRule getPModelRule() {
		return getPModelAccess().getRule();
	}
	
	//// Properties
	//ContainedPropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
	//	(',' ownedValue+=OptionalModalPropertyValue)*) (AppliesToKeywords appliesTo+=ContainmentPath (','
	//	appliesTo+=ContainmentPath)*)? (InBindingKeywords '(' inBinding+=[aadl2::Classifier|super::QCREF] ')')?
	//	';';
	public PropertiesGrammarAccess.ContainedPropertyAssociationElements getContainedPropertyAssociationAccess() {
		return gaProperties.getContainedPropertyAssociationAccess();
	}
	
	public ParserRule getContainedPropertyAssociationRule() {
		return getContainedPropertyAssociationAccess().getRule();
	}
	
	//PropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
	//	(',' ownedValue+=OptionalModalPropertyValue)*) (InBindingKeywords '(' inBinding+=[aadl2::Classifier|super::QCREF]
	//	')')?
	//	';';
	public PropertiesGrammarAccess.PropertyAssociationElements getPropertyAssociationAccess() {
		return gaProperties.getPropertyAssociationAccess();
	}
	
	public ParserRule getPropertyAssociationRule() {
		return getPropertyAssociationAccess().getRule();
	}
	
	//BasicPropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF]
	//	'=>' ownedValue+=PropertyValue ';';
	public PropertiesGrammarAccess.BasicPropertyAssociationElements getBasicPropertyAssociationAccess() {
		return gaProperties.getBasicPropertyAssociationAccess();
	}
	
	public ParserRule getBasicPropertyAssociationRule() {
		return getBasicPropertyAssociationAccess().getRule();
	}
	
	//ContainmentPath aadl2::ContainedNamedElement:
	//	path=ContainmentPathElement
	//	//	( 'annex' containmentPathElement+=AnnexPath )?
	//;
	public PropertiesGrammarAccess.ContainmentPathElements getContainmentPathAccess() {
		return gaProperties.getContainmentPathAccess();
	}
	
	public ParserRule getContainmentPathRule() {
		return getContainmentPathAccess().getRule();
	}
	
	////AnnexPath returns aadl2::ContainmentPathElement:
	////	 namedElement=[aadl2::NamedElement|IDANNEXTEXT];
	//ModalPropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=super::PropertyExpression
	//	InModesKeywords '('
	//	inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])*
	//	')';
	public PropertiesGrammarAccess.ModalPropertyValueElements getModalPropertyValueAccess() {
		return gaProperties.getModalPropertyValueAccess();
	}
	
	public ParserRule getModalPropertyValueRule() {
		return getModalPropertyValueAccess().getRule();
	}
	
	//OptionalModalPropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=super::PropertyExpression (InModesKeywords '('
	//	inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])*
	//	')')?;
	public PropertiesGrammarAccess.OptionalModalPropertyValueElements getOptionalModalPropertyValueAccess() {
		return gaProperties.getOptionalModalPropertyValueAccess();
	}
	
	public ParserRule getOptionalModalPropertyValueRule() {
		return getOptionalModalPropertyValueAccess().getRule();
	}
	
	//// &&&&&&&&&& handling of in binding
	//PropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=super::PropertyExpression;
	public PropertiesGrammarAccess.PropertyValueElements getPropertyValueAccess() {
		return gaProperties.getPropertyValueAccess();
	}
	
	public ParserRule getPropertyValueRule() {
		return getPropertyValueAccess().getRule();
	}
	
	//LiteralorReferenceTerm aadl2::NamedValue:
	//	namedValue=[aadl2::AbstractNamedValue|QPREF];
	public PropertiesGrammarAccess.LiteralorReferenceTermElements getLiteralorReferenceTermAccess() {
		return gaProperties.getLiteralorReferenceTermAccess();
	}
	
	public ParserRule getLiteralorReferenceTermRule() {
		return getLiteralorReferenceTermAccess().getRule();
	}
	
	//BooleanLiteral aadl2::BooleanLiteral:
	//	{aadl2::BooleanLiteral} (value?='true' | 'false');
	public PropertiesGrammarAccess.BooleanLiteralElements getBooleanLiteralAccess() {
		return gaProperties.getBooleanLiteralAccess();
	}
	
	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}
	
	//ConstantValue aadl2::NamedValue:
	//	namedValue=[aadl2::PropertyConstant|QPREF];
	public PropertiesGrammarAccess.ConstantValueElements getConstantValueAccess() {
		return gaProperties.getConstantValueAccess();
	}
	
	public ParserRule getConstantValueRule() {
		return getConstantValueAccess().getRule();
	}
	
	//ReferenceTerm aadl2::ReferenceValue:
	//	'reference' '('
	//	path=ContainmentPathElement
	//	//	( 'annex' ID '{**' 
	//	//	containmentPathElement+=ContainmentPathElement
	//	//	( '.' containmentPathElement+=ContainmentPathElement)*
	//	//	'**}')?
	//	')';
	public PropertiesGrammarAccess.ReferenceTermElements getReferenceTermAccess() {
		return gaProperties.getReferenceTermAccess();
	}
	
	public ParserRule getReferenceTermRule() {
		return getReferenceTermAccess().getRule();
	}
	
	//RecordTerm aadl2::RecordValue:
	//	'['
	//	ownedFieldValue+=FieldPropertyAssociation+
	//	']';
	public PropertiesGrammarAccess.RecordTermElements getRecordTermAccess() {
		return gaProperties.getRecordTermAccess();
	}
	
	public ParserRule getRecordTermRule() {
		return getRecordTermAccess().getRule();
	}
	
	//OldRecordTerm aadl2::RecordValue:
	//	'('
	//	ownedFieldValue+=FieldPropertyAssociation+
	//	')';
	public PropertiesGrammarAccess.OldRecordTermElements getOldRecordTermAccess() {
		return gaProperties.getOldRecordTermAccess();
	}
	
	public ParserRule getOldRecordTermRule() {
		return getOldRecordTermAccess().getRule();
	}
	
	//ComputedTerm aadl2::ComputedValue:
	//	'compute' '('
	//	function=ID
	//	')';
	public PropertiesGrammarAccess.ComputedTermElements getComputedTermAccess() {
		return gaProperties.getComputedTermAccess();
	}
	
	public ParserRule getComputedTermRule() {
		return getComputedTermAccess().getRule();
	}
	
	//ComponentClassifierTerm aadl2::ClassifierValue:
	//	'classifier' '('
	//	classifier=[aadl2::ComponentClassifier|super::QCREF]
	//	')';
	public PropertiesGrammarAccess.ComponentClassifierTermElements getComponentClassifierTermAccess() {
		return gaProperties.getComponentClassifierTermAccess();
	}
	
	public ParserRule getComponentClassifierTermRule() {
		return getComponentClassifierTermAccess().getRule();
	}
	
	//ListTerm aadl2::ListValue:
	//	{aadl2::ListValue}
	//	'(' (ownedListElement+=super::PropertyExpression (',' ownedListElement+=super::PropertyExpression)*)?
	//	')';
	public PropertiesGrammarAccess.ListTermElements getListTermAccess() {
		return gaProperties.getListTermAccess();
	}
	
	public ParserRule getListTermRule() {
		return getListTermAccess().getRule();
	}
	
	//FieldPropertyAssociation aadl2::BasicPropertyAssociation:
	//	property=[aadl2::BasicProperty]
	//	'=>'
	//	ownedValue=super::PropertyExpression
	//	';';
	public PropertiesGrammarAccess.FieldPropertyAssociationElements getFieldPropertyAssociationAccess() {
		return gaProperties.getFieldPropertyAssociationAccess();
	}
	
	public ParserRule getFieldPropertyAssociationRule() {
		return getFieldPropertyAssociationAccess().getRule();
	}
	
	//// from AADL2
	//// need to add annex path element
	//ContainmentPathElement aadl2::ContainmentPathElement:
	//	(namedElement=[aadl2::NamedElement] arrayRange+=ArrayRange*) ('.' path=ContainmentPathElement)?
	//	//	 | 	 'annex' namedElement=[aadl2::NamedElement|ID]
	//;
	public PropertiesGrammarAccess.ContainmentPathElementElements getContainmentPathElementAccess() {
		return gaProperties.getContainmentPathElementAccess();
	}
	
	public ParserRule getContainmentPathElementRule() {
		return getContainmentPathElementAccess().getRule();
	}
	
	//ANNEXREF: // check what values are ok inside ** **
	//	'{' STAR STAR ID STAR STAR '}';
	public PropertiesGrammarAccess.ANNEXREFElements getANNEXREFAccess() {
		return gaProperties.getANNEXREFAccess();
	}
	
	public ParserRule getANNEXREFRule() {
		return getANNEXREFAccess().getRule();
	}
	
	//PlusMinus aadl2::OperationKind:
	//	'+' | '-';
	public PropertiesGrammarAccess.PlusMinusElements getPlusMinusAccess() {
		return gaProperties.getPlusMinusAccess();
	}
	
	public ParserRule getPlusMinusRule() {
		return getPlusMinusAccess().getRule();
	}
	
	//StringTerm aadl2::StringLiteral:
	//	value=NoQuoteString;
	public PropertiesGrammarAccess.StringTermElements getStringTermAccess() {
		return gaProperties.getStringTermAccess();
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}
	
	//NoQuoteString:
	//	STRING;
	public PropertiesGrammarAccess.NoQuoteStringElements getNoQuoteStringAccess() {
		return gaProperties.getNoQuoteStringAccess();
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}
	
	//ArrayRange aadl2::ArrayRange:
	//	{aadl2::ArrayRange}
	//	'[' lowerBound=INTVALUE ('..' upperBound=INTVALUE)?
	//	']';
	public PropertiesGrammarAccess.ArrayRangeElements getArrayRangeAccess() {
		return gaProperties.getArrayRangeAccess();
	}
	
	public ParserRule getArrayRangeRule() {
		return getArrayRangeAccess().getRule();
	}
	
	//SignedConstant aadl2::Operation:
	//	op=PlusMinus ownedPropertyExpression+=ConstantValue;
	public PropertiesGrammarAccess.SignedConstantElements getSignedConstantAccess() {
		return gaProperties.getSignedConstantAccess();
	}
	
	public ParserRule getSignedConstantRule() {
		return getSignedConstantAccess().getRule();
	}
	
	//IntegerTerm aadl2::IntegerLiteral:
	//	value=SignedInt unit=[aadl2::UnitLiteral]?;
	public PropertiesGrammarAccess.IntegerTermElements getIntegerTermAccess() {
		return gaProperties.getIntegerTermAccess();
	}
	
	public ParserRule getIntegerTermRule() {
		return getIntegerTermAccess().getRule();
	}
	
	//SignedInt aadl2::Integer:
	//	('+' | '-')? INTEGER_LIT;
	public PropertiesGrammarAccess.SignedIntElements getSignedIntAccess() {
		return gaProperties.getSignedIntAccess();
	}
	
	public ParserRule getSignedIntRule() {
		return getSignedIntAccess().getRule();
	}
	
	//RealTerm aadl2::RealLiteral:
	//	value=super::SignedReal unit=[aadl2::UnitLiteral]?;
	public PropertiesGrammarAccess.RealTermElements getRealTermAccess() {
		return gaProperties.getRealTermAccess();
	}
	
	public ParserRule getRealTermRule() {
		return getRealTermAccess().getRule();
	}
	
	//NumericRangeTerm aadl2::RangeValue:
	//	minimum=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
	//	'..' maximum=NumAlt ('delta' delta=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//)?;
	public PropertiesGrammarAccess.NumericRangeTermElements getNumericRangeTermAccess() {
		return gaProperties.getNumericRangeTermAccess();
	}
	
	public ParserRule getNumericRangeTermRule() {
		return getNumericRangeTermAccess().getRule();
	}
	
	//NumAlt aadl2::PropertyExpression:
	//	RealTerm | IntegerTerm | SignedConstant | ConstantValue;
	public PropertiesGrammarAccess.NumAltElements getNumAltAccess() {
		return gaProperties.getNumAltAccess();
	}
	
	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}
	
	//AppliesToKeywords:
	//	'applies' 'to';
	public PropertiesGrammarAccess.AppliesToKeywordsElements getAppliesToKeywordsAccess() {
		return gaProperties.getAppliesToKeywordsAccess();
	}
	
	public ParserRule getAppliesToKeywordsRule() {
		return getAppliesToKeywordsAccess().getRule();
	}
	
	//InBindingKeywords:
	//	'in' 'binding';
	public PropertiesGrammarAccess.InBindingKeywordsElements getInBindingKeywordsAccess() {
		return gaProperties.getInBindingKeywordsAccess();
	}
	
	public ParserRule getInBindingKeywordsRule() {
		return getInBindingKeywordsAccess().getRule();
	}
	
	//InModesKeywords:
	//	'in' 'modes';
	public PropertiesGrammarAccess.InModesKeywordsElements getInModesKeywordsAccess() {
		return gaProperties.getInModesKeywordsAccess();
	}
	
	public ParserRule getInModesKeywordsRule() {
		return getInModesKeywordsAccess().getRule();
	}
	
	//terminal SL_COMMENT:
	//	'--' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaProperties.getSL_COMMENTRule();
	}
	
	//INTVALUE aadl2::Integer:
	//	INTEGER_LIT //NUMERAL 	
	//;
	public PropertiesGrammarAccess.INTVALUEElements getINTVALUEAccess() {
		return gaProperties.getINTVALUEAccess();
	}
	
	public ParserRule getINTVALUERule() {
		return getINTVALUEAccess().getRule();
	}
	
	//terminal fragment EXPONENT:
	//	('e' | 'E') ('+' | '-')? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return gaProperties.getEXPONENTRule();
	}
	
	//terminal fragment INT_EXPONENT:
	//	('e' | 'E') '+'? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return gaProperties.getINT_EXPONENTRule();
	}
	
	//terminal REAL_LIT:
	//	DIGIT+ ('_' DIGIT+)* ('.' DIGIT+ ('_' DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return gaProperties.getREAL_LITRule();
	}
	
	//terminal INTEGER_LIT:
	//	DIGIT+ ('_' DIGIT+)* ('#' BASED_INTEGER '#' INT_EXPONENT? | INT_EXPONENT?);
	public TerminalRule getINTEGER_LITRule() {
		return gaProperties.getINTEGER_LITRule();
	}
	
	//terminal fragment DIGIT:
	//	'0'..'9';
	public TerminalRule getDIGITRule() {
		return gaProperties.getDIGITRule();
	}
	
	//terminal fragment EXTENDED_DIGIT:
	//	'0'..'9' | 'a'..'f' | 'A'..'F';
	public TerminalRule getEXTENDED_DIGITRule() {
		return gaProperties.getEXTENDED_DIGITRule();
	}
	
	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ('_'? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return gaProperties.getBASED_INTEGERRule();
	}
	
	//QCLREF:
	//	ID '::' ID;
	public PropertiesGrammarAccess.QCLREFElements getQCLREFAccess() {
		return gaProperties.getQCLREFAccess();
	}
	
	public ParserRule getQCLREFRule() {
		return getQCLREFAccess().getRule();
	}
	
	//QPREF:
	//	ID ('::' ID)?;
	public PropertiesGrammarAccess.QPREFElements getQPREFAccess() {
		return gaProperties.getQPREFAccess();
	}
	
	public ParserRule getQPREFRule() {
		return getQPREFAccess().getRule();
	}
	
	//STAR:
	//	'*';
	public PropertiesGrammarAccess.STARElements getSTARAccess() {
		return gaProperties.getSTARAccess();
	}
	
	public ParserRule getSTARRule() {
		return getSTARAccess().getRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\') | !('\\' | '"'))* '"' |
	//	"'" ('\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\') | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaProperties.getSTRINGRule();
	}
	
	//terminal ID:
	//	('a'..'z'
	//	| 'A'..'Z') ('_'? ('a'..'z'
	//	| 'A'..'Z'
	//	| '0'..'9'))*;
	public TerminalRule getIDRule() {
		return gaProperties.getIDRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaProperties.getWSRule();
	}
}
