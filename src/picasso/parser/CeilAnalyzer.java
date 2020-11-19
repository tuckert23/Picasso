/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.unaryFunctions.Ceil;

/**
 * Handles parsing the ceil function.
 * 
 * @author taylor
 *
 */
public class CeilAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Ceil(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
