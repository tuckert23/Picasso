package picasso.parser.language.expressions.binaryFunctions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Binary;
import picasso.parser.language.expressions.RGBColor;


public class ImageWrap extends Binary {
	
	private String myString;
	private BufferedImage myImage;
	private static final String DEAFULT_PATH = "images/";

	public ImageWrap(ExpressionTreeNode left, ExpressionTreeNode right, String str) {
		super(left, right);
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
	
	private double wrap(double num) {
		num += 3;
		num %= 2;
		num -= 1;
		return num;
	}
}
