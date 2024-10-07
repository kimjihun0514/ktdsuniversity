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

# 10.01

# 파일 업로드/다운로드

## <input[type=”file”]>

파일을 전송하는 태그

form 태그에 enctype=”multipart/form-data”를 작성해 줘야 함

http로 전송할 수 있는 최대 Byte ⇒ 4GB

## 파일을 전송하려면?

**`@RequestParam`**을 사용

jsp파일에 있는 name과 파라미터로 받는 MultipartFile의 변수명은 같아야 한다.

### upload

무언가를 올린다 → 클라이언트가 서버로 올림

### download

무언가를 받는다 → 클라이언트에서 서버가 받음

| 1번 PC |  | 2번 PC |  | 3번 PC |
| --- | --- | --- | --- | --- |
| Client | → | Server | → | Client |
| A.txt | (upload) | A.txt | (download) | A.txt |

Server가 더 높은 위치에 있음

### 데이터의 크기

|  |  | only window | other |
| --- | --- | --- | --- |
| 1bit | ⇒ | 1 / 0 |  |
| 1 byte | ⇒ | 8bit |  |
| 1 kb | ⇒ | 1024 byte | 1000 byte |
| 1 mb | ⇒ | 1024 kb | 1000 kb |
| 1 gb | ⇒ | 1024 mb |  |
| 1 tb | ⇒ | 1024 gb |  |
| 1 pb | ⇒ | 1024 tb |  |
| 1 zb | ⇒ | 1024 pb |  |
| 1 yb | ⇒ | 1024 zb |  |
