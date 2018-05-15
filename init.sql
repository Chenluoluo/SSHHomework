--drop database IF EXISTS homework;
--创建数据库
create database homework;
--使用数据库
use homework;
create table HW_user(
	number int primary key auto_increment,
	username varchar(20),
	name varchar(20),
	password varchar(20),
	email varchar(20),
	phone varchar(20)
);
create table HW_blog(
	number int primary key auto_increment,
	title varchar(20),
	author varchar(20),
	type varchar(20),
	decoration varchar(500),
	create_time varchar(20),
	alter_time varchar(20),
	text varchar(5000)
);
create table HW_comment(
	number int primary key auto_increment,
	blognumber int,
	username varchar(20),
	content varchar(100),
	time varchar(20)
);
create table HW_picture(
	number int primary key auto_increment,
	name varchar(20),
	picture longblob,
	type varchar(20),
	create_time varchar(20),
	author varchar(20)
);
create table HW_message(
	number int primary key auto_increment,
	username varchar(20),
	content varchar(100),
	time varchar(20)
);