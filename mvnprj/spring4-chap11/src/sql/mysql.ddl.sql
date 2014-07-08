create user 'spring4'@'localhost' identified by 'spring4';

create database guestbook character set=utf8;

grant all privileges on guestbook.* to 'spring4'@'localhost';

-- guestbook DB에 아래 테이블 생성
create table guestbook.guestmessage (
	id int auto_increment primary key,
	name varchar(100),
	message text,
	creationTime datetime
) engine=InnoDB character set = utf8;
