<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
  background-image:url("https://www.cidrap.umn.edu/sites/default/files/public/styles/ss_media_popup/public/media/article/white_pills_on_blue-marco_verch.jpg?itok=xaMmTBg7");
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: 100% 100%;
}
.navbar {
  overflow: hidden;
    background-color: darkgray;
    border-radius: 15px;
    }

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: right;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 15px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}
section
{
background-color: ghostwhite;
    padding: 35px 35px 247px 36px;
    margin-top: inherit;
    border-radius: 18px;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>
<body>
	<div class="navbar">
  <a href="home.jsp">Home</a>
  <div class="dropdown">
    <button class="dropbtn">MY ACCOUNT 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="details.jsp">Details</a>
      <a href="logout.jsp">logout</a>
    </div>
  </div> 
</div>
<section>
<p> <%
Assignclass.tabledetails	td=new Assignclass.tabledetails();
String s=(String)request.getSession().getAttribute("na");
td.setUser(s);
Assignclass.Tabledetailsdao	tdd=new Assignclass.Tabledetailsdao();
td=tdd.retrive(td);
%>
<center>DETAILS</center>
<p>First Name       :<% out.print(td.getFn());%></p><br>
<p>Second Name      :<% out.print(td.getSn()); %></p><br>
<p>Email            :<% out.print(td.getEmail());%></p><br>
<p>Phone Number     :<% out.print(td.getPhone());%></p><br>
</section>
</body>
</html>