/**
 * 
 */
package picasso.parser.language.expressions.operators;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.BinaryOperatorsOrFunctions;
import picasso.parser.language.expressions.RGBColor;

/**
 * @author taylor
 *
 */
public class Multiply extends BinaryOperatorsOrFunctions {

	/**
	 * @param param1
	 * @param param2
	 */
	public Multiply(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the multiplication
	 * of the operator's two parameters.
	 * 
	 * @return the color from evaluating the addition of the operator's two
	 *         parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor right = rightParam.evaluate(x, y);
		RGBColor left = leftParam.evaluate(x, y);
		double red = left.getRed() * right.getRed();
		double green = left.getGreen() * right.getGreen();
		double blue = left.getBlue() * right.getBlue();

		return new RGBColor(red, green, blue);
	}

}
