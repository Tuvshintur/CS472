<%--
  Created by IntelliJ IDEA.
  User: mandu
  Date: 11/19/2019
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Page</title>
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/manduul.css">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="my-4">Welcome to Admin Panel asd asd</h1>

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-4 mb-4">
                <div class="card h-100">
                    <h4 class="card-header">Food Order</h4>
                    <div id="accordion">
                        <div class="card">
                            <c:forEach items="${orderList}" var="order" varStatus="loop">
                                <div class="card-header" id="${loop.index+1}">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            Order #${order.orderId}
                                        </button>
                                        <button type="button" class="order-btn btn status-btn btn-outline-success" order-id="${order.orderId}">Success</button>
                                    </h5>
                                </div>
                                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                                    <div class="card-body">
                                        <ul class="list-group list-group-flush">
                                            <c:forEach items="${order.getFoods()}" var="food" varStatus="loop">
                                                <li class="list-group-item">
                                                    <p><c:out value="${food.name}" /> | <c:out value="${food.calories}" /> calories</p>
                                                    <p style="color: grey;"><c:out value="${food.type}" /> type</p>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="user-table-container">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user" varStatus="loop">
                        <tr>
                            <td scope="row"><c:out value="${loop.index+1}" /></td>
                            <td><c:out value="${user.first_name}" /></td>
                            <td><c:out value="${user.last_name}" /></td>
                            <td><c:out value="${user.email}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-12 mb-4">
                <div class="card h-100">
                    <h4 class="card-header">Food List</h4>
                    <a href="food.jsp">
                        <button type="button" class="btn btn-primary" style="width: 100%;">Add New</button>
                    </a>
                    <div class="card-body">
                        <ul class="list-group">
                            <c:forEach items="${foodList}" var="food" varStatus="loop">
                                <li food-id="${food.foodId}" class="list-group-item d-flex justify-content-between align-items-center">
                                    <div style="max-width: 80%;">
                                        <p>Name : <c:out value="${food.name}" /></p>
                                        <p>Description : <c:out value="${food.description}" /></p>
                                    </div>
                                    <div>
                                        <form method="POST" action="editFood" id="button-form" style="display: inline-block;">
                                            <input value="${food.foodId}" name="foodID" style="visibility: hidden;width:50px;">
                                            <button type="submit" class="btn m-btn food-edit"><i class="fa fa-edit"></i></button>
                                        </form>
                                        <form method="POST" action="deleteFood" style="display: inline-block;width:50px;">
                                            <input value="${food.foodId}" name="foodID" style="visibility: hidden;">
                                            <button type="submit" class="btn m-btn food-delete"><i class="fa fa-close"></i></button>
                                        </form>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="card-footer">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<script>
    $(document).ready(function () {
        $('.status-btn').on('click', function () {
            console.log($(this).attr('order-id'));
            $.ajax({
                url: "${pageContext.request.contextPath}/orderStatus?orderId="+$(this).attr('order-id'),
                type: "POST",
                data: {
                    orderId: $(this).attr('order-id')
                },
                contentType: false,
                cache: false,
                processData: false,
                success: function (data) {
                    console.log(data);
                    if(data == "okay")  window.location.replace("${pageContext.request.contextPath}/admin");
                },
                error: function(error) {
                    console.log(error);
                }
            });
        })
    });
</script>


