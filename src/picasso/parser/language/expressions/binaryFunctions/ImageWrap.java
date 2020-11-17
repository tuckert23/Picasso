package picasso.parser.language.expressions.binaryFunctions;

import java.awt.Color;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.StringEvaluator;
import picasso.parser.language.expressions.unaryFunctions.Wrap;

public class ImageWrap extends Binary {

	StringEvaluator imageEvaluator;

	public ImageWrap(String str, ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		imageEvaluator = new StringEvaluator(str);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		
		// Evaluate left and right
		// Call wrap() on whatever values I get from left and right
		// retrieve (left,right) point from image
		
		
		int xDomain = imageEvaluator.domainScaleToImage(x, imageEvaluator.myImage.getWidth());
		int yDomain = imageEvaluator.domainScaleToImage(y, imageEvaluator.myImage.getHeight());
		double xd = wrap(xDomain, imageEvaluator.myImage.getWidth());
		double yd = wrap(yDomain, imageEvaluator.myImage.getHeight());
		Color pixColor = new Color(imageEvaluator.myImage.getRGB(xDomain, yDomain));
		return new RGBColor(pixColor);
	}

	private double wrap(int num, int boundary) {
		return Wrap.wrap(num);
	}
}
