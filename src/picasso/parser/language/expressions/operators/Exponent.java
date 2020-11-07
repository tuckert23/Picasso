/**
 * 
 */
package picasso.parser.language.expressions.operators;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;

import java.lang.Math;

/**
 * @author taylor
 *
 */
public class Exponent extends Binary {

	/**
	 * @param param1
	 * @param param2
	 */
	public Exponent(ExpressionTreeNode param1, ExpressionTreeNode param2) {
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
		
		double red = Math.pow(left.getRed(), right.getRed());
		double green = Math.pow(left.getGreen(), right.getGreen());
		double blue = Math.pow(left.getBlue(), right.getBlue());

		return new RGBColor(red, green, blue);
	}

}
