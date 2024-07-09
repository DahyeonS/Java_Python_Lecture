# XML / JSON 크롤링
- 마찬가지로 requests, BeautifulSoup 등을 이용해 스크래핑
#### 보안 관련 처리
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