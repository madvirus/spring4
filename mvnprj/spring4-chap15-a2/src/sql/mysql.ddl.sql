create user 'spring4'@'localhost' identified by 'spring4';

create database memberdb character set=utf8;

grant all privileges on memberdb.* to 'spring4'@'localhost';

DROP TABLE memberdb.MEMBER;
DROP TABLE memberdb.LOCKER;

-- memberdb DB에 아래 테이블 생성
create table memberdb.MEMBER (
	MEMBER_ID int auto_increment primary key,
	USER_ID varchar(10),
	ENC_PASSWORD varchar(100),
	EMAIL varchar(200),
	NAME varchar(200),
	LOCKER_ID int
) engine=InnoDB character set = utf8;

create table memberdb.LOCKER (
	LOCKER_ID int primary key,
	LOCKER_SIZE int,
	OCCUPIED CHAR(1)
) engine=InnoDB character set = utf8;

-- test 목록 초기 데이터
insert into memberdb.MEMBER (MEMBER_ID, USER_ID, ENC_PASSWORD, EMAIL, NAME, LOCKER_ID) 
values (1, 'madvirus', '61626364', 'madvirus@madvirus.net', '최범균', 1);

insert into memberdb.LOCKER value (1, 1, 'Y');
insert into memberdb.LOCKER value (2, 1, 'N');