# jQuery란?

- Node(Element)를 간편하게 컨트롤 하기 위한 라이브러리
- HTML문서에서 엘리먼트를 찾아오기, Content 변경, 사용자의 Action에 반응, **애니메이션화(조금 불편함 → CSS3 생기고 나서부터 CSS로 작업. 웬만하면 사용하지 않음)**, 네트워크에서 새로운 컨텐츠 받아오기(Ajax) 를 편하게 만들어 줌
- jQuery로 처리할 수 있는 Element 기능
    1. CSS
    2. Event
    3. Animation
    4. Create, Modify, Delete등을 처리
- 비동기 통신을 간편하게 처리

### DOM?

사실 HTML 문서는 DOM(Document Object Model)의 집합

![image](https://github.com/user-attachments/assets/0b28433d-9f13-4ef4-890f-de7c129b3f52)

javascript로 DOM을 컨트롤 하려면 코드가 길고 복잡해진다.

그리고 브라우저마다 처리하는 방법이 다름

![image](https://github.com/user-attachments/assets/5ce961fc-21ed-48fc-9bb1-7a4c71607758)

---

jQuery는 브라우저 별로 적절한 처리를 수행함 → 크로스 브라우징

![image](https://github.com/user-attachments/assets/8a3ece16-d534-4d4c-94e5-84a2c5042a41)

---

## 엘리먼트를 스크립트로 가져오기

```html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>jQuery</title>
    <script type="text/javascript">
	    var h1 = document.getElementsByTagName("h1")[0];
	    console.log(h1);
    </script>
  </head>
  <body>
  </body>
</html>
```

- console.log에 undefined가 출력됨
- 그 이유는 HTML파일을 읽는 순서에 있음

브라우저가 HTML파일을 읽는 순서

1. HTML문서 로딩 
2. 스크립트 실행
3. 구조 분석
4. 속성 분석
5. 렌더링 → DOM 생성
6. 화면 노출

→ onload를 사용해 렌더링 이후에 출력하게 하면 됨

```html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>jQuery</title>
    <script type="text/javascript">
     window.onload = function () {
      console.log("Rendering 이후");
	    var h1 = document.getElementsByTagName("h1")[0];
	    console.log(h1);
	   };
	   
	   console.log("Rendering 이전");
	   var h1 = document.getElementsByTagName("h1")[0];
	   console.log(h1);
    </script>
  </head>
  <body>
  </body>
</html>
```

**`document.getElementsByTagName(”태그명”)[인덱스];`**

---

## 엘리먼트를 jQuery로 가져오기

jQuery를 사용하려면 jQuery 라이브러리를 로드해야 함

```jsx
<script type="text/javascript" src="./jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="./자바스크립트파일.js"></script>
```

자바스크립트파일

```jsx
jQuery를 이용해서 브라우저 렌더링이 끝났을 때 alert실행 -> 렌더링이 되었는지 확인
jQuery(document).ready(function () {
  alert("jQuery 렌더링 완료!");
});
위 코드를 줄여서 사용할 수 있음
$(document).ready(function () {
  alert("jQuery 렌더링 완료!");
});

$().ready(function () {
  alert("jQuery 렌더링 완료!");
});
```

### jQuery를 사용해 h1엘리먼트를 출력

```jsx
$().ready(function () {
  var h1 = $("h1");
  console.log(h1);
  console.log(h1.text());
});
```
- 첫 번째 로그에는 배열이 나옴
- 두 번째 로그에는 값이 나옴

### h1 엘리먼트의 내용을 변경

```jsx
$().ready(function () {
  var h1 = $("h1");
  h1.text("어디로 갈까요?");
  console.log(h1.text());
});
```

- Where do you want to go? 가 어디로 갈까요? 로 변함

**`text();`**에 파라미터가 없으면 getter, 파라미터가 있으면 setter

---

# 셀렉팅

### 여러 요소 변경해보기

- li 엘리먼트를 전부 “서울”로 변경
1. script 파일 연결하기

```html
<script type="text/javascript" src="./jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="./자바스크립트파일.js"></script>
```

1. jQuery연결

```jsx
$().ready(function () {
  alert("ready!");
});
```

1. li 엘리먼트를 전부 서울로 변경
    
    ```jsx
    $().ready(function () {
      var li = $("li");
      li.text("서울");
    });
    ```

---

# 하위 요소 셀렉팅

### Class가 promo인 엘리먼트를 변경

```jsx
$().ready(function () {
  var promo = $(".promo");
  promo.text("부산");
});
```

## 자식 요소 가져오기

```jsx
$().ready(function () {
  var child = $("#any li"); -> id가 any인 엘리먼트의 모든 li
  console.log(child.text());
});
```

## 직속 자식 요소만 가져오기

```jsx
$().ready(function () {
  var child = $("#any > li"); -> 부모 엘리먼트의 id가 any인 li
  console.log(child.text());
});
```

---

# 다중 요소 셀렉팅

```jsx
$().ready(function () {
  var many = $("#any, .promo"); -> id가 any인 엘리먼트와 class가 promo인 엘리먼트
  console.log(many.text());
});
```

---

# Pseudo Classes

first : 처음 엘리먼트

last : 끝 엘리먼트

odd : 홀수 번째 엘리먼트 

even : 짝수 번째 엘리먼트

---

## DOM Traversing

셀렉터나 수도클래스를 대체하기 위해 나옴

→ 속도가 느려서 대체가 필요했음

```jsx
모든 요소 찾기
$("#destinations li");

$("#destinations").find("li");
```

```jsx
첫 번째 요소 찾기
$("li:first");

$("#destinations").find("li").first();
```

```jsx
첫 번째 요소의 다음 요소 찾기
$("li").first();

$("#destinations").find("li").first().next();
```

```jsx
여러 개 붙일 수 있음
$("li").first();

$("#destinations").find("li").first().next().prev();
```

```jsx
원하는 요소 찾기
// 1
  var liList = $("#destinations").find("li");
  var findLi = $(liList[1]);
  console.log(findLi.text());
  // 2
  var wantLi = $("#destinations").find("li").eq(1);
  console.log(wantLi.text());
```

Traversing은 여러 개를 붙여서 사용할 수 있음

![image](https://github.com/user-attachments/assets/ab893b84-cf4c-4ce8-9df8-a0e7ab127b73)

### 역순으로 조회하기

부모를 알 수는 없을까?

- **`parent()`** 사용

→ 고른 엘리먼트의 부모 엘리먼트가 선택 됨

**`$(”li”).first().parent();`** → li의 부모 즉 ul이나 ol이 됨

잘 사용하지 않음

---

### 직속 자식 요소만 찾는 방법

**`find(”요소”)`**는 모든 요소를 가져옴

**`children(”요소”)`** → 직속 자식 요소만 가져옴

---

# DOM 다루기

가상 돔 : jQuery만 알고있는 가상의 돔

## 가상 돔 추가 방법

**`before()`** : ~ 이전에 요소 추가

**`after()`** : ~ 이후에 요소 추가

**`append()`** : 요소의 안쪽 맨 뒤에 요소 추가

**`prepend()`** : 요소의 안쪽 가장 첫 부분에 요소 추가

## 돔 삭제 방법

**`remove()`** : 브라우저에서 완전 삭제

---

# 이벤트와 함께 DOM 다루기

이벤트들을 jQuery로 어떻게 다룰까?

EX> 버튼을 클릭하면 ~ 해라

```jsx
$("button").on("click", function () {});
```

### 선택한 요소만 삭제하기

![image](https://github.com/user-attachments/assets/05b5f362-e8b6-4bb3-88ea-733e513e3b1e)

this를 사용하면 클릭 한 버튼만 사라짐

![image](https://github.com/user-attachments/assets/35085710-7358-4161-b81b-5e1fdbde6f4e)

클릭한 버튼에만 가격을 붙일 수 있음

```jsx
$().ready(function () {
  $(".package-green-button").on("click", function () {
    /*
    Javascript 에서 this의 의미는 함수를 실행시킨 주체
    Java의 this와 개념이 유사하다.
    */
    console.log(this);

    var package = $(this).closest(".package");
    var priceValue = package.data("price");
    var nameValue = package.data("name");

    var price = $(`<p>${nameValue} From $${priceValue}</p>`);
    price.on("click", function () {
      $(this).css({
        // 여기서의 this는 price
        "background-color": "#FF0",
      });
});
```

remove가 위에 있으면 this가 사라져서 price 아래에 있는 this를 찾지 못함

### 부모 찾기

```jsx
var h2 = $(".promo").parent().prev().prev();
h2.text("목적지");

// Rio -> h1엘리먼트
var h1 = $(".promo")
    .parent() // ul
    .parent() // body
    .find("h1");
h1.text("어디로 갈까요?");
```

**`closest()`** : 가장 가까운 부모를 찾아감

→ **`parents()`**는 구조가 쉽게 바뀌기 때문에 잘 사용하지 않는다.

### 가격을 다르게 설정

data변수 사용(html 5부터 사용 가능)

**`data-key=”value”`**

![image](https://github.com/user-attachments/assets/64f0d745-6add-48d0-a179-c0261747923d)

**`$(this).closest(”.package”);`**가 중복되면서 호출할 때마다 찾음 → 성능 저하

![image](https://github.com/user-attachments/assets/3effa4d1-50e0-44af-b8c7-70236eca0226)

변수로 할당해줘서 한번만 찾게 함
