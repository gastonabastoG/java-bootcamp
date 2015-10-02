package highSchool.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "note_types")
public class NoteType {

	@Id
	@GeneratedValue
	private long id;
	private String description;

	public NoteType() {
		super();
	}

	public NoteType(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("NoteType[id: %d, description: %s]", id, description);
	}

}
