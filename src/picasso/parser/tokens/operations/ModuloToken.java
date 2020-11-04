/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.tokens.chars.CharToken;
import picasso.parser.language.CharConstants;


/**
 * @author taylor
 *
 */
public class ModuloToken extends CharToken implements OperationInterface {

	/**
	 * Constructs the ModuloToken object
	 */
	public ModuloToken() {
		super(CharConstants.MOD);
	}
	
	/**
	 * Gets order of operations ranking
	 */
	@Override
	public int getOrderOfOperation()
	{
		return MULTIPLY_OR_DIVIDE;
	}
}
