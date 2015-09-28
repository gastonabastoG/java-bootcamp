package com.sql.topic5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TeacherDB implements TeacherDAO{

	private static final String NEWLINE = System.lineSeparator();
	private final Connection connection;
	
	public TeacherDB(Connection connection){
		this.connection = connection;
	}
	
	public Teacher getTeacherByID(int id) {
		try {
			Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT COUNT(*)  from Teacher where  (Teacher.id = \""+ Integer.toString(id) + "\") ;");
		rs.next();
		
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(rs.getString("Teacher.id")));
		teacher.setFistName(rs.getString("Teacher.firstName"));
		teacher.setLastName(rs.getString("Teacher.lastName"));
		teacher.setDateOfBirth(rs.getString("Teacher.dateOfBirth"));
		
		return teacher;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Teacher> getAllTeachers() {
		try {
			Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT COUNT(*)  from Teacher;");

		List<Teacher> teachers = new ArrayList<Teacher>();
		rs.next();
		do{
			Teacher teacher = new Teacher();
			teacher.setId(Integer.parseInt(rs.getString("Teacher.id")));
			teacher.setFistName(rs.getString("Teacher.firstName"));
			teacher.setLastName(rs.getString("Teacher.lastName"));
			teacher.setDateOfBirth(rs.getString("Teacher.dateOfBirth"));
			teachers.add(teacher);
		}
		while(rs.next());
		return teachers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSchedule(int id) {
		try {
			Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT Course.name, Teacher.firstName, Teacher.lastName , DATE_FORMAT(Schedule.HourStart,'%W') as dia, time(Schedule.HourStart) as horai, time(Schedule.HourEnd) as houre "
														+ "from Schedule, Teacher, Course "
														+ "where  (Teacher.id = \""+ Integer.toString(id) + "\") and (Course.idAssignedTeacher = Teacher.id) and (Schedule.idSchedule = Course.idSchedule)"
														+ "group by Course.name "
														+ "Order by Schedule.HourStart;");
		StringBuilder result = new StringBuilder();
		rs.next();
		result
		.append("Teacher: "+ rs.getString("Teacher.lastName") + ", "+ rs.getString("Teacher.firstName")).append(NEWLINE)
		.append("Schedule: ").append(NEWLINE);
		do{
			result
			.append(rs.getString("dia")+ ", "+rs.getString("horai") + ", " +rs.getString("houre") + " " + rs.getString("Course.name"))
			.append(NEWLINE);
		}while(rs.next());
		statement.close();
		rs.close();
		return result.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
