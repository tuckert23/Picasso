package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a variable
 * 
 * @author Sara Sprenkle
 *
 */

public class Variable extends ExpressionTreeNode {

	private ExpressionTreeNode param;

	public Variable(ExpressionTreeNode param) {
		this.param = param;
	}

	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		return result;
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
		if (!(obj instanceof Variable)) {
			return false;
		}
		Variable l = (Variable) obj;
		return this.param.equals(l.param);
	}
}
