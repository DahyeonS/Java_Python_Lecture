# forms.py
from flask_wtf import FlaskForm
from wtforms import StringField, TextAreaField
from wtforms.validators import DataRequired

class QuestionForm(FlaskForm) :
    msg = '필수항목입니다.'
    subject = StringField('제목', validators=[DataRequired(msg)])
    content = StringField('내용', validators=[DataRequired(msg)])

class AnswerForm(FlaskForm) :
    msg = '필수항목입니다.'
    content = StringField('내용', validators=[DataRequired(msg)])