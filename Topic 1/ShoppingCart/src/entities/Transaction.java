package entities;

public class Transaction implements MailListSubject {
	
	PaymentStrategy paymentStrategy = null;
	ShoppingCart shoppingCart = null;
	private int id;
	
	public Transaction(PaymentStrategy paymentStrategy,ShoppingCart shoppingCart) {
		this.paymentStrategy = paymentStrategy;		
		this.shoppingCart = shoppingCart;
		this.id = IntIDGenerator.generateId();
	}
	
	public int getId() {
		return this.id;
	}
	
	
	public String toString() {
		return "Paid with: " + this.paymentStrategy.getPaymentType() + "\n" 
				+ "Subtotal: " + this.shoppingCart.getTotalPrice() + "\n" 
				+ "Total w/discount: " 
				+ this.paymentStrategy.getFinalPrice(this.shoppingCart.getTotalPrice()) + "\n" 
				+ "Transaction ID: " + this.getId();
				
				
	}
	
	//Here should be the observer implementation to notify the user
	//about new transactions (I may do it later)
	@Override
	public void addObserver(MailListObserver mailListObserver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(MailListObserver mailListObserver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doNotify() {
		// TODO Auto-generated method stub
		
	}
	

}
