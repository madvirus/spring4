insert into ssuserdb.users values ('bkchoi', '1234', true);
insert into ssuserdb.users values ('admin', '1234', true);

-- 암호화 기능을 위한 테스트시에는 아래 코드 이용
-- insert into users values ('bkchoi', '$2a$10$lbdTX16tpVENpDSKwws1h.wBPco2ZYEHsshWz5S44N.f8W/f1Hmja', true);
-- insert into users values ('admin', '$2a$10$dk37Mh0VRilJ/2V55qjjpee/xUK8eXasIQj8ANJohE0bB7Y2iTNLi', true);

insert into ssuserdb.authorities values ('admin', 'USER');
insert into ssuserdb.authorities values ('admin', 'USER_MANAGER');
insert into ssuserdb.authorities values ('bkchoi', 'USER');
