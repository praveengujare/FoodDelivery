<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tap.Model.Cart , java.util.Map , com.tap.Model.CartItem " %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Checkout | Food Delivery</title>
  <link rel="stylesheet" href="CheckOut.css">
</head>
<body>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    int grandTotal = 0;
%>

<div class="checkout-container">

 <h1 class="brand">🧾 Order Bill</h1>

  <form action="CheckOutServlet" method="post">

    <!-- ================= WRAPPER START ================= -->
    <div class="checkout-grid">

      <!-- ============ LEFT : ORDER SUMMARY ============ -->
      <div class="left-panel">

        <h2>Order Summary</h2>

        <div class="order-summary">
          <%
            if (cart != null && !cart.getItems().isEmpty()) {
              for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
                  CartItem item = entry.getValue();
                  double subTotal = item.getPrice() * item.getQuantity();
                  grandTotal += subTotal;
          %>
              <input type="hidden" name="menuId" value="<%= item.getItemId() %>">

              <div class="summary-row">
                <span><%= item.getName() %> (<%= item.getQuantity() %>)</span>
                <span>₹ <%= subTotal %></span>
              </div>
          <%
              }
            }
          %>

          <hr>

          <div class="summary-row total">
            <strong>Total</strong>
            <strong>₹ <%= grandTotal %></strong>
          </div>

          <input type="hidden" name="totalAmount" value="<%= grandTotal %>">
        </div>

      </div>

      <!-- ============ RIGHT : ADDRESS + PAYMENT ============ -->
      <div class="right-panel">

        <h2>Delivery Address</h2>
        <div class="input-group">
          <label>Address</label>
          <textarea name="address" placeholder="House No, Street, Area" required></textarea>
        </div>

        <h2>Payment Details</h2>
        <div class="payment-methods">
          <label>
            <input type="radio" name="paymentMode" value="CARD" checked>
            Card
          </label>

          <label>
            <input type="radio" name="paymentMode" value="UPI">
            UPI
          </label>

          <label>
            <input type="radio" name="paymentMode" value="COD">
            Cash on Delivery
          </label>
        </div>

      </div>

    </div>
    <!-- ================= WRAPPER END ================= -->



    <button type="submit" class="order-btn">
      Place Order
    </button>



  </form>
</div>

</body>
</html>