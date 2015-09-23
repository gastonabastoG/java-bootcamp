package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ShoppingCart implements MailListSubject {
	
	private static ShoppingCart shoppingCart = null;
	private static ArrayList<Product> productList = null;
	private static double totalPrice;
	Set<MailListObserver> mailListObservers;
	private String messageToObserver;
	
	private ShoppingCart() {
		productList = new ArrayList<Product>();
		totalPrice = 0;
		mailListObservers = new HashSet<MailListObserver>();
	};
	
	public static ShoppingCart getInstance() {
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
		}
		return shoppingCart;
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	public void addProduct(Product product) {
		productList.add(product);
		updateTotalPrice();
		this.messageToObserver = "a new product has been added:\n" + product;
		doNotify();
	}
	
	public void removeProduct(Product product) {
		productList.remove(product);
		updateTotalPrice();
	}
	
	public void setProductPrice(Product product, double price) {
		for (Product p : productList) {
			if(p.getName().equals(product.getName())) {
				double oldPrice = p.getPrice();
				p.setPrice(price);
				this.messageToObserver = p.getName() + " price has been modified:\n" 
				+ "From: $" + oldPrice + " to: $" + price;
			}
		}		
		doNotify();
		updateTotalPrice();
	}
	
	public void updateTotalPrice() {
		totalPrice = 0;
		for (Product product : productList) {
			totalPrice = totalPrice + product.getPrice();
		}
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public String listAllProducts() {
		String s = "Item Name ....... $ price \n"; //Writes first line
		for (Product p : productList) { //Iterates through all products and lists them
			s += p; //Concatenates each product information to temp string
		}
		return s; //Returns temp string
	}

	@Override
	public void addObserver(MailListObserver mailListObserver) {
		mailListObservers.add(mailListObserver);				
	}

	@Override
	public void removeObserver(MailListObserver mailListObserver) {
		mailListObservers.remove(mailListObserver);
	}

	@Override
	public void doNotify() {
		Iterator<MailListObserver> it = mailListObservers.iterator();
		while (it.hasNext()) {
			MailListObserver mailListObserver = it.next();
			mailListObserver.doUpdate(messageToObserver);
		}
	}
	

}
