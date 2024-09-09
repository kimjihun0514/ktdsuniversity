## Display & Visibility

### Block Display Tag

- 엘리먼트가 새 줄에서 시작해서 전체 너비를 차지함

---

### Inline Display Tag

- 엘리먼트가 컨텐츠 영역만큼만 차지
- 단, width와 height는 적용할 수 없음
- 컨텐츠가 <br/>등으로 밀려나면서 새 줄의 처음부터 시작

---

### Inline-block Display Tag

- 엘리먼트가 컨텐츠의 영역만큼 차지함.
- **width와 height 적용이 가능함.**
- 컨텐츠가 <br/> 등으로 밀려나면 블록 영역에서 개행됨.

- display: inline-block;
- vertical-align: top;

### Inline Element 와 Block Element의 차이점

Block Element는 한 줄을 다 차지함

Inline Element는 한 줄에 표현할 수 있는 만큼 다 표현함

Inline Element로 바꾸는 법 → display: inline-block;

Block Element로 바꾸는 법 → display: block;

## Text decoration

- color - 텍스트의 색상을 변경
    - color: red; 또는 color: rgb(255, 0, 0); 또는 color: #FF0000;
- text-decoration - 텍스트에 줄을 그음
    - text-decoration: underline;
- font-weight - 텍스트의 굵기를 조절
    - font-weight: bold; 또는 font-weight: 700;
- font-size - 텍스트의 크기를 변경
    - font-size: 12px;
- font-size를 %로 지정하거나 em, rem 등으로 지정할 경우,  브라우저의 기본 텍스트 크기를 기준으로 계산하게 된다.
    - Edge: 설정 -> 브라우저 디스플레이 -> 글꼴 -> 글꼴 사용자 지정
    - Chrome: 설정 -> 모양 -> 글꼴 맞춤설정

## Box align

### Box Model을 정렬시키는 CSS Property

![image](https://github.com/user-attachments/assets/c498c7e8-f147-42d8-a6d7-4fea39d61d0c)

**div 안에 있는 div는 세로정렬을 할 수 없음**

**→ flex, grid를 사용해야 함**

Vertical align : 정렬 기준을 맞춤

---

### **margin으로 정렬**

![image](https://github.com/user-attachments/assets/875ba5e8-f040-436b-9491-eec5c3bec2b5)

원하는 엘리먼트만 정렬시키고 싶을 때 사용 가능(좀 더 편한 듯)

## Pseudo class(:)

### 주로 많이 사용하는 pseudo class

active : 누르고만 있을 때 어떻게 할 것인가

checked : 

disabled : 

empty : 

focus : 

hover : 마우스를 올렸을 때 어떻게 할 것인가

invalid : 

last-child : 마지막 요소에게 스타일을 다르게 주고 싶을 때 사용

link : 방문하지 않은 링크 a태그 전용

not : 

nth-child : 목록을 만들 때 사용 (단위로 바꿈)

read-only : 

required : 

valid : 

visited : 방문한 링크 a태그 전용
