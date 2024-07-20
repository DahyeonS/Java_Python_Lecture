# Selenium
**수강 당시에는 3.0을 사용하였으며, 최신 버전인 4.0의 경우 별도 드라이버 설치가 필요 없으며 일부 코드가 다름**
- 스크래핑인 BeautifulSoup와 달리, Selenium은 웹 크롤링 오픈 소스 
- 클릭과 같이 BeautifulSoup에서 불가능한 동작이 가능함
- *강의 및 실습은 크롬 브라우저를 사용하였음*

## 라이브러리 사용
```python
from selenium import webdriver

# 구버전
driver = webdriver.Chrome('./util/chromedriver-win64/chromedriver.exe')
# 크롬 드라이버 설치 필요, 설치된 경로에서 크롬 드라이버 실행

# 최신버전
driver = webdriver.Chrome() # 별도 설치가 필요 없음
```

### 설정 적용
```python
options = webdriver.ChromeOptions()
options.add_argument('--headless')  # 창을 띄우지 않고 백그라운드에서 조작
options.add_argument('--no-sandbox') # 크롬 전용 샌드박스 사용하지 않음
options.add_argument('--disable-dev-shm-usage') # 안전하지 않음 경고 무시

driver = webdriver.Chrome(options=options) # 해당 설정들을 적용
```

## 동작
```python
driver.implicitly_wait(3) # 3초 대기 - time.sleep()에 비해 시간복잡도 개선
driver.get(url) # 페이지 로드(--headless 미적용시 창 열림)
search = driver.find_element_by_css_selector('#query') # 검색창 선택
search.send_keys('삽살개') # 검색창에 검색어 입력
search.send_keys(Keys.ENTER) # Enter키 동작

posts = driver.find_elements_by_css_selector('a.area_text_title') # 클릭할 부분 선택
posts[0].click() # 클릭 동작
driver.close() # 창 닫기
```