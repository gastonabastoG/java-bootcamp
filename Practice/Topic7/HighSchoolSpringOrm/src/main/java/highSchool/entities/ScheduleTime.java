package highSchool.entities;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule_time")
public class ScheduleTime {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "fk_course")
	private Course course;

	private Time timeFrom;
	private Time timeTo;
	private int dayOfWeek;

	public ScheduleTime() {
		super();
	}

	public ScheduleTime(Course course, Time timeFrom, Time timeTo, int dayOfWeek) {
		super();
		this.course = course;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.dayOfWeek = dayOfWeek;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Time getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Time getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Time timeTo) {
		this.timeTo = timeTo;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("ScheduleTime[id: %d, %s, timeFrom: %s, timeTo: %s, dayOfWeek: %d]", id, course.toString(),
				timeFrom.toString(), timeTo.toString(), dayOfWeek);

	}

}
