package com.rest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.User;
import com.services.UserServiceImpl;


public class Application {

    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

	    UserServiceImpl userManager = (UserServiceImpl) ctx.getBean("userServiceImpl");

	    boolean login = userManager.login("Guille", "12345678");
	    if(login)
	    	System.out.println("Guille se logueo");
	    else
	    	System.out.println("Guille NO SE LOGUEO");
	    
	    List<User> users = userManager.getAllUsers();
	    
	    System.out.println(users.size());
    	   
    }
}
