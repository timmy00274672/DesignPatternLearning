package calculator;

import java.util.Scanner;

public class CalculatorAddModOperation {

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
