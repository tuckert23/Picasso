package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an operator that takes two argument.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public abstract class BinaryOperator extends ExpressionTreeNode {

	protected ExpressionTreeNode param1;
	protected ExpressionTreeNode param2;

	/**
	 * @param param1
	 * @param param2
	 */
	public BinaryOperator(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		this.param1 = param1;
		this.param2 = param2;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter1>, <parameter2>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + param1 + ", " + param2;
	}

}
