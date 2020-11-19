/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the RgbToYCrCb function in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class RgbToYCrCb extends UnaryFunction {

	/**
	 * Create a RgbToYCrCb expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to RgbToYCrCb
	 */
	public RgbToYCrCb(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the RgbToYCrCb
	 * of the function's parameter.
	 * 
	 * @return the color from evaluating the RgbToYCrCb of the expression's
	 *         parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);

		double red = result.getRed() * 0.2989 + result.getGreen() * 0.5866 + result.getBlue() * 0.1145;
		double green = result.getRed() * -0.1687 + result.getGreen() * -0.3312 + result.getBlue() * 0.5;
		double blue = result.getRed() * 0.5000 + result.getGreen() * -0.4183 + result.getBlue() * -0.0816;

		return new RGBColor(red, green, blue);
	}

}
