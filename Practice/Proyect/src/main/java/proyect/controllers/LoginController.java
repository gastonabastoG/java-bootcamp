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

@RestController
class LoginController {

	@Autowired
	AccountDao accountDao;
	@Autowired
	HttpSession httpSession;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<String> login(@RequestBody Account account) {

		// if there is a session opened
		if ((Account) httpSession.getAttribute("accountSession") != null) {
			return new ResponseEntity<String>("PLEASE LOGOUT THE CURRENT SESSION", HttpStatus.OK);
		} else {
			// there is'nt a session opened
			Account accountFound = accountDao.findOne(account.getUsername());
			// if the provided account exists and the password is correct
			if (accountFound != null && accountFound.getPassword().equals(account.getPassword())) {
				// open session
				httpSession.setAttribute("accountSession", accountFound);
				return new ResponseEntity<String>("LOGGED", HttpStatus.OK);
			} else {
				// the provided account not exists or the password is wrong
				httpSession.setAttribute("accountSession", null);
				return new ResponseEntity<String>("THE USER NOT EXISTS OR WRONG PASSWORD", HttpStatus.OK);
			}
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	ResponseEntity<String> logout() {

		// if there is'nt a session opened
		if ((Account) httpSession.getAttribute("accountSession") == null) {
			return new ResponseEntity<String>("THERE IS'NT A SESSION OPENED", HttpStatus.OK);
		} else {
			// close session
			httpSession.setAttribute("accountSession", null);
			return new ResponseEntity<String>("SESSION CLOSED", HttpStatus.OK);
		}
	}

}
