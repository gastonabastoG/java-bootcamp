package com.point4;

import java.util.List;
import java.util.Set;

public class UserServiceImp implements UserService {
	
	public void addUser(User user) {
		Database.getInstance().addUser(user);
	}

	public void deleteUser(int userId) {
		Database.getInstance().deleteUser(userId);
	}

	public User getUser(int userID) {
		return Database.getInstance().getUser(userID);
	}

	public void updateUser(User user) {
		Database.getInstance().updateUser(user);
	}

	public Set<User> getUsers() {
		return Database.getInstance().getUsers();
	}

	public void makeFriends(int userId1, int userId2) {
		Database.getInstance().makeFriends(userId1, userId2);
	}

	public void unMakeFriends(int userId1, int userId2) {
		Database.getInstance().unMakeFriends(userId1, userId2);
	}

	public void addPhoto(Photo photo) {
		Database.getInstance().addPhoto(photo);
	}

	public void deletePhoto(Photo photo) {
		Database.getInstance().deletePhoto(photo);
	}

	public List<Photo> getUserPhotos(int userId) {
		return Database.getInstance().getUserPhotos(userId);
	}

	public void like(int userId, Photo photo) {
		Database.getInstance().like(userId, photo);
	}

	public void unLike(int userId, Photo photo) {
		Database.getInstance().unLike(userId, photo);
	}

}
