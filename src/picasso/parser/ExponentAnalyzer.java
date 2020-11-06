/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.operators.Exponent;
import picasso.parser.tokens.Token;

/**
 * @author taylor
 *
 */
public class ExponentAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Exponent(SemanticAnalyzer.getInstance().generateExpressionTree(tokens),
				SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
