s = '나는 홍길동 입니다'
for v in s :
    print(v, end=' ') # 나 는   홍 길 동   입 니 다

sp = s.split()
print(sp) # ['나는', '홍길동', '입니다']

for v in sp :
    if '홍길동' in v :
        print(v, end=' ') # 홍길동

l = [1, 2, 3, 4, 5]
for e in l :
    if e % 2 == 1 :
        print(e, end=' ') # 1 3 5

n = range(5)
print(n) # range(0, 5)

nl = list(n)
print(nl) # [0, 1, 2, 3, 4]

for i in n :
    print(i, end=' ') # 0 1 2 3 4

n = range(0, 5, 2)
for i in n :
    print(i, end=' ') # 0 2 4

l = [10, 20, 30, 40, 50]
for i in range(len(l)) :
    print(l[i], end=' ') # 10 20 30 40 50

for i in range(len(l)) :
    l[i] *= 10
    print(l[i], end=' ') # 100 200 300 400 500

n = range(1, 101)
lst = []
for i in n :
    if i % 5 == 0 :
        lst.append(i)
print(lst) # [5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100]

lst = []
for i in range(3, 101, 3) :
    lst.append(i)
print(lst)
# [3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90,
# 93, 96, 99]

y = [1, 0, 2, 1, 0]
y_pred = [1, 0, 2, 0, 0]
size = len(y)
acc = 0
for idx in range(size) :
    acc += int(y[idx] == y_pred[idx]) * 100 / size
print(acc) # 80.0

import random
lst = []
for i in range(10) :
    lst.append(random.randint(0, 9) * 0.25)
print(lst)

for i in range(2, 7, 2) :
    print(f'= {i}단 =')
    for j in range(1, 10) :
        print(f'{i} * {j} = {i * j}')

string = '''나는 홍길동 입니다.
주소는 서울시 입니다.
나이는 35세 입니다.'''
sents = [] # 문장 저장
words = [] # 단어 저장
chars = [] # 문자 저장

for sent in string.split('\n') :
    sents.append(sent)
    for word in sent.split() :
        words.append(word)
        for char in word :
            chars.append(char)
print(sents)
print(words)
print(chars)