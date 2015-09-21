package com.point4;

public class UserServiceFactory {

	private UserServiceFactory() {
	}

	public static UserService getLocalService() {
		return new UserServiceImp();
	}
}
