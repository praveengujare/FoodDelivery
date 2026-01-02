package com.tap.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tap.DaoImp.userDaoImp;
import com.tap.Model.userModel;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				String name = req.getParameter("userName");
				String email = req.getParameter("email");
				String password = req.getParameter("password");
			     long phone = Long.parseLong(req.getParameter("phone"));
			     String address = req.getParameter("address");
	            
			     
			     userModel user = new userModel( name, password, email, phone, address);
			     
			     userDaoImp userDaoImp = new userDaoImp();
			     userDaoImp.adduserModel(user);
			    	     
		
	}

}
