# app.py
from flask import Flask, redirect, url_for
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

if __name__ == '__main__' :
    app.run(debug=True)