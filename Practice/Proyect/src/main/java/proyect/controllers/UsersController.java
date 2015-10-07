package proyect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proyect.dao.AccountDao;
import proyect.model.Account;
import proyect.model.User;

@RestController
@RequestMapping(path = "/users")
class UsersController {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	HttpSession httpSession;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<String> register(@RequestBody User user) {

		// if there is a session opened
		if ((Account) httpSession.getAttribute("accountSession") != null) {
			return new ResponseEntity<String>("PLEASE LOGOUT, FOR TO REGISTER A NEW USER",
					HttpStatus.OK);
		} else {
			// if there is'nt a session opened then..
			Account accountFound = accountDao.findOne(user.getAccount().getUsername());
			// the username provided already exists
			if (accountFound != null) {
				return new ResponseEntity<String>("THE USERNAME ALREADY EXISTS", HttpStatus.OK);
			} else {
				// trying to register the user..
				String message = accountDao.save(user.getAccount());
				return new ResponseEntity<String>(message, HttpStatus.OK);
			}

		}
	}

}
