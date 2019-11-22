<%--
  Created by IntelliJ IDEA.
  User: mandu
  Date: 11/19/2019
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Food Form</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/manduul.css">

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="fragments/header.jsp" %>
<div class="container">
    <div style="margin-top: 100px;">
        <img src="${pageContext.request.contextPath}/upload?imageId=${food.image_id}" id="foodImage" height="300" width="300"/>
        <%@ include file="upload.jsp" %>
    </div>
    <form style="margin-top: 22px;" action="food" method="POST">
        <div class="form-group">
            <label for="name">Food Name</label>
            <input type="text" class="form-control" id="name" name="foodName" placeholder="Food Name"
                   value="${food.name}">
        </div>
        <div class="form-group">
            <label for="calories">Calories</label>
            <input type="text" class="form-control" id="calories" name="calories" value="${food.calories}"
                   onkeypress="return isNumberKey(event)" placeholder="Calories">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" id="price" name="price" value="${food.price}"
                   onkeypress="return isDecimalKey(event)" placeholder="Price">
        </div>
        <div class="form-group">
            <label for="foodType">Food Type</label>
            <select class="form-control" id="foodType" name="foodType">
                <option
                        <c:if test="${food.type eq 'Keto'}">
                            <c:out value=" selected "/>
                        </c:if>>Keto
                </option>
                <option
                        <c:if test="${food.type eq 'Vegetarian'}">
                            <c:out value=" selected "/>
                        </c:if>>Vegetarian
                </option>
                <option
                        <c:if test="${food.type eq 'Gluton free'}">
                            <c:out value=" selected "/>
                        </c:if>>Gluton free
                </option>
                <option
                        <c:if test="${food.type eq 'Paleo'}">
                            <c:out value=" selected "/>
                        </c:if>>
                    Paleo
                </option>
                <option
                        <c:if test="${food.type eq 'Free Style'}">
                            <c:out value=" selected "/>
                        </c:if>>Free Style
                </option>
            </select>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3" >${food.description}</textarea>
        </div>
        <input id="image" name="image" value="${food.image_id}" style="visibility: hidden">
        <input name="foodID" value="${food.foodId}" style="visibility: hidden">
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>

<script>
    function isNumberKey(evt) {
        var charCode = (evt.which) ? evt.which : evt.keyCode
        if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;
        return true;
    }

    function isDecimalKey(evt) {
        var charCode = (evt.which) ? evt.which : evt.keyCode
        if (charCode > 31 && (charCode != 46 && (charCode < 48 || charCode > 57)))
            return false;
        return true;
    }
</script>
