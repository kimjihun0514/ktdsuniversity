## Cascading & Specificity

Cascading : 같은 태그(엘리먼트)에 여러 개의 스타일 규칙을 정의할 수 있다.

Specificity : 스타일 충돌이 일어날 경우 명시도에 따라 처리

1. Inline Style
2. #ID Selectors
3. .class, :pseudo-class, [attribute]Selector(이거만 씀)
4. <tag>, ::pseudo-element selectors

## Inheritance

부모 태그에 정의된 스타일은 자식 태그에도 동일하게 적용

## Box model

기본적으로 HTML 요소를 감싸는 상자(모든 Tag는 Box)

여백(Margin), 테두리(Border), 패딩(Padding) 및 실제 콘텐츠로 구성

Border-Padding-Content가 Box의 범위

- Margin은 엘리먼트와 상관없이 바깥 여백으로 설정

- 박스모델은 상속이 불가능함.

Border : 주로 세션을 나눌 때 사용됨

Padding : Content와 Border 사이의 여백을 만들어 줌 → Border와 Content의 사이를 나눌 때 사용

Margin : 박스 외부 공간에 대한 여백 사이즈에 영향을 주지 않음

### Content Box (Content의 너비에 Padding, Border의 크기를 빼는 Box)

**기본 값**

- Content의 너비가 320px (width: 320px)
- Padding 10px (padding: 10px)
- Border 5px (border-width: 5px)
- 실제 Box의 사이즈는 350px이 된다.
    - (Padding, Border, Margin 값에 따라 크기가 유동적으로 변한다)

box-sizing: content-box;

### Border Box (Content 의 너비에 Padding,  Border의 크기를 빼는 Box)

- **가장 흔히 사용된다. → Universal Selector로 지정**
- Content의 너비가 320px (width: 320px)
- Padding 10px (padding: 10px)
- Border 5px (border-width: 5px)
- 실제 Box의 사이즈는 320px이 된다.
    - (Margin 값에 따라 크기가 유동적으로 변한다)

box-sizing: border-box;

height를 주지 않으면 content의 크기만큼 자동으로 늘어남

→ 필요한 상황이 아니면 잘 작성하지 않음

## Margin collapsing

Margin을 가진 엘리먼트가 나란히 있을 때, 중첩된 Margin은 제거됨

- Margin이 더 큰 쪽으로 덮어 씌움

## Width & Height

- Inline Element(13번 챕터)를 제외한 Block Element, Inline-block Element의 폭(Width)과 높이(height)를 지정할 수 있음
- **폭과 너비는 항상 부모 Element의 영역 내에서만 할당**

## Display & Visibility

### Block Display Tag

- 엘리먼트가 새 줄에서 시작해서 전체 너비를 차지함

---

### Inline Display Tag

- 엘리먼트가 컨텐츠 영역만큼만 차지
- 단, width와 height는 적용할 수 없음
- 컨텐츠가 <br/>등으로 밀려나면서 새 줄의 처음부터 시작

### Inline-block Display Tag

- 엘리먼트가 컨텐츠의 영역만큼 차지함.
- **width와 height 적용이 가능함.**
- 컨텐츠가 <br/> 등으로 밀려나면 블록 영역에서 개행됨.
