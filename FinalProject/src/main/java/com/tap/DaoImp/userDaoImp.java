package com.tap.DaoImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.userDao;
import com.tap.Model.userModel;
import com.tap.utility.Dbconnection;

public class userDaoImp implements userDao {
	
	
	String ADD_USER = "INSERT INTO user (userName, password, email, phone, address) VALUES (?, ?, ?, ?, ?)";
    String GET_USER= "SELECT * FROM `user` WHERE email = ? ";
    String UPDATE_USER ="UPDATE `user` SET email = ?, password = ?, phone = ?, address = ? WHERE userId = ?";
    String DELETE_USER = "DELETE FROM `user` WHERE userId = ?";
    String GET_ALL_USERS = "SELECT * FROM `user`";
	
	
	
    Connection connection ;
	{
		 connection = Dbconnection.connectDb();
	}


	@Override
	public void adduserModel(userModel user) {
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_USER);
			
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setLong(4, user.getPhone());
			statement.setString(5, user.getAddress());
			statement.executeUpdate();
			
			
			System.out.println("data inserted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

	@Override
	public userModel getUser(String email) {
		userModel u = null;
		
		try {
			PreparedStatement statement = connection.prepareStatement(GET_USER);
			statement.setString(1, email);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				int userId = rs.getInt("userId");
				String  userName = rs.getString("userName");
				String password = rs.getString("password");
				String email1 = rs.getString("email");
				long phone = rs.getLong("phone");
				String address = rs.getString("address");
				
				 u = new userModel( userId ,userName, password, email1, phone, address);
				
			}
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public void updateUser(userModel user) {
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setLong(3, user.getPhone());
			statement.setString(4, user.getAddress());
			statement.setInt(5, user.getUserId());

			
			statement.executeUpdate();			
			
			System.out.println("user updeted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int deleteUser(int id) {
		try {
			PreparedStatement statement = connection.prepareStatement(DELETE_USER);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			
			
			System.out.print("user deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return 0;
	}

	@Override
	public List<userModel> getAlluser() {
		 List<userModel> list = new ArrayList<>();
		 
			try {
				PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS);
				 ResultSet rs = statement.executeQuery();  
				 
				 
				 while (rs.next()) {
			            userModel u = new userModel();

			            u.setUserId(rs.getInt("userId"));
			            u.setUserName(rs.getString("userName"));
			            u.setPassword(rs.getString("password")); 
			            u.setEmail(rs.getString("email"));
			            u.setPhone(rs.getLong("phone"));
			            u.setAddress(rs.getString("address"));

			            list.add(u);
			        }
				 
				 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return list;
	}

}
