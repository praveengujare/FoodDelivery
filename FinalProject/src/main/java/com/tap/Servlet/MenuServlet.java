package com.tap.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.tap.DaoImp.MenuDaoImp;
import com.tap.Model.Menu;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		MenuDaoImp imp = new MenuDaoImp();
		List<Menu> menu= imp.getAllMenuByRestaurantId(restaurantId);
		
//		for (Menu menu2 : allMenuByRestaurantId) {
//			System.out.println(menu2);
//		}
		
		req.setAttribute("menu",menu);
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
		
		
	}

}
