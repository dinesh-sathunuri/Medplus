package com.medplus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.form.Employee;
import com.form.EmployeeDao;
@Service("empsc")
public class Employeeservice {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");  
	EmployeeDao empdao = (EmployeeDao) ctx.getBean("edao");
	public int submit(Employee rs)
	{
		return empdao.insert(rs);
	}
	public List<Employee> view()
	{
		
		List<Employee>employee=empdao.show();
		return employee;
	
	}
	public int delete(int id)
	{
		return empdao.delete(id);
		
	}
	public Employee salary(int id)
	{
		return empdao.employesalarybyid(id);
	}
	public int update(Employee e)
	{
		return empdao.update(e);
	}
	

}
