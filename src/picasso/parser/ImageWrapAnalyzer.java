package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.ImageWrap;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the imageWrap function.
 * 
 * @author Taylor
 *
 */
public class ImageWrapAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		ExpressionTreeNode y = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode x = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		StringToken t = (StringToken) tokens.pop();
		String str = t.getString();
		return new ImageWrap(str, x, y);
	}
}
