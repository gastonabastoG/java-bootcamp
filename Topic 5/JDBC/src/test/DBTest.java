package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import bdconnection.MySQLAccess;

public class DBTest {

	static MySQLAccess db = new MySQLAccess();
	private static Connection connect;
	private static Statement statement;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet;
	private static BatchSQL batchSQL = new BatchSQL();
	
	
	public static void main(String[] args) throws Exception {
		db.connectDatabase();
		
		connect = db.connectDatabase();
		//BatchSQL
		batchSQL.cleanDB(preparedStatement, connect);
		batchSQL.insertTeachers(preparedStatement, connect);
		batchSQL.insertCourses(preparedStatement, connect);
		batchSQL.insertStudents(preparedStatement, connect);
		batchSQL.insertCourseStudents(preparedStatement, connect);
		batchSQL.insertCourseResults(preparedStatement, connect);
		
		//Exercise 4
		String exercise4 = 
				"SELECT courses.name, teachers.lastname, teachers.firstname, students.lastname, students.firstname" 
				+ " FROM courses, teachers, students, coursestudents"
				+ " WHERE courses.idcourse = coursestudents.idcourse"
				+ " AND courses.assignedteacher = teachers.idteacher"
				+ " AND  coursestudents.idstudent = students.idstudent"
                + " ORDER BY courses.name, students.lastname;";
		
		statement = connect.createStatement();
		resultSet = statement.executeQuery(exercise4);
		
		String tempcoursename = "";
		while (resultSet.next()) {
			//goes through the result set
			String coursename = resultSet.getString(1);
			String tlastname = resultSet.getString(2);
			String tfirstname = resultSet.getString(3);
			String slastname = resultSet.getString(4);
			String sfirstname = resultSet.getString(5);
			//if it's a different course than the last one, prints its info
			//this works thanks to the ORDER BY course.name
			if  (!tempcoursename.equals(coursename)) {
				System.out.println("");
				System.out.println("Course: " + coursename);
				System.out.println("Teacher: " + tlastname + ", " + tfirstname);
				System.out.println("Students:");
				tempcoursename = coursename;
			}
			
			System.out.println(slastname + ", " + sfirstname);
				
		}
		
		//Exercise 5
		
		System.out.println("\nPlease type a Student ID to get his final course notes: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String exercise5 = "SELECT students.lastname, students.firstname, courseresults.result, courses.name" + 
				" FROM students, courseresults, courses" +
                " WHERE courses.idcourse = courseresults.idcourse" +
                " AND students.idstudent = courseresults.idstudent" +
                " AND students.idstudent = " + input + " AND courseresults.isfinal = 1" +
                " ORDER BY courses.name, courseresults.result";
		
		sc.close();
		statement = connect.createStatement();
		resultSet = statement.executeQuery(exercise5);
		
		boolean flag = false;
		while (resultSet.next()) {
			
			
			if (flag == false) {
				System.out.println("Student: " + resultSet.getString(1) + ", " + resultSet.getString(2));
				flag = true;
			}
			
			System.out.println("Course: " + resultSet.getString(4) + " Result: " + resultSet.getString(3));
		}
		
		db.closeDatabase();
	}
	


}
