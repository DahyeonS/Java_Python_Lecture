-- 테이블 생성
create table department(
	department_id int primary key not null,
	department_name varchar(50) not null
);

insert into department values(1, '수학');
insert into department values(2, '국문학');
insert into department values(3, '정보통신공학');
insert into department values(4, '모바일공학');

select * from department;

create table student (
	student_id int primary key not null,
	student_name varchar(20) not null,
	height int,
	department_id int references department(department_id)
);

insert into student values(1, '가길동', 177, 1);
insert into student values(2, '나길동', 178, 1);
insert into student values(3, '다길동', 179, 1);
insert into student values(4, '라길동', 180, 2);
insert into student values(5, '마길동', 170, 2);
insert into student values(6, '바길동', 172, 3);
insert into student values(7, '사길동', 166, 4);
insert into student values(8, '아길동', 192, 4);

select * from student;

create table professor (
	professor_id int primary key not null,
	professor_name varchar(20) not null,
	department_id int references department(department_id)
);

insert into professor values(1, '가교수' ,1);
insert into professor values(2, '나교수' ,2);
insert into professor values(3, '다교수' ,3);
insert into professor values(4, '빌게이츠' ,4);
insert into professor values(5, '스티브잡스' ,3);

select * from professor;

create table course (
	course_id int primary key not null,
	course_name varchar(50) not null,
	start_date date not null,
	end_date date not null,
	professor_id int references professor(professor_id)
);

insert into course values(1, '교양영어', '2016/9/2', '2016/11/30', 1);
insert into course values(2, '데이터베이스 입문', '2016/8/20','2016/10/30', 3);
insert into course values(3, '회로이론', '2016/10/20', '2016/12/30', 2);
insert into course values(4, '공업수학', '2016/11/2', '2017/1/28', 4);
insert into course values(5, '객체지향프로그래밍', '2016/11/1', '2017/1/30', 3);

select * from course;

create table student_course (
	student_id int references student(student_id),
	course_id int references course(course_id)
);

insert into student_course values(1, 1);
insert into student_course values(2, 1);
insert into student_course values(3, 2);
insert into student_course values(4, 3);
insert into student_course values(5, 4);
insert into student_course values(6, 5);
insert into student_course values(7, 5);

select * from student_course;

-- 테스트 쿼리 작성
-- 1번
select s.student_id, student_name, height, d.department_id, department_name from student s
inner join department d on s.department_id = d.department_id;

-- 2번
select professor_id from professor where professor_name = '가교수';

-- 3번
select department_name, count(professor_id) from professor p inner join department d on p.department_id = d.department_id
group by department_name order by department_name;

-- 4번
select s.student_id, student_name, height, s.department_id, department_name from student s
inner join department d on s.department_id = d.department_id where department_name = '정보통신공학';

-- 5번
select professor_id, professor_name, p.department_id, department_name from professor p
inner join department d on p.department_id = d.department_id where department_name = '정보통신공학';

-- 6번
select department_name from student s inner join department d on s.department_id = d.department_id
group by department_name order by count(student_id) desc limit 1;
select department_name from department where department_id =
(select department_id from student group by department_id order by count(student_id) desc limit 1);

-- 7번
select student_name, department_name from student s inner join department d on s.department_id = d.department_id
where student_name like '아%';

-- 8번
select count(student_id) from student where height between 180 and 190;

-- 9번
select department_name, max(height), avg(height) from department d inner join student s on d.department_id = s.department_id
group by department_name order by department_name;

-- 10번
select student_name from student where department_id = (select s.department_id from student s
inner join department d on s.department_id = d.department_id where student_name = '다길동');

-- 11번
select student_name, course_name from student s, student_course sc, course c where s.student_id = sc.student_id and sc.course_id = c.course_id
and course_name in (select course_name from course where start_date >= '2016-11-01');

-- 12번
select student_name from student s, student_course sc, course c where s.student_id = sc.student_id and sc.course_id = c.course_id
and course_name = '데이터베이스 입문';

-- 13번
select count(s.student_id) as "count(student_id)" from student s, student_course sc, course c, professor p where s.student_id = sc.student_id
and sc.course_id = c.course_id and c.professor_id = p.professor_id and professor_name = '빌게이츠';

-- 14번
select student_name from student s inner join student_course sc on s.student_id = sc.student_id where course_id =
(select c.course_id from student s, student_course sc, course c where s.student_id = sc.student_id and sc.course_id = c.course_id and student_name = '사길동');

-- 15번
select course_name, date_format(start_date, '%Y/%m/%d') start_date from course where course_name = 
(select course_name from student s, student_course sc, course c where s.student_id = sc.student_id
and sc.course_id = c.course_id and student_name = '사길동');

-- 16번
select student_name from student s inner join student_course sc on s.student_id = sc.student_id
where course_id in (select c.course_id from course c inner join professor p on c.professor_id = p.professor_id
where date_format(start_date, '%Y-%c') = '2016-11' and professor_name = '다교수');

-- 17번
select course_name, count(*) cnt from course c inner join student_course sc on c.course_id = sc.course_id
group by course_name order by course_name;