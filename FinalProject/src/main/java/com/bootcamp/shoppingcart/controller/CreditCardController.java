package com.bootcamp.shoppingcart.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import com.bootcamp.shoppingcart.entity.CreditCard;
import com.bootcamp.shoppingcart.service.CreditCardRepository;

@RestController
@RequestMapping(value = "/api/user/{idusr}/creditcard")
public class CreditCardController {
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	//Get Credit Card By Id
	@RequestMapping(value = "/{idcc}", method = RequestMethod.GET)
	public CreditCard findByUserId(@PathVariable long idcc) {
		return creditCardRepository.findOne(idcc);
	}
	
	//Add a Credit Card
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody CreditCard creditCard, HttpServletRequest request, HttpServletResponse response){
		creditCardRepository.save(creditCard);
		Long newId = creditCard.getId();
		String requestUrl = request.getRequestURL().toString();
		URI uri = new UriTemplate("{requestUrl}{{id}}").expand(requestUrl, newId);
		response.setHeader("Location",uri.toASCIIString());
	}
	
	//Modify a Credit Card
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody CreditCard creditCard){
		CreditCard rx = creditCardRepository.findOne(id);
		if(rx == null){
			throw new IllegalStateException("No Credit Card with id: " + id);
		}
			creditCard.setId(rx.getId());
			creditCardRepository.save(creditCard);
	}
	
	//Delete a Credit Card By Id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		creditCardRepository.delete(id);
	}
}
