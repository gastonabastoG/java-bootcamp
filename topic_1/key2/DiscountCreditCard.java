package topic_1.key2;

import java.math.BigDecimal;
import java.util.List;
import topic_1.key1.Item;

public class DiscountCreditCard implements Discount {

	@Override
	public BigDecimal applyDiscount(List<Item> items, BigDecimal total) {
            if (items.isEmpty())
                    return new BigDecimal("0.00");

            return total.subtract(enterPercentageDiscount(total, "0.1" ));
                            //total menos el 10% discount
				
	}
	
	/**
	 * simply to a shortcut to enter discounts
	 * @param balance
	 * @param discount a float percentage in form as a String (10%=String.valueOf(0.1))
	 * @return the final price
	 */
	private BigDecimal enterPercentageDiscount(BigDecimal balance,String discount){
	
		return //balance.subtract(
				balance.multiply(new BigDecimal(discount)) ;
		
	}
	
}
