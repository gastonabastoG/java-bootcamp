package proyect.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import proyect.model.Account;
import proyect.repositories.IAccountRepository;

@Component
public class AccountDao {

	@Autowired
	IAccountRepository accountRepository;

	@Transactional
	public Account findOne(String username) {
		return accountRepository.findOne(username);
	}

	@Transactional
	public String save(Account account) {
		try {
			accountRepository.save(account);
			return "ACCOUNT WAS REGISTERED";
		} catch (Exception e) {
			return "ACCOUNT WAS NOT REGISTERED";
		}
	}

	@Transactional
	public Account updateMap(Account account) {
		return accountRepository.findOne(account.getUsername());
	}

}
