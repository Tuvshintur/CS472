<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Login</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<%@ include file="fragments/header.jsp" %>
<div class="container">
    <section class="inner-wrapper">
        <div class="text-center">
            <h1>Connect with foody</h1>
            <p>Feed your hunger. Do it all under one
                minute.</p>
        </div>
        <div style="color:red;">${errorMsg}</div>
        <form name="loginForm" method="post" action="${pageContext.request.contextPath}/login">
            <div class="row">
                <div class="col-md-12">
                    <label for="email">*Email</label>
                    <input type="email" name="email" id="email" class="form-control">
                    <label for="password">*Password</label>
                    <input type="password" name="password" id="password" class="form-control">
                </div>
            </div>
            <button id="submitBtn" type="submit"
                    class="btn btn-primary btn-lg btn-block mt40">Login
            </button>
        </form>
        <p class="mt-2 text-center">Create account? <a href="${pageContext.request.contextPath}/register">Register
            here</a></p>
    </section>
</div>
<%@ include file="fragments/footer.jsp" %>
</body>
</html>