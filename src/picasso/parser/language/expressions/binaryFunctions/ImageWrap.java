package picasso.parser.language.expressions.binaryFunctions;

import java.awt.Color;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.StringEvaluator;
import picasso.parser.language.expressions.unaryFunctions.Wrap;

public class ImageWrap extends Binary {

	private StringEvaluator imageEvaluator;
	private ExpressionTreeNode x;
	private ExpressionTreeNode y;

	public ImageWrap(String str, ExpressionTreeNode x, ExpressionTreeNode y) {
		super(x, y);
		this.x = x;
		this.y = y;
		imageEvaluator = new StringEvaluator(str);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		
		// Evaluate left and right
		// Call wrap() on whatever values I get from left and right
		// retrieve (left,right) point from image
				
		
		RGBColor xResult = this.x.evaluate(x, y);
		RGBColor yResult = this.y.evaluate(x, y);
		
		double xWrapped = Wrap.wrap(xResult.getRed());
		double yWrapped = Wrap.wrap(yResult.getRed());
		
		RGBColor imageRep = imageEvaluator.evaluate(xWrapped, yWrapped);
		
		
		return imageRep;
	}


}
