/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class Wrap extends UnaryFunction {

	public Wrap(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = wrap(result.getRed());
		double green = wrap(result.getGreen());
		double blue = wrap(result.getBlue());
		return new RGBColor(red, green, blue);
	}
	
	private double wrap(double num) {
		num += 3;
		num %= 2;
		num -= 1;
		return num;
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
		if (!(obj instanceof Wrap)) {
			return false;
		}
		Wrap a = (Wrap) obj;
		return param.equals(a.param);
	}

}
