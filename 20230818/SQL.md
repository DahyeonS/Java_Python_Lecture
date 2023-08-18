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
