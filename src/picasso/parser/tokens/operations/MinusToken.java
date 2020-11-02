package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

public class MinusToken extends CharToken implements OperationInterface {

	public MinusToken() {
		super(CharConstants.MINUS);
	}

}
