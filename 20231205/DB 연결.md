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
