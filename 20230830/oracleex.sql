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
SELECT * FROM (select deptno, max(DECODE(JOB, 'CLERK' , SAL)) AS CLERK,
max(decode(job, 'SALESMAN' , sal)) as SALESMAN,
max(decode(job, 'PRESIDENT', sal)) as PRESIDENT,
max(decode(job, 'MANAGER' , sal)) as MANAGER,
max(decode(job, 'ANALYST' , sal)) as ANALYST from emp group by deptno
order by deptno) UNPIVOT (sal FOR job IN (CLERK, SALESMAN, PRESIDENT,
MANAGER, ANALYST)) ORDER BY deptno, job;

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

-- COMMIT, ROLLBACK
CREATE TABLE dept_tcl AS SELECT * FROM dept;

INSERT INTO dept_tcl VALUES (50, 'DATABASE', 'SEOUL');
UPDATE dept_tcl SET loc = 'BUSAN' WHERE deptno = 40;
DELETE FROM dept_tcl WHERE dname = 'RESEARCH';

SELECT * FROM dept_tcl;

ROLLBACK; -- 테이블 생성 시점으로 돌아감
COMMIT; -- 변경사항 적용

-- LOCK(변경 제한)
UPDATE DEPT_TCL SET DNAME = 'DATA' WHERE DEPTNO = 30;

-- CREATE
CREATE TABLE emp_ddl(
   empno NUMBER(4),
   ename VARCHAR2(10),
   job VARCHAR2(9),
   mgr NUMBER(4),
   hiredate DATE,
   sal NUMBER(7,2),
   comm NUMBER(7,2),
   deptno NUMBER(2)
);

DESC emp_ddl; -- 테이블 정보 호출

-- ALTER
CREATE TABLE emp_alter AS SELECT * FROM emp;
SELECT * FROM emp_alter;

ALTER TABLE emp_alter ADD hp VARCHAR2(20);
ALTER TABLE emp_alter RENAME COLUMN hp TO tel;
ALTER TABLE emp_alter MODIFY empno NUMBER(5);
ALTER TABLE emp_alter DROP COLUMN tel;

-- RENAME
RENAME emp_alter TO emp_new;
RENAME emp_new TO emp_rename;
SELECT * FROM emp_rename;

-- TRUNCATE
TRUNCATE TABLE emp_rename;
ROLLBACK;

-- DROP
DROP TABLE emp_rename;
ROLLBACK;

-- DATE DICTIONARY
SELECT * FROM DICT;
SELECT * FROM DICTIONARY;

SELECT * FROM USER_TABLES;

SELECT OWNER, TABLE_NAME FROM ALL_TABLES;

SELECT * FROM DBA_TABLES; -- 커맨드로 관리자 접속을 한 뒤 입력

-- INDEX
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_IND_COLUMNS;

CREATE INDEX idx_emp_sal ON emp(sal);
DROP INDEX idx_emp_sal;

-- VIEW
CREATE VIEW vw_emp20 AS
(SELECT empno, ename, job, deptno FROM emp WHERE deptno = 20);

SELECT view_name, text_length, text FROM user_views;

SELECT * FROM vw_emp20 WHERE job = 'CLERK';

DROP VIEW vw_emp20;

-- ROWNUM
SELECT ROWNUM, e.* FROM emp e;
SELECT ROWNUM, e.* FROM emp e ORDER BY sal DESC;
SELECT ROWNUM, e.* FROM (SELECT rownum, e.* FROM emp e ORDER BY sal DESC) e;

SELECT ROWNUM, e.* FROM (SELECT rownum, e.* FROM emp e ORDER BY sal DESC) e
WHERE ROWNUM <= 3;

SELECT ROWNUM, e.* FROM (SELECT rownum, e.* FROM emp e ORDER BY sal DESC) e
WHERE ROWNUM BETWEEN 10 AND 12;
SELECT ROWNUM, e.* FROM (SELECT rownum, e.* FROM emp e ORDER BY sal DESC) e
WHERE ROWNUM >= 10 AND ROWNUM <= 12;
SELECT ROWNUM, e.* FROM (SELECT rownum, e.* FROM emp e ORDER BY sal DESC) e
WHERE ROWNUM >= 10;

SELECT * FROM (SELECT * FROM emp e ORDER BY sal DESC) WHERE ROWNUM <= 5;

-- SEQUENCE
CREATE SEQUENCE seq_dept_sequence
    INCREMENT BY 10 -- 증가값, 생략 시 1
    START WITH 10 -- 시작값, 생략 시 1
    MAXVALUE 90 -- 최대값, 생략 시 10^27
    NOCYCLE; -- 반복 실행 없음(생략 시 반복)

-- CURRVAL(마지막 생성 번호), NEXTVAL(마지막+증가값 번호)
CREATE TABLE dept_seq AS SELECT * FROM dept WHERE 1<>1;

INSERT INTO dept_seq VALUES(seq_dept_sequence.NEXTVAL, 'DATABASE', 'SEOUL');
INSERT INTO dept_seq VALUES(seq_dept_sequence.NEXTVAL, 'DATABASE1', 'SEOUL1');
SELECT * FROM dept_seq;

SELECT seq_dept_sequence.CURRVAL FROM DUAL;
SELECT seq_dept_sequence.NEXTVAL FROM DUAL;

ALTER SEQUENCE seq_dept_sequence
    INCREMENT BY 3
    MAXVALUE 99
    CYCLE;
    
DROP SEQUENCE seq_dept_sequence;

-- CONSTRAINT
SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_OWNER, R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS
WHERE TABLE_NAME IN ('EMP', 'DEPT');

-- RECORD
SET SERVEROUTPUT ON; -- 결과 출력

DECLARE
    TYPE rec_dept IS RECORD(
        deptno NUMBER(2) NOT NULL := 99, -- :=(DEFALUT, 할당 연산자), 99(2자리 수)
        dname DEPT.DNAME%TYPE, -- 참조변수
        loc DEPT.LOC%TYPE
    );
    
dept_rec rec_dept; -- 레코드(rec_dept)형 변수 선언
    
BEGIN
    dept_rec.deptno := 99;
    dept_rec.dname := 'DATABASE';
    dept_rec.loc := 'SEOUL';
    INSERT INTO dept_record VALUES dept_rec;
    
    DBMS_OUTPUT.PUT_LINE('deptno: ' || dept_rec.deptno); -- print() 함수랑 비슷
    DBMS_OUTPUT.PUT_LINE('dname: ' || dept_rec.dname);
    DBMS_OUTPUT.PUT_LINE('loc: ' || dept_rec.loc);
END;
/

CREATE TABLE dept_record AS SELECT * FROM dept;
SELECT * FROM dept_record;

-- CURSOR
SET SERVEROUTPUT ON;

DECLARE
	v_deptno DEPT.DEPTNO%TYPE;

	CURSOR c1(p_deptno DEPT.DEPTNO%TYPE) IS
		SELECT deptno, dname, loc FROM dept WHERE deptno = p_deptno;

BEGIN
	v_deptno := &INPUT_DEPTNO;
	
	FOR c1_rec IN c1(v_deptno) LOOP
		DBMS_OUTPUT.PUT_LINE('deptno: ' || c1_rec.deptno);
		DBMS_OUTPUT.PUT_LINE('dname: ' || c1_rec.dname);
		DBMS_OUTPUT.PUT_LINE('loc: ' || c1_rec.loc);
	END LOOP;

END;
/

-- 묵시적 커서
SET SERVEROUTPUT ON;

BEGIN
   UPDATE DEPT SET DNAME='DATABASE' -- dept_record 테이블 로도 테스트
    WHERE DEPTNO = 50;

   DBMS_OUTPUT.PUT_LINE('갱신된 행의 수 : ' || SQL%ROWCOUNT);

   IF (SQL%FOUND) THEN
      DBMS_OUTPUT.PUT_LINE('갱신 대상 행 존재 여부 : true');
   ELSE
      DBMS_OUTPUT.PUT_LINE('갱신 대상 행 존재 여부 : false');
   END IF;

   IF (SQL%ISOPEN) THEN
      DBMS_OUTPUT.PUT_LINE('커서의 OPEN 여부 : true');
   ELSE
      DBMS_OUTPUT.PUT_LINE('커서의 OPEN 여부 : false');
   END IF;

END;
/

-- PROCEDURE
CREATE OR REPLACE PROCEDURE pro_noparam
IS
    v_empno NUMBER(4) := 7788;
    v_ename VARCHAR2(10);
BEGIN
    v_ename := 'SCOTT';
    DBMS_OUTPUT.PUT_LINE('v_empno: ' || v_empno);
    DBMS_OUTPUT.PUT_LINE('v_ename: ' || v_ename);
END;
/

EXECUTE pro_noparam;

/*
-파라미터-
IN: 기본 값, 입력 값
OUT: 출력 값(return value)
IN OUT: 입, 출력 값
*/

CREATE OR REPLACE PROCEDURE pro_param_in
(
    param1 IN NUMBER,
    param2 NUMBER,
    param3 NUMBER := 3,
    param4 NUMBER DEFAULT 4
)
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('param1: ' || param1);
    DBMS_OUTPUT.PUT_LINE('param2: ' || param2);
    DBMS_OUTPUT.PUT_LINE('param3: ' || param3);
    DBMS_OUTPUT.PUT_LINE('param4: ' || param4);
END;
/

EXECUTE pro_param_in(1, 2, 9, 8);

EXECUTE pro_param_in(1, 2);
EXECUTE pro_param_in(1); -- 오류

EXECUTE pro_param_in(param1 => 10,param2 => 2,param3 => 9,param4 => 8);


CREATE OR REPLACE PROCEDURE pro_param_out
(
    in_empno IN EMP.EMPNO%TYPE,
    out_ename OUT EMP.ENAME%TYPE,
    out_sal OUT EMP.SAL%TYPE
)
IS
BEGIN
    SELECT ename, sal INTO out_ename, out_sal FROM emp WHERE empno = in_empno;
END pro_param_out;
/

DECLARE
    v_ename EMP.ENAME%TYPE;
    v_sal EMP.SAL%TYPE;
BEGIN
    pro_param_out(7788, v_ename, v_sal);
    DBMS_OUTPUT.PUT_LINE('ename: ' || v_ename);
    DBMS_OUTPUT.PUT_LINE('sal: ' || v_sal);
END;
/

SELECT * FROM emp;

DECLARE
    v_ename EMP.ENAME%TYPE;
    v_sal EMP.SAL%TYPE;
BEGIN
    pro_param_out(7369, v_ename, v_sal);
    DBMS_OUTPUT.PUT_LINE('ename: ' || v_ename);
    DBMS_OUTPUT.PUT_LINE('sal: ' || v_sal);
END;
/

CREATE OR REPLACE PROCEDURE pro_param_inout
(
    inout_no IN OUT NUMBER
)
IS
BEGIN
    inout_no := inout_no * 2;
END pro_param_inout;
/

DECLARE
    no NUMBER;
BEGIN
    no := 5;
    pro_param_inout(no);
    DBMS_OUTPUT.PUT_LINE('no: ' || no);
END;
/

-- COMPILE ERROR
CREATE OR REPLACE PROCEDURE pro_err
IS
    err_no NUMBER;
BEGIN
    err_no = 100;
    DBMS_OUTPUT.PUT_LINE('err_no: ' || err_no);
END;
/

SHOW ERROR;

SELECT * FROM USER_ERRORS WHERE name = 'PRO_ERR';

-- STORED FUNCTION
CREATE OR REPLACE FUNCTION func_aftertax(
    sal IN NUMBER
)
RETURN NUMBER
IS
    tax NUMBER := 0.05;
BEGIN
    RETURN ROUND(sal - (sal * tax));
END func_aftertax;
/

SELECT func_aftertax(6000) FROM DUAL;
SELECT empno, ename, sal, func_aftertax(sal) AS aftertax FROM emp;

-- TRIGGER
CREATE TABLE emp_trg AS SELECT * FROM emp;

SELECT * FROM emp_trg;

CREATE OR REPLACE TRIGGER trg_emp_nodml_weekend
BEFORE
INSERT OR UPDATE OR DELETE ON emp_trg
BEGIN
    IF TO_CHAR(SYSDATE, 'DY') IN ('토', '일') THEN
        IF INSERTING THEN
            RAISE_APPLICATION_ERROR(-20000, '주말 사원정보 추가 불가');
        ELSIF UPDATING THEN
            RAISE_APPLICATION_ERROR(-20001, '주말 사원정보 수정 불가');
        ELSIF DELETING THEN
            RAISE_APPLICATION_ERROR(-20002, '주말 사원정보 삭제 불가');
        ELSE
            RAISE_APPLICATION_ERROR(-20003, '주말 사원정보 변경 불가');
        END IF;
    END IF;
END;
/

-- 주말에 실행하면 오류
INSERT INTO emp_trg VALUES(1, 'hong', 'job', 1, '1980-12-17 00:00:00.000', 1, 1, 1);
UPDATE emp_trg SET sal = 3500 WHERE empno = 7788;
DELETE FROM emp_trg WHERE empno = 7369;

DROP TRIGGER trg_emp_nodml_weekend;