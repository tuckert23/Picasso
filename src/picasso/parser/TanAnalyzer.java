/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Tan;
import picasso.parser.tokens.Token;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class TanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Tan(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
