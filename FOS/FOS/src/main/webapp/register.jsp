<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Register</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
<body>
<%@ include file="fragments/header.jsp"%>
<div class="container">
    <section class="inner-wrapper">
        <div class="text-center">
            <h1>Connect with foody</h1>
            <p>Join your people. Feed your hunger. Do it all under one
                minute.</p>
        </div>
        ${errorMsg}
        <form name="contactForm" method="post" action="register">
            <div class="row">
                <div class="col-md-12">
                    <label for="name">*Name</label>
                    <input type="name" name="first_name" id="name" class="form-control" required>
                    <label for="email">*Email</label>
                    <input type="email" name="email" id="email" class="form-control" required>
                    <label for="password">*Password</label>
                    <input type="password" name="password" id="password" class="form-control" minlength="5" required>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="agree" onchange="document.getElementById('submitBtn').disabled = !this.checked;">
                        <label class="form-check-label" for="agree">
									<span>I agree with the&nbsp; <a href="/terms-of-use">Terms of use</a>&nbsp; and the&nbsp;
									<a href="/privacy-policy">Privacy Policy</a>
							</span></label>
                    </div>
                </div>
            </div>
            <button id="submitBtn" type="submit"
                    class="btn btn-primary btn-lg btn-block mt40" disabled>Create account</button>
        </form>
        <p class="mt-2 text-center">Already have an account? <a href="login" >Login here</a></p>
    </section>
</div>
<%@ include file="fragments/footer.jsp"%>
<script>
        (function ()  
        	agree.addEventListener("change",function(event){
        		$("#submitBtn").disabled = $(this).checked;
        	});
        })();
    </script>
</body>
</html>