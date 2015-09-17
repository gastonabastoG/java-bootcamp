package com.mfidececchi.topic1;
import java.util.ArrayList;

public class ShoppingCartController {

	// private instance variables
	private Stock stock;

	private ArrayList<PaymentLine> shoppingCart;
	private PaymentType paymentType;

	// Constructor
	public ShoppingCartController() {
		shoppingCart = new ArrayList<PaymentLine>();
		stock = Stock.getInstance();
	}

	// method that find a Item in Stock and adds it to shopping Cart if found
	// it.
	public void selectItem(int id, int quantity) {
		Item item = stock.findItem(id);
		if (item != null) {
			// you can not add more items than there is in stock.
			if (quantity <= item.getQuantity()) {
				PaymentLine line = new PaymentLine(item, quantity);
				shoppingCart.add(line);
				System.out.println(
						quantity + " Items (id:" + id + ") successfully added to cart. totalLine: $" + line.getTotal());
			} else {
				System.out.println("there are not enough items (id:" + id + ")");
			}
		} else {
			System.out.println("The Item Id: " + id + " not exists");
		}
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public void checkout() {
		double total = TotalCalculator.getInstance().getTotal(shoppingCart, paymentType);
		Transaction transaction = new Transaction(paymentType, total);
		TransactionManager.getInstance().addTransaction(transaction);
	}

}
