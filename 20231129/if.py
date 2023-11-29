# n = int(input('n >> '))
# if n % 2 == 0 :
#     print('짝수')
# else :
#     print('홀수')

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