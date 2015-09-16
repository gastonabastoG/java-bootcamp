package topic_1.key1.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

import topic_1.key2.Discount;

/**
 * @author Guille
 * an abstraction to a variety of payment methods, like paypal or creditcard
 */
public abstract class FinancialPayment {
	protected Discount discount;
	private BigDecimal balance;
	
	public BigDecimal getBalance() {
		return balance.setScale(2, RoundingMode.UP);
	}
	
        public Discount getDiscount(){
            return discount;
        }
        
	/**
	 * this is a tricky part, just enter a float as a String( like 1.1= String.valueOf(1.1) )
	 * @param amount a float number as a String 
	 */
	public void setBalance(String amount) {
		this.balance = new BigDecimal(amount);
//		this.balance.subtract(new BigDecimal(appliedDiscount(amount)));

	}
	
	

}
