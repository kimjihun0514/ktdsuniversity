# Event가 적용되는 대상

event는 style과 다르게 줄 수 있는 대상이 한정적이다.

Event 제어의 대상이 되는 객체는 $().ready();가 호출되기 전에 객체화 된 Element들

jQuery를 통해 동적으로 추가 된 Element들에 대해서는 Event를 할당할 수 없음

→ **`var price = $(’<p>From $399.99</p>’);`**

![image](https://github.com/user-attachments/assets/43f9be5d-4139-4e2f-8c9f-3495bd2d87c5)

아무일도 일어나지 않음

![image](https://github.com/user-attachments/assets/43760efe-48ca-4d8a-a29b-067206e51018)

만들자마자 이벤트를 주는 게 가장 심플함

![image](https://github.com/user-attachments/assets/a527d019-2330-4961-8424-f005a2fe1fca)

배경색을 노란색으로 변경

## Mouse Event

![image](https://github.com/user-attachments/assets/bd549287-51ec-421c-ad63-99e97483848e)

**`click`** : 클릭했을 때

**`dblclick`** : 더블 클릭 했을 때

**`focusin`** : 

**`focusout`** : 

**`mousedown`** : 마우스를 누르고 있을 때

**`mouseup`** : 마우스를 눌렀다 뗐을 때

**`mousemove`** : 마우스를 움직일 때

**`mouseout`** : 마우스를 올렸다가 나갈 때

**`mouseover`** : 마우스를 올렸을 때(불필요한 호출을 반복)

**`mouseenter`** : 마우스를 올렸을 때

**`mouseleave`** : 마우스를 올렸다가 내렸을 때

![image](https://github.com/user-attachments/assets/43c340c0-5252-4c19-8285-130fdb6abed2)

대상이 같다면 on함수를 여러번 사용할 수 있음

![image](https://github.com/user-attachments/assets/d647ade3-b055-4831-8c0c-33bc478fd1f5)

## Keyboard Event

회원가입, 자소서 글자 수 세기 등에 사용

![image](https://github.com/user-attachments/assets/12aeba3f-7fb5-4050-92a0-746525e1e7eb)

**`keyup`**만 사용

**`keyup`** : 키보드의 모든 행동을 트래킹함

### 입력한 값 만큼 Total Price에 곱해서 할당하기

![image](https://github.com/user-attachments/assets/d7da0004-ca59-48a4-954c-cabea7519ef0)

더하기(+)를 하면 문자로 인식함 → var의 기본 값이 String이기 때문

⇒ 문자를 실수로 바꿔주는 것이 필요

![image](https://github.com/user-attachments/assets/9c63f19f-9e76-445e-a0b0-4ee81ae7dbe8)

백스페이스를 눌렀을 때 값이 바뀌면 좋겠음

![image](https://github.com/user-attachments/assets/df9847e9-2fe1-4dbc-b348-c127a313456e)

최종

![image](https://github.com/user-attachments/assets/af149b52-8307-4e88-857c-171c34d3ab8e)

# **AJAX – API – Open API – RESTful API**

## AJAX(**Asynchronous** **Javascript And XML**)

**비동기 통신(AJAX)** : 언제 실행되고 언제 끝날지 모름, 하나의 실행에 여러 개의 명령을 함(`멀티스레드 프로그래밍`)

**동기 통신(JAVA)** : 언제 동작이 될 지 암, 하나의 실행에 하나의 명령만 함(`싱글스레드 프로그래밍`)

```html
     HTTP + Secure

 Server ———————— Client

(Spring)        (Browser)

 |<———————1TCP————————>|
 |<———2Requestfeed————>|
 |<————3Response——————>|
 |<—————4TCP해제———————>|
```

![image](https://github.com/user-attachments/assets/02fc2bb7-58e1-43a3-9991-a522b54908a2)

**SHORT CUT 표현식**

![image](https://github.com/user-attachments/assets/2ce22cbf-67f3-4647-a045-cec9c33cf239)
