package com.leap92.recentList;

import java.util.Date;

public class File {
	
	//Simple class for File, could add more variables
	//but is not necessary for this exercise
	//Implements comparable to be able to compare dates and sort
	//the ArryList
	private String name;
	private Date lastOpenedDate;
	
	public File(String name) {
		this.name = name;
		this.lastOpenedDate = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getLastOpenedDate() {
		return lastOpenedDate;
	}

	public void setLastOpenedDate(Date lastOpenedDate) {
		this.lastOpenedDate = lastOpenedDate;
	}
}
