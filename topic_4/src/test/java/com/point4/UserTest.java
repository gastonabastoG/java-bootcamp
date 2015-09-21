package com.point4;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void setUp() {
		User user = new User(1,"guille", "123456");
		assertEquals("guille", user.getUserName());
		assertEquals("123456", user.getPassword());
	}
	
	@Test
	public void testUserNameChange() {
		User user = new User(1,"guille", "123456");
		user.setUserName("guillermo");
		assertEquals("guillermo", user.getUserName());
	}

	@Test
	public void testPasswordChange() {
		User user = new User(1,"guille", "123456");
		user.setPassword("1234");
		assertEquals("1234", user.getPassword());
	}
	
	@Test
	public void testAddFriend(){
		User user1 = new User(1,"guille", "123456");
		User user2 = new User(2,"gaston", "654321");
		user1.addFriend(user2);
		assertEquals(true, user1.isFriend(user2));
	}
	
	@Test
	public void testDeleteFriend(){
		User user1 = new User(1,"guille", "123456");
		User user2 = new User(2,"gaston", "654321");
		user1.addFriend(user2);
		assertEquals(true, user1.isFriend(user2));
		user1.deleteFriend(user2);
		assertEquals(false, user1.isFriend(user2));
	}

}
