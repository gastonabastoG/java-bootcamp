package topic_1.key1;

import topic_1.key1.payment.PaypalAccount;
import topic_1.key1.payment.CreditCard;
import topic_1.key1.payment.Cash;

public class Main {

    public static void main(String[] args) {
        EcommerceService web=new EcommerceService(DataConnection.retrieveOffers());

        web.listItems();
        web.listOffers();

        CustomerAccount newCustomer = new CustomerAccount("Guille", 
                                            new CreditCard("Guille", 12, "100.00"),
                                            new PaypalAccount("Guille", "123", "", "100.00"), 
                                            new Cash("100.00"));
        web.addProductToCart(web.searchProduct("Oferta del Bootcamp"), 1, newCustomer.getMyShoppingCart());
        web.checkout(newCustomer.getMoney(), newCustomer);
        web.checkout(newCustomer.getMoney(), newCustomer);


    }
}
