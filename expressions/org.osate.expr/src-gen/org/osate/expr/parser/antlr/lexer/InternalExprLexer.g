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
lexer grammar InternalExprLexer;

@header {
package org.osate.expr.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

Classifier : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('R'|'r');

Connection : ('C'|'c')('O'|'o')('N'|'n')('N'|'n')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Subprogram : ('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m');

Component : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('N'|'n')('E'|'e')('N'|'n')('T'|'t');

Processor : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s')('O'|'o')('R'|'r');

Reference : ('R'|'r')('E'|'e')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

Subclause : ('S'|'s')('U'|'u')('B'|'b')('C'|'c')('L'|'l')('A'|'a')('U'|'u')('S'|'s')('E'|'e');

Abstract : ('A'|'a')('B'|'b')('S'|'s')('T'|'t')('R'|'r')('A'|'a')('C'|'c')('T'|'t');

Constant : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('T'|'t');

Property : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('Y'|'y');

Applies : ('A'|'a')('P'|'p')('P'|'p')('L'|'l')('I'|'i')('E'|'e')('S'|'s');

Binding : ('B'|'b')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('N'|'n')('G'|'g');

Compute : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('U'|'u')('T'|'t')('E'|'e');

Element : ('E'|'e')('L'|'l')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

Feature : ('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e');

Library : ('L'|'l')('I'|'i')('B'|'b')('R'|'r')('A'|'a')('R'|'r')('Y'|'y');

Process : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Virtual : ('V'|'v')('I'|'i')('R'|'r')('T'|'t')('U'|'u')('A'|'a')('L'|'l');

Assert : ('A'|'a')('S'|'s')('S'|'s')('E'|'e')('R'|'r')('T'|'t');

Device : ('D'|'d')('E'|'e')('V'|'v')('I'|'i')('C'|'c')('E'|'e');

Memory : ('M'|'m')('E'|'e')('M'|'m')('O'|'o')('R'|'r')('Y'|'y');

Record : ('R'|'r')('E'|'e')('C'|'c')('O'|'o')('R'|'r')('D'|'d');

String : ('S'|'s')('T'|'t')('R'|'r')('I'|'i')('N'|'n')('G'|'g');

KW_System : ('S'|'s')('Y'|'y')('S'|'s')('T'|'t')('E'|'e')('M'|'m');

Thread : ('T'|'t')('H'|'h')('R'|'r')('E'|'e')('A'|'a')('D'|'d');

Delta : ('D'|'d')('E'|'e')('L'|'l')('T'|'t')('A'|'a');

Endif : ('E'|'e')('N'|'n')('D'|'d')('I'|'i')('F'|'f');

False : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

Group : ('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');

Modes : ('M'|'m')('O'|'o')('D'|'d')('E'|'e')('S'|'s');

Range : ('R'|'r')('A'|'a')('N'|'n')('G'|'g')('E'|'e');

Tuple : ('T'|'t')('U'|'u')('P'|'p')('L'|'l')('E'|'e');

Union : ('U'|'u')('N'|'n')('I'|'i')('O'|'o')('N'|'n');

Bool : ('B'|'b')('O'|'o')('O'|'o')('L'|'l');

Data : ('D'|'d')('A'|'a')('T'|'t')('A'|'a');

Else : ('E'|'e')('L'|'l')('S'|'s')('E'|'e');

Enum : ('E'|'e')('N'|'n')('U'|'u')('M'|'m');

Flow : ('F'|'f')('L'|'l')('O'|'o')('W'|'w');

Java : ('J'|'j')('A'|'a')('V'|'v')('A'|'a');

List : ('L'|'l')('I'|'i')('S'|'s')('T'|'t');

Mode : ('M'|'m')('O'|'o')('D'|'d')('E'|'e');

Real : ('R'|'r')('E'|'e')('A'|'a')('L'|'l');

Root : ('R'|'r')('O'|'o')('O'|'o')('T'|'t');

Then : ('T'|'t')('H'|'h')('E'|'e')('N'|'n');

True : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

Type : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

PlusSignEqualsSignGreaterThanSign : '+''=''>';

And : ('A'|'a')('N'|'n')('D'|'d');

Bag : ('B'|'b')('A'|'a')('G'|'g');

Bus : ('B'|'b')('U'|'u')('S'|'s');

Def : ('D'|'d')('E'|'e')('F'|'f');

Div : ('D'|'d')('I'|'i')('V'|'v');

Int : ('I'|'i')('N'|'n')('T'|'t');

Map : ('M'|'m')('A'|'a')('P'|'p');

Mod : ('M'|'m')('O'|'o')('D'|'d');

Not : ('N'|'n')('O'|'o')('T'|'t');

Set : ('S'|'s')('E'|'e')('T'|'t');

Val : ('V'|'v')('A'|'a')('L'|'l');

Var : ('V'|'v')('A'|'a')('R'|'r');

ExclamationMarkEqualsSign : '!''=';

AmpersandAmpersand : '&''&';

HyphenMinusGreaterThanSign : '-''>';

FullStopFullStop : '.''.';

ColonColon : ':'':';

LessThanSignEqualsSign : '<''=';

EqualsSignEqualsSign : '=''=';

EqualsSignGreaterThanSign : '=''>';

GreaterThanSignLessThanSign : '>''<';

GreaterThanSignEqualsSign : '>''=';

If : ('I'|'i')('F'|'f');

In : ('I'|'i')('N'|'n');

Of : ('O'|'o')('F'|'f');

Or : ('O'|'o')('R'|'r');

To : ('T'|'t')('O'|'o');

VerticalLineVerticalLine : '|''|';

NumberSign : '#';

PercentSign : '%';

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Solidus : '/';

Colon : ':';

Semicolon : ';';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

LeftSquareBracket : '[';

RightSquareBracket : ']';

CircumflexAccent : '^';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';

RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;
