package proyect.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import proyect.dao.ItemDao;
import proyect.model.Item;

@RestController
@RequestMapping(path = "/search")
class ItemController {

	@Autowired
	ItemDao itemDao;

	@Autowired
	HttpSession httpSession;

	@RequestMapping(value = "/itemsByName/{s_name}", method = RequestMethod.GET)
	ResponseEntity<List<Item>> itemsByName(@PathVariable String s_name) {
		// find Item
		List<Item> items = itemDao.findByItemName(s_name);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/itemsByCategory/{s_category}", method = RequestMethod.GET)
	ResponseEntity<List<Item>> itemsByCategory(@PathVariable String s_category) {
		// find Item
		List<Item> items = itemDao.findByItemCategory(s_category);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
}
