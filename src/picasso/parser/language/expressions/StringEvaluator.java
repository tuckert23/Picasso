/**
 * 
 */
package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class StringEvaluator extends ExpressionTreeNode {

	private String myString;
	private BufferedImage img;
	
	public StringEvaluator(String str) {
		myString = str;
		try {
			img = ImageIO.read(new File(myString));
		} catch (IOException e) {
		}
	}

	private int domainScaleToImage(double value, int bound) {
		value += 1;
		return (int) (value * bound) / 2;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		int xDomain = domainScaleToImage(x, img.getWidth());
		int yDomain = domainScaleToImage(y, img.getHeight());
		Color pixColor = new Color(img.getRGB(xDomain, yDomain));
		return new RGBColor(pixColor);
	}

}
