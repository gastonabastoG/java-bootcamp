package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login/{nickName}/")
public class UserLoginRestController {
	
	@Autowired
	private final UserService userService;
	
	@Autowired
	UserLoginRestController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/{password}", method = RequestMethod.GET)
	boolean login(@PathVariable String nickName, @PathVariable String password) {
		return userService.login(nickName, password);
	}
	
}
