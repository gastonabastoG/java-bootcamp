package com.files;

import java.util.Observable;

public class File extends Observable{
	
	private final String name;

	public File(String name){
		this.name = name;
		addObserver(RecentFileList.getInstance());
	}
	
	public String getName(){
		return name;
	}
	
	public void open(){
		System.out.println(name + " file was opened");
		setChanged();
		notifyObservers();
	}
}
