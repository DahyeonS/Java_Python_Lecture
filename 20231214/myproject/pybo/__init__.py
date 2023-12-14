# pybo.py
from flask import Flask
from flask_migrate import Migrate
from flask_sqlalchemy import SQLAlchemy
import config

db = SQLAlchemy()
migrate = Migrate()

# create_app(): flask main()
def create_app() :
    app = Flask(__name__)
    app.config.from_object(config)

    # ORM
    db.init_app(app)
    migrate.init_app(app, db)
    from . import models

    # Route
    from .views import main_views
    app.register_blueprint(main_views.bp)

    return app