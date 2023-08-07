create database ql_sv_asm 
go

create table grade (
	id int,
	masv nvarchar(50) primary key,
	enScore int,
	itScore int,
	gdtc int
);
go



create table students (
	masv nvarchar(50) primary key,
	name nvarchar(50),
	email nvarchar(50),
	phone nvarchar(15),
	gender bit,
	address nvarchar(50),
	img nvarchar(50)
);
go

create table users (
	username nvarchar(50),
	password nvarchar(50),
	role nvarchar(50)
);
go

-- Triger to insert grade
create trigger add_grade on students
instead of insert
as
begin 
	insert into grade(id, masv, enScore, itScore,gdtc) values (null , (select masv from inserted), null, null, null)
end
go

create trigger del_grade on students
instead of delete
as
begin 
	delete from grade where masv = (select masv from deleted)
end
go

-- Insert value for login
insert into users values ('Kienluu123', '12345678', 'qlsv');
insert into users values ('Kienluu345', '12345678', 'teacher');
