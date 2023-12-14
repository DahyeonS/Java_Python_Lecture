# main_views.py
from flask import Blueprint

bp = Blueprint('main', __name__, url_prefix='/')

@bp.route('/')
def index() :
    return '<h1>Hello, pybo main!</h1>'

@bp.route('/hello')
def hello() :
    return '<h1>Hello, pybo hello!</h1>'