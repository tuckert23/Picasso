/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author taylor
 *
 */
public abstract class Image extends ExpressionTreeNode {

	protected ExpressionTreeNode rightParam;
	protected ExpressionTreeNode leftParam;
	protected String image;
	protected StringEvaluator imageEvaluator;
	/**
	 * 
	 */
	public Image(String str, ExpressionTreeNode x, ExpressionTreeNode y) {
		leftParam = x;
		rightParam = y;
		image = str;
		imageEvaluator = new StringEvaluator(str);
	}


	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter1>, <parameter2>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + rightParam + ", " + leftParam + ", " + image;
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
		if (!(obj instanceof Image)) {
			return false;
		}
		Image a = (Image) obj;
		return rightParam.equals(a.rightParam) && leftParam.equals(a.leftParam) && image.equals(a.image) && this.getClass().equals(a.getClass());
	}

}
