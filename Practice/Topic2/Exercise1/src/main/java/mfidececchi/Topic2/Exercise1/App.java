package mfidececchi.Topic2.Exercise1;

import java.util.Scanner;

//Hello world!
public class App {
	public static void main(String[] args) {
		System.out.println("Enter name:");
		String name;
		Scanner scanIn = new Scanner(System.in);
		name = scanIn.nextLine();
		scanIn.close();
		System.out.println("Hello " + name + "!!");
	}
}
