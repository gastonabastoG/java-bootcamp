package com.entities;

import java.io.Serializable;

public class OrderEntry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3154074947236360045L;
	private int idOrder;
	private int idItem;
	private int quantity;
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
