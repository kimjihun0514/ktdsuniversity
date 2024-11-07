## 로그인된 회원의 Email을 자동으로 입력

로그인을 했다면 굳이 게시글을 작성할 때 이메일을 입력할 필요가 없이 게시글 작성할 때 로그인 한 회원의 이메일을 가져오면 됨

```java
@Controller
public class BoardController {
	... 생략 ...
	@PostMapping("/board/write")
	public String doCreateNewBoard(@Valid WriteBoardVO writeBoardVO
																	, BindingResult bindingResult
																	, Model model
																	, @SessionAttribute(value = "_LOGIN_USER_", required = false) MemberVO loginMemberVO) {
		if (bindingResult.hasError()) {
			// 에러가 존재한다면 ex> 제목 입력을 하지 않음 등 WriteBoardVO에 작성한 Valid와 맞지 않다면
			model.addAttribute("writeBoardVO", writeBoardVO);
			return "board/boardwrite";
		}
		if (loginMemberVO == null) {
			// 로그인을 하지 않았다면
			return "redirect:/member/login";
		}
		// 여기부터는 에러가 존재하지 않고 로그인을 했을 경우
		// 로그인 한 회원의 email을 가져와서 writeBoardVO에 저장
		writeBoardVO.setEmail( loginMemberVO.getEmail() );
		this.boardService.createNewBoard(writeBoardVO);
		return "redirect:/board/list"
	}
}
```
