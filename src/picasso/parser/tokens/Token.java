/**
 * 
 */
package picasso.parser.tokens;

/**
 * Represents tokens in the Picasso programming language
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 *
 */
public abstract class Token {

	public static final int CONSTANT = 0;
	public static final int ASSIGNMENT = 1;
	public static final int ADD_OR_SUBTRACT = 2;
	public static final int MULTIPLY_OR_DIVIDE = 3;
	public static final int EXPONENTIATE = 4;
	public static final int NEGATE = 5;
	public static final int GROUPING = 6; // parens

	private String description;

	/**
	 * Creates a token with the given description
	 * 
	 * @param description the token's description
	 */
	public Token(String description) {
		this.description = description;
	}

	/**
	 * Represents the token by its description
	 * 
	 * @return the token's description
	 */
	@Override
	public String toString() {
		return description;
	}

	/**
	 * Returns true if this token represents a constant, false otherwise
	 * 
	 * @return true iff this Token represents a constant
	 */
	public abstract boolean isConstant();

	/**
	 * Returns true if this token represents a function, false otherwise
	 * 
	 * @return true iff this Token represents a function
	 */
	public abstract boolean isFunction();

	/**
	 * A method to get the order of operation of a specific token
	 * 
	 * @return the order of operation
	 */
	public abstract int getOrderOfOperation();

}
