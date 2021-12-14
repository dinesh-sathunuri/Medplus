package Assign;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.script.ScriptException;

import Assignclass.Tabledetailsdao;
import Assignclass.tabledetails;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/regi")
public class Checkregi extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter pw=res.getWriter();
		String fn=req.getParameter("fn");
		String sn=req.getParameter("sn");
		String email=req.getParameter("em");
		String phone=req.getParameter("pn");
		String user=req.getParameter("un");
		String pass=req.getParameter("pw");
		tabledetails td =new tabledetails();

		td.setFn(fn);
		td.setSn(sn);
		td.setEmail(email);
		td.setPhone(phone);
		td.setUser(user);
		td.setPass(pass);
		Tabledetailsdao tdd =new Tabledetailsdao();
		int result = 0;
		try {
			result = tdd.insert(td);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==0)
		{
			res.sendRedirect("Register.jsp");
		}
		else
		{
			res.sendRedirect("login.jsp");
		}
	}
}
