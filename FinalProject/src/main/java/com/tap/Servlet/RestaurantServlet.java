package com.tap.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.tap.DaoImp.RestaurantDaoImp;
import com.tap.Model.Restaurant;


@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDaoImp restaurantDaoImp = new RestaurantDaoImp();
		List<Restaurant> allRestaurant = restaurantDaoImp.getAllRestaurant();
		
//		for (Restaurant restaurant : allRestaurant) {
//			System.out.println(restaurant);
//	}
		
		req.setAttribute("allRestaurant", allRestaurant);
		
		 RequestDispatcher rd = req.getRequestDispatcher("restaurant.jsp");
		 rd.forward(req, resp);
		
	}

}
