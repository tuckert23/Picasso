package picasso.parser.language;

import java.util.Map;
import java.util.TreeMap;

import picasso.parser.language.expressions.RGBColor;

/**
 * All elements of the language (e.g., that make up ExpressionTree) should
 * extend ExpressionTreeNode.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 */
public abstract class ExpressionTreeNode implements EvaluatableExpression {

	protected static int numberOfChildren = 0;
	
	public ExpressionTreeNode() {
		
	}
	
	/**
	 * Evaluate this expression, given x and y
	 * 
	 * @param x
	 * @param y
	 * 
	 * @return the result of evaluating the expression
	 */
	public abstract RGBColor evaluate(double x, double y);

	// TODO: Not being utilized yet. Why would it be useful?
	// keep a mapping of the element to its value.
	static protected Map<ExpressionTreeNode, Object> elementsToValue = new TreeMap<ExpressionTreeNode, Object>();
	
	/**
	 * get the number of children from an expression tree.
	 * 
	 * @return number of children
	 */
	public static int getNumberOfChildren() {
		return numberOfChildren;
	}
}
