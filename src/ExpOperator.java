
public class ExpOperator extends Operator{

	public ExpOperator() {

		precedence = 5;
	}

	public int getPrecedence() {

		return precedence;
	}

	@Override
	public double evaluate(double a, double b) {

		return Math.pow(a, b);
	}

}
