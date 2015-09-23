package services;

import java.util.ArrayList;

import entities.Product;

public class ShoppingCartImp implements IShoppingCart{
	
	//This is my local implementation of the ShoppingCart
	
	
	private static ShoppingCartImp shoppingCart = null;
	private static ArrayList<Product> productList = null;
	private static double totalPrice;
	
	private ShoppingCartImp() {
		productList = new ArrayList<Product>();
		totalPrice = 0;
	};
	
	public static ShoppingCartImp getInstance() {
		//Singleton pattern
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCartImp();
		}
		return shoppingCart;
	}
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	public void addProduct(Product product) {
		productList.add(product);
		updateTotalPrice();
	}
	
	public void removeProduct(Product product) {
		productList.remove(product);
		updateTotalPrice();
	}
	
	public void setProductPrice(Product product, double price) {
		for (Product p : productList) {
			if(p.getName().equals(product.getName())) {
				p.setPrice(price);
			}
		}		
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
	
	public Product getProductByName(String productName) {
		for (Product p : ShoppingCartImp.productList) {
			if (p.getName() == productName) {
				return p;
			}
		}
		return null;
	}
	
	public void updateProductPrice(String productName, double price) {
		getProductByName(productName).setPrice(price);
	}
}
