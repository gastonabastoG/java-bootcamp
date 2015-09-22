package com.mfidececchi.userservice.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mfidececchi.userservice.api.entities.Photo;
import com.mfidececchi.userservice.api.entities.User;
import com.mfidececchi.userservice.api.services.UserService;

public class UserServiceTest {

	UserService us = UserService.getInstance();;
	User u1, u2, u3, u4, u5;
	Photo p1, p2, p3;

	@Before
	public void setUp() {
		us.resetDB();
		u1 = new User("papo", "123456");
		u2 = new User("pepo", "234567");
		u3 = new User("pipo", "345678");
		u4 = new User("pupo", "456789");
		p1 = new Photo("Selfie1", "https://photos.com/p1");
		p2 = new Photo("Selfie1", "https://photos.com/p2");
		p3 = new Photo("Selfie1", "https://photos.com/p3");
	}

	@Test
	public void addUserTest() {
		// adds user1
		assertEquals(true, us.addUser(u1));
		// user1 is already exists
		assertEquals(false, us.addUser(u1));
		// adds user2
		assertEquals(true, us.addUser(u2));
	}

	@Test
	public void getUserTest() {
		// user2 does not exist
		assertEquals(null, us.getUser(u2.getNickName()));
		// user1 does not exist
		assertEquals(null, us.getUser(u1.getNickName()));
		// user1 exists
		us.addUser(u1);
		assertEquals(u1, us.getUser(u1.getNickName()));

	}

	@Test
	public void updateUser() {
		// user3 does not exist
		assertEquals(false, us.updateUser(u3));
		// add user3 to pseudo database
		us.addUser(u3);
		// change field on user3 object
		u3.setPassword("qweasd");
		// update user3 on database
		assertEquals(true, us.updateUser(u3));
	}

	@Test
	public void removeUserTest1() {

		// user4 does not exist
		assertEquals(false, us.removeUser(u4));
		// adds user4
		us.addUser(u4);
		// remove user4
		assertEquals(true, us.removeUser(u4));
		// user4 does not exist-
		assertEquals(false, us.removeUser(u4));
	}

	@Test
	public void removeUserTest2() {

		// user4 does not exist
		assertEquals(false, us.removeUser(u4.getNickName()));
		// adds user4
		us.addUser(u4);
		// remove user4
		assertEquals(true, us.removeUser(u4.getNickName()));
		// user4 does not exist
		assertEquals(false, us.removeUser(u4.getNickName()));
	}

	@Test
	public void addPhoto() {
		// user1 does not exist
		assertEquals(false, us.addPhoto(u1, p1));
		// adds user
		us.addUser(u1);
		// user1 adds a photo1
		assertEquals(true, us.addPhoto(u1, p1));
		// the photo1 is already exist on user1
		assertEquals(false, us.addPhoto(u1, p1));

	}

	@Test
	public void addFriend() {
		// user1 and user2 do not exist.
		assertEquals(false, us.addFriend(u1, u2));

		// user2 does not exist.
		us.addUser(u1);
		assertEquals(false, us.addFriend(u1, u2));

		// user1 and user2 exist.
		us.addUser(u2);
		assertEquals(true, us.addFriend(u1, u2));

		// user1 can't set friend yourself.
		assertEquals(false, us.addFriend(u1, u1));
	}

	@Test
	public void like() {

		// user1 , user2 and photo1 do not exist.
		assertEquals(false, us.like(u1, u2, p1));

		// user2 and photo1 does not exist.
		us.addUser(u1);
		assertEquals(false, us.like(u1, u2, p1));

		// user1 and user2 exist but photo1 does not exist.
		us.addUser(u2);
		assertEquals(false, us.like(u1, u2, p1));

		// user2 like photo of user1
		us.addPhoto(u1, p1);
		assertEquals(true, us.like(u2, u1, p1));

	}

	@Test
	public void removeLike() {

		// user1 , user2 and photo1 do not exist.
		assertEquals(false, us.removeLike(u1, u2, p1));

		// user2 and photo1 does not exist.
		us.addUser(u1);
		assertEquals(false, us.removeLike(u1, u2, p1));

		// user1 and user2 exist but photo1 does not exist.
		us.addUser(u2);
		assertEquals(false, us.removeLike(u1, u2, p1));

		// user1 adds photo1
		us.addPhoto(u1, p1);

		// user2 unlike photo of user1 but the photo is not liked.
		assertEquals(false, us.removeLike(u2, u1, p1));

		// user2 like photo1 of user1
		us.like(u2, u1, p1);

		// user2 unlike photo of user1
		assertEquals(true, us.removeLike(u2, u1, p1));

	}

}
