-- 첫번째 레코드 조회
SELECT species_code, catch_location, device_info_serial, sex, scientific_name, ring_code, bird_name FROM bird_tracking_devices
WHERE ROWID = 1;

-- device_info_serial의 값이 851인 레코드 조회
SELECT sex 성별, scientific_name 학명, bird_name 이름, tracking_started_at 추적시작일시, tracking_ended_at 추적종료일시
FROM bird_tracking_devices WHERE device_info_serial = 851;

-- device_info_serial을 중복 없이 조회
SELECT COUNT(*) "총 건수", COUNT(DISTINCT device_info_serial) "추적 장치 개수" FROM bird_tracking;

-- 에릭을 추적한 데이터 개수
SELECT COUNT(*) 건수 FROM bird_tracking WHERE device_info_serial = 851;

-- 에릭을 추적한 기간
SELECT MAX(date_time) 시작일시, MIN(date_time) 종료일시 FROM bird_tracking WHERE device_info_serial = 851;

-- 추적장치별, 월별 데이터 집계
SELECT device_info_serial 추적장치일련번호, SUBSTR(date_time, 1, 7) 년월, COUNT(*) 건수 FROM bird_tracking GROUP BY device_info_serial, SUBSTR(date_time, 1, 7) ORDER BY 추적장치일련번호, 년월;

-- 연습문제
SELECT bird_name 이름, SUBSTR(date_time, 1, 7) 년월, COUNT(*) 건수 FROM bird_tracking bt INNER JOIN bird_tracking_devices btd ON bt.device_info_serial = btd.device_info_serial GROUP BY bird_name, SUBSTR(date_time, 1, 7);