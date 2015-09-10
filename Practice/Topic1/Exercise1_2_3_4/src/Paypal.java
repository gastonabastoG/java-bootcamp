
public class Paypal extends PaymentType{

	// private instance variables
	private String email;
	private String password;

	// Constructor
	public Paypal(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
		
}
