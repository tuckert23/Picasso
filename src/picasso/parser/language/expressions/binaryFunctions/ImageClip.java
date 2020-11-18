/**
 * 
 */
package picasso.parser.language.expressions.binaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.RGBColor;

/**
 * @author taylor
 *
 */
public class ImageClip extends Image {

	/**
	 * @param x
	 * @param y
	 */
	public ImageClip(String str, ExpressionTreeNode x, ExpressionTreeNode y) {
		super(str, x, y);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		// Evaluate left and right
		// Call wrap() on whatever values I get from left and right
		// retrieve (left,right) point from image
				
		
		RGBColor xResult = super.leftParam.evaluate(x, y);
		RGBColor yResult = super.rightParam.evaluate(x, y);
		
		double xWrapped = clip(xResult.getRed());
		double yWrapped = clip(yResult.getRed());
		
		RGBColor imageRep = super.imageEvaluator.evaluate(xWrapped, yWrapped);
		
		
		return imageRep;
	}
	
	private double clip(double val)
	{
		return 0.1;
	}

}
