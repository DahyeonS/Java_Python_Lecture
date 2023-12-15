# config.py
import os

BASE_DIR = os.path.dirname(__file__)
db_path = os.path.join(BASE_DIR, 'pybo.db')
SQLALCHEMY_DATABASE_URI = f'sqlite:///{db_path}'
SQLALCHEMY_TRACK_MODIFICATIONS = False
SECRET_KEY = 'dev'