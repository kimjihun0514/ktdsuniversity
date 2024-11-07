# Spring Security

### Authentication 인증

- 가장 기본적인 인증 : 아이디, 비밀번호
    - 단점 : 비밀번호가 쉽게 털림
        - → 자동완성, 키 로거, 무차별 대입 등 여러 방법으로 비밀번호를 알아낼 수 있음
            - → 비밀번호 일정 횟수 틀리면 계정을 잠금
- 투 패턴 인증 : OTP, 전화번호 인증 등으로 인증 절차를 한번 더 함
    - 단점 : 사용자가 좀 귀찮음

---

### Authorization 인가(권한 부여, 접근 제어)

- 인증된 사용자가 특정 기능과 데이터에 대한 이용 권리가 있는 지 확인하는 프로세스

---

# Web App의 일반적인 보안 취약성

## 취약성

- 악의적 의도를 가지고 원치 않는 작업을 수행하는데 이용할 수 있는 약점

## 가장 많은 피해사례가 보고된 목록

- OWASP Top Ten
- SANS Top 25 —> 최소한 막아야 할 목록을 알려줌

## 그 중, 개발자가 대처방법을 반드시 알고 있어야 할 일반적인 취약성

- **`인증 취약성`**
    - 사용자가 악의를 가지고 `다른 사람의 기능이나 데이터에 접근`할 수 있는 것
        - EX>
            1. 일반 사용자가 관리자의 기능이다 데이터에 접근
            2. 내가 작성하지 않은 글의 수정 또는 삭제
            3. 내가 주문하지 않은 상품들의 주문서 수정 또는 삭제
- **`세션 고정`**
    - **`세션 인증 기반 애플리케이션에서 발생`**
        - 서버는 **`사용자를 식별한 후 요청을 위해 SessionID를 발급`**
        - 발급한 `SessionID를 사용자에게 Cookie를 통해 전달`
        - 사용자는 `매 요청마다 SesisonID를 Cookie로 전달`
    - **`세션 고정` / `세션 탈취`**
        - **`발급받은 SessionID가 로그인 전/후의 SessionID와 모두 동일하게 사용 될 경우`**
        - 악의적인 사용자가 **`피해자의 세션을 탈취하여 정상적인 사용자로 위장하는 방법`**
- **`XSS`**(교차 사이트 스크립팅) — **`솔루션이 필요함`**
    - 악의적인 사용자가 `게시글에 스크립트를 주입`해 사용자가 이를 실행하도록 하는 공격
    - `D-DOS`, `세션 탈취` 등의 공격에 사용
        - 불특정 다수의 피해자는 자신도 모르는 사이에 공격의 가담자가 될 수 있음

![image](https://github.com/user-attachments/assets/bdb22ac7-b561-4dd2-9a15-20591545979e)

- **`CSRF`**(사이트 간 요청 위조) — **`CSRF 토큰을 이용해 막을 수 있음`**
    - 웹 애플리케이션의 `흔한 취약점 중 하나`
    - 서버에서 실행되는 **`특정 URL하나를 추출해 이메일이나 게시글 및 댓글에 작성`**
        - `이미지나 링크 혹은 스크립트`
    - 이메일 또는 게시글, 댓글을 조회한 사용자는 `자기도 모르는 사이에 URL을 실행`
    - **`서버는 사용자가 직접 실행한 것으로 판단`**함
        - **`Log, DB 등에도 사용자가 직접 실행한 것으로 작성됨`**

![image](https://github.com/user-attachments/assets/28e532fd-8557-4d73-9677-bb02f61bd19e)

- **`Injection`**
    - 해커가 시스템의 `OS, DB, 환경정보 등을 **탈취 및 제어권을 확보하기 위한 공격**`
    - `Form 또는 URL을 통해` 시스템을 제어하는 실행 문장을 전송
    - 이를 방어하지 않은 서버는 정보를 탈취당하거나 제어권을 잃게 됨
        - SQL Injection: SQL문장을 서버로 보내 DB정보를 탈취
        - Command Injection: **`OS 명령문을 서버로 보내 OS의 제어권을 탈취`**
            - mkdir, re -rf/, remove 등 os의 제어권을 탈취할 만한 명령어를 입력
        - 등등…
- **`기밀 데이터 노출`**
    - 시스템의 중요 정보나 사용자의 개인 정보 등 보호되어야 할 정보들이 Log나 화면에 그대로 노출되는 것
        - `사용자의 개인 정보`
            - ID, Password, 주소, 이메일 등등…
        - `시스템 정보`
            - OS 종류, Server 제품명 및 버전, DB 제품명 및 버전 등등…
        - `로그인 결과 정보`
            - 아이디가 존재하지 않습니다.
            - 비밀번호가 틀렸습니다. 등 해커가 유추할 수 있는 정보들
- **`메서드 접근 제어 부족`** — **`권한에 대한 인터페이스나 클르스를 따로 분리하여 처리해야 함`**
    - Controller, Service, Repository 등 권한 처리를 하나의 클래스로만 처리하는 경우
    - 충분한 테스트가 뒷받침 되지 않으면, 정상적으로 동작하지 않은 가능성이 높다.
- **`알려진 취약성이 있는 종속성(Dependency) 이용`**
    - Spring 애플리케이션을 개발하기 위해서 여러 종류의 라이브러리가 필요
    - 취약성이 보고된 라이브러리를 사용할 경우, 개발자 단계에서 처리가 불가능
    - 따라서, 애플리케이션도 동일한 취약성에 노출
        - EX> Log4j

---

[[긴급] 거의 모든 서버가 위험하다! 매우 치명적인 ‘로그4j’ 보안 취약점 발견 (boannews.com)](https://www.boannews.com/media/view.asp?idx=103257)

![image](https://github.com/user-attachments/assets/9ab63643-9d6e-46c9-b5e3-ff4a3497c063)

---

## Spring Security

- 인증과 접근 제어(권한 처리)를 위해 세부적인 맞춤 구성이 가능한 강력한 필터 기반 프레임워크
- Spring 기반 애플리케이션을 보호하기 위한 사실상 표준 프레임 워크
    - Annotation 또는 간단한 코딩만으로 인증 및 접근 제거가 가능

**`Spring Security는 Dependency를 추가하는 것 만으로도 보안이 적용`**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

→ 모든 URL 자원들은 Spring Security의 인증이 있어야 사용할 수 있음

![image](https://github.com/user-attachments/assets/ad4b22e3-62a5-4869-abf4-d27553412541)

Dependency 추가 후 접속 시 로그인 페이지가 먼저 나옴

ID : user

password : Console의 비밀번호

Spring Security의 로그인은 Session 기반이 아님

Spring Security의 로그인 후 Session Login을 한번 더 수행해야 함

---

### Spring Security의 기본 구성

![image](https://github.com/user-attachments/assets/25754e77-9f5c-4d37-bc22-7d19194ce4eb)

인증 공급자 이후 디스페쳐 서블릿이 동작 하고 controller 가 작동

## 사용자 관리

beans.security 패키지 생성

---

UserDetails 인터페이스를 상속받는 SecurityUser 클래스가 필요

```java
package com.ktdsuniversity.edu.hello_spring.common.beans.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;

/**
 * SpringSecurity로 인증할 사용자의 정보를 담고있는 객체
 * SpringSecurity로 인증한 사용자의 정보를 담고있는 객체
 * SpringSecurity가 사용할 클래스 -> 인증 수행
 * 
 * AuthorizationFilter
 *   -> AuthorizationManager
 *      -> AuthorizationProvider
 *         -> UserDetailsService
 *           -> 호출
 */
public class SecurityUser implements UserDetails {

	private static final long serialVersionUID = 653523424966037221L;

	/**
	 * UserDetailsService를 통해서 아이디(이메일)로 데이터베이스에서 조회된 결과를 가지고 있을 멤버변수
	 */
	private MemberVO memberVO;
	
	public SecurityUser(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	/**
	 * 로그인을 요청한 사용자의 권한 정보를 세팅
	 *  -> 로그인 이후 해당 사용자의 권한 정보를 데이터베이스에서 조회한 후 권한 부여
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 권한 정보를 가지고있는 인터페이스 => GrantedAuthority
		// GrantedAuthority를 구현한 권한 클래스 => SimpleGrantedAuthority
		// SimpleGrantedAuthority List 를 반환
		
		// 부여된 권한에 따라서 실행을 제어할 수 있다.
		// 이 사용자는 CRUD 모두 가능한 권한을 가진 사용자.
		return List.of( new SimpleGrantedAuthority("CREATE"), 
				    new SimpleGrantedAuthority("READ"),
				    new SimpleGrantedAuthority("UPDATE"),
				    new SimpleGrantedAuthority("DELETE"));
	}

	/**
	 * 로그인을 요청한 사용자의 비밀번호를 반환
	 */
	@Override
	public String getPassword() {
		return this.memberVO.getPassword();
	}

	/**
	 * 로그인을 요청한 사용자의 아이디(이메일)를 반환
	 */
	@Override
	public String getUsername() {
		return this.memberVO.getEmail();
	}
}
```

memberDao에서 이메일만으로 사용자의 정보를 다 가져오는 기능 필요

```java
	@Override
	public MemberVO selectMemberByEmail(String username) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectMemberByEmail", username);
	}
```

(Mapper)

```xml
	<select id="selectMemberByEmail"
			parameterType="string"
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
		 WHERE EMAIL = #{_parameter} 
	</select>
```

---

UserDetailsService 인터페이스를 상속받는 SecurityUserDetailsService 클래스 생성

```java
package com.ktdsuniversity.edu.hello_spring.common.beans.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;

/**
 * Spring Security 에 인증을 요청한 사용자의 정보를 조회하는 역할
 * 
 * 아이디(이메일: UserDetails.getUserName())로만 데이터베이스에서 사용자의 정보를 조회한다.
 * 비밀번호 확인은 다른 클래스의 역할 
 * AuthorizationFilter
 *   -> AuthorizationManager
 *      -> AuthorizationProvider -> 호출
 */
public class SecurityUserDetailsService implements UserDetailsService {

	/**
	 * 사용자 정보를 조회 할 DAO
	 */
	private MemberDao memberDao;
	
	public SecurityUserDetailsService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	/**
	 * 데이터베이스에서 사용자의 정보를 조회
	 * 
	 * @param username 인증을 요청한 사용자의 아이디(이메일)
	 * @return UserDetails 인터페이스를 구현한 사용자 정보 객체
	 * @throws UsernameNotFoundException username 으로 조회한 결과가 null 일 때 Spring Security 에게 던질 예외
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO memberVO = this.memberDao.selectMemberByEmail(username);
		
		if (memberVO == null) {
			// UserDetailsService에서 예외가 던져지면
			// AuthenticationProvider에서 예외를 처리
			throw new UsernameNotFoundException("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		// UserDetails 인터페이스 타입의 클래스로 계정 정보를 전달
		// SecurityUser is a UserDetails
		return new SecurityUser(memberVO);
	}

}
```

UserDetailsService 인터페이스는 loadUserByUsername이라는 매소드 하나만 존재함

```java
	/**
	 * 데이터베이스에서 사용자의 정보를 조회
	 * 
	 * @param username 인증을 요청한 사용자의 아이디(이메일)
	 * @return UserDetails 인터페이스를 구현한 사용자 정보 객체
	 * @throws UsernameNotFoundException username 으로 조회한 결과가 null 일 때 Spring Security 에게 던질 예외
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO memberVO = this.memberDao.selectMemberByEmail(username);
		
		if (memberVO == null) {
			// UserDetailsService에서 예외가 던져지면
			// AuthenticationProvider에서 예외를 처리
			throw new UsernameNotFoundException("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		// UserDetails 인터페이스 타입의 클래스로 계정 정보를 전달
		// SecurityUser is a UserDetails
		return new SecurityUser(memberVO);
	}
```

---

## 암호 처리 - 기본 구성 재 정의

PasswordEncoder를 상속 받는 SecurityPasswordEncoder 클래스 작성 → 기존의 SHA 클래스를 상속

```java
package com.ktdsuniversity.edu.hello_spring.common.beans.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ktdsuniversity.edu.hello_spring.common.beans.Sha;

/**
 * SpringSecurity 인증 절차에서
 * 사용자가 입력한 비밀번호와 데이터베이스 내에 존재하는 암호화 된 비밀번호를 비교하는 역할 수행
 * 
 * AuthorizationFilter
 *   -> AuthorizationManager
 *      -> AuthorizationProvider -> 호출
 */
public class SecurityPasswordEncoder extends Sha implements PasswordEncoder {

	private String salt;

	/**
	 * 데이터베이스의 salt 값을 할당
	 *  -> 암호화에 필요하기 때문
	 *    -> 같은 salt 로 암호화 해야 같은 결과가 나옴
	 * @param salt 인증을 요청한 사용자의 salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 사용자가 인증 요청한 비밀번호를 암호화
	 *  -> 데이터베이스의 암호화 된 비밀번호와 일치하는지 확인하기 위함
	 * @param rawPassword 사용자가 인증 요청한(입력한) 비밀번호
	 * @return 암호화된 사용자가 요청한 비밀번호
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		// CharSequence == String
		return super.getEncrypt(String.valueOf(rawPassword), this.salt);
	}

	/**
	 * 암호화된 사용자의 비밀번호와 데이터베이스의 암호화된 비밀번호와 일치하는지 확인
	 * @param rawPassword 사용자가 인증 요청한(입력한) 비밀번호 (암호화 되기 전)
	 * @param encodedPassword 데이터베이스의 암호화된 비밀번호
	 * @return 비밀번호가 일치하는가?
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String password = this.encode(rawPassword); // 사용자가 입력 한 비밀번호를 암호화
		return password.equals(encodedPassword);
	}
}
```

---

## 인증 구현 - 기본 구성 재 정의

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/4c28c166-7e21-4f37-9938-7cc6eeb6a084/image.png)
