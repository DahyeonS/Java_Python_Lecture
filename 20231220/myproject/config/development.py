# development.py
from config.default import *

db_path = os.path.join(BASE_DIR, 'pybo.db')
SQLALCHEMY_DATABASE_URI = f'mysql:///{db_path}'
SQLALCHEMY_TRACK_MODIFICATIONS = False
SECRET_KEY = 'dev'