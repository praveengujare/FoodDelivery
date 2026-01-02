package com.tap.Dao;

import java.util.List;

import com.tap.Model.userModel;

public interface userDao {
  void adduserModel( userModel  user);
	 userModel getUser(String email);
	  void  updateUser(userModel user);
	  int deleteUser(int id);
	   List<userModel> getAlluser();
}
