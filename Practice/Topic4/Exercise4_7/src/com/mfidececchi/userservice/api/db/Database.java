package com.mfidececchi.userservice.api.db;

import java.util.HashMap;
import java.util.Map;

import com.mfidececchi.userservice.api.entities.Photo;
import com.mfidececchi.userservice.api.entities.User;

public class Database {

	private static Database database;
	private Map<String, User> users;
	private Map<String, Photo> photos;

	private Database() {
		users = new HashMap<String, User>();
		photos = new HashMap<String, Photo>();
	}

	public static Database getInstance() {
		if (database == null) {
			database = new Database();
		}
		return database;
	}

	public Map<String, User> getAllUsers() {
		return users;
	}

	public Map<String, Photo> getAllPhotos() {
		return photos;
	}

	public boolean addUser(User user) {
		if (users.containsKey(user.getNickName())) {
			return false;
		} else {
			users.put(user.getNickName(), user);
			return true;
		}
	}

	public User getUser(String nickName) {
		return users.get(nickName);
	}

	public boolean updateUser(User user) {
		if (users.replace(user.getNickName(), user) != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean removeUser(User user) {
		return users.remove(user.getNickName(), user);
	}

	public boolean addPhoto(User user, Photo photo) {
		User u = users.get(user.getNickName());
		if (u != null && !photos.containsKey(photo.getLink())) {
			photos.put(photo.getLink(), photo);
			u.addPhoto(photo);
			return true;
		} else {
			return false;
		}
	}

	public boolean addFriend(User user, User friend) {
		User u = users.get(user.getNickName());
		User f = users.get(friend.getNickName());
		if (u != null && f != null && u != f) {
			u.addFriend(f);
			f.addFriend(u);
			return true;
		} else {
			return false;
		}
	}

	public boolean like(User userDoesLike, User userLiked, Photo photoLiked) {
		User userDoes = users.get(userDoesLike.getNickName());
		User owner = users.get(userLiked.getNickName());
		if (userDoes != null && owner != null) {
			if (owner.getPhoto(photoLiked) != null) {
				photoLiked.like(userDoes);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean unLike(User userDoesLike, User userLiked, Photo photo) {
		User userDoes = users.get(userDoesLike.getNickName());
		User owner = users.get(userLiked.getNickName());
		if (userDoes != null && owner != null) {
			if (owner.getPhoto(photo) != null && photo.getLikes().get(userDoesLike.getNickName()) != null) {
				photo.unLike(userDoes);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void resetDB() {
		users.clear();
		photos.clear();
	}

}
