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
public class MultiplyToken extends CharToken implements OperationInterface {

	/**
	 * Constructs the MultiplyToken object
	 */
	public MultiplyToken() {
		super(CharConstants.STAR);
	}
	
	/**
	 * Gives the order of operations ranking
	 */
	@Override
	public int getOrderOfOperation() {
		return MULTIPLY_OR_DIVIDE;
	}

}
