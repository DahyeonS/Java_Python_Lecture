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

select * from rental where cast(return_date as date) = '2005-05-27'; -- PostgreSQL도 가능
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

select * from (select * from customer) a; -- 서브 쿼리로 조인 시 별칭 필요
```
## MySQL
```SQL
select * from film order by film_id limit 10; -- PostgreSQL도 가능
select * from film order by film_id limit 10 offset 10; -- PostgreSQL도 가능
```
## Oracle
```SQL
CREATE TABLE emp_ddl(
   empno NUMBER(4),
   ename VARCHAR2(10), -- Oracle에서는 VARCHAR2를 사용
   job VARCHAR2(9),
   mgr NUMBER(4),
   hiredate DATE,
   sal NUMBER(7,2),
   comm NUMBER(7,2),
   deptno NUMBER(2)
);

ALTER TABLE person ADD new;

SELECT empno, ename, sal, deptno FROM emp MINUS SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10;

SELECT SYSDATE, SYSDATE + 1, SYSDATE - 1, ADD_MONTHS(SYSDATE, 3), ADD_MONTHS(SYSDATE, -3) FROM DUAL;

SELECT * FROM emp e1, emp e2 WHERE e1.mgr = e2.empno(+);

SELECT * FROM (SELECT * FROM emp e ORDER BY sal DESC) WHERE ROWNUM <= 5;
```
