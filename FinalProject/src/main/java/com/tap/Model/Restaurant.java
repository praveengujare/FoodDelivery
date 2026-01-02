package com.tap.Model;

public class Restaurant {
	
	
	private  int restaurantId;
	private String name;
	private String cuisineType;
	private String deliveryTime;
	private String address;
	private int adminUser;
	private  int rating;
	private  boolean isActive;
	private String imagePath;
	
	
	public Restaurant() {
		
	}
	
	
	public Restaurant(int restaurantId, String name, String cuisineType, String deliveryTime, String address,
			int adminUser, int rating, boolean isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.adminUser = adminUser;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}
	
	public Restaurant( String name, String cuisineType, String deliveryTime, String address,
			int adminUser , int rating, boolean isActive, String imagePath) {
		super();
	
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.adminUser = adminUser;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
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
	 * @return the cuisineType
	 */
	public String getCuisineType() {
		return cuisineType;
	}


	/**
	 * @param cuisineType the cuisineType to set
	 */
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	/**
	 * @return the deliveryTime
	 */
	public String getDeliveryTime() {
		return deliveryTime;
	}


	/**
	 * @param deliveryTime the deliveryTime to set
	 */
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the adminUser
	 */
	public int getAdminUser() {
		return adminUser;
	}


	/**
	 * @param adminUser the adminUser to set
	 */
	public void setAdminUser(int adminUser) {
		this.adminUser = adminUser;
	}


	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}


	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}


	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}


	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
		return "restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisineType=" + cuisineType
				+ ", deliveryTime=" + deliveryTime + ", address=" + address + ", adminUser=" + adminUser + ", rating="
				+ rating + ", isActive=" + isActive + ", imagePath=" + imagePath + "]";
	}

}
