package com.tap.Model;

public class CartItem {
	
	private int itemId ;
	private int restaurantId;
	private int quantity;
	private String name;
	private double price;
	private String ImagePath;
	
	
	
	public void cartItem() {
		
	}


	public CartItem(int itemId, int restaurantId, int quantity, String name, double price) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.quantity = quantity;
		this.name = name;
		this.price = price;
	}


	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}


	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	/**
	 * @return the restaurantId
	 */
	public int getRestaurantId() {
		return restaurantId;
	}


	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}



	
	

	
	
	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", quantity=" + quantity + ", name="
				+ name + ", price=" + price + "]";
	}


	public String getImagePath() {
		return ImagePath;
	}


	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

}
