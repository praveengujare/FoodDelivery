package com.tap.Dao;

import java.util.List;

import com.tap.Model.OrderItem;

public interface OrderItemDao {
	void addOrderItem(OrderItem orderItem);

    List<OrderItem> getOrderItemsByOrderId(int orderId);

    void deleteOrderItemsByOrderId(int orderId);

}
