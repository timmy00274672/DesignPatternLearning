package calculator;

import java.util.Scanner;

public class CalculatorWithMeaningfulVariableName {

	public static void main(String[] args) {
		double firstOprand, secondOperand, result;
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

		// System.out.println(Integer.toHexString('*'));
		switch (operatorString) {
		case "+":
			result = firstOprand + secondOperand;
			break;
		case "-":
			result = firstOprand - secondOperand;
			break;
		case "*":
			result = firstOprand * secondOperand;
			break;
		case "/":
			result = firstOprand / secondOperand;
			break;
		default:
			throw new RuntimeException();
		}
		System.out.println(result);

	}
}
