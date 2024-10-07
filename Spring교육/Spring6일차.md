# 비밀번호 암호화(ppt 278)

회원가입할 때 입력한 비밀번호의 원문을 DB의 저장하는 것은 매우 위험

→ DB가 해킹되었을 때 치명적(EX> 뽐뿌 개인정보 유출사건)

비밀번호는 반드시 복호화 불가능한 암호화 알고리즘을 사용해 저장해야 함

→ **`SHA Algorithm` + `SALT`**(**복호화를** 하려면 슈퍼컴퓨터로 돌려도 30년 정도 걸리는 암호화 방법)

---

### 암호화란?

평문(원문)을 알아보기 어렵게 꼬아둔 것

### 복호화란?

암호화 된 문장을 평문(원문)으로 다시 돌리는 것

---

### 원래 SALT는 물리적으로 분리된 DB에 작성해야 함

물리적으로 같은 DB에 있을 경우 SALT를 보고 해석할 수 있기 때문

---

### 암호화 된 비밀번호를 어떻게 비교?

입력한 비밀번호를 암호화했을 때 나온 SALT와 DB에 있는 SALT를 가져와서 비교 했을 때 같으면 됨

---

## 모든 개인정보는 암호화 되어야 함

모든 정보는 민감한 개인정보이고 심지어 이름까지도 암호화 해서 저장해야 함

하지만 비밀번호의 경우 복호화가 되어선 안되는 케이스이므로 가장 복잡한 **`SHA 알고리즘`**을 사용

나머지는 MD5를 사용해서 암호화(실무에서는 사용 X)

---

## @Component와 @Bean의 차이점

|  | @Component |  | **`ComponentScan`**을 통해 Bean으로 생성 |
| --- | --- | --- | --- |
| ↙ | ⬇ | ↘ |  |
| @Controller | @Service | @Repository | Class로 지정(자동 Injection) |

@Bean : 메소드가 실행되면 반환되는 값을 가지고 인스턴스를 만들어 메소드로 BeanContainer에 저장함(수동 Injection을 해야 함)

@Configuration이 달려있는 클래스에 작성할 수 있음

---

### @Bean을 사용하는 이유

Spring에 의존하지 않고 객체 생성을 내가 할 수 있음

---

## 비밀번호 암호화

```java
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Sha {
	/**
	 * SHA-256 암호화 함
	 * @param source 원본
	 * @param salt(String) SALT 값
	 * @return
	 */
	public String getEncrypt(String source, String salt) {
		return getEncrypt(source, salt.getBytes());
	}
	
	/**
	 * SHA-256 암호화 함
	 * @param source 원본
	 * @param salt(byte[]) SALT 값
	 * @return
	 */
	public String getEncrypt(String source, byte[] salt) {
		
		String result = "";
		
		byte[] a = source.getBytes();
		byte[] bytes = new byte[a.length + salt.length];
		
		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			
			byte[] byteData = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}
			
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * SALT를 얻어온다.
	 * @return
	 */
	public String generateSalt() {
		Random random = new Random();
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < salt.length; i++) {
			// byte 값을 Hex 값으로 바꾸기.
			sb.append(String.format("%02x",salt[i]));
		}
		
		return sb.toString();
	}

}
```

### Bean 생성

Sha 클래스를 commmon.beans 패키지에 넣고 WebConfig 파일에 Bean으로 저장

```java
// Spring Bean 을 수동으로 생성하는 기능
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	/**
	 * Auto DI: @Component
	 * Manual DI: @Bean
	 *  -> 객체 생성을 스프링이 아닌 개발자가 직접 하는 것
	 * @return
	 */
	@Bean // Sha라는 이름의 Bean이 생김
	Sha createShaInstance() {
		Sha sha = new Sha();
		return sha;
	}
	
	...생략...
	
}
```

@Configuration은 Spring Bean을 수동으로 생성해주는 기능을 가지고 있다.

### Sha 사용법(예제)

```java
	public static void main(String[] args) {
		
		Sha sha = new Sha();
		
		// 1. salt 생성
		String salt = sha.generateSalt();
		
		// 2. 평문을 암호화
		String password = "password1234";
		String encryptedPassword = sha.getEncrypt(password, salt);
		System.out.println(encryptedPassword);
		System.out.println(salt);
	}
```

### Sha 사용법(ServiceImpl)

Bean으로 생성한 Sha를 @Autowired해서 사용

```java
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private Sha sha;
	
	@Override
	public boolean createNewMember(RegistMemberVO registMemberVO) {
		int emailCount = this.memberDao.selectEmailCount(registMemberVO.getEmail());
		if (emailCount > 0) {
			throw new IllegalArgumentException("해당 이메일은 사용중인 이메일입니다.");
		}
		// 1. Salt 발급
		String salt = this.sha.generateSalt();
		
		// 2. 사용자의 비밀번호를 암호화
		String password = registMemberVO.getPassword();
		password = this.sha.getEncrypt(password, salt);
		
		// 3. 암호화 된 비밀번호와 비밀번호 찾기를 위한 salt 를 DB에 저장
		registMemberVO.setPassword(password);
		registMemberVO.setSalt(salt);
		
		int insertCount = this.memberDao.insertNewMember(registMemberVO);
		return insertCount > 0;
	}
}
```

## 로그인 만들기

### dao

```java
	@Override
	public String selectSalt(String email) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectSalt", email);
	}

	@Override
	public MemberVO selectOneMember(LoginMemberVO loginMemberVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneMember", loginMemberVO);
	}
```

### mapper

```xml
	<select id="selectSalt" parameterType="string" resultType="string">
		SELECT SALT
     FROM MEMBERS
    WHERE EMAIL = #{_parameter} 
	</select>
	
	<select id="selectOneMember" 
	        parameterType="com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO" 
	        resultType="com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO">
		SELECT EMAIL
		     , NAME
		     , PASSWORD
		     , SALT
		     , LOGIN_FAIL_COUNT
		     , TO_CHAR(LATEST_LOGIN_FAIL_DATE, 'YYYY-MM-DD HH24:MI:SS') LATEST_LOGIN_FAIL_DATE
		     , LATEST_LOGIN_IP
		     , TO_CHAR(LATEST_LOGIN_SUCCESS_DATE, 'YYYY-MM-DD HH24:MI:SS') LATEST_LOGIN_SUCCESS_DATE
		  FROM MEMBERS
		 WHERE EMAIL = #{email} 
		   AND PASSWORD = #{password} 
	</select>
```

### Service

```java
	@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private Sha sha;
	
	@Override
	public MemberVO readMember(LoginMemberVO loginMemberVO) {
		
		// 1. 사용자가 입력한 이메일의 salt 조회
		String salt = this.memberDao.selectSalt(loginMemberVO.getEmail());
		if (salt == null) {
			// 비어있다면 없는 이메일을 작성한 것이지만 해킹 방지를 위해 
			// 비밀번호도 올바르지 않다고 보내줌
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
		// 2. 사용자가 입력한 비밀번호를 salt를 이용해 암호화
		String password = loginMemberVO.getPassword();
		password = this.sha.getEncrypt(password, salt);
		loginMemberVO.setPassword(password);
		
		// 3. 이메일과 암호화된 비밀번호로 데이터베이스에서 회원정보 조회
		MemberVO memberVO = this.memberDao.selectOneMember(loginMemberVO);
		if (memberVO == null) {
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
		return memberVO;
	}
}
```

### controller

```java
@GetMapping("/member/login")
	public String viewLoginPage() {
		return "member/memberlogin";
	}
	
	@PostMapping("/member/login")
	public String doLogin(@Valid LoginMemberVO loginMemberVO
			            , BindingResult bindingResult
			            , HttpSession session
			            , Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginMemberVO", loginMemberVO);
			return "member/memberlogin";
		}
		// Service에서 던져주는 예외를 잡기 위해 try 캐치 사용
		// 나중에는 사용 X
		try {
			MemberVO memberVO = this.memberService.readMember(loginMemberVO);
			// 로그인 상태를 서버에 저장 (HttpSession필요)
			session.setAttribute("_LOGIN_USER_", memberVO);
		}
		catch (IllegalArgumentException iae) {
			model.addAttribute("loginMemberVO", loginMemberVO);
			model.addAttribute("message", iae.getMessage());
			return "member/memberlogin";
		}
		
		return "redirect:/board/list";
	}
```
