package picasso.parser;

import java.util.Stack;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.UnaryFunction;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.BinaryOperatorsOrFunctions;


/**
 * All elements of the language (e.g., that make up ExpressionTree) should
 * extend ExpressionTreeNode.
 * 
 * @author Will Medick
 */
public class RandomExpressionTreeGenerator {
	
	final String unaryFunctionsPackage = "picasso.parser.language.expressions.unaryFunctions.";
	String[] unaryFunctionNames = { unaryFunctionsPackage + "Tan", unaryFunctionsPackage + "Sin" };

	final String binaryFunctionsPackage = "picasso.parser.language.expressions.operators.";
	String[] binaryFunctionNames = { binaryFunctionsPackage + "Addition" };
	
	final String operandsPackage = "picasso.parser.language.expressions.";
	String[] operandNames = { operandsPackage + "X", operandsPackage + "Y" };
	
	String[][] expressions = { unaryFunctionNames, binaryFunctionNames, operandNames };

	private static Random rnd = new Random();
	
	Map<String, Constructor<?>> nameToConstructor = new HashMap<>();
	
	public RandomExpressionTreeGenerator() {
		super();
	}		
	
	
	public ExpressionTreeNode makeOneExpression() {
		String[] classString = expressions[rnd.nextInt(expressions.length)];
		
		if (classString == operandNames) {

			try {
				String operandString = operandNames[rnd.nextInt(operandNames.length)];
				Class<?> className = Class.forName(operandString);
				Constructor<?> constructor = className.getDeclaredConstructor();
				nameToConstructor.put(operandString, constructor);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		if (classString == unaryFunctionNames) {
			try {
				String unaryString = unaryFunctionNames[rnd.nextInt(unaryFunctionNames.length)];
				Class<?> className = Class.forName(unaryString);
				System.out.println(className);
				Constructor<?> constructor = className.getDeclaredConstructor(picasso.parser.language.ExpressionTreeNode.class);
				System.out.println(constructor);
				nameToConstructor.put(unaryString, constructor);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		if (classString == binaryFunctionNames) {
			try {
				String binaryString = binaryFunctionNames[rnd.nextInt(binaryFunctionNames.length)];
				Class<?> className = Class.forName(binaryString);
				Constructor<?> constructor = className.getDeclaredConstructor(
						picasso.parser.language.ExpressionTreeNode.class,
						picasso.parser.language.ExpressionTreeNode.class);
				nameToConstructor.put(binaryString, constructor);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		for (Constructor<?> constructor : nameToConstructor.values()) {
			int numParams = constructor.getParameterCount();

			ExpressionTreeNode[] params = new ExpressionTreeNode[numParams];

			for (int i = 0; i < numParams; i++) {
				params[i] = makeOneExpression();
			}

			try {
				ExpressionTreeNode etn = (ExpressionTreeNode) constructor.newInstance(params);
				System.out.println(etn);
				return etn;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
		
}
