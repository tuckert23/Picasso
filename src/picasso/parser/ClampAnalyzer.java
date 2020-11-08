/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Clamp;
import picasso.parser.tokens.Token;

/**
 * @author taylor
 *
 */
public class ClampAnalyzer extends UnaryFunctionAnalyzer {

	/**
	 * 
	 */
	public ClampAnalyzer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the clamp token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Clamp(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
