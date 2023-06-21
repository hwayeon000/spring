-- root/ root
-- Board 게시판 테이블 생성
drop table board;

CREATE TABLE board(
	idx int not null auto_increment,
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(),
	count int default 0,
	primary key(idx)
);


insert into board (title, content, writer)
values ('파더스 베이글...', '그냥 그랬다.. 그래도 맛있다...힣','ㅂㅎㅇ');

insert into board (title, content, writer)
values ('파더스 123sdf...', '그냥ㅁㄴㅇㄹ랬다.. ㅁㄴㅇㄹㄴㅇㄹ도 맛있다...','aaa');

insert into board (title, content, writer)
values ('please', 'help me............','abc');

insert into board (title, content, writer)
values ('micha...beryo..', 'whyrano....whyrano....','122');


select * from board;

UPDATE board SET title='제발..' WHERE idx=20;
commit;


-- 회원 테이블 생성
CREATE TABLE member(
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
values('admin','1234','관리자', 20, '여자', 'admin@gmail.com');



