package com.files;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RecentFileList implements Observer{
	
	private static RecentFileList recentFileList = null;
	private List<File> list;
	private static final int firstPlace = 0;
	private static final int lastPlace = 14;
	private static final int maxSize = 15;
	
	private RecentFileList(){
		list = new ArrayList<File>(15);
	}
	
	public static synchronized RecentFileList getInstance(){
		if (recentFileList == null)
			recentFileList = new RecentFileList();
		return recentFileList;
	}

	public List<File> getList() {
		return list;
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void emptyList(){
		list = new ArrayList<File>(15); // or list.removeAll(getList());		
	}

	public void update(Observable o, Object arg) {
		if (list.contains((File)o)){
			list.remove((File)o);
			list.add(firstPlace, (File)o);
		}
		else {
			if (list.size() == maxSize)
				list.remove(lastPlace);
			list.add(firstPlace,(File)o);
		}
	}

}
