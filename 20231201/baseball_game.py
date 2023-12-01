# 야구 게임
import random

com = set()
cnt = 0
while True :
    n = random.randint(1, 9)
    com.add(n)
    if len(com) == 3 :
        com = list(com)
        break

while True :
    num = input('겹차지 않는 3자리 수를 입력하세요. >> ')
    user = set()
    for n in num:
        user.add(int(n))
    if len(num) == 3 and len(user) == 3 :
        cnt += 1
        user = []
        for n in num :
            user.append(int(n))
        strike = ball = 0
        for i in range(len(com)) :
            for j in range(len(user)) :
                if com[i] == user[j] and i == j:
                    strike += 1
                elif com[i] == user[j] :
                    ball += 1
        out = 3 - (strike + ball)
        print(f'{strike}Strike {ball}Ball {out}Out')
        if strike == 3 :
            print(f'Bingo!! {cnt}번 만에 맞췄습니다.')
            print(f'정답: {com[0]}{com[1]}{com[2]}')
            break
    else :
        print('다시 입력하세요.')