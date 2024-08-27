### SQL 문법 2

SELECT

⇒ Row 조회

INSERT

⇒ Row 추가

UPDATE

⇒ Row 수정

DELETE (잘 사용되지 않음)

⇒ Row 삭제

## 데이터 삽입

INSERT INTO - VALUES

```sql
INSERT INTO [TABLE](
								[COLUMN],
								[COLUMN],
								[...]
) VALUES (
			 [DATA],
			 [DATA],
			 [...]
)
;
```

데이터를 삽입할 때, 컬럼의 타입과 순서를 맞춰서 넣어야 함.

## 테이블 복사

SELECT - INTO - FROM

```sql
SELECT [COLUMN NAME],  		
				[COLUMN NAME],		
				[...]
INTO [NEW TABLE NAME]
FROM [ORIGINAL TABLE NAME]
;
```

ORIGINAL TABLE NAME 에서 NEW TABLE NAME 으로 데이터를 전부 복사함

## 데이터 수정

UPDATE - SET - WHERE

```sql
UPDATE [TABLE NAME]
SET [CULUMN NAME] = [VALUE]
WHERE [CONDITIONS]
;
```

- WHERE절을 입력하지 않으면 모든 데이터가 수정될 수 있다.
- Constraint(관계형성)가 있는 컬럼을 수정할 때는 때에 따라 변경이 되지 않을 수 있다.

## 데이터 삭제

DELETE - FROM - WHERE

```sql
DELETE 
FROM [TABLE NAME]
WHERE [CONDITIONS]
;
```

- WHERE절을 입력하지 않으면 모든 데이터가 삭제될 수 있다.
- Constraint(관계형성)가 있는 컬럼을 삭제할 때는 때에 따라 삭제가 되지 않을 수 있다.
- 자식키(FK)가 있는 부모키(PK)를 지울 수 없다!

### 여러 명이 동시에 데이터를 삽입하려 한다면?

PK가 중복이 될 가능성이 매우 높다.(동시성 문제)

⇒ PK가 자동으로 1씩 늘어나게 해주자! ⇒ 똑같은 문제가 생김(0.0001초 차이로 인해)

오라클에서 이 문제를 해결하기 위해 오라클에서 번호를 나눠줌(Sequence)

## Sequence

일련번호를 만들어 줌

주로 PK를 생성할 때 사용

시퀀스명.NEXTVAL을 통해 다음 일련번호 값을 조회할 수 있음

시퀀스명.CURRVAL을 통해 현재 일련번호 값을 조회할 수 있음

```sql
INSERT INTO MV_INFO
 (MV_ID
, MV_TTL
, OPN_DT
, SCRNG_TM
, AGE_LMT_ID
, PSTR
, PLT)
VALUES 
 ( (SELECT MAX(MV_ID) + 1 FROM MV_INFO)
, '에일리언:로물루스'
, TO_DATE('2024-08-14', 'YYYY-MM-DD')
, 119
, '00004'
, 'https://cf.lottecinema.co.kr//Media/MovieFile/MovieImg/202408/21028_103_1.jpg'
, '폐쇄된 공간에서 펼쳐지는 압도적인 공포를 느껴라!')
;
```

![image](https://github.com/user-attachments/assets/95662fa9-37bd-4400-9e2e-cfd3047260f8)


Sequence Name : 시퀀스 명

Value : 값

Min Value : 최솟값

Max Value : 최댓값

Increment : 호출할 때 마다 늘어나는 값

Cache : 미리 뽑아 놓는 값의 수

Cycle : 999999를 다 돌고나서 다음 번호를 어떻게 할 것인지

눌렀을 때 ⇒ Max Value의 연.월.일을 붙여서 다시 1번부터 돈다.

안눌렀을 때 ⇒ 번호 발급이 안됨.

Ordered : 여러 세션에서 시쿼스를 요청해도 항상 순차적인 번호가 할당됨.(성능 저하가 발생)

PK의 타입이 CHAR 라면 Cycle 체크 X

PK의 타입이 VARCHAR2 라면 Cycle 체크
