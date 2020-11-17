package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;

public class RandomExpressionTreeGenerator extends ExpressionTreeGenerator {

	public RandomExpressionTreeGenerator() {
		super();
	}
	
	@Override
	public ExpressionTreeNode makeExpression(String infix) {
		Stack<Token> postfix = infixToPostfix(infix);

		if (postfix.isEmpty()) {
			return null;
		}

		// System.out.println("Process postfix expression");
		SemanticAnalyzer semAnalyzer = SemanticAnalyzer.getInstance();

		ExpressionTreeNode root = semAnalyzer.generateExpressionTree(postfix);

		// Is this the best place to put this check?
		if (!postfix.isEmpty()) {
			throw new ParseException("Extra operands without operators or functions");
		}
		return root;
	}


}
