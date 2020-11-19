package picasso.parser;

import java.util.Stack;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

public class RandomExpressionTreeGenerator {

	private ExpressionTreeNode[] possibleExpressions;
	
	String[] expressionNames = { "picasso.parser.language.expressions.UnaryFunctions.Sin", 
			"picasso.parser.language.expressions.UnaryFunctions.Floor", 
			"picasso.parser.language.expressions.X" };
	
	private static Random rnd = new Random();
	
	Map<String, Constructor<?>> nameToConstructor = new HashMap<>();
	
	public RandomExpressionTreeGenerator() {
		super();
		
		//set up map here
	}		

		//create possible expressions here
	
	
	
	public ExpressionTreeNode makeOneExpression() {
		//randomly pick class name
		String className = expressionNames[rnd.nextInt(expressionNames.length)];
		
		//retrieve constructor for class name
		Constructor<?> constructor = nameToConstructor.get(className);
		
		//figure out how many parameters the constructor has and create array of that size
		int numParams = constructor.getParameterCount();
		ExpressionTreeNode[] params = new ExpressionTreeNode[numParams];
		//create array of random expression tree nodes and put that into array
		
		//create expression tree passing in those parameters
		for (int i = 0; i < numParams; i++) {
			if (numParams == 2 ) {
				params[i] = new Binary(left,right);
				//return expression tree
				return params[i];
			}
			if (numParams == 1 ) {
				params[i] = new UnaryFunction(param);
				return params[i];
			}
		}
	}
		
	public void makeExpression() {
		
		//while the number of children is not zero
		
			//pick root expression
			
			//figure out how many children the expression has
			
			//if there are two children
		
				//generate two children
				
				//for each child, make expression
				
			
				
			//if there is one child
				//generate new child
				
				//make new expression for this child
			
			//if there are no children, stop in that branch
			
			}
		
		
	}
