# JSP 파일 처리
### pom.xml 설정
```xml
<dependencies>
	<dependency>
	    <groupId>com.jfinal</groupId>
	    <artifactId>cos</artifactId>
	    <version>2022.2</version>
	</dependency>
</dependencies>
```

## 파일 업로드
### HTML
```html
<form name="fileForm" method="post" enctype="multipart/form-data"
action="fileUploadAction.jsp" onsubmit="return validateForm(this);"> <!-- onsubmit - submit 버튼 클릭 시 함수 실행 -->
    첨부파일 : <input type="file" name="attachedFile" /> <!-- 파일 첨부 -->
    <input type="submit" value="전송하기" />
</form>
```

### Java
1. 변수 설정
```java
String saveDirectory = application.getRealPath("/file-uploads");  // 저장할 디렉토라
int maxPostSize = 1024 * 1000;  // 파일 최대 크기(1MB)
String encoding = "UTF-8";  // 인코딩 방식
```
2. Try / Catch 문으로 실행
```java
try {
    // 1. MultipartRequest 객체 생성
    MultipartRequest mrequest = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);

    // 2. 새로운 파일명 생성
    String fileName = mrequest.getFilesystemName("attachedFile");  // 현재 파일 이름(요청받은 파라미터 값)
    String ext = fileName.substring(fileName.lastIndexOf("."));  // 파일 확장자
    String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date()); // 년월일_시분초
    String newFileName = now + ext;  // 새로운 파일 이름("업로드일시.확장자")

    // 3. 파일명 변경
    File oldFile = new File(saveDirectory + File.separator + fileName);
    File newFile = new File(saveDirectory + File.separator + newFileName);
    oldFile.renameTo(newFile);

    // 4. 다른 폼값 받기
    String name = mrequest.getParameter("name");
    String title = mrequest.getParameter("title");
    String[] cateArray = mrequest.getParameterValues("cate");
    StringBuffer cateBuf = new StringBuffer();
    if (cateArray == null) cateBuf.append("선택 없음");
    else {
        for (String s : cateArray) cateBuf.append(s + ", ");
    }

    // 5. DTO 생성
    MyfileDTO dto = new MyfileDTO();
    dto.setName(name);
    dto.setTitle(title);
    dto.setCate(cateBuf.toString());
    dto.setOfile(fileName);
    dto.setSfile(newFileName);

    // 6. DAO를 통해 데이터베이스에 반영
    MemberDAO dao = new MemberDAO();
    dao.insertFile(dto);

    // 7. 파일 목록 JSP로 리다이렉트
    response.sendRedirect("fileList.jsp");
}
// 처리 실패 시
catch (Exception e) {
    e.printStackTrace();
    request.setAttribute("errorMessage", "파일 업로드 오류");
    request.getRequestDispatcher("fileUpload.jsp").forward(request, response); // 돌아가기
}
```

## 파일 다운로드
### JSP
1. 변수 설정
```jsp
<%
    String saveDirectory = application.getRealPath("/file-uploads"); // 저장한 파일 경로
    String saveFilename = request.getParameter("sName"); // 저장한 파일명
    String originalFilename = request.getParameter("oName"); // 저장한 파일명 원본
%>
```
2. Try / Catch 문으로 실행
```jsp
<%
    try {
        // 1. 파일을 찾아 입력 스트림 생성
        File file = new File(saveDirectory, saveFilename); // 저장한 파일 불러오기
        InputStream inStream = new FileInputStream(file); // 입력 스트림 생성
        
        // 2. 한글 파일명 깨짐 방지
        String client = request.getHeader("User-Agent");
        if (client.indexOf("WOW64") == -1) originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
        else originalFilename = new String(originalFilename.getBytes("KSC5601"), "ISO-8859-1");
    
        // 3. 파일 다운로드용 응답 헤더 설정 
        response.reset();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFilename + "\""); // 파일 이름
        response.setHeader("Content-Length", "" + file.length()); // 파일 크기
        
        // 4. 입력 스트림 초기화
        out.clear();
        
        // 5. response 내장 객체로부터 새로운 출력 스트림 생성
        OutputStream outStream = response.getOutputStream();

        // 6. 출력 스트림에 파일 내용 출력
        byte b[] = new byte[(int)file.length()];
        int readBuffer = 0;    
        while ((readBuffer = inStream.read(b)) > 0) outStream.write(b, 0, readBuffer);

        // 7. 입/출력 스트림 닫음
        inStream.close(); 
        outStream.close();
    }
    // 처리 실패 시
    catch (FileNotFoundException e) {
%>
        <script>
            alert("파일을 찾을 수 없습니다.");
            history.back();
        </script>		
<%    
    }
    catch (Exception e) {
%>
        <script>
            alert("예외가 발생하였습니다.");
            history.back();
        </script>		
<%    
    }
%>
```