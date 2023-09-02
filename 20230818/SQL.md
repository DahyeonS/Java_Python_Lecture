# SQL

#### CREATE TABLE
```SQL
CREATE TABLE account (
	user_id SERIAL PRIMARY KEY,
	-- SERIAL - PostgreSQL에서만 쓸 수 있는 자동 증가 정수
	-- PRIMARY KEY - 기본키(중복 불가, NULL 불가
	username VARCHAR(50) UNIQUE NOT NULL,
	-- VARCHAR - 가변형 문자열
	-- TEXT - 크기 제한이 없는 가변형 문자열
	-- UNIQUE - 중복 불가
	-- NOT NULL - NULL 불가
	password VARCHAR(50) NOT NULL,
	email VARCHAR(355) UNIQUE NOT NULL,
	create_on TIMESTAMP NOT NULL,
	-- TIMESTAMP - 현재 시간을 나타내는 DATE
	last_on TIMESTAMP
);

CREATE TABLE account_role(
	role_id INTEGER NOT NULL,
	-- INTEGER - 정수
	user_id INTEGER NOT NULL,
	PRIMARY KEY (user_id, role_id), -- 2개 이상의 기본키를 설정할 때 주로 사용
--	CONSTRAINT account_role_pkey PRIMARY KEY(user_id, role_id),
	-- CONSTRAINT - 제약 조건 이름 설정 시 사용
	CONSTRAINT account_role_account_fkey
	FOREIGN KEY(user_id) REFERENCES account(user_id),
	-- FOREIGN KEY - 외래키
	-- REFERENCES - 외래키가 참조하는 대상
	CONSTRAINT account_role_role_fkey FOREIGN KEY(role_id) REFERENCES role(role_id)
);
```

#### TEMP TABLE
임시 테이블

DB가 연결됐을 때에만 존재하는 테이블

DB의 연결이 끊기면 삭제됨
```SQL
CREATE TEMP TABLE tp_temp_test(cust_id int);
```

#### VIEW
```SQL
CREATE VIEW brithdayview
AS SELECT name, birthday bdate, SUBSTR(birthday, 1, 4) yyyy, SUBSTR(birthday, 6, 2) mm, SUBSTR(birthday, 9, 2) dd
FROM person; -- BIRTHDAYVIEW라는 이름의 VIEW 생성

SELECT * FROM brithdayview; -- VIEW 출력
SELECT * FROM brithdayview WHERE yyyy > '1992'; -- 조건을 달아서 VIEW 출력
```

#### ALTER TABLE
```SQL
ALTER TABLE person ADD COLUMN new; -- PERSON 테이블에 NEW 칼럼 추가(Oracle은 COLUMN 문구 제외)
ALTER TABLE person ADD COLUMN new2 INTEGER NOT NULL DEFAULT 0; -- PERSON 테이블에 디폴트 값이 0이고 빈 값을 허용하지 않는 NEW2 칼럼 추가
ALTER TABLE person DROP new2; -- PERSON 테이블에서 NEW2 칼럼 삭제
ALTER TABLE person RENAME COLUMN new to height; -- PERSON 테이블에서 NEW2 칼럼명을 HEIGHT로 변경
```

#### TRUNCATE
```SQL
TRUNCATE link_tmp; -- 모든 값 삭제, 롤백 불가
```

#### DROP TABLE
```SQL
DROP TABLE emp; -- 테이블 삭제, 롤백 불가
```

#### UPDATE
> ```SQL
> UPDATE person SET name = '김아영' WHERE id = 5; -- ID가 5인 사람의 이름을 '김아영'으로 변경
> UPDATE person SET birthday = '1986-06-09' WHERE id = 3; -- ID가 3인 사람의 생일을 '1986-06-09'로 변경
> ```
> ##### UPDATE JOIN
> ```SQL
> UPDATE product SET net_price = price;
> 
> UPDATE product p SET net_price = p.price - (p.price * ps.discount)
> FROM product_segment ps WHERE ps.id = p.segment_id; -- 타 테이블 요소와 조인
> ```

#### INSERT
```SQL
INSERT INTO pets VALUES (1, 'Dr.Harris', 'Rabbit'); -- PETS 테이블에 데이터 추가
```

#### UPSERT
```SQL
INSERT INTO customers(name, email) VALUES
('Microsoft', 'hotline@microsoft.com') ON CONFLICT (name) DO NOTHING; -- 충돌이 나면 추가하지 않음

INSERT INTO customers(name, email) VALUES
('Microsoft', 'hotline@microsoft.com') ON CONFLICT (name) DO UPDATE
SET email = excluded.email || ';' || customers.email; -- 충돌이 나면 수정(기존 이메일 값에 새 값을 추가하는 방식)
```

#### SELECT
```SQL
SELECT * FROM person;

SELECT * FROM person WHERE id = 5; -- ID가 5인 데이터 전체
SELECT * FROM person WHERE name = '박혜리'; -- 이름이 '박혜리'인 데이터 전체

SELECT * FROM person WHERE birthday IS NULL; -- 생일이 빈 값인 데이터 전체
```

#### DELETE
```SQL
DELETE FROM link WHERE id = 5;
DELETE FROM link_tmp a USING link b where a.id = b.id; -- ID가 같은 레코드 삭제
DELETE FROM link_tmp WHERE id IN (SELECT id FROM link);
```

#### COMMIT
변경사항을 모두 DB에 적용
```SQL
COMMIT;
```

#### ROLLBACK
변경사항을 직전에 커밋한 시점으로 되돌림
```SQL
ROLLBACK;
```

#### AS
```SQL
SELECT name AS 이름, birthday 생일 FROM person; -- NAME 칼럼을 '이름'이라는 명칭으로 출력(출력값일 뿐 칼럼명이 달라지지 않음)
```

#### DATE
SQLite 기준
```SQL
SELECT STRFTIME('%Y-%m-%d %H %M %S', 'now', 'localtime') as 'yyyy-mm-dd'; -- 'now' 현재 시간, 'localtime' 현지 시간 기준(GMT+9)

-- 시스템 시간
SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;
```
PostgreSQL 기준
```SQL
SELECT NOW(); -- 현재 시간
SELECT CURRENT_TIMESTAMP; -- 현지 시간

SELECT NOW()::DATE; -- 현재 날짜 출력
SELECT CURRENT_DATE;

SELECT NOW()::TIME; -- 현재 시각 출력
SELECT CURRENT_TIME;

SELECT TO_CHAR(NOW()::DATE, 'dd/mm/yyyy');
SELECT TO_CHAR(NOW()::DATE, 'yyyy-mm-dd');
SELECT TO_CHAR(NOW()::DATE, 'yyyy년 mm월 dd일');

SELECT first_name, last_name, NOW() - create_date FROM customer;
SELECT first_name, last_name, TO_CHAR(NOW() - create_date, 'dd') FROM customer;

SELECT EXTRACT (YEAR FROM create_date), EXTRACT (MONTH FROM create_date), EXTRACT (DAY FROM create_date) FROM customer;
SELECT TO_CHAR(create_date, 'yyyy-mm-dd') FROM customer;
```

#### LIKE
```SQL
SELECT * FROM person WHERE name LIKE '%혜리'; -- 이름이 '혜리'로 끝나는 데이터 전체
SELECT * FROM person WHERE name LIKE '혜리%'; -- 이름이 '혜리'로 시작하는 데이터 전체
SELECT * FROM person WHERE name LIKE '%혜리%'; -- 이름에 '혜리'가 포함된 데이터 전체
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

#### ROUND
```SQL
SELECT name, height, weight,
ROUND(weight / (height * height * 0.0001), 1) bmi FROM person; -- 소수점 1자리까지 출력(자릿수를 정하지 않을 시 정수만 출력)
```

#### 집계함수
```SQL
SELECT COUNT(id) FROM person; -- ID의 개수를 집계하여 출력(NULL 값은 집계되지 않음)
SELECT MAX(height) FROM person; -- HEIGHT의 최대값 출력
SELECT AVG(height) FROM person; -- NULL값을 제외한 HEIGHT의 평균
```

#### JOIN
> ##### INNER JOIN
> ```SQL
> SELECT 음반.제목, 노래.제목, 연도 FROM 수록곡
> INNER JOIN 음반 ON 수록곡.음반ID = 음반.id
> INNER JOIN 노래 ON 수록곡.노래ID = 노래.id; -- 각 테이블의 같은 값들끼리 묶어서 출력
> ```
> ##### LEFT OUTER JOIN
> ```SQL
> SELECT * FROM payment p LEFT JOIN customer c ON c.customer_id = p.customer_id;
> ```
> ##### RIGHT OUTER JOIN
> ```SQL
> SELECT * FROM customer c RIGHT JOIN payment p ON c.customer_id = p.customer_id ORDER BY c.customer_id;
> ```
> ##### SELF JOIN
> ```SQL
> SELECT * FROM film f1 INNER JOIN film f2 ON f1.film_id <> f2.film_id WHERE f1.length = f2.length;
> ```

#### GROUP BY
```SQL
SELECT staff_id, COUNT(payment_id) FROM payment p GROUP BY staff_id;
```

#### GROUPING SET
```SQL
SELECT brand, segment, SUM(quantity) FROM sales GROUP BY GROUPING SETS ((brand, segment), (brand), (segment), ());
```

#### ROLLUP
그룹 별 합계
```SQL
SELECT brand, segment, SUM(quantity) FROM sales GROUP BY ROLLUP (brand, segment) ORDER BY brand, segment;
```

#### CUBE
```SQL
SELECT brand, segment, SUM(quantity) FROM sales
GROUP BY CUBE (brand, segment) ORDER BY brand, segment; -- GROUPING SET와 동일한 결과
```

#### OVER
SQLite 3.25 버전 이상에서만 사용 가능

PARTITION BY - 지정한 그룹 별로 순위를 나눔
```SQL
SELECT name, height, AVG(height) OVER () AS mean FROM person; -- 모든 행에 HEIGHT 평균값을 출력

SELECT COUNT(*) OVER(), * FROM product; -- group by 없이 코드 실행 가능

SELECT product_name, price, group_name, AVG(price) OVER (PARTITION BY pg.group_name) FROM product p
INNER JOIN product_group pg ON p.group_id = pg.group_id;
```

#### ROW_NUMBER
```SQL
SELECT a.product_name, b.group_name, a.price,
ROW_NUMBER() OVER (PARTITION BY b.group_name ORDER BY a.price DESC)
FROM product a INNER JOIN product_group b ON a.group_id = b.group_id; -- 그룹명 기준 가격 순위 출력
```

#### RANK
```SQL
SELECT a.product_name, b.group_name, a.price,
RANK() OVER (PARTITION BY b.group_name ORDER BY a.price DESC)
FROM product a INNER JOIN product_group b ON a.group_id = b.group_id; -- 그룹명 기준 가격 순위 출력(중복 허용)
```

#### DENSE_RANK
```SQL
SELECT a.product_name, b.group_name, a.price,
DENSE_RANK() OVER (PARTITION BY b.group_name ORDER BY a.price desc)
FROM product a INNER JOIN product_group b ON a.group_id = b.group_id;-- 그룹명 기준 가격 순위 출력(중복 허용, 건너뛰기 없음)
```

#### FIRST_VALUE
```SQL
SELECT a.product_name, b.group_name, a.price,
FIRST_VALUE(price) OVER (PARTITION BY b.group_name)
FROM product a INNER JOIN product_group b ON a.group_id = b.group_id; -- 그룹명 기준 가격의 첫번째 값 출력
```

#### LAST_VALUE
```SQL
SELECT a.product_name, b.group_name, a.price,
LAST_VALUE(price) OVER (PARTITION BY b.group_name ORDER BY a.price RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)
FROM product a INNER JOIN product_group b ON a.group_id = b.group_id; -- 그룹명 기준 가격의 마지막 값 출력
```

#### LAG
```SQL
SELECT a.product_name, b.group_name, a.price,
LAG(price, 1) OVER (PARTITION BY b.group_name ORDER BY a.price) AS prev_price -- 1번째 이전 값 출력
FROM product a INNER JOIN product_group b ON a.group_id = b.group_id;
```

#### LEAD
```SQL
SELECT a.product_name, b.group_name, a.price,
LEAD(price, 1) OVER (PARTITION BY b.group_name order by a.price) AS next_price -- 1번째 이후 값 출력
FROM product a INNER JOIN product_group b ON a.group_id = b.group_id;
```

#### UNION
> 합집합
> 
> *실행 시 칼럼 갯수를 맞춰야 함*
> ```SQL
> SELECT * FROM basket_a UNION SELECT * FROM basket_b;
> ```
>
> ##### UNION ALL
> 중복 허용
> ```SQL
> SELECT brand, segment, SUM(quantity) FROM sales GROUP BY brand, segment
> UNION ALL SELECT brand, NULL, SUM(quantity) FROM sales GROUP BY brand;
> ```

#### INTERSECT
교집합
```SQL
SELECT employee_id FROM keys INTERSECT SELECT employee_id FROM hipos;
```

#### EXCEPT
차집합
```SQL
SELECT employee_id FROM keys EXCEPT SELECT employee_id FROM hipos;
```

#### SUBQUERY
```SQL
SELECT * FROM film WHERE rental_rate > (SELECT AVG(rental_rate) FROM film) ORDER BY rental_rate, film_id;
```

#### ANY
OR 또는 IN과 비슷한 기능

문자형 - 해당하는 값의 레코드를 출력

숫자형 - 해당하는 범위에 진입하자마자 바로 레코드를 출력
```SQL
SELECT * FROM film WHERE length >=
ANY (SELECT MAX(length) FROM film f, film_category c WHERE f.film_id = c.film_id
GROUP BY c.category_id ORDER BY c.category_id);
```

#### ALL
AND와 비슷한 기능

해당하는 모든 범위에 반드시 포함되는 레코드를 출력
```SQL
SELECT * FROM film WHERE length >=
ALL (SELECT MAX(length) FROM film f, film_category c WHERE f.film_id = c.film_id
GROUP BY c.category_id ORDER BY c.category_id);
```

#### EXISTS
해당 레코드가 존재하는지 여부
```SQL
SELECT first_name, last_name FROM customer c
WHERE EXISTS (SELECT 1 FROM payment p
WHERE p.customer_id = c.customer_id AND p.amount > 11); -- 1은 아무 의미 없는 값, 서브쿼리 개별로 실행 불가
```

#### EXPORT
```SQL
COPY category(category_id, name, last_update) TO
'C:\kdigital2307\data\db_category.csv' DELIMITER ',' CSV HEADER; -- csv 파일로 저장

COPY category TO 'C:\kdigital2307\data\db_category.csv' DELIMITER ',' CSV HEADER;
```

#### IMPORT
```SQL
COPY category_import FROM 'C:\kdigital2307\data\db_category.csv' DELIMITER ',' CSV HEADER; -- csv에서 불러오기
COPY category_import(category_id, "NAME", last_update) FROM 'C:\kdigital2307\data\db_category.csv' DELIMITER ',' CSV HEADER;
```

#### COALESE
NULL이 아닌 최초의 인수를 반환
```SQL
SELECT product, price, (price - COALESE(discount, 0)) net_price FROM tb_item_coalesce_test; -- NULL값 처리
```

#### NULLIF
대상이 조건에 맞으면 NULL을 반환
```SQL
SELECT SUM(CASE WHEN gender = 1 TNEN 1 ELSE 0 END) /
NULLIF(SUM(CASE WHEN gender = 2 THEN 1 ELSE 0 END), 0) * 100 AS "male/female ratio"
FROM tb_member_nullif_test; -- nullif 함수를 이용해 값이 0이면 NULL을 반환
```

#### CAST
```SQL
SELECT CAST('100' AS INTEGER); -- 문자열 '100'을 정수로 변환
SELECT '100'::INTEGER;

SELECT CAST('2023--08-25' AS DATE);
SELECT '2023-08--25'::DATE;

SELECT CAST('10.2' AS DOUBLE PRECISION);
SELECT '10.2'::DOUBLE PRECISION;
```

#### WITH
```SQL
WITH tmp1 AS (
SELECT film_id, title, 
CASE
	WHEN length < 30 THEN 'SHORT'
	WHEN length >= 30 AND length < 90 THEN 'MEDIUM'
	ELSE 'LONG'
END AS length FROM film)
SELECT * FROM tmp1; -- 임시 테이블 생성
```
