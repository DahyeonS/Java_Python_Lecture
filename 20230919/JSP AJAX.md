# JSP AJAX
- 자바에서 값을 JSON 형태로 보낸 뒤, JSP를 통해 전달받은 값을 처리
- 새로고침 없이 실행 가능

### JSON 변환
```jsp
<%
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("rs", rs);
%>
```

### 여러 개의 값을 변환 후 전송
```jsp
<%
    JsonArray jsonArray = new JsonArray();
    // JSON으로 변환
    for (MemberDTO dto : list) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("idx", dto.getIdx());
        jsonObject.addProperty("id", dto.getId());
        jsonObject.addProperty("pw", dto.getPw());
        jsonObject.addProperty("name", dto.getName());
        jsonObject.addProperty("age", dto.getAge());
        jsonObject.addProperty("regdate", dto.getRegdate());
        jsonArray.add(jsonObject);
    }

    out.print(jsonArray.toString()); // JSON 전송
%>
```

## 실행 과정
### 자바스크립트
- 전송받은 값을 처리
- 동시에 시스템 처리를 위한 값을 자바로 전송하기도 함
```javascript
function updateJson() {
    // 자바로 전달할 값 설정
	const id = $('#id').val();
	const pw = $('#pw').val();
	const name = $('#name').val();
	const age = $('#age').val();
	const param = {id, pw, name, age};

	$.ajax({
        type: 'POST', // GET 또는 POST
        url: 'updateJson.jsp', // 값을 요청받고자 하는 주소
        dataType: 'json', // 데이터 전송 형태
        data: param, // 자바로 값 전송(없을 시 생략 가능)
        success: function(data) { // 전송 성공 시 수행
        	if(data['rs'] === 1) {
        		alert('회원정보가 수정되었습니다.');
        	} else {
        		alert('죄송합니다. 다시 시도해주세요.');
        	}
        }, error: function(xhr, status, error) { // 전송 실패 시 로그 출력
        	console.log(xhr, status, error);
        }
	});
};
```

### 자바
- 시스템 처리 후 결과값을 JSON 형태로 전송
```jsp
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String sAge = request.getParameter("age");
	int age = 0;
	if (sAge != null) age = Integer.parseInt(sAge);
	
	MemberDTO dto = new MemberDTO(id, pw, name, age);
	MemberDAO dao = new MemberDAO();
	int rs = 0;
	rs = dao.update(dto);
	
	JsonObject jsonObject = new JsonObject();
	jsonObject.addProperty("rs", rs); // 결과값을 JSON으로 변환
%>
<%=jsonObject%> <%-- 결과값 전송(out.print(jsonArray.toString());으로도 전송 가능) --%>
```