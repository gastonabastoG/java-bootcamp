package proyect.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyect.dao.AccountDao;
import proyect.dao.CartDao;
import proyect.dao.ItemDao;
import proyect.dao.LineItemDao;
import proyect.model.Account;
import proyect.model.Cart;
import proyect.model.Item;
import proyect.model.LineItem;

@RestController
@RequestMapping(path = "/cart")
class CartController {

	@Autowired
	AccountDao accountDao;

	@Autowired
	CartDao cartDao;

	@Autowired
	LineItemDao lineItemDao;

	@Autowired
	ItemDao itemDao;

	@Autowired
	HttpSession httpSession;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	ResponseEntity<String> addItemToCart(@RequestParam long item_id, @RequestParam int quantity) {

		Account accountAux = (Account) httpSession.getAttribute("accountSession");
		// if there is'nt a session opened
		if (accountAux == null) {
			return new ResponseEntity<String>("PLEASE LOGIN", HttpStatus.OK);
		} else {
			// if there is a session opened
			accountAux = (Account) httpSession.getAttribute("accountSession");
			// update mapping of account
			accountAux = accountDao.updateMap(accountAux);
			// find Item
			Item itemAux = itemDao.findOne(item_id);

			if (itemAux == null) {
				return new ResponseEntity<String>("THE ITEM ID: " + item_id + " NOT EXISTS", HttpStatus.OK);
			} else {
				// if item was found
				// Find opened cart of user
				Cart cartAux = accountAux.getUser().getOpenCart();

				if (cartAux != null) {
					LineItem line = cartAux.getLineByItemId(item_id);
					if (line != null) {
						return new ResponseEntity<String>("THE ITEM ID: " + item_id + " ALREADY EXISTS IN CART",
								HttpStatus.OK);
					} else {

						line = new LineItem(cartAux, itemAux, quantity);
						// save the lineItem into the database
						lineItemDao.save(line);
						return new ResponseEntity<String>(
								"ITEM: " + itemAux.getName() + " QUANTITY: " + quantity + " ADDED SUCCESSFULLY TO CART",
								HttpStatus.OK);
					}
				} else {
					// there is'nt a cart opened, creating a new cart for the
					// user
					cartAux = new Cart(accountAux.getUser());
					// save the cart into the database
					cartDao.save(cartAux);
					LineItem line = new LineItem(cartAux, itemAux, quantity);
					// save the lineItem into the database
					lineItemDao.save(line);
					return new ResponseEntity<String>("NEW CART WAS CREATED. CART ID: " + cartAux.getId() + "\nITEM: "
							+ itemAux.getName() + " QUANTITY: " + quantity + " ADDED SUCCESSFULLY TO CART",
							HttpStatus.OK);
				}

			}
		}

	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	ResponseEntity<String> removeItemFromCart(@RequestParam long item_id) {

		Account accountAux = (Account) httpSession.getAttribute("accountSession");
		// if there is'nt a session opened
		if (accountAux == null) {
			return new ResponseEntity<String>("PLEASE LOGIN", HttpStatus.OK);
		} else {
			// if there is a session opened
			accountAux = (Account) httpSession.getAttribute("accountSession");
			// update mapping of account
			accountAux = accountDao.updateMap(accountAux);
			// find Item
			// Find opened cart of user
			Cart cartAux = accountAux.getUser().getOpenCart();
			if (cartAux != null) {
				LineItem line = cartAux.getLineByItemId(item_id);
				if (line == null) {
					return new ResponseEntity<String>(
							"THE ITEM ID: " + item_id + " DOES NOT EXIST IN CART " + cartAux.getId(), HttpStatus.OK);
				} else {
					// remove lineItem
					String message = lineItemDao.remove(line);
					return new ResponseEntity<String>(message, HttpStatus.OK);

				}

			} else {
				// there is'nt a cart opened, creating a new cart for the
				return new ResponseEntity<String>("THERE IS'NT A CART OPENED", HttpStatus.OK);
			}
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	ResponseEntity<String> saveCart() {

		Account accountAux = (Account) httpSession.getAttribute("accountSession");
		// if there is'nt a session opened
		if (accountAux == null) {
			return new ResponseEntity<String>("PLEASE LOGIN", HttpStatus.OK);
		} else {
			// if there is a session opened
			// update mapping of account
			accountAux = accountDao.updateMap(accountAux);
			// find Item
			// Find opened cart of user
			Cart cartAux = accountAux.getUser().getOpenCart();
			if (cartAux != null) {
				// close cart
				cartAux.setClosed(true);
				// save cart in the database
				cartDao.save(cartAux);
				return new ResponseEntity<String>("THE CART ID: " + cartAux.getId() + " WAS SAVED SUCCESSFULLY",
						HttpStatus.OK);
			} else {
				// there is'nt a cart opened, creating a new cart for the
				return new ResponseEntity<String>("THERE IS'NT A CART OPENED", HttpStatus.OK);
			}
		}
	}

}
