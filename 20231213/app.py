# app.py
from flask import Flask, redirect, url_for, render_template, request
app = Flask(__name__)

@app.route('/')
def index() :
    return 'Hello Index'

@app.route('/hello')
def hello() :
    return 'Hello, world!'

@app.route('/users/<userid>')
def userid(userid) :
    return f'<h1>Hello {userid}</h1>' # /users/hong -> Hello hong

@app.route('/admin')
def admin() :
    return 'Hello Admin'

@app.route('/guest/<guest>')
def guest(guest) :
    return f'Hello {guest}'

@app.route('/user/<name>')
def user(name) :
    if name == 'admin' :
        return redirect(url_for('admin')) # 메소드명에 속한 링크로 이동
    else :
        return redirect(url_for('guest', guest=name)) # name을 매개변수 guest로 넣어서 리다이렉트

@app.route('/login_form')
def login_form() :
    return render_template('form.html') # html 파일을 실행

@app.route('/login_proc_get', methods=['GET']) # GET 방식
def login_proc_get() :
    user_id = request.args.get('user_id') # 파라미터 값을 요청해서 전달받음
    user_pwd = request.args.get('user_pwd')
    print(user_id, user_pwd)

    return f'login user id {user_id}, login user pwd {user_pwd}'

@app.route('/login_proc_post', methods=['POST']) # POST 방식
def login_proc_post() :
    user_id = request.form['user_id'] # 파라미터 값을 요청해서 전달받음
    user_pwd = request.form['user_pwd']
    print(user_id, user_pwd)

    return f'login user id {user_id}, login user pwd {user_pwd}'

@app.route('/plays') # POST 방식
def plays() :
    t1 = ('갤러그', '너구리', '리니지')
    l1 = ['야구', '축구', '농구']
    d1 = {'one':1, 'two':2, 'three':3}

    return render_template( # html에 값 전달
        'plays.html',
        title='PLAYS',
        games=t1,
        sports=l1,
        nums=d1
        )

if __name__ == '__main__' :
    app.run(debug=True)