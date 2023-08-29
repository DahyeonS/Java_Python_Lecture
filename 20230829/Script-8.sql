SELECT * FROM DEPT;

-- SESSION(동시 접속)
SELECT * FROM DEPT_TCL;

DELETE FROM DEPT_TCL WHERE DEPTNO = 50;

COMMIT;

-- LOCK(변경 제한)
UPDATE DEPT_TCL SET LOC = 'SEOUL' WHERE DEPTNO = 30;

COMMIT;

-- RECORD(DBeaver 출력용)
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
    DBMS_OUTPUT.PUT_LINE('deptno: ' || dept_rec.deptno); -- print() 함수랑 비슷
    DBMS_OUTPUT.PUT_LINE('dname: ' || dept_rec.dname);
    DBMS_OUTPUT.PUT_LINE('loc: ' || dept_rec.loc);
END;


DECLARE
    TYPE rec_dept IS RECORD(
        deptno NUMBER(2) NOT NULL := 99, -- :=(DEFALUT, 할당 연산자), 99(2자리 수)
        dname DEPT.DNAME%TYPE, -- 참조변수
        loc DEPT.LOC%TYPE
    );
    
dept_rec rec_dept; -- 레코드(rec_dept)형 변수 선언
    
BEGIN
    dept_rec.deptno := 50;
    dept_rec.dname := 'DB';
    dept_rec.loc := 'SEOUL';
    UPDATE dept_record SET ROW = dept_rec WHERE deptno = 99;
    
    DBMS_OUTPUT.PUT_LINE('deptno: ' || dept_rec.deptno); -- print() 함수랑 비슷
    DBMS_OUTPUT.PUT_LINE('dname: ' || dept_rec.dname);
    DBMS_OUTPUT.PUT_LINE('loc: ' || dept_rec.loc);
END;

SELECT * FROM DEPT_RECORD;