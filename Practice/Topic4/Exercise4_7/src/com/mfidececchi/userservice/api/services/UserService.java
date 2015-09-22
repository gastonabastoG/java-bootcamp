package com.mfidececchi.userservice.api.services;

import com.mfidececchi.userservice.api.db.Database;
import com.mfidececchi.userservice.api.entities.Photo;
import com.mfidececchi.userservice.api.entities.User;

public class UserService implements IUserService {

	private static UserService userService;
	private Database db;

	private UserService() {
		db = Database.getInstance();
	}

	public static UserService getInstance() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	@Override
	public boolean addUser(User user) {
		return db.addUser(user);
	}

	@Override
	public User getUser(String nickName) {
		return db.getUser(nickName);
	}

	@Override
	public boolean updateUser(User user) {
		return db.updateUser(user);
	}

	@Override
	public boolean removeUser(User user) {
		return db.removeUser(user);

	}

	@Override
	public boolean removeUser(String nickName) {
		User user = db.getUser(nickName);
		if (user != null) {
			return db.removeUser(user);
		} else {
			return false;
		}

	}

	@Override
	public boolean addPhoto(User user, Photo photo) {
		return db.addPhoto(user, photo);
	}

	@Override
	public boolean addFriend(User user, User friend) {
		return db.addFriend(user, friend);

	}

	@Override
	public boolean like(User userDoesLike, User userLiked, Photo photoLiked) {
		return db.like(userDoesLike, userLiked, photoLiked);

	}

	@Override
	public boolean removeLike(User userDoesLike, User userLiked, Photo photo) {
		return db.unLike(userDoesLike, userLiked, photo);
	}

	public void resetDB() {
		db.resetDB();
	}

}
