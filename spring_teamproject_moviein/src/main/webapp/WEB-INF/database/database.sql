
create table movie_introduction_present( /* 현재상영작 게시판 테이블 */
	bNum number(4) primary key,
	bTitle varchar2(100) not null,
	bContent varchar2(4000),
	bRelease varchar2(10) not null,
	bDate date default sysdate,
	bHit number(4) default 0
);
create table movie_introduction_board( /* 독립영화 게시판 테이블 */
	dNum number(4) primary key,
	dTitle varchar2(100) not null,
	dContent varchar2(4000),
	dRelease varchar2(10) not null,
	dDate date default sysdate,
	dHit number(4) default 0
);
create table RSmember (
	id varchar2(50) primary key,
	password varchar2(16) not null,
	name varchar2(10) not null,
	birth varchar2(10) not null,
	postcode varchar2(20) not null,
	address varchar2(50) not null,
	address2 varchar2(40) not null,
	tel varchar2(15) not null,
	email varchar2(50) not null,
	gender varchar2(10),
	genre varchar2(15),
	Rdate date default sysdate	
);
/* MySQL -> Oracle
1. Integer -> Number
2. varchar -> varchar2
3. auto_increment -> sequence
4. limit start, size -> between start and end
**/
drop table movie_introduction_present;
drop table movie_introduction_board;
drop table RSmember;
select * from movie_introduction_present;
select * from movie_introduction_board;
select * from RSmember;
select password from RSmember where id='hong';
alter sequence movie_introduction_seq increment by 1;
create sequence movie_introduction_present_seq start with 1;
create sequence movie_introduction_board_seq start with 1;
drop sequence movie_introduction_present_seq;
drop sequence movie_introduction_board_seq;

/*nextval : 새로 추가된 게시글의 번호
 * currval : 현재 추가된 게시글 id의 가장 큰 값
 */
