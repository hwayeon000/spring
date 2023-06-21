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

UPDATE board SET title='000' WHERE idx=8;
commit;

