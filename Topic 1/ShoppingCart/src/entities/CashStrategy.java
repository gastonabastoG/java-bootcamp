package entities;

public class CashStrategy implements PaymentStrategy{
	
	final String type = "Cash";

	@Override
	public double getFinalPrice(double price) {
		//Final price implementation goes here
		return 0;
	}

	@Override
	public String getPaymentType() {
		return this.type;
	}

}
