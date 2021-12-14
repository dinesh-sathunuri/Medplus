package Assignment;
import java.util.*;
import java.util.Map.Entry;
public class Employeeoperation1 {
	Map<Integer,Employee> empDetail = new TreeMap<Integer,Employee>();
	Map<String,Employee> deptWiseEmpDetail = new TreeMap<String,Employee>();
	public void addemployee(int empid,String name,String email,String dep,long sal)
	{
		int c=0;
		for(Map.Entry<Integer,Employee> entry:empDetail.entrySet())    
	        if(entry.getKey()==empid)
	        	c=1;
	       if(c==0)
	       {
		Employee e= new Employee(empid,name,dep,email,sal);
		empDetail.put(empid,e);
		deptWiseEmpDetail.put(dep,e);
		System.out.println("ADDED");
	       }
	       else
	    	   System.out.println("Id already Taken");
	}
	public void getemployee(int id)
	{
		int c=0;
		System.out.println("ID\tNAME\tEMAIL\t\tDEPT\tSALARY");
		for(Map.Entry<Integer, Employee> entry:empDetail.entrySet()){     
			Employee b=entry.getValue();  
			if(b.empid==id)
			{
				c=1;
	        System.out.println(b.empid+"\t"+b.name+"\t"+b.email+"\t"+b.dept+"\t"+b.salary);   
	    }  
	}
		
		if(c==0)
			System.out.println("Id not Found");
	}
	@SuppressWarnings("unlikely-arg-type")
	void removeemployee(int id)
	{
		int c=0;
		for(Map.Entry<Integer,Employee> entry:empDetail.entrySet())    
	        if(entry.getKey()==id)
	        	c=1;
	       if(c==1)
	       {
		empDetail.remove(id);
		deptWiseEmpDetail.remove(id);
		System.out.println("REMOVED");
	       }
	       else
	       {
	    	   System.out.println("Id not Found");
	       }
	}
	
	void getEmployeeDetailsByDept(String dp)
	{
		
		Set<Entry<Integer,Employee>> entrySet = empDetail.entrySet();
		
		List<Map.Entry<Integer,Employee>> list = new ArrayList<>(entrySet);
		
		Collections.sort(list, (o1, o2) -> o1.getValue().getEmployeeName().compareTo(o2.getValue().getEmployeeName()));
		
		list.forEach(b->{
			if(b.getValue().dept.compareTo(dp)==0)
			System.out.println(b.getKey()+"\t"+b.getValue().name);
			});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner sc1 =new Scanner(System.in);
		int id,choice;
		String name,email,dep;
		Long sal;
		Employeeoperation1 obj=new Employeeoperation1();
		while(true)
		{
			System.out.print("1.Addemployee\n2.GetEmployee\n3.RemoveEmployee\n4.Getemployeebydept\n5.Exit\nEnter your choice :");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:System.out.print("Enter id and name :");
				id=sc.nextInt();		
				name=sc1.nextLine();
				System.out.print("Enter sal and email :");
				sal=sc.nextLong();
				email=sc1.nextLine();
				System.out.print("Enter dep :");
				dep=sc1.nextLine();
				obj.addemployee(id,name,email,dep,sal);
				break;
			case 2:System.out.print("Enter the id");
				int id2=sc.nextInt();
				obj.getemployee(id2);
				break;
			case 3:System.out.print("Enter the id");
					id=sc.nextInt();
				obj.removeemployee(id);
				break;
			case 4:System.out.print("Enter the dp");
			String dp=sc1.nextLine();
				obj.getEmployeeDetailsByDept(dp);
			break;
			case 5:sc.close();
					sc1.close();
					System.exit(0);
			default:System.out.println("With in the choice only");
			}	
		}
		
	}
}
