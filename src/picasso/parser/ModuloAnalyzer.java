/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.operators.Modulo;
import picasso.parser.tokens.Token;

/**
 * @author taylor
 *
 */
public class ModuloAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Modulo(SemanticAnalyzer.getInstance().generateExpressionTree(tokens),
				SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
}
