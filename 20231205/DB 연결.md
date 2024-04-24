# DB 연결
## MySQL
pymysql 패키지를 이용
```python
# close() 이용
try :
    # DB 연결
    conn = pymysql.connect(host='localhost', # IP 주소
                           user='root', # 유저명(아이디)
                           password='rpass', # 패스워드
                           db='kdigital2307') # DB 이름
    # 쿼리 작업
    cursor = conn.cursor()
    sql = 'SELECT COUNT(*) FROM users' # 쿼리문
    cursor.execute(sql) # 쿼리문 실행
    cnt = cursor.fetchone() # 실행 결과 - (0, )
except Exception as e :
    print(e)
finally :
    cursor.close() # 쿼리 작업 종료
    conn.close() # DB 연결 종료

# with문 이용
try :
    # DB 연결
    with pymysql.connect(host='localhost',
                           user='root',
                           password='rpass',
                           db='kdigital2307') as conn :
        # 쿼리 작업
        with conn.cursor() as cursor :
            sql = 'SELECT COUNT(*) FROM users'
            cursor.execute(sql)
            cnt = cursor.fetchone() # (0, )
except Exception as e :
    print(e)
```

## MSSQL
pymssql 패키지를 이용
```python
import pymssql

def select_all_mssql() :
    with pymssql.connect(host='localhost',
                     user='sa',
                     password='sapass',
                     database='memberdb') as conn : # dict 형태
        with conn.cursor() as cursor :
            sql = 'SELECT * FROM users'
            cursor.execute(sql)
            users = cursor.fetchall()
            return users
```

## SQLite
sqlite3 패키지를 이용
```python
import sqlite3

def select_sqlite3_dict() :
    with sqlite3.connect('./data/python.db') as conn :
        conn.row_factory = sqlite3.Row
        cursor = conn.cursor()
        sql = 'SELECT * FROM miniboard'
        cursor.execute(sql)
        rs = cursor.fetchall()
        rs_list = []
        rs_dict = []
        for r in rs :
            rs_list.append(list(r))
            rs_dict.append(dict(r))
        return rs_list, rs_dict

rs_list, rs_dict = select_sqlite3_dict()
print(rs_list)
# [[1, 'hong', 'title1', 'content1', '2023-12-05 15:05:49']]
print(rs_dict)
# [{'idx': 1, 'writer': 'hong', 'title': 'title1', 'content': 'content1', 'regdate': '2023-12-05 15:05:49'}]

# 판다스 활용
import pandas as pd

def select_pandas() :
    with sqlite3.connect('./data/python.db') as conn :
        sql = 'SELECT * FROM miniboard'
        rs = pd.read_sql_query(sql, conn)
        print(type(rs))
        return rs # 데이터프레임 형태
```

## NoSQL
tinydb 패키지를 이용
```python
from tinydb import TinyDB

db = TinyDB('./data/db.json') # DB 생성(json 파일 형태)

# INSERT
db.insert({'type':'apple', 'count':7})

# SELECT
db.all() # 모든 데이터
db.all()[0] # 첫번째 데이터

from tinydb import Query # 조건문 처리를 위한 패키지

q = Query()

search_type = db.search(q.type == 'peach') # type가 peach인 대상을 선택
print(search_type) # [{'type': 'peach', 'count': 3}]

search_count = db.search(q.count > 2) # count가 2보다 큰 대상을 선택
print(search_count) # [{'type': 'apple', 'count': 7}, {'type': 'peach', 'count': 3}]

# UPDATE
db.update({'count':10}, q.type == 'apple') # type가 apple인 대상의 count를 10으로 변경

# DELETE
db.remove(q.count < 5) # count가 5보다 작은 대상 삭제

# TRUNCATE
db.truncate() # 데이터 모두 삭제

# 테이블 생성
fruits = db.table('fruits') # fruits 테이블 생성
fruits.insert({'type':'apple', 'count':7}) # fruits 테이블에 데이터 추가

fruits.all() # [{'type': 'apple', 'count': 7}]
db.all() # [] - 테이블에는 데이터가 출력되나 전체 DB에는 출력되지 않음

# 테이블 삭제
db.drop_table('fruits')

# 외부 API 저장
import requests
response = requests.get(url) # 특정 주소에서 응답을 요청

if response.status_code == 200 :
    rs = response.json() # 응답받은 데이터를 JSON으로 변환
    db = TinyDB('./data/lotto.json') 
    table = db.table('lotto')
    table.insert(rs) # 변환한 데이터를 저장
```