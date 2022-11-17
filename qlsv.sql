create table class(
classid int not null primary key auto_increment,
classname varchar(60) not null,
startdate datetime not null,
statuss bit
);
create table student (
studentid int not null primary key auto_increment,
studentname varchar (30) not null,
address varchar(50),
phone varchar(50),
statuss bit,
classid int not null,
foreign key(classid) references class (classid)
);
create table subject(
subid int not null primary key auto_increment,
subdname varchar(30) not null,
credit tinyint not null default 1 check (credit>=1),
statuss bit default 1 
);
create table mark(
markid int not null primary key auto_increment,
subid int not null unique ,
studentid int not null unique,
mark float default 0 check (mark between 0 and 100),
examtime tinyint default 1,
foreign key(subid) references subject(subid),
foreign key(studentid) references student(studentid)
);