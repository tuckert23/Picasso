package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import picasso.parser.language.expressions.RGBColor;
import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.Frame;

/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */


public class RandomEvaluator implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;

	/**
	 * Set a random color for each point in the image.
	 */
	public void execute(Pixmap target) {
		// evaluate it for each pixel
		Random rd = new Random();
		Dimension size = target.getSize();
		for (int imageY = 0; imageY < size.height; imageY++) {
			double evalY = imageToDomainScale(imageY, size.height);
			for (int imageX = 0; imageX < size.width; imageX++) {
				double evalX = imageToDomainScale(imageX, size.width);
				float red = rd.nextFloat();
				float green = rd.nextFloat();
				float blue = rd.nextFloat();
				Color pixelColor = new Color(red, green, blue);
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
}
