# XML / JSON 크롤링
- 마찬가지로 requests, BeautifulSoup 등을 이용해 스크래핑
#### SSL 보안 관련 처리
```python
import urllib3 # urllib의 개선된 패키지

urllib3.disable_warnings() # 경고 문구 무시
urllib3.util.ssl_.DEFAULT_CIPHERS += ':HIGH:!DH:!aNULL' 
# :HIGH: - 강력한 암호화 알고리즘, !DH: DH(Diffie-Hellman) 알고리즘 미사용, !aNULL: 인증서가 없는 암호화 알고리즘 미사용
try:
    urllib3.contrib.pyopenssl.util.ssl_.DEFAULT_CIPHERS += ':HIGH:!DH:!aNULL' # SSL 암호화 스위트 추가
except AttributeError:
    # no pyopenssl support used / needed / available
    pass # 에러 무시
```
## XML
- 사이트 주소가 .xml로 끝나는 경우 XML 페이지에 해당
- HTML과는 형식이 다소 다르나, 같은 방식으로 처리 가능
```python
url = f'https://wwwnew.kweather.co.kr/data/JISU/{xml_path}' # xml 페이지 링크
response = requests.get(url) # url 요청
response.encoding = 'utf-8' # 응답 데이터를 utf-8로 엔코딩
text = response.text # 응답 데이터를 텍스트로 변환
soup = BeautifulSoup(text, 'html.parser')
# 'html.parser'는 HTML을 처리할 때 사용하고 XML의 경우 'xml' 또는 'lxml'을 사용하나, 상황에 따라 달라질 수 있음
```

## JSON
- json() 함수를 이용 <i>(예시 - request.get(url).json())</i>
- XML과 마찬가지로 보안 관련 처리가 필요한 경우가 있음
```python
url = 'https://weather.kweather.co.kr/weather/life_weather/get_life_factor_list/11B00000'

response = requests.get(url, verify=False) # SSL 인증과정 생략
data = response.json()

factors = []
discs = []

for k in data :
    if re.findall('Factor$', k) : # Factor로 끝나는 문자열
        factors.append(k)
    if re.findall('Discription$', k) or re.findall('Discrption$', k) : # Discrption로 끝나는 문자열
        discs.append(k)

factors
# (['picnicFactor', 'lundaryFactor', 'carWashFactor', 'fireFactor',
# 'fitnessFactor', 'pollutionFactor', 'spoilageFactor',
# 'uvFactor','coldFactor','heatFactor','discomfortFactor','influFactor'],
discs
#  ['picnicDiscription', 'lundaryDiscription', 'carWashDiscription',
# 'fireDiscrption', 'fitnessDiscription', 'pollutionDiscription',
# 'spoilageDiscription', 'uvDiscription', 'coldDiscription',
# 'heatDiscription', 'discomfortDiscription', 'influDiscription'])
```