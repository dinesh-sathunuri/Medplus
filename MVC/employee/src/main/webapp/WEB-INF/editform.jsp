<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/form/editsave" modelAttribute="employee"  method="post">  
		<form:hidden path="id"/>
        Salary<form:input path="salary"/>
        <br><br>
        <input type="submit" value="save">  
</form:form>
</body>
</html>