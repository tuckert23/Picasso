package picasso.parser.language.expressions.operators;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the divide operator in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class Divide extends Binary {

	/**
	 * @param param1
	 * @param param2
	 */
	public Divide(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the division
	 * of the operator's two parameters.
	 * 
	 * @return the color from evaluating the division of the operator's two
	 *         parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor right = param1.evaluate(x, y);
		RGBColor left = param2.evaluate(x, y);
		double red = 0;
		double green = 0;
		double blue = 0;

		if (right.getRed() != 0) {
			red = left.getRed() / right.getRed();
		}
		if (right.getGreen() != 0) {
			green = left.getGreen() / right.getGreen();
		}
		if (right.getGreen() != 0) {
			blue = left.getBlue() / right.getBlue();
		}

		return new RGBColor(red, green, blue);
	}
}
