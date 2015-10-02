package highSchool.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private Timestamp birthDate;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "fk_student") , inverseJoinColumns = @JoinColumn(name = "fk_course") )
	private List<Course> courses;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, Timestamp birthDate) {
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

	public List<Course> getAllCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return String.format("Student[id: %d, firstName: %s, lastName: %s, birthDate: %s]", id, firstName, lastName,
				birthDate.toString());

	}
}
