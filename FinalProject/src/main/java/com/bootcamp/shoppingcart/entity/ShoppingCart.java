package com.bootcamp.shoppingcart.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@OneToMany
	@JoinColumn(name="shoppingcart_id", referencedColumnName="id")
	private List<ProductLine> productLine;
  
	 @NotNull
	 @Column(name="user_id")
	 public  int userId;

	public ShoppingCart() {
	}

	public ShoppingCart(long id){
		this.id = id;
	}
		
//	public ShoppingCart(User user, List<ProductLine> productLine) {
//		this.productLine = productLine;
//		this.user = user;
//	}

	public ShoppingCart(Long id, List<ProductLine> productLine, int userId) {
		super();
		this.id = id;
		this.productLine = productLine;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProductLine> getProductLine() {
		return productLine;
	}

	public void setProductLine(List<ProductLine> productLine) {
		this.productLine = productLine;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
