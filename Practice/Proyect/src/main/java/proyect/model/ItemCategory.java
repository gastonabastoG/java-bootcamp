package proyect.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_category")
public class ItemCategory {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	public ItemCategory() {
		super();
	}

	public ItemCategory(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

}
