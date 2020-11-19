package picasso.parser.language;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import picasso.parser.language.expressions.X;

public class TestConstructors {

	public static void main(String[] args) {
		final String unaryFunctionsPackage = "picasso.parser.language.expressions.unaryFunctions.";
		String[] unaryFunctionNames = { unaryFunctionsPackage + "Tan", unaryFunctionsPackage + "Sin" };

		final String binaryFunctionsPackage = "picasso.parser.language.expressions.operators.";
		String[] binaryFunctionNames = { binaryFunctionsPackage + "Addition" };

		Map<String, Constructor> nameToConstructor = new HashMap<>();

		for (String unaryClassName : unaryFunctionNames) {
			try {
				Class className = Class.forName(unaryClassName);
				System.out.print("Durhurr");
				System.out.println(className);
				Constructor constructor = className.getDeclaredConstructor(picasso.parser.language.ExpressionTreeNode.class);
				System.out.println(constructor);
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
				Class className = Class.forName(binaryClassName);
				System.out.print("test ");
				System.out.println(className);
				Constructor constructor = className.getDeclaredConstructor(
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

		for (Constructor constructor : nameToConstructor.values()) {
			// get constructor
			int numParams = constructor.getParameterCount();

			ExpressionTreeNode[] params = new ExpressionTreeNode[numParams];

			for (int i = 0; i < numParams; i++) {
				params[i] = new X();
			}

			try {
				ExpressionTreeNode etn = (ExpressionTreeNode) constructor.newInstance(params);
				System.out.println(etn);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
