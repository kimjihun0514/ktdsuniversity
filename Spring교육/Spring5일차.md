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
