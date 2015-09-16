package topic_1.key2;

import java.math.BigDecimal;
import java.util.List;

import topic_1.key1.Item;

public interface Discount {
	
	public BigDecimal applyDiscount(List<Item> items, BigDecimal price);

}
