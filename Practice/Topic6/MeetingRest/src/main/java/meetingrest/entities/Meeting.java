package meetingrest.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Meeting {

	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy = "meeting")
	private Set<Attendee> attendees = new HashSet<>();

	@ManyToOne
	@JoinColumn(name="fk_room")
	private Room room;

	private Date timeFrom;
	private Date timeTo;

	public Meeting() {
	}

	public Meeting(Room room, Date timeFrom, Date timeTo) {
		super();
		this.room = room;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}

	public long getId() {
		return id;
	}

}
