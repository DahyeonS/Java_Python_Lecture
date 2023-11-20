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
- *p, p1, p2, p3...* - 단락
```html
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
<p2>Integer nibh tellus, tristique quis blandit quis, consequat in nunc.</p>
```
- *img* - 이미지 삽입
```html
<img src="./daum.png"> <!--src에 들어갈 링크/파일명 등 들어갈 이미지 입력-->
<h2>절대 경로 img</h2>
<img src="/imgs/dog/dog1.jpg">
<img src="/imgs/cat/cat1.jpg">
<h2>상대 경로 img</h2>
<img src="./imgs/dog/dog2.jpg">
<img src="./imgs/cat/cat2.jpg">
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
<a href="http://127.0.0.1:5500/html/text_content.html">content</a> <!--절대경로-->
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
- *table* - 테이블(도표)
> - thead - 테이블의 head 부분(제목 등)
> - tbody - 테이블의 body 부분(내용물)
> - tr - 테이블의 열(가로줄)
> - th - 열의 제목
> - td - 열의 내용
> 
> *rowspan* - 행을 합침
> 
> *colspan* - 열을 합침
```html
<table border="1">
    <thead>
        <tr>
            <th></th>
            <th>월</th>
            <th>화</th>
            <th>수</th>
            <th>목</th>
            <th>금</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1교시</td>
            <td>영어</td>
            <td>국어</td>
            <td>과학</td>
            <td>미술</td>
            <td>기술</td>
        </tr>
    </tbody>
</table>
```

- *audio* - 오디오(음원) 삽입
```html
<audio src="https://rintiantta.github.io/academy-html/example/chapter_3/Kalimba.mp3" controls="controls"></audio>
```

- *video* - 비디오 삽입
```html
<video width="320" controls="controls" poster="http://placehold.it/320x180">
    <source src="https://rintiantta.github.io/academy-html/example/chapter_3/Wildlife.mp4" type="video/mp4">
</video>
```

- *form* - 폼 서식(다른 페이지로 값 전달 가능)
- *input* - 입력 기능
- *select* - 선택지 기능
```html
<form method="post" name="sform" id="sform"> <!-- method는 전달 방식(get, post) -->
    <input type="text" name="id" value=""><br> <!-- 텍스트 형식 --> <!-- value는 입력 값 -->
    <input type="password" name="password" value=""><br> <!-- 비밀번호 형식(입력 값이 마스킹됨) -->
    <input type="file" name="" value=""><br> <!-- 파일 형식 -->
    <input type="hidden" name="" value="비밀"><br> <!-- 숨겨짐 -->
    <input type="button" value="전송하기" onclick="check();"><br> <!-- 버튼 형식 -->
    <input type="reset" value="초기화"><br> <!-- 초기화 버튼 형식 -->
    <input type="submit" name="제출하기"><br> <!-- 제출 버튼 형식(클릭 시 입력 값을 다른 페이지로 전송) -->
    <input type="image" src="../imgs/cat/cat1.jpg"> <!-- 이미지 형식 -->
    <input id="man" type="radio" name="gender" value="m"> <!-- 선택지 버튼 형식 -->
    <label for="man">남자</label> <!-- 선택지의 이름 -->
    <input id="dog" type="checkbox" name="animal" value="d"> <!-- 체크박스 형식 -->
    <label for="dog">개</label> <!-- 체크박스의 이름 -->
    <select name="choice" multiple="multiple"> <!-- multiple은 스크롤 없이 전체를 보여줌 -->
        <option value="1">김밥</option> <!-- 선택지의 단위 -->
        <option value="2">떡볶이</option>
        <option value="3">순대</option>
        <option value="4">어묵</option>
    </select>
    <select>
        <optgroup label="html5"> <!-- 선택지들을 그룹으로 묶음 -->
            <option value="">M</option>
            <option value="">C</option>
            <option value="">D</option>
        </optgroup>
        <optgroup label="CSS3">
            <option value="">A</option>
            <option value="">3D</option>
        </optgroup>
    </select>
    <select onchange="location.href=this.value;"> <!-- onchange는 선택 시 작동(현재 "window.open(this.value);"와 같은 기능) -->
        <option>==select==</option>
        <option value="http://www.naver.com">naver</option>
        <option value="http://www.google.com">google</option>
    </select>
</form>
```

- *textarea* - 긴 텍스트 입력
```html
<textarea cols="50" rows="10">
        abcdabcd
</textarea>
```

- *pre* - 사용자가 입력한 그대로 문자를 출력
- *code* - 프로그래밍 언어 코드를 출력
```html
<pre>
    <code>
        aaaa
        bbbb
        cccc
        dddd
    </code>
</pre>
```

- *div* - 요소를 나누는 파트
```html
<div>
    <h1>HTML Basic</h1>
</div>
```

- *header* - 컨텐츠의 제목, 헤더
- *nav* - div와 비슷하나, 탐색 등의 네비게이션 요소를 정의할 때 사용
- *main* - 본격적인 컨텐츠가 담긴 부분
- *section* - 컨텐츠의 일반적인 섹션
- *article* - 컨텐츠에 포함된 독립적인 섹션(잡지, 신문, 논문, 에세이, 블로그 등)
- *footer* - 컨텐츠의 밑부분(저자, 링크, 저작권 정보 등을 표시)
```html
<header>
    <h1>HTML Basic</h1>
</header>
<nav>
    <ul>
        <li><a href="#">menu 1</a></li>
        <li><a href="#">menu 2</a></li>
        <li><a href="#">menu 3</a></li>
    </ul>
</nav>
<main>
    <section>
        <article>
            <h1>Lorem ipsum dolor sit amet</h1>
        </article>
        <article>
            <h1>Lorem ipsum dolor sit amet</h1>
        </article>
    </section>
</main>
<footer>
    <span>서울특별시 강서구 내발산동</span>
</footer>
```