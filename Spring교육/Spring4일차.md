## @RequestParam

URL로 전달한 파라미터를 가져올 수 있는 방법

EX> http://localhost:8080/board/viewpost?id=1

? 뒤에 있는 값을 가져와라

URL 뒤에 ? 기호로 시작하는 파라미터를 “Query String Parameter”라고 함

## Url에 파라미터를 보내는 방법(**@PathVariable**)

보안상의 문제로 Url에 파라미터를 보내야 함

requestParam과는 다른 방법을 사용

→ **`@GetMapping(”/board/modify/{id}”)` → http://localhost:8080/board/moify/2**

## JSP로 전달 된 Model 반복하기

JSTL(JSP Standard Tag Library) : JSP 표준 태그 라이브러리

- JSP에서 자주 사용하는 기능(반복/조건/데이터 포멧)을 구현해 놓은 태그 라이브러리
- JSP의 EL과 함께 사용됨
- 자주 사용되는 IF FOR문 등을 태그로 사용할 수 있게 해줌
