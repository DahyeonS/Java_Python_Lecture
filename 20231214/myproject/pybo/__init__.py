# pybo.py
from flask import Flask

# create_app(): flask main()
def create_app() :
    app = Flask(__name__)

    @app.route('/')
    def index() :
        return '<h1>Hello, pybo!</h1>'
    
    return app