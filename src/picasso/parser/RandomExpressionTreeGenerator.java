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
//public class RandomExpressionTreeGenerator {
//	
//	final String unaryFunctionsPackage = "picasso.parser.language.expressions.unaryFunctions.";
//	String[] unaryFunctionNames = { unaryFunctionsPackage + "Tan", unaryFunctionsPackage + "Sin" };
//
//	final String binaryFunctionsPackage = "picasso.parser.language.expressions.operators.";
//	String[] binaryFunctionNames = { binaryFunctionsPackage + "Addition", binaryFunctionsPackage + "Minus" };
//	
//	final String operandsPackage = "picasso.parser.language.expressions.";
//	String[] operandNames = { operandsPackage + "X", operandsPackage + "Y" };
//
//	String[] expressions = { unaryFunctionsPackage + "Tan", unaryFunctionsPackage + "Sin",
//			binaryFunctionsPackage + "Addition", binaryFunctionsPackage + "Minus",
//			operandsPackage + "X", operandsPackage + "Y"};
//	
//	ExpressionTreeNode[] params;
//	
//	private static Random rnd = new Random();
//	Map<String, Constructor<?>> nameToConstructor = new HashMap<>();

public class RandomExpressionTreeGenerator {
	
  private String[] constructorNames = {"Sin", "Tan", "Addition", "Minus", "X", "Y"};
  private int[] constructorParams = {1, 1, 2, 2, 0, 0};
  //private Map<String, Integer> constructorParams = new HashMap<String, Integer>();
  //constructorParams.put("Sin", new Integer(1));
  //constructorParams.put("Tan", new Integer(1));
  
  
  // private Map<String, int> constructorParams = {"Sin", 1, "Tan", 1, "Addition", 2, "Minus", 2, "X", 0, "Y", 0};
  private int lenConstNames = constructorNames.length;
  private Random rand = new Random();
 
  private ExpressionTreeNode makeOneExpression()
  {
	int ind = rand.nextInt(lenConstNames);
    String randConstructor = constructorNames[ind];
    int numParams = constructorParams[ind];
    
 
 
    if (numParams == 0)
    {
      return (ExpressionTreeNode) Class.forName(randConstructor).newInstance();
    }
    else if (numParams == 1)
    {
      return (ExpressionTreeNode) Class.forName(randConstructor).newInstance(makeOneExpression());
    }
    else if (numParams == 2)
    {
      return (ExpressionTreeNode) Class.forName(randConstructor).newInstance(makeOneExpression(), makeOneExpression());
    }
 
  }
}

	
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

//	public ExpressionTreeNode makeOneExpression() {
//			String classString = expressions[rnd.nextInt(expressions.length)];
//			Constructor<?> constructor = nameToConstructor.values();
//			params = new ExpressionTreeNode[numParams];
//			numParams = 
//			
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
//				return params[0];
//			}
//			
//			for (int i = 0; i < numParams; i++) {
//					System.err.println("This Node: ");
//					params[i] = new makeOneExpression();
//			}
//
//			try {
//				ExpressionTreeNode etn = (ExpressionTreeNode) constructor.newInstance(params);
//				System.err.print("Node: ");
//				System.err.println(etn);
//				return etn;
//			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
//					| InvocationTargetException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
		
}
