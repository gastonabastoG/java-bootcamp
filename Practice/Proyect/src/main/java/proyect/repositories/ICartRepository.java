package proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import proyect.model.Cart;

public interface ICartRepository extends JpaRepository<Cart, Long> {

}
