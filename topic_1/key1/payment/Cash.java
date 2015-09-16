package topic_1.key1.payment;

import topic_1.key2.DiscountCash;

public class Cash extends FinancialPayment {

	public Cash(String money) {
		setBalance(money);
		discount = new DiscountCash();
	}

}
