package test;

import java.util.ArrayList;
import java.util.Scanner;

import entities.*;

public class Demo {
	
	public static void main (String args[]) {
		//Some parts are commented just to try different ways to
		//test the program
		
		//Scanner in = new Scanner (System.in);
		
		ShoppingCart myShoppingCart = ShoppingCart.getInstance();
		User marketManager = new User("Market Manager", "manager@gmail.com");
		myShoppingCart.addObserver(marketManager);
		
		Product p1 = new Product("Silla",20.5);
		Product p2 = new Product("Mesa",50);
		Product p3 = new Product("Mantel",10);
		
		myShoppingCart.addProduct(p1);
		myShoppingCart.addProduct(p2);
		myShoppingCart.addProduct(p3);
		
		System.out.println(myShoppingCart.getTotalPrice());
		
		/*System.out.println("What do you want to pay with?");
		System.out.println("1 for Cash, 2 for Credit Card, 3 for PayPal");
		
		int sel = in.nextInt();
		
		switch (sel) {
		case 1:
			PaymentStrategy payWithCash = new CashStrategy();
			Transaction t1 = new Transaction(payWithCash,myShoppingCart);
			System.out.println(t1);
			break;
		case 2:
			PaymentStrategy payWithCC = new CreditCardStrategy("Leandro", "945854123");
			Transaction t2 = new Transaction(payWithCC,myShoppingCart);
			System.out.println(t2);
			break;
		case 3:
			PaymentStrategy payWithPayPal = new PayPalStrategy("leap92","asd123");
			Transaction t3 = new Transaction(payWithPayPal,myShoppingCart);
			System.out.println(t3);
			break;
		}
		in.close();*/
		
		PaymentStrategy payWithCash = new CashStrategy();
		Transaction t1 = new Transaction(payWithCash,myShoppingCart);
		System.out.println(t1);
		
		PaymentStrategy payWithCC = new CreditCardStrategy("Leandro", "945854123");
		Transaction t2 = new Transaction(payWithCC,myShoppingCart);
		System.out.println(t2);
		
		PaymentStrategy payWithPayPal = new PayPalStrategy("leap92","asd123");
		Transaction t3 = new Transaction(payWithPayPal,myShoppingCart);
		System.out.println(t3);
		
		System.out.println(myShoppingCart.listAllProducts());
		
		Product p4 = new Product("Celular", 100);
		
		ArrayList<Product> offerProducts = new ArrayList<Product>();
		offerProducts.add(p1);
		offerProducts.add(p4);
		Offer o1 = new Offer("Super oferta", 105, offerProducts);
		
		System.out.println(o1);
		
		myShoppingCart.setProductPrice(p3, 20);
		System.out.println(myShoppingCart.listAllProducts());
		System.out.println(myShoppingCart.getTotalPrice());
		
	}

}
