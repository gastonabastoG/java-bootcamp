package com.entities.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entities.Course;

@Repository
public class CourseDAOMySQLImp implements CourseDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void storeCourse(int idCourse, String name, int assignedTeacher) {
		Course course = new Course();
		course.setIdCourse(idCourse);
		course.setName(name);
		course.setAssignedTeacher(assignedTeacher);
		entityManager.getTransaction().begin();
		entityManager.persist(course);
		entityManager.getTransaction().commit();
	}

	@Override
	public void storeCourse(Course course) {
		entityManager.getTransaction().begin();
		entityManager.persist(course);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Course> getAllCourses() {
		Query q1 = (Query) entityManager.createQuery("SELECT c " + "from Course c ");

		List<Course> queryResult = q1.getResultList();
		return queryResult;
	}

	@Override
	public Course getCourse(int idCourse) {
		Query q1 = (Query) entityManager.createQuery("SELECT c " + "from Course c " + "where  (c.idCourse = " + idCourse + ") ");

		Course queryResult = (Course) q1.getSingleResult();
		return queryResult;
	}
}
