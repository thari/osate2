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
parser grammar InternalExprParser;

options {
	tokenVocab=InternalExprLexer;
	superClass=AbstractInternalAntlrParser;
}

@header {
package org.osate.expr.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.expr.services.ExprGrammarAccess;

}

@members {

 	private ExprGrammarAccess grammarAccess;

    public InternalExprParser(TokenStream input, ExprGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "ExprModel";
   	}

   	@Override
   	protected ExprGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleExprModel
entryRuleExprModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExprModelRule()); }
	iv_ruleExprModel=ruleExprModel
	{ $current=$iv_ruleExprModel.current; }
	EOF;

// Rule ExprModel
ruleExprModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			otherlv_0=Library
			{
				newLeafNode(otherlv_0, grammarAccess.getExprModelAccess().getLibraryKeyword_0_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getExprModelAccess().getAnnexExprLibraryParserRuleCall_0_1_0());
					}
					lv_annex_1_0=ruleExprLibrary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExprModelRule());
						}
						set(
							$current,
							"annex",
							lv_annex_1_0,
							"org.osate.expr.Expr.ExprLibrary");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		(
			otherlv_2=Subclause
			{
				newLeafNode(otherlv_2, grammarAccess.getExprModelAccess().getSubclauseKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getExprModelAccess().getAnnexExprSubclauseParserRuleCall_1_1_0());
					}
					lv_annex_3_0=ruleExprSubclause
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExprModelRule());
						}
						set(
							$current,
							"annex",
							lv_annex_3_0,
							"org.osate.expr.Expr.ExprSubclause");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleExprLibrary
entryRuleExprLibrary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExprLibraryRule()); }
	iv_ruleExprLibrary=ruleExprLibrary
	{ $current=$iv_ruleExprLibrary.current; }
	EOF;

// Rule ExprLibrary
ruleExprLibrary returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getExprLibraryAccess().getExprLibraryAction_0(),
					$current);
			}
		)
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getExprLibraryRule());
				}
				newCompositeNode(grammarAccess.getExprLibraryAccess().getDeclarationsParserRuleCall_1());
			}
			this_Declarations_1=ruleDeclarations[$current]
			{
				$current = $this_Declarations_1.current;
				afterParserOrEnumRuleCall();
			}
		)?
	)
;

// Entry rule entryRuleExprSubclause
entryRuleExprSubclause returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExprSubclauseRule()); }
	iv_ruleExprSubclause=ruleExprSubclause
	{ $current=$iv_ruleExprSubclause.current; }
	EOF;

// Rule ExprSubclause
ruleExprSubclause returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getExprSubclauseAccess().getExprSubclauseAction_0(),
					$current);
			}
		)
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getExprSubclauseRule());
				}
				newCompositeNode(grammarAccess.getExprSubclauseAccess().getDeclarationsParserRuleCall_1());
			}
			this_Declarations_1=ruleDeclarations[$current]
			{
				$current = $this_Declarations_1.current;
				afterParserOrEnumRuleCall();
			}
		)?
	)
;


// Rule Declarations
ruleDeclarations[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getDeclarationsAccess().getDeclsEDeclarationParserRuleCall_0_0());
				}
				lv_decls_0_0=ruleEDeclaration
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeclarationsRule());
					}
					add(
						$current,
						"decls",
						lv_decls_0_0,
						"org.osate.expr.Expr.EDeclaration");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=Semicolon
			{
				newLeafNode(otherlv_1, grammarAccess.getDeclarationsAccess().getSemicolonKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeclarationsAccess().getDeclsEDeclarationParserRuleCall_1_1_0());
					}
					lv_decls_2_0=ruleEDeclaration
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeclarationsRule());
						}
						add(
							$current,
							"decls",
							lv_decls_2_0,
							"org.osate.expr.Expr.EDeclaration");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		(
			otherlv_3=Semicolon
			{
				newLeafNode(otherlv_3, grammarAccess.getDeclarationsAccess().getSemicolonKeyword_2());
			}
		)?
	)
;

// Entry rule entryRuleEDeclaration
entryRuleEDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEDeclarationRule()); }
	iv_ruleEDeclaration=ruleEDeclaration
	{ $current=$iv_ruleEDeclaration.current; }
	EOF;

// Rule EDeclaration
ruleEDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEDeclarationAccess().getTypeDeclParserRuleCall_0());
		}
		this_TypeDecl_0=ruleTypeDecl
		{
			$current = $this_TypeDecl_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEDeclarationAccess().getVarDeclParserRuleCall_1());
		}
		this_VarDecl_1=ruleVarDecl
		{
			$current = $this_VarDecl_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEDeclarationAccess().getFunDeclParserRuleCall_2());
		}
		this_FunDecl_2=ruleFunDecl
		{
			$current = $this_FunDecl_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getEDeclarationAccess().getAssertionParserRuleCall_3());
		}
		this_Assertion_3=ruleAssertion
		{
			$current = $this_Assertion_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleTypeDecl
entryRuleTypeDecl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeDeclRule()); }
	iv_ruleTypeDecl=ruleTypeDecl
	{ $current=$iv_ruleTypeDecl.current; }
	EOF;

// Rule TypeDecl
ruleTypeDecl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Type
		{
			newLeafNode(otherlv_0, grammarAccess.getTypeDeclAccess().getTypeKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getTypeDeclAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypeDeclRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2=Colon
		{
			newLeafNode(otherlv_2, grammarAccess.getTypeDeclAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeDeclAccess().getTypeTypeParserRuleCall_3_0());
				}
				lv_type_3_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeDeclRule());
					}
					set(
						$current,
						"type",
						lv_type_3_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=LeftCurlyBracket
			{
				newLeafNode(otherlv_4, grammarAccess.getTypeDeclAccess().getLeftCurlyBracketKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTypeDeclAccess().getOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_1_0());
					}
					lv_ownedPropertyAssociations_5_0=rulePropertyAssociation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTypeDeclRule());
						}
						add(
							$current,
							"ownedPropertyAssociations",
							lv_ownedPropertyAssociations_5_0,
							"org.osate.xtext.aadl2.properties.Properties.PropertyAssociation");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_6=Semicolon
				{
					newLeafNode(otherlv_6, grammarAccess.getTypeDeclAccess().getSemicolonKeyword_4_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTypeDeclAccess().getOwnedPropertyAssociationsPropertyAssociationParserRuleCall_4_2_1_0());
						}
						lv_ownedPropertyAssociations_7_0=rulePropertyAssociation
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTypeDeclRule());
							}
							add(
								$current,
								"ownedPropertyAssociations",
								lv_ownedPropertyAssociations_7_0,
								"org.osate.xtext.aadl2.properties.Properties.PropertyAssociation");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_8=RightCurlyBracket
			{
				newLeafNode(otherlv_8, grammarAccess.getTypeDeclAccess().getRightCurlyBracketKeyword_4_3());
			}
		)?
	)
;

// Entry rule entryRuleVarDecl
entryRuleVarDecl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVarDeclRule()); }
	iv_ruleVarDecl=ruleVarDecl
	{ $current=$iv_ruleVarDecl.current; }
	EOF;

// Rule VarDecl
ruleVarDecl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					lv_const_0_0=Val
					{
						newLeafNode(lv_const_0_0, grammarAccess.getVarDeclAccess().getConstValKeyword_0_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getVarDeclRule());
						}
						setWithLastConsumed($current, "const", true, "val");
					}
				)
			)
			    |
			otherlv_1=Var
			{
				newLeafNode(otherlv_1, grammarAccess.getVarDeclAccess().getVarKeyword_0_1());
			}
		)
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getVarDeclAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getVarDeclRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		(
			otherlv_3=Colon
			{
				newLeafNode(otherlv_3, grammarAccess.getVarDeclAccess().getColonKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getVarDeclAccess().getDeclTypeTypeParserRuleCall_2_1_0());
					}
					lv_declType_4_0=ruleType
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getVarDeclRule());
						}
						set(
							$current,
							"declType",
							lv_declType_4_0,
							"org.osate.expr.Expr.Type");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_5=EqualsSign
			{
				newLeafNode(otherlv_5, grammarAccess.getVarDeclAccess().getEqualsSignKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getVarDeclAccess().getValueExpressionParserRuleCall_3_1_0());
					}
					lv_value_6_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getVarDeclRule());
						}
						set(
							$current,
							"value",
							lv_value_6_0,
							"org.osate.expr.Expr.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleFunDecl
entryRuleFunDecl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFunDeclRule()); }
	iv_ruleFunDecl=ruleFunDecl
	{ $current=$iv_ruleFunDecl.current; }
	EOF;

// Rule FunDecl
ruleFunDecl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Def
		{
			newLeafNode(otherlv_0, grammarAccess.getFunDeclAccess().getDefKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFunDeclAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFunDeclRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getFunDeclAccess().getLeftParenthesisKeyword_2());
		}
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getFunDeclRule());
			}
			newCompositeNode(grammarAccess.getFunDeclAccess().getArgsParserRuleCall_3());
		}
		this_Args_3=ruleArgs[$current]
		{
			$current = $this_Args_3.current;
			afterParserOrEnumRuleCall();
		}
		otherlv_4=RightParenthesis
		{
			newLeafNode(otherlv_4, grammarAccess.getFunDeclAccess().getRightParenthesisKeyword_4());
		}
		otherlv_5=Colon
		{
			newLeafNode(otherlv_5, grammarAccess.getFunDeclAccess().getColonKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFunDeclAccess().getResultTypeTypeParserRuleCall_6_0());
				}
				lv_resultType_6_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFunDeclRule());
					}
					set(
						$current,
						"resultType",
						lv_resultType_6_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_7=EqualsSign
			{
				newLeafNode(otherlv_7, grammarAccess.getFunDeclAccess().getEqualsSignKeyword_7_0());
			}
			(
				(
					(
						(
							lv_java_8_0=Java
							{
								newLeafNode(lv_java_8_0, grammarAccess.getFunDeclAccess().getJavaJavaKeyword_7_1_0_0_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getFunDeclRule());
								}
								setWithLastConsumed($current, "java", true, "java");
							}
						)
					)
					otherlv_9=Colon
					{
						newLeafNode(otherlv_9, grammarAccess.getFunDeclAccess().getColonKeyword_7_1_0_1());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getFunDeclAccess().getFqnJavaFQNParserRuleCall_7_1_0_2_0());
							}
							lv_fqn_10_0=ruleJavaFQN
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getFunDeclRule());
								}
								set(
									$current,
									"fqn",
									lv_fqn_10_0,
									"org.osate.expr.Expr.JavaFQN");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
				    |
				(
					(
						{
							newCompositeNode(grammarAccess.getFunDeclAccess().getExpExpressionParserRuleCall_7_1_1_0());
						}
						lv_exp_11_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getFunDeclRule());
							}
							set(
								$current,
								"exp",
								lv_exp_11_0,
								"org.osate.expr.Expr.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
		)?
	)
;

// Entry rule entryRuleJavaFQN
entryRuleJavaFQN returns [String current=null]:
	{ newCompositeNode(grammarAccess.getJavaFQNRule()); }
	iv_ruleJavaFQN=ruleJavaFQN
	{ $current=$iv_ruleJavaFQN.current.getText(); }
	EOF;

// Rule JavaFQN
ruleJavaFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getJavaFQNAccess().getIDTerminalRuleCall_0());
		}
		(
			kw=FullStop
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getJavaFQNAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getJavaFQNAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;


// Rule Args
ruleArgs[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getArgsAccess().getArgsArgumentParserRuleCall_0_0());
				}
				lv_args_0_0=ruleArgument
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getArgsRule());
					}
					add(
						$current,
						"args",
						lv_args_0_0,
						"org.osate.expr.Expr.Argument");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=Comma
			{
				newLeafNode(otherlv_1, grammarAccess.getArgsAccess().getCommaKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getArgsAccess().getArgsArgumentParserRuleCall_1_1_0());
					}
					lv_args_2_0=ruleArgument
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getArgsRule());
						}
						add(
							$current,
							"args",
							lv_args_2_0,
							"org.osate.expr.Expr.Argument");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)?
;

// Entry rule entryRuleArgument
entryRuleArgument returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArgumentRule()); }
	iv_ruleArgument=ruleArgument
	{ $current=$iv_ruleArgument.current; }
	EOF;

// Rule Argument
ruleArgument returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getArgumentAccess().getArgumentAction_0(),
					$current);
			}
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getArgumentRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2=Colon
		{
			newLeafNode(otherlv_2, grammarAccess.getArgumentAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getArgumentAccess().getTypeTypeParserRuleCall_3_0());
				}
				lv_type_3_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getArgumentRule());
					}
					set(
						$current,
						"type",
						lv_type_3_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleAssertion
entryRuleAssertion returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssertionRule()); }
	iv_ruleAssertion=ruleAssertion
	{ $current=$iv_ruleAssertion.current; }
	EOF;

// Rule Assertion
ruleAssertion returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Assert
		{
			newLeafNode(otherlv_0, grammarAccess.getAssertionAccess().getAssertKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getAssertionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAssertionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2=Colon
		{
			newLeafNode(otherlv_2, grammarAccess.getAssertionAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAssertionAccess().getAssertExpressionParserRuleCall_3_0());
				}
				lv_assert_3_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssertionRule());
					}
					set(
						$current,
						"assert",
						lv_assert_3_0,
						"org.osate.expr.Expr.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleType
entryRuleType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeRule()); }
	iv_ruleType=ruleType
	{ $current=$iv_ruleType.current; }
	EOF;

// Rule Type
ruleType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0());
		}
		this_PrimitiveType_0=rulePrimitiveType
		{
			$current = $this_PrimitiveType_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getRangeTypeParserRuleCall_1());
		}
		this_RangeType_1=ruleRangeType
		{
			$current = $this_RangeType_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getCategoryParserRuleCall_2());
		}
		this_Category_2=ruleCategory
		{
			$current = $this_Category_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getMetaClassParserRuleCall_3());
		}
		this_MetaClass_3=ruleMetaClass
		{
			$current = $this_MetaClass_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getRecordTypeParserRuleCall_4());
		}
		this_RecordType_4=ruleRecordType
		{
			$current = $this_RecordType_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getUnionTypeParserRuleCall_5());
		}
		this_UnionType_5=ruleUnionType
		{
			$current = $this_UnionType_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getTupleTypeParserRuleCall_6());
		}
		this_TupleType_6=ruleTupleType
		{
			$current = $this_TupleType_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getListTypeParserRuleCall_7());
		}
		this_ListType_7=ruleListType
		{
			$current = $this_ListType_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getSetTypeParserRuleCall_8());
		}
		this_SetType_8=ruleSetType
		{
			$current = $this_SetType_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getBagTypeParserRuleCall_9());
		}
		this_BagType_9=ruleBagType
		{
			$current = $this_BagType_9.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getMapTypeParserRuleCall_10());
		}
		this_MapType_10=ruleMapType
		{
			$current = $this_MapType_10.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getEnumTypeParserRuleCall_11());
		}
		this_EnumType_11=ruleEnumType
		{
			$current = $this_EnumType_11.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTypeAccess().getTypeRefParserRuleCall_12());
		}
		this_TypeRef_12=ruleTypeRef
		{
			$current = $this_TypeRef_12.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePrimitiveType
entryRulePrimitiveType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeRule()); }
	iv_rulePrimitiveType=rulePrimitiveType
	{ $current=$iv_rulePrimitiveType.current; }
	EOF;

// Rule PrimitiveType
rulePrimitiveType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getPrimitiveTypeAccess().getEBooleanAction_0_0(),
						$current);
				}
			)
			otherlv_1=Bool
			{
				newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getBoolKeyword_0_1());
			}
		)
		    |
		{
			newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getENumberTypeParserRuleCall_1());
		}
		this_ENumberType_2=ruleENumberType
		{
			$current = $this_ENumberType_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getPrimitiveTypeAccess().getEStringAction_2_0(),
						$current);
				}
			)
			otherlv_4=String
			{
				newLeafNode(otherlv_4, grammarAccess.getPrimitiveTypeAccess().getStringKeyword_2_1());
			}
		)
	)
;

// Entry rule entryRuleENumberType
entryRuleENumberType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getENumberTypeRule()); }
	iv_ruleENumberType=ruleENumberType
	{ $current=$iv_ruleENumberType.current; }
	EOF;

// Rule ENumberType
ruleENumberType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getENumberTypeAccess().getEIntegerParserRuleCall_0());
		}
		this_EInteger_0=ruleEInteger
		{
			$current = $this_EInteger_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getENumberTypeAccess().getERealParserRuleCall_1());
		}
		this_EReal_1=ruleEReal
		{
			$current = $this_EReal_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleEInteger
entryRuleEInteger returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEIntegerRule()); }
	iv_ruleEInteger=ruleEInteger
	{ $current=$iv_ruleEInteger.current; }
	EOF;

// Rule EInteger
ruleEInteger returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getEIntegerAccess().getEIntegerAction_0(),
					$current);
			}
		)
		otherlv_1=Int
		{
			newLeafNode(otherlv_1, grammarAccess.getEIntegerAccess().getIntKeyword_1());
		}
	)
;

// Entry rule entryRuleEReal
entryRuleEReal returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getERealRule()); }
	iv_ruleEReal=ruleEReal
	{ $current=$iv_ruleEReal.current; }
	EOF;

// Rule EReal
ruleEReal returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getERealAccess().getERealAction_0(),
					$current);
			}
		)
		otherlv_1=Real
		{
			newLeafNode(otherlv_1, grammarAccess.getERealAccess().getRealKeyword_1());
		}
	)
;

// Entry rule entryRuleRangeType
entryRuleRangeType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRangeTypeRule()); }
	iv_ruleRangeType=ruleRangeType
	{ $current=$iv_ruleRangeType.current; }
	EOF;

// Rule RangeType
ruleRangeType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Range
		{
			newLeafNode(otherlv_0, grammarAccess.getRangeTypeAccess().getRangeKeyword_0());
		}
		otherlv_1=Of
		{
			newLeafNode(otherlv_1, grammarAccess.getRangeTypeAccess().getOfKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRangeTypeAccess().getTypeTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRangeTypeRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleCategory
entryRuleCategory returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCategoryRule()); }
	iv_ruleCategory=ruleCategory
	{ $current=$iv_ruleCategory.current; }
	EOF;

// Rule Category
ruleCategory returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getCategoryAccess().getCategoryComponentCategoryParserRuleCall_0());
			}
			lv_category_0_0=ruleComponentCategory
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getCategoryRule());
				}
				set(
					$current,
					"category",
					lv_category_0_0,
					"org.osate.expr.Expr.ComponentCategory");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleComponentCategory
entryRuleComponentCategory returns [String current=null]:
	{ newCompositeNode(grammarAccess.getComponentCategoryRule()); }
	iv_ruleComponentCategory=ruleComponentCategory
	{ $current=$iv_ruleComponentCategory.current.getText(); }
	EOF;

// Rule ComponentCategory
ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=Abstract
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0());
		}
		    |
		kw=Bus
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1());
		}
		    |
		kw=Data
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2());
		}
		    |
		kw=Device
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3());
		}
		    |
		kw=Memory
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4());
		}
		    |
		kw=Process
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5());
		}
		    |
		kw=Processor
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6());
		}
		    |
		kw=Subprogram
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7());
		}
		    |
		(
			kw=Subprogram
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0());
			}
			kw=Group
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1());
			}
		)
		    |
		kw=KW_System
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9());
		}
		    |
		(
			kw=Thread
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0());
			}
			kw=Group
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1());
			}
		)
		    |
		kw=Thread
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11());
		}
		    |
		(
			kw=Virtual
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0());
			}
			kw=Bus
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1());
			}
		)
		    |
		(
			kw=Virtual
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0());
			}
			kw=Processor
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1());
			}
		)
	)
;

// Entry rule entryRuleMetaClass
entryRuleMetaClass returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMetaClassRule()); }
	iv_ruleMetaClass=ruleMetaClass
	{ $current=$iv_ruleMetaClass.current; }
	EOF;

// Rule MetaClass
ruleMetaClass returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getMetaClassAccess().getClassMetaClassEnumEnumRuleCall_0());
			}
			lv_class_0_0=ruleMetaClassEnum
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getMetaClassRule());
				}
				set(
					$current,
					"class",
					lv_class_0_0,
					"org.osate.expr.Expr.MetaClassEnum");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleRecordType
entryRuleRecordType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRecordTypeRule()); }
	iv_ruleRecordType=ruleRecordType
	{ $current=$iv_ruleRecordType.current; }
	EOF;

// Rule RecordType
ruleRecordType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getRecordTypeAccess().getRecordTypeAction_0(),
					$current);
			}
		)
		otherlv_1=Record
		{
			newLeafNode(otherlv_1, grammarAccess.getRecordTypeAccess().getRecordKeyword_1());
		}
		otherlv_2=LeftCurlyBracket
		{
			newLeafNode(otherlv_2, grammarAccess.getRecordTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getRecordTypeAccess().getFieldsFieldParserRuleCall_3_0_0());
					}
					lv_fields_3_0=ruleField
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRecordTypeRule());
						}
						add(
							$current,
							"fields",
							lv_fields_3_0,
							"org.osate.expr.Expr.Field");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getRecordTypeAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getRecordTypeAccess().getFieldsFieldParserRuleCall_3_1_1_0());
						}
						lv_fields_5_0=ruleField
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRecordTypeRule());
							}
							add(
								$current,
								"fields",
								lv_fields_5_0,
								"org.osate.expr.Expr.Field");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=RightCurlyBracket
		{
			newLeafNode(otherlv_6, grammarAccess.getRecordTypeAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleField
entryRuleField returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFieldRule()); }
	iv_ruleField=ruleField
	{ $current=$iv_ruleField.current; }
	EOF;

// Rule Field
ruleField returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getFieldAccess().getFieldAction_0(),
					$current);
			}
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getFieldAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFieldRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_2=Colon
		{
			newLeafNode(otherlv_2, grammarAccess.getFieldAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFieldAccess().getTypeTypeParserRuleCall_3_0());
				}
				lv_type_3_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFieldRule());
					}
					set(
						$current,
						"type",
						lv_type_3_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleUnionType
entryRuleUnionType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnionTypeRule()); }
	iv_ruleUnionType=ruleUnionType
	{ $current=$iv_ruleUnionType.current; }
	EOF;

// Rule UnionType
ruleUnionType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getUnionTypeAccess().getUnionTypeAction_0(),
					$current);
			}
		)
		otherlv_1=Union
		{
			newLeafNode(otherlv_1, grammarAccess.getUnionTypeAccess().getUnionKeyword_1());
		}
		otherlv_2=LeftCurlyBracket
		{
			newLeafNode(otherlv_2, grammarAccess.getUnionTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getUnionTypeAccess().getFieldsFieldParserRuleCall_3_0_0());
					}
					lv_fields_3_0=ruleField
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getUnionTypeRule());
						}
						add(
							$current,
							"fields",
							lv_fields_3_0,
							"org.osate.expr.Expr.Field");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getUnionTypeAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getUnionTypeAccess().getFieldsFieldParserRuleCall_3_1_1_0());
						}
						lv_fields_5_0=ruleField
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getUnionTypeRule());
							}
							add(
								$current,
								"fields",
								lv_fields_5_0,
								"org.osate.expr.Expr.Field");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=RightCurlyBracket
		{
			newLeafNode(otherlv_6, grammarAccess.getUnionTypeAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleTupleType
entryRuleTupleType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTupleTypeRule()); }
	iv_ruleTupleType=ruleTupleType
	{ $current=$iv_ruleTupleType.current; }
	EOF;

// Rule TupleType
ruleTupleType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getTupleTypeAccess().getTupleTypeAction_0(),
					$current);
			}
		)
		otherlv_1=Tuple
		{
			newLeafNode(otherlv_1, grammarAccess.getTupleTypeAccess().getTupleKeyword_1());
		}
		otherlv_2=LeftCurlyBracket
		{
			newLeafNode(otherlv_2, grammarAccess.getTupleTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getTupleTypeAccess().getFieldsTupleFieldParserRuleCall_3_0_0());
					}
					lv_fields_3_0=ruleTupleField
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTupleTypeRule());
						}
						add(
							$current,
							"fields",
							lv_fields_3_0,
							"org.osate.expr.Expr.TupleField");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getTupleTypeAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getTupleTypeAccess().getFieldsTupleFieldParserRuleCall_3_1_1_0());
						}
						lv_fields_5_0=ruleTupleField
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getTupleTypeRule());
							}
							add(
								$current,
								"fields",
								lv_fields_5_0,
								"org.osate.expr.Expr.TupleField");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=RightCurlyBracket
		{
			newLeafNode(otherlv_6, grammarAccess.getTupleTypeAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleTupleField
entryRuleTupleField returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTupleFieldRule()); }
	iv_ruleTupleField=ruleTupleField
	{ $current=$iv_ruleTupleField.current; }
	EOF;

// Rule TupleField
ruleTupleField returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getTupleFieldAccess().getTypeTypeParserRuleCall_0());
			}
			lv_type_0_0=ruleType
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getTupleFieldRule());
				}
				set(
					$current,
					"type",
					lv_type_0_0,
					"org.osate.expr.Expr.Type");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleListType
entryRuleListType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getListTypeRule()); }
	iv_ruleListType=ruleListType
	{ $current=$iv_ruleListType.current; }
	EOF;

// Rule ListType
ruleListType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=List
		{
			newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0());
		}
		otherlv_1=Of
		{
			newLeafNode(otherlv_1, grammarAccess.getListTypeAccess().getOfKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getListTypeAccess().getTypeTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getListTypeRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleSetType
entryRuleSetType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSetTypeRule()); }
	iv_ruleSetType=ruleSetType
	{ $current=$iv_ruleSetType.current; }
	EOF;

// Rule SetType
ruleSetType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Set
		{
			newLeafNode(otherlv_0, grammarAccess.getSetTypeAccess().getSetKeyword_0());
		}
		otherlv_1=Of
		{
			newLeafNode(otherlv_1, grammarAccess.getSetTypeAccess().getOfKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSetTypeAccess().getTypeTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSetTypeRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBagType
entryRuleBagType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBagTypeRule()); }
	iv_ruleBagType=ruleBagType
	{ $current=$iv_ruleBagType.current; }
	EOF;

// Rule BagType
ruleBagType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Bag
		{
			newLeafNode(otherlv_0, grammarAccess.getBagTypeAccess().getBagKeyword_0());
		}
		otherlv_1=Of
		{
			newLeafNode(otherlv_1, grammarAccess.getBagTypeAccess().getOfKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getBagTypeAccess().getTypeTypeParserRuleCall_2_0());
				}
				lv_type_2_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBagTypeRule());
					}
					set(
						$current,
						"type",
						lv_type_2_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleMapType
entryRuleMapType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMapTypeRule()); }
	iv_ruleMapType=ruleMapType
	{ $current=$iv_ruleMapType.current; }
	EOF;

// Rule MapType
ruleMapType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=Map
		{
			newLeafNode(otherlv_0, grammarAccess.getMapTypeAccess().getMapKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMapTypeAccess().getDomainTypeParserRuleCall_1_0());
				}
				lv_domain_1_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMapTypeRule());
					}
					set(
						$current,
						"domain",
						lv_domain_1_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=HyphenMinusGreaterThanSign
		{
			newLeafNode(otherlv_2, grammarAccess.getMapTypeAccess().getHyphenMinusGreaterThanSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMapTypeAccess().getImageTypeParserRuleCall_3_0());
				}
				lv_image_3_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMapTypeRule());
					}
					set(
						$current,
						"image",
						lv_image_3_0,
						"org.osate.expr.Expr.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleEnumType
entryRuleEnumType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumTypeRule()); }
	iv_ruleEnumType=ruleEnumType
	{ $current=$iv_ruleEnumType.current; }
	EOF;

// Rule EnumType
ruleEnumType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getEnumTypeAccess().getEnumTypeAction_0(),
					$current);
			}
		)
		otherlv_1=Enum
		{
			newLeafNode(otherlv_1, grammarAccess.getEnumTypeAccess().getEnumKeyword_1());
		}
		otherlv_2=LeftCurlyBracket
		{
			newLeafNode(otherlv_2, grammarAccess.getEnumTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralParserRuleCall_3_0_0());
					}
					lv_literals_3_0=ruleEnumLiteral
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEnumTypeRule());
						}
						add(
							$current,
							"literals",
							lv_literals_3_0,
							"org.osate.expr.Expr.EnumLiteral");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getEnumTypeAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralParserRuleCall_3_1_1_0());
						}
						lv_literals_5_0=ruleEnumLiteral
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getEnumTypeRule());
							}
							add(
								$current,
								"literals",
								lv_literals_5_0,
								"org.osate.expr.Expr.EnumLiteral");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=RightCurlyBracket
		{
			newLeafNode(otherlv_6, grammarAccess.getEnumTypeAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleEnumLiteral
entryRuleEnumLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEnumLiteralRule()); }
	iv_ruleEnumLiteral=ruleEnumLiteral
	{ $current=$iv_ruleEnumLiteral.current; }
	EOF;

// Rule EnumLiteral
ruleEnumLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getEnumLiteralRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.osate.xtext.aadl2.properties.Properties.ID");
			}
		)
	)
;

// Entry rule entryRuleTypeRef
entryRuleTypeRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeRefRule()); }
	iv_ruleTypeRef=ruleTypeRef
	{ $current=$iv_ruleTypeRef.current; }
	EOF;

// Rule TypeRef
ruleTypeRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getTypeRefRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getTypeRefAccess().getRefNamedElementCrossReference_0());
			}
			ruleQCREF
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	iv_ruleExpression=ruleExpression
	{ $current=$iv_ruleExpression.current; }
	EOF;

// Rule Expression
ruleExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall_0());
		}
		this_OrExpression_0=ruleOrExpression
		{
			$current = $this_OrExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getBlockExpressionParserRuleCall_1());
		}
		this_BlockExpression_1=ruleBlockExpression
		{
			$current = $this_BlockExpression_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleBlockExpression
entryRuleBlockExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBlockExpressionRule()); }
	iv_ruleBlockExpression=ruleBlockExpression
	{ $current=$iv_ruleBlockExpression.current; }
	EOF;

// Rule BlockExpression
ruleBlockExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getBlockExpressionAccess().getBlockAction_0(),
					$current);
			}
		)
		otherlv_1=LeftCurlyBracket
		{
			newLeafNode(otherlv_1, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getBlockExpressionAccess().getDeclsVarDeclParserRuleCall_2_0_0());
					}
					lv_decls_2_0=ruleVarDecl
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
						}
						add(
							$current,
							"decls",
							lv_decls_2_0,
							"org.osate.expr.Expr.VarDecl");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=Semicolon
			{
				newLeafNode(otherlv_3, grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_2_1());
			}
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getBlockExpressionAccess().getResultExpressionParserRuleCall_3_0());
				}
				lv_result_4_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
					}
					set(
						$current,
						"result",
						lv_result_4_0,
						"org.osate.expr.Expr.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=RightCurlyBracket
		{
			newLeafNode(otherlv_5, grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleOrExpression
entryRuleOrExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOrExpressionRule()); }
	iv_ruleOrExpression=ruleOrExpression
	{ $current=$iv_ruleOrExpression.current; }
	EOF;

// Rule OrExpression
ruleOrExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
		}
		this_AndExpression_0=ruleAndExpression
		{
			$current = $this_AndExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpOr
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getOrExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0());
							}
							lv_operator_2_0=ruleOpOr
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getOrExpressionRule());
								}
								set(
									$current,
									"operator",
									lv_operator_2_0,
									"org.osate.expr.Expr.OpOr");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_1_0());
					}
					lv_right_3_0=ruleAndExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getOrExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.osate.expr.Expr.AndExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpOr
entryRuleOpOr returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpOrRule()); }
	iv_ruleOpOr=ruleOpOr
	{ $current=$iv_ruleOpOr.current.getText(); }
	EOF;

// Rule OpOr
ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=Or
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0());
		}
		    |
		kw=VerticalLineVerticalLine
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1());
		}
	)
;

// Entry rule entryRuleAndExpression
entryRuleAndExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAndExpressionRule()); }
	iv_ruleAndExpression=ruleAndExpression
	{ $current=$iv_ruleAndExpression.current; }
	EOF;

// Rule AndExpression
ruleAndExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
		}
		this_EqualityExpression_0=ruleEqualityExpression
		{
			$current = $this_EqualityExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpAnd
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getAndExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0());
							}
							lv_operator_2_0=ruleOpAnd
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAndExpressionRule());
								}
								set(
									$current,
									"operator",
									lv_operator_2_0,
									"org.osate.expr.Expr.OpAnd");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_1_0());
					}
					lv_right_3_0=ruleEqualityExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAndExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.osate.expr.Expr.EqualityExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpAnd
entryRuleOpAnd returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpAndRule()); }
	iv_ruleOpAnd=ruleOpAnd
	{ $current=$iv_ruleOpAnd.current.getText(); }
	EOF;

// Rule OpAnd
ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=And
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0());
		}
		    |
		kw=AmpersandAmpersand
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1());
		}
	)
;

// Entry rule entryRuleEqualityExpression
entryRuleEqualityExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEqualityExpressionRule()); }
	iv_ruleEqualityExpression=ruleEqualityExpression
	{ $current=$iv_ruleEqualityExpression.current; }
	EOF;

// Rule EqualityExpression
ruleEqualityExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
		}
		this_RelationalExpression_0=ruleRelationalExpression
		{
			$current = $this_RelationalExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpEquality
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getEqualityExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0());
							}
							lv_operator_2_0=ruleOpEquality
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
								}
								set(
									$current,
									"operator",
									lv_operator_2_0,
									"org.osate.expr.Expr.OpEquality");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_1_0());
					}
					lv_right_3_0=ruleRelationalExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.osate.expr.Expr.RelationalExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpEquality
entryRuleOpEquality returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpEqualityRule()); }
	iv_ruleOpEquality=ruleOpEquality
	{ $current=$iv_ruleOpEquality.current.getText(); }
	EOF;

// Rule OpEquality
ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=EqualsSignEqualsSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
		}
		    |
		kw=ExclamationMarkEqualsSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
		}
	)
;

// Entry rule entryRuleRelationalExpression
entryRuleRelationalExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRelationalExpressionRule()); }
	iv_ruleRelationalExpression=ruleRelationalExpression
	{ $current=$iv_ruleRelationalExpression.current; }
	EOF;

// Rule RelationalExpression
ruleRelationalExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
		}
		this_AdditiveExpression_0=ruleAdditiveExpression
		{
			$current = $this_AdditiveExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpCompare
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getRelationalExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0());
							}
							lv_operator_2_0=ruleOpCompare
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
								}
								set(
									$current,
									"operator",
									lv_operator_2_0,
									"org.osate.expr.Expr.OpCompare");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_1_0());
					}
					lv_right_3_0=ruleAdditiveExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.osate.expr.Expr.AdditiveExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpCompare
entryRuleOpCompare returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpCompareRule()); }
	iv_ruleOpCompare=ruleOpCompare
	{ $current=$iv_ruleOpCompare.current.getText(); }
	EOF;

// Rule OpCompare
ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=GreaterThanSignEqualsSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
		}
		    |
		kw=LessThanSignEqualsSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1());
		}
		    |
		kw=GreaterThanSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
		}
		    |
		kw=LessThanSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
		}
		    |
		kw=GreaterThanSignLessThanSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4());
		}
	)
;

// Entry rule entryRuleAdditiveExpression
entryRuleAdditiveExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAdditiveExpressionRule()); }
	iv_ruleAdditiveExpression=ruleAdditiveExpression
	{ $current=$iv_ruleAdditiveExpression.current; }
	EOF;

// Rule AdditiveExpression
ruleAdditiveExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
		}
		this_MultiplicativeExpression_0=ruleMultiplicativeExpression
		{
			$current = $this_MultiplicativeExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpAdd
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getAdditiveExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0());
							}
							lv_operator_2_0=ruleOpAdd
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
								}
								set(
									$current,
									"operator",
									lv_operator_2_0,
									"org.osate.expr.Expr.OpAdd");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_1_0());
					}
					lv_right_3_0=ruleMultiplicativeExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.osate.expr.Expr.MultiplicativeExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpAdd
entryRuleOpAdd returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpAddRule()); }
	iv_ruleOpAdd=ruleOpAdd
	{ $current=$iv_ruleOpAdd.current.getText(); }
	EOF;

// Rule OpAdd
ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=PlusSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
		}
		    |
		kw=HyphenMinus
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
		}
	)
;

// Entry rule entryRuleMultiplicativeExpression
entryRuleMultiplicativeExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); }
	iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression
	{ $current=$iv_ruleMultiplicativeExpression.current; }
	EOF;

// Rule MultiplicativeExpression
ruleMultiplicativeExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryOperationParserRuleCall_0());
		}
		this_UnaryOperation_0=ruleUnaryOperation
		{
			$current = $this_UnaryOperation_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					(
						(
							ruleOpMulti
						)
					)
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getMultiplicativeExpressionAccess().getBinaryOperationLeftAction_1_0_0_0(),
								$current);
						}
					)
					(
						(
							{
								newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0());
							}
							lv_operator_2_0=ruleOpMulti
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
								}
								set(
									$current,
									"operator",
									lv_operator_2_0,
									"org.osate.expr.Expr.OpMulti");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryOperationParserRuleCall_1_1_0());
					}
					lv_right_3_0=ruleUnaryOperation
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
						}
						set(
							$current,
							"right",
							lv_right_3_0,
							"org.osate.expr.Expr.UnaryOperation");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleOpMulti
entryRuleOpMulti returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpMultiRule()); }
	iv_ruleOpMulti=ruleOpMulti
	{ $current=$iv_ruleOpMulti.current.getText(); }
	EOF;

// Rule OpMulti
ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=Asterisk
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
		}
		    |
		kw=Solidus
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1());
		}
		    |
		kw=Div
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2());
		}
		    |
		kw=Mod
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpMultiAccess().getModKeyword_3());
		}
	)
;

// Entry rule entryRuleUnaryOperation
entryRuleUnaryOperation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnaryOperationRule()); }
	iv_ruleUnaryOperation=ruleUnaryOperation
	{ $current=$iv_ruleUnaryOperation.current; }
	EOF;

// Rule UnaryOperation
ruleUnaryOperation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getUnaryOperationAccess().getUnaryOperationAction_0_0(),
						$current);
				}
			)
			(
				((
					ruleOpUnary
				)
				)=>
				(
					{
						newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0());
					}
					lv_operator_1_0=ruleOpUnary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
						}
						set(
							$current,
							"operator",
							lv_operator_1_0,
							"org.osate.expr.Expr.OpUnary");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperandUnitExpressionParserRuleCall_0_2_0());
					}
					lv_operand_2_0=ruleUnitExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
						}
						set(
							$current,
							"operand",
							lv_operand_2_0,
							"org.osate.expr.Expr.UnitExpression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		    |
		{
			newCompositeNode(grammarAccess.getUnaryOperationAccess().getUnitExpressionParserRuleCall_1());
		}
		this_UnitExpression_3=ruleUnitExpression
		{
			$current = $this_UnitExpression_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleOpUnary
entryRuleOpUnary returns [String current=null]:
	{ newCompositeNode(grammarAccess.getOpUnaryRule()); }
	iv_ruleOpUnary=ruleOpUnary
	{ $current=$iv_ruleOpUnary.current.getText(); }
	EOF;

// Rule OpUnary
ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=Not
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0());
		}
		    |
		kw=HyphenMinus
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
		}
		    |
		kw=PlusSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
		}
	)
;

// Entry rule entryRuleUnitExpression
entryRuleUnitExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnitExpressionRule()); }
	iv_ruleUnitExpression=ruleUnitExpression
	{ $current=$iv_ruleUnitExpression.current; }
	EOF;

// Rule UnitExpression
ruleUnitExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getUnitExpressionAccess().getPropertyExpressionParserRuleCall_0());
		}
		this_PropertyExpression_0=rulePropertyExpression
		{
			$current = $this_PropertyExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				{
					$current = forceCreateModelElementAndSet(
						grammarAccess.getUnitExpressionAccess().getUnitExpressionExpressionAction_1_0(),
						$current);
				}
			)
			(
				(
					(
						lv_convert_2_0=PercentSign
						{
							newLeafNode(lv_convert_2_0, grammarAccess.getUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getUnitExpressionRule());
							}
							setWithLastConsumed($current, "convert", true, "\%");
						}
					)
				)
				    |
				(
					(
						lv_drop_3_0=In
						{
							newLeafNode(lv_drop_3_0, grammarAccess.getUnitExpressionAccess().getDropInKeyword_1_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getUnitExpressionRule());
							}
							setWithLastConsumed($current, "drop", true, "in");
						}
					)
				)
			)?
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getUnitExpressionRule());
						}
					}
					otherlv_4=RULE_ID
					{
						newLeafNode(otherlv_4, grammarAccess.getUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRulePropertyExpression
entryRulePropertyExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyExpressionRule()); }
	iv_rulePropertyExpression=rulePropertyExpression
	{ $current=$iv_rulePropertyExpression.current; }
	EOF;

// Rule PropertyExpression
rulePropertyExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPropertyExpressionAccess().getSelectExpressionParserRuleCall_0());
		}
		this_SelectExpression_0=ruleSelectExpression
		{
			$current = $this_SelectExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				((
					(
					)
					NumberSign
				)
				)=>
				(
					(
						{
							$current = forceCreateModelElementAndSet(
								grammarAccess.getPropertyExpressionAccess().getPropertyExpressionModelElementAction_1_0_0_0(),
								$current);
						}
					)
					otherlv_2=NumberSign
					{
						newLeafNode(otherlv_2, grammarAccess.getPropertyExpressionAccess().getNumberSignKeyword_1_0_0_1());
					}
				)
			)
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPropertyExpressionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getPropertyExpressionAccess().getPropertyAbstractNamedValueCrossReference_1_1_0());
					}
					ruleQPREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleSelectExpression
entryRuleSelectExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSelectExpressionRule()); }
	iv_ruleSelectExpression=ruleSelectExpression
	{ $current=$iv_ruleSelectExpression.current; }
	EOF;

// Rule SelectExpression
ruleSelectExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getSelectExpressionAccess().getPrimaryExpressionParserRuleCall_0());
		}
		this_PrimaryExpression_0=rulePrimaryExpression
		{
			$current = $this_PrimaryExpression_0.current;
			afterParserOrEnumRuleCall();
		}
		(
			((
				(
				)
				FullStop
				(
					(
						ruleQCREF
					)
				)
				(
					LeftParenthesis
					(
						(
							(
								ruleExpression
							)
						)
						(
							Comma
							(
								(
									ruleExpression
								)
							)
						)*
					)?
					RightParenthesis
				)?
			)
			)=>
			(
				(
					{
						$current = forceCreateModelElementAndSet(
							grammarAccess.getSelectExpressionAccess().getSelectionReceiverAction_1_0_0(),
							$current);
					}
				)
				otherlv_2=FullStop
				{
					newLeafNode(otherlv_2, grammarAccess.getSelectExpressionAccess().getFullStopKeyword_1_0_1());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getSelectExpressionRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getSelectExpressionAccess().getRefNamedElementCrossReference_1_0_2_0());
						}
						ruleQCREF
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4=LeftParenthesis
					{
						newLeafNode(otherlv_4, grammarAccess.getSelectExpressionAccess().getLeftParenthesisKeyword_1_0_3_0());
					}
					(
						(
							(
								{
									newCompositeNode(grammarAccess.getSelectExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_0_0());
								}
								lv_args_5_0=ruleExpression
								{
									if ($current==null) {
										$current = createModelElementForParent(grammarAccess.getSelectExpressionRule());
									}
									add(
										$current,
										"args",
										lv_args_5_0,
										"org.osate.expr.Expr.Expression");
									afterParserOrEnumRuleCall();
								}
							)
						)
						(
							otherlv_6=Comma
							{
								newLeafNode(otherlv_6, grammarAccess.getSelectExpressionAccess().getCommaKeyword_1_0_3_1_1_0());
							}
							(
								(
									{
										newCompositeNode(grammarAccess.getSelectExpressionAccess().getArgsExpressionParserRuleCall_1_0_3_1_1_1_0());
									}
									lv_args_7_0=ruleExpression
									{
										if ($current==null) {
											$current = createModelElementForParent(grammarAccess.getSelectExpressionRule());
										}
										add(
											$current,
											"args",
											lv_args_7_0,
											"org.osate.expr.Expr.Expression");
										afterParserOrEnumRuleCall();
									}
								)
							)
						)*
					)?
					otherlv_8=RightParenthesis
					{
						newLeafNode(otherlv_8, grammarAccess.getSelectExpressionAccess().getRightParenthesisKeyword_1_0_3_2());
					}
				)?
			)
		)*
	)
;

// Entry rule entryRulePrimaryExpression
entryRulePrimaryExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryExpressionRule()); }
	iv_rulePrimaryExpression=rulePrimaryExpression
	{ $current=$iv_rulePrimaryExpression.current; }
	EOF;

// Rule PrimaryExpression
rulePrimaryExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNamedElementRefParserRuleCall_0());
		}
		this_NamedElementRef_0=ruleNamedElementRef
		{
			$current = $this_NamedElementRef_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRangeExpressionParserRuleCall_1());
		}
		this_RangeExpression_1=ruleRangeExpression
		{
			$current = $this_RangeExpression_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExpressionParserRuleCall_2());
		}
		this_IfExpression_2=ruleIfExpression
		{
			$current = $this_IfExpression_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_3());
		}
		this_Literal_3=ruleLiteral
		{
			$current = $this_Literal_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			otherlv_4=LeftParenthesis
			{
				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
			}
			{
				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_4_1());
			}
			this_Expression_5=ruleExpression
			{
				$current = $this_Expression_5.current;
				afterParserOrEnumRuleCall();
			}
			otherlv_6=RightParenthesis
			{
				newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_4_2());
			}
		)
	)
;

// Entry rule entryRuleNamedElementRef
entryRuleNamedElementRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNamedElementRefRule()); }
	iv_ruleNamedElementRef=ruleNamedElementRef
	{ $current=$iv_ruleNamedElementRef.current; }
	EOF;

// Rule NamedElementRef
ruleNamedElementRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_core_0_0=CircumflexAccent
				{
					newLeafNode(lv_core_0_0, grammarAccess.getNamedElementRefAccess().getCoreCircumflexAccentKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNamedElementRefRule());
					}
					setWithLastConsumed($current, "core", true, "^");
				}
			)
		)?
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNamedElementRefRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getNamedElementRefAccess().getRefNamedElementCrossReference_1_0());
				}
				ruleQCREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_2=LeftParenthesis
			{
				newLeafNode(otherlv_2, grammarAccess.getNamedElementRefAccess().getLeftParenthesisKeyword_2_0());
			}
			(
				(
					(
						{
							newCompositeNode(grammarAccess.getNamedElementRefAccess().getArgsExpressionParserRuleCall_2_1_0_0());
						}
						lv_args_3_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getNamedElementRefRule());
							}
							add(
								$current,
								"args",
								lv_args_3_0,
								"org.osate.expr.Expr.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
				(
					otherlv_4=Comma
					{
						newLeafNode(otherlv_4, grammarAccess.getNamedElementRefAccess().getCommaKeyword_2_1_1_0());
					}
					(
						(
							{
								newCompositeNode(grammarAccess.getNamedElementRefAccess().getArgsExpressionParserRuleCall_2_1_1_1_0());
							}
							lv_args_5_0=ruleExpression
							{
								if ($current==null) {
									$current = createModelElementForParent(grammarAccess.getNamedElementRefRule());
								}
								add(
									$current,
									"args",
									lv_args_5_0,
									"org.osate.expr.Expr.Expression");
								afterParserOrEnumRuleCall();
							}
						)
					)
				)*
			)?
			otherlv_6=RightParenthesis
			{
				newLeafNode(otherlv_6, grammarAccess.getNamedElementRefAccess().getRightParenthesisKeyword_2_2());
			}
		)?
	)
;

// Entry rule entryRuleRangeExpression
entryRuleRangeExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRangeExpressionRule()); }
	iv_ruleRangeExpression=ruleRangeExpression
	{ $current=$iv_ruleRangeExpression.current; }
	EOF;

// Rule RangeExpression
ruleRangeExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getRangeExpressionAccess().getRangeAction_0(),
					$current);
			}
		)
		otherlv_1=LeftSquareBracket
		{
			newLeafNode(otherlv_1, grammarAccess.getRangeExpressionAccess().getLeftSquareBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRangeExpressionAccess().getMinimumExpressionParserRuleCall_2_0());
				}
				lv_minimum_2_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
					}
					set(
						$current,
						"minimum",
						lv_minimum_2_0,
						"org.osate.expr.Expr.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=FullStopFullStop
		{
			newLeafNode(otherlv_3, grammarAccess.getRangeExpressionAccess().getFullStopFullStopKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRangeExpressionAccess().getMaximumExpressionParserRuleCall_4_0());
				}
				lv_maximum_4_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
					}
					set(
						$current,
						"maximum",
						lv_maximum_4_0,
						"org.osate.expr.Expr.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(Delta)=>
				otherlv_5=Delta
				{
					newLeafNode(otherlv_5, grammarAccess.getRangeExpressionAccess().getDeltaKeyword_5_0());
				}
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getRangeExpressionAccess().getDeltaExpressionParserRuleCall_5_1_0());
					}
					lv_delta_6_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
						}
						set(
							$current,
							"delta",
							lv_delta_6_0,
							"org.osate.expr.Expr.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_7=RightSquareBracket
		{
			newLeafNode(otherlv_7, grammarAccess.getRangeExpressionAccess().getRightSquareBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleIfExpression
entryRuleIfExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIfExpressionRule()); }
	iv_ruleIfExpression=ruleIfExpression
	{ $current=$iv_ruleIfExpression.current; }
	EOF;

// Rule IfExpression
ruleIfExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getIfExpressionAccess().getConditionalAction_0(),
					$current);
			}
		)
		otherlv_1=If
		{
			newLeafNode(otherlv_1, grammarAccess.getIfExpressionAccess().getIfKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExpressionParserRuleCall_2_0());
				}
				lv_if_2_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfExpressionRule());
					}
					set(
						$current,
						"if",
						lv_if_2_0,
						"org.osate.expr.Expr.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=Then
		{
			newLeafNode(otherlv_3, grammarAccess.getIfExpressionAccess().getThenKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_4_0());
				}
				lv_then_4_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIfExpressionRule());
					}
					set(
						$current,
						"then",
						lv_then_4_0,
						"org.osate.expr.Expr.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_5=Else
			{
				newLeafNode(otherlv_5, grammarAccess.getIfExpressionAccess().getElseKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_5_1_0());
					}
					lv_else_6_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIfExpressionRule());
						}
						set(
							$current,
							"else",
							lv_else_6_0,
							"org.osate.expr.Expr.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_7=Endif
		{
			newLeafNode(otherlv_7, grammarAccess.getIfExpressionAccess().getEndifKeyword_6());
		}
	)
;

// Entry rule entryRuleLiteral
entryRuleLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralRule()); }
	iv_ruleLiteral=ruleLiteral
	{ $current=$iv_ruleLiteral.current; }
	EOF;

// Rule Literal
ruleLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getEBooleanLiteralParserRuleCall_0());
		}
		this_EBooleanLiteral_0=ruleEBooleanLiteral
		{
			$current = $this_EBooleanLiteral_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_1());
		}
		this_NumberLiteral_1=ruleNumberLiteral
		{
			$current = $this_NumberLiteral_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getEStringLiteralParserRuleCall_2());
		}
		this_EStringLiteral_2=ruleEStringLiteral
		{
			$current = $this_EStringLiteral_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getListLiteralParserRuleCall_3());
		}
		this_ListLiteral_3=ruleListLiteral
		{
			$current = $this_ListLiteral_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getSetLiteralParserRuleCall_4());
		}
		this_SetLiteral_4=ruleSetLiteral
		{
			$current = $this_SetLiteral_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getRecordLiteralParserRuleCall_5());
		}
		this_RecordLiteral_5=ruleRecordLiteral
		{
			$current = $this_RecordLiteral_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getUnionLiteralParserRuleCall_6());
		}
		this_UnionLiteral_6=ruleUnionLiteral
		{
			$current = $this_UnionLiteral_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getTupleLiteralParserRuleCall_7());
		}
		this_TupleLiteral_7=ruleTupleLiteral
		{
			$current = $this_TupleLiteral_7.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getBagLiteralParserRuleCall_8());
		}
		this_BagLiteral_8=ruleBagLiteral
		{
			$current = $this_BagLiteral_8.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getMapLiteralParserRuleCall_9());
		}
		this_MapLiteral_9=ruleMapLiteral
		{
			$current = $this_MapLiteral_9.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleWrappedNamedElement
entryRuleWrappedNamedElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWrappedNamedElementRule()); }
	iv_ruleWrappedNamedElement=ruleWrappedNamedElement
	{ $current=$iv_ruleWrappedNamedElement.current; }
	EOF;

// Rule WrappedNamedElement
ruleWrappedNamedElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getWrappedNamedElementAccess().getWrappedNamedElementAction_0(),
					$current);
			}
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getWrappedNamedElementRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getWrappedNamedElementAccess().getElemNamedElementCrossReference_1_0());
				}
			)
		)
	)
;

// Entry rule entryRuleEBooleanLiteral
entryRuleEBooleanLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEBooleanLiteralRule()); }
	iv_ruleEBooleanLiteral=ruleEBooleanLiteral
	{ $current=$iv_ruleEBooleanLiteral.current; }
	EOF;

// Rule EBooleanLiteral
ruleEBooleanLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getEBooleanLiteralAccess().getEBooleanLiteralAction_0(),
					$current);
			}
		)
		(
			(
				(
					lv_value_1_0=True
					{
						newLeafNode(lv_value_1_0, grammarAccess.getEBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEBooleanLiteralRule());
						}
						setWithLastConsumed($current, "value", true, "true");
					}
				)
			)
			    |
			otherlv_2=False
			{
				newLeafNode(otherlv_2, grammarAccess.getEBooleanLiteralAccess().getFalseKeyword_1_1());
			}
		)
	)
;

// Entry rule entryRuleNumberLiteral
entryRuleNumberLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumberLiteralRule()); }
	iv_ruleNumberLiteral=ruleNumberLiteral
	{ $current=$iv_ruleNumberLiteral.current; }
	EOF;

// Rule NumberLiteral
ruleNumberLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getNumberLiteralAccess().getEIntegerLiteralParserRuleCall_0());
		}
		this_EIntegerLiteral_0=ruleEIntegerLiteral
		{
			$current = $this_EIntegerLiteral_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumberLiteralAccess().getERealLiteralParserRuleCall_1());
		}
		this_ERealLiteral_1=ruleERealLiteral
		{
			$current = $this_ERealLiteral_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleEIntegerLiteral
entryRuleEIntegerLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEIntegerLiteralRule()); }
	iv_ruleEIntegerLiteral=ruleEIntegerLiteral
	{ $current=$iv_ruleEIntegerLiteral.current; }
	EOF;

// Rule EIntegerLiteral
ruleEIntegerLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getEIntegerLiteralAccess().getEIntegerLiteralAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEIntegerLiteralAccess().getValueINTVALUEParserRuleCall_1_0());
				}
				lv_value_1_0=ruleINTVALUE
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEIntegerLiteralRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleERealLiteral
entryRuleERealLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getERealLiteralRule()); }
	iv_ruleERealLiteral=ruleERealLiteral
	{ $current=$iv_ruleERealLiteral.current; }
	EOF;

// Rule ERealLiteral
ruleERealLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getERealLiteralAccess().getERealLiteralAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getERealLiteralAccess().getValueSignedRealParserRuleCall_1_0());
				}
				lv_value_1_0=ruleSignedReal
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getERealLiteralRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.osate.expr.Expr.SignedReal");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleSignedReal
entryRuleSignedReal returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSignedRealRule()); }
	iv_ruleSignedReal=ruleSignedReal
	{ $current=$iv_ruleSignedReal.current.getText(); }
	EOF;

// Rule SignedReal
ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_REAL_LIT_0=RULE_REAL_LIT
	{
		$current.merge(this_REAL_LIT_0);
	}
	{
		newLeafNode(this_REAL_LIT_0, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall());
	}
;

// Entry rule entryRuleEStringLiteral
entryRuleEStringLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEStringLiteralRule()); }
	iv_ruleEStringLiteral=ruleEStringLiteral
	{ $current=$iv_ruleEStringLiteral.current; }
	EOF;

// Rule EStringLiteral
ruleEStringLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getEStringLiteralAccess().getEStringLiteralAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getEStringLiteralAccess().getValueNoQuoteStringParserRuleCall_1_0());
				}
				lv_value_1_0=ruleNoQuoteString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEStringLiteralRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;


// Rule ExpressionList
ruleExpressionList[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0=LeftParenthesis
		{
			newLeafNode(otherlv_0, grammarAccess.getExpressionListAccess().getLeftParenthesisKeyword_0());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getExpressionListAccess().getElementsExpressionParserRuleCall_1_0_0());
					}
					lv_elements_1_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getExpressionListRule());
						}
						add(
							$current,
							"elements",
							lv_elements_1_0,
							"org.osate.expr.Expr.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_2=Comma
				{
					newLeafNode(otherlv_2, grammarAccess.getExpressionListAccess().getCommaKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getExpressionListAccess().getElementsExpressionParserRuleCall_1_1_1_0());
						}
						lv_elements_3_0=ruleExpression
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getExpressionListRule());
							}
							add(
								$current,
								"elements",
								lv_elements_3_0,
								"org.osate.expr.Expr.Expression");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_4=RightParenthesis
		{
			newLeafNode(otherlv_4, grammarAccess.getExpressionListAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleListLiteral
entryRuleListLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getListLiteralRule()); }
	iv_ruleListLiteral=ruleListLiteral
	{ $current=$iv_ruleListLiteral.current; }
	EOF;

// Rule ListLiteral
ruleListLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getListLiteralAccess().getListLiteralAction_0(),
					$current);
			}
		)
		otherlv_1=List
		{
			newLeafNode(otherlv_1, grammarAccess.getListLiteralAccess().getListKeyword_1());
		}
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getListLiteralRule());
			}
			newCompositeNode(grammarAccess.getListLiteralAccess().getExpressionListParserRuleCall_2());
		}
		this_ExpressionList_2=ruleExpressionList[$current]
		{
			$current = $this_ExpressionList_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSetLiteral
entryRuleSetLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSetLiteralRule()); }
	iv_ruleSetLiteral=ruleSetLiteral
	{ $current=$iv_ruleSetLiteral.current; }
	EOF;

// Rule SetLiteral
ruleSetLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getSetLiteralAccess().getSetLiteralAction_0(),
					$current);
			}
		)
		otherlv_1=Set
		{
			newLeafNode(otherlv_1, grammarAccess.getSetLiteralAccess().getSetKeyword_1());
		}
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getSetLiteralRule());
			}
			newCompositeNode(grammarAccess.getSetLiteralAccess().getExpressionListParserRuleCall_2());
		}
		this_ExpressionList_2=ruleExpressionList[$current]
		{
			$current = $this_ExpressionList_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleRecordLiteral
entryRuleRecordLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRecordLiteralRule()); }
	iv_ruleRecordLiteral=ruleRecordLiteral
	{ $current=$iv_ruleRecordLiteral.current; }
	EOF;

// Rule RecordLiteral
ruleRecordLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getRecordLiteralAccess().getRecordLiteralAction_0(),
					$current);
			}
		)
		otherlv_1=Record
		{
			newLeafNode(otherlv_1, grammarAccess.getRecordLiteralAccess().getRecordKeyword_1());
		}
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getRecordLiteralAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getRecordLiteralAccess().getFieldValuesFieldValueParserRuleCall_3_0_0());
					}
					lv_fieldValues_3_0=ruleFieldValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRecordLiteralRule());
						}
						add(
							$current,
							"fieldValues",
							lv_fieldValues_3_0,
							"org.osate.expr.Expr.FieldValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getRecordLiteralAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getRecordLiteralAccess().getFieldValuesFieldValueParserRuleCall_3_1_1_0());
						}
						lv_fieldValues_5_0=ruleFieldValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRecordLiteralRule());
							}
							add(
								$current,
								"fieldValues",
								lv_fieldValues_5_0,
								"org.osate.expr.Expr.FieldValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		otherlv_6=RightParenthesis
		{
			newLeafNode(otherlv_6, grammarAccess.getRecordLiteralAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleFieldValue
entryRuleFieldValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFieldValueRule()); }
	iv_ruleFieldValue=ruleFieldValue
	{ $current=$iv_ruleFieldValue.current; }
	EOF;

// Rule FieldValue
ruleFieldValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getFieldValueAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFieldValueRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.osate.xtext.aadl2.properties.Properties.ID");
				}
			)
		)
		otherlv_1=Colon
		{
			newLeafNode(otherlv_1, grammarAccess.getFieldValueAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFieldValueAccess().getValueExpressionParserRuleCall_2_0());
				}
				lv_value_2_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFieldValueRule());
					}
					set(
						$current,
						"value",
						lv_value_2_0,
						"org.osate.expr.Expr.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleUnionLiteral
entryRuleUnionLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getUnionLiteralRule()); }
	iv_ruleUnionLiteral=ruleUnionLiteral
	{ $current=$iv_ruleUnionLiteral.current; }
	EOF;

// Rule UnionLiteral
ruleUnionLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getUnionLiteralAccess().getUnionLiteralAction_0(),
					$current);
			}
		)
		otherlv_1=Union
		{
			newLeafNode(otherlv_1, grammarAccess.getUnionLiteralAccess().getUnionKeyword_1());
		}
		otherlv_2=LeftParenthesis
		{
			newLeafNode(otherlv_2, grammarAccess.getUnionLiteralAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getUnionLiteralAccess().getFieldValueFieldValueParserRuleCall_3_0());
				}
				lv_fieldValue_3_0=ruleFieldValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getUnionLiteralRule());
					}
					set(
						$current,
						"fieldValue",
						lv_fieldValue_3_0,
						"org.osate.expr.Expr.FieldValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=RightParenthesis
		{
			newLeafNode(otherlv_4, grammarAccess.getUnionLiteralAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleTupleLiteral
entryRuleTupleLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTupleLiteralRule()); }
	iv_ruleTupleLiteral=ruleTupleLiteral
	{ $current=$iv_ruleTupleLiteral.current; }
	EOF;

// Rule TupleLiteral
ruleTupleLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getTupleLiteralAccess().getTupleLiteralAction_0(),
					$current);
			}
		)
		otherlv_1=Tuple
		{
			newLeafNode(otherlv_1, grammarAccess.getTupleLiteralAccess().getTupleKeyword_1());
		}
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getTupleLiteralRule());
			}
			newCompositeNode(grammarAccess.getTupleLiteralAccess().getExpressionListParserRuleCall_2());
		}
		this_ExpressionList_2=ruleExpressionList[$current]
		{
			$current = $this_ExpressionList_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleBagLiteral
entryRuleBagLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBagLiteralRule()); }
	iv_ruleBagLiteral=ruleBagLiteral
	{ $current=$iv_ruleBagLiteral.current; }
	EOF;

// Rule BagLiteral
ruleBagLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getBagLiteralAccess().getBagLiteralAction_0(),
					$current);
			}
		)
		otherlv_1=Bag
		{
			newLeafNode(otherlv_1, grammarAccess.getBagLiteralAccess().getBagKeyword_1());
		}
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getBagLiteralRule());
			}
			newCompositeNode(grammarAccess.getBagLiteralAccess().getExpressionListParserRuleCall_2());
		}
		this_ExpressionList_2=ruleExpressionList[$current]
		{
			$current = $this_ExpressionList_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleMapLiteral
entryRuleMapLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMapLiteralRule()); }
	iv_ruleMapLiteral=ruleMapLiteral
	{ $current=$iv_ruleMapLiteral.current; }
	EOF;

// Rule MapLiteral
ruleMapLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getMapLiteralAccess().getMapLiteralAction_0(),
					$current);
			}
		)
		otherlv_1=Map
		{
			newLeafNode(otherlv_1, grammarAccess.getMapLiteralAccess().getMapKeyword_1());
		}
	)
;

// Entry rule entryRuleQCREF
entryRuleQCREF returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQCREFRule()); }
	iv_ruleQCREF=ruleQCREF
	{ $current=$iv_ruleQCREF.current.getText(); }
	EOF;

// Rule QCREF
ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			this_ID_0=RULE_ID
			{
				$current.merge(this_ID_0);
			}
			{
				newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
			}
			kw=ColonColon
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
			}
		)*
		this_ID_2=RULE_ID
		{
			$current.merge(this_ID_2);
		}
		{
			newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
		}
		(
			kw=Colon
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonKeyword_2_0());
			}
			this_ID_4=RULE_ID
			{
				$current.merge(this_ID_4);
			}
			{
				newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1());
			}
		)?
	)
;

// Entry rule entryRuleContainedPropertyAssociation
entryRuleContainedPropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); }
	iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation
	{ $current=$iv_ruleContainedPropertyAssociation.current; }
	EOF;

// Rule ContainedPropertyAssociation
ruleContainedPropertyAssociation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
				}
				ruleQPREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=EqualsSignGreaterThanSign
			{
				newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
			}
			    |
			(
				(
					lv_append_2_0=PlusSignEqualsSignGreaterThanSign
					{
						newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
						}
						setWithLastConsumed($current, "append", true, "+=>");
					}
				)
			)
		)
		(
			(
				lv_constant_3_0=Constant
				{
					newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
					}
					setWithLastConsumed($current, "constant", true, "constant");
				}
			)
		)?
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
					}
					lv_ownedValue_4_0=ruleOptionalModalPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
						}
						add(
							$current,
							"ownedValue",
							lv_ownedValue_4_0,
							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5=Comma
				{
					newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
						}
						lv_ownedValue_6_0=ruleOptionalModalPropertyValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
							}
							add(
								$current,
								"ownedValue",
								lv_ownedValue_6_0,
								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			{
				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0());
			}
			ruleAppliesToKeywords
			{
				afterParserOrEnumRuleCall();
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0());
					}
					lv_appliesTo_8_0=ruleContainmentPath
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
						}
						add(
							$current,
							"appliesTo",
							lv_appliesTo_8_0,
							"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_9=Comma
				{
					newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0());
						}
						lv_appliesTo_10_0=ruleContainmentPath
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
							}
							add(
								$current,
								"appliesTo",
								lv_appliesTo_10_0,
								"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)?
		(
			{
				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0());
			}
			ruleInBindingKeywords
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_12=LeftParenthesis
			{
				newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0());
					}
					ruleQCREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_14=RightParenthesis
			{
				newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
			}
		)?
		otherlv_15=Semicolon
		{
			newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
		}
	)
;

// Entry rule entryRulePropertyAssociation
entryRulePropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyAssociationRule()); }
	iv_rulePropertyAssociation=rulePropertyAssociation
	{ $current=$iv_rulePropertyAssociation.current; }
	EOF;

// Rule PropertyAssociation
rulePropertyAssociation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPropertyAssociationRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
				}
				ruleQPREF
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=EqualsSignGreaterThanSign
			{
				newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
			}
			    |
			(
				(
					lv_append_2_0=PlusSignEqualsSignGreaterThanSign
					{
						newLeafNode(lv_append_2_0, grammarAccess.getPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPropertyAssociationRule());
						}
						setWithLastConsumed($current, "append", true, "+=>");
					}
				)
			)
		)
		(
			(
				lv_constant_3_0=Constant
				{
					newLeafNode(lv_constant_3_0, grammarAccess.getPropertyAssociationAccess().getConstantConstantKeyword_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPropertyAssociationRule());
					}
					setWithLastConsumed($current, "constant", true, "constant");
				}
			)
		)?
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
					}
					lv_ownedValue_4_0=ruleOptionalModalPropertyValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getPropertyAssociationRule());
						}
						add(
							$current,
							"ownedValue",
							lv_ownedValue_4_0,
							"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_5=Comma
				{
					newLeafNode(otherlv_5, grammarAccess.getPropertyAssociationAccess().getCommaKeyword_3_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
						}
						lv_ownedValue_6_0=ruleOptionalModalPropertyValue
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getPropertyAssociationRule());
							}
							add(
								$current,
								"ownedValue",
								lv_ownedValue_6_0,
								"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
		)
		(
			{
				newCompositeNode(grammarAccess.getPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_4_0());
			}
			ruleInBindingKeywords
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_8=LeftParenthesis
			{
				newLeafNode(otherlv_8, grammarAccess.getPropertyAssociationAccess().getLeftParenthesisKeyword_4_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getPropertyAssociationRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getPropertyAssociationAccess().getInBindingClassifierCrossReference_4_2_0());
					}
					ruleQCREF
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_10=RightParenthesis
			{
				newLeafNode(otherlv_10, grammarAccess.getPropertyAssociationAccess().getRightParenthesisKeyword_4_3());
			}
		)?
		otherlv_11=Semicolon
		{
			newLeafNode(otherlv_11, grammarAccess.getPropertyAssociationAccess().getSemicolonKeyword_5());
		}
	)
;

// Entry rule entryRuleContainmentPath
entryRuleContainmentPath returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainmentPathRule()); }
	iv_ruleContainmentPath=ruleContainmentPath
	{ $current=$iv_ruleContainmentPath.current; }
	EOF;

// Rule ContainmentPath
ruleContainmentPath returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0());
			}
			lv_path_0_0=ruleContainmentPathElement
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getContainmentPathRule());
				}
				set(
					$current,
					"path",
					lv_path_0_0,
					"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleOptionalModalPropertyValue
entryRuleOptionalModalPropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); }
	iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue
	{ $current=$iv_ruleOptionalModalPropertyValue.current; }
	EOF;

// Rule OptionalModalPropertyValue
ruleOptionalModalPropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());
				}
				lv_ownedValue_0_0=rulePropertyExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
					}
					set(
						$current,
						"ownedValue",
						lv_ownedValue_0_0,
						"org.osate.expr.Expr.PropertyExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			{
				newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0());
			}
			ruleInModesKeywords
			{
				afterParserOrEnumRuleCall();
			}
			otherlv_2=LeftParenthesis
			{
				newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0());
					}
				)
			)
			(
				otherlv_4=Comma
				{
					newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
							}
						}
						otherlv_5=RULE_ID
						{
							newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0());
						}
					)
				)
			)*
			otherlv_6=RightParenthesis
			{
				newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4());
			}
		)?
	)
;

// Entry rule entryRulePropertyValue
entryRulePropertyValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyValueRule()); }
	iv_rulePropertyValue=rulePropertyValue
	{ $current=$iv_rulePropertyValue.current; }
	EOF;

// Rule PropertyValue
rulePropertyValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0());
			}
			lv_ownedValue_0_0=rulePropertyExpression
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getPropertyValueRule());
				}
				set(
					$current,
					"ownedValue",
					lv_ownedValue_0_0,
					"org.osate.expr.Expr.PropertyExpression");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleConstantValue
entryRuleConstantValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstantValueRule()); }
	iv_ruleConstantValue=ruleConstantValue
	{ $current=$iv_ruleConstantValue.current; }
	EOF;

// Rule ConstantValue
ruleConstantValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getConstantValueRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0());
			}
			ruleQPREF
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleFieldPropertyAssociation
entryRuleFieldPropertyAssociation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); }
	iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation
	{ $current=$iv_ruleFieldPropertyAssociation.current; }
	EOF;

// Rule FieldPropertyAssociation
ruleFieldPropertyAssociation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0());
				}
			)
		)
		otherlv_1=EqualsSignGreaterThanSign
		{
			newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
				}
				lv_ownedValue_2_0=rulePropertyExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
					}
					set(
						$current,
						"ownedValue",
						lv_ownedValue_2_0,
						"org.osate.expr.Expr.PropertyExpression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=Semicolon
		{
			newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleContainmentPathElement
entryRuleContainmentPathElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getContainmentPathElementRule()); }
	iv_ruleContainmentPathElement=ruleContainmentPathElement
	{ $current=$iv_ruleContainmentPathElement.current; }
	EOF;

// Rule ContainmentPathElement
ruleContainmentPathElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getContainmentPathElementRule());
						}
					}
					otherlv_0=RULE_ID
					{
						newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());
					}
					lv_arrayRange_1_0=ruleArrayRange
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
						}
						add(
							$current,
							"arrayRange",
							lv_arrayRange_1_0,
							"org.osate.xtext.aadl2.properties.Properties.ArrayRange");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)
		(
			otherlv_2=FullStop
			{
				newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0());
					}
					lv_path_3_0=ruleContainmentPathElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
						}
						set(
							$current,
							"path",
							lv_path_3_0,
							"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRulePlusMinus
entryRulePlusMinus returns [String current=null]:
	{ newCompositeNode(grammarAccess.getPlusMinusRule()); }
	iv_rulePlusMinus=rulePlusMinus
	{ $current=$iv_rulePlusMinus.current.getText(); }
	EOF;

// Rule PlusMinus
rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=PlusSign
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());
		}
		    |
		kw=HyphenMinus
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1());
		}
	)
;

// Entry rule entryRuleNoQuoteString
entryRuleNoQuoteString returns [String current=null]:
	{ newCompositeNode(grammarAccess.getNoQuoteStringRule()); }
	iv_ruleNoQuoteString=ruleNoQuoteString
	{ $current=$iv_ruleNoQuoteString.current.getText(); }
	EOF;

// Rule NoQuoteString
ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_STRING_0=RULE_STRING
	{
		$current.merge(this_STRING_0);
	}
	{
		newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall());
	}
;

// Entry rule entryRuleArrayRange
entryRuleArrayRange returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getArrayRangeRule()); }
	iv_ruleArrayRange=ruleArrayRange
	{ $current=$iv_ruleArrayRange.current; }
	EOF;

// Rule ArrayRange
ruleArrayRange returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
					$current);
			}
		)
		otherlv_1=LeftSquareBracket
		{
			newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());
				}
				lv_lowerBound_2_0=ruleINTVALUE
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getArrayRangeRule());
					}
					set(
						$current,
						"lowerBound",
						lv_lowerBound_2_0,
						"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3=FullStopFullStop
			{
				newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0());
					}
					lv_upperBound_4_0=ruleINTVALUE
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getArrayRangeRule());
						}
						set(
							$current,
							"upperBound",
							lv_upperBound_4_0,
							"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_5=RightSquareBracket
		{
			newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleSignedConstant
entryRuleSignedConstant returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSignedConstantRule()); }
	iv_ruleSignedConstant=ruleSignedConstant
	{ $current=$iv_ruleSignedConstant.current; }
	EOF;

// Rule SignedConstant
ruleSignedConstant returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());
				}
				lv_op_0_0=rulePlusMinus
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignedConstantRule());
					}
					set(
						$current,
						"op",
						lv_op_0_0,
						"org.osate.xtext.aadl2.properties.Properties.PlusMinus");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0());
				}
				lv_ownedPropertyExpression_1_0=ruleConstantValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSignedConstantRule());
					}
					add(
						$current,
						"ownedPropertyExpression",
						lv_ownedPropertyExpression_1_0,
						"org.osate.xtext.aadl2.properties.Properties.ConstantValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleIntegerTerm
entryRuleIntegerTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntegerTermRule()); }
	iv_ruleIntegerTerm=ruleIntegerTerm
	{ $current=$iv_ruleIntegerTerm.current; }
	EOF;

// Rule IntegerTerm
ruleIntegerTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0());
				}
				lv_value_0_0=ruleSignedInt
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntegerTermRule());
					}
					set(
						$current,
						"value",
						lv_value_0_0,
						"org.osate.xtext.aadl2.properties.Properties.SignedInt");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIntegerTermRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0());
				}
			)
		)?
	)
;

// Entry rule entryRuleSignedInt
entryRuleSignedInt returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSignedIntRule()); }
	iv_ruleSignedInt=ruleSignedInt
	{ $current=$iv_ruleSignedInt.current.getText(); }
	EOF;

// Rule SignedInt
ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw=PlusSign
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());
			}
			    |
			kw=HyphenMinus
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1());
			}
		)?
		this_INTEGER_LIT_2=RULE_INTEGER_LIT
		{
			$current.merge(this_INTEGER_LIT_2);
		}
		{
			newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleRealTerm
entryRuleRealTerm returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRealTermRule()); }
	iv_ruleRealTerm=ruleRealTerm
	{ $current=$iv_ruleRealTerm.current; }
	EOF;

// Rule RealTerm
ruleRealTerm returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0());
				}
				lv_value_0_0=ruleSignedReal
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRealTermRule());
					}
					set(
						$current,
						"value",
						lv_value_0_0,
						"org.osate.expr.Expr.SignedReal");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRealTermRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0());
				}
			)
		)?
	)
;

// Entry rule entryRuleNumAlt
entryRuleNumAlt returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNumAltRule()); }
	iv_ruleNumAlt=ruleNumAlt
	{ $current=$iv_ruleNumAlt.current; }
	EOF;

// Rule NumAlt
ruleNumAlt returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0());
		}
		this_RealTerm_0=ruleRealTerm
		{
			$current = $this_RealTerm_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1());
		}
		this_IntegerTerm_1=ruleIntegerTerm
		{
			$current = $this_IntegerTerm_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2());
		}
		this_SignedConstant_2=ruleSignedConstant
		{
			$current = $this_SignedConstant_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3());
		}
		this_ConstantValue_3=ruleConstantValue
		{
			$current = $this_ConstantValue_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAppliesToKeywords
entryRuleAppliesToKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); }
	iv_ruleAppliesToKeywords=ruleAppliesToKeywords
	{ $current=$iv_ruleAppliesToKeywords.current.getText(); }
	EOF;

// Rule AppliesToKeywords
ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=Applies
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0());
		}
		kw=To
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1());
		}
	)
;

// Entry rule entryRuleInBindingKeywords
entryRuleInBindingKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getInBindingKeywordsRule()); }
	iv_ruleInBindingKeywords=ruleInBindingKeywords
	{ $current=$iv_ruleInBindingKeywords.current.getText(); }
	EOF;

// Rule InBindingKeywords
ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=In
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0());
		}
		kw=Binding
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1());
		}
	)
;

// Entry rule entryRuleInModesKeywords
entryRuleInModesKeywords returns [String current=null]:
	{ newCompositeNode(grammarAccess.getInModesKeywordsRule()); }
	iv_ruleInModesKeywords=ruleInModesKeywords
	{ $current=$iv_ruleInModesKeywords.current.getText(); }
	EOF;

// Rule InModesKeywords
ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw=In
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0());
		}
		kw=Modes
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1());
		}
	)
;

// Entry rule entryRuleINTVALUE
entryRuleINTVALUE returns [String current=null]:
	{ newCompositeNode(grammarAccess.getINTVALUERule()); }
	iv_ruleINTVALUE=ruleINTVALUE
	{ $current=$iv_ruleINTVALUE.current.getText(); }
	EOF;

// Rule INTVALUE
ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	this_INTEGER_LIT_0=RULE_INTEGER_LIT
	{
		$current.merge(this_INTEGER_LIT_0);
	}
	{
		newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall());
	}
;

// Entry rule entryRuleQPREF
entryRuleQPREF returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQPREFRule()); }
	iv_ruleQPREF=ruleQPREF
	{ $current=$iv_ruleQPREF.current.getText(); }
	EOF;

// Rule QPREF
ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
		}
		(
			kw=ColonColon
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1());
			}
		)?
	)
;

// Entry rule entryRuleSTAR
entryRuleSTAR returns [String current=null]:
	{ newCompositeNode(grammarAccess.getSTARRule()); }
	iv_ruleSTAR=ruleSTAR
	{ $current=$iv_ruleSTAR.current.getText(); }
	EOF;

// Rule STAR
ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	kw=Asterisk
	{
		$current.merge(kw);
		newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword());
	}
;

// Rule MetaClassEnum
ruleMetaClassEnum returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0=Component
			{
				$current = grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getMetaClassEnumAccess().getCOMPONENTEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1=Feature
			{
				$current = grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getMetaClassEnumAccess().getFEATUREEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2=Connection
			{
				$current = grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getMetaClassEnumAccess().getCONNECTIONEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3=Flow
			{
				$current = grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getMetaClassEnumAccess().getFLOWEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4=Mode
			{
				$current = grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getMetaClassEnumAccess().getMODEEnumLiteralDeclaration_4());
			}
		)
		    |
		(
			enumLiteral_5=Property
			{
				$current = grammarAccess.getMetaClassEnumAccess().getPROPERTYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_5, grammarAccess.getMetaClassEnumAccess().getPROPERTYEnumLiteralDeclaration_5());
			}
		)
	)
;
