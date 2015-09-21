package com.point4;

import java.util.ArrayList;
import java.util.List;

public class Photo {

	private final User owner;
	private final String path;
	private final List<User> likes;

	public Photo(User owner, String path) {
		this.owner = owner;
		this.path = path;
		likes = new ArrayList<User>();
	}

	public User getOwner() {
		return owner;
	}

	public String getPath() {
		return path;
	}

	public List<User> getLikes() {
		return likes;
	}
	
	public void like(User user){
		likes.add(user);
	}
	
	public void unLike(User user){
		likes.remove(user);
	}
	
	public int likesCount(){
		return likes.size();
	}
	
	public boolean equals(Photo otherPhoto){
		return path.equals(otherPhoto.getPath());
	}

}
