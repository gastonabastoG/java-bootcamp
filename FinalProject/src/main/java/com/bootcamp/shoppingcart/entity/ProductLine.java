package com.bootcamp.shoppingcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_line")
public class ProductLine {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "product_id")
	private Long product_id;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "subtotal")
	private double subTotal;

	@Column(name = "shoppingcart_id")
	private int shoppingcart_id;

	public ProductLine(Long product_id, int quantity, double subTotal,
			int shoppingCart_id) {
		this.product_id = product_id;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.shoppingcart_id = shoppingCart_id;
	}

	public ProductLine(Long id) {
		this.id = id;
	}

	public ProductLine() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getShoppingcart_id() {
		return shoppingcart_id;
	}

	public void setShoppingcart_id(int shoppingcart_id) {
		this.shoppingcart_id = shoppingcart_id;
	}
}
