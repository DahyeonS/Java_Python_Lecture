# Flask
- Python 기반 웹 프레임워크
- 웬만한 필수 기능들이 내장된 Django와 달리 핵심 기능만 최소한으로 구비됨
- Django에 비해 용량이 가벼우나 보안 관련, SQL 처리 등의 작업은 따로 라이브러리 설치 필요
- 개발용 서버 및 디버거, Jinja2 템플릿 엔진 내장
- *[점프 투 플라스크](https://wikidocs.net/book/4542)를 참고하며 작업하였습니다.*

## 시작
- 접속 링크는 *http://127.0.0.1:5000*
- debug를 True로 설정 시 수정사항이 실시간으로 반영됨
- 명령 프롬프트의 FLASK_APP 설정을 통해 app 외의 다른 파일명으로 설정 가능

*app.py*
```python
# 패키지 임포트
from flask import Flask

# 플라스크 어플리케이션 선언
app = Flask(__name__)

# 페이지 생성
@app.route('/') # route() 데코레이터를 통해 페이지 경로 설정
def index() : # View 함수
    return 'Hello Index'
# 플라스크 실행 시 웹 페이지에 Hello Index 문구가 출력

# 실행
if __name__ == '__main__' :
    app.run(debug=True)
```
- create_app() 함수를 선언하는 방식으로도 플라스크 실행 가능
```python
def create_app() :
    app = Flask(__name__)

    @app.route('/')
    def hello() :
        return 'Hello, World!'

    return app
```
- render_template 함수를 통해 HTML 파일을 랜더링(실행)
```python
@app.route('/login_form')
def login_form() :
    return render_template('form.html')

@app.route('/plays') # POST 방식
def plays() :
    t1 = ('갤러그', '너구리', '리니지')
    l1 = ['야구', '축구', '농구']
    d1 = {'one':1, 'two':2, 'three':3}

    return render_template('plays.html', title='PLAYS', games=t1,
    sports=l1, nums=d1) # html에 값 전달
```
- redirect 함수를 통해 특정 경로로 이동
```python
@app.route('/user/<name>')
def user(name) :
    if name == 'admin' :
        return redirect(url_for('admin')) # 메소드명에 속한 링크로 이동
    else :
        return redirect(url_for('guest', guest=name)) # name을 매개변수 guest로 넣어서 리다이렉트

@app.route('/admin')
def admin() :
    return 'Hello Admin' # name이 admin일 때 출력

@app.route('/guest/<guest>')
def guest(guest) : # 매개변수 guest에 name을 전달받음
    return f'Hello {guest}' # name이 guest일 때 출력
```

## 값 전송 / 처리

### jinja2
- Java의 JSP와 비슷하게 HTML 안에서 Python 관련 작업 처리 가능
- Python에서 값을 받거나 전송하고 HTML애서 전달받은 값을 표시

*form.html* - 값 전송
```HTML
<!-- GET 방식 -->
<form action="/login_proc_get" method="get">
    ID <input type="text" name="user_id"> <br>
    PW <input type="text" name="user_pwd"> <br>
    <input type="submit" value="Submit">
</form>

<!-- POST 방식 -->
<form action="/login_proc_post" method="post">
    ID <input type="text" name="user_id"> <br>
    PW <input type="text" name="user_pwd"> <br>
    <input type="submit" value="Submit">
</form>
```
*app.py* - 전송받은 값 처리 & 라우팅
```python

```
*plays.html* - 전달받은 값 출력
```HTML

```

## 라우팅
- 페이지 경로 별 처리 방식 설정
- 블루프린트를 통해 app.py와 작업 분리 가능

*app.py*
```python
def create_app() :
    app = Flask(__name__)

    # Route
    from .views import main_views
    app.register_blueprint(main_views.bp)

    return app
```

*main_views.py*
```python
from flask import Blueprint

bp = Blueprint('main', __name__, url_prefix='/')
@bp.route('/')
def index() :
    return render_template('index.html')
```

## 작업 분리
*views/main_views.py*
```python

```

## 모델
- 데이터베이스 관련 작업