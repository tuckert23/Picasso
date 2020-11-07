package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.PerlinColor;
import picasso.parser.tokens.Token;

public class PerlinColorAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new PerlinColor(SemanticAnalyzer.getInstance().generateExpressionTree(tokens),
				SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
