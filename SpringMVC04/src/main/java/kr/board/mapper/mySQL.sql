
-- root/ root
-- Board 게시판 테이블 생성
drop table board;

CREATE TABLE board(
	idx int not null auto_increment,
	memID varchar(20),
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(),
	count int default 0,
	primary key(idx)
);
-- board 컬럼에 시퀀스 생성 -> idx
CREATE SEQUENCE idx INCREMENT BY 1 START WITH 1;
--drop sequence idx;

insert into board (idx, title, content, writer)
values (idx.nextval, '파더스 베이글', '그냥 그랬다.. 그래도 맛있다...힣','ㅂㅎㅇ');

insert into board (idx, title, content, writer)
values (idx.nextval, 'please', 'help me............','abc');
select * from board;

commit;


-- 회원 테이블 생성
CREATE TABLE member(
	memIdx int,
   	memID varchar(20) not null,
   	memPassword varchar(20) not null,
   	memName varchar(20) not null,
   	memAge int,
   	memGender varchar(20),
   	memEmail varchar(50),
   	memProfile varchar(50)
);

-- member 컬럼에 시퀀스 생성 -> memIdx
CREATE SEQUENCE memIdx INCREMENT BY 1 START WITH 1;
--drop sequence memIdx;

select * from member;

commit; 

insert into member(memIdx, memID, memPassword, memName, memAge, memGender, memEmail)
values(memIdx.nextval, 'admin','1234','관리자', 20, '여자', 'admin@gmail.com');



