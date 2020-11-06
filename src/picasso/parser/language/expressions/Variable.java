package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a variable
 * 
 * @author Sara Sprenkle
 *
 */
public class Variable extends ExpressionTreeNode {

	private String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Variable)) {
			return false;
		}
		Variable l = (Variable) obj;
		return this.name.equals(l.name);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		ExpressionTreeNode param = (ExpressionTreeNode) elementsToValue.get(this);
		RGBColor result = param.evaluate(x, y);
		return result;
	}

	public String getName() {
		return name;
	}

}
