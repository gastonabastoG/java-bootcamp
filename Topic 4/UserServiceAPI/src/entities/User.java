package entities;

import java.util.HashMap;
import java.util.Map;

public class User {
	
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	
	private Map<String, User> friendList; //Map  that stores this user's friends
	private Map<String, Photo> userPhotos; //Map that stores this user's photos
	
	public User(String username, String firstName, String lastName, String password) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.friendList = new HashMap<String, User>();
		this.userPhotos = new HashMap<String, Photo>();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addFriend(User friend) {
		this.friendList.put(friend.getUsername(),friend);
	}
	public void addPhoto(Photo photo) {
		this.userPhotos.put(photo.getName(),photo);
	}
	public Photo getPhoto(Photo photo) {
		return this.userPhotos.get(photo.getName());
	}
	public Map<String, User> getFriends() {
		return this.friendList;
	}
	
	

}
