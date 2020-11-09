package picasso.parser.language.expressions.binaryFunctions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;

public class PerlinBW extends Binary {

	public PerlinBW(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor right = rightParam.evaluate(x, y);
		RGBColor left = leftParam.evaluate(x, y);
		double grey = ImprovedNoise.noise(left.getRed() + right.getRed(), left.getGreen() + right.getGreen(),
				left.getBlue() + right.getBlue());
		return new RGBColor(grey, grey, grey);
	}

}
