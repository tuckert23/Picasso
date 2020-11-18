package picasso.parser.language.expressions.operators;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the divide operator in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 * @author August Donovan
 */
public class Divide extends Binary {

	/**
	 * @param param1
	 * @param param2
	 */
	public Divide(ExpressionTreeNode right, ExpressionTreeNode left) {
		super(right, left);
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
		RGBColor right = rightParam.evaluate(x, y);
		RGBColor left = leftParam.evaluate(x, y);

		double red = 0;
		double green = 0;
		double blue = 0;
		
		if (right.getRed() != 0) {
			red = left.getRed() / right.getRed();
		}
		if (right.getGreen() != 0) {
			green = left.getGreen() / right.getGreen();
		}
		if (right.getBlue() != 0) {
			blue = left.getBlue() / right.getBlue();
		}
		return new RGBColor(red, green, blue);
	}
}
