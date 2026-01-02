package com.tap.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.Model.Menu;
import com.tap.utility.Dbconnection;
import com.tap.Dao.MenuDao;

public class MenuDaoImp  implements MenuDao{
	
	String add_Menu = "INSERT INTO menu "
            + "(restaurantId, itemName, description, price, isAvailable, imagePath) "
            + "VALUES (?, ?, ?, ?, ?, ?)";


String GET_MENU_ID = "SELECT * FROM menu WHERE menuId = ?";


String GET_ALL_MENU = "SELECT * FROM `menu`";

String GET_ALL_MENU_BY_RESTAURANTID = "SELECT * FROM menu WHERE restaurantId = ? ";

String DELETE_MENU = "DELETE FROM menu WHERE menuId = ? ";

String UPDATE_MENU = "UPDATE menu "
		+ "SET itemName = ?, description = ?, price = ?, isAvailable = ?, imagePath = ?"
		+ "WHERE menuId = ? ";




Connection connection ;
	{
		 connection = Dbconnection.connectDb();
 }
	


@Override
public void addMenu(Menu menu) {
	      
	try {
		PreparedStatement ps = connection.prepareStatement(add_Menu);
		
		    ps.setInt(1, menu.getRestaurantId());
	        ps.setString(2, menu.getItemName());
	        ps.setString(3, menu.getDescription());
	        ps.setInt(4, menu.getPrice());
	        ps.setBoolean(5, menu.isAvailable());
	        ps.setString(6, menu.getImagePath());
		
	        ps.executeUpdate();	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}

@Override
public Menu getMenuId(int id) {
	// TODO Auto-generated method stub
	
	Menu menu = null;
	try {
		PreparedStatement ps = connection.prepareStatement(GET_MENU_ID);
		
		  ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            menu = new Menu(
	                rs.getInt("menuId"),
	                rs.getInt("restaurantId"),
	                rs.getString("itemName"),
	                rs.getString("description"),
	                rs.getInt("price"),
	                rs.getBoolean("isAvailable"),
	                rs.getString("imagePath")
	            );
	        }
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return menu;
}





@Override
public List<Menu> getAllMenu() {

   List<Menu> menuList = new ArrayList<>();
  

   try (PreparedStatement ps = connection.prepareStatement(GET_ALL_MENU)) {

       ResultSet rs = ps.executeQuery();

       while (rs.next()) {
           Menu menu = new Menu(
               rs.getInt("menuId"),
               rs.getInt("restaurantId"),
               rs.getString("itemName"),
               rs.getString("description"),
               rs.getInt("price"),
               rs.getBoolean("isAvailable"),
               rs.getString("imagePath")
           );

           menuList.add(menu);
       }

   } catch (Exception e) {
       e.printStackTrace();
   }

   return menuList;
}





@Override
public List<Menu> getAllMenuByRestaurantId(int restaurantId) {

   List<Menu> menuList = new ArrayList<>();
  

   try (PreparedStatement ps = connection.prepareStatement(GET_ALL_MENU_BY_RESTAURANTID)) {

       ps.setInt(1, restaurantId);
       ResultSet rs = ps.executeQuery();

       while (rs.next()) {
           Menu menu = new Menu(
               rs.getInt("menuId"),
               rs.getInt("restaurantId"),
               rs.getString("itemName"),
               rs.getString("description"),
               rs.getInt("price"),
               rs.getBoolean("isAvailable"),
               rs.getString("imagePath")
           );

           menuList.add(menu);
       }

   } catch (Exception e) {
       e.printStackTrace();
   }

   return menuList;
}





@Override
public void deleteMenu(int id) {

  

   try (PreparedStatement ps = connection.prepareStatement(DELETE_MENU)) {

       ps.setInt(1, id);
       ps.executeUpdate(); // Executes DELETE

   } catch (Exception e) {
       e.printStackTrace();
   }
}




@Override
public Menu updateMenu(Menu menu) {

  

   try (PreparedStatement ps = connection.prepareStatement(UPDATE_MENU)) {

       ps.setString(1, menu.getItemName());
       ps.setString(2, menu.getDescription());
       ps.setInt(3, menu.getPrice());
       ps.setBoolean(4, menu.isAvailable());
       ps.setString(5, menu.getImagePath());
       ps.setInt(6, menu.getMenuId());

       int rows = ps.executeUpdate();

       if (rows > 0) {
           return menu; 
       }

   } catch (Exception e) {
       e.printStackTrace();
   }

   return null; // update failed
}

}
