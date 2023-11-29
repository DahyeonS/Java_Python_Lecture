n = int(input('n >> '))
if n % 2 == 0 :
    print('짝수')
else :
    print('홀수')

import datetime

today = datetime.datetime.now()
print(today) # 현재 시각
print(type(today)) # <class 'datetime.datetime'>

day = today.weekday() # 0 ~ 6 (월 ~ 일)
print(day)

if day >= 5 :
    print('주말')
else :
    print('평일')

date = ['월', '화', '수', '목', '금', '토', '일']
print(date[day] + '요일')

if day == 0 :
    print('월')
elif day == 1 :
    print('화')
elif day == 2 :
    print('수')
elif day == 3 :
    print('목')
elif day == 4 :
    print('금')
elif day == 5 :
    print('토')
else :
    print('일')

if day % 2 == 0 :
    if day == 0 :
        print('월')
    else :
        print('월요일은 아니에요')
else :
    pass # 아무 작업도 수행하지 않음

num = 80
if num >= 60 :
    grade = 'pass'
else :
    grade = 'not pass'
print(grade)

grade = 'pass' if num >= 60 else 'not pass' # 삼항 연산자(참 if 조건 else 거짓)
print(grade)

s = 'hong is hong gil dong'
if 'hong' in s :
    print('ok')
else :
    print('not found')