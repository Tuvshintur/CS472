<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.mum.cs.cs472.service.impl.FoodServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order your meals</title>
<!-- Bootstrap stylesheet -->
<link
	href="https://www.spheretheme.com/html/steam/assets/libs/bootstrap-4.0.0-dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- icofont -->
<link href="./css/icofont.css" rel="stylesheet" type="text/css">
<!-- crousel css -->
<link
	href="https://www.spheretheme.com/html/steam/assets/libs/owlcarousel2/assets/owl.carousel.min.css"
	rel="stylesheet" type="text/css">
<!-- Animated Headlines css -->
<link
	href="https://www.spheretheme.com/html/steam/assets/libs/animated-headlines/animated-headlines.css"
	rel="stylesheet" type="text/css">
<!-- mb.YTPlayer css -->
<link
	href="https://www.spheretheme.com/html/steam/assets/libs/mb.YTPlayer/css/jquery.mb.YTPlayer.min.css"
	rel="stylesheet" type="text/css">
<!-- Switch Style css -->
<link
	href="https://www.spheretheme.com/html/steam/assets/switch-style/switch-style.css"
	rel="stylesheet" type="text/css">
<!-- Theme Stylesheet -->
<link href="https://www.spheretheme.com/html/steam/assets/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="fragments/menu.jsp"%>
	<div class="container">
		<%
			FoodServiceImpl foodServiceImpl = new FoodServiceImpl();
		%>
		<table cellpadding="2" cellspacing="2" border="0">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Order</th>
			</tr>
			<c:forEach var="f" items="<%=foodServiceImpl.getAllFood()%>">
				<tr>
					<td>${f.foodId}</td>
					<td>${f.name}</td>
					<td>${f.type}</td>
					<td>${f.price}</td>
					<td align="center"><a href="order?id=${f.foodId}&action=add">Order
							Now</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="menu">
			<div class="row">
				<c:forEach var="f" items="<%=foodServiceImpl.getAllFood()%>">
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="box">
							<div class="image">
								<img src="img/01.jpg" alt="image" title="image"
									class="img-fluid">
							</div>
							<div class="caption">
								<h4>
									<c:out value="${food.name}" />
								</h4>
								<p class="des">
									<c:out value="Type: ${food.type}" />
								</p>
								<p class="des">
									<c:out value="${food.calories} kcal" />
								</p>
								<p class="des">
									<c:out value="Popularity: ${food.order_count} times ordered! " />
								</p>
								<span><c:out value="${food.description}" /></span>
								<div class="price">
									<c:out value="$${food.price}" />
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
</body>
</html>