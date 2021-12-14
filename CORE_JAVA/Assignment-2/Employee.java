package Assignment;

public class Employee {
	int empid;
	String name,dept,email;
	long salary;
	public Employee(int id,String nam,String dep,String emai,Long sal) {
		// TODO Auto-generated constructor stub
		this.dept=dep;
		this.email=emai;
		this.empid=id;
		this.name=nam;
		this.salary=sal;
	}
	public String getEmployeeName() {
		// TODO Auto-generated method stub
		return name;
	}

}
