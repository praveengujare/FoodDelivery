package com.tap.Dao;

import java.util.List;

import com.tap.Model.Order;

public interface OrderDao {
	

	    int createOrder(Order order);         

	    Order getOrderById(int orderId);

	    List<Order> getOrdersByUserId(int userId);

	    List<Order> getAllOrders();

	    void updateOrderStatus(int orderId, String status);
	

}
