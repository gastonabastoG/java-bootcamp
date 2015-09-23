package entities;

import java.util.concurrent.atomic.AtomicInteger;

public class IntIDGenerator {
	
	private static final AtomicInteger count = new AtomicInteger(1); //Counter starts from 1
	
	private IntIDGenerator() {};
	
	public static int generateId() {
		return count.getAndIncrement();
	}
	

}
