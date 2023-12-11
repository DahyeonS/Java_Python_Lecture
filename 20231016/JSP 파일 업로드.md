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
<form name="fileForm" method="post" enctype="multipart/form-data" action="fileUploadAction.jsp" onsubmit="return validateForm(this);">
    첨부파일 : <input type="file" name="attachedFile" />
    <input type="submit" value="전송하기" />
</form>
```