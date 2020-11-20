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
import java.util.ArrayList;
import java.lang.Class;

/**
 * All elements of the language (e.g., that make up ExpressionTree) should
 * extend ExpressionTreeNode.
 * 
 * @author Will Medick
 * 
 */
public class RandomExpressionTreeGenerator {
	
//	public static void main(String[] args) {
//		
//		RandomExpressionTreeGenerator test = new RandomExpressionTreeGenerator();
//		System.out.println(test.makeOneExpression());
//	}
	
	final String unaryFunctionsPackage = "picasso.parser.language.expressions.unaryFunctions.";
	String[] unaryFunctionNames = {unaryFunctionsPackage + "Tan", unaryFunctionsPackage + "Sin",
			unaryFunctionsPackage + "Floor", unaryFunctionsPackage + "Abs", unaryFunctionsPackage + "Log"};

	final String binaryFunctionsPackage = "picasso.parser.language.expressions.operators.";
	String[] binaryFunctionNames = { binaryFunctionsPackage + "Addition", binaryFunctionsPackage + "Minus",
			binaryFunctionsPackage + "Multiply", binaryFunctionsPackage + "Divide",
			binaryFunctionsPackage + "Exponent"};
	
	final String operandsPackage = "picasso.parser.language.expressions.";
	String[] operandNames = { operandsPackage + "X", operandsPackage + "Y" };

	String[] expressions = {operandsPackage + "X", operandsPackage + "Y", 
			binaryFunctionsPackage + "Addition",
			unaryFunctionsPackage + "Sin",
			binaryFunctionsPackage + "Divide", unaryFunctionsPackage + "Log", unaryFunctionsPackage + "Tan"};
//			binaryFunctionsPackage + "Multiply", unaryFunctionsPackage + "Floor",};
//	
	private static Random rnd = new Random();
	Map<String, Constructor<?>> nameToConstructor = new HashMap<>();

//public class RandomExpressionTreeGenerator {
//	
//  private String[] constructorNames = {"Sin", "Tan", "Addition", "Minus", "X", "Y"};
//  private int[] constructorParams = {1, 1, 2, 2, 0, 0};
  //private Map<String, Integer> constructorParams = new HashMap<String, Integer>();
  //constructorParams.put("Sin", new Integer(1));
  //constructorParams.put("Tan", new Integer(1));
  
  
  // private Map<String, int> constructorParams = {"Sin", 1, "Tan", 1, "Addition", 2, "Minus", 2, "X", 0, "Y", 0};
//  private int lenConstNames = constructorNames.length;
//  private Random rand = new Random();
 
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
  
  
  
//	private ExpressionTreeNode makeOneExpression() {
//		int ind = rand.nextInt(lenConstNames);
//	    String randConstructor = constructorNames[ind];
//	    int numParams = constructorParams[ind];
//	 
//	    if (numParams == 0)
//	    {
//	      return (ExpressionTreeNode) Class.forName(randConstructor).newInstance();
//	    }
//	    else if (numParams == 1)
//	    {
//	      return (ExpressionTreeNode) Class.forName(randConstructor).newInstance(makeOneExpression());
//	    }
//	    else if (numParams == 2)
//	    {
//	      return (ExpressionTreeNode) Class.forName(randConstructor).newInstance(makeOneExpression(), makeOneExpression());
//	    }
// 
//  }
//}

	public ExpressionTreeNode makeOneExpression() {
			String classString = expressions[rnd.nextInt(expressions.length)];
			Constructor<?> constructor = nameToConstructor.get(classString);
			int numParams = constructor.getParameterCount();
			ExpressionTreeNode[] params = new ExpressionTreeNode[numParams];
			System.out.println(numParams);
			System.out.println(classString);
			
			for (int i = 0; i < numParams; i++) {
					System.out.println("This Node: ");
					params[i] = makeOneExpression();
			}
			
			if (numParams > 0)
			{

			try {
				ExpressionTreeNode etn = (ExpressionTreeNode) constructor.newInstance(params);
				System.err.print("Node: ");
				System.err.println(etn);
				return etn;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			}
			else
			{
			ExpressionTreeNode etn;
			try {
				etn = (ExpressionTreeNode) constructor.newInstance();
				return etn;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			return null;
	}
		
}
