package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.language.expressions.operators.*;
import picasso.parser.language.expressions.unaryFunctions.*;
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
	
	@Test
	public void DivideExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x / y");
		assertEquals(new Divide(new X(), new Y()), e);

		assertNotEquals(new Multiply(new X(), new Y()), e); 

		e = parser.makeExpression("[1,.3,-1] / y");
		assertEquals(new Divide(new RGBColor(1, .3, -1), new Y()), e);

		e = parser.makeExpression("x / y / [ -.51, 0, 1]");
		assertEquals(new Divide(new Divide(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	@Test
	public void ExponentExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x ^ y");
		assertEquals(new Exponent(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] ^ y");
		assertEquals(new Exponent(new RGBColor(1, .3, -1), new Y()), e);

		e = parser.makeExpression("x ^ y ^ [ -.51, 0, 1]");
		assertEquals(new Exponent(new Exponent(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	
	
	
	
	
	
	
	
	
	
	//Taylors Work Started here and there are a lot of fails
	
	@Test
	public void AbsoluteValueExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("abs(x)");
		assertEquals(new Abs(new X()), e);
		
		e = parser.makeExpression("abs(y)");
		assertEquals(new Abs(new Y()), e);
		
		e = parser.makeExpression("abs(-1)");
		assertEquals(new Abs(new Constant(-1)), e);
		
		e = parser.makeExpression("abs(x + y)");
		assertEquals(new Abs(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void AtanExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("atan(x)");
		assertEquals(new Atan(new X()), e);
		
		e = parser.makeExpression("atan(y)");
		assertEquals(new Atan(new Y()), e);
		
		e = parser.makeExpression("atan(x + y)");
		assertEquals(new Atan(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void CeilingExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("ceil(x)");
		assertEquals(new Ceiling(new X()), e);
		
		e = parser.makeExpression("ceil(y)");
		assertEquals(new Ceiling(new Y()), e);
		
		e = parser.makeExpression("abs(x + y)");
		assertEquals(new Ceil(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void CosExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("cos(x)");
		assertEquals(new Cos(new X()), e);
		
		e = parser.makeExpression("cos(y)");
		assertEquals(new Cos(new Y()), e);
		
		e = parser.makeExpression("cos(x + y)");
		assertEquals(new Cos(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void ExpExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("exp(x)");
		assertEquals(new Exp(new X()), e);
		
		e = parser.makeExpression("exp(y)");
		assertEquals(new Exp(new Y()), e);
		
		e = parser.makeExpression("exp(x + y)");
		assertEquals(new Exp(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void FloorExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("floor(x)");
		assertEquals(new Floor(new X()), e);
		
		e = parser.makeExpression("floor(y)");
		assertEquals(new Floor(new Y()), e);
		
		e = parser.makeExpression("floor(x + y)");
		assertEquals(new Floor(new Plus(new X(), new Y())), e);

	}
	
	@Test
	public void LogExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("log(x)");
		assertEquals(new Log(new X()), e);
		
		e = parser.makeExpression("log(y)");
		assertEquals(new Log(new Y()), e);

		e = parser.makeExpression("log(x + y)");
		assertEquals(new Log(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void NotExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("!x");
		assertEquals(new Not(new X()), e);
		
		e = parser.makeExpression("!y");
		assertEquals(new Not(new Y()), e);
		
		e = parser.makeExpression("!(x + y)");
		assertEquals(new Not(new Plus(new X(), new Y())), e);
		
	}
	
	@Test
	public void RgbToYCrCbExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("rgbToYCrCb(x)");
		assertEquals(new RgbToYCrCb(new X()), e);
		
		e = parser.makeExpression("rgbToYCrCb(y)");
		assertEquals(new RgbToYCrCb(new Y()), e);
		
		e = parser.makeExpression("rgbToYCrCb(x + y)");
		assertEquals(new RgbToYCrCb(new Plus(new X(), new Y())), e);
		
	}
	
	@Test
	public void SinExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("sin(x)");
		assertEquals(new Sin(new X()), e);
		
		e = parser.makeExpression("sin(y)");
		assertEquals(new Sin(new Y()), e);

		e = parser.makeExpression("sin(x + y)");
		assertEquals(new Sin(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void TanExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("tan(x)");
		assertEquals(new Tan(new X()), e);
		
		e = parser.makeExpression("tan(y)");
		assertEquals(new Tan(new Y()), e);
		
		e = parser.makeExpression("tan(x + y)");
		assertEquals(new Tan(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void WrapExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("wrap(x)");
		assertEquals(new Wrap(new X()), e);
		
		e = parser.makeExpression("wrap(y)");
		assertEquals(new Wrap(new Y()), e);
		
		e = parser.makeExpression("wrap(x + y)");
		assertEquals(new Wrap(new Plus(new X(), new Y())), e);
	}
	
	@Test
	public void YCrCbtoRGBExpressionTest()
	{
		ExpressionTreeNode e = parser.makeExpression("yCrCbtoRGB(x)");
		assertEquals(new YCrCbtoRGB(new X()), e);
		
		e = parser.makeExpression("yCrCbtoRGB(y)");
		assertEquals(new YCrCbtoRGB(new Y()), e);
		
		e = parser.makeExpression("yCrCbtoRGB(x + y)");
		assertEquals(new YCrCbtoRGB(new Plus(new X(), new Y())), e);

	}
	
	// Taylor work on unary function tests

}