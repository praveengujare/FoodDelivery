package com.tap.Model;

public class userModel {

	
	 private int userId;
	  private String userName;
	  private String password;
	  private String email;
	  private long phone;
	 private String address;
	 
	 
	 public userModel() {

		 
	 }


	 public userModel(int userId, String userName, String password, String email, long phone, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	 }
	
	 
	 public userModel( String userName, String password, String email, long phone, String address) {
			super();
			
			this.userName = userName;
			this.password = password;
			this.email = email;
			this.phone = phone;
			this.address = address;
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
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}


		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}


		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}


		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}


		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}


		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}


		/**
		 * @return the phone
		 */
		public long getPhone() {
			return phone;
		}


		/**
		 * @param phone the phone to set
		 */
		public void setPhone(long phone) {
			this.phone = phone;
		}


		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}


		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}
		


		 @Override
		public String toString() {
			return "userModel [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
					+ ", phone=" + phone + ", address=" + address + "]";
		}
}
