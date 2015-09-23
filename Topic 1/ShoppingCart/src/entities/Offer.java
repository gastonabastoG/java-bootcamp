package entities;

import java.util.ArrayList;

public class Offer {
	
	private String name;
	private double price;
	private ArrayList<Product> productList = null;
	
	public Offer(String name, double price, ArrayList<Product> productList) {
		this.name = name;
		this.price = price;
		this.productList = productList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<Product> getProductList() {
		return productList;
	}
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	
	public String toString() {
		String s = "Offer: \n" + this.name + " ....... $" + this.price + "\n";
		for (Product p : productList) {
			s += "\t" + p;
		}
		return s;
	}

}
