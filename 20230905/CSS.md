# CSS
CSS는 HTML의 요소를 꾸며주는 역할

위치, 색깔, 애니메이션 등을 설정할 수 있음

<style></style> 부분에서 작성하거나 css 파일로 작성하여 링크로 연동

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
        li:first-child { border-radius: 10px 0 0 10px; } /* 첫번째 자식 선택자만 적용 */
        li:last-child { border-radius: 0 10px 10px 0; } /* 마지막 자식 선택자만 적용 */
        li:nth-child(2n) { background-color: #FF0003; } /* 짝수 자식 선택자만 적용 */
        li:nth-child(2n+1) { background-color:#800000; } /* 홀수 자식 선택자만 적용 */
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

## 크기와 패딩 조정
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
- **margin은 객체의 외부 여백**