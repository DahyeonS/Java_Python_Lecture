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

```

## SQLite
sqlite3 패키지를 이용
```python

```