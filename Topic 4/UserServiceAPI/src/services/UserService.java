package services;

import entities.Photo;
import entities.User;

public interface UserService {
	
	public void createUser(String username, String firstName, 
			String lastName, String password);
	
	public User getUserByUsername(String username);
	
	public void updateUser(String username, String firstName,
			String lastName, String password);
	
	public void removeUser(String username);
	
	public void uploadPhoto(String username, Photo photo);
	
	public void addFriend(String activeUsername, String friendToAddUsername);
	
	public void giveLike(String userWhoLikes, String userLiked, Photo photo);

	public void removeLike(String userWhoLikes, String userLiked, Photo photo);

}
