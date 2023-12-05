# JSP AJAX
- 자바에서 값을 JSON 형태로 보낸 뒤, JSP를 통해 전달받은 값을 처리
- 새로고침 없이 실행 가능
```java
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
```

## 실행 과정
1. 자바스크립트로 값 요청
```javascript

```

2. 자바에서 처리 후 결과값 전송
```java

```

3. 전달받은 결과값을 자바스크립트로 처리
```javascript

```