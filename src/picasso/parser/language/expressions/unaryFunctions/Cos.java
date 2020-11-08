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
public class Cos extends UnaryFunction {

	/**
	 * Create a cos expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to sin
	 */
	
	public Cos(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the cosine of the
	 * function's parameter.
	 * 
	 * @return the color from evaluating the cosine of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.cos(result.getRed());
		double green = Math.cos(result.getGreen());
		double blue = Math.cos(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (!(obj instanceof Cos)) {
			return false;
		}
		Cos s = (Cos) obj;
		return param.equals(s.param);
	}

}
