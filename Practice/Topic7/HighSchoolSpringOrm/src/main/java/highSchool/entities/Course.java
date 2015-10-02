package highSchool.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int hoursByWeek;
	private int year;

	@ManyToOne
	@JoinColumn(name = "fk_teacher")
	private Teacher teacher;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "fk_course") , inverseJoinColumns = @JoinColumn(name = "fk_student") )
	private List<Student> students;

	public Course() {
		super();
	}

	public Course(String name, int hoursByWeek, int year, Teacher teacher) {
		super();
		this.name = name;
		this.hoursByWeek = hoursByWeek;
		this.year = year;
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHoursByWeek() {
		return hoursByWeek;
	}

	public void setHoursByWeek(int hoursByWeek) {
		this.hoursByWeek = hoursByWeek;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public long getId() {
		return id;
	}

	public List<Student> getAllStudents() {
		return students;
	}

	@Override
	public String toString() {
		return String.format("Course[id: %d, name: %s, hoursByWeek: %d, year: %d, %s]", id, name, hoursByWeek, year,
				teacher.toString());
	}

}
