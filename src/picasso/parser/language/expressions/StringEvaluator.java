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
	private BufferedImage myImage;
	private static final String DEAFULT_PATH = "images/";
	
	public StringEvaluator(String str) {
		myString = str;
		try {
			myImage = ImageIO.read(new File(DEAFULT_PATH + myString));
		} catch (IOException e) {
		}
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		int xDomain = domainScaleToImage(x, myImage.getWidth());
		int yDomain = domainScaleToImage(y, myImage.getHeight());
		Color pixColor = new Color(myImage.getRGB(xDomain, yDomain));
		return new RGBColor(pixColor);
	}
	
	private int domainScaleToImage(double value, int bound) {
		return (int) (++value * bound) / 2;
	}

}
