package picasso.parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import picasso.parser.language.ExpressionTreeNode;
import java.lang.Class;

/**
 * All elements of the language (e.g., that make up ExpressionTree) should
 * extend ExpressionTreeNode.
 * 
 * @author Will Medick
 * 
 */
public class RandomExpressionTreeGenerator {

	final String unaryFunctionsPackage = "picasso.parser.language.expressions.unaryFunctions.";
	String[] unaryFunctionNames = { unaryFunctionsPackage + "Tan", unaryFunctionsPackage + "Sin",
			unaryFunctionsPackage + "Floor", unaryFunctionsPackage + "Abs", unaryFunctionsPackage + "Log" };

	final String binaryFunctionsPackage = "picasso.parser.language.expressions.operators.";
	String[] binaryFunctionNames = { binaryFunctionsPackage + "Addition", binaryFunctionsPackage + "Minus",
			binaryFunctionsPackage + "Multiply", binaryFunctionsPackage + "Divide",
			binaryFunctionsPackage + "Exponent" };

	final String operandsPackage = "picasso.parser.language.expressions.";
	String[] operandNames = { operandsPackage + "X", operandsPackage + "Y" };

	String[] expressions = { operandsPackage + "X", operandsPackage + "Y", binaryFunctionsPackage + "Addition",
			unaryFunctionsPackage + "Sin", binaryFunctionsPackage + "Divide", unaryFunctionsPackage + "Log",
			unaryFunctionsPackage + "Tan" };
//			binaryFunctionsPackage + "Multiply", unaryFunctionsPackage + "Floor",};
//	
	private static Random rnd = new Random();
	Map<String, Constructor<?>> nameToConstructor = new HashMap<>();

	/**
	 * 
	 * Constructor for the RandomExpressionTreeGenerator class.
	 * 
	 */
	public RandomExpressionTreeGenerator() {
		for (String unaryClassName : unaryFunctionNames) {
			try {
				Class<?> className = Class.forName(unaryClassName);
				Constructor<?> constructor = className
						.getDeclaredConstructor(picasso.parser.language.ExpressionTreeNode.class);
				nameToConstructor.put(unaryClassName, constructor);
			} catch (ClassNotFoundException e) {
				System.out.println("Class is not found");
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.out.println("No such method exists");
				e.printStackTrace();
			} catch (SecurityException e) {
				System.out.println("Security Exception");
				e.printStackTrace();
			}
		}

		for (String binaryClassName : binaryFunctionNames) {
			try {
				Class<?> className = Class.forName(binaryClassName);
				Constructor<?> constructor = className.getDeclaredConstructor(
						picasso.parser.language.ExpressionTreeNode.class,
						picasso.parser.language.ExpressionTreeNode.class);
				nameToConstructor.put(binaryClassName, constructor);
			} catch (ClassNotFoundException e) {
				System.out.println("Class is not found");
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.out.println("No such method exists");
				e.printStackTrace();
			} catch (SecurityException e) {
				System.out.println("Security Exception");
				e.printStackTrace();
			}

		}

		for (String operandClassName : operandNames) {
			try {
				Class<?> className = Class.forName(operandClassName);
				Constructor<?> constructor = className.getDeclaredConstructor();
				nameToConstructor.put(operandClassName, constructor);
			} catch (ClassNotFoundException e) {
				System.out.println("Class is not found");
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.out.println("No such method exists");
				e.printStackTrace();
			} catch (SecurityException e) {
				System.out.println("Security Exception");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Makes a single expression tree node.
	 * 
	 * @return etn
	 */
	public ExpressionTreeNode makeOneExpression() {
		String classString = expressions[rnd.nextInt(expressions.length)];
		Constructor<?> constructor = nameToConstructor.get(classString);
		int numParams = constructor.getParameterCount();
		ExpressionTreeNode[] params = new ExpressionTreeNode[numParams];

		for (int i = 0; i < numParams; i++) {

			params[i] = makeOneExpression();
		}

		if (numParams > 0) {

			try {
				ExpressionTreeNode etn = (ExpressionTreeNode) constructor.newInstance(params);
				return etn;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			ExpressionTreeNode etn;
			try {
				etn = (ExpressionTreeNode) constructor.newInstance();
				return etn;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}