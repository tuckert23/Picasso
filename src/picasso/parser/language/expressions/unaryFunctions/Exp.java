/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.UnaryFunction;
import java.lang.Math;

/**
 * @author taylor
 *
 */
public class Exp extends UnaryFunction {

	/**
	 * @param param
	 */
	public Exp(ExpressionTreeNode param) {
		super(param);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		
		double red = Math.exp(result.getRed());
		double green = Math.exp(result.getGreen());
		double blue = Math.exp(result.getBlue());
		
		
		if (red > 1)
		{
			red = 1;
		}
		else if (red < -1)
		{
			red = -1;
		}
		
		if (green > 1)
		{
			green = 1;
		}
		else if (green < -1)
		{
			green = -1;
		}
		
		if (blue > 1)
		{
			blue = 1;
		}
		else if (blue < -1)
		{
			blue = -1;
		}

		
		
		
		return new RGBColor(red, green, blue);
	}

}
