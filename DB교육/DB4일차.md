# 테이블 조인
- A테이블의 PK값과  B테이블의 FK값이 같은 Row만 조회된다.
- 각 테이블은 관련 정보만 담아둠.
- 테이블 끼리 관계형성 해둬서 관련된 여러 정보를 가져온다.
```SQL
SELECT E.*
     , D.*
  FROM EMPLOYEES E
 INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
;
```
# 재귀 조인
- 한 테이블에 PK가 존재하고, 해당 PK를 참조하는 FK가 동시에 존재하는 경우

![image](https://github.com/user-attachments/assets/381fbdb0-52aa-4bfd-b469-3d569c933b92)

- EX> 자신의 상사보다 더 많은 연봉을 받는 사원의 모든 정보
```SQL
-- SUB QUERY 사용
SELECT *
  FROM EMPLOYEES EMP -- Alias 알리아스 => 헷갈리지 않도록 별칭을 붙여줌
 WHERE EMP.MANAGER_ID = (SELECT MAN.EMPLOYEE_ID
                           FROM EMPLOYEES MAN
                          WHERE EMP.MANAGER_ID = MAN.EMPLOYEE_ID
                            AND EMP.SALARY > MAN.SALARY)
;
-- INNER JOIN 사용
SELECT *
  FROM EMPLOYEES EMP -- 부하직원
 INNER JOIN EMPLOYEES MAN -- 상사
    ON EMP.MANAGER_ID = MAN.EMPLOYEE_ID -- 부하직원의 상사사원번호는 상사정보의 사원정보와 같다!
 WHERE EMP.SALARY > MAN.SALARY
;
``
