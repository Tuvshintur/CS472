<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CS472-WAP-Lab 12 - Implementing and using a Custom JSP Tag</title>
<%--  <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css" rel="stylesheet" integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous">--%>
  <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css" rel="stylesheet" integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

  <%@include file="fragments/header.html"%>

  <div class="container">
    <div class="jumbotron">
      <h1 class="display-3">Hello, Servlet 4.0, JSP 2.3 with Custom Tags!</h1>
      <h3>Welcome to Lab 12 Solution - implements Custom JSP Tags named, &lt;ct:CurrentDate /&gt; and &lt;ct:CurrentTime /&gt;</h3>
      <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
      <hr class="my-4">
      <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
      <p class="lead">
        <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
      </p>
    </div>
  </div>

  <%@include file="fragments/footer.html"%>

</body>
</html>
