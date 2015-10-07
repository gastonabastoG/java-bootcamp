package proyect.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String first_name;
	private String last_name;
	private String email;
	@OneToOne
	@JoinColumn(name = "fk_account")
	private Account account;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Cart> carts;

	public User() {
		super();
	}

	public User(String first_name, String last_name, String email, Account account) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.account = account;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart getOpenCart() {
		Cart cartAux = null;
		for (Cart c : this.carts) {
			// if there is a cart opened
			if (!c.isClosed()) {
				cartAux = c;
				break;
			}
		}
		return cartAux;
	}

}
