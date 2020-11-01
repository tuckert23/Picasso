/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class Plus extends BinaryOperator {

	/**
	 * @param param
	 */
	public Plus(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = param1.evaluate(x, y);
		RGBColor result2 = param2.evaluate(x, y);
		double red = result1.getRed() + result2.getRed();
		double green = result1.getGreen() + result2.getGreen();
		double blue = result1.getBlue() + result2.getBlue();

		return new RGBColor(red, green, blue);
	}

}
