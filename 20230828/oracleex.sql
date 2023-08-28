SELECT * FROM dept;

DESC dept;

SELECT DISTINCT deptno FROM emp;

SELECT ename, sal, sal * 12 + comm total FROM emp;

SELECT * FROM emp ORDER BY sal ASC;
SELECT * FROM emp ORDER BY sal DESC;

SELECT * FROM emp WHERE sal = 3000;
SELECT * FROM emp WHERE sal != 3000;
SELECT * FROM emp WHERE sal <> 3000;
SELECT * FROM emp WHERE sal ^= 3000;

SELECT * FROM emp WHERE sal * 12 = 36000;
SELECT * FROM emp WHERE sal > 3000;
SELECT * FROM emp WHERE ename > 'F';

SELECT * FROM emp WHERE deptno = 10 AND job = 'MANAGER';

SELECT * FROM emp WHERE job = 'MANAGER' OR job = 'SALESMAN' OR job = 'CLERK';

SELECT * FROM emp WHERE job IN ('MANAGER', 'SALESMAN', 'CLERK');

SELECT * FROM emp WHERE job <> 'MANAGER' AND job <> 'SALESMAN' AND job <> 'CLERK';

SELECT * FROM emp WHERE job NOT IN ('MANAGER', 'SALESMAN', 'CLERK');