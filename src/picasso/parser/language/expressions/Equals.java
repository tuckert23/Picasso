package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Handles Evaluating a variable in the picasso language
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class Equals extends ExpressionTreeNode {

	ExpressionTreeNode param;

	/**
	 * Create an expression that takes as a parameter the given expression
	 * 
	 * @param param the expression
	 */
	public Equals(ExpressionTreeNode param) {
		this.param = param;
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the expression
	 * 
	 * @return the color from evaluating the the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		return param.evaluate(x, y);
	}
}
