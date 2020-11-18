/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
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

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);

		double red = RGBColor.clamp(result.getRed());
		double green = RGBColor.clamp(result.getGreen());
		double blue = RGBColor.clamp(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
