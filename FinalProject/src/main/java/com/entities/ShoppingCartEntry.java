package com.entities;

import java.io.Serializable;

public class ShoppingCartEntry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5360505508652787584L;
	private int idUser;
	private int idItem;
	private int quantity;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
