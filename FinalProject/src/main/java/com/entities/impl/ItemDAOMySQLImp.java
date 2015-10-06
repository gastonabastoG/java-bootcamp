package com.entities.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.entities.Item;

@Repository
public class ItemDAOMySQLImp implements ItemDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Item> getItemsByCategory(String name) {
		TypedQuery<Item> lQuery = entityManager.createQuery("SELECT i  "
				+ "from Item i, Category c "
				+ "where  (i.category = c.idCategory) and (c.name = "+ name + ") ", Item.class);
				
		List<Item> queryResult = lQuery.getResultList();
		return queryResult;
	}

	@Override
	public List<Item> getItemsByName(String name) {
		TypedQuery<Item> lQuery = entityManager.createQuery("SELECT i  "
				+ "from Item i "
				+ "where  (i.name = "+ name + ") ", Item.class);
				
		List<Item> queryResult = lQuery.getResultList();
		return queryResult;
	}

}
