// Generated from C:/Users/natha/Dev/CompilerProject/Neo.g4 by ANTLR 4.13.1

    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NeoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NeoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NeoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(NeoParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#programHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramHeader(NeoParser.ProgramHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#programIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramIdentifier(NeoParser.ProgramIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(NeoParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(NeoParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(NeoParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(NeoParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhs(NeoParser.LhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhs(NeoParser.RhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(NeoParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(NeoParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationList(NeoParser.VariableDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#variableList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableList(NeoParser.VariableListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(NeoParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#functionDefinitionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinitionList(NeoParser.FunctionDefinitionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(NeoParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(NeoParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(NeoParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(NeoParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(NeoParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(NeoParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#booleanTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanTerm(NeoParser.BooleanTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#booleanFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanFactor(NeoParser.BooleanFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(NeoParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealExpression(NeoParser.RealExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealTerm(NeoParser.RealTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealFactor(NeoParser.RealFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealVariable(NeoParser.RealVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealNumber(NeoParser.RealNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(NeoParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealFunctionCall(NeoParser.RealFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealFunctionName(NeoParser.RealFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realFunctionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealFunctionDefinition(NeoParser.RealFunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realRelOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealRelOp(NeoParser.RealRelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realAddOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealAddOp(NeoParser.RealAddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#realMulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealMulOp(NeoParser.RealMulOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixExpression(NeoParser.MatrixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixTerm(NeoParser.MatrixTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixFactor(NeoParser.MatrixFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixVariable(NeoParser.MatrixVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixEntry(NeoParser.MatrixEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixFunctionCall(NeoParser.MatrixFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixFunctionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixFunctionName(NeoParser.MatrixFunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixFunctionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixFunctionDefinition(NeoParser.MatrixFunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixRelOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixRelOp(NeoParser.MatrixRelOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixAddOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixAddOp(NeoParser.MatrixAddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link NeoParser#matrixMulOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixMulOp(NeoParser.MatrixMulOpContext ctx);
}