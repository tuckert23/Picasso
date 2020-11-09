package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the cosine function in the Picasso language.
 * 
 * @author August Donovan
 * Based on Abdelrahman's structure in Sin
 *
 */
public class Atan extends UnaryFunction {

	/**
	 * Create an atan expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to atan
	 */
	
	public Atan(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the arctangent of the
	 * function's parameter.
	 * 
	 * @return the color from evaluating the arctangent of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.atan(result.getRed());
		double green = Math.atan(result.getGreen());
		double blue = Math.atan(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
