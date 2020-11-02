
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class Minus extends BinaryOperator {

	/**
	 * @param param1
	 * @param param2
	 */
	public Minus(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = param1.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		double red = result2.getRed() - result1.getRed();
		double green = result2.getGreen() - result1.getGreen();
		double blue = result2.getBlue() - result1.getBlue();

		return new RGBColor(red, green, blue);
	}

}
