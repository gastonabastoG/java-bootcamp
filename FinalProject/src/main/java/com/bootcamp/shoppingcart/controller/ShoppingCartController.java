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

import com.bootcamp.shoppingcart.entity.ShoppingCart;
import com.bootcamp.shoppingcart.exceptions.ShoppingCartDoesNotExistException;
import com.bootcamp.shoppingcart.exceptions.UserDoesNotExistException;
import com.bootcamp.shoppingcart.service.ShoppingCartRepository;
import com.bootcamp.shoppingcart.service.UserRepository;

@RestController
@RequestMapping(value = "/api/user/{usrid}/cart")
public class ShoppingCartController {
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private UserRepository userRepository;
	
	//get a shoppingcart with the passed id
    @RequestMapping(value ="{scid}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ShoppingCart getShoppingCartById(@PathVariable long scid) throws ShoppingCartDoesNotExistException {
    ShoppingCart shoppingCart = shoppingCartRepository.findOne(scid);
    if(shoppingCart == null){
    	throw new ShoppingCartDoesNotExistException(scid);
    }
    return shoppingCart;
   }
	
	//Create a Shopping Cart
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ShoppingCart shoppingCart, @PathVariable long usrid, HttpServletRequest request, HttpServletResponse response) throws UserDoesNotExistException {
		if(userRepository.findOne(usrid) == null){
			throw new UserDoesNotExistException(usrid);
		}
		shoppingCartRepository.save(shoppingCart);
		Long newId = shoppingCart.getId();
		String requestUrl = request.getRequestURL().toString();
		URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, newId);
		response.setHeader("Location",uri.toASCIIString());
	}
	
	//Modify a Shopping Cart
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody ShoppingCart shoppingCart){
		ShoppingCart rx = shoppingCartRepository.findOne(id);
		if(rx == null){
			throw new IllegalStateException("No Shopping Cart with id: " + id);
		}
			shoppingCart.setId(rx.getId());
			shoppingCartRepository.save(shoppingCart);
	}
	
	//Delete a Shopping Cart By Id
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		shoppingCartRepository.delete(id);
	}
}
