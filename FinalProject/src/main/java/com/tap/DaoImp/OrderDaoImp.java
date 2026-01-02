package com.tap.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Model.Order;
import com.tap.utility.Dbconnection;
import com.tap.Dao.OrderDao;

public class OrderDaoImp implements OrderDao{
	
	private static final String INSERT =
		    "INSERT INTO `order` (userId, restaurantId, orderDate, totalAmount, status, paymentMode) " +
		    "VALUES (?, ?, CURRENT_TIMESTAMP, ?, ?, ?)";


		    private static final String GET_BY_ID =
		        "SELECT * FROM `order` WHERE orderId = ?";

		    private static final String GET_BY_USER =
		        "SELECT * FROM `order` WHERE userId = ?";

		    private static final String GET_ALL =
		        "SELECT * FROM `order`";

		    private static final String UPDATE_STATUS =
		        "UPDATE `order` SET status = ? WHERE orderId = ?";

		    Connection connection ;
			{
				 connection = Dbconnection.connectDb();
	         }

	@Override
	public int createOrder(Order order) {

	    int orderId = 0;

	    try {
	        PreparedStatement ps = connection.prepareStatement(
	                INSERT,
	                Statement.RETURN_GENERATED_KEYS
	        );

	        ps.setInt(1, order.getUserId());
	        ps.setInt(2, order.getRestaurantId());
	        ps.setDouble(3, order.getTotalAmount());
	        ps.setString(4, order.getStatus());
	        ps.setString(5, order.getPaymentMode());

	        ps.executeUpdate();

	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            orderId = rs.getInt(1); // generated orderId
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return orderId;
	}

	
	

	@Override
	public Order getOrderById(int orderId) {
		
	    Order order = null;

        try {
             PreparedStatement ps = connection.prepareStatement(GET_BY_ID);

            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));              
                order.setOrderDate(rs.getTimestamp("orderDate"));
                order.setStatus(rs.getString("status"));
                order.setTotalAmount(rs.getLong("totalPrice"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
		
		
		
	
	
	
	
	
	
	
	
	
	@Override
	public List<Order> getOrdersByUserId(int userId) {
		
		 List<Order> list = new ArrayList<>();

	        try {
	             PreparedStatement ps = connection.prepareStatement(GET_BY_USER);

	            ps.setInt(1, userId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Order order = new Order();
	                order.setOrderId(rs.getInt("orderId"));
	                order.setUserId(rs.getInt("userId"));
	                order.setOrderDate(rs.getTimestamp("orderDate"));
	                order.setStatus(rs.getString("status"));
	                order.setTotalAmount(rs.getLong("totalPrice"));

	                list.add(order);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	
	
	
	

	@Override
	public List<Order> getAllOrders() {
		
		List<Order> list = new ArrayList<>();

        try {
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL);

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                order.setUserId(rs.getInt("userId"));
                order.setOrderDate(rs.getTimestamp("orderDate"));
                order.setStatus(rs.getString("status"));
                order.setTotalAmount(rs.getLong("totalPrice"));

                list.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}

	
	
	
	
	@Override
	public void updateOrderStatus(int orderId, String status) {
		try {
	             PreparedStatement ps = connection.prepareStatement(UPDATE_STATUS);

	            ps.setString(1, status);
	            ps.setInt(2, orderId);
	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
	

}
