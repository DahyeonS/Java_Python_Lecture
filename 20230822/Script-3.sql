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