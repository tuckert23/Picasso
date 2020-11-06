/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.operators.Multiply;
import picasso.parser.tokens.Token;

/**
 * @author taylor
 *
 */
public class MultiplyAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Multiply(SemanticAnalyzer.getInstance().generateExpressionTree(tokens),
				SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
}
