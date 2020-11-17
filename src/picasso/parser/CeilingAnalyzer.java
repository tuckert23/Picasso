/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Floor;
import picasso.parser.tokens.Token;

/**
 * @author taylor
 *
 */
public class CeilingAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Floor(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
