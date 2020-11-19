package picasso.parser.tokens;

/**
 * Represents an String token
 * 
 * @author Abdelrahman AboEitta
 */
public class StringToken extends Token {

	private String str;

	/**
	 * Constructs a token representing the string
	 * 
	 * @param string the string of this stringToken
	 */
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

	/**
	 * return a string representation of the token
	 * 
	 * @return a string representation of the token
	 */
	public String toString() {
		return super.toString() + ": " + str;
	}

	/**
	 * @return true iff o is a StringToken with same String
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof StringToken)) {
			return false;
		}
		StringToken other = (StringToken) o;
		return this.str == other.str;
	}

	/**
	 * return the string in a stringToken
	 * 
	 * @return the string in a stringToken
	 */
	public String getString() {
		return str;
	}
}
