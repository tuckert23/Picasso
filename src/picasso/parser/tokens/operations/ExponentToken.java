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
	
	public int getOrderOfOperation()
	{
		return EXPONENTIATE;
	}
	

}
