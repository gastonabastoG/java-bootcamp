package com.leap92.bootcamp;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Escriba su nombre:");
    	
    	if (System.console() == null) {
    	      Scanner sc = new Scanner(System.in);
    	      System.out.println("Hola " + sc.next());
    	      sc.close();
    	     } else {
    	      String input = System.console().readLine();
    	      System.out.println("Hola " + input);
    	     }
    }
}
