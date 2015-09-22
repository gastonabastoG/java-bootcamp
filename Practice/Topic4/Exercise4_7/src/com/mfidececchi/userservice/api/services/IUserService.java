package com.mfidececchi.userservice.api.services;

import com.mfidececchi.userservice.api.entities.Photo;
import com.mfidececchi.userservice.api.entities.User;

public interface IUserService {

	public boolean addUser(User user);

	public User getUser(String nickName);

	public boolean updateUser(User user);

	public boolean removeUser(User user);

	// Overload removeUser
	public boolean removeUser(String nickName);

	public boolean addPhoto(User user, Photo photo);

	public boolean addFriend(User user, User friend);

	public boolean like(User userDoesLike, User userLiked, Photo photoLiked);

	public boolean removeLike(User userDoesLike, User userLiked, Photo photo);

}
