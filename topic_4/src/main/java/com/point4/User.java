package com.point4;

import java.util.HashSet;
import java.util.Set;

public class User {

	private final int userId;
	private String userName;
	private String password;
	private final Set<User> friends;

	public User(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		friends = new HashSet<User>();
	}
	
	public int getUserId(){
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public Set<User> getFriends() {
		return friends;
	}
	
	public void addFriend(User friend){
		friends.add(friend);
	}
	
	public void deleteFriend(User friend){
		if (isFriend(friend))
			friends.remove(friend);
	}
	
	public boolean isFriend(User user){
		return friends.contains(user);
	}
	
	public boolean equals(User otherUser){
		return userId == otherUser.getUserId();
	}

}
