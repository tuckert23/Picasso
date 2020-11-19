/**
 * 
 */
package picasso.parser.language.expressions.operators;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.BinaryOperatorsOrFunctions;
import picasso.parser.language.expressions.RGBColor;

import java.lang.Math;

/**
 * @author taylor
 *
 */
public class Exponent extends BinaryOperatorsOrFunctions {

	/**
	 * @param param1
	 * @param param2
	 */
	public Exponent(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the first parameter ^ second parameter
	 * of the operator's two parameters.
	 * 
	 * @return the color from evaluating the addition of the operator's two
	 *         parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor right = rightParam.evaluate(x, y);
		RGBColor left = leftParam.evaluate(x, y);
		
		double red = Math.pow(left.getRed(), right.getRed());
		double green = Math.pow(left.getGreen(), right.getGreen());
		double blue = Math.pow(left.getBlue(), right.getBlue());

		return new RGBColor(red, green, blue);
	}

}
