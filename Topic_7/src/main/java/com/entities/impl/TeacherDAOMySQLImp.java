package com.entities.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.entities.Teacher;

@Repository
public class TeacherDAOMySQLImp implements TeacherDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void storeTeacher(int idTeacher, String firstName, String lastName, Date birthdate) {
		Teacher teacher = new Teacher();
		teacher.setIdTeacher(idTeacher);
		teacher.setFirstName(firstName);
		teacher.setLastName(lastName);
		teacher.setBirthdate(birthdate);
		entityManager.getTransaction().begin();
		entityManager.persist(teacher);
		entityManager.getTransaction().commit();
	}

	@Override
	public void storeTeacher(Teacher teacher) {
		entityManager.getTransaction().begin();
		entityManager.persist(teacher);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Teacher> getAllTeachers() {
		Query q1 = (Query) entityManager.createQuery("SELECT t "
				+ "from Teacher t ");
				
		List<Teacher> queryResult = q1.getResultList();
		return queryResult;
	}

	@Override
	public Teacher getTeacher(int idTeacher) {
		Query q1 = (Query) entityManager.createQuery("SELECT t "
				+ "from Teacher t "
				+ "where  (t.idTeacher = "+ idTeacher + ") ");
				
		Teacher queryResult = (Teacher) q1.getSingleResult();
		return queryResult;
	}

}
