package com.entities;

import java.sql.Date;

public class Course {

	private int idCourse;
	private String name;
	private int assignedTeacher;
	private int hoursByWeek;
	private Date startTime;
	private Date endTime;

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAssignedTeacher() {
		return assignedTeacher;
	}

	public void setAssignedTeacher(int assignedTeacher) {
		this.assignedTeacher = assignedTeacher;
	}

	public int getHoursByWeek() {
		return hoursByWeek;
	}

	public void setHoursByWeek(int hoursByWeek) {
		this.hoursByWeek = hoursByWeek;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
