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