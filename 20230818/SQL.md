# SQL

#### SELECT
```SQL
SELECT * FROM person;

SELECT * FROM person WHERE id = 5; -- ID가 5인 데이터 전체
SELECT * FROM person WHERE name = '박혜리'; -- 이름이 '박혜리'인 데이터 전체

SELECT * FROM person WHERE birthday IS NULL; -- 생일이 빈 값인 데이터 전체
```

#### UPDATE
```SQL
UPDATE person SET name = '김아영' WHERE id = 5; -- ID가 5인 사람의 이름을 '김아영'으로 변경
UPDATE person SET birthday = '1986-06-09' WHERE id = 3; -- ID가 3인 사람의 생일을 '1986-06-09'로 변경
```

#### LIKE
```SQL
SELECT * FROM person WHERE name LIKE '%혜리'; -- 이름이 '혜리'로 끝나는 데이터 전체
SELECT * FROM person WHERE name LIKE '혜리%'; -- 이름이 '혜리'로 시작하는 데이터 전체
SELECT * FROM person WHERE name LIKE '%혜리%'; -- 이름에 '혜리'가 포함된 데이터 전체
```

#### INSERT
```SQL
INSERT INTO pets VALUES (1, 'Dr.Harris', 'Rabbit'); -- PETS 테이블에 데이터 추가
```

#### ALTER TABLE
```SQL
ALTER TABLE person ADD COLUMN new; -- PERSON 테이블에 NEW 칼럼 추가
ALTER TABLE person ADD COLUMN new2 INTEGER NOT NULL DEFAULT 0; -- PERSON 테이블에 디폴트 값이 0이고 빈 값을 허용하지 않는 NEW2 칼럼 추가
ALTER TABLE person DROP new2; -- PERSON 테이블에서 NEW2 칼럼 삭제
ALTER TABLE person RENAME COLUMN new to height; -- PERSON 테이블에서 NEW2 칼럼명을 HEIGHT로 변경
```

#### AS
```SQL
SELECT name AS 이름, birthday 생일 FROM person; -- NAME 칼럼을 '이름'이라는 명칭으로 출력(출력값일 뿐 칼럼명이 달라지지 않음)
```

#### ROUND
```SQL
SELECT name, height, weight,
ROUND(weight / (height * height * 0.0001), 1) bmi FROM person; -- 소수점 1자리까지 출력(자릿수를 정하지 않을 시 정수만 출력)
```

#### VIEW
```SQL
CREATE VIEW brithdayview
AS SELECT name, birthday bdate, SUBSTR(birthday, 1, 4) yyyy, SUBSTR(birthday, 6, 2) mm, SUBSTR(birthday, 9, 2) dd
FROM person; -- BIRTHDAYVIEW라는 이름의 VIEW 생성

SELECT * FROM brithdayview; -- VIEW 출력
SELECT * FROM brithdayview WHERE yyyy > '1992'; -- 조건을 달아서 VIEW 출력
```

#### CASE
```SQL
SELECT name, bdate, mm,
CASE
	WHEN mm = '01' THEN 'Jan.'
	WHEN mm = '02' THEN 'Feb.'
	WHEN mm = '03' THEN 'Mar.'
	WHEN mm = '06' THEN 'Jun.'
END as month
FROM brithdayview; -- 조건에 따라 값을 다르게 출력
```

#### 날짜
SQLite 기준
```SQL
SELECT STRFTIME('%Y-%m-%d %H %M %S', 'now', 'localtime') as 'yyyy-mm-dd'; -- 'now' 현재 시간, 'localtime' 현지 시간 기준(GMT+9)

-- 시스템 시간
SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;
```

#### 집계함수
```SQL
SELECT COUNT(id) FROM person; -- ID의 개수를 집계하여 출력(NULL 값은 집계되지 않음)
SELECT MAX(height) FROM person; -- HEIGHT의 최대값 출력
SELECT AVG(height) FROM person; -- NULL값을 제외한 HEIGHT의 평균
```

#### OVER
SQLite 3.25 버전 이상에서만 사용 가능
```SQL
SELECT name, height, AVG(height) OVER () AS mean FROM person; -- 모든 행에 HEIGHT 평균값을 출력
```

#### JOIN
##### INNER JOIN
```SQL
SELECT 음반.제목, 노래.제목, 연도 FROM 수록곡
INNER JOIN 음반 ON 수록곡.음반ID = 음반.id INNER JOIN 노래 ON 수록곡.노래ID = 노래.id; -- 각 테이블의 같은 값들끼리 묶어서 출력
```
##### LEFT OUTER JOIN
```SQL
SELECT * FROM payment p LEFT JOIN customer c ON c.customer_id = p.customer_id;
```
##### RIGHT OUTER JOIN
```SQL
SELECT * FROM customer c RIGHT JOIN payment p ON c.customer_id = p.customer_id ORDER BY c.customer_id;
```
##### SELF JOIN
```SQL
SELECT * FROM film f1 INNER JOIN film f2 ON f1.film_id <> f2.film_id WHERE f1.length = f2.length;
```

#### GROUP BY
```SQL
SELECT staff_id, COUNT(payment_id) FROM payment p GROUP BY staff_id;
```

#### GROUPING SET
```SQL
SELECT brand, segment, SUM(quantity) FROM sales GROUP BY GROUPING SETS ((brand, segment), (brand), (segment), ());
```

#### UNION
합집합
```SQL

```

#### INTERSECT
교집합
```SQL

```

#### EXCEPT
차집합
```SQL

```

#### SUBQUERY
```SQL

```
