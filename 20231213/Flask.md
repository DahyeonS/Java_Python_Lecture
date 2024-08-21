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
- app.py가 아닌 폴더명으로 사용할 경우 해당 폴더 안에 \_\_init\_\_.py로 파일명을 설정해야 함
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
    <p>0부터 순서: {{ loop.index0 }} </p> <!-- 0부터 1씩 증가하는 반복 순서 -->
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

*templates/base.html*
```HTML
<body>
    {% include "navbar.html" %} <!-- navbar.html이 삽입 -->

    {% block content %} <!-- 해당 부분에 상속되는 템플릿의 내용이 삽입 -->

    {% endblock %} <!-- 반드시 블록을 닫아야 함 -->
</body>
```
*templates/navbar.html*
```HTML
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container-fluid">
        <a class="navbar-brand" href="{{ url_for('main.index') }}">Pybo</a>
    </div>
</nav>
```
*templates/question/question_list.html*
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
- 입력 값의 양식을 설정하여 적합한 값이 전달됐을 때만 처리할 수 있게 함
- 데이터의 필수 여부, 형식, 길이, 양식 미충족 시 메시지 등을 설정할 수 있음
- flask-wtf 설치 및 환경 변수 SECRET_KEY 설정 필요(CSRF 방지)

*config.py*
```python
SECRET_KEY = 'dev' # 개발용 한정, 배포용의 경우 보다 복잡한 문자열로 설정해야 함
```
*forms.py*
```python
from flask_wtf import FlaskForm
from wtforms import StringField # 데이터 형식
from wtforms.validators import DataRequired # 데이터 필수 여부

class QuestionForm(FlaskForm) : # FlaskForm을 상속받아 새로운 폼 작성
    msg = '필수항목입니다.' # 오류 메시지 문자열
    subject = StringField('제목', validators=[DataRequired(msg)])
    # 라벨명 '제목', 문자열 형식, 필수 데이터(미충족 시 msg 메시지를 띄움)
    content = StringField('내용', validators=[DataRequired(msg)])
    # 라벨명 '내용', 문자열 형식, 필수 데이터(미충족 시 msg 메시지를 띄움)
```

### 폼 활용
*views/question_views.py*
```python
from flask import request, redirect, url_for
from datetime import datetime
from ..forms import QuestionForm
from .. import db

@bp.route('/create', methods=['GET', 'POST']) # GET과 POST 모두 처리
def create() :
    form = QuestionForm() # Qustsion 테이블에 넣을 폼 생성

    # 요청을 POST로 전달받고 데이터가 폼의 양식에 알맞을 때 실행
    if request.method == 'POST' and form.validate_on_submit() :
        subject = form.subject.data # 폼의 subject 값
        content = form.content.data # 폼의 content 값
        question = Question(subject=subject, content=content, create_date=datetime.now())
        # 현재 시각과 폼의 값들이 담긴 Question 테이블의 새로운 데이터 생성

        db.session.add(question) # db에 해당 데이터를 추가
        db.session.commit() # 커밋
        return redirect(url_for('main.index')) # 메인 화면으로 리다이렉트
        
    # GET으로 요청받았거나 데이터가 폼의 양식에 알맞지 않을 때
    return render_template('question/question_form.html', form=form) # 빈 폼 또는 작성 중인 폼을 전송
```

*templates/question/question_form.html*
```HTML
<form method="post" class="my-3">
    {{form.csrf_token}} <!-- 폼을 다룰 때는 반드시 CSRF 토큰이 필요함 -->
    {% if form.errors %} <!-- 폼에 빈 공간이 있을 때 -->
    <div class="alert alert-danger" role="alert">
        {% for f, errors in form.errors.items() %}
        <strong>{{form[f].label}}</strong> <!-- 폼의 데이터 라벨명 -->
        <ul>
            {% for e in errors %}
            <li>{{e}}</li> <!-- 에러 메시지 -->
            {% endfor %}
        </ul>
        {% endfor %}
    </div>
    {% endif %}
    <div class="mb-3">
        <label for="subject">제목</label>
        <input type="text" class="form-control" name="subject" id="subject" value="{{form.subject.data or ''}}">
        <!-- 폼에 저장된 데이터 또는 빈 값 -->
    </div>
    <div class="mb-3">
        <label for="content">내용</label>
        <textarea type="text" class="form-control" name="content" id="content" rows="10">{{form.content.data or ''}}</textarea>
        <!-- 폼에 저장된 데이터 또는 빈 값 -->
    </div>
    <button type="submit" class="btn btn-primary">저장하기</button>
</form>
```

## 페이징
- 플라스크의 SQLAlchemy에 내장된 paginate 함수를 사용
- jinja2를 통해 전송할 경우 Paginate 객체 그대로 보내면 됨
- Ajax나 Axios와 같은 비동기 방식의 경우 JSON으로 변환하여 전송

#### Paginate 객체
- items	- 데이터베이스에서 가져온 데이터들 *(models 객체)*
- total	- 전체 데이터 수 *(int)*
- per_page - 페이지당 데이터 수 *(int)*
- page - 현재 페이지 번호 *(int)*
- iter_pages - 페이지 범위 *(list화가 가능한 객체)*
- prev_num - 이전 페이지 번호 *(int)*
- next_num - 다음 페이지 번호 *(int)*
- has_prev - 이전 페이지 존재 여부 *(boolean)*
- has_next - 다음 페이지 존재 여부 *(boolean)*

*views/question_views.py*
```python
@bp.route('/list')
def _list() :
    page = request.args.get('page', type=int, default=1) # 요청받은 값의 자료형은 int로 한정, 기본값은 1
    question_list = Question.query.order_by(Question.create_date.desc())
    question_list = question_list.paginate(page=page, per_page=10) # 페이지마다 10개씩의 데이터를 리턴
    return render_template('question/question_list.html', question_list=question_list)
```
*templates/question/question_list.html*
```HTML
<!-- 페이징처리 시작 -->
<ul class="pagination justify-content-center">
    <!-- 이전페이지 -->
    {% if question_list.has_prev %}
    <li class="page-item">
        <a class="page-link" href="?page={{ question_list.prev_num }}">이전</a>
    </li>
    {% else %}
    <li class="page-item disabled">
        <a class="page-link" tabindex="-1" aria-disabled="true" href="javascript:void(0)">이전</a>
    </li>
    {% endif %}
    <!-- 페이지번호 -->
    {% for page_num in question_list.iter_pages() %}
    {% if page_num %}
    {% if page_num != question_list.page %}
    <li class="page-item">
        <a class="page-link" href="?page={{ page_num }}">{{ page_num }}</a>
    </li>
    {% else %}
    <li class="page-item active" aria-current="page">
        <a class="page-link" href="javascript:void(0)">{{ page_num }}</a>
    </li>
    {% endif %}
    {% else %}
    <li class="disabled">
        <a class="page-link" href="javascript:void(0)">...</a>
    </li>
    {% endif %}
    {% endfor %}
    <!-- 다음페이지 -->
    {% if question_list.has_next %}
    <li class="page-item">
        <a class="page-link" href="?page={{ question_list.next_num }}">다음</a>
    </li>
    {% else %}
    <li class="page-item disabled">
        <a class="page-link" tabindex="-1" aria-disabled="true" href="javascript:void(0)">다음</a>
    </li>
    {% endif %}
</ul>
<!-- 페이징처리 끝 -->
```

## 페이징 필터
- jinja2에서 값을 원하는 형태로 볼 수 있게 하며, |로 해당 기능을 수행함
- *length* 등의 내장 필터와 사용자 지정 필터 모두 가능

*filter.py*
##### 사용된 포멧 코드
- %Y - 년
- %m - 월
- %d - 일
- %p - AM / PM 표시
- %I - 시간(12시간 단위)
- %M - 분
```python
def format_datetime(value, fmt='%Y년 %m월 %d일 %p %I:%M') :
    return value.strftime(fmt) # 값을 '년 월 일 AM/PM 시:분' 형태로 출력
```
*app.py*
```python
def create_app() :
    app = Flask(__name__)
    app.config.from_object(config)

    # filter
    from .filter import format_datetime
    app.jinja_env.filters['datetime'] = format_datetime

    return app
```
*templates/question/question_detail.html*
```HTML
<h2 class="border-bottom py-2">{{question.subject}}</h2>
<div class="card my-3">
    <div class="card-body">
        <div class="card-text" style="white-space: pre-line;">
            {{question.content}}
        </div>
        <div class="d-flex justify-content-end">
            <div class="badge bg-light text-dark p-2 text-start">
                <div class="mb-2">{{question.user_id}}</div>
                <div>{{question.create_date|datetime}}</div> <!-- 날짜를 지정된 형식으로 출력 -->
            </div>
        </div>
        <div class="my-3">
            {% if g.user == question.user %}
                <a href="{{url_for('question.modify', question_id=question.id)}}" class="btn btn-sm btn-outline-secondary">수정</a>
                <a href="{{url_for('question.delete', question_id=question.id)}}" class="btn btn-sm btn-outline-secondary">삭제</a>
            {% endif %}
        </div>
    </div>
</div>
```

## 회원관리
### 회원가입
*model.py*
```python
class User(db.Model) :
    id = db.Column(db.Integer, primary_key=True) # 일련번호 - 기본키
    username = db.Column(db.String(150), unique=True, nullable=False) # 사용자명(아이디)
    password = db.Column(db.String(200), nullable=False) # 비밀번호
    email = db.Column(db.String(120), unique=True, nullable=False) # 이메일
```
*forms.py*
- Email()을 사용하기 위해선 email-validator를 설치해야 함
```python
from wtforms import PasswordField, EmailField
from wtforms.validators import Length, EqualTo, Email

class UserCreateForm(FlaskForm) :
    username = StringField('사용자이름', validators=[DataRequired(), Length(min=3, max=25)]) # 길이제한 3~25자
    password1 = PasswordField('비밀번호', validators=[DataRequired(), EqualTo('password2', '비밀번호 불일치')])
    # password1은 password2와 값이 일치해야 유효
    password2 = PasswordField('비밀번호 확인', validators=[DataRequired()])
    email = EmailField('이메일', validators=[DataRequired(), Email()])
```
*views/auth_views.py*
- generate_password_hash 함수는 문자열을 암호화시키며, 복호화가 불가능함
```python
# auth_views.py
from flask import Blueprint, redirect, url_for, session
from flask import render_template, flash, request
from werkzeug.security import generate_password_hash

from app import db
from app.forms import UserCreateForm
from app.models import User

bp = Blueprint('auth', __name__, url_prefix='/auth')

@bp.route('/signup', methods=['POST', 'GET'])
def signup() :
    form = UserCreateForm() # 회원가입 폼 생성

    # 요청을 POST로 전달받고 데이터가 폼의 양식에 알맞을 때 실행
    if request.method == 'POST' and form.validate_on_submit() :
        user = User.query.filter_by(username=form.username.data).first()
        if not user : # 중복되는 유저명(아이디)이 없을 경우 실행
            email = User.query.filter_by(email=form.email.data).first()
            if not email : # 중복되는 이메일이 없을 경우 실행
                user = User(username=form.username.data,
                            password=generate_password_hash(form.password1.data),
                            email=form.email.data)
                db.session.add(user) # 새로운 유저 데이터 추가
                db.session.commit()
                return redirect(url_for('main.index')) # 메인화면으로 리다이렉트
            else : # 중복되는 이메일이 있을 경우 실행
                flash('이미 존재하는 이메일입니다.') # 오류 메시지 전송
        else : # 중복되는 유저명(아이디)이 있을 경우 실행
            flash('이미 존재하는 사용자입니다.') # 오류 메시지 전송

    # GET으로 요청받았거나 데이터가 폼의 양식에 알맞지 않을 때
    return render_template('auth/signup.html', form=form) # 빈 폼 또는 작성 중인 폼을 전송
```
*templates/auth/signup.html*
```HTML
{% extends "base.html" %}
{% block content %}
<div class="container">
    <h5 class="my-3 border-bottom pb-2">계정생성</h5>
    <form method="post">
        {{form.csrf_token}}
        {% include "form_errors.html" %}
        <div class="mb-3">
            <label for="username">사용자 이름</label>
            <input type="text" class="form-control" name="username" id="username" value="{{form.username.data or ''}}">
        </div>
        <div class="mb-3">
            <label for="password1">비밀번호</label>
            <input type="password" class="form-control" name="password1" id="password1" value="{{form.password1.data or ''}}">
        </div>
        <div class="mb-3">
            <label for="password2">비밀번호 확인</label>
            <input type="password" class="form-control" name="password2" id="password2" value="{{form.password2.data or ''}}">
        </div>
        <div class="mb-3">
            <label for="email">이메일</label>
            <input type="text" class="form-control" name="email" id="email" value="{{form.email.data or ''}}">
        </div>
        <button type="submit" class="btn btn-primary">생성하기</button>
    </form>
</div>
{% endblock %}
```

#### 오류 메시지 출력
- 폼이나 flash를 통해 전송받은 오류 메시지를 표시

*templates/form_errors.html*
```HTML
<!-- 폼에 에러 메시지가 있을 때만 작동 -->
{% if form.errors %}
    <div class="alert alert-danger" role="alert">
        {% for f, errors in form.errors.items() %}
        <strong>{{form[f].label}}</strong> <!-- 오류가 난 데이터의 라벨명 -->
        <ul>
            {% for e in errors %}
            <li>{{e}}</li> <!-- 오류 메시지 출력 -->
            {% endfor %}
        </ul>
        {% endfor %}
    </div>
{% endif %}
<!-- flash 메시지가 있을 때만 작동 -->
{% for msg in get_flashed_messages() %}
<div class="alert alert-danger" role="alert">
    {{msg}}
</div>
{% endfor %}
```

### 로그인
- 로그인 성공시 session에 회원 정보를 담아 만료되기 전까지 활용 가능

*forms.py*
```python
class UserLoginForm(FlaskForm) :
    username = StringField('사용자이름', validators=[DataRequired(), Length(min=3, max=25)])
    password = PasswordField('비밀번호', validators=[DataRequired()])
```
*views/auth_views.py*
- check_password_hash 함수는 입력 문자열을 암호화시킨 후 암호화된 문자열과 암호화된 입력 문자열을 비교
```python
from flask import session
from werkzeug.security import check_password_hash
from app.forms import UserLoginForm

@bp.route('/login', methods=['GET', 'POST'])
def login() :
    form = UserLoginForm() # 로그인 폼 생성

    # 요청을 POST로 전달받고 데이터가 폼의 양식에 알맞을 때 실행
    if request.method == 'POST' and form.validate_on_submit() :
        error = None
        user = User.query.filter_by(username=form.username.data).first()
        if not user : # 조회되는 유저가 없을 때 실행
            error = '존재하지 않는 사용자입니다.'
        # 비밀번호가 일치하지 않을 때 실행
        elif not check_password_hash(user.password, form.password.data) :
            error = '비밀번호가 올바르지 않습니다.'
        if error is None : # else :
            session.clear() # 기존 세션 제거
            session['user_id'] = user.id # 세션에 유저 일련번호 저장
            session['username'] = user.username # 세션에 유저명(아이디) 저장
            _next = request.args.get('next', '')
            if _next : # 리다이렉트할 페이지가 지정됐을 때
                return redirect(_next) # 지정된 페이지로 리다이렉트
            else : # 지정되지 않았을 때
                return redirect(url_for('main.index')) # 메인화면으로 리다이렉트         
        flash(error) # 에러 메시지 전송

    # GET으로 요청받았거나 데이터가 폼의 양식에 알맞지 않을 때
    return render_template('auth/login.html', form=form) # 빈 폼 또는 작성 중인 폼을 전송
```
*templates/auth/login.html*
```HTML
{% extends "base.html" %}
{% block content %}
<div class="container">
    <h5 class="ny-3 border-bottom pb-2">로그인</h5>
    <form method="post">
        {{form.csrf_token}}
        {% include "form_errors.html" %}
        <div class="mb-3">
            <label for="username">사용자 이름</label>
            <input type="text" class="form-control" name="username" id="username" value="{{form.username.data or ''}}">
        </div>
        <div class="mb-3">
            <label for="password">비밀번호</label>
            <input type="password" class="form-control" name="password" id="password" value="{{form.password.data or ''}}">
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
</div>
{% endblock %}
```
#### 로그인 제약
*views/auth_views.py*
```python

```

### 로그아웃
*views/auth_views.py*
```python
@bp.route('/logout')
def logout() :
    session.clear() # 세션 제거
    return redirect(url_for('main.index')) # 메인 화면으로 리다이렉트
```