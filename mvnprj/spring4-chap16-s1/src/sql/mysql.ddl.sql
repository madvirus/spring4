create user 'spring4'@'localhost' identified by 'spring4';

create database ssuserdb character set=utf8;

grant all privileges on ssuserdb.* to 'spring4'@'localhost';

create table ssuserdb.users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
) engine=InnoDB character set = utf8;

create table ssuserdb.authorities (
	username varchar(50) not null,
	authority varchar(50) not null
) engine=InnoDB character set = utf8;

create unique index ix_auth_username on ssuserdb.authorities (username,authority);
