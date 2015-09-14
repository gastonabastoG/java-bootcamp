package com.mfidececchi.topic2;
import java.util.ArrayList;

public class Stock {

	private static Stock stock = null;
	private ArrayList<Item> items;
	private int lastItemId;

	private Stock() {
		items = new ArrayList<Item>();
	}

	public static Stock getInstance() {
		if (stock == null) {
			stock = new Stock();			
		}
		return stock;
	}

	// returns the last Item that was incorporated.
	private int getLastItemId() {
		return lastItemId;
	}

	// method that allocate an id to Item, then adds Item into the arrayList and
	// update the last Item that was incorporated.
	public void addItem(Item item) {
		int idAux = this.getLastItemId() + 1;
		item.setId(idAux);
		items.add(item);
		lastItemId = idAux;
	}

	// method that find an Item by id, returns item at found or null if not.
	public Item findItem(int id) {
		for (Item i : items) {
			if (i.getId() == id) {
				return i;
			}
		}
		return null;
	}

	// Method that prints in console the Stock's items
	public void printStock() {
		System.out.println("Id \\\\ Offer Name \\\\ Quantity \\\\ $Price");
		for (Item i : items) {
			System.out.println(i.getId()+" \\\\ "+i.getName() + " \\\\ " + i.getQuantity() + " \\\\ " + i.getPrice());
		}
	}
}
