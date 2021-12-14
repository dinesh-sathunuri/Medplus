package Assignclass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException; 
public class Tabledetailsdao {
	public int check(tabledetails td) throws ClassNotFoundException//Checking login from mysql
	{
		int count=0;
		Class.forName("com.mysql.jdbc.Driver");
		try
		{
			
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/dinesh","root","dinesh700");  
			
			String query="Select * from details where username=? and password=MD5(?)";
			
			PreparedStatement prst=con.prepareStatement(query);
			prst.setString(1, td.getUser());
			prst.setString(2, td.getPass());
			ResultSet rs=prst.executeQuery();
			if(rs.next()) 
			{
				count++;
			}
		}catch(Exception e)
		{
			System.out.print(e);
		}
		return count;
		
	}
	public int insert(tabledetails td) throws ClassNotFoundException, FileNotFoundException, ScriptException, NoSuchMethodException//inserting into mysql from register  
	{
		
		int count=0;
		
			
		Class.forName("com.mysql.jdbc.Driver");
		try
		{
			Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/dinesh","root","dinesh700");  
		PreparedStatement stm= con.prepareStatement("insert into details values(?,?,?,?,?,MD5(?))");
		String user=td.getUser();
		String pass=td.getPass();
		stm.setString(1,td.getFn());
		stm.setString(2,td.getSn());
		stm.setString(3,td.getEmail());
		stm.setString(4,td.getPhone());
		stm.setString(5,user);
		stm.setString(6,pass);
		count=stm.executeUpdate();
		con.close();
		stm.close();
		
		}catch(Exception e)
		{
			System.out.print(e);
		}
		return count;
		}
	public tabledetails retrive(tabledetails td) throws ClassNotFoundException//Showing the details from Mysql
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		try
		{
			Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/dinesh","root","dinesh700");  
			String user=td.getUser();
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select firstname,secondname,email,phoneno,username from details");
			while(rs.next())
			{
				if(rs.getString(5).equals(user))
				{
			td.setFn(rs.getString(1));
			td.setSn(rs.getString(2));
			td.setEmail(rs.getString(3));
			td.setPhone(rs.getString(4));
			break;
				}
			}
		con.close();
		stm.close();
		
		}catch(Exception e)
		{
			System.out.print(e);
		}
		return td;
	}
	}

