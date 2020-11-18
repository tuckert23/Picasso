package picasso.parser.language.expressions.binaryFunctions;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.unaryFunctions.Wrap;

public class ImageWrap extends Image {

	public ImageWrap(String str, ExpressionTreeNode x, ExpressionTreeNode y) {
		super(str, x, y);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		
		// Evaluate left and right
		// Call wrap() on whatever values I get from left and right
		// retrieve (left,right) point from image
				
		
		RGBColor xResult = super.leftParam.evaluate(x, y);
		RGBColor yResult = super.rightParam.evaluate(x, y);
		
		double xWrapped = Wrap.wrap(xResult.getRed());
		double yWrapped = Wrap.wrap(yResult.getRed());
		
		RGBColor imageRep = super.imageEvaluator.evaluate(xWrapped, yWrapped);
		
		
		return imageRep;
	}


}
