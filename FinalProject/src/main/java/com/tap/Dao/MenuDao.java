package com.tap.Dao;

import java.util.List;

import com.tap.Model.Menu;

public interface MenuDao {
	public void addMenu(Menu menu);
	public Menu getMenuId(int id);
	public List<Menu> getAllMenu();
	public List<Menu> getAllMenuByRestaurantId(int restaurantId);
	public void deleteMenu(int id);
	public Menu updateMenu(Menu menu);

}
