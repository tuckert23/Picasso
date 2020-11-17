/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * @author taylor
 *
 */
public class NotToken extends CharToken implements OperationInterface {

	/**
	 * @param ch
	 */
	public NotToken() {
		super(CharConstants.BANG);
	}
	
	/**
	 * Returns the order of operations ranking
	 */
	
	public int getOrderOfOperation()
	{
		return NEGATE;
	}

}
