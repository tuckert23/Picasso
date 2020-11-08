package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Equals;
import picasso.parser.language.expressions.Variable;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;

public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	public static ExpressionTreeNode expression;

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		expression = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		EqualsAnalyzer.addNewVariable(tokens);
		return new Equals(expression);
	}
	
	private static void addNewVariable(Stack<Token> tokens) {
		IdentifierToken t = (IdentifierToken) tokens.pop();
		String name = t.getName();
		IdentifierAnalyzer.idToExpression.put(name, new Variable(expression));
	}
}
