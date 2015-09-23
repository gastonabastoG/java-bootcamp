package services;

import entities.Product;

public interface IShoppingCart {
	
	public void addProduct(Product product);
	
	public Product getProductByName(String productName);
	
	public void removeProduct(Product product);
	
	public void updateProductPrice(String productName, double price);
	
	
	//Could add some other methods

}
