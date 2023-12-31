a = 11111111111111111111111111111111111111111111111111111
print(a) # 11111111111111111111111111111111111111111111111111111

var1 = 'hello python'
print(var1) # 'hello python'
print(id(var1)) # 1940528694192
print(type(var1)) # <class 'str'>

var1 = 100
var2 = 100
print(var1) # 100
print(id(var1)) # 140726897464856
print(id(var2)) # 140726897464856
print(id(100)) # 140726897464856

var1 = "a"
var2 = 'a'
print(var1) # a
print(id(var1)) # 140726897495264
print(id(var2)) # 140726897495264
print(id('a')) # 140726897495264

var1 = 150.25
print(var1) # 150.25
print(type(var1)) # <class 'float'>
var2 = True
var3 = False
print(var2) # True
print(type(var2)) # <class 'bool'>
print(var3) # False

import keyword
v1 =  keyword.kwlist
print(v1)

# ['False', 'None', 'True', 'and', 'as', 'assert', 'async', 'await', 'break', 'class', 'continue', 'def', 'del', 'elif',
# 'else', 'except', 'finally', 'for', 'from', 'global', 'if', 'import', 'in', 'is', 'lambda', 'nonlocal', 'not', 'or',
# 'pass', 'raise', 'return', 'try', 'while', 'with', 'yield']

i = 10
print(type(i)) # <class 'int'>

a = int(10.5)
b = int(20.42)
c = a + b
print(c) # 30

a = float(a)
b = float(b)
c = a + b
print(c) # 30.0

print(int(True)) # 1
print(int(False)) # 0

st = '10'
i = int(st) ** 2
print(i) # 100

num1 = 100
num2 = 20
add = num1 + num2
print(add) # 120

num1 = 100
num2 = 30
div = num1 / num2
print(div) # 3.333333333333333
print(int(div)) # 3

div2 = num1 % num2
print(div2) # 10

num1 = 100
num2 = 20
num1 == num2 # False
num1 != num2 # True
num1 > num2 # True
num1 < num2 # False

num1 >= 50 and num2 <= 10 # False(앞 연산이 False일 경우 연산 종료)
num1 >= 50 or num2 <= 10 # True(앞 연산이 True일 경우 연산 종료)

not(num1 >= 50) # False

i = tot = 10
i, tot # (10, 10) => tuple 자료형
print(i, tot) # 10 10

i += 1
i # 11
tot += i
tot # 21

a = 10
b = 20
print(a, b) # 10 20

a, b = b, a
(a, b) = (b, a)

print(a, b) # 20 10

# 패킹(packing) 할당
lst = [1, 2, 3, 4, 5] # 리스트
print(lst[0]) # 1

v1, *v2 = lst # 첫번째 요소만 v1, 나머지는 v2(*는 제외한 나머지)
print(v1, v2) # 1 [2, 3, 4, 5]

*v1, v2, v3 = lst
print(v1, v2, v3) # [1, 2, 3] 4 5

i = input('숫자 입력: ')
print(i)

a = int(input('숫자 입력: '))
b = int(input('숫자 입력: '))
c = a + b
print(c)

print(help(print))
print(1, end='\t')
print(2) # 1	2
print(1, 2, 3, 4, sep=',') # 1,2,3,4

print('★', end='')
print('★', end='')
print('★', end='')
print('★', end='')
print('★')

print('★' * 5)

f = format(3.14159, '8.3f') # 8자리, 소수점 3자리 실수
print(f) #    3.142

f = format(12345, '10d') # 10자리 실수
print(f) #      12345

f = format(12345, '3,d')
print(f) # 12,345

a = 10; b = 20
tot = a + b
print('10 + 20 = %d' %tot) # 10 + 20 = 30
print('10 + 20 = %s' %tot) # 10 + 20 = 30
print('%s + %s = %s' %(a, b, tot)) # 10 + 20 = 30
print('이름은 %s이고, 나이는 %d입니다.' %('홍길동', 35)) # 이름은 홍길동이고, 나이는 35입니다.

print('{} + {} = {}'.format(a, b, tot)) # 10 + 20 = 30
print('이름은 {}이고, 나이는 {}입니다.'.format('홍길동', 35)) # 이름은 홍길동이고, 나이는 35입니다.

ff = '{} + {} = {}'.format(a, b, tot)
print(ff) # 10 + 20 = 30

ff = f'{a} + {b} = {tot}'
print(ff) # 10 + 20 = 30

uid = input('id input >> ')
query = f'select * from member where uid = {uid}'
print(query)

multi = '''
this is
one line
string
'''
oneLine = 'this is \none line \nstring'
print(multi)
print(oneLine)

s = 'PYTHON'
print(s[0]) # P
print(s[len(s)-1]) # N
print(s[-1]) # N

l = len(s)
ss = s[0] + s[l-1]
print(ss) # PN

s = 'this is one line string'
print(len(s)) # 23

# 슬라이싱 -> numpy
ss = s[:4]
print(ss) # this
print(s[8:12]) # one
print(s[-6:]) # string

s = [1, 2, 3, 4, 5]
sss = s[:] # 복사본(값 변경 가능)
ssss = s # 참조변수

ss = s[::2]
print(ss) # [1, 3, 5]

ss = s[1::2]
print(ss) # [2, 4]

ss = s[1:-1]
print(ss) # [2, 3, 4]

ss = s[:-1]
print(ss) # [1, 2, 3, 4]

# 문자열 처리 함수
s = 'this is one line string'
cnt = s.count('t')
print(cnt) # 2
print(s.replace('this', 'that')) # that is one line string

m = '''this is 
multi line 
string'''
print(m.split('\n')) # ['this is ', 'multi line ', 'string']

oneLine = 'this is one line string'
words = oneLine.split()
print(words) # ['this', 'is', 'one', 'line', 'string']

j = ','.join(words)
print(j) # this,is,one,line,string

print('\n') # 줄 바꿈
print('\\n') # \n
print(r'\n') # \n