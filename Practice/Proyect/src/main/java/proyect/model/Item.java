package proyect.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "fk_category")
	private ItemCategory category;

	public Item() {
		super();
	}

	public Item(String name, BigDecimal price, ItemCategory category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ItemCategory getCategory() {
		return category;
	}

	public void setCategory(ItemCategory category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

}
