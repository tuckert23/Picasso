/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.YCrCbtoRGB;
import picasso.parser.tokens.Token;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class YCrCbtoRGBAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new YCrCbtoRGB(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}