package picasso.parser;

import java.util.Stack;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.*;
import picasso.parser.language.expressions.*;
import picasso.parser.language.expressions.operators.*;


/**
 * All elements of the language (e.g., that make up ExpressionTree) should
 * extend ExpressionTreeNode.
 * 
 * @author Will Medick
 * 
 */
public class RandomExpressionTreeGenerator {
	
	final String unaryFunctionsPackage = "picasso.parser.language.expressions.unaryFunctions.";
	String[] unaryFunctionNames = { unaryFunctionsPackage + "Tan", unaryFunctionsPackage + "Sin" };

	final String binaryFunctionsPackage = "picasso.parser.language.expressions.operators.";
	String[] binaryFunctionNames = { binaryFunctionsPackage + "Addition", binaryFunctionsPackage + "Minus" };
	
	final String operandsPackage = "picasso.parser.language.expressions.";
	String[] operandNames = { operandsPackage + "X", operandsPackage + "Y" };
	
	String[][] expressions = { unaryFunctionNames, binaryFunctionNames, operandNames };
	
	ExpressionTreeNode[] params;
	
	private static Random rnd = new Random();
	
	Map<String, Constructor<?>> nameToConstructor = new HashMap<>();
	
	public RandomExpressionTreeGenerator() {
		for (String unaryClassName : unaryFunctionNames) {
			try {
				Class<?> className = Class.forName(unaryClassName);
				Constructor<?> constructor = className.getDeclaredConstructor(picasso.parser.language.ExpressionTreeNode.class);
				nameToConstructor.put(unaryClassName, constructor);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (String binaryClassName : binaryFunctionNames) {
			try {
				Class<?> className = Class.forName(binaryClassName);
				System.out.print("test ");
				System.out.println(className);
				Constructor<?> constructor = className.getDeclaredConstructor(
						picasso.parser.language.ExpressionTreeNode.class,
						picasso.parser.language.ExpressionTreeNode.class);
				nameToConstructor.put(binaryClassName, constructor);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			for (String operandClassName : operandNames) {
				try {
					Class<?> className = Class.forName(operandClassName);
					System.out.print("test ");
					System.out.println(className);
					Constructor<?> constructor = className.getDeclaredConstructor();
					System.out.println(constructor);
					nameToConstructor.put(operandClassName, constructor);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
	
//	public void makeOneExpression() {
//		try {
//			String operandString = operandNames[rnd.nextInt(operandNames.length)];
//			Class<?> className = Class.forName(operandString);
//			Constructor<?> constructor = className.getDeclaredConstructor();
//			nameToConstructor.put(operandString, constructor);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
//		}
	

	public ExpressionTreeNode makeOneExpression() {
		for (Constructor<?> constructor : nameToConstructor.values()) {
			String[] classString = expressions[rnd.nextInt(expressions.length)];
			int numParams = constructor.getParameterCount();
			params = new ExpressionTreeNode[numParams];
			
//			if (numParams == 0)
//			{
//				return null;
//			}
//
//			if (numParams == 1) {
//				params[0] = makeOneExpression();
//				return params[0];
//			}
//			
//			if (numParams == 2) {
//				params[0] = makeOneExpression();
//				params[1] = makeOneExpression();
//				return params[0];
//			}
			
			for (int i = 0; i < numParams; i++) {
					params[i] = makeOneExpression();
			}

			try {
				ExpressionTreeNode etn = (ExpressionTreeNode) constructor.newInstance(params);
				System.out.print("Node: ");
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
