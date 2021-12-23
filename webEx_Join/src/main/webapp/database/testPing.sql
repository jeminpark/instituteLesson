
create schema loginServer;

use loginServer;

create table users(
	
	code integer primary key auto_increment,
	id varchar(30) not null,
	pw varchar(30) not null,
	name varchar(30) not null,
	birth varchar(30) not null,
	gender varchar(30) not null,
	email varchar(50) not null,
	mobile varchar(30) not null,
	
	regDate datetime not null default current_timestamp


);


select* from users;

use loginServer;
insert users(id, pw, name, birth, gender, email, mobile) values('test', '1234', '테스트', '1965-7-31','남자','test@test.com','123-1234-4567');
insert users(id, pw, name, birth, gender, email, mobile) values('zxcv','1234', '시험용', '2021-1-12', '여자','zxcv@test.com' ,'000-4561-4556');


drop table users;


delete from users where code = 2;
