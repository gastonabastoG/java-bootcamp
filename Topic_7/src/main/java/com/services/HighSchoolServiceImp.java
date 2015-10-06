package com.services;

import java.util.List;

import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Course;
import com.entities.Student;
import com.entities.Teacher;
import com.entities.impl.CourseDAO;
import com.entities.impl.RegistrationsDAO;
import com.entities.impl.StudentDAO;
import com.entities.impl.TeacherDAO;

@Service
public class HighSchoolServiceImp implements HighSchoolService {

	@Autowired
	private CourseDAO courseDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private TeacherDAO teacherDAO;

	@Autowired
	private RegistrationsDAO registrationsDAO;

	@Override
	public void addStudent(Student s) {
		studentDAO.storeStudent(s);
	}

	@Override
	public void addTeacher(Teacher t) {
		teacherDAO.storeTeacher(t);
	}

	@Override
	public void addCourse(Course c) {
		courseDAO.storeCourse(c);
	}

	@Override
	public void addRegistration(Registration r) {
		registrationsDAO.storeRegistration(r);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherDAO.getAllTeachers();
	}

	@Override
	public List<Course> getAllCourses() {
		return courseDAO.getAllCourses();
	}

	@Override
	public List<Course> getAllCoursesOfStudent(int registrationNumber) {
		return registrationsDAO.getAllCoursesOfStudent(registrationNumber);
	}

	@Override
	public List<Student> getAllStudents(int idCourse) {
		return registrationsDAO.getAllStudents(idCourse);
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studenDAO) {
		this.studentDAO = studenDAO;
	}

	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public RegistrationsDAO getRegistrationsDAO() {
		return registrationsDAO;
	}

	public void setRegistrationsDAO(RegistrationsDAO registrationsDAO) {
		this.registrationsDAO = registrationsDAO;
	}

}
