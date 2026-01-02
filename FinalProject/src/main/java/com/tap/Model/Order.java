package com.tap.Model;

import java.sql.Timestamp;

public class Order {
	private int orderId;
	 private int userId;
	 private int restaurantId;
	 private Timestamp orderDate;
	 private double  totalAmount;
	 private String status;
	 private String paymentMode;
	 
	 public  Order() {
		 
	 }
	 
	 
	 
	 /**
		 * @return the orderId
		 */
		public int getOrderId() {
			return orderId;
		}

		/**
		 * @param orderId the orderId to set
		 */
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		/**
		 * @return the userId
		 */
		public int getUserId() {
			return userId;
		}

		/**
		 * @param userId the userId to set
		 */
		public void setUserId(int userId) {
			this.userId = userId;
		}

		/**
		 * @return the restaurantId
		 */
		public int getRestaurantId() {
			return restaurantId;
		}

		/**
		 * @param restaurantId the restaurantId to set
		 */
		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}

		/**
		 * @return the orderDate
		 */
		public Timestamp getOrderDate() {
			return orderDate;
		}

		/**
		 * @param timestamp the orderDate to set
		 */
		public void setOrderDate(Timestamp timestamp) {
			this.orderDate = timestamp;
		}

		/**
		 * @return the totalAmount
		 */
		public double getTotalAmount() {
			return totalAmount;
		}

		/**
		 * @param  the totalAmount to set
		 */
		public void setTotalAmount(double d ) {
			this.totalAmount = d;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		/**
		 * @return the paymentMode
		 */
		public String	 getPaymentMode() {
			return paymentMode;
		}

		/**
		 * @param paymentMode the paymentMode to set
		 */
		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		
		
		
		 @Override
			public String toString() {
				return "order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", orderDate="
						+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMode=" + paymentMode
						+ "]";
			}
	 
	

}
