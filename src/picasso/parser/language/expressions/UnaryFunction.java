package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes one argument.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 *
 */
public abstract class UnaryFunction extends ExpressionTreeNode {

	protected ExpressionTreeNode param;

	/**
	 * @param param
	 */
	public UnaryFunction(ExpressionTreeNode param) {
		this.param = param;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + param;
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
		if (!(obj instanceof UnaryFunction)) {
			return false;
		}
		UnaryFunction f = (UnaryFunction) obj;
		return param.equals(f.param);
	}

}
