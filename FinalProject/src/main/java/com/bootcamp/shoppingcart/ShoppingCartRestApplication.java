package com.bootcamp.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class ShoppingCartRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartRestApplication.class, args);
    }
}