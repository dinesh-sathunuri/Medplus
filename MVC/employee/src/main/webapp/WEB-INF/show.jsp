<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Gender</th><th>Date of Birth</th><th>Date of Joining</th><th>Salary</th><th>Edit</th><th>Delete</th></tr> 
<c:forEach var="emp" items="${employee}">   
   <tr>  
<%--    <td>${emp.id}</td>   --%>
   <td>${emp.firstname}</td>
   <td>${emp.gender}</td> 
   <td>${emp.dateofbirth}</td> 
   <td>${emp.dateofjoining}</td> 
   <td>${emp.salary}</td>  
<%--    <td>${emp.departmentid}</td>   --%>
   <td><a href="editemp/${emp.id}">Edit</a></td>  
   <td><a href="deleteemp/${emp.id}">Delete</a></td>  
   </tr>  
   </c:forEach>   
   </table>
<a href="reservation">Add Employee</a>
</body>
</html>