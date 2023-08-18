SELECT SUBSTR('1994-06-09', 1, 4);
SELECT SUBSTR('1994-06-09', 6, 2);
SELECT SUBSTR('1994-06-09', 9);

SELECT STRFTIME('%Y-%m-%d %H %M %S', 'now', 'localtime') as 'yyyy-mm-dd'; -- 'now' 현재 시간, 'localtime' 현지 시간 기준(GMT+9)

-- 시스템 시간
SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;

SELECT SQlite_VERSION();