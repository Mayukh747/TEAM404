grammar Neo;

@header {
    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;
}


program : programHeader ';' functionDefinitionList 'main' variableDeclarationList compoundStatement ;
programHeader : PROGRAM programIdentifier ;
programIdentifier       locals [ SymtabEntry entry = null ]
    : IDENTIFIER;

statement : compoundStatement
          | assignmentStatement
          | ifStatement
          | whileStatement
          | printStatement
          | returnStatement
          ;

compoundStatement : '{' statementList '}' ;

statementList       : (statement ';')+ ;
assignmentStatement : lhs ':=' rhs ;
lhs : variable
    | matrixEntry;
rhs : expression ;

argumentList : (argument ( ',' argument )*)? ;
argument     : expression ;

variableDeclarationList : VAR variableList;
variableList: (variable (',' variable)*)?;
variable : realVariable
         | matrixVariable
         ;

functionDefinitionList: (functionDefinition functionDefinition*)?;
functionDefinition : realFunctionDefinition
                    | matrixFunctionDefinition;
ifStatement     : IF '(' expression ')' compoundStatement (ELSE compoundStatement)? ;

whileStatement : WHILE '(' expression ')' compoundStatement ;

//printStatement : PRINT '(' expression ')' ;
printStatement: PRINT '(' variable ')';

returnStatement: RETURN expression ;

expression : realExpression (realRelOp realExpression)?
           | matrixExpression (matrixRelOp matrixExpression)?
           ;

realExpression : realTerm (realAddOp realTerm)* ;

realTerm       : realFactor (realMulOp realFactor)* ;

realFactor     : realVariable
               | realNumber
               | realFunctionCall
//               | matrixVariable '[' INTEGER ']' '[' INTEGER ']'
               | matrixEntry
               | '!' realFactor
               | '(' realExpression ')'
               ;


realVariable : 'r_' IDENTIFIER ;
// realNumber : '-'? REAL ;
realNumber : '-'? integer '.' integer;
integer : INTEGER;

realFunctionCall : realFunctionName '(' argumentList? ')' ;
realFunctionName : 'rf_' IDENTIFIER ;
realFunctionDefinition: realFunctionName '(' variableList ')' variableDeclarationList compoundStatement;

realRelOp : '=' | '!=' | '<=' ;
realAddOp : '+' | '-' | '||' ;
realMulOp : '*' | '/' | '&&' ;

matrixExpression : matrixTerm (matrixAddOp matrixTerm)* ;
matrixTerm      :   matrixFactor (matrixMulOp matrixFactor)*;
matrixFactor    :   matrixVariable
                |   matrixFunctionCall
                |   '!'matrixFactor
                |   '('matrixExpression')'
                ;

matrixVariable: 'm_' INTEGER '_' IDENTIFIER;
matrixEntry : matrixVariable '[' realExpression '][' realExpression ']';

matrixFunctionCall: matrixFunctionName '(' argumentList? ')' ;
matrixFunctionName: 'mf_' INTEGER '_' IDENTIFIER;
matrixFunctionDefinition: matrixFunctionName '(' variableList ')' variableDeclarationList compoundStatement;

matrixRelOp : '=' | '!=' ;
matrixAddOp : '+' | '-' | '||' ;
matrixMulOp : '*' | '&&' ;

PROGRAM   : P R O G R A M ;
WHILE     : W H I L E ;
IF        : I F ;
ELSE      : E L S E ;
RETURN    : R E T U R N;
PRINT     : P R I N T;
VAR       : V A R;

fragment A : ('a' | 'A') ;
fragment B : ('b' | 'B') ;
fragment C : ('c' | 'C') ;
fragment D : ('d' | 'D') ;
fragment E : ('e' | 'E') ;
fragment F : ('f' | 'F') ;
fragment G : ('g' | 'G') ;
fragment H : ('h' | 'H') ;
fragment I : ('i' | 'I') ;
fragment J : ('j' | 'J') ;
fragment K : ('k' | 'K') ;
fragment L : ('l' | 'L') ;
fragment M : ('m' | 'M') ;
fragment N : ('n' | 'N') ;
fragment O : ('o' | 'O') ;
fragment P : ('p' | 'P') ;
fragment Q : ('q' | 'Q') ;
fragment R : ('r' | 'R') ;
fragment S : ('s' | 'S') ;
fragment T : ('t' | 'T') ;
fragment U : ('u' | 'U') ;
fragment V : ('v' | 'V') ;
fragment W : ('w' | 'W') ;
fragment X : ('x' | 'X') ;
fragment Y : ('y' | 'Y') ;
fragment Z : ('z' | 'Z') ;

//fragment COMMENT_CHARACTER : '#' ;
//COMMENT : '{' COMMENT_CHARACTER* '}' -> skip ;

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]* ;
INTEGER    : [0-9]+ ;
// REAL       : INTEGER '.' INTEGER ;

NEWLINE : '\r'? '\n' -> skip  ;
WS      : [ \t]+ -> skip ;
