<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="/WEB-INF/my-custom-tlds/ct.tld" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CS472-WAP-Lab 12 - Implementing and using a Custom JSP Tag</title>
<%--    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css" rel="stylesheet" integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous">--%>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css" rel="stylesheet" integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@include file="fragments/header.html"%>

    <div class="container">
        <p>&nbsp;</p>
        <h1 class="display-3">Hello JSP: Model 2 Architecture (a.k.a MVC) with Custom Tag</h1>

        <hr class="my-4">

        <p>
            <c:if test="${true}">
                <span>Using &lt;ct:CurrentDate /&gt;, today's Date is: </span><ct:currDate color="red" size="18px" /><br/>
                <span>Using &lt;ct:CurrentTime /&gt;, the Time now at the AppServer is: </span><ct:currTime color="green" size="20px" />
            </c:if>
        </p>
        <p>Model 2 Architecture (also known as <b>Model-View-Controller (MVC) architecture</b>) suggests using
            Servlet as a <em>Controller</em> component and JSP as <em>View</em>.
            While the <em>Model</em> will consist of one or more Java Bean classes, representing the
            application's data.
        </p>
        <p>&nbsp;</p>

        <p class="lead">
            <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
        </p>

    </div>

    <%@include file="fragments/footer.html"%>

</body>
</html>

