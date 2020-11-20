/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an a function that takes more than one argument including an image.
 * 
 * @author taylor
 *
 */
public abstract class Image extends ExpressionTreeNode {

	protected ExpressionTreeNode y;
	protected ExpressionTreeNode x;
	protected String image;
	protected StringEvaluator imageEvaluator;
	
	/**
	 * constructor that takes a string, x and y as parameters
	 * 
	 * @param str
	 * @param x
	 * @param y
	 */
	public Image(String str, ExpressionTreeNode x, ExpressionTreeNode y) {
		this.x = x;
		this.y = y;
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
		return this.getClass() + ": " + y + ", " + x + ", " + image;
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
		return this.y.equals(a.y) && this.x.equals(a.x) && image.equals(a.image) && this.getClass().equals(a.getClass());
	}

}
