package com.mfidececchi.topic1;
import java.util.ArrayList;

public class TotalCalculator {

	private static TotalCalculator totalCalculator;
	private double discountRateCreditCard = 10;

	private TotalCalculator() {
	}

	public static TotalCalculator getInstance() {
		if (totalCalculator == null) {
			totalCalculator = new TotalCalculator();
		}
		return totalCalculator;
	}

	private double getSubtotal(ArrayList<PaymentLine> shoppingCart) {
		double subTotal = 0;
		for (PaymentLine line : shoppingCart) {
			subTotal += line.getTotal();
		}
		return subTotal;
	}

	private double getDiscount(ArrayList<PaymentLine> shoppingCart, PaymentType paymentType, double subTotal) {

		double discount = 0;

		try {
			CreditCard cast = (CreditCard) paymentType;
			// 10% discount by Credit Card.
			discount = subTotal * 1 / discountRateCreditCard;
			System.out.println("SubTotal: " + subTotal + " Discount by CreditCard: " + discount);
		} catch (Exception e1) {

			try {
				Paypal cast = (Paypal) paymentType;
				// "The cheapest item is for free when the user pay by Paypal"
				// is
				// replaced by
				// "The cheapest Payline is for free when the user pay by
				// Paypal"
				// because I made exercise allowing that user can buy several
				// Items
				// on the same PaymentLine.

				// find cheapest PaymentLine
				PaymentLine cheapestLine = null;
				for (PaymentLine line : shoppingCart) {
					if (cheapestLine == null) {
						cheapestLine = line;
					} else {
						if (line.getTotal() < cheapestLine.getTotal()) {
							cheapestLine = line;
						}
					}
				}
				discount = cheapestLine.getTotal();
				System.out.println("SubTotal: " + subTotal + " Discount by Paypal: " + discount);
			} catch (Exception e2) {

				try {

					Cash cast = (Cash) paymentType;

					// "90% of the most expensive item is free if the user pays
					// by
					// Cash." is
					// replaced by
					// "90% of the most expensive PaymentLine is free if the
					// user pays
					// by Cash."
					// because I made exercise allowing that user can buy
					// several Items
					// on the same PaymentLine.

					// find most expensive PaymentLine
					PaymentLine expensiveLine = null;
					for (PaymentLine line : shoppingCart) {
						if (expensiveLine == null) {
							expensiveLine = line;
						} else {
							if (line.getTotal() > expensiveLine.getTotal()) {
								expensiveLine = line;
							}
						}
					}
					discount = expensiveLine.getTotal();
					System.out.println("SubTotal: " + subTotal + " Discount by Cash: " + discount);
				} catch (Exception e3) {

				}

			}
		}
		return discount;
	}

	// method that returns (subTotal - discount) depending on paymentType
	public double getTotal(ArrayList<PaymentLine> shoppingCart, PaymentType paymentType) {

		// calculateSubTotal
		double subTotal = getSubtotal(shoppingCart);
		double discount = getDiscount(shoppingCart, paymentType, subTotal);
		double total = subTotal - discount;
		System.out.println("Total: " + total);
		return total;
	}

}
