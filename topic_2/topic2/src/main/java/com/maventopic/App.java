package com.maventopic;

import java.util.Scanner;
import org.apache.commons.math3.RealFieldElement;
import com.ning.http.client.listener.TransferCompletionHandler;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		String entry = sc.nextLine();
		System.out.println("Hello " + entry);
		
		// dependencies uses examples		
		RealFieldElement<Float> f;
		TransferCompletionHandler handler = new TransferCompletionHandler();
		
		sc.close();
	}
}
