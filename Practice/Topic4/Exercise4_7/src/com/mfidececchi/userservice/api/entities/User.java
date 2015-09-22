package com.mfidececchi.userservice.api.entities;

import java.util.HashMap;
import java.util.Map;

public class User {

	private String nickName; // nickname of user
	private String pass; // password of user
	private Map<String, Photo> photos; // user's photos
	private Map<String, User> friends; // user's friends

	// constructor
	public User(String nickName, String pass) {
		this.nickName = nickName;
		this.pass = pass;
		this.friends = new HashMap<String, User>();
		this.photos = new HashMap<String, Photo>();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}

	// adds a new friend to friends list
	public void addFriend(User friend) {
		this.friends.put(friend.getNickName(), friend);
	}

	// adds a new photo to photos list
	public void addPhoto(Photo photo) {
		this.photos.put(photo.getLink(), photo);
	}

	public Photo getPhoto(Photo photo) {
		return this.photos.get(photo.getLink());
	}

	public Map<String, User> getFriends() {
		return this.friends;
	}

}
