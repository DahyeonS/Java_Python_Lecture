# EL / JSTL
## EL
- JSP에서 파라미터 값을 메소드 없이 바로 전달받을 수 있음
- *${}* 형식
- *속성 이름으로 값을 가져올 경우 우선순위가 페이지-세션-어플리케이션 순*

### **param**
- 파라미터 값을 가져옴
```jsp
<h2>
name: ${param.name} <!-- ?name= -->
address: ${param.address} <!-- ?address= -->
</h2>
```

### paramValues
- form의 input 등의 value 값을 가져옴
```jsp
<h2>
${paramValues["pet"][0]} <br> <!-- 강아지 -->
${paramValues["pet"][1]} <br> <!-- 고양이 -->
${paramValues["pet"][2]} <br> <!-- 돼지 -->
</h2>
```

### requestScope
- 리퀘스트 속성 값을 가져옴
- 설정한 속성 이름으로도 가져올 수 있음
```jsp
EL request scope: ${requestScope.scope} <br>
EL scope: ${scope}
```

### sessionScope
- 세션 속성 값을 가져옴
- 설정한 속성 이름으로도 가져올 수 있음
```jsp
EL session scope: ${sessionScope.scope} <br>
EL scope: ${scope}
```

## JSTL
