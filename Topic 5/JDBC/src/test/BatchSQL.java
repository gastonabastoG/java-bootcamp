package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchSQL {
	//This class does the DB Batch prepared statements
	public void cleanDB(PreparedStatement preparedStatement, Connection connect) throws Exception{
		//Erase all info on all tables
		preparedStatement = connect.prepareStatement
				("DELETE  FROM courseresults");
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement
				("DELETE FROM coursestudents");
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement
				("DELETE FROM schedules");
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement
				("DELETE FROM courses");
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement
				("DELETE FROM students");
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement
				("DELETE FROM teachers");
		preparedStatement.executeUpdate();
}
	
	public void insertTeachers(PreparedStatement preparedStatement, Connection connect)throws Exception {
		
				//Insert into teacher statement
				String insertTeachersSQL = "INSERT INTO teachers VALUES (?,?,?,?)";
				preparedStatement = connect.prepareStatement(insertTeachersSQL);
				
				//Each teacher is added to batch and then the batch is executed
				//Same for all other tables later
				preparedStatement.setInt(1, 3485);
				preparedStatement.setString(2, "Saul");
				preparedStatement.setString(3, "Herrera");
				preparedStatement.setDate(4, java.sql.Date.valueOf("1956-03-14"));
				preparedStatement.addBatch();
				
				preparedStatement.setInt(1, 4853);
				preparedStatement.setString(2, "Azul");
				preparedStatement.setString(3, "Chamorro");
				preparedStatement.setDate(4, java.sql.Date.valueOf("1967-09-12"));
				preparedStatement.addBatch();
				
				preparedStatement.setInt(1, 3152);
				preparedStatement.setString(2, "Mauro");
				preparedStatement.setString(3, "Pettinari");
				preparedStatement.setDate(4, java.sql.Date.valueOf("1960-12-21"));
				preparedStatement.addBatch();
				
				preparedStatement.executeBatch();
	}

	
	public void insertCourses(PreparedStatement preparedStatement, Connection connect) throws Exception{
		String insertCoursesSQL = "INSERT INTO courses VALUES (?,?,?,?)";
		preparedStatement = connect.prepareStatement(insertCoursesSQL);
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, "English");
		preparedStatement.setInt(3, 3152);
		preparedStatement.setInt(4,10);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setString(2, "Programming");
		preparedStatement.setInt(3, 3152);
		preparedStatement.setInt(4,8);
		preparedStatement.addBatch();

		preparedStatement.setInt(1, 3);
		preparedStatement.setString(2, "Algebra");
		preparedStatement.setInt(3, 3485);
		preparedStatement.setInt(4,6);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 4);
		preparedStatement.setString(2, "Logic");
		preparedStatement.setInt(3, 4853);
		preparedStatement.setInt(4,10);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 5);
		preparedStatement.setString(2, "Databases");
		preparedStatement.setInt(3, 4853);
		preparedStatement.setInt(4,9);
		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();
	}

	
	public void insertStudents(PreparedStatement preparedStatement, Connection connect) throws Exception{
		
		String insertStudentsSQL = "INSERT INTO students VALUES (?,?,?,?)";
		preparedStatement = connect.prepareStatement(insertStudentsSQL);
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, "Baul");
		preparedStatement.setString(3, "Saratti");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1993-12-19"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setString(2, "Juan");
		preparedStatement.setString(3, "Perez");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1994-11-23"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setString(2, "Ignacio");
		preparedStatement.setString(3, "Ramos");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1990-01-14"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 4);
		preparedStatement.setString(2, "Maki");
		preparedStatement.setString(3, "Cuerpa");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1993-08-10"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 5);
		preparedStatement.setString(2, "Matt");
		preparedStatement.setString(3, "Foster");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1996-02-04"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 6);
		preparedStatement.setString(2, "Estefi");
		preparedStatement.setString(3, "Errote");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1987-01-31"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 7);
		preparedStatement.setString(2, "Tito");
		preparedStatement.setString(3, "Max");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1993-02-22"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 8);
		preparedStatement.setString(2, "Elliot");
		preparedStatement.setString(3, "Alderson");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1989-09-13"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 9);
		preparedStatement.setString(2, "Jorge");
		preparedStatement.setString(3, "Saer");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1988-01-04"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 10);
		preparedStatement.setString(2, "Gloria");
		preparedStatement.setString(3, "Sander");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1985-08-29"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 11);
		preparedStatement.setString(2, "Nestor");
		preparedStatement.setString(3, "De Bernardo");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1996-02-14"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 12);
		preparedStatement.setString(2, "Leandro");
		preparedStatement.setString(3, "Pross");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1992-07-17"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 13);
		preparedStatement.setString(2, "Monica");
		preparedStatement.setString(3, "Princic");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1988-11-13"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 14);
		preparedStatement.setString(2, "Daniel");
		preparedStatement.setString(3, "Pross");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1986-05-14"));
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 15);
		preparedStatement.setString(2, "Sergio");
		preparedStatement.setString(3, "Gumer");
		preparedStatement.setDate(4, java.sql.Date.valueOf("1994-07-29"));
		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();
	}

	
	public void insertCourseStudents(PreparedStatement preparedStatement, Connection connect) throws Exception{
		
		String insertCourseStudentsSQL = "INSERT INTO coursestudents VALUES (?,?)"; 
		preparedStatement = connect.prepareStatement(insertCourseStudentsSQL);
		
		//Here i could insert the ids getting them
		//from a SQL query of students/teachers or just hardcode them
		//gonna hardcode them, since the foreign key constraints will
		//make sure that the values i write down exist in their respective
		//tables
		
		//First value is idcourse, second is idstudent
		preparedStatement.setInt(1, 1);
		preparedStatement.setInt(2, 3);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 3);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setInt(2, 1);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setInt(2, 2);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setInt(2, 5);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 8);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 10);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 11);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 12);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setInt(2, 1);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setInt(2, 7);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setInt(2, 6);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 4);
		preparedStatement.setInt(2, 15);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 4);
		preparedStatement.setInt(2, 14);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 5);
		preparedStatement.setInt(2, 9);
		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();
		
	}

	
	public void insertCourseResults(PreparedStatement preparedStatement, Connection connect) throws Exception {
		
		String insertCourseResultsSQL = "INSERT INTO courseresults VALUES(?,?,?,?,?)";
		preparedStatement = connect.prepareStatement(insertCourseResultsSQL);
		
		preparedStatement.setInt(1, 1); //idcourse
		preparedStatement.setInt(2, 1); //idstudent
		preparedStatement.setInt(3, 1); //examnumber
		preparedStatement.setInt(4, 4); //result
		preparedStatement.setBoolean(5, true); //isFinal
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3); 
		preparedStatement.setInt(2, 1); 
		preparedStatement.setInt(3, 1);
		preparedStatement.setInt(4, 9);
		preparedStatement.setBoolean(5, true); 
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setInt(2, 3);
		preparedStatement.setInt(3, 2);
		preparedStatement.setInt(4, 5);
		preparedStatement.setBoolean(5, false);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setInt(2, 3);
		preparedStatement.setInt(3, 3);
		preparedStatement.setInt(4, 4);
		preparedStatement.setBoolean(5, true);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 8);
		preparedStatement.setInt(3, 1);
		preparedStatement.setInt(4, 4);
		preparedStatement.setBoolean(5, false);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 8);
		preparedStatement.setInt(3, 2);
		preparedStatement.setInt(4, 10);
		preparedStatement.setBoolean(5, false);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 8);
		preparedStatement.setInt(3, 3);
		preparedStatement.setInt(4, 9);
		preparedStatement.setBoolean(5, true);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 10);
		preparedStatement.setInt(3, 1);
		preparedStatement.setInt(4, 2);
		preparedStatement.setBoolean(5, false);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 10);
		preparedStatement.setInt(3, 2);
		preparedStatement.setInt(4, 7);
		preparedStatement.setBoolean(5, false);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 10);
		preparedStatement.setInt(3, 3);
		preparedStatement.setInt(4, 10);
		preparedStatement.setBoolean(5, true);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setInt(2, 7);
		preparedStatement.setInt(3, 1);
		preparedStatement.setInt(4, 8);
		preparedStatement.setBoolean(5, false);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setInt(2, 7);
		preparedStatement.setInt(3, 2);
		preparedStatement.setInt(4, 5);
		preparedStatement.setBoolean(5, false);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1, 3);
		preparedStatement.setInt(2, 7);
		preparedStatement.setInt(3, 3);
		preparedStatement.setInt(4, 9);
		preparedStatement.setBoolean(5, true);
		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();
	}

	

}
