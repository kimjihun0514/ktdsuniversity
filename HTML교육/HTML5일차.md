## Pseudo Element(::)

- box 타입임

first-line : Block 엘리먼트에만 사용 가능(div, p 등)

first-letter : Block 엘리먼트에만 사용 가능

**after** : 엘리먼트 뒤에 이미지를 삽입 (가장 많이 사용)

![image](https://github.com/user-attachments/assets/858a2ba7-7900-42be-918b-ef7bbc40a106)

**before** : (가장 많이 사용)

marker : li 태그의 마커(순서, 도형 등)의 스타일을 변경

![image](https://github.com/user-attachments/assets/66556759-c247-4fdd-9adc-b1c12b6c2546)

**selection** : 드래그 한 글자의 배경색과 글자색을 변경

![image](https://github.com/user-attachments/assets/67bc65fe-65a1-4d7d-aade-bf0f9ac98d01)

## !important

우선 순위를 무시하고 스타일을 덮어 씀

→ 사용하지 말아야 할 프로퍼티 값

사용 하는 순간 모든 레이아웃 스타일이 깨질 수 있음

### 그럼 언제 사용?

명시도가 적용 된 Style을 별도의 스타일로 표현할 수 없을 때 사용

- CSS FrameWork(BootStrap, Tailwind)의 스타일을 덮어써야 할 때 등.

무작정 사용할 경우 명시도가 꼬여 스타일 추적이 아주 어렵게 됨

---

## Outline

Input, Select 등 사용자 입력 요소가 선택되어 활성화 된 경우(focus)

- 사용자에게 상태를 표현하기 위해 Outline이 표시됨
- Outline이 표시되면서 알맞게 맞춰놓은 레이아웃이 일그러질 수 있음
- 필요에 따라 Outline을 제거하거나 꾸밀 수 있음

![image](https://github.com/user-attachments/assets/e29a13d6-0656-495d-8f04-1080a079ca7e)

input : 여러가지 타입을 지정할 수 있음 (inline element, 싱글라인)

select : option과 함께 쓰이는 합성 태그

---

## Floating dom

Box Model을 배치하는 고전적인 방법

![image](https://github.com/user-attachments/assets/46dd5087-278a-4172-8a82-0bbcb42c5de9)

Float의 문제점

- 여러 개의 Div가 존재할 때, 특정 Div에 float 프로퍼티를 부여하면
- 브라우저의 정상정인 DOM 대열에서 분리

![image](https://github.com/user-attachments/assets/78cce9b1-2069-4639-8775-434897e03e48)

clear: both;

- float해 놓은 엘리먼트만 남겨두고 그 뒤에 나오는 것은 브라우저를 따라가라

---

## Position

엘리먼트를 배치하는 여러가지 방법(모든 엘리먼트에 기본적으로 부여)

![image](https://github.com/user-attachments/assets/1248dba9-3c98-45cc-81a5-68e6d1fb903f)

static : 기본 포지션

**relative** : relative가 적용 된 엘리먼트 내부에서 좌표계가 0부터 다시 시작(상대적 좌표가 생성) **absolute와 같이 사용✔**

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/f731536c-cc9f-4e38-b98f-d8e20e621749/image.png)

**fixed** : 스크롤을 움직이더라도 항상 같은 위치에 표시 (고정위치 메뉴, Floating menu, Floating Button등을 만들 때 사용)

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/23fee2da-2107-4887-9b68-4d546f66d29e/image.png)

**absolute** : 엘리먼트를 원하는 위치에 배치, Layered Popup, Dialog등을 표현할 때 주로 사용 → 스크롤의 영향을 받음 (Block, inline 둘 다 아님)

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/ba733c7d-b93b-4878-8a61-5c54bc3d8606/image.png)

- Document Flow 배치 좌표 기준

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/3f19f7ad-7db4-4091-9cbd-87fd31b91c8d/image.png)

**sticky** : 정상적인 Document flow로 자리잡고 있다가, 스크롤이 움직일 때, 지정한 위치에 도달한 경우 Fixed처럼 동작(Header, Scroll-Spy등에 주로 사용)

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/39986e50-bc2d-42a5-813f-ecaf952599ca/image.png)

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/ce375663-da26-4558-855c-12c4510bff8e/image.png)

---

## z-index

- position 프로퍼티가 적용 된 Box Element에만 적용할 수 있는 프로퍼티
- 엘리먼트 위에 다른 엘리먼트를 덮어 씌움
- 중요한 내용을 가장 상위에 표현할 때 사용

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/c7a2dce0-9f83-4e84-8d6d-4e0dbbff3a9d/image.png)

---

## Overflow

자식 엘리먼트의 크기가 부모 엘리먼트의 크기를 벗어날 때 표현방법을 정의하는 프로퍼티

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/e60c770b-76fe-484f-8e8e-26ba3099601f/image.png)

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/ea0c112f-5be1-474e-894d-ed2318cfd244/image.png)

hidden : 초과하는 자식 엘리먼트를 안보여줌

auto : 자동으로 스크롤바가 생김
