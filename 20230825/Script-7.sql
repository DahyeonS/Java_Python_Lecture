-- 테이블 생성
create table programming (
	programming_id smallint(1) primary key,
	programming_name varchar(50)
);

insert into programming values (1, 'JAVA');
insert into programming values (2, 'C#');
insert into programming values (3, 'C');
insert into programming values (4, 'PYTHON');

select * from programming;

create table programmer (
	programmer_id smallint(1) primary key,
	programmer_name varchar(20),
	career int(2),
	programming_id smallint(1) not null references programming(programming_id)
);

insert into programmer values (1,'김길동',2, 1);
insert into programmer values (2,'박길동',10, 2);
insert into programmer values (3,'다길동',1, 3);
insert into programmer values (4,'헐길동',5, 1);

select * from programmer;

create table product (
	product_id smallint(1) primary key,
	product_name varchar(20),
	product_date date,
	price int(10),
	programmer_id smallint(1) references programmer(progammer_id)
);

insert into product values (1, 'ERP', '15/01/01', 1000, 1);
insert into product values (2, 'SHOPPING MALL', '15/01/22', 2000, 1);
insert into product values (3, 'ANDROID APP', '16/10/01', 3000, 2);
insert into product values (4, 'iOS APP', '16/09/01', 3000, 3);
insert into product values (5, 'NETWORK SYS', '16/09/19',1500, 3);

select * from product;

create table customer (
	customer_id smallint(1) primary key,
	customer_name varchar(20)
);

insert into customer values (1, '1 번고객');
insert into customer values (2, '2 번고객');
insert into customer values (3, '3 번고객');
insert into customer values (4, '4 번고객');
insert into customer values (5, '5 번고객');

select * from customer;

create table product_order (
	customer_id smallint(1) not null references customer(customer_id),
	order_date date,
	product_id smallint(1) not null references product(product_id),
	cnt smallint(2),
	constraint pk_order primary key(customer_id, order_date, product_id)
);

insert into product_order values (1, '16/05/01', 1, 1);
insert into product_order values (2, '16/05/15', 2, 2);
insert into product_order values (3, '16/05/16', 2, 5);
insert into product_order values (4, '15/12/01', 3, 2);
insert into product_order values (5, '15/11/01', 4, 1);

select * from product_order;

-- 테스트 쿼리 작성
-- 1번
select programming_name, count(programmer_id) "count(r.programmer_id)" from programming p1 left join programmer p2
on p1.programming_id = p2.programming_id group by programming_name order by programming_name;

-- 2번
select programming_name from programming p1 where not exists
(select 1 from programmer p2 where p1.programming_id = p2.programming_id);

-- 3번
select programming_name from programming where programming_id not in (select programming_id from programmer);

-- 4번
select programmer_name from programmer p1 inner join programming p2
on p1.programming_id = p2.programming_id where programming_name = 'JAVA';

-- 5번
select programming_name, count(product_id) "count(c.product_id)", max(price) max_price
from programming p1, programmer p2, product p3 where p1.programming_id = p2.programming_id
and p2.programmer_id = p3.programmer_id group by programming_name order by programming_name;

-- 6번
select customer_name from customer c inner join product_order p on c.customer_id = p.customer_id where product_id =
(select product_id from product p1 inner join programmer p2 on p1.programmer_id = p2.programmer_id where career >= 3);

-- 7번
select programming_name, product_name, sum(cnt) cnt from programming p1, programmer p2, product p3, product_order p4
where p1.programming_id = p2.programming_id and p2.programmer_id = p3.programmer_id and p3.product_id = p4.product_id
group by programming_name, product_name order by programming_name;

-- 8번
select product_name, date_format(order_date, '%Y') order_year, sum(price * cnt) order_sum from product p
left join product_order o on p.product_id = o.product_id group by product_name, date_format(order_date, '%Y')
having sum(price * cnt) >= 5000;

-- 9번
select product_name, sum(case
	when date_format(order_date, '%Y') = '2015' then cnt
	else 0 end
) "2015년", sum(case
	when date_format(order_date, '%Y') = '2016' then cnt
	else 0 end
) "2016년" from product p
right join product_order o on p.product_id = o.product_id group by product_name order by product_name;