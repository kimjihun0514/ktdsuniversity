# AOP / Transaction

# AOP

관점 지향 프로그래밍

- Web Application이 실행되는 시점에 따라 정해진 공통 코드를 실행시키는 방법

![image](https://github.com/user-attachments/assets/0c0acf43-e592-47c4-8498-38634770104d)

Weaving - Spring에 내장되어있음

ServiceImpl.java의 모든 메소드가 완료되는데 까지 얼마나 걸리는지 확인

→ 성능 점검

→ AOP Library Dependency 추가

→ AOP 클래스 생성(TimingAspect.java)

→ @Component(클래스를 Spring Bean으로 생성)

→ 공통 코드가 개입할 시점 정의 (@Pointcut)무언가 실행 될 때 개입

→ @Around (@Pointcut의 대상이 실행될 때 개입 할 AOP 코드 정의)

---

AOP는 Interceptor로 대체가 가능하지만 Transaction을 하기 위해 만들어야 함

---

# Transaction

하나의 Business Logic이 완료/실패 되는 단위(Commit, Rollback)

---

Application에서의 Transaction - 하나의 업무에 대한 처리

---

| 특성 | 설명 |
| --- | --- |
| `원자성`(atomicity) | 하나의 트랜잭션은 `모두 하나의 작업 단위로 처리`되어야 함. 트랜잭션이 A,B,C로 구성된다면 `A,B,C의 처리 결과는 모두 동일해야 하며` `하나라도 실패했을 경우 세 가지 모두 처음으로 되돌아가야 함` |
| `일관성`(consistency) | `트랜잭션이 성공했다면 데이터베이스의 모든 데이터는 일관성을 유지`해야 함 |
| `고립성`(isolation) | `트랜잭션은 독립적으로 처리`되며, 처리되는 중간에 `외부에서의 간섭은 없어야 함` |
| `지속성`(durabillty) | `트랜잭션은 독립적으로 처리`되며, `그 결과는 지속적으로 유지`되어야 함 |

# 댓글 구현하기

댓글 구현은 vo dao service 모두 동일하지만 controller에서 @Controller가 아닌 @RestController를 사용한다

## @RestController

@Controller 와 @ResponseBody가 하나로 합쳐진 Annotation

댓글에 관한 것은 json으로 만들어서 사용하기 위함

```java
@RestController
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/board/reply/{boardId}")
	public Map<String, Object> getAllReplies(@PathVariable int boardId) {
		ReplyListVO replyListVO = this.replyService.getAllReplies(boardId);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("count", replyListVO.getReplyCnt());
		resultMap.put("replies", replyListVO.getReplyList());
		
		return resultMap;
	}
	
	@PostMapping("/board/reply/{boardId}")
	public Map<String, Object> doCreateNewReply(@PathVariable int boardId
												, @Valid WriteReplyVO writeReplyVO
												, BindingResult bindingResult
												, @SessionAttribute("_LOGIN_USER_") MemberVO loginMemberVO) {
		if (bindingResult.hasErrors()) {
			return ErrorMapUtil.getErrorMap(bindingResult);
		}
		
		writeReplyVO.setBoardId(boardId);
		writeReplyVO.setEmail(loginMemberVO.getEmail());
		boolean isCreated = this.replyService.createNewReply(writeReplyVO);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", isCreated);
		
		return resultMap;
	}
	
	@GetMapping("/board/reply/delete/{replyId}")
	public Map<String, Object> doDeleteReply(@PathVariable int replyId
											, @SessionAttribute("_LOGIN_USER_") MemberVO loginMemberVO) {
		boolean isDeleted = this.replyService.deleteOneReply(replyId, loginMemberVO.getEmail());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", isDeleted);
		return resultMap;
	}
	
	@PostMapping("/board/reply/modify/{replyId}")
	public Map<String, Object> doModifyReply(@PathVariable int replyId
											, @ModelAttribute ModifyReplyVO modifyReplyVO
											, @SessionAttribute("_LOGIN_USER_") MemberVO loginMemberVO) {
		modifyReplyVO.setReplyId(replyId);
		modifyReplyVO.setEmail(loginMemberVO.getEmail());
		boolean isModified = this.replyService.modifyOneReply(modifyReplyVO);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", isModified);
		
		return resultMap;
	}

	@GetMapping("/board/reply/recommend/{replyId}")
	public Map<String, Object> doRecommendReply(@PathVariable int replyId
														, @SessionAttribute("_LOGIN_USER_") MemberVO loginMemberVO) {
		boolean isIncreased = this.replyService.recommendOneReply(replyId, loginMemberVO.getEmail());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", isIncreased);
		
		return resultMap;
	}
	
}
```
