/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;

/**
 * @author taylor
 *
 */
public class Clamp extends UnaryFunction {

	/**
	 * @param param
	 */
	public Clamp(ExpressionTreeNode param) {
		super(param);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		
		double red;
		double green;
		double blue;
		
		if (result.getRed() > 1)
		{
			red = 1;
		}
		else if (result.getRed() < -1)
		{
			red = -1;
		}
		else
		{
			red = result.getRed();
		}
		
		if (result.getBlue() > 1)
		{
			blue = 1;
		}
		else if (result.getBlue() < -1)
		{
			blue = -1;
		}
		else
		{
			blue = result.getBlue();
		}
		
		if (result.getGreen() > 1)
		{
			green = 1;
		}
		else if (result.getGreen() < -1)
		{
			green = -1;
		}
		else
		{
			green = result.getGreen();
		}
		
		return new RGBColor(red, green, blue);
	}

}
