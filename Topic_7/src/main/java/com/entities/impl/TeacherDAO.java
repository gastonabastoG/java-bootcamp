package com.entities.impl;

import java.sql.Date;
import java.util.List;

import com.entities.Teacher;

/**
 * Teacher entity Data Access Object interface
 *
 */
public interface TeacherDAO {
	/**
	 * Store a new teacher in database
	 * 
	 * @param idTeacher
	 *            teacher's identity number
	 * @param firstName
	 * @param lastName
	 * @param birthdate
	 */
	public void storeTeacher(int idTeacher, String firstName, String lastName, Date birthdate);

	/**
	 * Store a new teacher in database
	 * 
	 * @param teacher
	 */
	public void storeTeacher(Teacher teacher);

	/**
	 * Fetch all teachers from database
	 * 
	 * @return list containing all teachers
	 */
	public List<Teacher> getAllTeachers();

	/**
	 * Fetch a specific teacher from database
	 * 
	 * @param idTeacher
	 * @return
	 */
	public Teacher getTeacher(int idTeacher);

}
