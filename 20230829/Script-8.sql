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

-- COLLECTION
DECLARE
	TYPE ITAB_EX IS TABLE OF VARCHAR2(20)
	INDEX BY PLS_INTEGER;

text_arr ITAB_EX;

BEGIN
	text_arr(1) := '1st data';
	text_arr(2) := '2st data';
	text_arr(3) := '3st data';
	text_arr(4) := '4st data';
	DBMS_OUTPUT.PUT_LINE('text_arr(1): ' || text_arr(1));
END;


DECLARE
	TYPE REC_DEPT IS RECORD(
        deptno DEPT.DEPTNO%TYPE,
        dname DEPT.DNAME%TYPE
    );
	TYPE ITAB_DEPT IS TABLE OF REC_DEPT
	INDEX BY PLS_INTEGER;

dept_arr ITAB_DEPT;
idx PLS_INTEGER := 0;

BEGIN
	FOR i IN (SELECT deptno, dname FROM DEPT) LOOP
		idx := idx + 1;
		dept_arr(idx).deptno := i.deptno;
		dept_arr(idx).dname := i.dname;
		
		DBMS_OUTPUT.PUT_LINE('deptno: ' || dept_arr(idx).deptno);
		DBMS_OUTPUT.PUT_LINE('dname: ' || dept_arr(idx).dname);
	END LOOP;
END;

-- 반복문
DECLARE
	TYPE ITAB_DEPT IS TABLE OF DEPT%ROWTYPE
	INDEX BY PLS_INTEGER;

dept_arr ITAB_DEPT;
idx PLS_INTEGER := 0;

BEGIN
	FOR i IN (SELECT deptno, dname, loc FROM DEPT) LOOP
		idx := idx + 1;
		dept_arr(idx).deptno := i.deptno;
		dept_arr(idx).dname := i.dname;
		dept_arr(idx).loc := i.loc;
		
		DBMS_OUTPUT.PUT_LINE('deptno: ' || dept_arr(idx).deptno);
		DBMS_OUTPUT.PUT_LINE('dname: ' || dept_arr(idx).dname);
		DBMS_OUTPUT.PUT_LINE('loc: ' || dept_arr(idx).loc);
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('dept_arr.count: ' || dept_arr.count);
	DBMS_OUTPUT.PUT_LINE('dept_arr.first: ' || dept_arr.FIRST);
	DBMS_OUTPUT.PUT_LINE('dept_arr.last: ' || dept_arr.LAST);
	DBMS_OUTPUT.PUT_LINE('dept_arr.prior: ' || dept_arr.PRIOR(2));
	DBMS_OUTPUT.PUT_LINE('dept_arr.next: ' || dept_arr.NEXT(2));
END;

-- CURSOR
DECLARE
	V_DEPT_ROW DEPT%ROWTYPE;

BEGIN
	SELECT deptno, dname, loc INTO v_dept_row FROM dept WHERE deptno = 40;
	DBMS_OUTPUT.PUT_LINE('deptno: ' || v_dept_row.deptno);
END;


DECLARE
	V_DEPT_ROW DEPT%ROWTYPE;

	CURSOR c1 IS -- 커서 선언
		SELECT deptno, dname, loc INTO v_dept_row FROM dept WHERE deptno = 40;

BEGIN
	OPEN c1; -- 커서 열기

	FETCH c1 INTO v_dept_row; -- 데이터 한 행씩 가져오기

	CLOSE c1; -- 커서 닫기
	
	DBMS_OUTPUT.PUT_LINE('deptno: ' || v_dept_row.deptno);
	DBMS_OUTPUT.PUT_LINE('dname: ' || v_dept_row.dname);
	DBMS_OUTPUT.PUT_LINE('loc: ' || v_dept_row.loc);
END;


DECLARE
	V_DEPT_ROW DEPT%ROWTYPE;

	CURSOR c1 IS
		SELECT deptno, dname, loc INTO v_dept_row FROM dept;

BEGIN
	OPEN c1;
	
	LOOP
		FETCH c1 INTO v_dept_row;
	
		EXIT WHEN c1%NOTFOUND;
		
		DBMS_OUTPUT.PUT_LINE('deptno: ' || v_dept_row.deptno);
		DBMS_OUTPUT.PUT_LINE('dname: ' || v_dept_row.dname);
		DBMS_OUTPUT.PUT_LINE('loc: ' || v_dept_row.loc);
	END LOOP;

	CLOSE c1; -- 커서 닫기
	
	
END;


DECLARE
	V_DEPT_ROW DEPT%ROWTYPE;

	CURSOR c1 IS
		SELECT deptno, dname, loc INTO v_dept_row FROM dept;

BEGIN
	
	FOR c1_rec IN c1 LOOP
		DBMS_OUTPUT.PUT_LINE('deptno: ' || c1_rec.deptno);
		DBMS_OUTPUT.PUT_LINE('dname: ' || c1_rec.dname);
		DBMS_OUTPUT.PUT_LINE('loc: ' || c1_rec.loc);
	END LOOP;
	
END;


DECLARE
	V_DEPT_ROW DEPT%ROWTYPE;

	CURSOR c1(p_deptno DEPT.DEPTNO%TYPE) IS
		SELECT deptno, dname, loc INTO v_dept_row FROM dept WHERE deptno = p_deptno;

BEGIN
	OPEN c1(10);
	
	LOOP
		FETCH c1 INTO v_dept_row;
	
		EXIT WHEN c1%NOTFOUND;
		
		DBMS_OUTPUT.PUT_LINE('deptno: ' || v_dept_row.deptno);
		DBMS_OUTPUT.PUT_LINE('dname: ' || v_dept_row.dname);
		DBMS_OUTPUT.PUT_LINE('loc: ' || v_dept_row.loc);
	END LOOP;

	CLOSE c1;
END;


DECLARE
	V_DEPT_ROW DEPT%ROWTYPE;

	CURSOR c1(p_deptno DEPT.DEPTNO%TYPE) IS
		SELECT deptno, dname, loc INTO v_dept_row FROM dept WHERE deptno = p_deptno;

BEGIN
	OPEN c1(20);
	
	LOOP
		FETCH c1 INTO v_dept_row;
	
		EXIT WHEN c1%NOTFOUND;
		
		DBMS_OUTPUT.PUT_LINE('deptno: ' || v_dept_row.deptno);
		DBMS_OUTPUT.PUT_LINE('dname: ' || v_dept_row.dname);
		DBMS_OUTPUT.PUT_LINE('loc: ' || v_dept_row.loc);
	END LOOP;

	CLOSE c1;
END;