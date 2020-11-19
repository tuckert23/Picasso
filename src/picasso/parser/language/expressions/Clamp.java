/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the clamp function in the Picasso language.
 * 
 * @author Taylor Tucker
 *
 */
public class Clamp extends UnaryFunction {

	/**
	 * @param param
	 */
	
	public Clamp(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Clamps the colors between [-1, 1]
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);

		double red = RGBColor.clamp(result.getRed());
		double green = RGBColor.clamp(result.getGreen());
		double blue = RGBColor.clamp(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
