/**
 * 
 */
package picasso.parser.tokens.operations;
import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the exponent sign token
 * 
 * @author taylor
 *
 */
public class ExponentToken extends CharToken implements OperationInterface {

	/**
	 * Constructs an ExponentToken object
	 */
	public ExponentToken() {
		super(CharConstants.CARET);
	}
	
	/**
	 * Returns the order of operations ranking
	 */
	@Override
	public int getOrderOfOperation()
	{
		return EXPONENTIATE;
	}
	

}
