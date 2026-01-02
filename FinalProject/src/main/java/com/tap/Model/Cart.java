package com.tap.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	public Map<Integer, CartItem> getItems() {
		return items;
	}


	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}

	Map<Integer, CartItem> items = new HashMap<>();
	
	
	
    
	public void addItemToCart( CartItem cartitem) {
		int itemId = cartitem.getItemId();
		
		
		if(items.containsKey(itemId)) {
			CartItem item = items.get(itemId);
			item.setQuantity(item.getQuantity()+1);
			
		}else{
			items.put(itemId, cartitem);
			
		}
		 
	}
	
	
		public void UpdateCartItem( int itemId , int quantity) {
			
			
			
			if(quantity < 1) {
				 items.remove(itemId);
			}else {
			CartItem cartItem = items.get(itemId);			
			cartItem.setQuantity(quantity);
		 
		}
				
		}
			
	
			public void DeleteCartItem(int itemId) {
				items.remove(itemId);
				}
	
			
	public double TotalPrice() {
				
				double TotalPrice = 0 ;
				Collection<CartItem> values = items.values();
				
				for(CartItem cartItem : values) {
				 double CartPrice = cartItem.getPrice() * cartItem.getQuantity();
				 TotalPrice+=CartPrice;
				}
				
				
				return TotalPrice;
				
				 
			}

}
