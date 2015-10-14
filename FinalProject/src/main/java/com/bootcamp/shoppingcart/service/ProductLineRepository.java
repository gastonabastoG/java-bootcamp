package com.bootcamp.shoppingcart.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.shoppingcart.entity.ProductLine;

@Repository
public interface ProductLineRepository extends CrudRepository<ProductLine, Long>{

}
