/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class YCrCbtoRGB extends UnaryFunction {

	/**
	 * @param param
	 */
	public YCrCbtoRGB(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.getRed() + result.getBlue() * 1.4022;
		double green = result.getRed() + result.getGreen() * -0.3456 + result.getBlue() * -0.7145;
		double blue = result.getRed() + result.getGreen() * 1.7710;
		
		return new RGBColor(red, green, blue);

		
		
	}

}
