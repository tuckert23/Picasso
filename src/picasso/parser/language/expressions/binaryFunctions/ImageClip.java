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
	public RGBColor evaluate(double x, double y) {
		
		RGBColor xResult = super.x.evaluate(x, y);
		RGBColor yResult = super.y.evaluate(x, y);
		
		double xClipped = clip(xResult.getRed());
		double yClipped = yResult.getRed();
		
		RGBColor imageRep = super.imageEvaluator.evaluate(xClipped, yClipped);
		
		
		return imageRep;
	}
	
	/**
	 * This function binds the x parameter to the edges of the given image. Therefore, for every 
	 * x value between [-1, -0.5], will evaluate to the color of the image at (x=-0.5,y=-1).
	 * 
	 * @param num
	 * @return
	 */
	public static double clip(double num) {
		num /= 2;
		
		if (num <= -0.5)
		{
			return -0.5;
		}
		else if (num >= 0.5)
		{
			return 0.5;
		}
		else
		{
			return num;
		}
		
	}

}
