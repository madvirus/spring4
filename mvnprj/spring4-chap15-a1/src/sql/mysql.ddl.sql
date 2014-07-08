create user 'spring4'@'localhost' identified by 'spring4';

create database hrdb character set=utf8;

grant all privileges on hrdb.* to 'spring4'@'localhost';

DROP TABLE hrdb.EMPLOYEE;
DROP TABLE hrdb.TEAM;

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
	JOINED_DATE date
) engine=InnoDB character set = utf8;

create table hrdb.TEAM (
	TEAM_ID int auto_increment primary key,
	NAME varchar(100)
) engine=InnoDB character set = utf8;

-- 테스트 목록 초기 데이터
insert into hrdb.TEAM values (1, 'SW팀');

insert into hrdb.EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('1234567890', '최범균', '서울시 관악구', '신사동', '151872', 1977, 1, '2011-07-01');

insert into hrdb.EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('1234567891', '홍길동', '전라남도 장성군', '황룡면', '515813', 1983, 1, '2013-01-02');

insert into hrdb.EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('1234567892', '이순신', '서울시 중구', '인현동', '100282', 1982, 1, '2013-02-01');

insert into hrdb.EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('1234567893', '김구', '황해도 해주', '백운방 텃골', '111222', 1979, 1, '2013-03-01');

insert into hrdb.EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('1234567894', '전길남', '일본', '오사카', 'XXXYYY', 1943, 1, '2014-01-02');

insert into hrdb.EMPLOYEE (EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE)
values ('1234567895', '제임스고슬링', '캐나다', '어딘가', 'XXXYYY', 1955, 1, '2014-06-01');
