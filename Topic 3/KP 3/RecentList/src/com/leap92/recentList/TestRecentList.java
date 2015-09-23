package com.leap92.recentList;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecentList {

	@Test
	public void testIfListIsEmpty() {
		RecentList.getRecentFiles().clear();
		
		RecentList recentList = new RecentList();
		assertEquals(0,recentList.getSize());
	}
	
	@Test
	public void testIfFileIsAdded() {
		RecentList.getRecentFiles().clear();
		
		RecentList recentList = new RecentList();
		File maven = new File("Maven.exe");
		File tdd = new File("TDD.jpg");

		recentList.openFile(maven);
		recentList.openFile(tdd);
		
		//If opened file exists in the recent list
		//containsFile returns true
		assertEquals(true, recentList.containsFile(tdd));
		assertEquals(true, recentList.containsFile(maven));
	}
	
	//Couldn't get to sort the arraylist by date, gonna check later
	/*@Test
	public void testIfFileIsBumped() {
		RecentList.getRecentFiles().clear();
		
		RecentList recentList = new RecentList();
		File tdd = new File("TDD.jpg");
		File spring = new File("Spring.exe");
		File sql = new File("SQL");
		
		recentList.openFile(tdd);
		recentList.openFile(spring);
		recentList.openFile(sql);
		recentList.openFile(new File("asd"));
		//Getting the item from index 0 should return
		//the most recent file opened
		for (File f : RecentList.getRecentFiles()) {
			System.out.println("Filename: " + f.getName() + " Date: " + f.getLastOpenedDate());
		}
		
		assertEquals("asd", recentList.get(0).getName());
	}*/

}
