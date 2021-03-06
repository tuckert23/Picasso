/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("[1, -1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testPlusEvaluation() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		ExpressionTreeNode f = parser.makeExpression("x + y + [0.2, 0.2, 0.2]");
		ExpressionTreeNode g = parser.makeExpression("sin(x) + floor(y)");
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				assertEquals(new RGBColor(x + y, x + y, x + y), e.evaluate(x, y));
				assertEquals(new RGBColor(x + y + 0.2, x + y + 0.2, x + y + 0.2), f.evaluate(x, y));
				assertEquals(new RGBColor(Math.sin(x) + Math.floor(y), Math.sin(x) + Math.floor(y),
						Math.sin(x) + Math.floor(y)), g.evaluate(x, y));
			}
		}
	}
	// TODO: add more tests
}
