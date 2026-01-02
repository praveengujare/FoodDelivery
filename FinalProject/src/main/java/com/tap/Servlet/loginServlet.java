package com.tap.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tap.DaoImp.userDaoImp;
import com.tap.Model.userModel;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String email = req.getParameter("email");
	   String password = req.getParameter("password");
	   

	   userDaoImp userDaoImp = new userDaoImp();
	   userModel user = userDaoImp.getUser(email);
	   
	   System.out.println(user);

	   if(user!=null) {
		   HttpSession session = req.getSession();
		   session.setAttribute("user", user); 
		   
		   resp.sendRedirect("RestaurantServlet");
	   }else {
		   resp.sendRedirect("userlogin.jsp");
	   }
	   
	}

}
