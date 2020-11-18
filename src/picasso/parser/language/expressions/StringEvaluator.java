package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;

/**
 * @author Abdelrahman AboEitta for the base
 * @author taylor for the extension
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
										"(x + y)", "(x * y)",
										"(x - y)", "(y - x)", 
										"(x / y)", "(y / x)",
										"(x % y)", "(y % x)"};
	

	private final String[] OPERATIONS = {" + ", " - ", " / ", " % ", " * "}; 
										 // " + !", " - !", " / !", " % !", " * !"};
										 // The above functionality in terms of operations could be implemented,
										 // however, these tend to make the pictures very intense.
	
	private final int LEN_FUNCTIONS = FUNCTIONS.length;
	private final int LEN_OPERATIONS = OPERATIONS.length;
	private ExpressionTreeNode node;

	
	/**
	 * Take in the string from the token and tries to evaluate as a file first, and then as a string second
	 * 
	 * @param str
	 */
	public StringEvaluator(String str) {
		myString = str;
		readImage(myString);
		
		if (!image)
		{
			System.out.println("Image at the given path could not be found. Generating a unique image from the given string.");
			treeFromString(myString);
		}
			
	}

	/**
	 * Takes in the x and y parameters. Displays the image pixel by pixel if it is an image,
	 * and evaluates the generated expression from the string if the string is not an image
	 * 
	 * @param x
	 * @param y
	 * 
	 */
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
			return node.evaluate(x, y);
		}
	}

	/**
	 * Binds the image to the correct scale
	 * @param value
	 * @param bound
	 * @return
	 */
	public static int domainScaleToImage(double value, int bound) {
		//return (int) ((value/2) + 0.5) * 799;
		return (int) ((++value * bound) / 2) + 399;
	}

	/**
	 * Takes in the string and opens the file if it can be linked to an image in the directory, or returns
	 * false if the string does not represent an image in a directory
	 * 
	 * @param imageName
	 * @return if it is an image or not
	 */
	private void readImage(String imageName) {
		String[] pathFolders = imageName.split("/");
		if (pathFolders.length == 1) {
			try {
				myImage = ImageIO.read(new File(DEFAULT_PATH + imageName));
				image = true;
			} catch (IOException e) {
			}
		} else {
			try {
				myImage = ImageIO.read(new File(imageName));
				image = true;
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * Takes a string as input. Translates the string into it's unique HashCode then builds an expression using 
	 * modulo to choose a deterministic expression based on the functions and expressions defined above.
	 * 
	 * This will set the private class attribute node equal to the root node of the tree representing the parsed expression
	 * 
	 * @param str
	 */
	private void treeFromString(String str)
	{
		hash = Math.abs(str.hashCode());
		
		if (hash < 100)
		{
			hash += "Washington and Lee".hashCode();
		}
		
		String expression = "0";
		
		for (int i = 0; i < 10; i++)
		{
			String function  = FUNCTIONS[hash % LEN_FUNCTIONS];
			String operation = OPERATIONS[hash % LEN_OPERATIONS];
			expression += operation + function;
			hash /= 2;
		}
		
		System.out.println("Expression generated: " + expression +"\n");
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		node = expTreeGen.makeExpression(expression);
		
	}
}
