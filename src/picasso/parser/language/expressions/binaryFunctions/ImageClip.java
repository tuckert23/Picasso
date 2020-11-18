/**
 * 
 */
package picasso.parser.language.expressions.binaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.RGBColor;
//import picasso.parser.language.expressions.StringEvaluator;

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

	/**
	 * This function evaluates both the x and y expression in the imageClip function call. It then takes one
	 * of the values from the RGBColor given by the evaluation, and clips the x value while leaving the y value.
	 * By leaving the y value, the imageClip maintains all the image in the y direction, while "streaking" the x values 
	 * at each y value. After determining the position from where on the image to grab the color, the function
	 * returns that color from the image. 
	 * 
	 * @param x
	 * @param y
	 * @return imageRep
	 */
	@Override
	public RGBColor evaluate(double x, double y) 
		{
		
		RGBColor xResult = super.x.evaluate(x, y);
		RGBColor yResult = super.y.evaluate(x, y);
		
		double xClipped = RGBColor.clamp(xResult.getRed());
		double yClipped = RGBColor.clamp(yResult.getRed());

		RGBColor imageRep = super.imageEvaluator.evaluate(xClipped, yClipped);
		
		return imageRep;
		
		}

}
