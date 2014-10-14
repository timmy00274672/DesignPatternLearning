package cash_registerv2;

public class Administrator {
	public static void main(String[] args){
		CashStategy.addStrategy("HALF", new CashStategy.CountMethod() {
			
			@Override
			public double getSum(int number, double price) {
				return 0.5 * number * price;
			}
		});
	}
}
