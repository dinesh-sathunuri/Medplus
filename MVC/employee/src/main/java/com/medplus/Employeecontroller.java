package com.medplus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.form.Employee;
import com.form.EmployeeDao;


@Controller()
public class Employeecontroller {
	
	@Autowired
	Employeeservice empsc;
	@RequestMapping("/reservation")
	public ModelAndView reservation()
	{
		ModelAndView mv=new ModelAndView();
		Employee rs=new Employee();
		mv.addObject("reservation", rs);
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("/submit")
	public ModelAndView submit(@ModelAttribute("reservation") Employee rs)
	{
		ModelAndView mv= new ModelAndView();

		if(empsc.submit(rs)==1)
		{
		mv.setViewName("redirect:/view");
		return mv;
		}
		else
		{
		mv.setViewName("index");
		return mv;
		}
	}
	@RequestMapping("/view")
	public ModelAndView view()
	{
		
		ModelAndView mv=new ModelAndView();
		List<Employee>employee=empsc.view();
		mv.addObject("employee", employee);
		mv.setViewName("show");
		return mv;
		
	}
	 @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
	public ModelAndView delete(@PathVariable int id)
	{
		 ModelAndView mv=new ModelAndView();
		 if(empsc.delete(id)==1)
			{
				List<Employee>employee=empsc.view();
				mv.addObject("employee", employee);
				mv.setViewName("redirect:/view");
				return mv;
			}
			else
			{
				mv.setViewName("show");
			return mv;
			}
	}
	 @RequestMapping(value="/editemp/{id}",method = RequestMethod.GET)
	 public ModelAndView edit(@PathVariable int id)
	 {
		 ModelAndView mv=new ModelAndView();
		 Employee emp=new Employee();
		 emp=empsc.salary(id);
		 emp.setId(id);
		 mv.addObject("employee", emp);
		 mv.setViewName("editform");
		return mv;
	 }
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)
	 public ModelAndView editsave(@ModelAttribute("employee") Employee emp)
	 {
 ModelAndView mv=new ModelAndView();
		 
		 if(empsc.update(emp)==1)
		 {
			 mv.setViewName("redirect:/view");
			 return mv;
		 }
		 else
		 {
			 mv.setViewName("editform");
			 return mv;
		 }
	 }
	 
}
