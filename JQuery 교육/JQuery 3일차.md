# Form Element

## Input/Textarea 공통

val(); → 입력 된 값을 가져옴

Ex > **`var email = $(”#email”).val();`**

val(”값”); → 값을 세팅해줌 (입력 값 초기화에 유용)

Ex > **`$(”#email”).val(”Email 입니다.”);`**

```jsx
$(".check-email-btn").on("click", function () {
    var email = $("#email").val();
    /**
     * Javascript의 Not 연산자
     * "", '', 0(숫자일 때만), null, undefined, false를 모두 체크
     * 값이 없다라는 의미가 된다면, !variable의 결과는 true
     * 값이 있다라는 의미가 된다면, variavle의 결과는 true
     */
    if (!email) {
      alert("이메일을 입력하세요!");
    }
    alert(email);
  });
```

## Select Eelement

**`option:selected`** → 선택 된 option태그

```jsx
$("#jobs").on("change", function () {
    var jobsValue = $(this).val();
    var jobsText = $(this).find("option:selected").text();

    console.log(typeof jobsValue); // String

    console.log("Value : " + jobsValue, "Text : " + jobsText);
    if (jobsValue === "0") {
      alert("직업을 반드시 선택해 주세요!");
    }
  });
```

## Radio/CheckBox 공통

**`$(”input[type=radio][name=age]”).lenght;`**

**`$(”input[type=checkbox][name=favorate-genre]”).lenght;`**

→ 선택 된 개수를 가져옴 → 선택 여부를 알 수 있음

```jsx
$(".check-radio-item").on("click", function () {
    var radioLength = $("input[type=radio][name=age]").length;
    console.log(radioLength);
    var checkedRadio = $("input[type=radio][name=age]:checked").length;
    console.log(checkedRadio);
    if (!checkedRadio) {
      alert("연령대를 선택해주세요!");
    }
  });
```

```jsx
$("input[type=checkbox][name=favorate-genre]").on("change", function () {
    var checkboxLength = $(
      "input[type=checkbox][name=favorate-genre]:checked"
    ).length;
    var allCheckboxLength = $(
      "input[type=checkbox][name=favorate-genre]"
    ).length;
    console.log(allCheckboxLength);
    console.log(checkboxLength);
 });
```

**`prop();`**은 선택을 강제로 함

```jsx
/*
    선택 된 체크박스의 개수와 전체 제크박스의 길이가 같다면
    전체선택 체크박스를 체크
    선택 된 체크박스의 개수와 전체 제크박스의 길이가 다르다면
    전체선택 체크박스 해체
    */
    $("#checked-all").prop("checked", checkboxLength === allCheckboxLength);
    // attr, prop
    // attr : 태그의 속성(Attribute)를 제어하는 역할 -> 실제로 선택되어있지 않음(표면상 선택)
    // prop : 태그의 속성(Attribute)를 제어하는 역할 -> 실제로 선택 됨
    //        사용자의 이벤트를 유발하는 속성을 제어
  });
  /**
   * 전체선택 체크박스가 체크되면 모든 체크박스가 체크되고
   * 전체선택 체크박스가 체크 해제되면 모든 체크박스가 해제
   */
  $("#checked-all").on("change", function () {
    var checked = $(this).prop("checked");

    $("input[type=checkbox][name=favorate-genre]").prop("checked", checked);
  });
```
