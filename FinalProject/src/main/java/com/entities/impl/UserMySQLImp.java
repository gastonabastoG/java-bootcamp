package com.entities.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.entities.User;

@Repository
public class UserMySQLImp implements UserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User getUser(int id) {
		//Query lQuery  = (Query) entityManager.createQuery("SELECT u  from User u where  (u.id = "+ Integer.toString(id) + ") ");
		TypedQuery<User> lQuery =  entityManager.createQuery("SELECT u  FROM User u WHERE  (u.id = "+ Integer.toString(id) + ") ", User.class);
				
		User queryResult = lQuery .getSingleResult();
		return queryResult;
	}
	
	@Override
	public List<User> getAllUsers() {
		//Query lQuery  = (Query) entityManager.createQuery("SELECT u from User u");
		TypedQuery<User> lQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
		List<User> queryResult = lQuery.getResultList();
		return queryResult;
	}
	
	@Override
	public User getUser(String nickName) {
		Query oQuery  = (Query)  entityManager.createQuery("SELECT u FROM User u WHERE  (u.nickName = '"+ nickName + "') ");
				
		User queryResult =  (User) oQuery.getSingleResult();
		return queryResult;
	}
	
}
