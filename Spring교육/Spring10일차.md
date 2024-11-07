## 본인이 작성한 게시글만 수정 및 삭제 가능하게 만들기

```html
...생략...
<body>
	...생략...
	<div>
		...생략...
		<div class="btn-group">
			<c:if test="${sessionScope._LOGIN_USER_.email eq boardVO.email}">
				<div class="right-align">
					<a href="/board/modify/${boardVO.id}">수정</a>
					<a href="/board/delete/${boardVO.id}">삭제</a>
				</div>
			</c:if>
		</div>
	</div>
</body>
```

c:if 태그를 사용해 로그인 한 회원의 email과 해당 게시글의 email 과 같아야만 화면에 노출되게 변경

## Excel Download 추가

### pom.xml에 라이브러리 추가

```xml
		<!-- excel 파일을 만들어 주기 위한 Dependency -->
		<!-- 스프링이 관리하는 라이브러리가 아니기 때문에 버전 작성 -->
				<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi</artifactId>
		    <version>5.2.3</version>
		</dependency>
		<!-- excel 파일을 만들어 주기 위한 Dependency -->
		<!-- 스프링이 관리하는 라이브러리가 아니기 때문에 버전 작성 -->
				<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi-ooxml</artifactId>
		    <version>5.2.3</version>
		</dependency>
		<!-- excel 파일을 만들어 주기 위한 Dependency -->
		<!-- 스프링이 관리하는 라이브러리가 아니기 때문에 버전 작성 -->
				<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-scratchpad -->
		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi-scratchpad</artifactId>
		    <version>5.2.3</version>
		</dependency>
```

다른 라이브러리와는 다르게 버전을 작성해 주어야 함

### apache.poi로 할 수 있는 것

1. 엑셀파일 만들기
2. 파워포인트 파일을 이미지로 변환

---

# Logging

Trace > Debug > Info > Warn > Error

일반적으로 Debug와 Info를 많이 사용

![image](https://github.com/user-attachments/assets/1193bd46-b9fd-4136-a522-134129290793)

# Application 공통 예외처리

## 사용자가 보는 화면에 Exception을 그대로 노출하면 안되는 이유

1. Web Application의 신뢰도 하락
2. Web Application의 시스템 구조가 노출되어서 보안상의 취약점 증가
    1. Server의 종류
    2. 언어의 종류
    3. 패키지의 종류
    4. SQL 에러일 경우 SQL문 노출

---

### Spring은 Web Application에서 발생하는 Exception을 일괄 처리할 수 있음

- 에러 전용 화면 노출

---

## Exception별 처리하는 Controller 만들기

**`@ControllerAdvice`** 사용

→ 예외가 발생하면 해당 Annotation이 있는 클래스를 찾아감

→ 해당 Annotation이 있는 클래스가 없다면 WhiteLabel이나 예외가 홈페이지로 보내짐
