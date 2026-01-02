package com.tap.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.RestaurantDao;
import com.tap.Model.Restaurant;
import com.tap.utility.Dbconnection;

public class RestaurantDaoImp implements RestaurantDao {
	
	
	String ADD_RESTAURANT ="INSERT INTO `restaurant`(name , cuisineType , deliveryTime , address , adminUser , rating ,isActive , imagePath )"
			+ " values(? , ? , ? , ? , ? , ?  ,?  , ?  )";
	
	String DELETE_RESTAURANT = " DELETE  FROM `restaurant` WHERE restaurantId = ?";
	
	String GET_RESTAURANT =" SELECT * FROM  `restaurant` WHERE restaurantId  = ?  ";
	String GET_ALL_RESTAURANT =" SELECT * FROM  `restaurant`";
	
	
	Connection connection ;
	{
		 connection = Dbconnection.connectDb();
     }
	
	

	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_RESTAURANT);
			
			statement.setString(1, restaurant.getName());
			statement.setString(2, restaurant.getCuisineType());
			statement.setString(3, restaurant.getDeliveryTime());
			statement.setString(4, restaurant.getAddress());
			statement.setInt(5, restaurant.getAdminUser());
			statement.setInt(6, restaurant.getRating());
			statement.setBoolean(7, restaurant.isActive());
			statement.setString(8, restaurant.getImagePath());
			
			 statement.executeUpdate();
			
			System.out.println("RESTAURANT DATA INSERTED");
//			Restaurant res =new Restaurant(0, name, cuisineType, deliveryTime, address, adminUser, rating, isActive, imagePath)
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	

	@Override
	public Restaurant getRestaurant(int id) {
		Restaurant res =null;
	try {
		PreparedStatement statement = connection.prepareStatement(GET_RESTAURANT);
		statement.setInt(1, id);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("name");
			String cuisineType = rs.getString("cuisineType");
			String deliveryTime = rs.getString("deliveryTime");
			
			String address = rs.getString("address");
			int adminUser = rs.getInt("adminUser");
			int rating = rs.getInt("rating");
			String isActive = rs.getString("isActive");
			String imagePath = rs.getString("imagePath");
			
			res = new Restaurant( name, cuisineType, deliveryTime, address, adminUser,rating, false, imagePath);
			
		}
		
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
		
		
		return res;
	}

	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> restaurantList =new ArrayList<Restaurant>(); 
		 
		try {
			PreparedStatement statement = connection.prepareStatement(GET_ALL_RESTAURANT);
			
			ResultSet res = statement.executeQuery();
			
			while(res.next()) {
				int restaurantId = res.getInt("restaurantId");
				String name = res.getString("name");
				String cuisineType = res.getString("cuisineType");
				String delivery_time = res.getString("deliverytime");
				String address = res.getString("address");
				int  adminUserid = res.getInt("adminUser");
				String rating = res.getString("rating");
				boolean isActive = res.getBoolean("isActive");
				String imagePath = res.getString("imagePath");
				
				
				Restaurant restaurant = new Restaurant(restaurantId, name, cuisineType, delivery_time, address, adminUserid, adminUserid, isActive, imagePath);
				restaurantList.add(restaurant);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return restaurantList;
	}

	@Override
	public void deleteRestaurant(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement(DELETE_RESTAURANT);
			statement.setInt(1, id);
		     statement.executeUpdate();
		     
		     System.out.println("RESTAURANT ID IS SUCCESSFULLY DELETED ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

}
