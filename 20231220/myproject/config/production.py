# production.py
from config.default import *

db_path = os.path.join(BASE_DIR, 'pybo.db')
SQLALCHEMY_DATABASE_URI = f'sqlite:///{db_path}'
SQLALCHEMY_TRACK_MODIFICATIONS = False
SECRET_KEY = b'\x03\x7f\x0e,\xe1m\xddL\x01*P\x9c\xff_B\xb3'