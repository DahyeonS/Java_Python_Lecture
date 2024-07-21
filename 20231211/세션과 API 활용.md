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