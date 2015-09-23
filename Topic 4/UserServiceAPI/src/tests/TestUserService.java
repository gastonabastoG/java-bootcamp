package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Photo;
import services.UserService;
import services.UserServiceImp;

public class TestUserService {

	@Test
	public void addAUser() {
		UserService userService = new UserServiceImp();
		userService.createUser("fer223", "Baul", "Saratti", "grappamiel");
		
		assertEquals("Saratti", userService.getUserByUsername("fer223").getLastName());
		
	}
	
	@Test
	public void removeAUser() {
		UserService userService = new UserServiceImp();
		userService.createUser("leap92", "Leandro", "Pross", "lala");
		
		userService.removeUser("leap92");
		
		assertEquals(null,userService.getUserByUsername("leap92"));
	}
	
	@Test
	public void updateAUser() {
		UserService userService = new UserServiceImp();
		userService.createUser("roman123", "Roman", "Schiavon", "ladron");
		
		userService.updateUser("roman123", "Saul", "Laverni", "123");
		
		assertEquals("Saul", userService.getUserByUsername("roman123").getFirstName());
		
	}
	
	@Test
	public void addAPhoto() {
		UserService userService = new UserServiceImp();
		Photo photo = new Photo("asd123", "jpg");
		userService.uploadPhoto("roman123", photo);
		
		assertEquals(photo.getName(), userService.getUserByUsername("roman123").getPhoto(photo).getName());
	}
	
	@Test public void addAndRemoveLike() {
		
		UserService userService = new UserServiceImp();
		userService.createUser("jmd", "Juan", "Del Valle", "inc");
		userService.createUser("tito", "Ernesto", "Max", "cpl");
		
		Photo photo = new Photo("laverni", "png");
		userService.uploadPhoto("jmd", photo);
		
		userService.giveLike("tito", "jmd", photo);
		
		assertEquals("tito", userService.getUserByUsername("jmd").
				getPhoto(photo).getLikes().get("tito").getUsername());
		
		userService.removeLike("tito", "jmd", photo);
		
		assertEquals(null, userService.getUserByUsername("jmd").
				getPhoto(photo).getLikes().get("tito"));
		
	}
	
	@Test
	public void addFriend() {
		UserService userService = new UserServiceImp();
		userService.addFriend("tito", "jmd");
		
		assertEquals("jmd", userService.getUserByUsername("tito").getFriends().get("jmd").getUsername());
	}

}
