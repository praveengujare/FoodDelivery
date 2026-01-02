package com.tap.Model;

public class OrderItem {
	
	private int orderItemId;
	private int oredrId;
	private int menuId;
	private double totalPrice;
	
	public OrderItem() {
		
	}
	
	
	
	/**
	 * @return the orderItemId
	 */
	public int getOrderItemId() {
		return orderItemId;
	}

	/**
	 * @param orderItemId the orderItemId to set
	 */
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * @return the oredrId
	 */
	public int getOredrId() {
		return oredrId;
	}

	/**
	 * @param oredrId the oredrId to set
	 */
	public void setOredrId(int oredrId) {
		this.oredrId = oredrId;
	}

	/**
	 * @return the menuId
	 */
	public int getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void settotalPrice(double d) {
		this.totalPrice = d;
	}

	
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", oredrId=" + oredrId + ", menuId=" + menuId
				+ ", totalAmount=" + totalPrice + "]";
	}
	
	
	

}
