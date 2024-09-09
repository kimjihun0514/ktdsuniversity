## Background

Box Block의 배경색이나 배경이미지를 설정한다

- background-color: 배경색 지정
- background-image: 배경이미지 지정
- background-position: 배경이미지의 위치 지정
    - Sprite 이미지로 배경이미지를 표현할 수 있다.
        - 거대한 이미지 파일을 하나 만들어놓고 잘라 씀
        - Sprite만 로딩이 된다면 오류 없이 바로 출력
        - Box가 움직이면 보여지는 공간이 달라지기 때문에 Sprite 이미지가 움직이는 것
        - → 음수로 표현
- background-repeat: 배경이미지 반복여부 지정
- background-size: 배경이미지(Sprite)의 크기 지정
- background (Shothand)

## Size & Unit

엘리먼트에 사용할 수 있는 단위

| **단위 명** | **표현식** |
| --- | --- |
| pixels | px |
| points | pt |
| percentages | % |
| **root em** | **rem** |
| **em** | **em** |
| viewport height | vh |
| viewport width | vw |

pixels : 절대적인 크기

Points : 상대적인 크기 (사용자가 지정한 비율을 따라감)

---

| **절대 길이** | **뷰포트 길이** | **폰트 상대 길이** |
| --- | --- | --- |
| 유저 셋팅
무시 | 현재 뷰포트
길이 조정 | 유저 폰트 
크기 조정 |
|  |  |  |
| **px** | **vh** | **rem** |
| cm | **vw** | **em** |
| mm | vmin | ... |
| ... | vmax |  |
|  |  |  |
|  | **%** | **%** |

1rem : 사용자가 지정한 길이로 쓰겠다

0.5rem : 사용자가 지정한 길이의 절반

2rem : 사용자가 지정한 길이의 2배

**%는 부모(Container)의 영향을 받음**

**포지션의 값마다 영향을 받는 Container가 다름!**

em : 부모의 크기에서 조정 → 불편해서 잘 사용하지 않음

---

- position: fixed; 에서의 %는 Viewport(브라우저)를 기준으로 %단위를 결정

![image](https://github.com/user-attachments/assets/af593ba9-ac29-4d19-b270-cd7620d8d2a4)

---

- width | min-width | max-width & height | min-height | max-height

- Element에 min-width가 지정되면 Viewport 가 줄어들거나, 부모 엘리먼트의 크기가 줄어들 때, 최소 100px; 의 크기는 항상 유지된다.

---

- font-size를 %로 지정하거나 em, rem 등으로 지정할 경우,  브라우저의 기본 텍스트 크기를 기준으로 계산하게 된다.
    - Edge: 설정 -> 브라우저 디스플레이 -> 글꼴 -> 글꼴 사용자 지정
    - Chrome: 설정 -> 모양 -> 글꼴 맞춤설정

![image](https://github.com/user-attachments/assets/dff2f507-f49d-4f79-a69c-ad8d36906fef)

---

**rem → margin의 크기가 rem에 따라 달라짐**

---

max-width, min-width : width의 단위가 %일 때만 작동

최대 크기와 최소 크기를 지정

---

## Responsive web (반응형 웹)

다양한 크기의 Device에서 하나의 웹 페이지를 표현하는 방법

- width의 길이를 기준으로 만듬

---

## Hardware pixels vs. Software pixels

- 기기별 물리적 픽셀(Device Resolution)과 소프트웨어 픽셀(Viewport Size)을 정리
- 해상도가 매우 높은 화면의 크기는 작은 기기에서 1pixel을 그대로 표기 할 경우 이미지나 텍스트가 찌그러지는 현상을 방지하기 위해 제조사에서 설정해 놓은 기기별 소프트웨어 픽셀 단위

![image](https://github.com/user-attachments/assets/e5cb187f-e5e0-4c5d-9ca3-53d7981d3b8f)

https://yesviz.com/viewport/

## Media query

- @media (min-width: 40rem) { ... } è viewport width >= 40rem
    - 40rem: 640px;
    - 너비가 최소 640px 이상일 경우 지정할 스타일.
    - 모바일 기준으로 CSS를 구성한 후, Desktop이나 Laptop 기준의 CSS로 확장할 경우.
- @media (max-width: 40rem) { ... } è viewport width <= 40rem
    - 너비가 최대 640px 이할 경우 지정할 스타일.
    - Desktop이나 Laptop 기준으로 CSS를 구성한 후, 모바일 기준의 CSS로 확장할 경우.
- @media

https://developer.mozilla.org/ko/docs/Web/CSS/@media

https://www.w3schools.com/css/css3_mediaqueries.asp

---

### **Media query를 만들기 전 준비**

![image](https://github.com/user-attachments/assets/1bf0c3c6-d321-4fde-b674-cfa1303632c6)

## Form styling

input, select, button, label, textarea 등을 스타일링

---

### Attribute Selectors

**[attribute] Selector**

- Target 속성이 부여된 <a>태그의 스타일을 변경

![image](https://github.com/user-attachments/assets/1c57e0f6-9d39-4058-a037-bbd44ab04e89)

**[attribute="value"] Selector**

- Target 속성의 값이 “_blank” 인 <a> 태그의 스타일을 변경

![image](https://github.com/user-attachments/assets/467e9a90-0384-40bc-94c0-92c0650dc1de)

### **Descendant Selector (하위 셀렉터)**

- div 태그 안의 모든 p 태그

![image](https://github.com/user-attachments/assets/1dc9fbdf-7aa9-4e29-ba45-6a9c7edd6232)

### **Child Selector (>)**

- Div 태그 안의 첫 번째 자식 형제 p 태그

![image](https://github.com/user-attachments/assets/372b0c11-e4c5-4e93-a52f-e5ef7de3f03b)

### Adjacent Sibling Selector (+) (인접 형제 셀렉터)

- div 태그 밑(형제) p태그

![image](https://github.com/user-attachments/assets/367b964f-d305-4a2d-8c73-7cef4baaef05)

**Attribute Selector, Descendant Selector, Child Selector**를 가장 많이 씀

---

- **checkbox, select 스타일링**.
    - https://developer.mozilla.org/en-US/docs/Web/CSS/appearance
    - checkbox, select는 브라우저에서 기본제공하는 프로퍼티를 사용.
    - checbox와 select를 스타일링 하려면, **appearance를 수정**해야 한다.
        - [https://developer.mozilla.org/en-US/docs/Web/CSS/appearance#syntax](https://developer.mozilla.org/en-US/docs/Web/CSS/appearance)
