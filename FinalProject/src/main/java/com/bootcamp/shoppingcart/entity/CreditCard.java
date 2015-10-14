package com.bootcamp.shoppingcart.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="creditcard")
//@NamedQuery(name = "CreditCard.findACreditCard",query = "select cc from CreditCard cc inner join User u on u.creditCard_id = cc.id where cc.id = ?1 and u.id = ?2")
public class CreditCard {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "brand")
	@NotNull
	private String brand;
	
	@Column(name = "number")
	@NotNull
	private String number;
	
	@Column(name = "bank")
	@NotNull
	private String bank;
	
	@Column(name = "ownername")
	@NotNull
	private String ownername;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date expdate;

	public CreditCard() {

	}

	public CreditCard(Long id) {
		this.id = id;
	}

	public CreditCard(String brand, String number, String bank,
			String ownername, Date expdate) {
		this.brand = brand;
		this.number = number;
		this.bank = bank;
		this.ownername = ownername;
		this.expdate = expdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
}
