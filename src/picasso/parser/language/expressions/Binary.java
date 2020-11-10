package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an operator that takes two argument.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public abstract class Binary extends ExpressionTreeNode {

	protected ExpressionTreeNode rightParam;
	protected ExpressionTreeNode leftParam;

	public Binary(ExpressionTreeNode left, ExpressionTreeNode right) {
		leftParam = left;
		rightParam = right;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter1>, <parameter2>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + rightParam + ", " + leftParam;
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
		if (!(obj instanceof Binary)) {
			return false;
		}
		Binary a = (Binary) obj;
		return rightParam.equals(a.rightParam) && leftParam.equals(a.leftParam) && this.getClass().equals(a.getClass());
	}

}
