package com.point4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class UserServiceTest {

	@After
	public void clearDB() {
		Database.getInstance().clear();
	}

	@Test
	public void testAddAndDeleteUser() {
		UserService userService = UserServiceFactory.getLocalService();
		User user = new User(1,"guille", "123456");
		userService.addUser(user);
		assertEquals(user, userService.getUser(1));
		userService.deleteUser(1);
		assertEquals(null, userService.getUser(1));
	}

	@Test
	public void testMakeAndUnMakeFriends() {
		UserService userService = UserServiceFactory.getLocalService();
		User user1 = new User(1,"guille", "123456");
		User user2 = new User(2,"gaston", "654321");
		userService.addUser(user1);
		userService.addUser(user2);
		userService.makeFriends(1, 2);
		assertEquals(true, user1.isFriend(user2));
		assertEquals(true, user2.isFriend(user1));
		userService.unMakeFriends(1, 2);
		assertEquals(false, user1.isFriend(user2));
		assertEquals(false, user2.isFriend(user1));
	}

	@Test
	public void testUpdates() {
		UserService userService = UserServiceFactory.getLocalService();
		User user = new User(1,"guille", "123456");
		userService.addUser(user);
		user.setPassword("new password");
		userService.updateUser(user);
		assertEquals("new password", userService.getUser(1).getPassword());
	}

	@Test
	public void testAddAndDeletePhoto() {
		UserService userService = UserServiceFactory.getLocalService();
		User user = new User(1,"guille", "123456");
		userService.addUser(user);
		Photo photo = new Photo(user, "path");
		userService.addPhoto(photo);
		assertEquals(true, userService.getUserPhotos(1).contains(photo));
		userService.deletePhoto(photo);
		assertEquals(false, userService.getUserPhotos(1).contains(photo));
	}

	@Test
	public void testLikes() {
		UserService userService = UserServiceFactory.getLocalService();
		User user1 = new User(1,"guille", "123456");
		User user2 = new User(2,"gaston", "654321");
		userService.addUser(user1);
		userService.addUser(user2);
		Photo photo = new Photo(user1, "path");
		userService.addPhoto(photo);
		userService.like(2, photo);
		assertEquals(true, photo.getLikes().contains(user2));
		userService.unLike(2, photo);
		assertEquals(false, photo.getLikes().contains(user2));
	}

}
