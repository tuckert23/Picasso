/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the YCrCbtoRGB function in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class YCrCbtoRGB extends UnaryFunction {

	/**
	 * Create a YCrCbtoRGB expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to YCrCbtoRGB
	 */
	public YCrCbtoRGB(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the YCrCbtoRGB of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the YCrCbtoRGB of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.getRed() + result.getBlue() * 1.4022;
		double green = result.getRed() + result.getGreen() * -0.3456 + result.getBlue() * -0.7145;
		double blue = result.getRed() + result.getGreen() * 1.7710;

		return new RGBColor(red, green, blue);

	}

}
