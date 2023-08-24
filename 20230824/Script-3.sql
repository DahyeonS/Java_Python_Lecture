-- select
select * from actor;
select * from customer;
select first_name, last_name, email from customer order by first_name, last_name desc;

-- distinct
create table t1 (
id serial not null primary key,
bcolor varchar,
fcolor varchar
);

INSERT
INTO T1(BCOLOR,FCOLOR)
VALUES
('red','red')
,('red','red')
,('red',NULL)
,(NULL,'red')
,('red','green')
,('red','blue')
,('green','red')
,('green','blue')
,('green','green')
,('blue','red')
,('blue','green')
,('blue','blue')
;

select * from t1;
select distinct bcolor from t1;

-- 필터링
select * from customer where first_name = 'Jamie' and last_name = 'Rice';
select * from payment where amount <= 1 or amount >= 8;

-- limit
select * from film order by film_id limit 10;
select * from film order by film_id limit 10 offset 0;
select * from film order by film_id limit 10 offset 10;
select * from film order by film_id limit 10 offset 20;
select * from film order by film_id limit 10 offset 30;

select * from film order by title fetch first row only;
select * from film order by film_id offset 10 rows fetch first 10 rows only;

-- 가장 큰 length 순으로 3 ~ 5등까지 출력하시오
select * from film order by length desc limit 3 offset 2;

-- in / or
select * from rental where customer_id in (1, 2, 3) order by return_date desc;
select * from rental where customer_id = 1 or customer_id = 2 or customer_id = 3 order by return_date desc;

-- not in
select * from rental where customer_id <> 1 and customer_id != 2 order by return_date desc;
select * from rental where customer_id not in (1, 2) order by return_date desc;

-- cast
select * from rental where cast(return_date as date) = '2005-05-27';
select * from rental where customer_id in (select customer_id from rental where cast(return_date as date) = '2005-05-27');

select first_name, last_name from customer where customer_id in (select customer_id from rental where cast(return_date as date) = '2005-05-27');
select first_name, last_name from customer where customer_id in (select customer_id from rental where customer_id in (1, 2, 3) order by return_date desc);

-- between
select * from payment limit 3;
select * from payment where amount between 8 and 9;
select * from payment where amount >= 8 and amount <= 9;
select * from payment where amount not between 8 and 9;
select * from payment where amount >= 8 or amount <= 9;

select * from payment where cast(payment_date as date) between '2007-02-07' and '2007-02-15';
select * from payment where to_char(payment_date, 'YYYY-MM-DD') between '2007-02-07' and '2007-02-15';

-- like
select * from customer where first_name like 'Jen%';
select * from customer where first_name like '%ny';
select * from customer where email like '%ko%';


create table contact (
	id int generated by default as identity,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(255) not null,
	phone varchar(15),
	primary key(id)
);

insert into contact (first_name, last_name, email, phone)
values ('John', 'Doe', 'john@example.com', null),
('Lily', 'Bush', 'lily.bush@example.com', '111-111-1111');

select * from contact where phone = null;
select * from contact where phone is null;
select * from contact where phone is not null;

-- payment 테이블에서 amount 값이 가장 큰 고객의 customer_id를 중복없이 출력
select customer_id from payment order by amount desc, customer_id limit 1;

select distinct customer_id from payment where amount = (select amount from payment order by amount desc limit 1) order by customer_id;
select distinct customer_id from payment where amount = (select max(amount) from payment) order by customer_id; -- 성능 상 우위

-- email 추출
select * from customer where email like '%@%' and email not like '@%' and email not like '%@' order by customer_id;

-- inner join
select * from (select * from customer) a;

create table basket_a (
	id int primary key,
	fruit varchar(100) not null
);

create table basket_b (
	id int primary key,
	fruit varchar(100) not null
);

insert into basket_a values
(1, 'Apple'),
(2, 'Orange'),
(3, 'Banana'),
(4, 'Cucumber');

insert into basket_b values
(1, 'Orange'),
(2, 'Apple'),
(3, 'Watremelon'),
(4, 'Pear');

select * from basket_a;
select * from basket_b;

select * from basket_a a inner join basket_b b on b.fruit = a.fruit;
select b.id, a.fruit from basket_a a inner join basket_b b on b.fruit = a.fruit;
select * from basket_a a inner join basket_b b on b.id = a.id;

update basket_a set fruit = 'apple' where id = 1; -- 대소문자 구분
update basket_a set fruit = 'Apple' where id = 1;

select * from basket_a a, basket_b b where a.fruit = b.fruit;

select * from customer c inner join payment p on c.customer_id = p.customer_id where amount > 11 order by c.customer_id;
select * from customer c, payment p where c.customer_id = p.customer_id and amount > 11 order by c.customer_id desc;

select * from customer c inner join payment p on c.customer_id = p.customer_id where c.customer_id = 2 order by c.customer_id;
select c.customer_id, c.first_name, c.last_name, c.email, p.amount, p.payment_date
from customer c, payment p where c.customer_id = p.customer_id and c.customer_id = 2 order by c.customer_id;

select * from payment p inner join customer c on c.customer_id = p.customer_id
inner join staff s on s.staff_id = p.staff_id order by c.customer_id;
select c.customer_id, c.first_name, c.last_name, c.email, p.amount, p.payment_date
from customer c, payment p, staff s where c.customer_id = p.customer_id and s.staff_id = p.staff_id and c.customer_id = 2 order by c.customer_id;

-- left outer join
select * from payment p left join customer c on c.customer_id = p.customer_id;
select * from basket_a a left join basket_b b on b.fruit = a.fruit;

select * from payment p left join customer c on c.customer_id = p.customer_id order by c.customer_id;
select * from basket_a a left join basket_b b on b.fruit = a.fruit order by a.id;

-- right outer join
select * from customer c right join payment p on c.customer_id = p.customer_id order by c.customer_id;
select * from basket_a a right join basket_b b on b.fruit = a.fruit order by a.id;

-- self join
CREATE TABLE EMPLOYEE
(
EMPLOYEE_ID INT PRIMARY KEY
, FIRST_NAME VARCHAR (255) NOT NULL
, LAST_NAME VARCHAR (255) NOT NULL
, MANAGER_ID INT
, FOREIGN KEY (MANAGER_ID)
REFERENCES EMPLOYEE (EMPLOYEE_ID)
ON DELETE cascade -- 연동해서 같이 삭제
);

INSERT INTO EMPLOYEE (
EMPLOYEE_ID
, FIRST_NAME
, LAST_NAME
, MANAGER_ID
)
VALUES
(1, 'Windy', 'Hays', NULL),
(2, 'Ava', 'Christ', 1)
(3, 'Hassan', 'Conner', 1),
(4, 'Anna', 'Reeves', 2),
(5, 'Sau', 'Norman', 2),
(6, 'Kelsie', 'Hays', 3),
(7, 'Tory', 'Goff', 3),
(8, 'Salley', 'Lester', 3);

select * from employee;
update employee set manager_id = 1 where employee_id = 2;

-- 각 직원의 manager 이름, first_name, last_name을 출력
select e2.first_name, e2.last_name, e2.manager_id, e1.first_name, e1.last_name from employee e1 inner join employee e2 on e1.employee_id = e2.manager_id;
select e2.first_name || ' ' || e2.last_name as employee, e2.manager_id, e1.first_name || ' ' || e1.last_name as manager from employee e1 inner join employee e2 on e1.employee_id = e2.manager_id;

-- 상영 시간이 같은 영화들(제목 중복 X) 출력
select * from film f1 inner join film f2 on f1.film_id <> f2.film_id where f1.length = f2.length;

-- group by
select customer_id, sum(amount) amount_sum from payment group by customer_id order by sum(amount) desc;
select staff_id, count(payment_id) from payment p group by staff_id;
select customer_id, sum(amount) amout_sum from payment group by customer_id having sum(amount) > 200;
select store_id, count(customer_id) from customer group by store_id;

-- 가게들이 있는 나라명, 도시명, 주소 추출
select c2.country, c.city, a.address from address a, store s, city c, country c2 where a.address_id = s.address_id and a.city_id = c.city_id and c.country_id = c2.country_id;

-- grouping set
create table sales (
	brand varchar not null,
	segment varchar not null,
	quantity int not null,
	primary key(brand, segment)
);

insert into sales values
('ABC', 'Premium', 100),
('ABC', 'Basic', 200),
('XYZ', 'Premium', 100),
('XYZ', 'Basic', 300);

select brand, sum(quantity) from sales group by brand;
select segment, sum(quantity) from sales group by segment;
select brand, segment, sum(quantity) from sales group by brand, segment;
select sum(quantity) from sales;

select brand, segment, sum(quantity) from sales group by brand, segment
union all select brand, null, sum(quantity) from sales group by brand
union all select null, segment, sum(quantity) from sales group by segment
union all select null, null, sum(quantity) from sales;

select brand, segment, sum(quantity) from sales group by
grouping sets ((brand, segment), (brand), (segment), ());

select grouping (brand) grouping_brand, grouping (segment) grouping_segment,
brand, segment, sum(quantity) from sales group by
grouping sets ((brand, segment), (brand), (segment), ());

-- rollup
select brand, segment, sum(quantity) from sales group by rollup (brand, segment) order by brand, segment; -- 그룹 별 합계
select sum(quantity) from sales where brand = 'ABC';

-- cube
select brand, segment, sum(quantity) from sales group by cube (brand, segment) order by brand, segment; -- grouping set와 동일한 결과

-- over
create table product_group(
	group_id serial primary key,
	group_name varchar(255) not null
);

create table product (
	product_id serial primary key,
	product_name varchar(255) not null,
	price decimal(11, 2), -- 정수와 소수를 입력 가능
	group_id int not null,
	foreign key(group_id) references product_group(group_id)
);

INSERT INTO PRODUCT_GROUP (GROUP_NAME)
VALUES
('Smartphone')
, ('Laptop')
, ('Tablet');

INSERT INTO PRODUCT (PRODUCT_NAME,
GROUP_ID,PRICE)
VALUES
('Microsoft Lumia', 1, 200)
, ('HTC One', 1, 400)
, ('Nexus', 1, 500)
, ('iPhone', 1, 900)
, ('HP Elite', 2, 1200)
, ('Lenovo Thinkpad', 2, 700)
, ('Sony VAIO', 2, 700)
, ('Dell Vostro', 2, 800)
, ('iPad', 3, 700)
, ('Kindle Fire', 3, 150)
, ('Samsung Galaxy Tab', 3, 200);

select count(*) over(), * from product; -- group by 없이 코드 실행 가능

select group_name, avg(price) from product p inner join product_group pg on p.group_id = pg.group_id group by group_name;

select product_name, price, group_name, avg(price) over(partition by pg.group_name) from product p inner join product_group pg on p.group_id = pg.group_id;

-- row_number
select a.product_name, b.group_name, a.price,
row_number() over (partition by b.group_name order by a.price desc) from product a inner join product_group b on a.group_id = b.group_id; -- 그룹명 기준 가격 순위 출력

-- rank
select a.product_name, b.group_name, a.price,
rank() over (partition by b.group_name order by a.price desc) from product a inner join product_group b on a.group_id = b.group_id; -- 그룹명 기준 가격 순위 출력(중복 허용)

-- dense_rank
select a.product_name, b.group_name, a.price,
dense_rank() over (partition by b.group_name order by a.price desc) from product a inner join product_group b on a.group_id = b.group_id;-- 그룹명 기준 가격 순위 출력(중복 허용, 건너뛰기 없음)

-- first_value
select a.product_name, b.group_name, a.price,
first_value(price) over (partition by b.group_name order by a.price desc) from product a inner join product_group b on a.group_id = b.group_id; -- 그룹명 기준 가격의 첫번째 값 출력
select a.product_name, b.group_name, a.price,
first_value(price) over (partition by b.group_name) from product a inner join product_group b on a.group_id = b.group_id; -- 그룹명 기준 가격의 첫번째 값 출력

-- last_value
select a.product_name, b.group_name, a.price,
last_value(price) over (partition by b.group_name order by a.price range between unbounded preceding and unbounded following)
from product a inner join product_group b on a.group_id = b.group_id; -- 그룹명 기준 가격의 마지막 값 출력

-- lag
select a.product_name, b.group_name, a.price,
lag(price, 1) over (partition by b.group_name order by a.price) as prev_price, price - lag(price, 1) over (partition by group_name order by price) as cur_pre_diff
from product a inner join product_group b on a.group_id = b.group_id;

-- lead
select a.product_name, b.group_name, a.price,
lead(price, 1) over (partition by b.group_name order by a.price) as next_price, price - lead(price, 1) over (partition by group_name order by price) as next_cur_diff
from product a inner join product_group b on a.group_id = b.group_id;

-- 년월일 기준 렌탈 횟수 출력
select to_char(return_date, 'YYYY') y, to_char(return_date, 'MM') m, to_char(return_date, 'DD') d, count(rental_id)
from rental group by rollup (to_char(return_date, 'YYYY'), to_char(return_date, 'MM'), to_char(return_date, 'DD'));

-- rental 횟수가 많은 고객 정보 출력
select r.customer_id, row_number() over(order by count(rental_id) desc), count(r.customer_id),
max(first_name) as first_name, max(last_name) as last_name from rental r, customer c where r.customer_id = c.customer_id group by r.customer_id limit 1;
select r.customer_id, row_number() over(order by count(rental_id) desc), count(r.customer_id),
max(first_name) || ' ' || max(last_name) as name from rental r, customer c where r.customer_id = c.customer_id group by r.customer_id limit 1;

select r.customer_id, row_number() over(order by count(rental_id) desc), count(r.customer_id), first_name || ' ' || last_name as name
from rental r, customer c where r.customer_id = c.customer_id group by r.customer_id, first_name, last_name limit 1; -- 성능 떨어짐

-- intersect
CREATE TABLE EMPLOYEES
(
EMPLOYEE_ID SERIAL PRIMARY KEY
, EMPLOYEE_NAME VARCHAR (255) NOT NULL
);

CREATE TABLE KEYS
(
EMPLOYEE_ID INT PRIMARY KEY,
EFFECTIVE_DATE DATE NOT NULL,
FOREIGN KEY (EMPLOYEE_ID)
REFERENCES EMPLOYEES (EMPLOYEE_ID)
);

CREATE TABLE HIPOS
(
EMPLOYEE_ID INT PRIMARY KEY,
EFFECTIVE_DATE DATE NOT NULL,
FOREIGN KEY (EMPLOYEE_ID)
REFERENCES EMPLOYEES (EMPLOYEE_ID)
);

INSERT INTO EMPLOYEES (EMPLOYEE_NAME)
VALUES
('Joyce Edwards'),
('Diane Collins'),
('Alice Stewart'),
('Julie Sanchez'),
('Heather Morris'),
('Teresa Rogers'),
('Doris Reed'),
('Gloria Cook'),
('Evelyn Morgan'),
('Jean Bell');

select * from employees;

INSERT INTO KEYS
VALUES
(1, '2000-02-01'),
(2, '2001-06-01'),
(5, '2002-01-01'),
(7, '2005-06-01');

INSERT INTO HIPOS
VALUES
(9, '2000-01-01'),
(2, '2002-06-01'),
(5, '2006-06-01'),
(10, '2005-06-01');

select * from keys;
select * from hipos;

select employee_id from keys intersect select employee_id from hipos; -- 교집합 출력
select employee_id from keys intersect select employee_id from hipos order by employee_id desc;

select k.employee_id from keys k, hipos h where k.employee_id = h.employee_id;

-- except
select employee_id from keys except select employee_id from hipos; -- 차집합 출력(특정 집합을 제외)

-- 재고가 존재하는 영화의 필름ID, 영화제목
select distinct i.film_id, title from inventory i, film f where i.film_id = f.film_id order by film_id;

-- 재고가 존재하지 않는 영화의 필름ID, 영화제목
select distinct film_id, title from film f except select distinct i.film_id, title from inventory i, film f where i.film_id = f.film_id order by film_id;

-- subquery
-- rantal rate보다 큰 정보 출력
select avg(rental_rate) from film; -- 2.98
select * from film where rental_rate > (select avg(rental_rate) from film) order by rental_rate, film_id;
select * from film a, (select avg(rental_rate) avg_rate from film) b where a.rental_rate > b.avg_rate;

select film_id, title, rental_rate from (select a.film_id, a.title, a.rental_rate, (select avg(l.rental_rate) from film l) avg_rate from film a) a where a.rental_rate > a.avg_rate;

-- any
select * from film where length >=
any (select max(length) from film f, film_category c where f.film_id = c.film_id group by c.category_id order by c.category_id); -- 상영시간 별 최대값들 중 하나보다 큰 영화(하나라도 크면 만족)

select * from film where film_id in (1, 2, 3);
select * from film f1 where f1.film_id = any (select f2.film_id from film f2 where f2.film_id in (1, 2, 3));
select * from film where film_id = any (select film_id from film order by film_id limit 3);

-- all
select * from film where length >=
all (select max(length) from film f, film_category c where f.film_id = c.film_id group by c.category_id order by c.category_id); -- 상영시간 별 모든 최대값보다 큰 영화

-- exists
select first_name, last_name from customer c
where exists (select 1 from payment p where p.customer_id = c.customer_id and p.amount > 11) -- 1은 아무 의미 없는 값, 서브쿼리 개별로 실행 불가
order by first_name, last_name; -- 존재 여부 파악

-- ansi(where -> inner join)
select country, city, address from address a, store s, city c, country c2
where a.address_id = s.address_id and a.city_id = c.city_id and c.country_id = c2.country_id;

select country, city, address from address a
inner join store s on a.address_id = s.address_id inner join city c on a.city_id = c.city_id inner join country c2 on c.country_id = c2.country_id;

-- 테이블 스캔 줄이기
select film_id, title, rental_rate from film where rental_rate > (select avg(rental_rate) from film) order by film_id;

select distinct film_id, title, rental_rate from film a, (select avg(rental_rate) over () as avg_rate from film b) b where a.rental_rate > b.avg_rate order by film_id;

select * from film_actor fa,
(select distinct film_id, title, rental_rate from film a, (select avg(rental_rate) over () as avg_rate from film b) b where a.rental_rate > b.avg_rate) a
where fa.film_id = a.film_id;

select * from actor a,
(select * from film_actor fa,
(select distinct film_id, title, rental_rate from film a, (select avg(rental_rate) over () as avg_rate from film b) b where a.rental_rate > b.avg_rate) a
where fa.film_id = a.film_id) b where a.actor_id = b.actor_id;

select distinct actor_id from film_actor where actor_id in 
(select a.actor_id from actor a,
(select * from film_actor fa,
(select distinct film_id, title, rental_rate from film a, (select avg(rental_rate) over () as avg_rate from film b) b where a.rental_rate > b.avg_rate) a
where fa.film_id = a.film_id) b where a.actor_id = b.actor_id);

-- 평균 이상 렌트된 영화의 배우 이름 출력
select * from actor a where actor_id in
(select distinct actor_id from film_actor fa, (select film_id from film where rental_rate > (select avg(rental_rate) from film)) a where fa.film_id = a.film_id);

-- except 없이 쿼리 수정
select FILM_ID, TITLE FROM FILM except select distinct INVENTORY.FILM_ID, TITLE FROM INVENTORY
inner join FILM on FILM.FILM_ID = INVENTORY.FILM_ID ORDER by TITLE;

select film_id, title from film where film_id not in (select distinct i.film_id from film f, inventory i where f.film_id = i.film_id) order by film_id;
select film_id, title from film f where not exists (select 1 from film f2, inventory i where f2.film_id = i.film_id and f.film_id = f2.film_id) order by film_id;
select film_id, title from film f where film_id != all (select distinct i.film_id from film f, inventory i where f.film_id = i.film_id) order by film_id;

-- insert
CREATE TABLE LINK (
ID SERIAL PRIMARY KEY
, URL VARCHAR (255) NOT NULL
, NAME VARCHAR (255) NOT NULL
, DESCRIPTION VARCHAR (255)
, REL VARCHAR (50)
);

insert into link(url, name) values
('http://naver.com', 'Naver'),
('http://naver.com', 'Naver''website'), -- 따옴표 안에 ' 넣기 가능
('http://google.com', 'Google'),
('http://yahoo.com', 'Yahoo'),
('http://bing.com', 'bing');

create table link_tmp as select * from link where 0=1; -- 컬럼명만 동일한 빈 테이블 생성

select * from link;
select * from link_tmp;

insert into link_tmp select * from link;
drop table link_tmp;

-- update
alter table link add column last_update date;
alter table link alter column last_update set default current_date;
select * from link;

update link set last_update = current_date;
update link set last_update = default;
update link set name = 'Bing' where id = 5;
update link set description = name;

-- update join
CREATE TABLE PRODUCT_SEGMENT
(
ID SERIAL PRIMARY KEY
, SEGMENT VARCHAR NOT NULL
, DISCOUNT NUMERIC (4, 2)
);

INSERT INTO PRODUCT_SEGMENT
(SEGMENT, DISCOUNT)
VALUES
('Grand Luxury', 0.05)
, ('Luxury', 0.06)
, ('Mass', 0.1);