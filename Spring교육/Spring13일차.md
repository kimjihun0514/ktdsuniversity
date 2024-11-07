# Pagination

게시글의 수가 많다면 데이터를 블록단위로 나누어서 노출

→ ex> 네이버 쇼핑

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/d914575a-53b3-4065-8228-94f938883c80/a9a2e996-8dce-4d0a-b4c9-0ec902d8c07a/image.png)

---

## pagination 원리

한 페이지에 많은 항목을 보여주려고 하면 메모리가 부족함

1. 필요 데이터
    - 조회 할 페이지 번호
    - 게시글의 총 갯수
    - 한 목록에 노출 할 게시글의 수
2. 게시글에 필요 한 페이지의 총 개수
    - **`게시글의 총 개수 / 한 목록에 노출 할 게시글의 수 + 1`**
3. 조회 시작 게시글 번호 구하기
    - **`조회할 페이지 번호 X 한 목록에 노출할 게시글의 수 + 1`**
4. 조회 끝 게시글 번호 구하기
    - **`(조회할 페이지 번호 + 1) X 한 목록에 노출할 게시글의 수`**

ex> 첫 번째 페이지의 게시글 조회

→ 0 X 10 + 1 = 1

→ (0 + 1) X 10 = 10

ex> 다섯 번째 페이지의 게시글 조회

→ 5 X 10 + 1 = 51

→ (5 + 1) X 10 = 60

---

## pagination한 게시글의 page도 pagination 해야 함

1. 필요 데이터
    - 총 페이지의 개수
    - 한 페이지 그룹에 보여줄 페이지의 번호의 개수
    - 총 페이지 그룹의 개수
    - 현재 페이지의 그룹 번호
    - 페이지 그룹 번호의 시작 페이지 번호
    - 페이지 그룹 번호의 끝 페이지 번호
2. 총 페이지 그룹의 개수
    - 총 페이지 개수 / 한 페이지에 보여 줄 페이지 번호의 개수
3. 현재 페이지 그룹 번호
    - (현재 페이지 번호 / 한 페이지 그룹에 보여줄 페이지의 번호의 개수)
4. 페이지 그룹 번호의 시작 페이지 번호
    - 현재 페이지 그룹 번호 * 한 페이지 그룹에 보여줄 페이지의 번호의 개수
5. 페이지 그룹 번호의 끝 페이지 번호
    - (현재 페이지 그룹 번호 + 1) * 한 페이지 그룹에 보여줄 페이지의 번호의 개수-1

```java
public void setPageCount(int listCount) {
		// 총 페이지 개수 계산하기
		this.pageCount = (int)Math.ceil( (double)listCount / this.listSize );
		/**********************************************************************/
		// 페이지 그룹 관련 계산하기
		// 총 페이지 그룹 개수
		this.groupCount = (int)Math.ceil( (double)this.pageCount / this.pageCountInGroup );
		// 현재 페이지 번호
		this.groupNo = this.pageNo / this.pageCountInGroup;
		// 현재 페이지 그룹의 시작 페이지 번호
		this.groupStartPageNo = this.groupNo * this.pageCountInGroup;
		// 현재 페이지 그룹의 끝 페이지 번호
		this.groupEndPageNo = (this.groupNo + 1) * this.pageCountInGroup - 1;
		/*
		 * 현재 그룹이 마지막 그룹일 경우
		 * 계산 된 현재 그룹의 마지막 페이지 번호와 실제 마지막 페이지 번호가 다를 수 있다.
		 */
		if (this.groupEndPageNo > this.pageCount) {
			this.groupEndPageNo = this.pageCount - 1;
		}
		// 다음 그룹 존재 여부
		this.hasNextGroup = this.groupNo + 1 < this.groupCount;
		// 이전 그룹 존재 여부
		this.hasPrevGroup = this.groupNo > 0;
		// 다음 그룹의 시작 페이지 번호
		this.nextGroupStartPageNo = this.groupEndPageNo + 1;
		// 이전 그룹의 시작 페이지 번호
		this.prevGroupStartPageNo = this.groupStartPageNo - this.pageCountInGroup;
	}
```

```html
<ul class="page-nav">
				<c:if test="${searchBoardVO.hasPrevGroup}">
					<li>
						<a href="javascript:movePage(0);">
							처음
						</a>
					</li>
					<li>
						<a href="javascript:movePage(${searchBoardVO.prevGroupStartPageNo});">
							&lt;			
						</a>
					</li>
				</c:if>
				<!--
				 여기서의 forEach는 자바에서의 일반 For문과 비슷한 역할을 함 
				 begin : 현재 페이지 그룹의 시작 페이지 번호
				 end : 
				 step : 
				 -->
				<c:forEach begin="${searchBoardVO.groupStartPageNo}"
						   end="${searchBoardVO.groupEndPageNo}" 
						   step="1" 
						   var="p">
					<li class="${p eq searchBoardVO.pageNo ? 'active' : ''}">
						<a href="javascript:movePage(${p});">
							${p + 1} 
						</a>
					</li>
				</c:forEach>
				<c:if test="${searchBoardVO.hasNextGroup}">
					<li>
						<a href="javascript:movePage(${searchBoardVO.nextGroupStartPageNo});">
							&gt;
						</a>
					</li>
					<li>
						<a href="javascript:movePage(${searchBoardVO.pageCount - 1});">
							마지막 
						</a>
					</li>
				</c:if>
</ul>
```

```jsx
$().ready(function() {
	$(".list-size").on("change", function() {
		// var listSize = $(this).val();
		// location.href="/board/list?pageNo=0&listSize=" + listSize;
		movePage(0);
	});
	$(".search-btn").on("click", function() {
		movePage(0);
	});
});

function movePage( pageNo ) {
	$(".page-no").val(pageNo);
	
	$(".search-form").attr({
		"method": "GET",
		"action": "/board/list"
	}).submit();
}
```

# 검색

```java
package com.ktdsuniversity.edu.hello_spring.bbs.vo;

import com.ktdsuniversity.edu.hello_spring.common.vo.PaginationVO;

public class SearchBoardVO extends PaginationVO {

	/****검색****/
	private String searchType;
	
	private String searchKeyword;
	
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

}
```

Pagination을 같이 하기 위해 PaginationVO를 상속받음

⇒ 둘 중 하나를 수정해도 사용이 가능해짐

```html
<form class="search-form">
				<input type="hidden" name="pageNo" class="page-no" value="${searchBoardVO.pageNo}"/>
				<select name="listSize" class="list-size">
					<option value="10" ${"10" eq searchBoardVO.listSize ? "selected" : ""}>10개</option>
					<option value="20" ${"20" eq searchBoardVO.listSize ? "selected" : ""}>20개</option>
					<option value="30" ${"30" eq searchBoardVO.listSize ? "selected" : ""}>30개</option>
					<option value="40" ${"40" eq searchBoardVO.listSize ? "selected" : ""}>40개</option>
					<option value="50" ${"50" eq searchBoardVO.listSize ? "selected" : ""}>50개</option>
					<option value="100" ${"100" eq searchBoardVO.listSize ? "selected" : ""}>100개</option>
				</select>
				
				<select class="search-type" name="searchType">
					<option value="boardId" ${"boardId" eq searchBoardVO.searchType ? "selected" : ""}>글 번호</option>
					<option value="subject" ${"subject" eq searchBoardVO.searchType ? "selected" : ""}>제목</option>
					<option value="content" ${"content" eq searchBoardVO.searchType ? "selected" : ""}>내용</option>
					<option value="subject+content" ${"subject+content" eq searchBoardVO.searchType ? "selected" : ""}>제목 + 내용</option>
					<option value="name" ${"name" eq searchBoardVO.searchType ? "selected" : ""}>작성자 이름</option>
					<option value="email" ${"email" eq searchBoardVO.searchType ? "selected" : ""}>작성자 이메일</option>
				</select>
				<input type="text" class="search-keyword" name="searchKeyword"/>
				<button type="button" class="search-btn">검색</button>
			</form>
```

선택이 되었을 때 고정이 되도록 selected 속성을 줌
