package com.point4;

import java.util.List;
import java.util.Set;

/**
 * 
 * UserService API
 *
 */

public interface UserService {

	/**
	 * Add a user to the database
	 * 
	 * @param user
	 *            instance of User class
	 */
	public void addUser(User user);

	/**
	 * Remove a user from the database
	 * 
	 * @param userId
	 */
	public void deleteUser(int userId);

	/**
	 * Get a user from the database by user's id
	 * @param userId
	 * @return instance of User
	 */
	public User getUser(int userId);

	/**
	 * Replaces the old user data by new
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * Get all users from the database
	 * @return Set Collection of User
	 */
	public Set<User> getUsers();

	/**
	 * Users are added to both lists of friends
	 * @param userId1
	 * @param userId2
	 */
	public void makeFriends(int userId1, int userId2);

	/**
	 * Users are deleted to both lists of friends
	 * @param userId1
	 * @param userId2
	 */
	public void unMakeFriends(int userId1, int userId2);

	/**
	 * Add photo to the database
	 * @param photo
	 */
	public void addPhoto(Photo photo);

	/**
	 * Remove photo to the database
	 * @param photo
	 */
	public void deletePhoto(Photo photo);

	/**
	 * Get all photos from a user
	 * @param userId
	 * @return
	 */
	public List<Photo> getUserPhotos(int userId);

	/**
	 * Add like to a photo
	 * @param userId user that make like
	 * @param photo
	 */
	public void like(int userId, Photo photo);

	/**
	 * Remove like to a photo
	 * @param userId user that removes his like
	 * @param photo
	 */
	public void unLike(int userId, Photo photo);

}
