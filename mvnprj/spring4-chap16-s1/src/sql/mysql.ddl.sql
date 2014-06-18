create user 'spring4'@'localhost' identified by 'spring4';

create database ssuserdb character set=utf8;

grant all privileges on ssuserdb.* to 'spring4'@'localhost';

create table users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
) engine=InnoDB character set = utf8;

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null
) engine=InnoDB character set = utf8;

create unique index ix_auth_username on authorities (username,authority);

create table groups (
	id bigint auto_increment primary key,
	group_name varchar_ignorecase(50) not null
) engine=InnoDB character set = utf8;

create table group_authorities (
	group_id bigint not null,
	authority varchar(50) not null,
) engine=InnoDB character set = utf8;

create table group_members (
	id bigint auto_increment primary key,
	username varchar(50) not null,
	group_id bigint not null,
) engine=InnoDB character set = utf8;

create table persistent_logins (
	username varchar(64) not null,
	series varchar(64) primary key,
	token varchar(64) not null,
	last_used timestamp not null
) engine=InnoDB character set = utf8;