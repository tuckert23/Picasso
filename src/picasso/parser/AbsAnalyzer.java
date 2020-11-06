package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Abs;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the absolute function.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class AbsAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Abs(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
