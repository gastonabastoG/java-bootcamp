package com.sql.test;

import java.sql.SQLException;

import org.junit.Test;

import com.sql.topic5.DBManager;
import com.sql.topic5.TeacherDAO;
import com.sql.topic5.TeacherDAOFactory;

public class DBTest {

	
	private DBManager getDBManager() throws Exception{
		DBManager manager = new DBManager();
		manager.connect();
		manager.loadFile("scriptCreation.sql");
		return manager;
	}
	
	@Test
	public void testConnection() throws ClassNotFoundException, SQLException {
		DBManager manager = new DBManager();
		manager.connect();
		manager.closeConnection();
	}
	
	@Test
	public void testFileLoad() throws Exception {
		DBManager manager = getDBManager();
		manager.closeConnection();
	}
	
	@Test
	public void testQueryStudentAndTeachers() throws Exception{
		DBManager manager = getDBManager();
		System.out.println(manager.getStudentAndTeachers("Matematica"));
		manager.closeConnection();
	}
	
	@Test
	public void testQueryFinalNoteForStudent() throws Exception{
		DBManager manager = getDBManager();
		System.out.println(manager.getFinalNoteForStudent("1"));
		manager.closeConnection();
	}
	
	@Test
	public void testQueryPercentageOfStudentsPassed() throws Exception{
		DBManager manager = getDBManager();
		System.out.println(manager.percentageOfStudentsPassed("Lengua"));
		manager.closeConnection();
	}
	
	
	
	/*
	 * TeacherDB test - Bean - DAO - Factory
	 */
	@Test
	public void testTeacherWithNewDesign() throws Exception{
		DBManager manager = getDBManager();
		TeacherDAO teacherDAO = TeacherDAOFactory.getTeacherDAO("mysql");
		System.out.println(teacherDAO.getSchedule(1));
		manager.closeConnection();
	}

}
