package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Product;
import services.IShoppingCart;
import services.ShoppingCartFactory;

public class TestShoppingCart {

	@Test
	public void addItemsToCart() {
		
		IShoppingCart shoppingCart = ShoppingCartFactory.getLocalService();
		Product p1 = new Product("Coca", 15);
		Product p2 = new Product("Papas", 5);
		
		shoppingCart.addProduct(p1);
		shoppingCart.addProduct(p2);
		
		assertEquals(shoppingCart.getProductByName("Coca").getName(),p1.getName());
		assertEquals(shoppingCart.getProductByName("Papas").getName(),p2.getName());
	}
	
	@Test
	public void editItem() {
		IShoppingCart shoppingCart = ShoppingCartFactory.getLocalService();
		shoppingCart.updateProductPrice("Papas", 10);
		
		assertEquals(10,shoppingCart.getProductByName("Papas").getPrice(),0.1);
	}
	
	@Test
	public void removeItem() {
		
		IShoppingCart shoppingCart = ShoppingCartFactory.getLocalService();
				
		String productName = "Coca";
		shoppingCart.removeProduct(shoppingCart.getProductByName(productName));
		assertEquals(null,shoppingCart.getProductByName(productName));
	}

}
