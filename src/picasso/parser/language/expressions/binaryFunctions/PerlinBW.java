package picasso.parser.language.expressions.binaryFunctions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.BinaryOperatorsOrFunctions;
import picasso.parser.language.expressions.RGBColor;


/**
 * Represents the PerlinBW function in the Picasso language.
 * 
 * @author taylor
 *
 */
public class PerlinBW extends BinaryOperatorsOrFunctions {

	/**
	 * Create a PerlinBW expression that takes left and right as parameters.
	 * 
	 * @param left
	 * @param right
	 */
	public PerlinBW(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	/**
	 * This function implements the PerlinBW evaluation of position using noise
	 * to determine the shade of grey to return.
	 * 
	 * @return the color from evaluating perlinBW
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor right = rightParam.evaluate(x, y);
		RGBColor left = leftParam.evaluate(x, y);
		double grey = ImprovedNoise.noise(left.getRed() + right.getRed(), left.getGreen() + right.getGreen(),
				left.getBlue() + right.getBlue());
		return new RGBColor(grey, grey, grey);
	}

}
