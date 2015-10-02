package highSchool.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private Timestamp birthDate;

	public Teacher() {
		super();
	}

	public Teacher(String firstName, String lastName, Timestamp birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("Teacher[id: %d, firstName: %s, lastName: %s, birthDate: %s]", id, firstName, lastName,
				birthDate.toString());

	}
}
