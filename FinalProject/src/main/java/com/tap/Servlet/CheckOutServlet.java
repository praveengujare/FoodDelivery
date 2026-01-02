package com.tap.Servlet;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.DaoImp.OrderDaoImp;
import com.tap.DaoImp.OrderItemDaoImp;
import com.tap.Model.Cart;
import com.tap.Model.CartItem;
import com.tap.Model.Order;
import com.tap.Model.OrderItem;
import com.tap.Model.userModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	    Cart cart = (Cart)session.getAttribute("cart");
	    userModel user = (userModel)session.getAttribute("user");
	    Integer restaurantId = (Integer)session.getAttribute("oldRestaurantId");
	    
	        int itemId = Integer.parseInt(req.getParameter("menuId"));
	      
	      
	        String paymentMode = req.getParameter("paymentMode");
	        String address = req.getParameter("address");
	        
	   if(user==null){   
		   RequestDispatcher requestDispatcher = req.getRequestDispatcher("userlogin.jsp");
		   requestDispatcher.forward(req, resp);
	   }
		
	   if(cart!=null && !cart.getItems().isEmpty()) {
		   
		   Order order = new Order();
		   
		   order.setUserId(user.getUserId());
		   order.setRestaurantId(restaurantId);
		   Timestamp time = new Timestamp(System.currentTimeMillis());
		   order.setTotalAmount(cart.TotalPrice());
	
		   String placed=null;
		   order.setStatus(placed);
		   order.setPaymentMode(paymentMode);
		  
		   System.out.println("start");
		   
		   
		   OrderDaoImp orderDaoImp = new OrderDaoImp(); 
		   int orderId = orderDaoImp.createOrder(order);
		   
		   
	
		   
		   for (CartItem item : cart.getItems().values()) {
			   OrderItem orderItem = new OrderItem();
			   
			   orderItem.setOredrId(orderId);
			   orderItem.setMenuId(item.getItemId());
			
			   
			   orderItem.settotalPrice(item.getPrice());
			   
			   OrderItemDaoImp orderItemDaoImp = new OrderItemDaoImp();
			   orderItemDaoImp.addOrderItem(orderItem);
		}	   
	}
	   session.removeAttribute("cart");
	   
	   resp.sendRedirect("conformed.jsp");
		
		
		
	}

}
