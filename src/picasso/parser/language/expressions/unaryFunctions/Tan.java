package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the tangent function in the Picasso language.
 * 
 * @author August Donovan
 * Based on Abdelrahman's structure in Sin
 *
 */
public class Tan extends UnaryFunction {

	/**
	 * Create a tan expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to tan
	 */
	
	public Tan(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the tangent of the
	 * function's parameter.
	 * 
	 * @return the color from evaluating the tangent of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.tan(result.getRed());
		double green = Math.tan(result.getGreen());
		double blue = Math.tan(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
