# Web Socket

- 일반적인 HTTP 통신을 사용하지 않는 방법

### HTTP

TCP 연결 → 통신 후 → TCP 연결 해제

- 연결이 지속적이지 않음
- 상태가 없음

### Socket

응용프로그램에서 일반적으로 사용(온라인 애플리케이션 - 메신저, 온라인 게임)

TCP 연결 → 통신이 완료되어도 연결 해제를 하지 않음

- 연결이 지속적이다
- 상태가 존재
- 서버 + 클라이언트 + 다른 클라이언트가 지속적으로 통신이 가능

### Web Socket

Spring에서는 Socket Lib를 사용

```xml
		<!-- 
			Web Socket을 사용하기 위한 Dependency(라이브러리)
			ws://, wss:// 프로토콜을 사용할 수 있음 
		-->
		<!--
		https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-websocket 
		-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-websocket</artifactId>
		</dependency>
```

---

Spring이 아니라면 Node.js를 사용함

---

Web Socket은 이름 그대로 Web에서 Socket을 사용함(ws://, wss://)

TCP 연결 → 통신이 완료되어도 연결 해제를 하지 않음

- 연결이 지속적이다
- 상태가 존재
- 서버 + 클라이언트 + 다른 클라이언트가 지속적으로 통신이 가능
- HTML5 Spec : HTTP2 통신에서 사용

Web Socket이 존재하지 않을 때의 서비스 구현

→ Polling, Long Polling

→ 서버 자원을 매우 많이 소비하는 단점이 있었음
