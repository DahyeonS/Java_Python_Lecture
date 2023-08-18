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

ALTER TABLE person ADD COLUMN new2 INTEGER NOT NULL DEFAULT 0; -- 칼럼 추가
ALTER TABLE person DROP new2;
ALTER TABLE person RENAME COLUMN new to height;

UPDATE person SET height = 167 WHERE id = 3;
UPDATE person SET height = 170.3 WHERE id = 4;
UPDATE person SET height = 164 WHERE id = 5;
SELECT * FROM person;

-- Person 테이블에 Weight 칼럼을 추가해보라.
ALTER TABLE person ADD COLUMN weight INTEGER NOT NULL DEFAULT 0;
SELECT * FROM person;

-- 별명주기 AS
SELECT name AS 이름, birthday 생일 FROM person;

UPDATE person SET weight = 50 WHERE id = 1;
UPDATE person SET weight = 0 WHERE id = 2;
UPDATE person SET weight = 54 WHERE id = 4;
UPDATE person SET weight = 46 WHERE id = 5;


SELECT name, height, weight, ROUND(weight / (height * height * 0.0001), 1) bmi FROM person;

CREATE VIEW brithdayview AS SELECT name, birthday bdate,
SUBSTR(birthday, 1, 4), SUBSTR(birthday, 6, 2), SUBSTR(birthday, 9, 2) FROM person;
SELECT * FROM brithdayview;