
<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.tap.Model.Cart , java.util.Map , com.tap.Model.CartItem , java.util.Collection "   %>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Your Cart</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="Cart.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>

  <!-- Header -->
  <header class="cart-header">
    <div class="header-content">
      <div class="header-left">
        <div class="cart-icon-wrapper">
          <svg class="cart-icon" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <circle cx="9" cy="21" r="1"></circle>
            <circle cx="20" cy="21" r="1"></circle>
            <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
          </svg>
        </div>
        <h1>Your Cart</h1>
      </div>
      <%
        Cart cart = (Cart)session.getAttribute("cart");
        Map<Integer, CartItem> items = cart.getItems();
        Collection<CartItem> itemValues = items.values();
        Integer restaurantId = (Integer)session.getAttribute("oldRestaurantId");
        int totalItems = 0;
        for(CartItem item : itemValues) {
          totalItems += item.getQuantity();
        }
      %>
      <div class="header-right">
        <span class="item-count"><%= totalItems %> Items</span>
      </div>
    </div>
  </header>

  <!-- Main Container -->
  <div class="cart-container">

    <!-- Cart Items Section -->
    <section class="cart-items-section">
      <div class="cart-items">
        <%
        for(CartItem itemValue : itemValues){
        %>
        <div class="cart-item">
          <div class="item-image-wrapper">
            <img src="<%= itemValue.getImagePath() %>" alt="<%= itemValue.getName() %>" class="item-image">
          </div>
          
          <div class="item-info">
            <div class="item-header">
              <h3 class="item-name"><%= itemValue.getName() %></h3>
              <form action="CartServlet" class="remove-form">
                <input type="hidden" name="itemId" value="<%= itemValue.getItemId() %>">
                <input type="hidden" name="restaurantId" value="<%= itemValue.getRestaurantId() %>">
                <input type="hidden" name="action" value="Remove">
                <button type="submit" class="remove-btn" title="Remove item">
                  <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                    <polyline points="3 6 5 6 21 6"></polyline>
                    <path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path>
                  </svg>
                </button>
              </form>
            </div>
            
            <div class="item-footer">
              <div class="item-price">₹<%= itemValue.getPrice() %></div>
              
              <div class="quantity-controls">
                <form action="CartServlet" class="quantity-form">
                  <input type="hidden" name="itemId" value="<%= itemValue.getItemId() %>">
                  <input type="hidden" name="restaurantId" value="<%= itemValue.getRestaurantId() %>">
                  <input type="hidden" name="action" value="Update">
                  <input type="hidden" name="quantity" value="<%= itemValue.getQuantity()-1 %>">
                  <button type="submit" class="qty-btn qty-minus" <%= itemValue.getQuantity() <= 1 ? "disabled" : "" %>>
                    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                      <line x1="5" y1="12" x2="19" y2="12"></line>
                    </svg>
                  </button>
                </form>
                
                <span class="qty-display"><%= itemValue.getQuantity() %></span>
                
                <form action="CartServlet" class="quantity-form">
                  <input type="hidden" name="itemId" value="<%= itemValue.getItemId() %>">
                  <input type="hidden" name="restaurantId" value="<%= itemValue.getRestaurantId() %>">
                  <input type="hidden" name="action" value="Update">
                  <input type="hidden" name="quantity" value="<%= itemValue.getQuantity()+1 %>">
                  <button type="submit" class="qty-btn qty-plus">
                    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                      <line x1="12" y1="5" x2="12" y2="19"></line>
                      <line x1="5" y1="12" x2="19" y2="12"></line>
                    </svg>
                  </button>
                </form>
              </div>
              
              <div class="item-subtotal">
                ₹<%= itemValue.getPrice() * itemValue.getQuantity() %>
              </div>
            </div>
          </div>
        </div>
        <%
        }
        %>
      </div>
      
      <!-- Add More Items Button -->
      <div class="add-more-section">
        <a href="MenuServlet?restaurantId=<%=restaurantId%>" class="add-more-btn">
          <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
            <line x1="12" y1="5" x2="12" y2="19"></line>
            <line x1="5" y1="12" x2="19" y2="12"></line>
          </svg>
          <span>Add More Items</span>
        </a>
      </div>
    </section>

    <!-- Bill Summary Sidebar -->
    <aside class="bill-summary">
      <div class="bill-summary-sticky">
        <h2 class="bill-title">Bill Summary</h2>
        
        <div class="bill-details">
          <div class="bill-row">
            <span class="bill-label">Item Total</span>
            <span class="bill-value">₹<%= cart.TotalPrice() %></span>
          </div>
          
          <div class="bill-row">
            <span class="bill-label">Delivery Fee</span>
            <span class="bill-value free">FREE</span>
          </div>
          
          <div class="bill-row">
            <span class="bill-label">Taxes & Charges</span>
            <span class="bill-value">₹0</span>
          </div>
          
          <div class="bill-divider"></div>
          
          <div class="bill-row bill-total">
            <span class="bill-label">Grand Total</span>
            <span class="bill-value">₹<%= cart.TotalPrice() %></span>
          </div>
        </div>
        
        <form action="CheckOut.jsp" class="checkout-form">
          <button type="submit" class="checkout-btn">
            <span>Proceed to Checkout</span>
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <line x1="5" y1="12" x2="19" y2="12"></line>
              <polyline points="12 5 19 12 12 19"></polyline>
            </svg>
          </button>
        </form>
        
      </div>
    </aside>

  </div>

</body>
</html>
