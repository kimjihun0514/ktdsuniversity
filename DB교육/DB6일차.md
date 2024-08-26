# UNION
- UNION은 두 개 이상의 SELECT 문의 결과를 하나로 결합하는 연산자.
- 여러 쿼리 결과를 단일 결과 집합으로 통합할 때 유용.
- UNION은 중복된 행을 자동으로 제거하며, 모든 중복 행을 포함하려면 UNION ALL을 사용.
```SQL
-- 사용할 때 타입을 맞춰줘야 함
SELECT EMPLOYEE_ID 
     , FIRST_NAME 
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 100
 UNION ALL
SELECT *
  FROM (SELECT EMPLOYEE_ID 
             , FIRST_NAME
          FROM EMPLOYEES
         WHERE EMPLOYEE_ID != 100
         ORDER BY EMPLOYEE_ID DESC)
; 
```
# Concat
- CONCAT 함수는 SQL에서 문자열을 연결하는 데 사용.
- 두 개 이상의 문자열을 하나로 결합하여 새로운 문자열을 생성.
- CONCAT은 여러 열의 데이터를 하나의 열로 합치거나, 문자열에 접두사나 접미사를 추가할 때 유용하게 사용.
```SQL
SELECT D.DEPARTMENT_NAME || ' (' || COUNT(E.EMPLOYEE_ID) || ')' 
  FROM DEPARTMENTS D
  LEFT OUTER JOIN EMPLOYEES E
    ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
 GROUP BY D.DEPARTMENT_NAME
;
```
# Scala Query
- Scala Query는 SELECT 문에서 사용할 수 있고, 1개의 컬럼만 반환해야 하며, 1개의 Row만 반환해야 한다.
```SQL
SELECT '사원번호 ' || EMP.EMPLOYEE_ID || '번 사원의 상사명은 ' || (SELECT MAN.FIRST_NAME || ' ' || MAN.LAST_NAME
                                                                   FROM EMPLOYEES MAN
                                                                  WHERE EMP.MANAGER_ID = MAN.EMPLOYEE_ID) || '입니다.' AS 상사명
  FROM EMPLOYEES EMP
;
```
# 정규화
- 정규화는 데이터베이스 설계에서 중요한 과정으로, 데이터의 중복을 최소화하고 데이터 무결성을 보장하는 것을 목표로 함.
- 이는 여러 단계로 구성되며, 각 단계마다 특정 유형의 데이터 중복과 이상현상을 제거.
- 정규화를 통해 데이터베이스의 구조가 개선되어 유지보수가 용이해지고 데이터의 일관성이 향상.
