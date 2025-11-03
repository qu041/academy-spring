create table users (
	username varchar2(50) not null primary key, --아이디
	password varchar2(50) not null,             --암호
	enabled char(1) default '1'                 -- 활동 여부
);

create table authorities (
	username varchar2(50) not null,             --아이디(FK)
	authority varchar2(50) not null,            --권한(ROLE_XXX)
	constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);


insert into users (username, password) values ('dog', '1111');
insert into users (username, password) values ('cat', '1111');
insert into users (username, password) values ('tiger', '1111');

insert into authorities (username, authority) values ('dog', 'ROLE_USER'); --일반유저
insert into authorities (username, authority) values ('cat', 'ROLE_MANAGER'); --중간 관리자
insert into authorities (username, authority) values ('tiger', 'ROLE_ADMIN'); --관리자
insert into authorities (username, authority) values ('tiger', 'ROLE_MANAGER'); --중간 관리자

commit;

select * from users;

select * from authorities;
---------------------------------------------------------------------------------------------------------
--사용자지정 테이블
create table member (
    memberid varchar2(50) primary key ,
    memberpw varchar2(100) not null,
    membername varchar2(50) not null,
    email varchar2(100) not null,
    gender char(1) not null,
    enabled char(1) default '1',
    regdate date default sysdate not null

);

create table member_auth (
    memberid varchar2(50) not null,             --아이디(FK)
	auth varchar2(50) not null,            --권한(ROLE_XXX)
	constraint fk_member_users foreign key(memberid) references member(memberid)

);

commit;

select * from member;

insert into member_auth values ('dog', 'ROLE_MEMBER');
insert into member_auth values ('cat', 'ROLE_MEMBER');
insert into member_auth values ('tiger', 'ROLE_MEMBER');
insert into member_auth values ('tiger', 'ROLE_ADMIN');
--asjkldhjalskdjlkasd
commit;

select *
from member_auth;

delete from member where memberid='hong';

commit;

