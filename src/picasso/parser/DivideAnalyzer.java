package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.operators.Divide;
import picasso.parser.tokens.Token;

public class DivideAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Divide(SemanticAnalyzer.getInstance().generateExpressionTree(tokens),
				SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
