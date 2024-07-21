# 세션
- 로그인이 필요한 페이지를 스크래핑할 때 활용
```python
login = 'https://www.hanbit.co.kr/member/login_proc.php' # 로그인 페이지
my_page = 'https://www.hanbit.co.kr/myhanbit/myhanbit.html' # 로그인 후 마이페이지
data = {
    'm_id':mid, # 아이디
    'm_passwd':mpw # 비밀번호
}
session = requests.session() # 로그인을 위한 세션 생성
session.post(login, data=data) # 로그인 페이지에서 데이터를 입력하여 로그인

response = session.get(my_page) # 로그인 세션을 유지한 채 URL 요청
soup = BeautifulSoup(response.text)
```

# API 활용
- 기업 또는 기관에서 제공하는 API를 스크래핑해 활용할 수 있음
- 파라미터, 헤더 등의 정보나 사용법은 API 제공처에서 숙지

### folium
- 오픈스트리트 기반 지도 시각화 라이브러리
- 좌표값을 입력하면 지도에 위치를 표시할 수 있음
- 결과물을 HTML 형식으로 저장 가능
#### 지도 생성
```python
import folium

y ='37.5511225714939' # X 좌표
x ='126.987867837993' # Y 좌표

location = (y, x)
map = folium.Map(location, zoom_start=17) # zoom_start는 확대 단계
map = folium.Map(location=(y, x), zoom_start=17)
```

#### 마커 표시
```python
zone_no = '04340'

popup = f'남산타워 {zone_no}' # 마커에 입력할 팝업문구
folium.Marker(
    location, # 마커 표시 위치
    popup, # 팝업 문구 설정
    icon=folium.Icon(color='pink', icon='glyphicon-screenshot') # 아이콘 모양 설정
).add_to(map) # 지도에 마커 생성
```