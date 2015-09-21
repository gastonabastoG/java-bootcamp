package com.files;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class RecentFileListTest {
	
	private static final int topElement = 0;
	private static final int maxSize = 15;
	
	@After
	public void emptyList(){
		RecentFileList.getInstance().emptyList(); // simulate program's end
	}

	@Test
	public void testEmptyList() {
		assertEquals(true,RecentFileList.getInstance().isEmpty());		
	}
	
	@Test
	public void testNotEmptyList(){
		createAndOpenFiles(1);
		assertEquals(false,RecentFileList.getInstance().isEmpty());
	}
	
	@Test
	public void testRecentFileListContent(){
		createAndOpenFiles(4);
		assertEquals("File 1",RecentFileList.getInstance().getList().get(3).getName());
		assertEquals("File 2",RecentFileList.getInstance().getList().get(2).getName());
		assertEquals("File 3",RecentFileList.getInstance().getList().get(1).getName());
		assertEquals("File 4",RecentFileList.getInstance().getList().get(topElement).getName());
	}
	
	@Test
	public void testOpenExistsFile(){
		new File("File 1").open();
		new File("File 2").open();
		new File("File 1").open();
		assertEquals("File 1",RecentFileList.getInstance().getList().get(topElement).getName());
	}
	
	@Test
	public void testMaxSize(){
		createAndOpenFiles(18);
		assertEquals(maxSize,RecentFileList.getInstance().getList().size()); // did not exceed the 15 elements
		assertEquals("File 18",RecentFileList.getInstance().getList().get(topElement).getName()); // the top element is the last file opened
	}
	
	private void createAndOpenFiles(int quantity){
		for (int i = 1; i <= quantity; i++)
			new File("File " + i).open();
	}

}
