<%--
  Created by IntelliJ IDEA.
  User: tuvsh
  Date: 11/14/2019
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Contact App</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <form id="formCustomerContact" method="post" action="process-contact-form">
        <fieldset>
            <legend>Customer Contact Form</legend>
            <div>
                <c:forEach var="error" items="${errMsgs}">
                    <p><span style="color:red;font-size:1em"><c:out value="${error}"/></span></p>
                </c:forEach>
            </div>
            <div class="form-group">
                <label for="customerName">*Name:</label>
                <input type="text" class="form-control" id="customerName" name="customerName"
                       aria-describedby="customerNameHelp"
                       placeholder="e.g. John Smith"
                       title="Enter your full name"
                       value="${param.customerName}">
                <small id="customerNameHelp" class="form-text text-muted">Enter your full name.</small>
            </div>
            <label>*Gender:</label><br/>
            <label class="custom-control custom-radio">
                <input id="radioGenderMale" name="radioGender" type="radio" class="custom-control-input" value="male"
                        <c:if test="${param.radioGender eq 'male'}">
                            <c:out value=" checked"/>
                        </c:if>
                />
                <span class="custom-control-indicator"></span>
                <span class="custom-control-description">Male</span>
            </label>
            <label class="custom-control custom-radio">
                <input id="radioGenderFemale" name="radioGender" type="radio" class="custom-control-input"
                       value="female"
                        <c:if test="${param.radioGender eq 'female'}">
                            <c:out value=" checked"/>
                        </c:if>/>
                <span class="custom-control-indicator"></span>
                <span class="custom-control-description">Female</span>
            </label>
            <div class="form-group">
                <label for="ddlCategory">*Category:</label>
                <select class="form-control" id="ddlCategory" name="ddlCategory">
                    <option value="null">Select...</option>
                    <option value="feedback"
                            <c:if test="${param.ddlCategory eq 'feedback'}">
                                <c:out value=" selected "/>
                            </c:if>
                    >Feedback
                    </option>
                    <option value="inquiry"
                            <c:if test="${param.ddlCategory eq 'inquiry'}">
                                <c:out value=" selected "/>
                            </c:if>
                    >Inquiry
                    </option>
                    <option value="complaint"
                            <c:if test="${param.ddlCategory eq 'complaint'}">
                                <c:out value=" selected "/>
                            </c:if>
                    >Complaint
                    </option>
                </select></div>
            <div class="form-group">
                <label for="message">*Message:</label>
                <textarea class="form-control" id="message" name="message" rows="3"></textarea>
            </div>
            <button id="btnSubmit" type="submit" class="btn btn-primary btn-block">Submit</button>
        </fieldset>
    </form>
</div>
<div class="container"><br/><br/>
    <span class="text-muted">Hit Count for this page: ${hitCount} </span>
    <span style="float:right;" class="text-muted">Total Hit Count for the entire WebApp: ${counter}</span>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>