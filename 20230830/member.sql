use kdigital2307;

create table member(
	idx int primary key auto_increment,
    id varchar(50) not null unique,
    pw varchar(50) not null,
    name varchar(50) not null,
    age int,
    regdate datetime not null default now()
);

insert into member (id, pw, name, age) values
('hong1', '1111', '홍길동1', 11),
('hong2', '2222', '홍길동2', 22),
('hong3', '3333', '홍길동3', 33);

select * from member;