/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * Represents the not operator in the Picasso language.
 * 
 * @author taylor
 *
 */
public class Not extends UnaryFunction {

	/**
	 * Create a negation expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to negate
	 */
	public Not(ExpressionTreeNode param) {
		super(param);

	}

	/**
	 * Evaluates this expression at the given point by evaluating the negating of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		return new RGBColor(-result.getRed(), -result.getGreen(), -result.getBlue());
	}

}
