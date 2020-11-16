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
	public BufferedImage myImage;
	private static final String DEFAULT_PATH = "images/";

	public StringEvaluator(String str) {
		myString = str;
		readImage(myString);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		int xDomain = domainScaleToImage(x, myImage.getWidth());
		int yDomain = domainScaleToImage(y, myImage.getHeight());
		Color pixColor = new Color(myImage.getRGB(xDomain, yDomain));
		return new RGBColor(pixColor);
	}

	public int domainScaleToImage(double value, int bound) {
		return (int) (++value * bound) / 2;
	}

	private void readImage(String imageName) {
		String[] pathFolders = imageName.split("/");
		if (pathFolders.length == 1) {
			try {
				myImage = ImageIO.read(new File(DEFAULT_PATH + imageName));
			} catch (IOException e) {
			}
		} else {
			try {
				myImage = ImageIO.read(new File(imageName));
			} catch (IOException e) {
			}
		}
	}
}
