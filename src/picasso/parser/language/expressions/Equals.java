package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Equals extends Binary {
	
	public Equals(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
		System.out.println(param2);
		System.out.println(param1);
		elementsToValue.put(param2, param1);
	}
	
	@Override
	public String toString() {
		return this.getClass() + ": " + param1 + ", " + param2;
	}


	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor right = param1.evaluate(x, y);
		return right;
	}
	
	
}
