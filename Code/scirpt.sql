--Code > script.sql

-- 코드 조각 게시판
-- 1. 코드 조각 테이블(게시물) > CodeDTO
-- 2. 언어 테이블(카테고리) >  LanguageDTO

create table tblLanguage (
    name varchar2(100) primary key ,
    icon varchar2(100) not null ,
    color varchar2(10) not null
);

insert into tblLanguage values ('Java', 'fa-solid fa-code', '#0096FF');
insert into tblLanguage values ('SQL', 'fa-solid fa-database', '#ff5733');
insert into tblLanguage values ('HTML', 'fa-brands fa-html5', '#00A36C');
insert into tblLanguage values ('CSS', 'fa-brands fa-css3-alt', '#FFBF00');
insert into tblLanguage values ('JavaScript', 'fa-brands fa-js', '#FFE5B4');
commit;

create table tblCode (
    seq number primary key ,
    subject varchar2(300) not null,
    code varchar2(4000) not null,
    regdate date default sysdate not null ,
    language varchar2(100) not null references tblLanguage(name)
);

create sequence seqCode;

commit;

select * from tblCode;

select
    *
from tblCode c
    inner join  tblLanguage l on c.language = l.name
			order by seq desc;