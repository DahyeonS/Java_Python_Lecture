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
## 페이지 출력
- render_template 함수를 통해 HTML 파일을 랜더링(실행)
```python
@app.route('/login_form')
def login_form() :
    return render_template('form.html')
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

*templates/form.html* - 값 전송
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
# GET 방식
@app.route('/login_proc_get', methods=['GET'])
def login_proc_get() :
    user_id = request.args.get('user_id') # 파라미터 값을 요청해서 전달받음
    user_pwd = request.args.get('user_pwd')
    print(user_id, user_pwd)

    return f'login user id {user_id}, login user pwd {user_pwd}'

# POST 방식
@app.route('/login_proc_post', methods=['POST'])
def login_proc_post() :
    user_id = request.form['user_id'] # 파라미터 값을 요청해서 전달받음
    user_pwd = request.form['user_pwd']
    print(user_id, user_pwd)

    return f'login user id {user_id}, login user pwd {user_pwd}'
```
- render_template 함수를 통해서도 값 전송 가능
```python
@app.route('/plays') # POST 방식
def plays() :
    t1 = ('갤러그', '너구리', '리니지')
    l1 = ['야구', '축구', '농구']
    d1 = {'one':1, 'two':2, 'three':3}

    return render_template('plays.html', title='PLAYS', games=t1,
    sports=l1, nums=d1) # html에 값 전달
```
*templates/plays.html* - 전달받은 값 출력
```HTML
<h1>title: {{title}}</h1> <!-- title: PLAYS -->

<!-- 반복문 활용 -->
<ul>
    {% for g in games %}
        <li>{{g}}</li> <!-- 각 줄 마다 갤러그, 너구리, 리니지 출력 -->
    {% endfor %}
</ul>

<ul>
    {% for k, v in nums.items() %}
        <li>{{k}}, {{v}}</li> <!-- 각 줄 마다 키, 값 출력 -->
    {% endfor %}
</ul>
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
*views/main_views.py*
```python
from flask import Blueprint

bp = Blueprint('main', __name__, url_prefix='/')
@bp.route('/')
def index() :
    return render_template('index.html')
```

## 모델
- 데이터베이스 관련 작업
- 플라스크의 SQLAlchemy 설치 필요
- 개발 단계에서는 비교적 가벼운 SQLite를 사용
- 배포 단계에서는 실제 서버를 운영하기 때문에 MySQL, PostgreSQL 등을 사용
- 도중에 사용하는 데이터베이스가 달라져도 설정만 수정하면 호환 가능

*app.py*
```python
from flask_migrate import Migrate
from flask_sqlalchemy import SQLAlchemy
import config

db = SQLAlchemy()
migrate = Migrate() # DB 마이그레이션

def create_app() :
    app = Flask(__name__)
    app.config.from_object(config)

    # ORM - DB 작업
    db.init_app(app)
    migrate.init_app(app, db)
    from . import models

    # Route
    from .views import main_views
    app.register_blueprint(main_views.bp)

    return app
```
*config.py*
```python
import os

BASE_DIR = os.path.dirname(__file__) # 현재 디렉토리
db_path = os.path.join(BASE_DIR, 'pybo.db') # pybo.db라는 DB 사용(마이그레이트 시 자동생성)
SQLALCHEMY_DATABASE_URI = f'sqlite:///{db_path}' # SQLite 데이터베이스 사용
SQLALCHEMY_TRACK_MODIFICATIONS = False # SQLAlchemy 이벤트 처리 옵션(불필요)
```
*models.py*
```python
from app import db

class Question(db.Model): # Question 테이블 생성
    id = db.Column(db.Integer, primary_key=True) # 숫자형, 기본키
    subject = db.Column(db.String(200), nullable=False) # 200자 제한 문자형, NULL 비허용
    content = db.Column(db.Text(), nullable=False) # 글자 수 제한이 없는 문자형, NULL 비허용
    create_date = db.Column(db.DateTime(), nullable=False) # 날짜형, NULL 비허용

class Answer(db.Model): # Answer 테이블 생성
    id = db.Column(db.Integer, primary_key=True) # 숫자형, 기본키
    question_id = db.Column(db.Integer, db.ForeignKey('question.id', ondelete='CASCADE')) # 숫자형, Question 테이블의 id의 외래키(삭제 시 같이 삭제)
    question = db.relationship('Question', backref=db.backref('answer_set')) # Question 테이블과 양방향 참조
    content = db.Column(db.Text(), nullable=False) # 글자 수 제한이 없는 문자형, NULL 비허용
    create_date = db.Column(db.DateTime(), nullable=False) # 날짜형, NULL 비허용
```
- 첫 사용시 명령 프롬프트에서 flask db init로 DB 초기화(필요한 경우만)
- DB 초기화 시 db 파일이 자동 생성됨
- 테이블 추가/변경 시 명령 프롬프트에서 flask db migrate 입력
- 마이그레이트 후 명령 프롬프트에서 flask db upgrade를 입력해 변경 사항을 실제 DB에 적용