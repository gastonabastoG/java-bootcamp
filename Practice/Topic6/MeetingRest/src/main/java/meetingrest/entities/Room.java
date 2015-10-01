package meetingrest.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room {

	@Id
	@GeneratedValue
	private long id;
	private String description;
	private int size;
	
	@OneToMany(mappedBy="room")
	private Set<Meeting> meetings = new HashSet<Meeting>();

	public Room() {

	}

	public Room(String description, int size) {
		super();
		this.description = description;
		this.setSize(size);
	}

	public String getDescription() {
		return description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
