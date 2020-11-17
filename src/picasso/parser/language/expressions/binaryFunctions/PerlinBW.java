package picasso.parser.language.expressions.binaryFunctions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;
/**
 * 
 * @author taylor
 *
 */
public class PerlinBW extends Binary {
	
	/**
	 * 
	 * @param left
	 * @param right
	 */

	public PerlinBW(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
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
