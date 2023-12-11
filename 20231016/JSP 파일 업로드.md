# JSP 파일 업로드
## pom.xml 설정
```xml
<dependencies>
	<dependency>
	    <groupId>com.jfinal</groupId>
	    <artifactId>cos</artifactId>
	    <version>2022.2</version>
	</dependency>
</dependencies>
```

## HTML
```html
<form name="fileForm" method="post" enctype="multipart/form-data"
action="fileUploadAction.jsp" onsubmit="return validateForm(this);"> <!-- onsubmit - submit 버튼 클릭 시 함수 실행 -->
    첨부파일 : <input type="file" name="attachedFile" /> <!-- 파일 첨부 -->
    <input type="submit" value="전송하기" />
</form>
```