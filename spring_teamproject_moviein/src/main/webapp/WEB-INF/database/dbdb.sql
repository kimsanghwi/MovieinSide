create table PM_recommend_board (
	dAI_Id number(4) primary key,
	dAI_Title varchar2(100),
	dAI_Content varchar2(2000),
	dAI_Name varchar2(100),
	safeFile varchar2(2000),
	safeFile2 varchar2(2000),
	dAI_Date date default sysdate,
	dAI_Hit number(10) default 0
);
create table DAI_people_board (
	dAI_Id number(4) primary key,
	dAI_Title varchar2(100),
	dAI_Content varchar2(2000),
	dAI_Name varchar2(100),
	safeFile varchar2(2000),
	safeFile2 varchar2(2000),
	dAI_Date date default sysdate,
	dAI_Hit number(10) default 0
);
create table DAI_director_board (
	dAI_Id number(4) primary key,
	dAI_Title varchar2(100),
	dAI_Content varchar2(2000),
	dAI_Name varchar2(100),
	safeFile varchar2(2000),
	safeFile2 varchar2(2000),
	dAI_Date date default sysdate,
	dAI_Hit number(10) default 0
);

create table board_file(
fno number primary key,
no number references board(no) on delete cascade,
oriFile varchar2(100),
serFile varchar2(100) not null
);

create fileupload(
attachPath varchar2(200) not null,
Filename varchar2(200) not null,
upload varchar2(200),

)

create sequence borad_file_seq;

select * from board_file;

select * from DAI_people_board;

select * from DAI_director_board;

select * from PM_recommend_board;

drop table board_file;

drop table PM_recommend_board;
drop table DAI_people_board;
drop table DAI_director_board;


select last_number from user_sequences where sequence_name='recommend_board_seq';

select * from PM_recommend_board_seq;
select * from DAI_people_board_seq;
select * from DAI_director_board_seq;

create sequence PM_recommend_board_seq start with 1;

create sequence DAI_people_board_seq start with 1;

create sequence DAI_director_board_seq start with 1;

drop sequence PM_recommend_board_seq;
drop sequence DAI_people_board_seq;
drop sequence DAI_director_board_seq;


alter sequence recommend_board_seq increment by 1;

