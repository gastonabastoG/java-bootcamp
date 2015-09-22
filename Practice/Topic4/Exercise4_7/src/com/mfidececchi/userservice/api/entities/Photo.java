package com.mfidececchi.userservice.api.entities;

import java.util.HashMap;
import java.util.Map;

public class Photo {

	private String link;
	private String name;
	private Map<String, User> likes;

	public Photo(String name, String link) {
		this.name = name;
		this.link = link;
		this.likes = new HashMap<String, User>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void like(User user) {
		this.likes.put(user.getNickName(), user);
	}

	public void unLike(User user) {
		this.likes.remove(user.getNickName());
	}

	public Map<String, User> getLikes() {

		return this.likes;

	}

}
