package services;

import java.util.HashMap;
import java.util.Map;

import entities.Photo;
import entities.User;

public class UserServiceImp implements UserService {
	//Tried using Map this time to make it easier to get
	//an item from the list
	private static Map<String,User> userList = new HashMap<String, User>();

	@Override
	public void createUser(String username, String firstName, String lastName, String password) {
		if (userList.containsKey(username)) {
			//Prevents duplicated users
			System.out.println("This user already exists.");
		}
		else {
			User user = new User(username, firstName, lastName, password);
			userList.put(username, user);	
		}
	}

	@Override
	public User getUserByUsername(String username) {
		return userList.get(username);
		//Other methods use this method to get an item from
		//the users list
	}
	

	@Override
	public void updateUser(String username, String firstName, String lastName, String password) {
		User user = getUserByUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
	}

	@Override
	public void removeUser(String username) {
		userList.remove(username);
	}

	@Override
	public void uploadPhoto(String username, Photo photo) {
		getUserByUsername(username).addPhoto(photo);
	}

	@Override
	public void addFriend(String activeUser, String friendToAdd) {
		//This method receives the user who is adding a friend (activeuser)
		//and the friend to add, and adds him to the activeuser friend list
		getUserByUsername(activeUser).addFriend(getUserByUsername(friendToAdd));
	}

	@Override
	public void giveLike(String userWhoLikes, String userLiked, Photo photo) {
		// This method gets the user who liked the photo
		//and the "receiver" of that like, and the photo itself
		//then adds the user who liked it to the photo's like list
		getUserByUsername(userLiked).getPhoto(photo).addLike(getUserByUsername(userWhoLikes));
	}
	
	@Override
	public void removeLike(String userWhoLikes, String userLiked, Photo photo) {
		//Same as giveLike but removes the user from the like list
		getUserByUsername(userLiked).getPhoto(photo).removeLike(getUserByUsername(userWhoLikes));
	}

}
