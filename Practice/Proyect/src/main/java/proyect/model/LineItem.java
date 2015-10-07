package proyect.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "line_item")
public class LineItem {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name = "fk_cart")
	private Cart cart;
	@ManyToOne
	@JoinColumn(name = "fk_item")
	private Item item;
	private int quantity;

	public LineItem() {
		super();
	}

	public LineItem(Cart cart, Item item, int quantity) {
		super();
		this.cart = cart;
		this.item = item;
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

}
