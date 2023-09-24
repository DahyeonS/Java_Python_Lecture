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
<img src="./daum.png"> <!--src에 들어갈 링크/파일명 등 들어갈 이미지 입력-->
```
- *hr* - 구분선 추가
- *br* - 줄 바꿈
```html
<h1>홍차</h1>
<hr> <!--구분선 추가-->
<h2>정의</h2>
<p>홍차는 백차, 녹차, 우롱차보다 더 많이 발효된 차의 일종이다.</p>
<br> <!--줄 바꿈-->
```
- *a* - 하이퍼링크
```html
<!--href에 링크 입력-->
<a href="http://naver.com">네이버</a><br>
<a href="http://daum.net">다음</a>
<!--href에 파일 위치 입력-->
<a href="/html/text_content.html">content</a> <!--절대경로-->
<a href="../html/text_content.html">content</a> <!-- 상대경로 -->
```
- *b* - 굵게(볼드체)
```html
<b>Lorem ipsum dolor sit amet</b>
```
- *i* - 기울게(이탤릭체)
```html
<i>Lorem ipsum dolor sit amet</i>
```
- *small* - 작게
```html
<small>Lorem ipsum dolor sit amet</small>
```
- *sub* - 작게(아래로 이동)
```html
Lorem ipsum dolor <sub> sit amet</sub>
```
- *sup* - 작게(위로 이동)
```html
Lorem ipsum dolor <sup> sit amet</sup>
```
- *ins* - 밑줄
```html
<ins>Lorem ipsum dolor sit amet</ins>
```
- *del* - 취소선
```html
<del>Lorem ipsum dolor sit amet</del>
```
- *ul* - 글머리 기호
```html
<ul id="store" class="fruit"> <!--순서 없음-->
        <li>사과</li>
        <li>바나나</li>
        <li>오렌지</li>
</ul>
```
- *ol* - 번호 매기기
```html
<ol id="store" class="fruit"> <!--순서 있음-->
        <li>사과</li> <!--1번-->
        <li>바나나</li> <!--2번-->
        <li>오렌지</li> <!--3번-->
</ol>
```
