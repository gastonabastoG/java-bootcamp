package meetingrest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendee {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "fk_meeting")
	private Meeting meeting;

	public Attendee(String firstName, String lastName, Meeting meeting) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.meeting = meeting;
	}

	public Attendee() {
		super();
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

	public Long getId() {
		return id;
	}

	public Meeting getMeeting() {
		return meeting;
	}

}