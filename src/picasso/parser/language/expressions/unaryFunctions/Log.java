package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the log function in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class Log extends UnaryFunction {

	/**
	 * Create a log expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to log
	 */
	public Log(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the log of the
	 * function's parameter.
	 * 
	 * @return the color from evaluating the log of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		if (x == 0)
		{
			return new RGBColor(1, 1, 1);
		}
		
		double red = 1;
		double blue = 1;
		double green = 1;
		
		if (result.getRed() != 0) {
			red = Math.log(Math.abs(result.getRed()));
		}
		if (result.getGreen() != 0) {
			green = Math.log(Math.abs(result.getGreen()));
		}
		if (result.getBlue() != 0) {
			blue = Math.log(Math.abs(result.getBlue()));
		}

		return new RGBColor(red, green, blue);
	}
}
