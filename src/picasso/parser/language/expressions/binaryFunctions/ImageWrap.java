package picasso.parser.language.expressions.binaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.unaryFunctions.Wrap;

/**
 * Represents the imageWrap function in the Picasso language.
 * 
 * @author taylor
 *
 */
public class ImageWrap extends Image {

	/**
	 * Create an imageWrap expression that takes x,y expressions and an image as
	 * arguments
	 * 
	 * @param str the name of the image
	 * @param x
	 * @param y
	 */
	public ImageWrap(String str, ExpressionTreeNode x, ExpressionTreeNode y) {
		super(str, x, y);
	}

	/**
	 * This function evaluates the x and y expressions given in the imageWrap
	 * function call. It then takes the corresponding value from the RGBColor those
	 * expressions give (in this case, the red value, but all are the same), and
	 * uses the wrap function. It then evaluates the point as the wrapped point on
	 * the image, which essentially takes a point from the image and puts it in
	 * another place on the newly generated image, giving the wrapping effect.
	 * 
	 * @param x
	 * @param y
	 */
	@Override
	public RGBColor evaluate(double x, double y) {

		RGBColor xResult = super.x.evaluate(x, y);
		RGBColor yResult = super.y.evaluate(x, y);

		double xWrapped = Wrap.wrap(xResult.getRed());
		double yWrapped = Wrap.wrap(yResult.getRed());

		RGBColor imageRep = super.imageEvaluator.evaluate(xWrapped, yWrapped);

		return imageRep;
	}

}
