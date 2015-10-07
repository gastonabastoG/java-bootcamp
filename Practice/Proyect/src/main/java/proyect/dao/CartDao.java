package proyect.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import proyect.model.Cart;
import proyect.repositories.ICartRepository;

@Component
public class CartDao {

	@Autowired
	ICartRepository cartRepository;

	@Transactional
	public void save(Cart cartAux) {
		cartRepository.save(cartAux);

	}

}
