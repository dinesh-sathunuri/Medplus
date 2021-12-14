<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<body>
 <form:form action="submit" modelAttribute="reservation">  
        First name: <form:input path="firstname" />         
        <br><br>  
        Gender:   
        Male <form:radiobutton path="gender" value="Male"/>  
        Female <form:radiobutton path="gender" value="Female"/>  
        <br><br>  
        Date of Birth
        <form:input type="date" path="dateofbirth"/><br><br>
         Date of Joining<form:input type="date" path="dateofjoining"/><br><br>
         Salary<form:input path="salary" /><br><br>
        
       Department:<form:select path="departmentid">  
        <form:option value="1" label="Software"/>  
        <form:option value="2" label="Accounts"/>  
        <form:option value="3" label="CallCenter"/>  
        <form:option value="4" label="HR"/>  
        </form:select><br><br>  
         
<input type="submit" value="submit">
 </form:form>  
</body>
</html>
