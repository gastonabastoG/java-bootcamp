package com.sql.topic5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static Connection connection;
	private static final String NEWLINE = System.lineSeparator();
	
	
	
	public void connect() throws ClassNotFoundException, SQLException {
	
	    connection =  ConnectionManager.getInstance().getConnection();
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public void loadFile(String path) throws Exception {
		ScriptRunner runner = new ScriptRunner(connection, false, true);
		runner.runScript(new BufferedReader(new FileReader(path)));
	}

	/*
	 * Get Students and teaches from course
	 */
	public String getStudentAndTeachers(String course) throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select Course.name, Teacher.firstName, Teacher.lastname, Student.firstName, Student.lastName "
				+ "from Course, Teacher, Student, Notas where (Course.name =\""+course +"\") and (Course.idCourse = Notas.idCourse) and "
						+ "(Course.idAssignedTeacher = Teacher.id) and (Notas.idStudent = Student.registrationNumber) order by Student.lastName;");
		StringBuilder result = new StringBuilder();
		rs.next();
		
		result
		.append("Course: "+ course).append(NEWLINE)
		.append("Teacher : "+ rs.getString("Teacher.lastname")+ ", "+ rs.getString("Teacher.firstName")).append(NEWLINE)
		.append("Students:");
		
		while(rs.next()){
			result.append(NEWLINE).append(rs.getString("Student.lastName") + ", "+ rs.getString("Student.firstName") );
		}
		
		statement.close();
		rs.close();
		return result.toString();
	}
	
	public String getFinalNoteForStudent (String student) throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select Student.lastName, Student.firstName, Course.name, Notas.finalNote "
														+"from Student, Course, Notas "
														+"where (Student.registrationNumber = \""+student +"\") and (Notas.idStudent = Student.registrationNumber) and (Course.idCourse = Notas.idCourse) "
														+"order by Notas.finalNote, Course.name;");
		StringBuilder result = new StringBuilder();
		rs.next();
		result.append("Student: "+ rs.getString("Student.lastName") + ", "+ rs.getString("Student.firstName")).append(NEWLINE);
		
		while(rs.next()){
			result.append("Course : "+ rs.getString("Course.name")+ ": Final Note "+rs.getString("Notas.finalNote")).append(NEWLINE);
		}
		
		statement.close();
		rs.close();
		return result.toString();
	}
	
	
	public String percentageOfStudentsPassed(String course) throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT AVG(a.scount) as average "
													   +"FROM (select count(1) as scount "
													   +"from Notas, Course, Student "
													   +"where (Notas.idCourse = Course.idCourse)and (Course.name = \""+course+"\") and (Student.registrationNumber = Notas.idStudent) "
													   +"and (Notas.finalNote >= 4) GROUP BY Course.name) a;"); 
		StringBuilder result = new StringBuilder();
		rs.next();
		result.append("Course: "+ course + ", Average: "+ rs.getString("average"));
		statement.close();
		rs.close();
		return result.toString();
	}

	
}
