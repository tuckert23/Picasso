package picasso.parser.language.expressions.binaryFunctions;

import java.awt.Color;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.StringEvaluator;

public class ImageWrap extends Binary {

	StringEvaluator imageEvaluator;

	public ImageWrap(String str, ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		imageEvaluator = new StringEvaluator(str);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		int xDomain = imageEvaluator.domainScaleToImage(x, imageEvaluator.myImage.getWidth());
		int yDomain = imageEvaluator.domainScaleToImage(y, imageEvaluator.myImage.getHeight());
		xDomain = wrap(xDomain, imageEvaluator.myImage.getWidth());
		yDomain = wrap(yDomain, imageEvaluator.myImage.getHeight());
		Color pixColor = new Color(imageEvaluator.myImage.getRGB(xDomain, yDomain));
		return new RGBColor(pixColor);
	}

	private int wrap(int num, int boundary) {
		return 0;
	}
}
