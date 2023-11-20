# CSS
CSS는 HTML의 요소를 꾸며주는 역할

위치, 색깔, 애니메이션 등을 설정할 수 있음

style 태그에서 작성하거나 css 파일로 작성하여 링크로 연동

## 선택자 사용법
```html
<head>
    <style>
        * {color: red;}

        h1 {color: green;}
        p {background-color: brown;}

        #header {width: 800px; margin: 0 auto; background-color: red;}
        .content {width: 800px; margin: 0 auto; background-color: red;}

        #header h1 {color: blue;} /* ",":or , " ": (후손-자식, 손자 포함)*/
        #header > p {font-weight: bold;} /* ">": (바로 앞 후손-자식 한정) */

        input:enabled {background-color: aquamarine;} /* 해당 input이 사용 가능할 때만 적용 */
        li:first-child {border-radius: 10px 0 0 10px;} /* 첫번째 자식 선택자만 적용 */
        li:last-child {border-radius: 0 10px 10px 0;} /* 마지막 자식 선택자만 적용 */
        li:nth-child(2n) {background-color: #FF0003;} /* 짝수 자식 선택자만 적용 */
        li:nth-child(2n+1) {background-color:#800000;} /* 홀수 자식 선택자만 적용 */
    </style>
</head>

<body>
    <h1>Hello
    <p>Hello!
    <div id="header">
        <p>Hello!!
    </div>
    <div class="content">
        <p>Hello!!!
    </div>
    <input>
    <li>첫 번째</li>
    <li>두 번째</li>
    <li>세 번째</li>
    <li>네 번째</li>
    <li>다섯 번째</li>
</body>
```
- *는 전체를 선택하는 와일드카드
- h1, p 등의 요소를 입력하면 해당하는 요소 전체가 적용됨
- #으로 시작하는 경우 해당하는 id를, .으로 시작하는 경우 해당하는 class를 가진 요소만 적용됨
- 공백이나 , 또는 ">"를 사용해 자식 요소를 선택 가능
- :는 상태 또는 구조를 선택

## 스타일 설정
### 선, 색, 크기와 여백 조정
```html
<head>
    <style>
        .tmp {
            background-color: red; /* 배경색 - 빨강 */
            width: 100px; height: 100px; /* 100px 크기의 정사각형 */
            border-radius: 50px 25px 50px 24px; /* 순서는 반시계방향(위 - 오른쪽 - 아래 - 왼쪽) */
        }
    </style>
</head>

<body>
    <div class="tmp">d</div>
</body>
```
- color(글자)나 background-color(바탕)으로 색깔을 설정
- width는 너비, height는 높이
- border-radius는 외곽선의 둥근 정도

```html
<head>
    <style>
        .box {
            width: 100%;
            border-width: thick; /* 윤곽선을 굵게 */
            border-style: dashed; /* 점선 */
            border-color: black; /* 검은 선 */
            border-radius: 20px;
            margin-bottom: 20px; /* 외부 여백 */
        }
    </style>
</head>
<body>
    <div class="box">
        <h1>Lorem ipsum dolor amet</h1>
    </div>
</body>
```
- border는 윤곽선 설정
- **margin은 객체(대상)의 외부 여백**
- **padding은 객체(대상)의 내부 여백**

### 표시 유무
```html
<head>
    <style>
        #box {display: none;} /* 보이지 않음 */
        #box {display: block;} /* 다른 요소들과 다른 줄에서 보여줌 */
        #box {display: inline;} /* 다른 요소들과 같은 줄에서 보여줌 */
    </style>
</head>
<body>
    <span>더미 객체</span>
    <div id="box">대상 객체</div>
    <span>더미 객체</span>
</body>
```
- display는 대상을 보여주는 방식을 설정

### 배경에 이미지 삽입
```html
<head>
    <style>
        body {
            background-image: url(../imgs/cat/cat1.jpg); /* 배경 이미지 삽입 */
            background-repeat: no-repeat; /* 배경 이미지 반복 없음 */
            background-size: 100% 250px; /* 배경 이미지 크기 */
            background-attachment: scroll; /* 스크롤 시 배경 이미지도 같이 스크롤 */
            background-attachment: fixed; /* 스크롤 시에도 배경 이미지 고정 */
            background-position: bottom; /* 배경 이미지 위치(아래) */
            background-position: 0px 50%; /* 배경 이미지 위치(중앙) */
        }
    </style>
</head>
<body>
    
</body>
```

### 글씨 조정
```html
<head>
    <style>
        .a {font-size: 32px; font-family:'Lucida Sans';}
        .b {font-size: 2em; font-style: italic;}
        .c {font-size: large; font-weight: bold;}
        .d {font-size: small; text-align: right;}
        h1 {text-align: center;}
    </style>
</head>
<body>
    <h1>Lorem ipsum</h1>
    <p class="a">Lorem ipsum</p>
    <p class="b">Lorem ipsum</p>
    <p class="c">Lorem ipsum</p>
    <p class="d">Lorem ipsum</p>
</body>
```
- font 및 text로 글씨를 설정
- font-size는 글씨 크기
- font-family는 글씨체(여러 개 설정 가능)
- font-style은 기울기, font-weight는 굵기
- text-align은 글씨 정렬(왼쪽, 가운데, 오른쪽)

```html
<head>
    <style>
        .button {
            width: 150px;
            height: 70px;
            background-color: #FF6A00;
            border: 10px solid #FFFFFF;
            border-radius: 30px;
            box-shadow: 5px 5px 5px #A9A9A9;
        }

        .button > a {
            display: block;
            line-height: 70px;
        }
    </style>
</head>
<body>
    <div class="button">
        <a href="#">Click</a>
    </div>
</body>
```
- line-height는 글씨의 높이 조정(도형의 높이와 같아야 가운데 정렬 가능)

```html
<head>
    <style>
        a {text-decoration: none;} /* 링크 밑줄 없음 */
    </style>
</head>
<body>
    <h1>
        <a href="#">Lorem ipsum dolor amet</a>
    </h1>
</body>
```
- a태그(링크)에서 text-decoration으로 밑줄 설정 가능(색깔은 color로 설정)

### 위치 설정
#### position
```html
<head>
    <style>
        .box {
            width: 100px; height: 100px;
            position: absolute; /* 부모 요소의 위치를 기준으로 삼음(여기서는 body) */
        }
        .box:nth-child(1) { /* 첫번째 상자 */
            background-color: red;
            left: 10px; top: 10px;
            z-index: 999; /* 맨 앞 */
        }
        .box:nth-child(2) { /* 두번째 상자 */
            background-color: green;
            left: 50px; top: 50px;
            z-index: 50; /* 빨강보다 뒤, 파랑보다 앞 */
        }
        .box:nth-child(3) { /* 세번째 상자 */
            background-color: blue;
            left: 90px; top: 90px;
        }
        body > div {
            width: 400px; height: 100px;
            border: 3px solid black; /* 3px 굵기의 검은 실선 */
            position: relative; /* 자식 요소의 기준점이 됨(여기서는 box 클래스 요소들) */
            overflow-y: scroll; /* 넘치는 부분은 스크롤을 이용해 보여줌 */
        }
    </style>
</head>
<body>
    <h1>Lorem ipusm dolor amet</h1>
    <div>
        <div class="box"></div>
        <div class="box"></div>
        <div class="box"></div>
    </div>
    <h1>Lorem ipusm dolor amet</h1>
</body>
```
- position, left, top, right, bottom으로 위치 설정
- z-index로 대상의 순서를 조정(숫자가 다른 대상보다 높을 수록 앞으로 나옴)
- overflow는 대상의 크기가 보여주는 범위를 초과했을 때 어떻게 처리할지 설정함

#### float
```html
<head>
    <style>
        .img {float: right;}
    </style>
</head>
<body>
    <img class="img" src="../imgs/cat/cat1.jpg">
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
</body>
```
- float는 화면 크기에 따라 자동으로 위치가 조정(오른쪽으로 설정할 경우 항상 오른쪽에 출력)

```html
<head>
    <style>
        .box {
            width: 100px; height: 100px;
            background-color: red;
            margin: 10px; padding: 10px;
            float: left; /* 왼쪽 수평 정렬 */
        }
    </style>
</head>
<body>
    <div class="box">1</div>
    <div class="box">2</div>
</body>
```
- float를 이용해 여러 대상을 한 줄에 수평으로 정렬 가능

### 그림자 설정
```html
<head>
    <style>
        .box {
            border: 3px solid black;
            box-shadow: 10px 10px 30px black;
        }
        h1 {
            text-shadow: 5px 5px 5px black;
        }
    </style>
</head>
<body>
    <h1>Lorem ipsum dolor amet</h1>
    <hr>
    <div class="box"></div>
</body>
```
- box-shadow 및 text-shadow를 이용해 상자 또는 그림자의 위치와 색상을 설정 가능

## *반응형 웹 설정*
```html
<head>
    <style>
        @media screen { /* 화면 출력 */
            body {background-color: black; color: white;}
        }

        @media print { /* 프린트 출력 */
            body {background-color: white; color: black;}
        }

        @media(max-width: 499px) { /* 스마트폰 화면 출력 */
            body{background: red;}
        }

        @media(max-width: 500px) and (max_width: 799px){ /* 태블릿 pc 화면 출력 */
            body{background: green;}
        }

        @media(min-width: 800px) { /* 데스크톱 화면 출력 */
            body {background: blue;}
        }
    </style>
</head>
<body>
    <h1>Lorem ipsum dolor sit amet</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
</body>
```
- @media를 이용해 여러 가지 기종들에 맞춘 화면을 출력할 수 있음