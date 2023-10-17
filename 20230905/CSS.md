# CSS
CSS는 HTML의 요소를 꾸며주는 역할

위치, 색깔, 애니메이션 등을 설정할 수 있음

<style></style> 부분에서 작성하거나 css 파일로 작성하여 링크로 연동

#### 와일드카드 사용법
```html
<style>
* {color: red;}
h1 {color: green;}
p {background-color: brown;}
#header {width: 800px; margin: 0 auto; background-color: red;}
.content {width: 800px; margin: 0 auto; background-color: red;}
#header h1 {color: blue;} /* ",":or , " ": (후손-자식, 손자 포함)*/
#header > p {font-weight: bold;} /* ">": (바로 앞 후손-자식 한정) */
</style>

<body>
    <h1>Hello
    <p>Hello!
    <div id="header">
        <p>Hello!!
    </div>
    <div class="content">
        <p>Hello!!!
    </div>
</body>
```
- *는 전체를 선택
- h1, p 등의 요소를 입력하면 해당하는 요소 전체가 적용됨
- #으로 시작하는 경우 해당하는 id를, .으로 시작하는 경우 해당하는 class를 가진 요소만 적용됨
- 공백이나 , 또는 ">"를 사용해 자식 요소를 선택 가능

