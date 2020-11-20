package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an operator or a function that takes two argument.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public abstract class BinaryOperatorsOrFunctions extends ExpressionTreeNode {

	protected ExpressionTreeNode rightParam;
	protected ExpressionTreeNode leftParam;

	/**
	 * constructs the left and right nodes.
	 * 
	 * @param left
	 * @param right
	 */
	public BinaryOperatorsOrFunctions(ExpressionTreeNode left, ExpressionTreeNode right) {
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
		if (!(obj instanceof BinaryOperatorsOrFunctions)) {
			return false;
		}
		BinaryOperatorsOrFunctions a = (BinaryOperatorsOrFunctions) obj;
		return rightParam.equals(a.rightParam) && leftParam.equals(a.leftParam) && this.getClass().equals(a.getClass());
	}

}