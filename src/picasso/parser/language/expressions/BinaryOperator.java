/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Abdelrahman AboEitta
 *
 */
public abstract class BinaryOperator extends ExpressionTreeNode {
	
	
	ExpressionTreeNode param1;
	ExpressionTreeNode param2;
	
	public BinaryOperator(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		this.param1 = param1;
		this.param2 = param2;
	}
	
	@Override
	public String toString() {
		return this.getClass() + ": " + param1;
	}

}
