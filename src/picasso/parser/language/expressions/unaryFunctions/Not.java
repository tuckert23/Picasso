/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * @author taylor
 *
 */
public class Not extends UnaryFunction {

	/**
	 * @param param
	 */
	public Not(ExpressionTreeNode param) {
		super(param);

	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = -1 * result.getRed();
		double green = -1 * result.getGreen();
		double blue = -1 * result.getBlue();

		return new RGBColor(red, green, blue);
	}

}
