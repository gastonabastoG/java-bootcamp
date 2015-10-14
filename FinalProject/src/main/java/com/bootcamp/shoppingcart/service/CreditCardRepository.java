package com.bootcamp.shoppingcart.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.shoppingcart.entity.CreditCard;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long>{
	
//	@Query("SELECT u.creditcard FROM User u WHERE u.id = ?")
//	Iterable<CreditCard> findByUserid(long userId);
	
//	@Query("SELECT p FROM Product p INNER JOIN p.category c WHERE c.description = :desc")
//	List<Product> findByCategory(@Param("desc") String category);
	
//	@Query("select cc from CreditCard cc inner join User u on u.creditCard_id = cc.id where cc.id = ?1 and u.id = ?2")
//	CreditCard findACreditCard(long idCreditCard, long idUsr);
}
