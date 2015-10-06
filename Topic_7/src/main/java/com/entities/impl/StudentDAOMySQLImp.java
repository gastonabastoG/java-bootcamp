package com.entities.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entities.Student;

@Repository
public class StudentDAOMySQLImp implements StudentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void storeStudent(int registrationNumber, String firstName, String lastName, Date birthdate) {
		Student student = new Student();
		student.setRegistrationNumber(registrationNumber);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setBirthdate(birthdate);
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
	}

	@Override
	public void storeStudent(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Student> getAllStudents() {
		Query q1 = (Query) entityManager.createQuery("SELECT s "
				+ "from Student s ");
				
		List<Student> queryResult = q1.getResultList();
		return queryResult;
	}

	@Override
	public Student getStudent(int registrationNumber) {
		Query q1 = (Query) entityManager.createQuery("SELECT s "
				+ "from Student s "
				+ "where  (s.registrationNumber = "+ registrationNumber + ") ");
				
		Student queryResult = (Student) q1.getSingleResult();
		return queryResult;
	}

}
