package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Abdelrahman AboEitta
 * @author taylor
 */
public class StringEvaluator extends ExpressionTreeNode {

	private String myString;
	public BufferedImage myImage;
	private static final String DEFAULT_PATH = "images/";
	private boolean image = false;
	private int hash;
	/*
	private ArrayList fns = ["floor", "sin", "abs", "log", "rgbToYCrCB", "YCrCbtoRGB"
	                         sin
	                         abs
	                         log
	                         rgbToYCrCb
	                         yCrCbtoRGB
	                         perlinColor
	                         perlinBW
	                         atan
	                         tan
	                         cos
	                         wrap
	                         not
	                         clamp
	                         exp
	                         imageWrap];
	*/
	
	public StringEvaluator(String str) {
		myString = str;
		if (!readImage(myString))
		{
			readString(myString);
		}
			
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		if (image)
		{
			int xDomain = domainScaleToImage(x, myImage.getWidth());
			int yDomain = domainScaleToImage(y, myImage.getHeight());
			Color pixColor = new Color(myImage.getRGB(xDomain, yDomain));
			return new RGBColor(pixColor);
		}
		else
		{
			return new RGBColor(new Color(hash));
		}
	}

	public int domainScaleToImage(double value, int bound) {
		return (int) (++value * bound) / 2;
	}

	private boolean readImage(String imageName) {
		String[] pathFolders = imageName.split("/");
		boolean success = false;
		if (pathFolders.length == 1) {
			try {
				myImage = ImageIO.read(new File(DEFAULT_PATH + imageName));
				success = true;
				image = true;
			} catch (IOException e) {
			}
		} else {
			try {
				myImage = ImageIO.read(new File(imageName));
				success = true;
				image = true;
			} catch (IOException e) {
			}
		}
		return success;
	}
	
	private void readString(String str)
	{
		hash = Math.abs(str.hashCode());
		System.out.println(hash);
	}
}
