package com.tap.Dao;

import java.util.List;

import com.tap.Model.Restaurant;

public interface RestaurantDao {

	public void addRestaurant(Restaurant restaurant);
	public Restaurant getRestaurant(int id);
	public List<Restaurant> getAllRestaurant();
	public void deleteRestaurant(int id);
	public Restaurant  updateRestaurant(Restaurant restaurant);
	
	
	
}
