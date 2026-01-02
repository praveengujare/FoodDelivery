package com.tap.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.OrderItemDao;
import com.tap.Model.OrderItem;
import com.tap.utility.Dbconnection;

public class OrderItemDaoImp implements OrderItemDao {

	private static final String INSERT =
			"INSERT INTO orderitem (oredrId, menuId, totalAmount) VALUES (?, ?, ?)";

			private static final String GET_BY_ORDER =
			"SELECT * FROM orderitem WHERE orderId = ?";

			private static final String DELETE_BY_ORDER =
			"DELETE FROM orderitem WHERE orderId = ?";
				
				
				
				
			Connection connection ;
			{
				 connection = Dbconnection.connectDb();
			 }
				

			public void addOrderItem(OrderItem item) {
			    try {
			         PreparedStatement ps = connection.prepareStatement(INSERT);

			        ps.setInt(1, item.getOredrId());
			        ps.setInt(2, item.getMenuId()); 
			        ps.setDouble(3, item.getTotalPrice());

			        ps.executeUpdate();

			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			}


			@Override
			public List<OrderItem> getOrderItemsByOrderId(int orderId) {
			    List<OrderItem> list = new ArrayList<>();

			    try {
			         PreparedStatement ps = connection.prepareStatement(GET_BY_ORDER);

			        ps.setInt(1, orderId);
			        ResultSet rs = ps.executeQuery();

			        while (rs.next()) {
			            OrderItem item = new OrderItem();
			            item.setOrderItemId(rs.getInt("orderItemId"));
			            item.setOredrId(rs.getInt("orderId"));
			            item.setMenuId(rs.getInt("menuId")); 
			            item.settotalPrice(rs.getInt("totalPrice"));

			            list.add(item);
			        }

			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    return list;
			}




				@Override

					    public void deleteOrderItemsByOrderId(int orderId) {
					        try {
					             PreparedStatement ps = connection.prepareStatement(DELETE_BY_ORDER);

					            ps.setInt(1, orderId);
					            ps.executeUpdate();

					        } catch (Exception e) {
					            e.printStackTrace();
					        }
					    }
					

}
