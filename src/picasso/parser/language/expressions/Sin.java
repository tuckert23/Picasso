package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the sin function in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class Sin extends UnaryFunction {

	/**
	 * Create a sin expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to sin
	 */
	public Sin(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the sin of the
	 * function's parameter.
	 * 
	 * @return the color from evaluating the sin of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.sin(result.getRed());
		double green = Math.sin(result.getGreen());
		double blue = Math.sin(result.getBlue());

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
		if (!(obj instanceof Sin)) {
			return false;
		}
		Sin s = (Sin) obj;
		return param.equals(s.param);
	}

}
