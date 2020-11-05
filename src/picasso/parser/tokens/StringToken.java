package picasso.parser.tokens;

public class StringToken extends Token {

	private String str;

	public StringToken(String str) {
		super("String Token");
		this.str = str;
	}

	@Override
	public boolean isConstant() {
		return false;
	}

	@Override
	public boolean isFunction() {
		return false;
	}

	@Override
	public int getOrderOfOperation() {
		return CONSTANT;
	}

	public String toString() {
		return super.toString() + ": " + str;
	}
}
