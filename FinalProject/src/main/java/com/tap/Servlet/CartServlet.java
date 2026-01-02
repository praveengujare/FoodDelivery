package com.tap.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tap.DaoImp.MenuDaoImp;
import com.tap.Model.Cart;
import com.tap.Model.CartItem;
import com.tap.Model.Menu;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			  
			HttpSession session = req.getSession();
			
			Cart  cart = (Cart)session.getAttribute("cart");
			
			 
			Integer oldRestaurantId = (Integer)session.getAttribute("oldRestaurantId");
			
			int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
			
		
			if(cart==null || oldRestaurantId != restaurantId ){
				
				cart = new Cart();
				session.setAttribute("cart", cart);
				session.setAttribute("oldRestaurantId",  restaurantId);
			}
			
			String action = req.getParameter("action");
			
			if(action.equals("add")){
	             addTocart(req ,resp ,cart);	
			}else if(action.equals("Update")) {
				UpdateToCart(req , resp , cart);
				
			}else if(action.equals("Remove")) {
				RemoveToCart(req ,resp ,cart);
			}
			
			
			resp.sendRedirect("Cart.jsp");
			 
		}


		


		private void addTocart(HttpServletRequest req, HttpServletResponse resp, Cart cart) {
			int itemId = Integer.parseInt(req.getParameter("menuId"));
			int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
			int  quantity = Integer.parseInt(req.getParameter("quantity"));
			
			 MenuDaoImp menuDaoImp = new MenuDaoImp();
		      Menu menu = menuDaoImp.getMenuId(itemId);
		       
		      String itemName = menu.getItemName();
		      int price = menu.getPrice();
		      String imagePath = menu.getImagePath();
		    
		      
		    CartItem cartItem = new CartItem(itemId, restaurantId, quantity, itemName, price);
		   cart.addItemToCart(cartItem);
		   req.setAttribute( "cart", cart);
//		   RequestDispatcher requestDispatcher = req.getRequestDispatcher("Cart.jsp");
//		   try {
////			requestDispatcher.forward(req, resp);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		   
		   
		   
		   
		}

		private void UpdateToCart(HttpServletRequest req, HttpServletResponse resp, Cart cart) {
			
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		 cart.UpdateCartItem(itemId , quantity);
		 
		}
		
		
		
		private void RemoveToCart(HttpServletRequest req, HttpServletResponse resp, Cart cart) {
			int itemId = Integer.parseInt(req.getParameter("itemId"));
//			System.out.println(itemId);
			cart.DeleteCartItem(itemId);
			
		}

	}

	


