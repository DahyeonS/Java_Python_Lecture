-- 데이터 총 건수
SELECT COUNT(*) FROM 서울상권정보; -- 377,124

-- 시군구명과 행정동명
SELECT DISTINCT 시군구명 FROM 서울상권정보;
SELECT DISTINCT 행정동명 FROM 서울상권정보;

-- 특정 지역 내의 특정 상호를 가진 업소 목록
SELECT 상호명, 시군구명, 행정동명 FROM 서울상권정보
WHERE 시군구명 = '강남구' AND 상호명 LIKE '공차%' ORDER BY 시군구명, 행정동명; -- 강남구 내 공차 매장 목록

-- 지역별 매장 수
SELECT 시군구명, 행정동명, COUNT(*) FROM 서울상권정보
WHERE 시군구명 IN ('노원구', '도봉구', '강북구') AND 상호명 LIKE '공차%' GROUP BY 시군구명, 행정동명; -- 노도강 내 동별 공차 매장 수

-- 인구 테이블 생성
SELECT 행정구역 FROM 인구세대현황;
SELECT 행정구역, "2023년07월_총인구수" FROM 인구세대현황;
SELECT 행정구역, "2023년07월_총인구수" FROM 인구세대현황 WHERE 행정구역 LIKE '%서울특별시 종로구%';

-- 상권 데이터와 인구 데이터를 조인
SELECT DISTINCT 시도명 || ' ' || 시군구명 FROM 서울상권정보;
SELECT 시도명, 시군구명, 매장수, 인구수 FROM
(SELECT 시도명, 시군구명, COUNT(*) AS 매장수 FROM 서울상권정보 WHERE 상호명 LIKE '공차%' GROUP BY 시군구명) 매장,
(SELECT 행정구역, "2023년07월_총인구수" AS 인구수 FROM 인구세대현황) 인구
WHERE 인구.행정구역 LIKE '%' || 매장.시군구명 || ' ' || '%';

-- 매장 당 인구수 구하기
SELECT * FROM
(SELECT 시도명, 시군구명, 매장수, 인구수, 인구수 / 매장수 AS "매장 당 인구수" FROM
(SELECT 시도명, 시군구명, COUNT(*) AS 매장수 FROM 서울상권정보 WHERE 상호명 LIKE '공차%' GROUP BY 시군구명) 매장,
(SELECT 행정구역, REPLACE("2023년07월_총인구수", ',', '') AS 인구수 FROM 인구세대현황) 인구
WHERE 인구.행정구역 LIKE '%' || 매장.시군구명 || ' ' || '%') ORDER BY "매장 당 인구수";

SELECT 시도명, 시군구명, COUNT(*) 매장수, "2023년07월_총인구수" 인구수, REPLACE("2023년07월_총인구수", ',', '') / COUNT(*) AS "매장 당 인구수"
FROM 서울상권정보 매장, 인구세대현황 인구 WHERE 인구.행정구역 LIKE '%' || 매장.시군구명 || '%' AND 상호명 LIKE '공차%' GROUP BY 시군구명 ORDER BY "매장 당 인구수";

-- 연습 문제
SELECT 시도명, 시군구명, COUNT(*) 매장수, "2023년07월_총인구수" 인구수, ROUND(CAST(REPLACE("2023년07월_총인구수", ',', '') AS FLOAT) / COUNT(*), 1) AS "매장 당 인구수"
FROM 서울상권정보 매장, 인구세대현황 인구 WHERE 인구.행정구역 LIKE '%' || 매장.시군구명 || '%' AND 상호명 LIKE '공차%' GROUP BY 시군구명 ORDER BY "매장 당 인구수";