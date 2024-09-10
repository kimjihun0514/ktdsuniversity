## radio group

- name 을 이용해 같은 name끼리 묶여서 한 개만 선택 가능하게 됨
- radio에는 label을 같이 사용할 수 있음
    - radio에 id를 붙여주고 라벨에 for를 사용해 라벨을 선택해도 선택이 가능하게 됨

![image](https://github.com/user-attachments/assets/727539c3-81a6-4fa3-ba9f-073aef3d788a)

## Flex box

Display container system

- Flex(Flexible Box, FlexBox)
- 아이템들을 **한 방향으로 배치시킬 때 유용**
- Flex는 Container와 item에 대한 속성을 부여함으로써 아이템을 배치
- **자동 띄어쓰기가 삭제됨**

![image](https://github.com/user-attachments/assets/5f86da85-aa2d-49e3-afb7-c45bf1cff019)

### 배치 방향 설정

![image](https://github.com/user-attachments/assets/05aedb7a-c6d6-4f82-9363-e9f931ee4413)

![image](https://github.com/user-attachments/assets/b0ec4608-ab63-488b-820f-a041d82e7e60)


### 줄 넘김 처리 설정

![image](https://github.com/user-attachments/assets/4e0f7ff3-8028-4df0-a90f-93992bcae7a1)

### 교차 축 정렬

align-items

### 메인 축 정렬

justify-content

### 메인, 교차 축 정렬

justify-content, align-items

- 정 가운데 정렬

![image](https://github.com/user-attachments/assets/c990e2cd-b324-4e6a-89db-7f671649406c)

### 여러 행 정렬

align-content

- flex-wrap: wrap;이 설정 된 상태에서 아이템들의 행이 2줄 이상 되었을 때 교차 축 방향 정렬을 결정하는 속성

## Flex item

`Flex-Box의 자식만 flex-item이 됨`

![image](https://github.com/user-attachments/assets/f01acd38-0c0e-4253-b610-7d5b08269590)

ul은 flex-item, li는 아님

Section 1은 flex-item, Section 2는 아님

- flex에서는 width와 height를 지정할 수 없음

### flex-basis

아이템의 크기를 조절하는 속성

- flex-direction: row;일 때는 메인 축이 가로(너비)
- flex-direction: column;일 때는 메인 축이 세로(높이)
- 고정되는 값이 아님

---

**flex-basis: auto;(기본 값)**

→ 컨텐츠의 크기에 따라 자동으로 조절

---

**flex-basis: 300px;**

→ 아이템의 기본 크기를 300px로 맞춤, 300px가 넘어갈 경우 원래 크기로 조절

![image](https://github.com/user-attachments/assets/7ab3e419-6b68-440a-97e5-3106a1c954e2)

---

**flex-basis: 50%;**

→ 아이템의 기본 크기를 윈도우 사이즈의 50%로 맞춤, 아이템이 나열 된 크기가 100%가 넘어갈 경우 flex-container의 flex-wrap의 설정 여부에 따라 개행처리 됨

![image](https://github.com/user-attachments/assets/4a1cd878-7e15-441a-a62f-e3637d0a5511)

---

### flex-grow

**flex-grow: 0;(기본 값)**

- basis의 값보다 커질 수 있는지
- flex-grow의 값이 0보다 클 경우, flex container의 빈 공간을 모두 메우게 됨

![image](https://github.com/user-attachments/assets/bb47b4c5-fa7a-450c-9e12-7ebc4fecb87a)

flex-grow: 자기 값 / 다 더한 값

---

### flex-shrink

**flex-shrink: 1;(기본 값)**

- flex-grow와 쌍을 이루는 속성
- flex-basis보다 작아질 수 있는지 결정하는 속성
- flex-shrink의 값이 0보다 클 경우 flex-basis보다 작아질 수 있다.
    - flex-shrink: 0; → flex-basis보다 안 작아짐

---

## Grid

Flex보다 복잡한 레이아웃을 간편하게 만들 수 있음

![image](https://github.com/user-attachments/assets/2cc3843e-b61f-4825-a863-5e00b88ab44e)

**`그리드 하나만 작성하면 아무 일도 일어나지 않음`**

![image](https://github.com/user-attachments/assets/030ba87a-2882-40e9-ba8a-51de9c4edae2)

grid-template-columns, grid-template-rows를 사용해야 함

![image](https://github.com/user-attachments/assets/1987ca1e-89b7-474c-89ad-6c902f9037e5)

### Grid의 형태 정의(fraction) - 비율

**반응형으로 만들고 싶은데 px, rem을 사용하면 줄어들지 않음**

**→ grid에서는 fr이라는 단위를 사용(분수)**

![image](https://github.com/user-attachments/assets/92f7ba3b-e98c-4bd6-a61c-5bb63451ef5d)

### Grid의 형태 정의(pixel + fraction)

pixel을 같이 쓸 수 있음

![image](https://github.com/user-attachments/assets/51bfde5d-a1cb-4ead-bfa0-60879475089b)

### Grid의 형태 정의 (minmax) - 최소/최대 크기 설정

minmax(최솟 값, 최댓 값)함수를 사용할 수 있음

![image](https://github.com/user-attachments/assets/6d8f045e-e532-4b03-bbee-a7e2ba949b60)

### 간격 만들기

row-gap과 column-gap을 사용해 간격을 나눌 수 있음

or

gap: row column;

![image](https://github.com/user-attachments/assets/5aab8c39-5831-43dc-a66d-efccc3c049df)

## Grid item

### 아이템의 영역 지정

- Grid item의 영역

![image](https://github.com/user-attachments/assets/7837c0cf-34b9-421f-9b9b-5fb1e95a6c98)

grid-column-start, grid-column-end, grid-row-start, grid-row-end

**너무 길어서 줄여서 사용함**

![image](https://github.com/user-attachments/assets/51f115b6-1355-4069-a136-1b78720a5b89)

grid-column: 2/4; 2~4까지 합쳐라

grid-row: 1/2; 1~2까지 합쳐라

---

합치고 나면 원래 있던 아이템이 밀려남

![image](https://github.com/user-attachments/assets/56629fc6-c0ed-4ee1-a23a-fa2376980ce8)

→ 전체 공간은 9개로 했지만 사용하는 것은 4개밖에 없기 때문

→ 나머지 공간은 삭제
