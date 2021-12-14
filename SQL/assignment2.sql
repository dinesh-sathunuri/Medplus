use assignment;
create table user1(userid integer(10) primary key auto_increment,
name varchar(10) not null,
phoneno varchar(11) unique key,
gender varchar(1) not null,
age integer(4) not null
); 
create table user2(userid integer(10) primary key auto_increment,
name varchar(10) not null,
phoneno varchar(11) unique key,
gender varchar(1) not null,
age integer(4) not null
); 
insert into user1 values(1,"dinesh",8008488833,"m",21);
insert into user1(name,phoneno,gender,age) values("mohit",80084797979,"m",21);
insert into user1(name,phoneno,gender,age) values("shantan",80084797679,"m",21);
insert into user1(name,phoneno,gender,age) values("aashrith",98664797979,"m",21);
insert into user2 values(1,"aashrith",98664797979,"m",21);
insert into user2(name,phoneno,gender,age) values("shantan",80084797679,"m",21);
insert into user2(name,phoneno,gender,age) values("pavan",8098488833,"m",21);
insert into user2(name,phoneno,gender,age) values("shravan",80884797979,"m",21);

select user1.name,user1.phoneno from user1
union
select user2.name,user2.phoneno from user2;

select user1.name,user1.phoneno from user1
union all
select user2.name,user2.phoneno from user2;

select user1.name,user2.phoneno from user2
 inner join
 user1
 on
user2.phoneno=user1.phoneno;