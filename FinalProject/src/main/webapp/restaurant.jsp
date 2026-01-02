<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import=" java.util.List , com.tap.Model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub - Restaurant Directory</title>
    <link rel="stylesheet" href="restaurant.css">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="container">
            <div class="nav-content">
                <!-- Logo -->
                <div class="logo">
                    <div class="logo-icon">
                        <i class="fas fa-utensils"></i>
                    </div>
                    <span class="logo-text">FoodHub</span>
                </div>

                <!-- Search Bar -->
                <div class="search-container">
                    <i class="fas fa-search search-icon"></i>
                    <input type="text" class="search-input" placeholder="Search restaurants or cuisines...">
                </div>

                <!-- Right Menu -->
                <div class="nav-menu">
                    <a href="userlogin.jsp" class="nav-link">Sign In</a>
                    <a href="#" class="nav-link">
                        <i class="fas fa-user"></i>
                        <span>Account</span>
                    </a>
                    <a href="#" class="nav-link cart-link">
                        <i class="fas fa-shopping-bag"></i>
                        <span class="cart-badge">0</span>
                    </a>
                </div>
            </div>
        </div>
    </nav>


    <!-- Hero Section -->
    <section class="hero">
        <div class="container">
            <div class="hero-content">
                <h1 class="hero-title">Discover Amazing Restaurants</h1>
                <p class="hero-subtitle">Explore delicious cuisines from around the world, delivered straight to your doorstep</p>
            </div>
        </div>
    </section>
    
     <!-- Restaurant Grid -->
     <main class="main-content">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title">Popular Restaurants</h2>
                <p class="section-subtitle"></p>
            </div>
            
             <div class="restaurant-grid">
           

  
  <%
  List<Restaurant>  allRestaurant   =   (List<Restaurant>)request.getAttribute("allRestaurant");
     for(  Restaurant  restaurant  : allRestaurant)
     {
     %>
    	 
    	 <a href="MenuServlet?restaurantId=<%=restaurant.getRestaurantId() %>">
    	 
    	 
    	    <div class="restaurant-card">
                    <div class="card-image-container">
                        <img src="<%=restaurant.getImagePath() %>" alt="Bella Italia" class="card-image">
                        <span class="status-badge status-open">Open</span>
                        <span class="id-badge"><%=restaurant.getRestaurantId() %></span>
                    </div>
                    <div class="card-content">
                        <div class="card-header">
                            <h3 class="restaurant-name"><%=restaurant.getName() %></h3>
                            <span class="cuisine-badge"><%=restaurant.getCuisineType() %></span>
                        </div>
                        <div class="rating">
                            <i class="fas fa-star star-filled"></i>
                            <i class="fas fa-star star-filled"></i>
                            <i class="fas fa-star star-filled"></i>
                            <i class="fas fa-star star-filled"></i>
                            <i class="fas fa-star star-filled"></i>
                            <span class="rating-text"><%=restaurant.getRating()%></span>
                        </div>
                        <div class="card-info">
                            <i class="fas fa-clock info-icon"></i>
                            <span class="info-text"><%=restaurant.getDeliveryTime() %></span>
                        </div>
                        <div class="card-info">
                            <i class="fas fa-map-marker-alt info-icon"></i>
                            <span class="info-text"><%=restaurant.getAddress() %></span>
                        </div>
                        <div class="card-footer">
                            <i class="fas fa-user-shield admin-icon"></i>
                            <span class="admin-text"><%=restaurant.getAdminUser() %></span>
                        </div>
                    </div>
                </div>
    	 
    	 </a>
    	  
    	 
    	 <%	 
     }
  
  %>
  
  
  

                       
                    </div>
                </div>
                
                
                
            </div>
        </div>
    </main>

  
   
</body>
</html>
    