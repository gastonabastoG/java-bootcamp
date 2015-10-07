package proyect.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class Account {

	@Id
	private String username;

	private String password;

	@ManyToOne
	@JoinColumn(name = "fk_rol")
	private Rol rol;

	@JsonIgnore
	@OneToOne(mappedBy = "account")
	private User user;

	public Account() {
		super();
	}

	public Account(String username, String password, Rol rol) {
		super();
		this.username = username;
		this.password = password;
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
