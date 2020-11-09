/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the absolute function in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class Abs extends UnaryFunction {

	/**
	 * Create an absolute expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to absolute
	 */
	public Abs(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the absolute of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the absolute of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.abs(result.getRed());
		double green = Math.abs(result.getGreen());
		double blue = Math.abs(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
