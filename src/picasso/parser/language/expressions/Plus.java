package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the plus operator in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class Plus extends BinaryOperator {

	public Plus(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the addition
	 * of the operator's two parameters.
	 * 
	 * @return the color from evaluating the addition of the operator's two
	 *         parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor right = param1.evaluate(x, y);
		RGBColor left = param2.evaluate(x, y);
		double red = left.getRed() + right.getRed();
		double green = left.getGreen() + right.getGreen();
		double blue = left.getBlue() + right.getBlue();

		return new RGBColor(red, green, blue);
	}

}
