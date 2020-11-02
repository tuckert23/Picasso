package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;


public class DivideToken extends CharToken implements OperationInterface {

	public DivideToken() {
		super(CharConstants.SLASH);
	}
	
	@Override
	public int getOrderOfOperation() {
		return MULTIPLY_OR_DIVIDE;
	}
}
