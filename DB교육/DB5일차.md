# INLINE VIEW
- JOIN만으로 풀리지 않는 문제를 INLINE VIEW를 통해서 처리함
    - EX> 사원 수가 가장 많은 부서
- 보통 INLINE VIEW 내부에는 복잡한 JOIN 쿼리가 작성된다

# 외부조인

## LEFT OUTER JOIN

- 테이블 A에 테이블 B를 조인하여 데이터를 가져옴

⇒ 메인 테이블과 참조테이블이 생김 (A테이블이 메인 테이블이 됨)

![image](https://github.com/user-attachments/assets/bd6e207f-c3d7-4c8e-8606-27ae7b4b1258)


INNER JOIN과는 다르게 LEFT OUTER JOIN은 메인 테이블(STUDENT)이 온전하게 나온다.

중복 데이터가 필연적으로 발생

⇒ 성능이 떨어질 수 있음 필요할 때만 사용

학생 4의 FK가 NULL이기 때문에 연결 된 TEACHER의 테이블도 NULL이 됨

- 사용하는 경우
1. 쇼핑몰 ⇒ 가전제품 ⇒ 냉장고, 에어컨, TV, 전자레인지 …

A가 냉장고 1개와 에어컨을 1개를 사감

B가 냉장고 1개와 에어컨 2개를 사감

가전제품 LEFT OUTER JOIN 주문

| 가전제품 | 주문 |
| --- | --- |
| 냉장고 | A, 냉장고, 1 |
| 냉장고 | B, 냉장고, 1 |
| 에어컨 | A, 에어컨, 1 |
| 에어컨 | B, 에어컨, 2 |
| TV | NULL, NULL, NULL |
| 전자레인지 | NULL, NULL, NULL |
| … | … |
1. 게시글 ⇒ 댓글
- 게시글

| PK | 제목 |
| --- | --- |
| 1 | 축하~~~ |
| 2 | test1 |
| 3 | ~~ |
| 4 | ~~ |
| … | … |
- 댓글

| PK | FK | 내용 |
| --- | --- | --- |
| 1 | 1 | 축하~ |
| 2 | 1 | .. |
| 3 | 1 | .. |
| 4 | 1 | .. |
| 5 | 2 | .. |
| 6 | 2 | .. |
| … | … | … |

게시글 LEFT OUTER JOIN 댓글

| 게시글 번호(PK) | 제목 | 댓글 수 |
| --- | --- | --- |
| 1 | 축하~~~ | 5 |
| 2 | test | 2 |
| 3 | ~~ | 0 |
| 4 | ~~ | 0 |

## RIGHT OUTER JOIN

- 테이블 B에 테이블 A을 조인하여 데이터를 가져옴

⇒ B테이블이 메인테이블이 됨

- 잘 사용하지 않음

![image](https://github.com/user-attachments/assets/6b84ed0f-760c-4012-a762-e6227d0a0c27)


메인테이블이 TEACHER이기 때문에 TEACHER테이블이 온전하게 나온다.
