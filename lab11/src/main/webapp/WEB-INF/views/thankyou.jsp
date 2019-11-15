<%--
  Created by IntelliJ IDEA.
  User: tuvsh
  Date: 11/14/2019
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0 , shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Contact App - Thank you!</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css"
          integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="container">
        <span style="float:right;" class="text-muted"><c:out value="${now}"/></span>
    </div>
    <div class="container"><br/>
        <span style="float:right;" class="text-muted"></span>
        <div class="card">
            <div class="card-header">
                <h2>Thank you! Your message has been received as follows:</h2>
            </div>
            <div class="card-body">
                <h4 class="card-title">Name: <c:out value="${param.customerName}"/></h4><br/>
                <h5 class="card-subtitle mb-2 text-muted">Gender: <c:out value="${param.radioGender}"/></h5><br/>
                <h5 class="card-subtitle mb-2 text-muted">Category: <c:out value="${param.ddlCategory}"/></h5><br/>
                <p class="card-text">Message: <c:out value="${param.message}"/></p><br/><br/>
                <p>Please feel free to <a href="contact-form" class="card-link">Contact Us</a> again</p>
            </div>
            <div class="container">
                <span class="text-muted">Hit Count for this page: ${hitCount}</span>
                <span style="float:right; " class="text-muted">Total Hit Count for the entire WebApp: ${counter}</span>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
