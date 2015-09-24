package com.mfidececchi.mysql.java;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class DBConnector {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3307/high-school";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "admin";

	// private objects
	private Statement stmt;
	Connection conn;

	/**
	 * This function allows execute a query in database ´high-school´. The
	 * queries was fixed and established for the exercises of topic5.
	 * 
	 * @param queryNumber
	 *            <p>
	 *            <b><i>3: </i></b> Insert information for 3 teachers, 5 courses
	 *            and 20 students per course.</br>
	 *            <b><i>4: </i></b> List students and teachers for a given
	 *            course.</br>
	 *            <b><i>5: </i></b> List final course notes for a given
	 *            student.</br>
	 *            </p>
	 */
	public void executeQuery(int queryNumber) {
		conn = null;
		stmt = null;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "";
			switch (queryNumber) {
			case 3: {
				exercise3();
				break;
			}
			case 4: {
				exercise4();
				break;
			}
			case 5: {
				exercise5();
				break;
			}
			default:
				return;
			}

			// Clean-up environment
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	private void exercise5() throws SQLException {
		System.out.println("Input a Student ID for notes");
		Scanner scanner = new Scanner(System.in);
		String studentId = scanner.nextLine();

		String sql = "SELECT student.lastName, student.firstName, note.value, course.name, note.date "
				+ "FROM note, student, course, note_types " 
				+ "WHERE note.fk_note_type = note_types.id "
				+ "AND note_types.id = 2 " 
				+ "AND note.fk_student = student.id " 
				+ "AND student.id = 5 "
				+ "AND NOTE.fk_course = course.id " 
				+ "ORDER BY note.value DESC, course.name";

		// Execute query
		ResultSet rs = stmt.executeQuery(sql);
		// Extract data from result set
		System.out.println("Results-----------------");
		boolean displayStudent = true;
		while (rs.next()) {
			// Retrieve by column name
			String courseName = rs.getString(4);
			String studentLastName = rs.getString(1);
			String studentFirstName = rs.getString(2);
			String noteValue = rs.getString(3);
			String noteDate = rs.getString(5);

			// Display values
			if (displayStudent) {
				System.out.println("Student: " + studentLastName + ", " + studentFirstName);
				displayStudent = false;
			}
			System.out.println("Note: " + noteValue + " Course: " + courseName + " Date: " + noteDate);
		}
		System.out.print("End-----------------------");
		rs.close();

	}

	private void exercise4() throws SQLException {

		String sql = "SELECT course.name , teacher.lastName , teacher.firstName, student.lastName, student.firstName "
				+ "FROM course, student_course, teacher, student " 
				+ "WHERE course.id = student_course.fk_course "
				+ "AND teacher.id = course.fk_teacher " 
				+ "AND student.id = student_course.fk_student "
				+ "ORDER BY course.name, student.lastName;";
		// Execute query
		ResultSet rs = stmt.executeQuery(sql);
		// Extract data from result set
		System.out.println("Results-----------------");
		String lastCourse = "";
		while (rs.next()) {
			// Retrieve by column name
			String courseName = rs.getString(1);
			String teacherLastName = rs.getString(2);
			String teacherFirstName = rs.getString(3);
			String studentLastName = rs.getString(4);
			String studentFirstName = rs.getString(5);

			// Display values
			if (!lastCourse.equals(courseName)) {
				System.out.println("Course: " + courseName);
				System.out.println("Teacher: " + teacherLastName + ", " + teacherFirstName);
				System.out.println("Students: ");
				lastCourse = courseName;
			}
			System.out.println(studentLastName + ", " + studentFirstName);
		}
		System.out.print("End-----------------------");
		rs.close();
	}

	private void exercise3() throws SQLException {

		// teachers data String
		String sql = "INSERT INTO `high-school`.teacher (firstName, lastName, birthDate) VALUES "
				+ "('fabricio', 'pereira', '1980-02-01 00:00:00'), " 
				+ "('pedro', 'carline', '1982-08-22 00:00:00'), "
				+ "('ignacio', 'rojo', '1950-12-11 00:00:00') ";

		System.out.println("Running teachers data entry.."); // Execute query
		stmt.executeUpdate(sql); // Extract data from result set
		System.out.println("Teachers data is successfully added to database");

		// Students data
		sql = "INSERT INTO `high-school`.student (firstName, lastName, birthDate) VALUES "
				+ "('Blair', 'Arias', '1995-02-22 00:00:00'), " 
				+ "('Cory', 'Elam', '1995-08-23 00:00:00'), "
				+ "('Fabiola', 'Durfee', '1994-12-24 00:00:00'), " 
				+ "('Loren', 'Albrecht', '1994-03-11 00:00:00'), "
				+ "('Easter', 'Loach', '1995-09-15 00:00:00'), " 
				+ "('Teena', 'Lajeunesse', '1993-10-16 00:00:00'), "
				+ "('Veola', 'Cadogan', '1993-01-14 00:00:00'), " 
				+ "('Ivonne', 'Christine', '1990-02-07 00:00:00'), "
				+ "('Mireya', 'Geib', '1996-04-28 00:00:00'), " 
				+ "('Tobi', 'Bryner', '1996-05-29 00:00:00'), "
				+ "('Virgie', 'Collette', '1995-06-06 00:00:00'), " 
				+ "('Erika', 'Kuhlman', '1994-07-16 00:00:00'), "
				+ "('Kenny', 'Bedwell', '1994-11-20 00:00:00'), " 
				+ "('Karisa', 'Mincey', '1994-11-11 00:00:00'), "
				+ "('Adriane', 'Benefield', '1991-01-10 00:00:00'), " 
				+ "('Marica', 'Cawthon', '1991-02-05 00:00:00'), "
				+ "('Jamey', 'Malachi', '1992-03-29 00:00:00'), " 
				+ "('Luigi', 'Curley', '1993-09-30 00:00:00'), "
				+ "('Caroline', 'Solberg', '1993-09-30 00:00:00'), "
				+ "('Federica', 'Shetley', '1993-08-16 00:00:00') ";

		System.out.println("Running students data entry.."); // Execute query
		stmt.executeUpdate(sql); // Extract data from result set
		System.out.println("Students data is successfully added to database");

		// Courses data
		sql = "INSERT INTO `high-school`.course (name, hoursByWeek, year, fk_teacher) VALUES "
				+ "('java-basic','20','2015','1'), " 
				+ "('java-intermediate','30','2015','1'), "
				+ "('java-advanced','10','2015','2'), " 
				+ "('mysql-basic','20','2015','3'), "
				+ "('java-advanced','20','2015','3')";

		System.out.println("Running courses data entry.."); // Execute query
		stmt.executeUpdate(sql); // Extract data from result set
		System.out.println("Courses data is successfully added to database");

		// schedules of courses
		sql = "INSERT INTO `high-school`.schedule_time (fk_course, timeFrom, timeUntil, dayOfWeek) VALUES "
				+ "('1','10:00:00','12:00:00','2'), " 
				+ "('1','15:00:00','17:00:00','4'), "
				+ "('2','17:00:00','21:00:00','4'), " 
				+ "('2','20:00:00','23:00:00','5'), "
				+ "('3','07:00:00','12:00:00','1'), " 
				+ "('3','17:00:00','20:00:00','3'), "
				+ "('4','15:00:00','20:00:00','2'), " 
				+ "('4','10:00:00','18:00:00','4'), "
				+ "('5','12:00:00','18:00:00','1')";

		System.out.println("Running schedule data entry..");
		// Execute query
		stmt.executeUpdate(sql);
		// Extract data from result set
		System.out.println("Schedule data is successfully added to database");

		// note types data String
		sql = "INSERT INTO `high-school`.note_types (description) VALUES " + "('partial'), " + "('final')";

		System.out.println("Running note types data entry..");
		// Execute query
		stmt.executeUpdate(sql);
		// Extract data from result set
		System.out.println("Note type data is successfully added to database");

		// recording of students at courses (student_course)
		sql = "INSERT INTO `high-school`.student_course (fk_student, fk_course) VALUES "
				+ "('1','1'), ('1','2'), ('1','3'), ('1','4'), ('1','5'), "
				+ "('2','1'), ('2','2'), ('2','3'), ('2','4'), ('2','5'), "
				+ "('3','1'), ('3','2'), ('3','3'), ('3','4'), ('3','5'), "
				+ "('4','1'), ('4','2'), ('4','3'), ('4','4'), ('4','5'), "
				+ "('5','1'), ('5','2'), ('5','3'), ('5','4'), ('5','5'), "
				+ "('6','1'), ('6','2'), ('6','3'), ('6','4'), ('6','5'), "
				+ "('7','1'), ('7','2'), ('7','3'), ('7','4'), ('7','5'), "
				+ "('8','1'), ('8','2'), ('8','3'), ('8','4'), ('8','5'), "
				+ "('9','1'), ('9','2'), ('9','3'), ('9','4'), ('9','5'), "
				+ "('10','1'), ('10','2'), ('10','3'), ('10','4'), ('10','5'), "
				+ "('11','1'), ('11','2'), ('11','3'), ('11','4'), ('11','5'), "
				+ "('12','1'), ('12','2'), ('12','3'), ('12','4'), ('12','5'), "
				+ "('13','1'), ('13','2'), ('13','3'), ('13','4'), ('13','5'), "
				+ "('14','1'), ('14','2'), ('14','3'), ('14','4'), ('14','5'), "
				+ "('15','1'), ('15','2'), ('15','3'), ('15','4'), ('15','5'), "
				+ "('16','1'), ('16','2'), ('16','3'), ('16','4'), ('16','5'), "
				+ "('17','1'), ('17','2'), ('17','3'), ('17','4'), ('17','5'), "
				+ "('18','1'), ('18','2'), ('18','3'), ('18','4'), ('18','5'), "
				+ "('19','1'), ('19','2'), ('19','3'), ('19','4'), ('19','5'), "
				+ "('20','1'), ('20','2'), ('20','3'), ('20','4'), ('20','5')";

		System.out.println("Running student-course registration data entry..");
		// Execute query
		stmt.executeUpdate(sql);
		// Extract data from result set
		System.out.println("Student-course registration data is successfully added to database");

		// recording of notes for each student for each course (note).
		//the note values are introduced randomly.
		sql = "INSERT INTO `high-school`.note (fk_note_type, date, fk_student, fk_course, value) VALUES ";
		Random r = new Random();
		String values = "";
		for (int student = 1; student <= 20; student++) {
			for (int course = 1; course <= 5; course++) {
				// first time without comma
				if (student == 1 && course == 1) {
					values += "('1','2015-09-11','" + student + "','" + course + "','" + r.nextInt(11) + "')";
					values += ", ('1','2015-09-15','" + student + "','" + course + "','" + r.nextInt(11) + "')";
					values += ", ('1','2015-09-19','" + student + "','" + course + "','" + r.nextInt(11) + "')";
					values += ", ('2','2015-10-30','" + student + "','" + course + "','" + r.nextInt(11) + "')";
				} else {
					values += ", ('1','2015-09-11','" + student + "','" + course + "','" + r.nextInt(11) + "')";
					values += ", ('1','2015-09-15','" + student + "','" + course + "','" + r.nextInt(11) + "')";
					values += ", ('1','2015-09-19','" + student + "','" + course + "','" + r.nextInt(11) + "')";
					values += ", ('2','2015-10-30','" + student + "','" + course + "','" + r.nextInt(11) + "')";
				}
			}

		}
		sql += values;

		System.out.println("Running note data entry..");
		// Execute query
		stmt.executeUpdate(sql);
		// Extract data from result set
		System.out.println("Note data is successfully added to database");

	}
}