package proyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import proyect.model.LineItem;

public interface ILineItemRepository extends JpaRepository<LineItem, Long> {

}
