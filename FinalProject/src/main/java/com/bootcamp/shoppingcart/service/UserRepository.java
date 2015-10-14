package com.bootcamp.shoppingcart.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.shoppingcart.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findById(Long id);
}
