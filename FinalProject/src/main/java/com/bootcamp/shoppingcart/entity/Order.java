package com.bootcamp.shoppingcart.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "status")
	@NotNull
	private String status;
	
	@Column(name = "paymentmethod")
	@NotNull
	private String paymentmethod;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date date;
	
	@Column(name = "total")
	@NotNull
	private double total;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shoppingcart_id")
	private ShoppingCart shoppingCart;
		
	public Order() {
	}

	public Order(Long id) {
		this.id = id;
	}

	public Order(String status, String paymentmethod, Date date, double total,
			ShoppingCart shoppingcart) {
		this.status = status;
		this.paymentmethod = paymentmethod;
		this.date = date;
		this.total = total;
		this.shoppingCart = shoppingcart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ShoppingCart getShoppingcart() {
		return shoppingCart;
	}

	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingCart = shoppingcart;
	}	
}
