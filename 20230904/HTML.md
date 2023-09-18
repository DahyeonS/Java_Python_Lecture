# HTML
웹 문서
- *head* - 페이지 상단 페이지명
- *body* - 페이지 안에 들어갈 내용물
- *style* - 페이지 내용물을 꾸며주는 곳(폰트, 글씨 위치, 색깔 등), css파일로 연동하여 적용 가능
- *script* - 페이지 내용물에 적용하는 스크립트(javascirpt가 기본값), js파일로 연동하여 적용 가능
```html
<!DOCTYPE html>
<html lang="ko">
<head> <!--부모태그--> <!--제목(탭 이름)-->
    <meta charset="UTF-8">
    <title>페이지 이름</title> <!--자식태그-->
</head> <!--부모태그 끝-->
<body> <!--내용-->
    <h1>Hello World!!</h1>
</body>
</html>
```
- *h1, h2, h3...* - 소제목(숫자가 커질 수록 크기가 작아짐)
```html
<h1>가장 중요한 제목</h1>
<h2>그 다음 중요한 제목</h2>
<h3>그 그다음 중요한 제목</h3>
```
- *p1, p2, p3...* - 단락
```html
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
<p2>Integer nibh tellus, tristique quis blandit quis, consequat in nunc.</p>
```
- *img* - 이미지 삽입
```html
<img src="./daum.png"> <!--src에 들어갈 링크/파일명 등 들어갈 이미지를 넣음-->
```
- *hr* - 줄 바꿈
- *br* - 구분선 추가
- *a* - 하이퍼링크
