import random

r = random.random()
print(r)

random.seed(42)

cnt = 0
while True :
    r = random.random()
    print(r, end=' ')
    if r < 0.01 :
        break
    cnt += 1
print(cnt)

names = ['홍길동', '이순신', '유관순']
if '이순신' in names :
    print('ok')
else :
    print('no')