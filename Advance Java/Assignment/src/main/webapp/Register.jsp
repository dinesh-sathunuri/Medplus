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
form
{
       padding: 14px 505px 0px 531px;
    border-radius: 25px;
}
.reg{
	padding: 11px 62px 13px 7px;
    font-size: 15px;
    line-height: 15px;
    border-radius: 4px;
    border-width: 1px;
    border-top-width: 1px;
    border-right-width: 1px;
    border-bottom-width:1px;
    border-left-width: 1px;
}
.sub
{
    padding: 2px 8px;
    font-size: 15px;
    border-radius: 5px;
    background-color: #4aabff;
}
x
{
color:red;
}
</style>
</head>
<body>
<script type="text/javascript">
function myFunction() {
	  var x = document.getElementById("pass");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
function fun()
{
	var user=document.getElementById("user").value;
	var phone=document.getElementById("phone").value;
	var pass=document.getElementById("pass").value;
	var fn=document.getElementById("fn").value;
	var sn=document.getElementById("sn").value;
	var email=document.getElementById("email").value;
	if(fn.length==0)
		{
		alert("First Name Should not be null ");
		return false;
		}
	if(sn.length==0)
		{
		alert("Second Name Should not be null ");
		return false;
		}
	if(email.length==0)
		{
		alert("Email Should not be null ");
		return false;
		}
	if(phone.length!=10)
		{
		alert("Invalid Phone Number");
		return false;
		}
	if(user.length<10)
		{
		alert("User Name Should be more than 10 char");
		return false;
		}
	if(pass.length<8)
	{
		alert("Password Should be more than 8 char");
		return false;
	}
	alert("After ok You Reload to login then your acount is created,if not your username is already taken ")
	}
</script>
<form action="regi" onsubmit="return fun()" method="post">
<center> <h>Register</h></center><br>
First Name<x>*</x>  : <br><input type="text" name="fn" class="reg" id="fn"><br><br>
Second Name<x>*</x> :<br> <input type="text" name="sn" class="reg" id="sn"><br><br>
Email ID<x>*</x> 	:   <br> <input type="email" name="em" class="reg" id="email"><br><br>
Phone No<x>*</x>    :   <br> <input type="tel" name="pn" class="reg" id="phone" pattern="[0-9]{10}"><br><br>
User Name<x>*</x>   :   <br> <input type="text" name="un" class="reg"  id="user"><br><br>
Password<x>*</x>	:	 <br> <input type="password" name="pw" class="reg" id="pass"><br><br>
<center><input type="checkbox" onclick="myFunction()">Show Password</center><br>
<br><center><input type="submit" class="sub"></center>

</form>
</body>
</html>