package com.leap92.recentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecentList {
	
	
	private static ArrayList<File> recentFiles = new ArrayList<File>();
	private final int maxRecents = 3;
		
	public static ArrayList<File> getRecentFiles() {
		return recentFiles;
	}

	public int getSize() {
		return recentFiles.size();
	}

	public void openFile(File file) {/*
		//Couldn't get to sort the arraylist by date, gonna check later
		//flag that indicates if file already exists
		int flag = 0;
		for (File f : recentFiles) {
			if (f.getName() == file.getName()) {
				f.setLastOpenedDate(file.getLastOpenedDate());
				//if it exists sets the flag to 1
				flag = 1;
			}
		}
		//if it doesnt exist
		if (flag == 0) {
			//if list is full, delete the last item
			if (recentFiles.size() == maxRecents) {
				recentFiles.remove(maxRecents - 1);
			}
			//add file to the list
			recentFiles.add(file);
		}
		//Collections.sort sorts in ascending order
		//that's why i added the second part
		sortRecentList();*/
		recentFiles.add(file);
	}

	public boolean containsFile(File file) {
		return recentFiles.contains(file);
	}

	public File get(int index) {
		return recentFiles.get(index);
	}
	
	public void sortRecentList() {
		Collections.sort(recentFiles, new Comparator<File>() {
		    @Override
		    public int compare(File f1, File f2) {
		        return f1.getLastOpenedDate().compareTo(f2.getLastOpenedDate());
		    }
		}); 
	}

}
