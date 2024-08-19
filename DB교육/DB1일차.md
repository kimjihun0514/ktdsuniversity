# DBMS
- 대량의 데이터를 처리하기 위한 시스템
- DBMS는 다수의 데이터 베이스로 구성
- 다수의 데이터가 서로 관계를 맺고있어 관계형 데이터 베이스라고 부름
![image](https://github.com/user-attachments/assets/4cc945a2-f6c7-4bc7-aa9c-1089dfcfe89c)

# Database
- 대량의 데이터를 처리하기 위한 공간
- 하나의 Database는 다수의 Table로 구성
![image](https://github.com/user-attachments/assets/a51b5e81-a27b-4eb7-9c1c-06e2980ab4e2)

# Table
- 실제 데이터가 보관되는 ```정형화된 구조의 저장소```
- 여러 정보들이 "정형화"된 타입으로 저장
  - 컬럼과 데이터 타입 등으로 정형화 되어있음
- 여러 테이블은 관련된 정보로 채워짐
  - 상품, 회원, 장바구니 등등
- 하나의 테이블은 특성을 표기할 수 있는 이름이 주어짐
![image](https://github.com/user-attachments/assets/f37e4ff2-2756-47ad-b0f6-fb9a1a6f2d3b)

- 컬럼 이외에도 다양한 항목이 존재
![image](https://github.com/user-attachments/assets/bbb046ea-305a-4436-8360-de7dd03ec48c)

# Column
- 하나의 테이블은 하나 이상의 컬럼으로 구성(적어도 한개 이상)
- 데이터를 담을 수 있는 하나의 "공간"
- 각 컬럼은 데이터 타입을 가지고 있음

# Rows
- 각 행은 여러개의 컬럼으로 구성
- 테이블의 데이터는 하나의 "행"으로 표현

# Keys
### Primary key(PK)
- 하나의 테이블에서 절대 중복되지 않는 값
- 하나의 Row를 대표하는 값
  - EX> 회원 ID, 이메일 주소 등
- 테이블은 하나 이상의 Primary key를 반드시 가져야 함
### Foreign key(FK)
- Primary key를 참조하는 키
- 자신의 테이블 또는 다른 테이블의 Primary key로 관계를 형성할 때 사용
  - 하나의 PK와 연계되어있는 다양한 정보를 FK로 지정
  - EX> 특정 회원의 주문목록, 특정 회원의 배송지 등
### Unique key
- 하나의 테이블에서 절대 중복되지 않는 값
  - PK와는 다른 성격
  - PK는 Row(데이터)를 대표하는 값
  - Unique key는 한 테이블에서 중복된 데이터를 생성할 수 없음
  - EX> 회원의 중복 불가능한 닉네임

# SQL(Structured Query Language)
- 데이터 베이스가 관리하는 데이터를 조작하는 언어
- 데이터 베이스, 테이블, 컬럼 등을 생성(Create), 수정(Alter), 삭제(Drop)할 수 있음
- 테이블 내의 Row를 추가(C), 조회(R), 수정(U), 삭제(D)할 수 있음
- 위 항목들을 관리할 수 있도록 구조화된 언어체계를 가지고 있음
