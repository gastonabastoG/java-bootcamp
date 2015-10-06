package com.entities.impl;

import java.util.List;

import com.entities.Course;

/**
 * Course entity Data Access Object interface
 *
 */
public interface CourseDAO {

	/**
	 * Store in database a new course
	 * 
	 * @param idCourse
	 *            course's identity number
	 * @param name
	 *            course's name
	 * @param assignedTeacher
	 *            identity number of course's assigned teacher
	 */
	public void storeCourse(int idCourse, String name, int assignedTeacher);

	/**
	 * Store in database a new course
	 */
	public void storeCourse(Course course);

	/**
	 * Fetch all courses stored in database
	 * 
	 * @return list containing all courses
	 */
	public List<Course> getAllCourses();

	/**
	 * Fetch a especific course
	 * 
	 * @param idCourse
	 *            course's identity number
	 * @return
	 */
	public Course getCourse(int idCourse);
}
