create schema assignment;
use assignment;
create table Depart(Departmentid integer(10) primary key auto_increment,
Departmentname varchar(10) not null,
Datecreated timestamp not null,
createdby varchar(10) not null default "dinesh"
);

create table employee(employeeid integer(10) primary key auto_increment,
employeename varchar(10) not null ,
Gender varchar(1) not null,
DOB date not null,
phoneno integer(10) not null,
salary integer(10) not null,
Datecreated timestamp not null,
Createdby varchar(10) not null,
Datemodified timestamp default null,
Datemodifiedby  varchar(10) default null
);
create table mapping(employeeid integer(10),
departmentid integer(10),
foreign key(departmentid) references Depart(Departmentid),
foreign key(employeeid) references employee(employeeid));
insert into depart(Departmentid,Departmentname,Datecreated)
 values(1,"Aero",now());
insert into depart(Departmentname,Datecreated)
 values("CSE",now());
insert into depart(Departmentname,Datecreated)
 values("ECE",now());
insert into depart(Departmentname,Datecreated)
 values("MECH",now());
 alter table employee
 alter createdby set default "Dinesh";
 
insert into employee(employeeid,employeename,Gender,
DOB,phoneno,salary,Datecreated)
values
(1,"aashrith","m","1999-08-02",800848883,
10000,now()); 
insert into employee(employeename,Gender,
DOB,phoneno,salary,Datecreated)
values
("pavani","f","1999-08-16",800848883,
10000,now()); 
insert into employee(employeename,Gender,
DOB,phoneno,salary,Datecreated)
values
("mohith","m","1999-05-12",800848883,
10000,now()); 
insert into employee(employeename,Gender,
DOB,phoneno,salary,Datecreated)
values
("shantan","m","1999-04-23",800848883,
10000,now()); 
insert into employee(employeename,Gender,
DOB,phoneno,salary,Datecreated)
values
("shravani","f","1999-08-12",800848883,
10000,now()); 
insert into employee(employeename,Gender,
DOB,phoneno,salary,Datecreated)
values
("Dinesh","m","1999-08-29",800848883,
10000,now()); 
insert into employee(employeename,Gender,
DOB,phoneno,salary,Datecreated)
values
("sundar","m","1999-07-30",800848883,
10000,now()); 
select * from employee;
select * from depart;
 update employee set salary =20000
 where employeeid=6;
 update employee set salary =20000
 where employeeid=5;
 update employee set salary =15000
 where employeeid=1;
  update employee set salary =20000
 where employeeid=4;
 insert into mapping values(1,1);
 insert into mapping values(2,1);
 insert into mapping values(3,2);
 insert into mapping values(4,2);
 insert into mapping values(5,3);
 insert into mapping values(6,4);
 insert into mapping values(7,3);
 select * from mapping;
 select count(employeeid) As count_employee,
 depart.Departmentname 
 from depart inner join 
 mapping
 on mapping.departmentid=depart.Departmentid
 group by depart.Departmentid;
 
 select max(salary) As salary,depart.departmentname  from
 mapping inner join
 depart inner join
 employee
 on mapping.departmentid=depart.Departmentid and
 mapping.employeeid=employee.employeeid
 group by depart.Departmentname;
 
 
 
 select employee.* from employee inner join depart inner join mapping
on mapping.departmentid=depart.Departmentid and
 mapping.employeeid=employee.employeeid
order by employee.salary desc
limit 3;


select Departmentname,avg(salary) As averagesalary
 from  employee inner join depart inner join
 mapping
 on 
 mapping.departmentid=depart.Departmentid and
 mapping.employeeid=employee.employeeid
 group by Departmentname
 having avg(salary)>=10000;
 
