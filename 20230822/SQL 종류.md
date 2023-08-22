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

select * from film order by film_id limit 10;
select * from film order by film_id limit 10 offset 10;
```
## Oracle
```SQL

```
