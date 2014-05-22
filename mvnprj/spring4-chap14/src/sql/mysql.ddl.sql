create user 'spring4'@'localhost' identified by 'spring4';

create database hrdb character set=utf8;

grant all privileges on hrdb.* to 'spring4'@'localhost';

-- hrdb DB에 아래 테이블 생성
create table hrdb.EMPLOYEE (
	EMPLOYEE_ID int auto_increment primary key,
	EMPLOYEE_NUM varchar(10),
	NAME varchar(100),
	HOME_ADDR1 varchar(200),
	HOME_ADDR2 varchar(200),
	HOME_ZIPCODE varchar(10),
	BIRTH_YEAR int,
	TEAM_ID int,
) engine=InnoDB character set = utf8;

create table hrdb.TEAM (
	TEAM_ID int auto_increment primary key,
	NAME varchar(100)
) engine=InnoDB character set = utf8;

-- 테스트 목록 초기 데이터