package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;

/**
 * Parses a function that takes one expression as a parameter.
 * 
 * XXX: Not sure if this class is necessary.
 * 
 * @author Sara Sprenkle
 * 
 */
public abstract class UnaryFunctionAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public abstract ExpressionTreeNode generateExpressionTree(
			Stack<Token> tokens);

}
