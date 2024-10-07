# Spring이란?

**`Java 개발을 간소화`** 하기 위해 발명이 됨

- POJO를 이용한 가볍고 비침투적인 개발
- DI와 인터페이스 지향을 통한 느슨한 결합도
- 

# Spring Framework

## Spring Framework란?

**`Framework(Frame + Work)`** : 틀 내부에서 일 하는 것 틀을 벗어나면 안됨

**`Spring Framework`** : 제공해 주는 틀(도구)에서 개발을 해라

엔터프라이즈 애플리케이션 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임워크

---

### 애플리케이션 프레임워크

특정 계층이나 기술, 업무 분야에 국한되지 않고 애플리케이션 전 영역을 포괄하는 범용적인 프레임워크

---

### 경량급 프레임워크

Spring이 제공하는 다양한 기능들을 Module로 쪼개어 놓은 것

필요한 Module만 Load해 개발할 수 있음으로 단순한 웹 컨테이너에서도 엔터프라이즈의 고급 기술을 대부분 사용 가능

---

### 엔터프라이즈 애플리케이션 개발에 용이

개발자는 설정에 관여하지 않고 Biz Logic 개발에 전념할 수 있도록 해줌

→ 설정의 작업을 Spring Framework에서 대부분 처리

---

### 오픈소스 → 소스를 공개함

Open Source의 장점(빠른 지원, 빠른 Bug Fix 등)을 충분히 가져가며 단점(보안상 취약점)과 한계를 잘 극복함

---

## Spring Framework의 특징

### Bean Container

Bean : java의 인스턴스

Spring이 객체의 Life-cycle을 직접 관리

→ Spring에 필요한 구성요소를 사용자에게 제공(DataAccessHelper, Servlet와 같은 작업을 대신 해줌)

Application에 필요한 클래스들을 Spring이 인스턴스로 생성하여 컨테이너에 보관

→ 만들어진 인스턴스(Bean)을 컨테이너에 보관

인스턴스가 필요할 때마다 컨테이너에서 참조

---

### Dependency Injection(DI) 지원

설정 파일이나 Annotation을 통해 객체 간의 의존 관계를 설정할 수 있음

의존 객체는 Bean Container에서 참조

→ Bean Container에 있는 변수를 직접 할당해줌

---

### Aspect Oriented Programming(AOP) 지원

Application 전반에 필요로 하는 **`공통기능`**들을 핵심 모듈에서 분리

**`실행시점`**에 따라 공통 모듈이 실행될 수 있도록 지원

> **`공통기능`** : 트랜잭션 처리, 로깅, 보안 등
> 

> **`실행시점`** : 모듈 실행 전, 실행 후, Exception 발생시 등
> 

---

### Plain Old Java Object (POJO) 지원

POJO : 순수 Java Object

Spring은 순수 Java 객체를 지원

프레임워크를 사용하기 위한 특별한 클래스나 인터페이스를 상속받지 않아도 됨

---

### 트랜잭션 처리를 위한 일관된 방법을 지원

트랜잭션에 대한 처리는 Spring이 직접 관리해 개발자가 관여 할 필요가 없다.

---

### Persistence와 관련 된 다양한 API 지원

Persistence : 영속성 = 데이터를 관리하는 방법

MyBatis, Hibernate 등 데이터베이스 처리를 위한 ORM(Object Relational Mapping)프레임워크들과의 연동 지원

---

### Library Dependency 지원

Spring은 Maven, Gradle 등의 빌드 툴을 이용해 필요한 Library를 자동 관리

→ 우리가 연결하려 하는 라이브러리를 자동으로 연결 및 관리해줌

---

### 관습에 따른 설정 지원

Spring에서 개발자가 일일이 설정해야 했던 반복되는 내용들을 자동 설정

→ Spring Boot에서 자동으로 설정해줌

→ 모든 것을 자동 설정을 해주니까 모든 것의 자동 설정을 준비해서 쓸 데 없는 설정까지 함

---

### Dependency 버전 충돌 문제 감소

Spring에서 Library Dependency 적용 시 Version에 따라 충돌/오작동 되던 문제를 해결

→ Spring Boot 버전과 알맞은 Library 버전을 찾아 적용해줌

---

## Spring IoC/DI

Java의 Class 상속 / Interface를 이용한 추상화를 기반으로 하는 개발 방법

**Spring은 DI와 Ioc를 강력하게 지원하는 프레임워크**

**`Ioc`** : Inversion of Control

- 프로그램을 제어하는 패턴 중 하나
- DI는 IoC패턴의 구현체 중 하나
- DI에 따라 프로그램의 흐름이 완전히 변경

**`DI`** : Dependency Injection

- 프로그램에 필요한 객체들을 Bean Container에 두고 필요할 때마다 사용

Spring은 DI를 기준으로 많은 프레임워크 모듈이 만들어짐

---

## Maven

Spring을 사용하기 위해 **`Maven Build`**가 필요

![image](https://github.com/user-attachments/assets/50d3a86c-609e-4d70-813b-bcbdb46e3985)


### Maven

1. Spring의 의존 라이브러리를 간편하게 추가할 수 있도록 의존성 주입을 제공
2. 그 외 오픈소스 라이브러리도 Maven Repository에 업로드 함으로 대부분의 라이브러리를 자동으로 추가 가능함
3. 프로젝트의 구조를 자동으로 구성
4. Build를 통해 배포를 위한 파일 생성

---

# Hello, Spring Boot

## Spring Boot

### Localhost

- 현재 사용중인 PC의 주소를 Localhost라고 함
- 컴퓨터의 IP와 동일

### Port

- 현재 사용중인 PC와 프로그램 또는 외부 PC와 통신할 수 있는 번호
- HTTP의 기본 포트는 80
    - 개발 단계에서는 8080을 많이 사용

![image](https://github.com/user-attachments/assets/27d5e697-10ff-4310-965f-9e445a2bf8a7)

### HTTP(Hyper Text Transfer Protocol)

- WWW(World Wide Web)상에서 정보를 주고받을 수 있는 프로토콜
- 주로 HTML문서를 주고 받는데 사용

---

## @Controller()

브라우저와 통신할 수 있는 **`클래스`** → `Servlet`을 대신함

> 클라이언트의 요청에 대해 `Model`이 업무 수행을 완료하면 그 결과를 가지고 화면을 생성하도록 `View`에 전달하는 역할을 하게 되며, 일종의 조정자 담당
> 
- Model : 무엇을 할 지에 대한 로직을 담고 비지니스 로직을 처리하기 위한 역할
- View : 최종 사용자에게 결과를 화면(UI)로 보여주기 위한 역할
- Controller : 이 두 사이에 있는 컴포넌트로 Model이 데이터를 어떻게 처리할 지를 알려주는 역할

@Controller가 적용 된 클래스는 Spring이 직접 인스턴스로 만들어서 Bean Container에 보관

```java
import org.springframework.stereotype.Controller;

@Controller
public class HelloBootContorller {}
```

---

## @GetMapping()

- @RequestMapping을 상속한다.
- Servlet의 doGet()과 같은 역할을 함
- 요청 url에 대한 GET 요청을 메소드와 mapping시키는 것

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBootContorller {

  @GetMapping("/print") // http://localhost:8080/print
  public void printConsoleURL() {
    System.out.println("브라우저에 의해 호출되었습니다."); -> 해당 URL에 접속하면 콘솔에 찍힘
  }
  
  // 브라우저에 텍스트 보내기
  @GetMapping("/text") // http://localhost:8080/text
  public ResponsEntity<String> printText() {
    return new ResponsEntity<>("브라우저로 텍스트를 전달합니다.", HttpStatus.OK);
    -> body에 텍스트가 적용이 됨
  }
  
  // 브라우저에 html 보내기
  @GetMapping("/html") // http://localhost:8080/html
  public ResponsEntity<String> printHtml() {
    return new ResponsEntity<>("""
                <!DOCTYPE html>
                <html>
                  <head>
                    <title>Spring Test</title>
                  </head>
                  <body>
                    <h1>Hello Spring Boot!</h1>
                  </body>
                </html>
               """, HttpStatus.OK);
    -> 브라우저에 html코드가 보내짐
  }
  
  //브라우저에 jsp파일 보내기
  @GetMapping("/jsp") // http://localhost:8080/jsp
  public String viewJSP() {
    return "helloJsp"; -> jsp파일이 보내짐
  }
  
  @GetMapping("/jsp2") // http://localhost:8080/jsp2
	public ModelAndView viewJSPWithModelAndView() {
		/*
		 * 옛날 방법
		 * Model : JSP에 보내질 데이터
		 * View : 브라우저에게 보여 줄 화면
		 */
		ModelAndView view = new ModelAndView("helloJsp");
		//                    Key       ,    Value
		view.addObject("applicationName", "HelloBoot!");
		return view;
	}
	
	@GetMapping("/jsp3") // http://localhost:8080/jsp
	public String viewJSPWithModel(Model model) {
		// Model : JSP에 보내질 데이터
		model.addAttribute("applicationName", "Spring Boot 3.3.4");
		
		return "helloJsp";
	}
	
}
```

# JSP로 응답하기

## JSP란?

### Jakarta(Java) Server Page

- HTML문법에 Java를 사용할 수 있는 Server Side Language
- <%여기에 Java Code를 작성할 수 있음%>
- 2000년대 초반까지는 JSP만 사용해서 작성함
- Spring Framework 출시 후 JSP를 Template로 사용
    - <%더 이상 사용하지 않음%>

### Spring Boot와 함께 출시된 Thymeleaf를 공식 지원

- 국내 Spring 사용자들은 JSP를 선호

### Spring Boot 3에서는 JSP를 기본제공하지 않음

- Thymeleaf를 기본으로 제공함
- JSP를 사용하려면 별도의 설정이 필요
    
    → 플러그인 설치 교재 44Page 참고
