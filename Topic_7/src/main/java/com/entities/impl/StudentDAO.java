package com.entities.impl;

import java.sql.Date;
import java.util.List;

import com.entities.Student;

/**
 * Student entity Data Access Object interface
 *
 */
public interface StudentDAO {
	/**
	 * Store a new student in database
	 * 
	 * @param registrationNumber
	 * @param firstName
	 * @param lastName
	 * @param birthdate
	 */
	public void storeStudent(int registrationNumber, String firstName, String lastName, Date birthdate);

	/**
	 * Store a new student in database
	 * 
	 * @param student
	 */
	public void storeStudent(Student student);

	/**
	 * Fetch all student from database
	 * 
	 * @return list containing all students
	 */
	public List<Student> getAllStudents();

	/**
	 * Fetch a specific student from database
	 * 
	 * @param registrationNumber
	 *            student's registration number
	 * @return
	 */
	public Student getStudent(int registrationNumber);

}
