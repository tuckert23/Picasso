/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.StringToken;

/**
 * @author Abdelrahman AboEitta
 *
 */

public class Str extends ExpressionTreeNode {
	
	private String myString;
	
	public Str(StringToken strToken) {
		myString = strToken.getString();
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return null;
	}

}
