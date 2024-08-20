# DBMS
- Oracle
- SQLite
- MySQL
- MariaDB
- MS-SQL(SQL-Sever) 등등…
### 표준 SQL
- ANSI SQL
## 데이터 조회
- SELECT[COLUMN],[COLUMN],[…]
- FROM[TABLE]
1. 날짜를 조회하는 방법
SYSDATE를 사용하고, 받아 올 테이블이 없기 때문에 ``DUMMY TABLE``을 사용한다.(Row가 하나만 있는 의미 없는 테이블)
```SQL
SELECT SYSDATE
  FROM DUAL
;
```

2. 날짜를 문자로 변경하는 방법(TO_CHAR())
**TO_CHAR()** 함수를 사용해서 바꾸고 싶은 날짜타입의 컬럼을 넣고, 포멧을 설정한다.
- **'YYYY-MM-DD'** => 연-월-일
- **'HH:MI:SS'** => 시:분:초(**12시간** 베이스)
- **'HH24:MI:SS'** => 시:분:초(**24시간** 베이스)
```SQL
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')
  FROM DUAL
;
```

3. 문자를 날짜로 변경하는 방법(TO_DATE())
**TO_DATE()** 함수를 사용해서 날짜타입으로 바꾸고 싶은 문자를 넣고, 포멧을 설정한다.
```SQL
SELECT TO_DATE()
  FROM 
```

4. SELECT - FROM 문법 정리
```SQL
SELECT[조회 할 컬럼] => 보여주고 싶은 것
  FROM[조회 할 테이블] => 가져오고 싶은 것
```
## 데이터 정렬
- SELECT[COLUMN],[COLUMN],[…]
- FROM[TABLE]
- ORDER BY[COLUMN][ORDER TYPE]
**ORDER BY**를 사용해 정렬하고 싶은 컬럼을 놓고 ASC(**오름차순**), DESC(**내림차순**)를 사용한다.
```SQL
오름차순(ASC 생략 가능)
SELECT *
  FROM EMPLOYEES
 ORDER BY FIRST_NAME ASC
;
내림차순
SELECT *
  FROM EMPLOYEES
 ORDER BY FIRST_NAME DESC
;
```
``ORDER BY는 항상 마지막에 작성이 되어야 함.``
## 데이터 필터링
- 하나 이상의 테이블에서 여러 데이터를 가져옴. 단, 조건에 맞는 데이터만 가져옴.
- SELECT [COLUMN], [COLUMN], […]  
- FROM [TABLE] 
- WHERE [CONDITIONS]
- **WHERE**을 사용해서 필터링 한다.(**=, !=, <, <=, >, >=, BETWEEN A AND B, IS NULL ...**)
```SQL
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID > 100
;
```
- **연산자의 종류**

![image](https://github.com/user-attachments/assets/529f1fab-a384-4a60-9992-693b18425a3b)

7. AND / OR의 연산 순위를 조정하는 방법
``AND 연산자가 우선순위``이기 때문에 OR연산자를 먼저 연산하고 싶다면 **소괄호()**를 사용해 묶어준다.
```SQL
SELECT *
  FROM EMPLOYEES
 WHERE (JOB_ID = 'SA_MAN'
    OR JOB_ID = 'SA_REP'
    OR JOB_ID = 'IT_PROG')
   AND SALARY >= 10000
   AND MANAGER_ID = 100
;
```

8. IN, LIKE, BETWEEN, NOT, IS NULL, IS NOT NULL 연산자의 사용 방법
- **IN**연산자는 뒤에 소괄호를 붙여서 사용한다.
```SQL
SELECT *
  FROM EMPLOYEES
 WHERE JOB_ID IN ('SA_MAN', 'SA_REP', 'IT_PROG')
   AND SALARY >= 10000
   AND MANAGER_ID = 100
;
```
- LIKE연산자는 ``WILD CARD``가 사용이 된다.(**%, _**)
- **COLUMN LIKE 'D%' --> 컬럼의 값이 D로 시작한다.**
- **COLUMN LIKE '%D' --> 컬럼의 값이 D로 끝난다.**
- **COLUMN LIKE '%D%' --> 컬럼의 값이 D로 시작하거나, D로 끝나거나, 중간에 D가 존재한다. => 컬럼이 포함되어있다.**
- **COLUMN LIKE '__' --> 컬럼의 값이 두 글자다.**
- **COLUMN LIKE '____' --> 컬럼의 값이 네글자다.**
```SQL
SELECT *
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE 'D%'
;

SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE '____'
;
```
- **BETWEEN**연산자는 주로 날짜를 비교할 때 사용된다.
```SQL
SELECT *
  FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN TO_DATE('2005-09-01', 'YYYY-MM-DD') AND TO_DATE('2005-09-30', 'YYYY-MM-DD')
;
```
- **NOT**연산자는 부정을 할 때 사용이 된다.

- **IS NULL**연산자는 해당 테이블이 NULL인 것을 가져온다.
```SQL
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL
;
```
- **IS NOT NULL**연산자는 해당 테이블이 NULL이 아닌 것을 가져온다.
```SQL
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
;
```
