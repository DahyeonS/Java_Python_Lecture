# SQL 종류
## SQLite
```SQL
SELECT * FROM bird_tracking_devices WHERE ROWID = 1;

SELECT SUBSTR('1994-06-09', 1, 4);
SELECT CURRENT_TIMESTAMP;
```
## MSSQL
```SQL
SELECT TOP 3 * FROM Products;
```
## PostgreSQL
- serial - int의 자동증가
```SQL
create table t1 (
id serial not null primary key,
bcolor varchar,
fcolor varchar
);

select * from film order by title fetch first row only;

select * from rental where cast(return_date as date) = '2005-05-27';
```
## MySQL
```SQL
select * from film order by film_id limit 10; -- PostgreSQL도 가능
select * from film order by film_id limit 10 offset 10; -- PostgreSQL도 가능
```
## Oracle
```SQL

```
