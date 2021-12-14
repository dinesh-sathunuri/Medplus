package com.form;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;




public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
	public int insert(Employee e) {
		// TODO Auto-generated method stub
		int id=0;
		id=e.getId();
		if(id!=0)
		{
		String query="insert into employee values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,e.getId(),e.getFirstname(),e.getGender(),e.getDateofbirth(),e.getDateofjoining(),e.getSalary(),e.getDepartmentid());
		return 1;
		}
		else
		{
			String query="insert into employee(name,gender,dob,doj,salary,deptid) values(?,?,?,?,?,?)";
			jdbcTemplate.update(query,e.getFirstname(),e.getGender(),e.getDateofbirth(),e.getDateofjoining(),e.getSalary(),e.getDepartmentid());
			return 1;
		}
	}
	public List show() {
		// TODO Auto-generated method stub
		
		String query="select * from employee";
		return jdbcTemplate.query(query,new ResultSetExtractor<List<Employee>>() {

			public List<Employee> extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Employee>employee = new ArrayList<Employee>();
				 while(rs.next()){ 
				Employee e =new Employee();
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setDateofbirth(rs.getString(4));
				e.setDateofjoining(rs.getString(5));
				e.setSalary(rs.getInt(6));
				e.setDepartmentid(rs.getInt(7));
				employee.add(e);
			}
				 return employee;
			}
			
		} );
	}
	public int update(Employee e) {
		// TODO Auto-generated method stub
		String query="update employee set salary=? where id=?";
		return jdbcTemplate.update(query,e.getSalary(),e.getId());
		
	}
	public int delete(int id) {
		// TODO Auto-generated method stub
		String query="delete from employee where id=?";
		return jdbcTemplate.update(query,id);
	}
	public List showid(final int id)
	{
		String query="select * from employee";
		final List<Employee> employee=new ArrayList<Employee>();
		jdbcTemplate.query(query, new RowCallbackHandler(){
			
			public void processRow(ResultSet rs) throws SQLException {
				if(rs.getInt(1)==id)
				{
				Employee e =new Employee();
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setDateofbirth(rs.getString(4));
				e.setDateofjoining(rs.getString(5));
				e.setSalary(rs.getInt(6));
				e.setDepartmentid(rs.getInt(7));
				employee.add(e);
				}
			}
			
		});
		return employee;
		
	}
	public void Batchinsert(final List<Employee> employee) {
		// TODO Auto-generated method stub
		 String SQL = "insert into employee(name,gender,dob,doj,salary,deptid) values(?,?,?,?,?,?)";
	      int[] updateCounts = jdbcTemplate.batchUpdate(SQL,new BatchPreparedStatementSetter() {
	       
	         public void setValues(PreparedStatement ps, int i) throws SQLException {
	            ps.setString(1, employee.get(i).getFirstname());
	            ps.setString(2,employee.get(i).getGender());
	            ps.setString(3, employee.get(i).getDateofbirth());
	            ps.setString(4,employee.get(i).getDateofjoining());
	            ps.setInt(5,employee.get(i).getSalary());
	            ps.setInt(6, employee.get(i).getDepartmentid());
	         }
	         public int getBatchSize() {
	            return employee.size();
	         }
	      }); 
		
	}
	public List showwithdepart()
	{
		String query="select emp.*,d.name,emp1.name from employee emp inner join department d on emp.deptid=d.deptid inner join employee emp1 on emp1.id=d.hodid";
		final List<Employee> employee=new ArrayList<Employee>();
		return jdbcTemplate.query(query,new ResultSetExtractor<List<Employee>>()
				{

					public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						while(rs.next())
						{
							Employee e =new Employee();
							e.setId(rs.getInt(1));
							e.setFirstname(rs.getString(2));
							e.setGender(rs.getString(3));
							e.setDateofbirth(rs.getString(4));
							e.setDateofjoining(rs.getString(5));
							e.setSalary(rs.getInt(6));
							e.setDepartmentid(rs.getInt(7));
							e.setDepartmentname(rs.getString(8));
							e.setHodname(rs.getString(9));
							employee.add(e);
						}
						return employee;
						
					}
			
				});
		
	}
	public void Batchupdate(final List<Employee> employee) {
		// TODO Auto-generated method stub
		 String SQL = "update employee set salary = ? where id = ?";
	      int[] updateCounts = jdbcTemplate.batchUpdate(SQL,new BatchPreparedStatementSetter() {
	         
	         public void setValues(PreparedStatement ps, int i) throws SQLException {
	            ps.setInt(1, employee.get(i).getSalary());						
	            ps.setInt(2, employee.get(i).getId());
	         }
	         public int getBatchSize() {
	            return employee.size();
	         }
	      }); 
		
	}
	public Map<String,Integer> Batchsalary()
	{
		String query="select d.name,sum(emp.salary) from employee emp join department d on emp.deptid=d.deptid group by d.name";
		final Map<String,Integer> employee=new HashMap();
		return jdbcTemplate.query(query,new ResultSetExtractor<Map<String,Integer>>() {

			public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				while(rs.next())
				{
					employee.put(rs.getString(1), rs.getInt(2));
				}
				return employee;
			}
		});
	}
	public Map<String,Integer> Batchemployee()
	{
		String query="select emp1.name,count(emp.id)-1 as Hodname from employee emp inner join department d on emp.deptid=d.deptid inner join employee emp1 on emp1.id=d.hodid group by emp1.name";
		final Map<String,Integer> employee=new HashMap();
		return jdbcTemplate.query(query,new ResultSetExtractor<Map<String,Integer>>() {

			public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				while(rs.next())
				{
					
					employee.put(rs.getString(1),rs.getInt(2));
					
				}
				return employee;
			}
		});
	}
	public List Employeesalary(int salary)
	{
		String query="select emp.*,d.name,emp1.name from employee emp inner join department d on emp.deptid=d.deptid and emp.salary<? inner join employee emp1 on emp1.id=d.hodid";
		return jdbcTemplate.query(query, new Object[] {salary},new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Employee e =new Employee();
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setDateofbirth(rs.getString(4));
				e.setDateofjoining(rs.getString(5));
				e.setSalary(rs.getInt(6));
				e.setDepartmentid(rs.getInt(7));
				e.setDepartmentname(rs.getString(8));
				e.setHodname(rs.getString(9));
				return e;
				
			}
		});
		
	}
	public Employee employesalarybyid(int id)
	{
		String query="select salary from employee where id =?";
		
		return jdbcTemplate.queryForObject(query, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	public List employedojbyid(int id)
	{
		String query="select doj from employee where id =?";
		
		return jdbcTemplate.query(query,new Object[] {id}, new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee e=new Employee();
				e.setDateofjoining(rs.getString(1));
				return e;
			}

			
		});	
	}
	public List employehodbyid(int id)
	{
		String query="select emp1.name as Hodname from employee emp1 inner join department d on d.deptid=? and emp1.id=d.hodid;";
		
		return jdbcTemplate.query(query,new Object[] {id}, new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee e=new Employee();
				e.setHodname(rs.getString(1));
				return e;
			}

			
		});	
	}
	public List employedetailsbyid(int id)
	{
		String query="select * from employee where id =?";
		
		return jdbcTemplate.query(query,new Object[] {id}, new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setDateofbirth(rs.getString(4));
				e.setDateofjoining(rs.getString(5));
				e.setSalary(rs.getInt(6));
				e.setDepartmentid(rs.getInt(7));
				return e;
			}

			
		});	
	}
	public List<Employee> getEmpjoinDate(String date1,String date2) throws ParseException {
		// TODO Auto-generated method stub
		String query="select emp.*,d.name as departmentname,emp1.name as Hodname from employee emp inner join department d on emp.deptid=d.deptid and date(emp.doj) between ? and  ? inner join employee emp1 on emp1.id=d.hodid";
		Date date11=(Date) new SimpleDateFormat("yyyy/MM/dd").parse(date1);
		Date date111=(Date) new SimpleDateFormat("yyyy/MM/dd").parse(date2);
		return jdbcTemplate.query(query,new Object[] {date11,date111},new RowMapper<Employee>() {

					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Employee e =new Employee();
						e.setId(rs.getInt(1));
						e.setFirstname(rs.getString(2));
						e.setGender(rs.getString(3));
						e.setDateofbirth(rs.getString(4));
						e.setDateofjoining(rs.getString(5));
						e.setSalary(rs.getInt(6));
						e.setDepartmentid(rs.getInt(7));
						e.setDepartmentname(rs.getString(8));
						e.setHodname(rs.getString(9));
						return e;
					}
			});
	}
}
