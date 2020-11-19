/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Not;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the negation operator.
 * 
 * @author taylor
 *
 */
public class NotAnalyzer implements SemanticAnalyzerInterface {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Not(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
