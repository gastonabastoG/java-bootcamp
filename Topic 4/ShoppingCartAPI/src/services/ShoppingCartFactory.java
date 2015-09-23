package services;

public class ShoppingCartFactory {
	
	//This factory minimizes the number of classes
	//the clients need to understand to use our service
	
	private ShoppingCartFactory () {}
	
	public static IShoppingCart getLocalService() {
		return ShoppingCartImp.getInstance();
	}
	
	//Here we can add remote services such as a web service
	//to use other kinds of transportation mechanisms 
	//transparently (that's what the proxy is for)

}
