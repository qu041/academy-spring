--계정 만들기
alter session set "_ORACLE_SCRIPT"=true;
create user spring identified by java1234;
grant connect, resource, dba to spring;
alter user spring default tablespace users;

commit;

select * from tabs;

create table tblAddress (
    seq number primary key ,
    name varchar2(30) not null,
    age number(3) not null ,
    address varchar2(300) not null ,
    gender char(1) not null
);

create sequence seqAddress;
commit;

insert into tblAddress values (seqAddress.nextval, '홍길동', 30, '서울시 강남구 역삼동', 'm');
select * from tblAddress;
commit;

insert into tblAddress values (seqAddress.nextval, '아무개', 10, '서울시 강남구 선정릉', 'w');
insert into tblAddress values (seqAddress.nextval, '강아지', 22, '서울시 강남구 선릉', 'w');
insert into tblAddress values (seqAddress.nextval, '고양이', 32, '서울시 강남구 선릉', 'w');
insert into tblAddress values (seqAddress.nextval, '병아리', 42, '서울시 강남구 선릉', 'w');
insert into tblAddress values (seqAddress.nextval, '쿼카', 62, '서울시 강남구 선릉', 'w');

create table tblPoint (
    seq number primary key ,
    point number default 100 not null ,
    aseq number not null references tblAddress(seq)
);

create sequence seqPoint;
select * from tblAddress;
select * from tblPoint;

commit ;

select
			*
		from tblAddress a
			left outer join tblPoint p
				on a.seq=p.aseq;

create table tblProject (
    seq number primary key ,
    name varchar2(100) not null ,
    location varchar2(200) not null ,
    num number not null references TBLINSA(num)
);

commit;

insert into tblProject values (1,'해외수출','서울',1001);
insert into tblProject values (2,'티비광고','부산',1002);
insert into tblProject values (3,'고객홍보','광주',1001);
insert into tblProject values (4,'자재매입','울산',1003);
insert into tblProject values (5,'재고확보','대전',1001);

commit;

select * from tblInsa i
			left outer join tblProject p
				on i.num = p.num;

select count(*) from tblAddress;