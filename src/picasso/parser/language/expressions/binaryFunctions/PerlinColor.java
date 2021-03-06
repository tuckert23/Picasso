package picasso.parser.language.expressions.binaryFunctions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.BinaryOperatorsOrFunctions;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the perlinColor function in the Picasso language.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class PerlinColor extends BinaryOperatorsOrFunctions {

	/**
	 * Create a PerlinColor expression that takes left and right as parameters.
	 * 
	 * @param left node
	 * @param right node
	 */
	public PerlinColor(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	/**
	 * This function also uses improvedNoise to generate "noisy" distributions of color which creates a mosaic of color 
	 * on the canvas. 
	 * 
	 * @return the color from evaluating perlinColor
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor right = rightParam.evaluate(x, y);
		RGBColor left = leftParam.evaluate(x, y);
		double red = ImprovedNoise.noise(left.getRed() + 0.3, right.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(left.getBlue() + 0.1, right.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(left.getGreen() - 0.8, right.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
	}

}
