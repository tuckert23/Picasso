package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import picasso.parser.ExpressionTreeGenerator;
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
	private final String[] FUNCTIONS = {"floor(x)", "floor(y)", 
										"sin(y)", "sin(x)", 
										"abs(x)", "abs(y)", 
										"log(x)", "log(y)", 
										"rgbToYCrCb(y)", "rgbToYCrCb(x)", 
										"yCrCbtoRGB(x)", "yCrCbtoRGB(y)", 
										"perlinColor(x, y)","perlinColor(y, x)", 
										"perlinBW(y, x)", "perlinBW(x, y)", 
										"atan(x)", "atan(y)", 
										"tan(y)", "tan(x)", 
										"cos(y)", "cos(x)", 
										"wrap(x)", "wrap(y)", 
										"!y", "!x", 
										"clamp(y)", "clamp(x)", 
										"exp(x)", "exp(y)",
										"ceiling(x)", "ceiling(y)",
										"x + y", "x * y",
										"x - y", "y - x", 
										"x / y", "y / x",
										"x % y", "y % x"};
	

	private final String[] OPERATIONS = {" + ", " - ", " / ", " % ", " * "}; 
										 //" + !", " - !", " / !", " % !", " * !"};
	
	private final int LEN_FUNCTIONS = FUNCTIONS.length;
	private final int LEN_OPERATIONS = OPERATIONS.length;
	private ExpressionTreeNode node;

	
	
	public StringEvaluator(String str) {
		myString = str;
		if (!readImage(myString))
		{
			treeFromString(myString);
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
			// return new RGBColor(new Color(hash));
			return node.evaluate(x, y);
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
	
	/**
	 * Takes a string as input. Translates the string into its unique has code then builds an expression using 
	 * modulo to choose a deterministic function defined above.
	 * @param str
	 */
	private void treeFromString(String str)
	{
		hash = Math.abs(str.hashCode());
		System.out.println("Hash before: " + hash);
		
		if (hash < 100)
		{
			hash += "Washington and Lee".hashCode();
			System.out.println("Hash after: " + hash);
		}
		
		String expression = "0";
		
		for (int i = 0; i < 10; i++)
		{
			String function  = FUNCTIONS[hash % LEN_FUNCTIONS];
			String operation = OPERATIONS[hash % LEN_OPERATIONS];
			expression = expression + operation + function;
			hash /= 2;
		}
		System.out.println(expression);
		
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		node = expTreeGen.makeExpression(expression);
		
	}
}
