package entities;

public class CreditCardStrategy implements PaymentStrategy {
	
	private String name;
	private String cardNumber;
	private final String type = "Credit Card";
	
	public CreditCardStrategy(String name, String cardNumber) {
		this.name = name;
		this.cardNumber = cardNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public double getFinalPrice(double price) {
		double finalPrice = price*0.9;
		return finalPrice;
	}
	@Override
	public String getPaymentType() {
		return this.type;
	}
}
