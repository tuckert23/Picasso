package picasso.parser.language.expressions.binaryFunctions;

import java.awt.Color;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.StringEvaluator;
import picasso.parser.language.expressions.unaryFunctions.Wrap;

public class ImageWrap extends Binary {

	private StringEvaluator imageEvaluator;
	private ExpressionTreeNode left;
	private ExpressionTreeNode right;

	public ImageWrap(String str, ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		this.left = left;
		this.right = right;
		imageEvaluator = new StringEvaluator(str);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		
		RGBColor leftResult = left.evaluate(x, y);
		RGBColor rightResult = right.evaluate(x, y);
		
		double red   = Wrap.wrap(leftResult.getRed()   + rightResult.getRed()); 
		double green = Wrap.wrap(leftResult.getGreen() + rightResult.getGreen());
		double blue  = Wrap.wrap(leftResult.getBlue()  + rightResult.getBlue());
		
		return new RGBColor(red, green, blue);
	}


}
