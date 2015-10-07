package proyect.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import proyect.model.LineItem;
import proyect.repositories.ILineItemRepository;

@Component
public class LineItemDao {

	@Autowired
	ILineItemRepository lineItemRepository;

	@Transactional
	public void save(LineItem line) {
		lineItemRepository.save(line);
	}

	@Transactional
	public String remove(LineItem line) {
		if (lineItemRepository.findOne(line.getId()) != null) {
			lineItemRepository.delete(line.getId());
			return "THE ITEM ID: " + line.getItem().getId() + " WAS REMOVED FROM CART " + line.getCart().getId();
		} else {
			return "THE LINE DOES NOT EXIST IN CART";
		}

	}

}
