package com.entities.impl;

import java.util.List;

import javax.servlet.Registration;

import com.entities.Course;
import com.entities.Student;

/**
 * Registrations entity Data Access Object interface
 *
 */
public interface RegistrationsDAO {

	/**
	 * Store a new registration on database
	 * @param r
	 */
	public void storeRegistration(Registration r);
	/**
	 * Fetch all courses of a given student
	 * 
	 * @param registrationNumber
	 *            student's id
	 * @return list containing all courses of the student
	 */
	public List<Course> getAllCoursesOfStudent(int registrationNumber);

	/**
	 * Fetch all students of a given course
	 * 
	 * @param idCourse
	 *            courses's id
	 * @return list containing all students of the course
	 */
	public List<Student> getAllStudents(int idCourse);
}
