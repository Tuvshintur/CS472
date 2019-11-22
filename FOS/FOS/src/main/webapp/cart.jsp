<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if
	test="${sessionScope.cart ne null and sessionScope.cart.size() gt 0}">
	<div style="padding: 15px;">
		<h2>My Cart Items</h2>
		<table cellpadding="2" cellspacing="2" border="0">
			<tr>
				<th></th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Sub total</th>
			</tr>
			<c:set var="total" value="0" scope="session" />
			<c:forEach var="item" items="${sessionScope.cart}">
				<c:set var="total"
					value="${total + item.food.price * item.quantity}" />
				<tr>
					<td align="center"><a
						onclick="addtocart(event,${item.food.foodId},'delete')" href="#"
						class="delete">x</a></td>
					<td>${item.food.name}</td>
					<td>$${item.food.price}</td>
					<td>${item.quantity}</td>
					<td>$${item.food.price * item.quantity}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="right" class="total">$${total}</td>
			</tr>
		</table>
		<a href="checkout" class="checkout">Check out</a>
	</div>
</c:if>