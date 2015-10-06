package com.entities.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.Registration;

import org.springframework.stereotype.Repository;

import com.entities.Course;
import com.entities.Student;

@Repository
public class RegistrationsDAOMySQLImp implements RegistrationsDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void storeRegistration(Registration r) {
		entityManager.getTransaction().begin();
		entityManager.persist(r);
		entityManager.getTransaction().commit();		
	}

	@Override
	public List<Course> getAllCoursesOfStudent(int registrationNumber) {
		Query q1 = (Query) entityManager.createQuery("SELECT c "
				+ "from Course c, Registrations r "
				+ "where  (c.idCourse =  r.idCourse) and (r.registrationNumber = "+ registrationNumber + ") ");
				
		List<Course> queryResult = q1.getResultList();
		return queryResult;
	}

	@Override
	public List<Student> getAllStudents(int idCourse) {
		Query q1 = (Query) entityManager.createQuery("SELECT s "
				+ "from Student s, Registrations r "
				+ "where  (s.registrationNumber =  r.registrationNumber) and (r.idCourse = "+ idCourse + ") ");
				
		List<Student> queryResult = q1.getResultList();
		return queryResult;
	}
}
