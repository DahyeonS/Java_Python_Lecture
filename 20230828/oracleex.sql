-- SELECT
SELECT * FROM dept;

DESC dept;

SELECT DISTINCT deptno FROM emp;

SELECT ename, sal, sal * 12 + comm total FROM emp;

SELECT * FROM emp ORDER BY sal ASC;
SELECT * FROM emp ORDER BY sal DESC;

-- = <> != ^=
SELECT * FROM emp WHERE sal = 3000;
SELECT * FROM emp WHERE sal != 3000;
SELECT * FROM emp WHERE sal <> 3000;
SELECT * FROM emp WHERE sal ^= 3000;

SELECT * FROM emp WHERE sal * 12 = 36000;
SELECT * FROM emp WHERE sal > 3000;
SELECT * FROM emp WHERE ename > 'F';

-- AND
SELECT * FROM emp WHERE deptno = 10 AND job = 'MANAGER';

-- OR, IN
SELECT * FROM emp WHERE job = 'MANAGER' OR job = 'SALESMAN' OR job = 'CLERK';
SELECT * FROM emp WHERE job IN ('MANAGER', 'SALESMAN', 'CLERK');

-- NOT
SELECT * FROM emp WHERE job <> 'MANAGER' AND job <> 'SALESMAN' AND job <> 'CLERK';
SELECT * FROM emp WHERE job NOT IN ('MANAGER', 'SALESMAN', 'CLERK');

-- BETWEEN
SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;

SELECT * FROM emp WHERE sal < 2000 OR sal > 3000;
SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;

-- 와일드 카드: _  1개 문자
-- 와일드 카드: % 모든 문자
SELECT * FROM emp WHERE ename LIKE '_L%';
SELECT * FROM emp WHERE ename LIKE 'A%';
SELECT * FROM emp WHERE ename LIKE '%Z';
SELECT * FROM emp WHERE ename NOT LIKE '%A%';

-- NULL
SELECT * FROM emp WHERE COMM IS NULL;
SELECT * FROM emp WHERE COMM IS NOT NULL;

-- UNION
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10
UNION SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 20;

-- UNION ALL
SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10
UNION SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10;

SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10
UNION ALL SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10;

-- MINUS
SELECT empno, ename, sal, deptno FROM emp
MINUS SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10;

-- INTERSECT
SELECT empno, ename, sal, deptno FROM emp
INTERSECT SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10;

-- UPPER, LOWER, INITCAP
SELECT ename, UPPER(ename), LOWER(ename), INITCAP(ename) FROM emp
WHERE UPPER(ename) = UPPER('scott');
SELECT ename, UPPER(ename), LOWER(ename), INITCAP(ename) FROM emp
WHERE UPPER(ename) LIKE UPPER('scott');

-- LENGTH
SELECT ename, LENGTH(ename) FROM emp WHERE LENGTH(ename) > 5;
SELECT LENGTH('한글'), LENGTHB('한글') FROM DUAL;

-- SUBSTR
SELECT job, SUBSTR(job, 1, 2), SUBSTR(job, 3, 2), SUBSTR(job, 3, 5) FROM emp;

SELECT job, SUBSTR(job, -LENGTH(job)), SUBSTR(job, -LENGTH(job), 2),
SUBSTR(job, -3) FROM emp;

-- INSTR
SELECT ename, INSTR(ename, 'S') FROM emp WHERE INSTR(ename, 'S') > 0;
SELECT ename, INSTR(ename, 'S') FROM emp WHERE ename LIKE '%S%';

-- REPLACE
SELECT '010-1234-5678' AS pre, replace('010-1234-5678', '-', ''),
replace('010-1234-5678', '-') as repl FROM DUAL;

-- LPAD, RPAD
SELECT 'Oracle', LPAD('Oracle', 10, '#'), RPAD('Oracle', 10, '#') FROM DUAL;
SELECT RPAD('720529-', 14, '*'), RPAD('010-6789-', 13, '*') FROM DUAL;

-- CONCAT
SELECT CONCAT(empno, ename), CONCAT(empno, concat(':', ename)),
empno || ':' || ename FROM emp WHERE LOWER(ename) = 'scott';

-- TRIM
SELECT '[' || TRIM('    Oracle     ') || ']',
'[' || LTRIM('    Oracle     ') || ']',
'[' || RTRIM('    Oracle     ') || ']',
'[' || RTRIM(LTRIM('    Oracle     ')) || ']' FROM DUAL;

-- ROUND
SELECT ROUND(1234.5678), ROUND(1234.5678, 0), ROUND(1234.5678, 1),
ROUND(1234.5678, 2), ROUND(1234.5678, -1), ROUND(1236.5678, -1),
ROUND(1234.5678, -2), ROUND(1264.5678, -2) FROM DUAL;

-- TRUNC
SELECT TRUNC(1234.5678), TRUNC(1234.5678, 0), TRUNC(1234.5678, 1),
TRUNC(1234.5678, 2), TRUNC(1234.5678, -1), TRUNC(1236.5678, -1),
TRUNC(1234.5678, -2), TRUNC(1264.5678, -2) FROM DUAL;

-- CEIL, FLOOR
SELECT ceil(3.14), FLOOR(3.14), ceil(-3.14), FLOOR(-3.14) FROM DUAL;

-- MOD
SELECT MOD(15, 6), MOD(10, 2), MOD(11, 2) FROM DUAL;

-- SYSDATE, ADD_MONTHS
SELECT SYSDATE, SYSDATE + 1, SYSDATE - 1, /*SYSDATE + SYSDATE, */ 
ADD_MONTHS(SYSDATE, 3), ADD_MONTHS(SYSDATE, -3) FROM DUAL;

SELECT empno, ename, hiredate, ADD_MONTHS(hiredate, 120) FROM emp
WHERE ADD_MONTHS(hiredate, 120) > '1991-01-01';

-- MONTHS_BETWEEN
SELECT empno, ename, hiredate, SYSDATE,
ROUND(MONTHS_BETWEEN(hiredate, SYSDATE)) AS month1,
ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)) AS month2,
TRUNC(MONTHS_BETWEEN(SYSDATE, hiredate)) AS month3 FROM EMP;

-- NEXT_DAY
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') now,
TO_CHAR(NEXT_DAY(SYSDATE, '금요일'), 'YYYY-MM-DD') day1,
TO_CHAR(NEXT_DAY(SYSDATE, 6), 'YYYY-MM-DD') day2 -- 일(1) ~ 토(7)
FROM DUAL;

-- 형변환
SELECT empno, ename, empno + '500' FROM emp WHERE ename = 'SCOTT';

-- TO_CHAR
SELECT sal, TO_CHAR(sal, '$999,999') AS sal_$,
TO_CHAR(sal, 'L999,999') AS sal_, TO_CHAR(sal, '999,999.00') AS sal,
TO_CHAR(sal, '999,999.99') AS sal FROM emp;

-- TO_NUMBER
SELECT 1300 - '1500', '1300' - 1500 FROM DUAL;
SELECT '1300' - '1500' FROM DUAL;
SELECT TO_NUMBER('1,300', '999,999') - TO_NUMBER('1,500', '999,999') FROM DUAL;

-- TO_DATE
SELECT TO_DATE('2023-08-28', 'YYYY-MM-DD') AS today1,
TO_DATE('20230828', 'YYYY-MM-DD') AS today2,
TO_DATE('230828', 'YY/MM/DD') AS today3,
TO_DATE('230828', 'RR/MM/DD') AS today4 FROM DUAL;

SELECT * FROM emp WHERE hiredate > TO_DATE('1981/06/01', 'YYYY/MM/DD');

-- NVL
SELECT empno, ename, sal, sal+comm, NVL(comm, 0), sal + NVL(comm, 0) FROM emp;
SELECT empno, ename, comm, NVL2(comm, 'O', 'X') FROM emp;

-- CASE
SELECT empno, ename, job, sal,
CASE job
    WHEN 'MANAGER' THEN sal * 1.1
    WHEN 'SALESMAN' THEN sal * 1.05
    WHEN 'ANALYST' THEN sal
    ELSE sal * 1.03
END AS upsal FROM emp;

SELECT empno, ename, comm,
CASE 
    WHEN comm is null THEN sal * 1.1
    WHEN comm = 0 THEN sal * 1.05
    WHEN comm > 0 THEN sal
    ELSE sal * 1.03
END AS upsal FROM emp;

-- DECODE
SELECT empno, ename, job, sal, DECODE(job, 'MANAGER', sal * 11,
'SALESMAN', sal * 1.05, 'ANALYST', sal * 1, sal * 1.03) AS upsal FROM emp;

-- 집계함수
SELECT SUM(DISTINCT sal), SUM(sal) FROM emp;
SELECT COUNT(DISTINCT sal), COUNT(sal) FROM emp;
SELECT ROUND(AVG(DISTINCT sal)), ROUND(AVG(sal)),
ROUND(SUM(sal) / COUNT(sal)) FROM emp;

SELECT DISTINCT deptno FROM emp;

SELECT ROUND(AVG(sal)), '10' FROM emp WHERE deptno = 10;
SELECT ROUND(AVG(sal)), '20' FROM emp WHERE deptno = 20;
SELECT ROUND(AVG(sal)), '30' FROM emp WHERE deptno = 30;

-- GROUP BY
SELECT deptno, ROUND(AVG(sal)) FROM emp GROUP BY deptno;
SELECT deptno, job, ROUND(AVG(sal)) FROM emp GROUP BY deptno, job
ORDER BY deptno, job;

-- HAVING
SELECT deptno, job, ROUND(AVG(sal)) FROM emp GROUP BY deptno, job
HAVING AVG(sal) > 2000 ORDER BY deptno, job;
SELECT deptno, job, ROUND(AVG(sal)) FROM emp WHERE sal > 2000
GROUP BY deptno, job ORDER BY deptno, job;

-- ROLL UP
SELECT deptno, job, COUNT(*), MAX(sal), SUM(sal), ROUND(AVG(sal)) FROM emp
GROUP BY deptno, job ORDER BY deptno, job;
SELECT deptno, job, COUNT(*), MAX(sal), SUM(sal), ROUND(AVG(sal)) FROM emp
GROUP BY ROLLUP(deptno, job) ORDER BY deptno, job;

-- CUBE
SELECT deptno, job, COUNT(*), MAX(sal), SUM(sal), ROUND(AVG(sal)) FROM emp
GROUP BY CUBE(deptno, job) ORDER BY deptno, job;

-- GROUPING SETS
SELECT deptno, job, COUNT(*) FROM emp GROUP BY GROUPING SETS(deptno, job);

-- GROUPING
SELECT deptno, job, COUNT(*), MAX(sal), SUM(sal), ROUND(AVG(sal)),
GROUPING(deptno), GROUPING(job)
FROM emp GROUP BY CUBE(deptno, job) ORDER BY deptno, job;

SELECT DECODE(GROUPING(deptno), 1, 'ALL_DEPT', deptno) AS deptno,
DECODE(GROUPING(job), 1, 'ALL_JOB', deptno) AS job, COUNT(*) FROM emp
GROUP BY CUBE(deptno, job) ORDER BY deptno, job;

-- LISTAGG
SELECT deptno, ename FROM emp GROUP BY deptno, ename; -- 세로

SELECT deptno,
LISTAGG(ename, ',') WITHIN GROUP(ORDER BY sal DESC) AS enames
FROM emp GROUP BY deptno;

-- PIVOT
SELECT deptno, job, MAX(sal) FROM emp GROUP BY deptno, job;

SELECT * FROM (select deptno, job, sal from emp)
PIVOT(MAX(sal) FOR deptno IN (10, 20 ,30));

SELECT * FROM (select deptno, job, sal from emp)
PIVOT(MAX(sal) FOR job IN ('CLERK', 'SALESMAN', 'PRESIDENT'));

-- UNPIVOT
SELECT *
  FROM(SELECT DEPTNO,
              MAX(DECODE(JOB, 'CLERK' , SAL)) AS "CLERK",
              MAX(DECODE(JOB, 'SALESMAN' , SAL)) AS "SALESMAN",
              MAX(DECODE(JOB, 'PRESIDENT', SAL)) AS "PRESIDENT",
              MAX(DECODE(JOB, 'MANAGER' , SAL)) AS "MANAGER",
              MAX(DECODE(JOB, 'ANALYST' , SAL)) AS "ANALYST"
         FROM EMP
       GROUP BY DEPTNO
       ORDER BY DEPTNO)
UNPIVOT(
   SAL FOR JOB IN (CLERK, SALESMAN, PRESIDENT, MANAGER,ANALYST))
ORDER BY DEPTNO, JOB;

-- NATURAL JOIN
SELECT * FROM emp e NATURAL JOIN dept d;
SELECT * FROM emp e JOIN dept d ON e.deptno = d.deptno;
SELECT * FROM emp e JOIN dept d USING (deptno);

-- LEFT JOIN
SELECT * FROM emp e1, emp e2 WHERE e1.mgr = e2.empno(+);
SELECT * FROM emp e1 LEFT OUTER JOIN emp e2 ON e1.mgr = e2.empno;

-- RIGHT JOIN
SELECT * FROM emp e1, emp e2 WHERE e1.mgr(+) = e2.empno;
SELECT * FROM emp e1 RIGHT OUTER JOIN emp e2 ON e1.mgr = e2.empno;

-- SUBQUERY
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- ANY
SELECT deptno, SUM(sal) FROM emp WHERE sal < ANY(select max(sal) from emp)
GROUP BY deptno;
SELECT deptno, SUM(sal) FROM emp WHERE sal <
ANY(select sal from emp where deptno = 30) GROUP BY deptno;

-- ALL
SELECT * FROM emp where sal < ALL (select sal from emp where deptno = 30);
SELECT * FROM emp WHERE sal < (select min(sal) from emp where deptno = 30)
ORDER BY sal, deptno;

-- EXISTS
SELECT * FROM emp WHERE EXISTS (select dname from dept where deptno = 10);
SELECT * FROM EMP WHERE EXISTS (select dname from dept where deptno = 50);

-- 비교할 열이 여러 개
SELECT * FROM emp WHERE (deptno, sal) IN (select deptno, max(sal) from emp
group by deptno);
                         
-- 인라인 뷰
SELECT empno, ename, job, sal, (select grade from salgrade
where e.sal between losal and hisal) AS salgrade, deptno,
(select dname from dept d where e.deptno = d.deptno) AS dname FROM emp e;
