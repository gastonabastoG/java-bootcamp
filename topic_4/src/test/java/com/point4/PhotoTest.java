package com.point4;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhotoTest {

	@Test
	public void setUp() {
		User user = new User(1,"guille", "123456");
		Photo photo = new Photo(user, "samplePath");
		assertEquals(user, photo.getOwner());
		assertEquals("samplePath", photo.getPath());
	}

	@Test
	public void testLikesCount() {
		User user1 = new User(1,"guille", "123456");
		Photo photo = new Photo(user1, "samplePath");
		User user2 = new User(2,"gaston", "654321");
		User user3 = new User(3,"lucas", "peter");
		photo.like(user2);
		photo.like(user3);
		assertEquals(2, photo.likesCount());
		photo.unLike(user3);
		assertEquals(1, photo.likesCount());
	}

}
