# 숫자 맞추기 게임
import random

com = random.randint(1, 10)
cnt = 0

while True :
    cnt += 1
    user = int(input('1부터 10까지의 숫자를 입력하세요. >> '))
    if user == com :
        print(f'정답! {cnt}번 만에 맞췄습니다!')
        break
    else :
        print('오답! 다시 시도해보세요.')

# 숫자 찍기
for i in range(1, 6) :
    print(str(i) * 5)

for i in range(1, 26) :
    for j in range(i, i+1) :
        if j < 10 :
            print(j, end='  ')
        else :
            print(j, end=' ')
    if i % 5 == 0 :
        print()

for i in range(1, 26, 5) :
    for j in range(i, i+5) :
        if j < 10 :
            print(j, end='  ')
        else :
            print(j, end=' ')
    print()

# 별 찍기
# 1번
for i in range(5) :
    print('★' * 5)

# 2번
for i in range(1, 6) :
    print('★' * i)

# 3번
for i in range(5, 0, -1) :
    print('★' * i)

# 4번
for i in range(1, 11, 2) :
    print(' ' * ((11 - i) // 2), '★' * i)

# 5번
for i in range(9, 0, -2) :
    print(' ' * ((11 - i) // 2), '★' * i)

# 6번
for i in range(1, 13, 2) :
    print(' ' * ((13 - i) // 2), '★' * i)
for i in range(9, 0, -2) :
    print(' ' * ((13 - i) // 2), '★' * i)

# 주사위 눈 구하기
for i in range(1, 7) :
    for j in range(1, 7) :
        if i + j == 6 :
            print(f'({i}, {j})', end=' ')

for x in range(0, 11) :
    for y in range(0, 11) :
        if x * 2 + y * 4 == 10 :
            print(f'x = {x}, y = {y}')

# 버블 정렬
sort_num = []
for i in range(10) :
    sort_num.append(random.randint(0, 10))
print(sort_num)

for i in range(len(sort_num)-1) :
    check = False
    for j in range(len(sort_num)-1-i) :
        if sort_num[j] > sort_num[j+1] :
            check = True
            sort_num[j], sort_num[j+1] = sort_num[j+1], sort_num[j]
            print(sort_num)
    if not check :
        break

# 로또 뽑기
# 1장 뽑기
lotto = set()
while True :
    lotto.add(random.randint(1, 46))
    if len(lotto) == 6 :
        break
print(lotto)

# 5장 뽑기
lotto5 = []
lotto = set()
while True :
    lotto.add(random.randint(1, 45))
    if len(lotto) == 6 :
        lotto5.append(lotto)
        lotto = set()
    if len(lotto5) == 5 :
        break
print(lotto5)

# list 사용
lotto_num = []
for i in range(1, 45) :
    lotto_num.append(i)

lotto5 = []
for i in range(5) :
    for j in range(1000) :
        shuffle = random.randint(0, 44)
        lotto_num[0], lotto_num[shuffle] = lotto_num[shuffle], lotto_num[0]
    lotto = lotto_num[:6]
    print(lotto)
    lotto5.append(lotto)
print(lotto5)
