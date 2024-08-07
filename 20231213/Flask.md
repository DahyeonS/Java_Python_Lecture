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
- 명령 프롬프트에서 FLASK_DEBUG=true를 입력하면 코드 수정 시 자동으로 새로고침이 됨

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
    app.run(debug=True) # 코드 수정 시 자동 새로고침
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

##### cmd 파일
- 명령 프롬프트에 입력할 문구를 저장한 뒤, 해당 파일을 실행하는 방식으로 명령 자동화
- *@echo off* - 실행 시 입력 문구가 출력되지 않은 채로 실행

## 페이지 출력
- render_template 함수를 통해 HTML 파일을 랜더링(실행)
```python
from flask import render_template

@app.route('/login_form')
def login_form() :
    return render_template('form.html')
```
- redirect 함수를 통해 특정 경로로 이동
```python
from flask import redirect, url_for

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
from flask import request

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
    {% endfor %} <!-- 반드시 반복문을 닫아야 함 -->
</ul>

<ul>
    {% for k, v in nums.items() %}
        <li>{{k}}, {{v}}</li> <!-- 각 줄 마다 키, 값 출력 -->
    {% endfor %} <!-- 반드시 반복문을 닫아야 함 -->
</ul>

{% for g in games %}
    <p>0부터 순서: {{ loop.index() }} </p> <!-- 0부터 1씩 증가하는 반복 순서 -->
    <p>1부터 순서: {{ loop.index }} </p> <!-- 1부터 1씩 증가하는 반복 순서 -->
    <p>{{ g }}</p>
{% endfor %}

<!-- 조건문 활용 -->
{% if games %}
    <ul>
        {% for g in games %}
            <li>{{g}}</li>
        {% endfor %}
    </ul>
{% elif nums %}
    <ul>
        {% for k, v in nums.items() %}
            <li>{{k}}, {{v}}</li>
        {% endfor %}
    </ul>
{% else %}
    <h3>데이터 없음</h3>
{% endif %} <!-- 반드시 조건문을 닫아야 함 -->
```

#### 디렉토리 연결 및 템플릿 상속
##### 디렉토리 연결
- Head 또는 Body 태그 안에 url_for 함수 사용
- 연결할 수 있는 파일은 js, css, 이미지, 아이콘 등이 있음
- a태그와 url_for 함수를 활용하면 특정 위치로 라우팅 가능
```HTML
<!-- 스크립트 -->
<script src="{{ url_for('static', filename='js/index.js') }}"></script> <!-- js 폴더에 위치한 index.js 연결 -->

<!-- 스타일 CSS -->
<link rel="stylesheet" href="{{ url_for('static', filename='style.css') }}"> <!-- 현재 디렉토리에 위치한 style.css 연결 -->

<!-- 이미지 -->
<img src="{{ url_for('static', filename='img/image.png') }}"> <!-- img 폴더에 위치한 image.png 연결 -->

<!-- 아이콘(반드시 Head 태그 안에 입력) -->
<link rel="icon" href="{{ url_for('static', filename='img/favicon.ico') }}" type="image/x-icon">

<!-- a태그(라우팅) -->
<a href="{{url_for('question.detail', question_id=q.id)}}">{{q.subject}}</a>
<!-- question_id에 값을 담은 채 question 블루프린트로 등록된 뷰의 detail 함수로 이동 -->
```

##### 템플릿 상속
- extends와 include를 사용해서 다른 HTML 파일을 연결
###### extends
- extends는 block content 부분에 상속한 템플릿(HTML 파일)이 삽임됨
- 상속되는 템플릿(HTML 파일)은 별도의 Head 태그 등을 생략하고 <i>extends '파일명.html'</i>로 대체한 뒤, block content 안에 내용이 들어감
###### include
- <i>include '파일명.html'</i>로 다른 템플릿(HTML 파일)의 내용을 삽입함
- 삽입되는 템플릿(HTML 파일)은 별도의 Head 태그 등을 생략하고 입력하고자 하는 코드만 작성하면 됨

*base.html*
```HTML
<body>
    {% include "navbar.html" %} <!-- navbar.html이 삽입 -->

    {% block content %} <!-- 해당 부분에 상속되는 템플릿의 내용이 삽입 -->

    {% endblock %} <!-- 반드시 블록을 닫아야 함 -->
</body>
```
*navbar.html*
```HTML
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container-fluid">
        <a class="navbar-brand" href="{{ url_for('main.index') }}">Pybo</a>
    </div>
</nav>
```
*question_list.html*
```HTML
{% extends 'base.html' %} <!-- base.html에서 상속받은 템플릿 -->
{% block content %} <!-- base.html에서 출력하고자 하는 내용 -->
<div class="container my-3">
    <table class="table">
        <thead>
            <tr class="table-dark">
                <th>번호</th>
                <th>제목</th>
                <th>날짜</th>
            </tr>
        </thead>
        <tbody>
            {% if question_list %}
            {% for q in question_list.items %}
            <tr>
                <td>{{q.id}}</td>
                <td><a href="{{url_for('question.detail', question_id=q.id)}}">{{q.subject}}</a></td>
                <td>{{q.create_date}}</td>
            </tr>
            {% endfor %}
            {% else %}
            <tr>
                <td colspan="3">File Not Found!!</td>
            </tr>
            {% endif %}
        </tbody>
    </table>
</div>
{% endblock %} <!-- 반드시 블록을 닫아야 함 -->
```

## 라우팅
- 페이지 경로 별 처리 방식 설정
- 블루프린트를 통해 라우팅 함수의 URL을 등록, app.py와 작업 분리 가능
- url_for을 이용해 라우팅 함수로 등록되어 있는 URL을 찾아줌

##### Case 1
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
from flask import Blueprint, render_template

bp = Blueprint('main', __name__, url_prefix='/') # main이라는 이름의 블루프린트로 등록, URL 접두사 없음
@bp.route('/')
def index() :
    return render_template('index.html')
```

##### Case 2
*app.py*
```python
def create_app() :
    app = Flask(__name__)

    # Route
    from .views import main_views, question_views
    app.register_blueprint(main_views.bp)
    app.register_blueprint(question_views.bp)

    return app
```
*views/main_views.py*
```python
from flask import Blueprint, url_for, redirect

bp = Blueprint('main', __name__, url_prefix='/')
@bp.route('/')
def index() :
    return redirect(url_for('question._list')) # question 블루프린트로 등록된 뷰의 _list 함수로 이동
```
*views/question_views.py*
```python
from flask import Blueprint, render_template

bp = Blueprint('question', __name__, url_prefix='/question') # question이라는 이름의 블루프린트로 등록, URL 접두사는 question
@bp.route('/list')
def _list() :
    return render_template('question/question_list.html')
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

### DB 데이터 처리
- 명령 프롬프트에 flask shell을 입력해 쉘로 작업하거나, 함수 또는 파일로 코드를 작성
```python
from app import db
```

#### 데이터 추가
- 새 데이터 객체 생성 후 db.session.add()로 데이터 추가
- 반드시 커밋해야 수정사항이 실제로 적용됨
```python
from models import Question

q = Question(
    subject='질문입니다.', content='오늘은 무슨 요일인가요?', create_date=datetime.now()
    ) # 새 데이터 객체 생성
db.session.add() # 데이터 추가

db.session.commit() # 커밋
```

#### 데이터 조회
- SELECT문에 해당
```python
Question.query.all() # Question 테이블의 모든 칼럼 조회

Question.query.filter(Question.id==1).all() # Question 테이블의 id가 1인 모든 칼럼 조회

Question.query.get(1) # Question 테이블의 키본키의 값이 1인 칼럼 조회
Question.query.get_or_404(1) # 해당 데이터를 찾을 수 없는 경우 404 오류 페이지 출력

Question.query.filter(Question.subject.like('%플라스크%')).all()
# Question 테이블의 subject의 값에 '플라스크'가 포함된 칼럼 조회

q.id # 1
# (데이터 객체.로우 이름) 형식으로 로우 값을 불러오기 가능

Question.query.order_by(Question.create_date.desc()) # 생성날짜 별로 내림차순 정렬
```

#### 데이터 수정
- 반드시 커밋해야 수정사항이 실제로 적용됨
```python
q = Question.query.get(2) # Question 테이블의 키본키의 값이 2인 칼럼
q.subject = 'Flask Model Question' # subject를 수정

db.session.commit() # 커밋
```

#### 데이터 삭제
- 반드시 커밋해야 수정사항이 실제로 적용됨
```python
q = Question.query.get(1) # Question 테이블의 키본키의 값이 1인 칼럼
db.session.delete(q) # 데이터 삭제

db.session.commit() # 커밋
```

## 폼
