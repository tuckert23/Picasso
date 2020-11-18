package picasso.parser.language.expressions;

import java.awt.Color;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Special color class for Picasso. Represents colors by their red, green, and
 * blue components. Each color component is on a scale of [-1,1]. When the color
 * is evaluated in the expression tree, it is the color.
 *
 */

public class RGBColor extends ExpressionTreeNode {
	public static final double COLOR_MIN = -1;
	public static final double COLOR_MAX = 1;
	public static final int JAVA_COLOR_MAX = 255;

	private double myRed;
	private double myGreen;
	private double myBlue;

	/**
	 * Create an RGBColor object that has the given amount of red, green, and blue.
	 * All components are on a scale of [-1, 1]
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 */
	
	public RGBColor(double red, double green, double blue) {
		myRed = red;
		myGreen = green;
		myBlue = blue;
	}

	/**
	 * Copy a Java Color object into a Picasso RGBColor object
	 * 
	 * @param javaColor the color to convert into a Picassoc RGBColor object
	 */
	
	public RGBColor(Color javaColor) {
		myRed = toDouble(javaColor.getRed());
		myGreen = toDouble(javaColor.getGreen());
		myBlue = toDouble(javaColor.getBlue());
	}

	public double getRed() {
		return myRed;
	}

	public double getGreen() {
		return myGreen;
	}

	public double getBlue() {
		return myBlue;
	}

	public void clamp() {
		myRed = clamp(myRed);
		myGreen = clamp(myGreen);
		myBlue = clamp(myBlue);
	}

	public Color toJavaColor() {
		clamp();
		return new Color(toInt(myRed), toInt(myGreen), toInt(myBlue));
	}

	public boolean equals(Object o) {
		if (o instanceof RGBColor) {
			RGBColor other = (RGBColor) o;
			return myRed == other.myRed && myGreen == other.myGreen && myBlue == other.myBlue;
		}
		return false;
	}

	public String toString() {
		return "Color: " + getRed() + " " + getGreen() + " " + getBlue();
	}

	/**
	 * Convert the Java color's component value (from [0,255]) to the [-1,1] range
	 * needed for Picasso
	 * 
	 * @param value the color's component value (from [0,255])
	 * @return the value of the color component, scaled from [1,1]
	 */
	
	protected double toDouble(int value) {
		double range = COLOR_MAX - COLOR_MIN;
		return (double) value / JAVA_COLOR_MAX * range + COLOR_MIN;
	}

	/**
	 * Convert the Picasso color's component value (from [-1,1] to the Java color's
	 * component (from [0,255])
	 * 
	 * @param value the color's component value (from [-1,1s])
	 * @return the value of the color component, scaled from [0,255]
	 */
	
	protected int toInt(double value) {
		double range = COLOR_MAX - COLOR_MIN;
		return (int) ((value - COLOR_MIN) / range * JAVA_COLOR_MAX);
	}

	protected static double clamp(double value) {
		return Math.max(COLOR_MIN, Math.min(COLOR_MAX, value));
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return this;
	}
}
