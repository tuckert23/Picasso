package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import picasso.parser.Tokenizer;
import picasso.parser.ParseException;
import picasso.parser.tokens.*;
import picasso.parser.tokens.chars.*;
import picasso.parser.tokens.functions.*;
import picasso.parser.tokens.operations.MinusToken;
import picasso.parser.tokens.operations.PlusToken;

public class TokenizerTest {

	Tokenizer tokenizer;
	List<Token> tokens;

	@Before
	public void setUp() throws Exception {
		tokenizer = new Tokenizer();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test that parsing a constant works
	 */
	@Test
	public void testTokenizeConstant() {
		String expression = ".324";
		List<Token> tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(.324), tokens.get(0));

		expression = "-1";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1), tokens.get(0));
		
		// No problems here; problem will be in next step (Semantic Analysis)
		expression = "-1.2";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new NumberToken(-1.2), tokens.get(0));
	}


	@Test
	public void testTokenizeColor() {
		String expression = "[1, 1, 1]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(1, 1, 1), tokens.get(0));

		expression = "[-1, 0, .5]";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new ColorToken(-1, 0, .5), tokens.get(0));
	}

	@Test(expected = ParseException.class)
	public void testTokenizeInvalidColor() {
		String expression = "[1, 1.0001, 1]";
		tokens = tokenizer.parseTokens(expression);
	}

	@Test
	public void testTokenizeBasicFunctionExpression() {
		String expression = "floor(x)";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new FloorToken(), tokens.get(0));
		assertEquals(new LeftParenToken(), tokens.get(1));
		assertEquals(new IdentifierToken("x"), tokens.get(2));
		assertEquals(new RightParenToken(), tokens.get(3));
	}
	
	@Test
	public void testTokenizeBasicOperatorExpression() {
		String expression = "x + y - bugs";
		tokens = tokenizer.parseTokens(expression);
		assertEquals(new IdentifierToken("x"), tokens.get(0));
		assertEquals(new PlusToken(), tokens.get(1));
		assertEquals(new IdentifierToken("y"), tokens.get(2));
		assertEquals(new MinusToken(), tokens.get(3));
		assertEquals(new IdentifierToken("bugs"), tokens.get(4));
	}

	@Test
	public void testTokenizeCombinedFunctionExpression() {
		String expression = "perlinColor(floor(x), y)";
		List<Token> tokens = tokenizer.parseTokens(expression);
		// TODO: Check the tokens...

		expression = "sin(perlinColor(x, y))";
		tokens = tokenizer.parseTokens(expression);
		// TODO: Check the tokens...
	}

	// TODO: Test arithmetic (rather than function-based) expressions ...

}
