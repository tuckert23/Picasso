/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Cos;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the cos function.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class CosAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Cos(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
