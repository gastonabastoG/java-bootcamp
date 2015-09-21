package com.point2;

import java.math.BigDecimal;

/**
 * 
 * This interface represents the behavior of the pay method depending on the payment's type
 * Pay method returns true if the operation is performed and otherwise returns false
 * 
 */

public interface Payment {

	public boolean pay(BigDecimal amount);
}
