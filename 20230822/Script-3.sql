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