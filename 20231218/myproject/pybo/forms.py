# forms.py
from flask_wtf import FlaskForm
from wtforms import StringField, TextAreaField, PasswordField, EmailField
from wtforms.validators import DataRequired, Length, EqualTo, Email

class QuestionForm(FlaskForm) :
    msg = '필수항목입니다.'
    subject = StringField('제목', validators=[DataRequired(msg)])
    content = StringField('내용', validators=[DataRequired(msg)])

class AnswerForm(FlaskForm) :
    msg = '필수항목입니다.'
    content = StringField('내용', validators=[DataRequired(msg)])

class UserCreateForm(FlaskForm) :
    username = StringField('사용자이름', validators=[DataRequired(), Length(min=3, max=25)])
    password1 = PasswordField('비밀번호', validators=[DataRequired(), EqualTo('password2', '비밀번호 불일치')])
    password2 = PasswordField('비밀번호 확인', validators=[DataRequired()])
    email = EmailField('이메일', validators=[DataRequired(), Email()])

class UserLoginForm(FlaskForm) :
    username = StringField('사용자이름', validators=[DataRequired(), Length(min=3, max=25)])
    password = PasswordField('비밀번호', validators=[DataRequired()])