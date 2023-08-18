-- SELECT
SELECT * FROM person WHERE id = 5;

SELECT * FROM person WHERE name = '박혜리';

SELECT * FROM person WHERE birthday IS NULL;
UPDATE person SET name = '김아영' WHERE id = 5;
UPDATE person SET birthday = '1986-06-09' WHERE id = 3;
UPDATE person SET birthday = '1992-06-09' WHERE id = 4;
SELECT * FROM person;

-- like (검색) %
SELECT * FROM person WHERE name LIKE '%혜리'; 
SELECT * FROM person WHERE name LIKE '혜리%'; 
SELECT * FROM person WHERE name LIKE '%혜리%';

SELECT * FROM person WHERE birthday IS NOT NULL ORDER BY birthday DESC;

-- 5.2 Person 테이블에서 Name이 김으로 시작하는 행을 찾아서, 그 값을 유라로 바꾸어 보라.
UPDATE person SET name = '유라' WHERE name LIKE '김%';
SELECT * FROM person;

-- 5.3 연습문제 3.1에서 만든 pets 테이블에 다음과 같이 데이터를 넣어라.
INSERT INTO pets VALUES (1, 'Dr.Harris', 'Rabbit');
INSERT INTO pets VALUES (2, 'Moon', 'Dog');
INSERT INTO pets VALUES (3, 'Ripley', 'Cat');
INSERT INTO pets VALUES (4, 'Tom', 'Cat');
SELECT * FROM pets;

-- 칼럼 추가
ALTER TABLE person ADD COLUMN new2 INTEGER NOT NULL DEFAULT 0; -- 칼럼 추가
ALTER TABLE person DROP new2;
ALTER TABLE person RENAME COLUMN new to height;

-- 데이터 수정
UPDATE person SET height = 167 WHERE id = 3;
UPDATE person SET height = 170.3 WHERE id = 4;
UPDATE person SET height = 164 WHERE id = 5;
SELECT * FROM person;

-- Person 테이블에 Weight 칼럼을 추가해보라.
ALTER TABLE person ADD COLUMN weight INTEGER NOT NULL DEFAULT 0;

UPDATE person SET weight = 50 WHERE id = 1;
UPDATE person SET weight = 0 WHERE id = 2;
UPDATE person SET weight = 54 WHERE id = 4;
UPDATE person SET weight = 46 WHERE id = 5;
SELECT * FROM person;

-- 별명주기 AS
SELECT name AS 이름, birthday 생일 FROM person;

-- ROUND()
SELECT name, height, weight, ROUND(weight / (height * height * 0.0001), 1) bmi FROM person;

-- VIEW
CREATE VIEW brithdayview AS SELECT name, birthday bdate,
SUBSTR(birthday, 1, 4) yyyy, SUBSTR(birthday, 6, 2) mm, SUBSTR(birthday, 9, 2) dd FROM person;
SELECT * FROM brithdayview;
SELECT * FROM brithdayview WHERE yyyy > '1992';

-- CASE 조건문
SELECT name, bdate, mm,
CASE
	WHEN mm = '01' THEN 'Jan.'
	WHEN mm = '02' THEN 'Feb.'
	WHEN mm = '03' THEN 'Mar.'
	WHEN mm = '06' THEN 'Jun.'
END as month
FROM brithdayview;

-- 날짜
SELECT name, birthday 생일, STRFTIME('%Y', 'now') - SUBSTR(birthday, 1, 4) "만 나이", (STRFTIME('%m-%d', 'now') < SUBSTR(birthday, 6)) FROM person;

-- 집계함수
SELECT COUNT(*) FROM person;
SELECT COUNT(id) FROM person; -- count() 함수는 보통 기본키를 넣음
SELECT COUNT(height) FROM person; -- NULL값은 집계되지 않음

SELECT MAX(height) FROM person;
SELECT name, MAX(height) FROM person; -- 원래는 실행 불가 구문
SELECT name, SUM(height) FROM person; -- 원래는 실행 불가 구문

SELECT SUM(height) / COUNT(id) FROM person; -- 125.325
SELECT AVG(height) FROM person; -- 167.1(NULL값 제외)

UPDATE person SET height = 166.8 WHERE id = 1;
SELECT * FROM person;
SELECT AVG(height) FROM person; -- 167.025

SELECT ROUND(height), COUNT(*) FROM person GROUP BY ROUND(height); -- 키 별 카운트
SELECT ROUND(height), COUNT(*) FROM person GROUP BY ROUND(height) HAVING COUNT(*) > 1;

--12.3 pets 테이블(연습문제 5.3)에서 고양이가 몇 마리인지 세어보라.
SELECT COUNT(*) FROM pets WHERE animal = 'Cat';

--pets 테이블에는 동물이 종류별로 몇 마리씩 있는지 세어보라.
SELECT animal, COUNT(*) FROM pets GROUP BY animal;

-- OVER(3.25 버전 이상에서만 사용 가능)
SELECT name, height, AVG(height) OVER () AS mean FROM person;


-- 표준편차
SELECT name, height, AVG(height) OVER () AS mean, (height - AVG(height) OVER ()) 편차 FROM person;