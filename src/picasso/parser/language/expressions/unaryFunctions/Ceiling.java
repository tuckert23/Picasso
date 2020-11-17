/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;
import java.lang.Math;

/**
 * @author taylor
 *
 */
public class Ceiling extends UnaryFunction {

	/**
	 * @param param
	 */
	public Ceiling(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.ceil(result.getRed());
		double green = Math.ceil(result.getGreen());
		double blue = Math.ceil(result.getBlue());
		return new RGBColor(red, green, blue);
	}

}
