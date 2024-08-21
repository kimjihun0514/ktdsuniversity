## 데이터 그룹핑

Row를 특정 기준으로 분류해, 분류별 그룹함수를 사용할 수 있다.

- 부서별 사원의 수
- 부서별 사원의 연봉 합
- 부서별 최고 연봉
- 부서별 최저 연봉
- 부서별 연봉 총 합 등등

**GROUP BY[분류 기준COLUMN]**

> 여러 개의 기준으로 분류하려면 분류 기준COLUMN을 콤마(,)로 연결
> 

GROUP BY [분류 기준COLUMN1],[분류 기준COLUMN2],[…]

GROUP BY를 사용하면 나누어 진 개수만큼의 임시 테이블로 쪼개짐

```sql
SELECT DEPARTMENT_ID
     , MAX(SALARY)
     , MIN(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID --> GROUP BY가 포함 된 쿼리에서는 *를 쓸 수 없음
;

SELECT DEPARTMENT_ID
     , JOB_ID
     , AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
     , JOB_ID
;
```

GROUP BY 주의점

- GROUP BY는 테이블을 기준에 따라 임시테이블로 쪼개는 키워드.
- 테이블에 굉장히 많은 Row가 있을 때 GROUP BY를 사용하게 된다면, 성능이 매우 떨어지게 된다. → 사용 X!!!

---

### 쪼개진 데이터를 필터링 하는 방법

- HAVING을 사용한다.

SELECT [COLUMN], [COLUMN], […]  

FROM [TABLE] 

WHERE [CONDITIONS] 

GROUP BY [COLUMN], [COLUMN], […] 

**HAVING [CONDITION]**

- 실무에서는 사용하지 않음.
- 사용하더라도 검증 용도로만 사용됨.

---

### 작성 순서

1. SELECT
2. FROM
3. WHERE
    1. AND / OR
4. GROUP BY
5. HAVING
6. ORDER BY

---

## 서브 쿼리

SELECT 쿼리 안의 SELECT 쿼리(WHERE에서 사용할 때)

SELECT (SELECT…FROM…) ⇒ SCALA QUERY

FROM (SELECT…FROM…) ⇒ INLINE QUERY

**WHERE COL 연산자 (SELECT…FROM…) ⇒ SUB QUERY**

- 조회하려는 대상을 정확히 알지 못할 때 사용
- 조회하려는 대상이 하나 이상일 때 사용
    - EX> “IT_PROG”부서에서 근무 중인 사원들의 정보를 조회(조회대상(PK)을 모름)
    
    ```sql
    SELECT *
      FROM EMPLOYEES
     WHERE 
    ;
    ```
    
    - EX> 평균 연봉보다 많은 연봉을 받는 사원들을 조회
    
    ```sql
    SELECT *
      FROM EMPLOYEES
     WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES)
    ;
    ```
    
    - EX> 지역번호가 1700인 부서에서 근무 중인 사원들의 정보 조회(대상이 하나 이상)
    
    ```sql
    SELECT 
      FROM 
     WHERE 
    ;
    ```
    

## 테이블 조인

테이블간 Primary Key - Foreign Key로 연결해 관련 정보들을 가져옴

- DEPARTMENTS와 EMPLOYEES 테이블은 DEPARTMENT_ID로 관계가 형성되어있음.
    - DEPARTMENT 테이블의 PK인 DEPARTMENT_ID의 값은
        
        EMPLOYEES 테이블의 FK인 DEPARTMENT_ID와 같다.
        
- 이러한 연결 상태를 JOIN이라 하며, 연결 관계를 지칭할 수 있다.(**Has A관계**)

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/32ec58b7-3293-49fb-b949-09c487f936dc/image.png)

> JOIN 관계에 있는 데이터에 따라 여러가지 형태의 관계가 형성
> 
- 1:1
    - 한 테이블의 PK가 다른 테이블의 FK에 하나만 존재하는 관계
    - 만들어서는 안됨
        - 단, 컬럼의 수가 40개 이상 넘어갈 경우 테이블을 분리해서 1:1관계를 맺어야 함
- 1:N
    - 한 테이블의 PK가 다른 테이블의 FK에 여러개가 존재하는 관계
    - PK = 1, FK = N
    - 가장 흔하게 만들게 됨
        - EX> 한 명의 회원(PK)이 여러 개의 상품을 주문(FK)한다
        - EX> 한 명의 회원(PK)이 여러 개의 게시글을 작성(FK)한다 등
- N:N
    - 물리적으로 존재할 수 없는 관계
    - 한 명의 강사가 여러 명의 수강생에게 강의한다(1:N)
    - 한 명의 수강생은 여러 명의 강사에게 강의를 받는다(1:N)
        - 결국, N:N관계가 만들어짐
        - N:N관계는 별도의 테이블을 만들어 1:N으로 해소해야 함

---

## DB

| 논리 모델 | 물리 모델 |
| --- | --- |
| 엔티티 | 테이블 |
| 필드 | 컬럼 |

### ERD(Entity Relationship Diagram)

식별관계 : 부모 테이블의 기본키(PK)를 자식 테이블이 자신의 기본키(PK)로 사용 ⇒ PFK(실선으로 표현)

비-식별관계 : 일반적인 관계 ⇒ 점선으로 표현

---

논리명 : 우리가 스스로 알아보기 위한 이름(EX> 사원정보)

물리명 : 실제로 저장된 이름(EX> EMPLOYEES)

### ERD를 만드는 순서

1. 논리명 물리명을 적고 Primary Key들만 먼저 만들어둔다.
2. 부모테이블에서 받는 PK를 연결해주면 FK가 자동으로 생성되고 원하는 논리명으로 바꿔준다.
3. 채우지 못한 컬럼을 작성한다.
4. 마지막으로 순서를 수정한다.

### 재귀 조인

스스로에게 참조함

## MULTI KEY

Primary Key가 여러 개일 경우 Multi Key라고 함.(식별관계 사용 시)

| PK | PK |  |
| --- | --- | --- |
| A | 1 | 해당 줄이 하나의 PK가 됨 |
| B | 1 |  |
| C | 1 |  |
| A | 2 |  |
| A | 1 | 중복이 되기 때문에 X |
- 사용하는 경우
    - 같은 게시글에 똑같은 사람이 좋아요를 한번 더 누르려고 할 경우
    
    EX> 게시글(A가 글을 작성하고, B가 좋아요를 누름)
    

| 글 번호 | 좋아요 한 사람 |  |
| --- | --- | --- |
| 1 | B |  |
| 1 | B | 중복이 되기 때문에 사용 불가 |
