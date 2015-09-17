package com.mfidececchi.topic1;
import java.time.Instant;
import java.util.Date;

public class Transaction {

	// Private instance variables
	private PaymentType paymentType;
	private double total;
	private Date TimeTransaction;
	private int numberTransaction;

	// Constructor
	public Transaction(PaymentType paymentType, double total) {
		this.paymentType = paymentType;
		this.total = total;
		TimeTransaction = Date.from(Instant.now());
	}

	// setter of number of transaction
	public void setNumberTransaction(int numberTransaction) {
		this.numberTransaction = numberTransaction;
	}

	// getters
	public PaymentType getPaymentType() {
		return paymentType;
	}

	public double getTotal() {
		return total;
	}

	public Date getTimeTransaction() {
		return TimeTransaction;
	}

	public int getNumberTransaction() {
		return numberTransaction;
	}

}
