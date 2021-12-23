
create schema loginServer;

use loginServer;

create table users(
	
	code integer primary key auto_increment,
	id varchar(30) not null,
	pw varchar(30) not null,
	
	regDate datetime not null default current_timestamp


);


select* from users;

use loginServer;
insert users(id, pw) values('test', '1234');
insert users(id, pw) values('zxcv','1234');


drop table users;


delete from users where code = 2;
