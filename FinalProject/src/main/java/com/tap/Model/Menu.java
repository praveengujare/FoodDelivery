package com.tap.Model;

public class Menu {
	
	private  int menuId;
	private  int restaurantId;
	 private  String itemName;
	 private  String  description;
	 private  int  price;
	 private  boolean isAvailable;
	 private  String imagePath;
	
	
	 public Menu() {
			
		}
	 
	 
		public Menu(int menuId, int restaurantId, String itemName, String description, int price, boolean isAvailable,
				String imagePath) {
			super();
			this.menuId = menuId;
			this.restaurantId = restaurantId;
			this.itemName = itemName;
			this.description = description;
			this.price = price;
			this.isAvailable = isAvailable;
			this.imagePath = imagePath;
		}

	 
	 

	public int getMenuId() {
		return menuId;
	}
	
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	
	public int getRestaurantId() {
		return restaurantId;
	}
	
	
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvailable=" + isAvailable + ", imagePath=" + imagePath + "]";
	}

}
