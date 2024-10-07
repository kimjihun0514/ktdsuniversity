# Spring MVC Pattern

## MVC란?

Model View Controller

| Model | 애플리케이션의 정보(데이터) |
| --- | --- |
| View | 사용자에게 제공 할 화면(**`Presentation Logic`**) |
| Controller | Model과 View 사이의 상호작용을 관리 |
|  | 기존의 Servlet의 역할을 수행 |

## MVC 패턴의 주 목적

**`Business Logic`**과 **`Presentation Logic`**을 분리하기 위함

- **`업무처리로직`**과 **`화면로직`**이 분리되면서 협업의 효율이 증가

MVC Pattern을 통해 요청과 응답에 대한 전반적인 처리를 지원

## MVC 패턴의 아키텍쳐

![image](https://github.com/user-attachments/assets/90ab7287-c323-4c2e-b934-c61d7b126d78)


## MVC의 동작방식

![image](https://github.com/user-attachments/assets/076514d6-5a85-42b3-9af7-c1708a568438)

1. dispatcher Servlet이 브라우저의 URL을 전송
2. dispatcher Servlet이 Handle과 Mapping을 이용해 URL과 매칭이 되는 컨트롤러를 검색함 → 찾는 URL이 없으면 404 Error 전송
3. dispatcher Servlet이 Handler Adapter에게 실행을 요청함
4. java의 리플렉션을 이용해 실행함
5. 결과 리턴
6. 리턴
7. dispatcher Servlet이 ViewResolver에게 보여줄 View를 찾아달라고 함 있으면 돌려줌
8. View에게 ViewResolver가 찾은 View를 JSP 파일을 생성함
9. 응답 생성
10. 응답 반환
11. 응답 반환

**Spring Bean** : 모든 클래스의 인스턴스를 Spring이 만들어 줌

# 게시판 만들기

## Mybatis

**`Mybatis`** : Spring Application에서 DB와 연동하는 가장 일반적인 방법

- 쿼리를 XML파일로 별도 관리
    - 하나의 DaoImpl 파일마다 쿼리 XML파일 하나가 생성
- 쿼리에 전달되는 파라미터를 이용해 Dynamic Query생성 가능

## 게시글 목록 조회하기

### 게시글 목록 조회 요청 했을 때, 패키지별 호출 구조

![image](https://github.com/user-attachments/assets/77f34382-b3c3-41bc-b0af-10dbdd3d868b)

### BOARD 테이블의 컬럼구조로 BoradVO 클래스 생성

1. 컬럼의 타입이 **`Number`**인 경우는 **`int`**
2. 그 외의 타입은 모두 **`String`**으로 함
3. 대문자인 컬럼명은 **`Camel Case`**로 변경 → Mybatis가 자동으로 변경하게 설정을 해야 함 (src/main/resources/mybatis에 mybatis-config.xml파일 생성)

```xml
<!-- config.xml -->
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <settings>
  	<!-- DB의 Column 을 자바변수의 이름으로 자동 Camel Case로 바꿔줌 -->
  	<setting name="mapUnderscoreToCamelCase" value="true"/>
  	<!-- DB에서의 Null 이 자바에서의 null 로 인식하게 만들어줌 -->
  	<setting name="jdbcTypeForNull" value="NULL"/>
  </settings>
</configuration>
```

1. 변수마다 **`Getter`**/**`Setter`**를 반드시 생성해야 함

```java
public class BoardVO {
    private int id;
    private String subject;
    private String content;
    private String email;
    private int viewCnt;
    private String crtDt;
    private String mdfyDt;
    private String fileName;
    private String originFileName;
    … Getter / Setter …
}
```

## Mapper 설정

Dao별 Query라는 Mapper라는 xml파일에 적용

→ Dao 하나당 Mapper가 생김

| **Alias** | **Mapped Type** |
| --- | --- |
| _byte | byte |
| _char (since 3.5.10) | char |
| _character (since 3.5.10) | char |
| **`_long`** | **`long`** |
| _short | short |
| **`_int`(int를 붙이면 Integer가 됨)** | **`int`** |
| **`_integer`** | **`int`** |
| _double | double |
| _float | float |
| _boolean | boolean |
| **`string(소문자)`** | **`String`** |
| byte | Byte |
| char (since 3.5.10) | Character |
| character (since 3.5.10) | Character |
| long | Long |
| short | Short |
| **`int`** | **`Integer`** |
| integer | Integer |
| double | Double |
| float | Float |
| boolean | Boolean |
| date | Date |
| decimal | BigDecimal |
| bigdecimal | BigDecimal |
| biginteger | BigInteger |
| object | Object |
| date[] | Date[] |
| decimal[] | BigDecimal[] |
| bigdecimal[] | BigDecimal[] |
| biginteger[] | BigInteger[] |
| object[] | Object[] |
| **`map(소문자)`** | **`Map`** |
| hashmap | HashMap |
| **`list(소문자)`** | **`List`** |
| arraylist | ArrayList |
| collection | Collection |
| iterator | Iterator |

## 폴더 경로를 똑같이 만들어야 하는 이유

target 폴더는 경로가 같은 것들을 모아주기 때문에

![image](https://github.com/user-attachments/assets/224b4814-9ac7-4ca7-a712-e7ce311bc26c)

