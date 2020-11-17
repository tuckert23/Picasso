/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.unaryFunctions.Ceiling;

/**
 * @author taylor
 *
 */
public class CeilingAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Ceiling(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
