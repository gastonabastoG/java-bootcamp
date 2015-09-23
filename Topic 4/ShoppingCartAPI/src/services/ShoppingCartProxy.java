package services;

import entities.Product;

public class ShoppingCartProxy implements IShoppingCart {
	IShoppingCart implementation;
	//Proxy pattern
	//This makes the service look like as if it's 
	//local to whoever is using it
	//Not used until I add a remote service stub
	
	protected ShoppingCartProxy(IShoppingCart imp) {
		this.implementation = imp;
	}
	
	@Override
	public void addProduct(Product product) {
		implementation.addProduct(product);
	}

	@Override
	public Product getProductByName(String productName) {
		return implementation.getProductByName(productName);
	}

	@Override
	public void removeProduct(Product product) {
		implementation.removeProduct(product);
	}

	@Override
	public void updateProductPrice(String productName, double price) {
		implementation.updateProductPrice(productName, price);
	}

}
