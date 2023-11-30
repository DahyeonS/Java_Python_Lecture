# while, for

idx = tot = 0
while idx < 5 :
    idx += 1
    tot += idx
    print(idx, tot)
# 1 1
# 2 3
# 3 6
# 4 10
# 5 15

# 1 ~ 100까지 3의 배수 합과 원소 추출하기
cnt = 1; tot = 0
while cnt <= 100 :
    cnt += 1
    if cnt % 3 == 0 :
        tot += cnt
        print(cnt, tot)

cnt = tot = 0
dataset = []
while cnt <= 100 :
    cnt += 1
    if cnt % 3 == 0 :
        tot += cnt
        dataset.append(cnt)
print('tot =', tot) # tot = 1683
print('dataset =', dataset)
# dataset = [3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81,
# 84, 87, 90, 93, 96, 99]

# 1 ~ 100 사이에서 5의 배수면서 3의 배수가 아닌 합 계산하기
cnt = tot = 0
dataset = []
while cnt <= 100 :
    cnt += 1
    if cnt % 5 == 0 and cnt % 3 != 0 :
        tot += cnt
        dataset.append(cnt)
print('tot =', tot) # tot = 735
print('dataset =', dataset) # dataset = [5, 10, 20, 25, 35, 40, 50, 55, 65, 70, 80, 85, 95, 100]

# -1, 3, -5, 7, -9 ~ 99까지의 합을 구하시오
cnt = idx = 1
tot = 0

while cnt < 100 :
    if idx % 2 != 0 :
        tot -= cnt
        print(-cnt, end=' ')
    else :
        tot += cnt
        print(cnt, end=' ')
    cnt += 2
    idx += 1
print('')
print(tot)

# 윤년 판별
year = int(input('연도 입력 >> '))
if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0 :
    print('윤년입니다.')
else :
    print('평년입니다.')

# FizzBuzz
n = 1
while n <= 100 :
    if n % 3 == 0 and n % 5 == 0 :
        print(n, 'FizzBuzz')
    elif n % 3 == 0 :
        print(n, 'Fizz')
    elif n % 5 == 0 :
        print(n, 'Buzz')
    else :
        print(n)
    n += 1

for i in range(1, 101) :
    print('Fizz' * (i % 3 == 0) + 'Buzz' * (i % 5 == 0) or i)