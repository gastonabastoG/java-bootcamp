package proyect.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import proyect.model.Item;
import proyect.repositories.I_ItemRepository;

@Component
public class ItemDao {

	@Autowired
	I_ItemRepository itemRepository;

	public Item findOne(long itemId) {
		return itemRepository.findOne(itemId);
	}

	public List<Item> findByItemName(String s_name) {

		List<Item> allItems = itemRepository.findAll();
		List<Item> itemsOk = new ArrayList<Item>();
		for (Item i : allItems) {
			if (i.getName().toLowerCase().contains(s_name.toLowerCase())) {
				itemsOk.add(i);
			}
		}
		return itemsOk;
	}

	public List<Item> findByItemCategory(String s_category) {
		List<Item> allItems = itemRepository.findAll();
		List<Item> itemsOk = new ArrayList<Item>();
		for (Item i : allItems) {
			if (i.getCategory().getName().toLowerCase().contains(s_category.toLowerCase())) {
				itemsOk.add(i);
			}
		}
		return itemsOk;
	}

}
