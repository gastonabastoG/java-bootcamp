package com.point2;

import java.math.BigDecimal;

public class Item {

	private final String name;
	private BigDecimal price;
	private final String description;

	public Item(String name, BigDecimal price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return name + " - $" + price.toString();
	}
	
	public boolean equals(Item otherItem){
		return name.equals(otherItem.getName());
	}

}
