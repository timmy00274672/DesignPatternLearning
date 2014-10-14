package calculator;

import java.util.Scanner;

public class CalculatorWithFactory {

	public static void main(String[] args) {
		double firstOprand, secondOperand;
		String operatorString;

		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);

		System.out.println("Input A");
		firstOprand = stdin.nextDouble();

		do {
			System.out.println("Input operator(+-*/)");
			operatorString = stdin.next();
			// check
			if (operatorString.matches("[+-/|\\u002a]"))
				break;
		} while (true);

		System.out.println("Input B");
		secondOperand = stdin.nextDouble();

		DoubleOperation2 operation = OperationFactory
				.createOperation(operatorString);
		System.out.println(operation.getResult(new double[] { firstOprand,
				secondOperand }));
	}

}

class OperationFactory {
	public static DoubleOperation2 createOperation(String operator) {
		DoubleOperation2[] operations = { DoubleOperation2.ADD,
				DoubleOperation2.MINUS, DoubleOperation2.TIMES,
				DoubleOperation2.DIVIDES };
		for (DoubleOperation2 doubleOperation : operations) {
			if (doubleOperation.opString.equals(operator))
				return doubleOperation;
		}
		throw new RuntimeException("UnSupported Operator");
	}
}

abstract class DoubleOperation2 {
	protected String opString;

	public String getOpString() {
		return opString;
	}

	protected DoubleOperation2(String opString) {
		this.opString = opString;
	}

	abstract double getResult(double[] operands);

	static final DoubleOperation2 ADD = new DoubleOperation2("+") {

		@Override
		public double getResult(double[] operands) {
			double sum = 0;
			for (double d : operands) {
				sum += d;
			}
			return sum;
		}
	};
	static final DoubleOperation2 MINUS = new DoubleOperation2("-") {

		@Override
		public double getResult(double[] operands) {
			if (operands.length != 2)
				throw new RuntimeException("should provide two operands");
			return operands[0] - operands[1];
		}
	};
	static final DoubleOperation2 TIMES = new DoubleOperation2("*") {

		@Override
		public double getResult(double[] operands) {
			if (operands.length == 0)
				throw new RuntimeException(
						"should provide at least one operand");
			double sum = 1;
			for (double d : operands) {
				sum *= d;
			}
			return sum;
		}
	};
	static final DoubleOperation2 DIVIDES = new DoubleOperation2("/") {

		@Override
		public double getResult(double[] operands) {
			if (operands.length != 2)
				throw new RuntimeException("should provide two operands");
			return operands[0] / operands[1];
		}
	};
}
