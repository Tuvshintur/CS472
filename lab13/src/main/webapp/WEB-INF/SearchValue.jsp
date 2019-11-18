<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CS472 LAB 13</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cosmo/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-uhut8PejFZO8994oEgm/ZfAv0mW1/b83nczZzSwElbeILxwkN491YQXsCFTE6+nx" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">CS472-WAP ::: Lab13</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01"
                aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/lab13/search" method="get">
                <input class="form-control mr-sm-2" type="text" name="searchQuery" placeholder="Search">
                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>
<div class="container">
    <div class="jumbotron">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Email</th>
                <th scope="col">Gender</th>
                <th scope="col">IP address</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="person" items="${list}" varStatus="loop">
                <tr>
                    <th scope="row"><c:out value="${loop.index + 1}"/></th>
                    <td><c:out value="${person.firstName}"/></td>
                    <td><c:out value="${person.lastName}"/></td>
                    <td><c:out value="${person.email}"/></td>
                    <td><c:out value="${person.gender}"/></td>
                    <td><c:out value="${person.ip}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<footer class="footer">
    <div id="footer-content">
        <span class="text-muted">Tuvshintur Batzorig : : : CS472-WAP</span>
        <span style="float:right;" class="text-muted">&copy; November 2019</span>
    </div>
</footer>
</body>
</html>
