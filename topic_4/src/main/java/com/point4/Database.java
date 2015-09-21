package com.point4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Database {

	private final Map<Integer, User> users;
	private final Map<Integer, List<Photo>> photos;
	private static Database database = null;

	private Database() {
		users = new HashMap<Integer,User>();
		photos = new HashMap<Integer, List<Photo>>();
	}

	public static Database getInstance() {
		Database db = database;
		if (db == null){
			synchronized(Database.class){
				db = database;
				if (db == null){
					db = new Database();
					database = db;
				}
			}
		}
		return database;
	}

	public void addUser(User user) {
		users.put(user.getUserId(),user);
	}

	public User getUser(int userId) {
		if (users.containsKey(userId))
			return users.get(userId);
		return null;
	}

	public void deleteUser(int userId) {
		photos.remove(userId); // remove all user's photos first
		users.remove(userId); // delete user from db
	}

	public void makeFriends(int userId1, int userId2) {
		User u1 = users.get(userId1);
		User u2 = users.get(userId2);
		u1.addFriend(u2);
		u2.addFriend(u1);
	}

	public void unMakeFriends(int userId1, int userId2) {
		User u1 = users.get(userId1);
		User u2 = users.get(userId2);
		u1.deleteFriend(u2);
		u2.deleteFriend(u1);
	}

	public void updateUser(User user) {
		users.remove(user.getUserId()); // equals is true when userNames are the same
		addUser(user); // add the user with the new password e.g
	}

	public void addPhoto(Photo photo) {
		List<Photo> userPhotos = photos.get(photo.getOwner().getUserId());
		if (userPhotos != null)
			userPhotos.add(photo);
		else {
			userPhotos = new ArrayList<Photo>();
			userPhotos.add(photo);
			photos.put(photo.getOwner().getUserId(), userPhotos);
		}
	}

	public void deletePhoto(Photo photo) {
		photos.get(photo.getOwner().getUserId()).remove(photo);
	}

	public void like(int userId, Photo photo) {
		photo.like(users.get(userId));
	}

	public void unLike(int userId, Photo photo) {
		photo.unLike(users.get(userId));
	}

	public List<Photo> getUserPhotos(int userId) {
		return photos.get(userId);
	}

	public void clear() {
		users.clear();
		photos.clear();
	}

	public Set<User> getUsers() {
		Set<User> u = new HashSet<User>();
		for (int i : users.keySet())
			u.add(users.get(i));
		return u;
	}

}
