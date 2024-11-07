### 쿠키

동일한 브라우저에서는 세션의 정보를 공유한다

→ 창이 다르거나 탭이 달라도 세션을 항상 공유함

---

# 회원이 작성한 글만 조회하기

### BoardVO에 MemberVO 추가

게시글 목록, 내용 조회 페이지에서 게시글 작성자의 이름과 이메일을 볼 수 있게 하기 위해 BoardVO에 이름과 이메일이 담긴 MemberVO를 멤버변수로 추가

```java
public class BoardVO {
	...생략...
	private MemberVO memberVO;
	...생략...
	public MemberVO getMemberVO(){
		return this.memberVO;
	}
	public void setMemberVO(MemberVO memberVO){
		this.memberVO = memberVO;
	}
}
```

---

## Interceptor

Spring은 여러 곳에서 필요한 공통 로직을 Interceptor라는 개념으로 제공

- Boolean 데이터를 반환함
1. `controller 실행 전에 가로챔`
- true면 controller를 실행
- false면 내가 설정한 URL로 연결
- **`preHandle`** 동작
1. `controller 실행 후에 가로챔`
- 성능 체크 하기 위해 시간을 잴 수 있음
- **`postHandle`** 동작
1. `html로 반환 되고 난 다음에 전달하기 직전에 가로챔`
- **`afterCompletion`** 동작

controller가 하던 session check를 interceptor가 대신 하게 만들어줌

---

### 세션이 없는 경우(로그인을 하지 않은 경우)

1. controller가 실행되지 않아야 함
2. 로그인 페이지로 전달
3. 로그인이 완료되면 원래 가려 했던 URL로 이동

→ 세션 체크의 경우 **`preHandle`**만 사용해도 충분

→ `postHandle, afterCompletion은 삭제`

→ **`HandlerInterceptor 인터페이스`**는 모든 메소드가 default로 되어있어서 지워도 사용 가능
