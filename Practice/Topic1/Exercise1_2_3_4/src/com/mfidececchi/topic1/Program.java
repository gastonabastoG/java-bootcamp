package com.mfidececchi.topic1;

public class Program {

	public static void main(String[] args) {

		// Initialization of Stock
		Stock stock = Stock.getInstance();
		stock.addItem(new Item("Manzana", 10.6, 56));
		stock.addItem(new Item("Naranja", 14.2, 14));
		stock.addItem(new Item("Pera", 22.1, 5));
		stock.addItem(new Item("Sandia", 31.5, 100));
		stock.printStock();

		// an user
		ShoppingCartController userControl1 = new ShoppingCartController();
		// Credit card purchase
		// select id item and quantity
		userControl1.selectItem(3, 2);
		userControl1.selectItem(4, 500);
		// set credit card as payment type
		userControl1.setPaymentType(new CreditCard("Mastercard", 123123123));
		// finish purchase
		userControl1.checkout();

		// another user
		ShoppingCartController userControl2 = new ShoppingCartController();
		// paypal purchase
		// select id item and quantity
		userControl2.selectItem(3, 2);
		userControl2.selectItem(4, 5);
		// set paypal as payment type
		userControl2.setPaymentType(new Paypal("email@gmail.com", "pass"));
		// finish purchase
		userControl2.checkout();

		// another user
		ShoppingCartController userControl3 = new ShoppingCartController();
		// cash purchase
		// select id item and quantity
		userControl3.selectItem(3, 2);
		userControl3.selectItem(4, 5);
		// set cash as payment type
		userControl3.setPaymentType(new Cash());
		// finish purchase
		userControl3.checkout();

		TransactionManager.getInstance().printTransactions();
	}

}
