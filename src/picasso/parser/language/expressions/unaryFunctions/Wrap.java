/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the wrap function in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class Wrap extends UnaryFunction {

	/**
	 * Create a wrap expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to wrap
	 */
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the wrap of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the wrap of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = wrap(result.getRed());
		double green = wrap(result.getGreen());
		double blue = wrap(result.getBlue());
		return new RGBColor(red, green, blue);
	}

	/**
	 * takes a double then wrap it.
	 * 
	 * @param num
	 * @return num wrapped
	 */
	public static double wrap(double num) {
		num += 3;
		num %= 2;
		num -= 1;
		return num;
	}
}
