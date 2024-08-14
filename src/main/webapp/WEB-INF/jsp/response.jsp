<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${message}</h3>
<c:if test="${showDetails}">
<p>Employee Details:</p>
    <ul>
        <li>ID: ${employee.id}</li>
        <li>Name: ${employee.name}</li>
        <li>Salary: ${employee.salary}</li>
    </ul>
    </c:if>
    
<c:if test="${showAll}">
<div class="container">
<table class="table">
<thead>
 <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Salary</th>
 </tr>
</thead>
<tbody>
<c:forEach items="${employee}" var="emp">
 <tr>  
     <td>${emp.id}</td>
     <td>${emp.name}</td>
     <td>${emp.salary}</td>
 </tr>
</c:forEach>
</tbody>
</table>
</div>
 </c:if>
    
</body>
</html>