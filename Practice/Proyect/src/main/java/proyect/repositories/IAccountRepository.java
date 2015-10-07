package proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import proyect.model.Account;

public interface IAccountRepository extends JpaRepository<Account, String> {

}
