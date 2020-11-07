/**
 * 
 */
package picasso.parser.language.expressions.operators;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;

/**
 * @author taylor
 *
 */
public class Multiply extends Binary {

	/**
	 * @param param1
	 * @param param2
	 */
	public Multiply(ExpressionTreeNode param1, ExpressionTreeNode param2) {
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
		double red = left.getRed() * right.getRed();
		double green = left.getGreen() * right.getGreen();
		double blue = left.getBlue() * right.getBlue();

		return new RGBColor(red, green, blue);
	}

}
