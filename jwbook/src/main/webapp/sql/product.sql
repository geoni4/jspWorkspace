-- 참고 사이트 - https://huskdoll,tistory.com/401

create table product(
	id varchar2(20) primary key,
	name varchar2(50),
	maker varchar2(50),
	price number,
	regdate date default sysdate

);

insert into product
values('101', '애플사과폰 12', '애플전자', 1200000, '2020.12.12');
insert into product
values('102', '삼전우주폰 12', '삼전전자', 1300000, '2021.2.2');
insert into product
values('103', '엘스듀얼폰', '엘스전자', 1500000, '2020.3.2');

select * from product


delete from product where id = 104