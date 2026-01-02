<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List ,com.tap.Model.Menu " %>
    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu</title>
    <link rel="stylesheet" href="menu.css">
</head>
<body>
    <!-- Header -->
    <header>
        <div class="header-content">
            <h1>Our Menu</h1>
            <p class="subtitle">Discover our delicious selection of handcrafted dishes</p>
        </div>
    </header>
        

    <!-- Main Content -->
    <main>
        <!-- Category Filter -->
        
        <div class="category-filter">
            <button class="category-btn active" data-category="all">All</button>
           
        </div>
        
         <div class="menu-grid">
        <%
        List<Menu> menuItems = (List<Menu>) request.getAttribute("menu");
        for(Menu menuItem :menuItems){
        	 %>
        	
        	 <div class="menu-card" style="--card-index: 0" data-category="main">
                <div class="card-inner">
                    <div class="image-container">
                        <img src="<%=menuItem.getImagePath() %>" 
                             alt="Classic Burger Deluxe" 
                             class="menu-image">
                        <div class="badge badge-available">Available</div>
                    </div>
                    <div class="card-content">
                        <div class="card-header">
                            <h3 class="item-name"><%=menuItem.getItemName() %></h3>
                            <span class="item-price">$<%=menuItem.getPrice() %>></span>
                        </div>
                        
                        <p class="item-description"><%=menuItem.getDescription() %></p>
                        
                       
                       <form action="CartServlet">
                       
                        <input type="hidden" name="menuId" value="<%= menuItem.getMenuId() %>">
			      <input type="hidden" name="restaurantId" value="<%= menuItem.getRestaurantId() %>">
			      <input type="hidden" name="quantity" value="1">
			      <input type="hidden" name="action" value="add">
                   <button class="order-btn available">Add to Cart</button>
                       </form>
                       
                       
                       
                       
                       
                       
                       
                       
                    </div>
                </div>
            </div>
        	
        	
        	
        <%	
        }
        
        %>

      
            </div>

      
    </main>
 
    <!-- Footer -->
    <footer>
        <p>Crafted with love and the finest ingredients</p>
        <p class="footer-small">© 2026 Restaurant Menu. All rights reserved.</p>
    </footer>

    
        
</body>
</html>