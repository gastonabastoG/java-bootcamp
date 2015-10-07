package proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import proyect.model.Item;

public interface I_ItemRepository extends JpaRepository<Item, Long> {

}
