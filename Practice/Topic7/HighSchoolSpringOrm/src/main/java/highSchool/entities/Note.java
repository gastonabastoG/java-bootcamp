package highSchool.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Note {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "fk_student")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "fk_course")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "fk_note_type")
	private NoteType noteType;

	private int value;

	private Date date;

	public Note() {
		super();
	}

	public Note(Student student, Course course, NoteType noteType, int value, Date date) {
		super();
		this.student = student;
		this.course = course;
		this.noteType = noteType;
		this.value = value;
		this.date = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public NoteType getNoteType() {
		return noteType;
	}

	public void setNoteType(NoteType noteType) {
		this.noteType = noteType;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

}
