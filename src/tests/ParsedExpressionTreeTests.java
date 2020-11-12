package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.language.expressions.operators.*;
import picasso.parser.language.expressions.unaryFunctions.Floor;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle.
 * 
 */
public class ParsedExpressionTreeTests {

	private ExpressionTreeGenerator parser;

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
	}

	@Test
	public void PlusExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Plus(new X(), new Y()), e);

		assertNotEquals(new Minus(new X(), new Y()), e); 

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Plus(new RGBColor(1, .3, -1), new Y()), e);

		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Plus(new Plus(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Plus(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Plus(new X(), new Plus(new Y(), new RGBColor(1, 1, 1))), e);
	}

	@Test
	public void floorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Plus(new X(), new Y())), e);
	}
	
	// Danny and Will work on more tests for binary operators
	
	@Test
	public void MinusExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x - y");
		assertEquals(new Minus(new X(), new Y()), e);

		assertNotEquals(new Plus(new X(), new Y()), e); 

		e = parser.makeExpression("[1,.3,-1] - y");
		assertEquals(new Minus(new RGBColor(1, .3, -1), new Y()), e);

		e = parser.makeExpression("x - y - [ -.51, 0, 1]");
		assertEquals(new Minus(new Minus(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	@Test public void MultiplyExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x * y");
		assertEquals(new Multiply(new X(), new Y()), e);

		assertNotEquals(new Divide(new X(), new Y()), e); 

		e = parser.makeExpression("[1,.3,-1] * y");
		assertEquals(new Multiply(new RGBColor(1, .3, -1), new Y()), e);

		e = parser.makeExpression("x * y * [ -.51, 0, 1]");
		assertEquals(new Multiply(new Multiply(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	// Taylor work on unary function tests

}