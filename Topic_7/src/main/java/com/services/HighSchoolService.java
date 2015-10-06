package com.services;

import java.util.List;

import javax.servlet.Registration;

import com.entities.Course;
import com.entities.Student;
import com.entities.Teacher;

/**
 * Highschool service interface
 *
 */
public interface HighSchoolService {

	/**
	 * Store a new student
	 * 
	 * @param s
	 */
	public void addStudent(Student s);

	/**
	 * Store a new teacher
	 * 
	 * @param t
	 */
	public void addTeacher(Teacher t);

	/**
	 * Store a new course
	 * 
	 * @param c
	 */
	public void addCourse(Course c);

	/**
	 * Store a new registration
	 * 
	 * @param r
	 */
	public void addRegistration(Registration r);

	/**
	 * Fetch all students from database
	 * 
	 * @return list containing all students
	 */
	public List<Student> getAllStudents();

	/**
	 * Fetch all teachers from database
	 * 
	 * @return list containing all teachers
	 */
	public List<Teacher> getAllTeachers();

	/**
	 * Fetch all students from courses
	 * 
	 * @return list containing all courses
	 */
	public List<Course> getAllCourses();

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
	 *            course's id
	 * @return list containing all studends of the course
	 */
	public List<Student> getAllStudents(int idCourse);
}
