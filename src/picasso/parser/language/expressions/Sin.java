package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Sin extends UnaryFunction {

	public Sin(ExpressionTreeNode param) {
		super(param);
	}

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
