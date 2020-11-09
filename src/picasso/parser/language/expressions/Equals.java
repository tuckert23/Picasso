package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Equals extends ExpressionTreeNode {

	ExpressionTreeNode param;

	public Equals(ExpressionTreeNode param) {
		this.param = param;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		return param.evaluate(x, y);
	}
}
