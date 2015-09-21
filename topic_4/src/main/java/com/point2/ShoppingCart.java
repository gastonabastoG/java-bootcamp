package com.point2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private final List<Item> cartContent;
	private Payment payment;
	private boolean paid;
	
	public ShoppingCart(){
		cartContent = new ArrayList<Item>();
		payment = null;
		paid = false;
	}
	
	public void addItem(Item item, int quantity){
		for (int i = 0; i < quantity; i++)
			cartContent.add(item);
	}
	
	public void removeItem(Item item){
		cartContent.remove(item);
	}
	
	public void remove(int index){
		if (index < cartContent.size())
			cartContent.remove(index);
	}
	
	public void setPayment(Payment payment){
		this.payment = payment;
	}
	
	public Payment getPayment(){
		return payment;
	}
	
	public void emptyCart(){
		cartContent.clear();
	}
	
	public boolean isEmpty(){
		return cartContent.isEmpty();
	}
	
	public int getItemQuantity(Item item){
		int count = 0;
		for (Item it : cartContent)
			if (it.equals(item))
				count++;
		return count;
	}
	
	public boolean contains(Item item){
		return cartContent.contains(item);
	}
	
	public boolean isPaid(){
		return paid;
	}
	
	public void checkOut(){
		if (payment != null){
			BigDecimal total = calculateTotal();
			payment.pay(total);
			paid = true;
		}
	}

	private BigDecimal calculateTotal(){
		BigDecimal total = new BigDecimal(0);
		for (Item item : cartContent)
			total = total.add(item.getPrice());
		return total;
	}
}
