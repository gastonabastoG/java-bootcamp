package com.point4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class DatabaseTest {

	@After
	public void clearDB() {
		Database.getInstance().clear();
	}

	@Test
	public void testAddUser() {
		User user = new User(1,"guille", "123456");
		Database.getInstance().addUser(user);
		assertEquals(user, Database.getInstance().getUser(1));
	}

	@Test
	public void testDeleteUser() {
		User user = new User(1,"guille", "123456");
		Database.getInstance().addUser(user);
		assertEquals(user, Database.getInstance().getUser(1));
		Database.getInstance().deleteUser(1);
		assertEquals(null, Database.getInstance().getUser(1));
	}

	@Test
	public void testMakeAndUnMakeFriends() {
		User user1 = new User(1,"guille", "123456");
		User user2 = new User(2,"gaston", "654321");
		Database.getInstance().addUser(user1);
		Database.getInstance().addUser(user2);
		Database.getInstance().makeFriends(1, 2);
		assertEquals(true, user1.isFriend(user2));
		assertEquals(true, user2.isFriend(user1));
		Database.getInstance().unMakeFriends(1, 2);
		assertEquals(false, user1.isFriend(user2));
		assertEquals(false, user2.isFriend(user1));
	}

	@Test
	public void testUpdates() {
		User user = new User(1,"guille", "123456");
		Database.getInstance().addUser(user);
		user.setPassword("new password");
		Database.getInstance().updateUser(user);
		assertEquals("new password", Database.getInstance().getUser(1).getPassword());
	}

	@Test
	public void testAddAndDeletePhoto() {
		User user = new User(1,"guille", "123456");
		Database.getInstance().addUser(user);
		Photo photo = new Photo(user, "path");
		Database.getInstance().addPhoto(photo);
		assertEquals(true, Database.getInstance().getUserPhotos(1).contains(photo));
		Database.getInstance().deletePhoto(photo);
		assertEquals(false, Database.getInstance().getUserPhotos(1).contains(photo));
	}

	@Test
	public void testLikes() {
		User user1 = new User(1,"guille", "123456");
		User user2 = new User(2,"gaston", "654321");
		Database.getInstance().addUser(user1);
		Database.getInstance().addUser(user2);
		Photo photo = new Photo(user1, "path");
		Database.getInstance().addPhoto(photo);
		Database.getInstance().like(2, photo);
		assertEquals(true, photo.getLikes().contains(user2));
		Database.getInstance().unLike(2, photo);
		assertEquals(false, photo.getLikes().contains(user2));
	}
}
