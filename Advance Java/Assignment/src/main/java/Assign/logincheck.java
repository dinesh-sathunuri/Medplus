package Assign;
import java.io.IOException;

import Assignclass.Tabledetailsdao;
import Assignclass.tabledetails;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/inside")

public class logincheck extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
	String na =	req.getParameter("name");
	String pa=req.getParameter("password");
	tabledetails td =new tabledetails();
	td.setUser(na);
	td.setPass(pa);
	int count=0;
	Tabledetailsdao	tdd=new Tabledetailsdao();
	try {
		 count=tdd.check(td);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(count==1)
	{
		HttpSession s=req.getSession();
		s.setAttribute("na", na);
		res.sendRedirect("home.jsp");
		
	}
	else
	{
		res.sendRedirect("login.jsp");
	}
	}
	

}
