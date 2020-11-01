/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class Log extends UnaryFunction {

	/**
	 * @param param
	 */
	public Log(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.log(result.getRed());
		double green = Math.log(result.getGreen());
		double blue = Math.log(result.getBlue());

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
		if (!(obj instanceof Log)) {
			return false;
		}
		Log l = (Log) obj;
		return param.equals(l.param);
	}

}
