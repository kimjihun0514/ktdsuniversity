Pure Javascript(vanilla script)

---

## JavaScript

- 브라우저(Client)에서 동작하는 Client-Side Language
- 이벤트 기반의 동작 언어
    - EX> 사용자가 가입하기 버튼을 클릭할 때 OOO을 해라
- 웹 페이지에서는 없어서는 안될 언어
    - Javascript는 동적인 페이지를 만들 수 있도록 도와줌
- SPA(Single Page Application)을 만들 때에도 필수
- 현재는 Server-Side에서도 Javascript를 사용
    - MongoDB
    - Node.js

### Wed 2.0

문서가 아니라 하나의 플랫폼 → 웹에서 문서 작성 사진 저장 등

V8-engine → 크롬제작(빠른 대신에 메모리를 많이 먹음)

- 구글에서 만든 Javascript 개발 환경

---

### Javascript는 Compile 언어가 아니다?

Javascript는 Interpreter 언어

Compile 언어 : 타입이 있음(자바, C, C++ 등등) → 변수마다 Byte가 정해져 있음

Interpreter 언어 : 타입이 없음(파이썬, 자바스크립트 등등)

![image](https://github.com/user-attachments/assets/544e8a56-ddb0-4756-9a30-af9af9c36483)

---

### ECMA Script

ANSI SCRIPT

Javascript와 비슷함

---

ECMA Script 5가 현재까지 가장 많이 쓰임 (Client, Server 포함)

- 함수 지향 언어
- 다른 언어와는 다른 개념으로 혼란이 가중
- 객체지향개념도 지원하지만 그 형태가 단순하지 않음 → 사용 어려움

최근 ECMA Script 6가 발표되면서 새로운 언어로 재 탄생

- ECMA Script 5가 가지던 이미지를 버림(프로그래밍 언어가 아니라 Support tool로써의 의미)
- 객체지향개념을 지원
    - Class의 개념 도입
- 다른 언어와 유사한 개념들을 지원

현재 모든 브라우저에서 ECMA Script 6를 지원함

---

### Javascript를 사용할 수 있는 가장 간단한 방법

- 브라우저 요소 검색에서 콘솔에 들어감

---

### Javascript의 기본 문법

변수 : var 키워드 사용

```jsx
var 변수명;
```

변수의 할당 : =키워드 사용

```jsx
var 변수명 = 값;
```

### 데이터의 표현

다른 컴파일 언어와는 다르게 데이터 타입이 없음

단, 정수,실수,문자열,불린 등의 값은 표현은 가능(추론)

```jsx
var count = 10;
var age = 40;
var number = 60;
var pi = 3.14;
var floatingNumber = 50.13;
var str1 = "문자열입니다."
var str2 = '문자열입니다.'
var isTrue = true;
var isFalse = false;
```

정의는 되었지만 값이 할당되지 않았다면?(java = null)

```jsx
undefined
```

값이 비어있을 경우 사용할 수 있는 표현

→ undefined와 다르게 직접 할당해야 함

```jsx
null
var name = null;
```

null 이라는 데이터가 들어있다.

### 변수 값 변경

변수의 값은 언제든지 변경 가능(중복 정의도 가능)

```jsx
var count = 10;
count = 15;

var number = 660;
number = 177;
```

- `var` 키워드는 변수의 정의를 담당한다.
- `var` 키워드를 삭제한 후 값을 할당하면, 변수 값의 변경을 의미한다.
- `var` 키워드를 삭제하지 않고 변수를 할당하더라도 값의 재 할당이 이루어진다.

```jsx
var count = 10;
var count = 15;

var number = 660;
var number = 177;
```

**하지만 정의할 때만 `var`을 사용하는 것이 좋음**

- 연산에 의한 변경

```jsx
var count = 10;
count = 40 + 60;
```

## 변수의 사용

## 출력

화면에 출력하기

```jsx
alert("안녕하세요");
```

- **alert(…)** 은 화면에 경고창을 띄어주는 역할을 함
- **alert(…)** 에 변수를 사용하면 변수의 내용이 경고창으로 나타남

```jsx
var helloMessage = "안녕하세요";
alert(helloMessage);
```

---

- **console.log(…)** 는 개발자 도구에 변수의 값을 출력하는 역할을 함.
- 실제 개발 환경에서 Debugging 을 할 때, 주로 사용됨.

```jsx
var helloMessage = "안녕하세요";
console.log(helloMessage);
```

HTML 문서 내에 javascript 변수의 내용을 출력

---

## 연산

기본적으로 사칙연산을 지원

자바와 똑같음(연산 우선순위, 문자열 연산, 단항 연산자)

---

## 참조

변수는 다른 변수의 값으로 참조 가능

```jsx
var count = 5;
var myNumber = count;
console.log(myNumber); -> 5
```

연산자의 항으로 사용 가능

```jsx
var count = 5;
var myNumber = count + 5;
console.log(myNumber); -> 10
```

문자열 연산에도 가능

```jsx
var count = 5;
var myNumber = "당신은" + count + "번째 입니다.";
console.log(myNumber);
```

---

## 주석

자바와 같음(//, /* */)

---

## 반복문

### **for**

동일한 코드의 반복적인 사용이 필요할 때 사용

```jsx
for(var i = 0; i < 5; i++) {
 console.log(i + "번째 손님 응대 중입니다.");
}
```

**비교 연산자**

```jsx
var number1 = 10;
var number2 = 20;
크다
var result = number2 > number1; -> true
크거나 같다
result = number2 >= number1; -> true
작다
result = number1 < number2; -> true
작거나 같다
result = number1 <= number2; -> true
같다
result = number2 === number1; -> false
다르다
result = number2 != number1; -> true
```

javascript의 이퀄사인

| 변수 | 이퀄 사인 | 변수 | 결과 |
| --- | --- | --- | --- |
| “1” | == | 1 | true |
| “1” | === | 1 | false |

---

### **while**

잘 사용되지 않음 → while이 되는 동안에는 브라우저가 멈춤

---

### **if**

코드 진행 상황을 제어(자바와 문법이 같음)

---

## 배열

- 값의 집합
- []사용

```jsx
var scores = [100, 90, 100];
console.log(scores); -> [100, 90, 100]
```

**인덱스가 생김**

```jsx
console.log(scores[0]); -> 100
console.log(scores[1]); -> 90
console.log(scores[2]); -> 100
console.log(scores[3]); -> undefined
```

---

### **배열 요소 추가**

→ push()

```jsx
scores.push(50); -> 마지막 요소에 추가
console.log(scores); -> [100, 90, 100, 50]
```

---

### **배열 요소 삭제**

pop(), slice(), splice()

- pop() : 마지막 요소 삭제

```jsx
scores.pop(); -> 마지막 요소 삭제
console.log(scores); -> [100, 90, 100]
```

- slice(n) : n번째 인덱스부터 보겠다(자름)

```jsx
scores.slice(1); -> 1번 인덱스부터 확인 -> 0번 인덱스 삭제
console.log(scores); -> [90, 100]
```

- splice(n, i) : n번째 인덱스부터 i번째 인덱스 까지 지운다

```jsx
scores.splice(0, 0); -> 0번 인덱스 부터 0번 인덱스 까지 지운다
console.log(scores); -> [100]
```

---

### **for-in**

| INDEX | 0 | 1 | 2 | 3 | 4 | 5 |
| --- | --- | --- | --- | --- | --- | --- |
| VALUE | 10 | 20 | 30 | 40 | 50 | 60 |

```jsx
for (var i in scores) {
	console.log(scores[i]) -> 0, 1, 2, 3, 4, 5
}
```

---

## 함수

### 일반 함수

작업 단위를 정하고, 일부를 분리시켜 관리

function function_name(){ 작업 코드 … }

```jsx
function sayHello() {
	console.log("안녕?");
}
sayHello(); -> 안녕?
```

```jsx
function calcAndPrintNumbers(){
 var numberOne = 10;
 var numberTwo = 20;
 var result = numberOne + numberTwo;
 console.log(numberOne + "+" + numberTwo + "=" + result);
}
calcAndPrintNumber(); -> 10 + 20 = 30
```

---

### 리턴 함수

return 여부로 판단

- 일반 함수가 결과 값을 반환

```jsx
function getCalcNumbers(){
 var numberOne = 10;
 var numberTwo = 20;
 var result = numberOne + numberTwo;
 return result;
}
var calcResult = getCalcNumber()
console.log(calcResult); -> 30
```

---

### 매개변수(파라미터)가 있는 함수

함수에 필요한 데이터를 전달

**`파라미터에 var 작성하면 오류 발생!`**

```jsx
function add(numberOne, numberTwo) {
  return numberOne + numberTwo;
}

var addResult = add(1, 4);
console.log(addResult); -> 5

addResult = add(10, 20, 40, 50); // 파라미터의 개수만큼만 인식 나머지는 undefined
console.log(addResult); -> 30

addResult = add(true);
console.log(addResult); -> 1 // false = 0

addResult = add(10);
console.log(addResult); -> NaN(Not a Number) -> 숫자 + undefined
```

**NaN을 안나오게 하려면?**

```jsx
// 1. 조건문 작성
function add(numberOne, numberTwo) {
  if (numberOne === undefined) {
    numberOne = 0;
  }
  if (numberTwo === undefined) {
    numberOne = 0;
  }
  return numberOne + numberTwo;
}

// 2. 조건문 작성을 요약
function add(numberOne = 0, numberTwo = 0) {
  return numberOne + numberTwo;
}
```

arguments : 읽기 전용 배열

---

### 중첩 함수

자바스크립트에는 접근제어지시자가 없음

그럼 어떻게 하냐? → 중첩 함수 사용

---

함수 안에 함수가 포함되어있는 형태

```jsx
function gerCalcNumbers(numberOne, numberTwo) {
  function calcPlus () {
    return numberOne + numberTwo;
  }
  return calcPlus();
}

var result = getCalcNumbers(10, 50);
console.log(result); -> 60
```

---

### 함수를 리턴하는 함수 → Closure

함수 자체를 반환시킬 수 있음

중첩 함수와 비슷하지만 함수를 리턴하는 점이 다름

- private한 **`변수`**나 함수를 가릴 때 사용

![image](https://github.com/user-attachments/assets/f6f9e36d-df92-430b-9965-ace1871394e1)

---

### 콜백

처리 후 작업

- 함수에서 특정 작업이 완료되었을 때, 추가로 실행해야 하는 작업을 기술한 함수
- 함수가 **종료되는 시점이 불분명**할 때 **`콜백`**사용
    - EX> Ajax(비동기 통신)와 같은 Network작업
- **함수가 파라미터로 전달**

![image](https://github.com/user-attachments/assets/20cfec3d-7aba-41c6-98b9-cd58c1f29e8a)

![image](https://github.com/user-attachments/assets/8c031884-e96c-4699-bf27-4314ec233e22)

---

## 객체 리터럴 (상수 X)

Javascript에서 가장 기본적인 객체 생성 방법(Map)

프로퍼티, value로 구분

(:)을 기준으로 프로퍼티: Value로 맵처럼 사용 가능

![image](https://github.com/user-attachments/assets/97a09d38-0d7e-4501-b814-91c49bd1030e)


함수를 어딘가에 넣고싶다면 익명함수를 사용해야 함

**`for in 사용 가능`**

![image](https://github.com/user-attachments/assets/e3808b46-d63e-4236-8165-6e481e4c7df3)

---

## 변수의 영역

다른 언어에서 변수의 영역 : 중괄호 안에서 선언된다면 중괄호 안에서만 사용 가능

![image](https://github.com/user-attachments/assets/ffe7d55f-11d4-41ec-a8fa-637cd5057e74)

javascript에서 변수의 영역 : function기반의 영역을 사용

→ function 내부에서 선언 된 변수는 function의 모든 영역에서 사용 가능

- 호이스팅 : 끌어올리다

![image](https://github.com/user-attachments/assets/2ca35f14-03a6-4ec4-8a4b-11b6d7f132b3)

호이스팅이 된다면?

![image](https://github.com/user-attachments/assets/d07af0eb-d270-45d6-b861-ff887be8c079)

변수들이 최상단으로 올라감

---

## confirm()

사용자에게 예/아니오 선택창 보여주기

![image](https://github.com/user-attachments/assets/8bd6adeb-186b-4346-86ad-3618388f3b10)
