package entities;

public interface PaymentStrategy {
	
	double getFinalPrice(double price);
	String getPaymentType();
	
}
