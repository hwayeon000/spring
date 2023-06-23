drop table board;

-- Board 게시판 테이블 생성
create table board(
	idx int not null auto_increment,
	memID varchar(20) not null,
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(),
	count int default 0,
	
	primary key(idx)
);

insert into board(title, content, writer)
values('너무 배부르다','진짜 잠도오고 죽겠음','김한송');
insert into board(title, content, writer)
values('오늘 화요일','집에가고싶다','김개똥');
insert into board(title, content, writer)
values('내일 수요일','ㄱㄱㄱㄱㄱㄱㄱㄱㄱ','김고고');
insert into board(title, content, writer)
values('모레 목요일','ㄴㄴㄴㄴㄴㄴㄴㄴㄴ','김노노');
insert into board(title, content, writer)
values('글피 금요일','ㄷㄷㄷㄷㄷㄷㄷㄷㄷ','김도도');

select * from board;

-- 회원테이블 생성
create table member(
	memIdx int auto_increment,
	memID varchar(20) not null,
	memPassword varchar(20) not null,
	memName varchar(20) not null,
	memAge int,
	memGender varchar(20),
	memEmail varchar(50),
	memProfile varchar(50),
	primary key(memIdx)
);

select * from member;


insert into member(memID, memPassword, memName, memAge, memGender, memEmail)
values('admin','1234','관리자',20,'남자','admin@gmail.com');













