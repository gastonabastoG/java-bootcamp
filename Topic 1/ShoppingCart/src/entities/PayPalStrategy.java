package entities;

//import java.util.Collections;

public class PayPalStrategy implements PaymentStrategy{
	
	private String email;
	private String password;
	private final String type = "PayPal";
	//private ShoppingCart shoppingCart = null;
	
	public PayPalStrategy (String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public double getFinalPrice(double price) {
		return 0; 
		// Final price implementation goes here
	}
	@Override
	public String getPaymentType() {
		return this.type;
	}
	
	

}
