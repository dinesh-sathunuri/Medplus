package Assignclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class tabledetails {
	private String fn,sn,email,phone,user,pass;

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	/*public String encrypt(String mess)
	{
		char[] chars=mess.toCharArray();
		for(char c:chars)
		{
			c+=1;
		}
		mess=chars.toString();
		System.out.print(mess);
		return mess;
	}
	public String dencrypt(String mess)
	{
		char[] chars=mess.toCharArray();
		for(char c:chars)
		{
			c-=1;
		}
		mess=chars.toString();
		
		return mess;
		
	}*/
}
