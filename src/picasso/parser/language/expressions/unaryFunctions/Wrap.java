/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class Wrap extends UnaryFunction {

	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = wrap(result.getRed());
		double green = wrap(result.getGreen());
		double blue = wrap(result.getBlue());
		return new RGBColor(red, green, blue);
	}

	public static double wrap(double num) {
		num += 3;
		num %= 2;
		num -= 1;
		return num;
	}
}
