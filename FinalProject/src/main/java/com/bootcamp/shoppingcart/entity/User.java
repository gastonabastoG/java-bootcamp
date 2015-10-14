package com.bootcamp.shoppingcart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
//@NamedQuery(name = "query", query = "SELECT DISTINCT o " +
//	    "FROM Organization o, User u " +
//	    "JOIN o.roles oRole " +
//	    "JOIN u.roles uRole " +
//	    "WHERE oRole.id = uRole.id AND u.id = :uId")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "firstname")
	@NotNull
	private String firstname;
	
	@Column(name = "lastname")
	@NotNull
	private String lastname;
	
	@Column(name = "mail")
	@NotNull
	private String mail;
	
	@Column(name = "address")
	@NotNull
	private String address;
	
	@Column(name = "username")
	@NotNull
	private String username;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinColumn(name="user_id", referencedColumnName="id")
	 private List<CreditCard> creditCard;
	
	public User() {
	}

	public User(String firstname, String lastname, String mail, String address,
			String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.address = address;
		this.username = username;
		this.password = password;		
	}

	/**
	 * @param id2
	 */
	public User(long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CreditCard> getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}
}