/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Clamp;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the clamp function.
 * 
 * @author taylor
 *
 */
public class ClampAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Clamp(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
