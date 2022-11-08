CREATE TABLE news(
	aid number primary key,
	title VARCHAR2(100) not null,
	img VARCHAR2(200) not null,
	regdate date default sysdate,
	content VARCHAR2(4000) not null
);

drop table new

select * from news

