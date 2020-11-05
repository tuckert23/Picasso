/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Str;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class StringAnalyzer implements SemanticAnalyzerInterface {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		StringToken t = (StringToken) tokens.pop();
		return new Str(t);
	}
}
