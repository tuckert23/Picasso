
package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import picasso.parser.RandomExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.Frame;

/**
 * Evaluate a random expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */


public class RandomEvaluator implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	
	/**
	 * Evaluate an expression for each point in the image.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void execute(Pixmap target) {
		// create the expression to evaluate just once
		ExpressionTreeNode expr = createRandomExpression();
		// evaluate it for each pixel
		Dimension size = target.getSize();
		for (int imageY = 0; imageY < size.height; imageY++) {
			double evalY = imageToDomainScale(imageY, size.height);
			for (int imageX = 0; imageX < size.width; imageX++) {
				double evalX = imageToDomainScale(imageX, size.width);
				Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
				target.setColor(imageX, imageY, pixelColor);
			}
		}
	}
	

	/**
	 * Convert from image space to domain space.
	 */
	private double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}
	
	/**
	 * 
	 * @return rndTreeGen
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	
	private ExpressionTreeNode createRandomExpression() {
		RandomExpressionTreeGenerator rndTreeGen = new RandomExpressionTreeGenerator();
		return rndTreeGen.makeOneExpression();
	}
}
