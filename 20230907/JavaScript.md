# JavaScript

## 출력
```javascript
console.log(this);
```

### 알림창
```javascript
alert(Hello!);
```

## 변수 선언
- var - 선언과 동시에 undefined로 초기화, 재할당 가능, 중복 선언 가능
- let - 중복 선언이 불가능한 변수(재할당 가능), 선언과 초기화가 분리되어 있음
- const - 재할당이 불가능한 상수
```javascript
var a = 10;
let b = 20;
const c = 30;
```

### 날짜형 변수
```javascript
const date = new Date();
const year = date.getFullYear(); // 연
const month = date.getMonth(); // 월
const day = date.getDay(); // 일
const hours = date.getHours(); // 시
const minutes = date.getMinutes(); // 분
const seconds = date.getSeconds(); // 초
```

### 배열
```javascript
// 변수 선언
let array = ['가', '나', '다', '라'];

// 배열 요소 선언
array[0] = '윤';

console.log(array[0]); // 윤
console.log(array[1]); // 나
console.log(array[2]); // 다
console.log(array[3]); // 라

// 배열 요소 개수
console.log(array.length); // 4

// ...
const nums = [1, 2, 3, 4, 5];
const anotherNums = [...nums, 1000, ...nums]; // [1, 2, 3, 4, 5, 1000, 1, 2, 3, 4, 5]
```

## 조건문
```javascript
if (hours < 12) {
    console.log("오전");
} else {
    console.log("오후");
}

if (hours < 12) console.log("오전");
else console.log("오후");
```

## 반복문
```javascript
let output = 0;
for (let i=0; i<=100; i++) output += i; // 1부터 100까지의 합
console.log(output); // 5050

const items = ['item1', 'item2', 'item3'];

// forEach: Array
items.forEach(function(item) {
    console.log(item);
});

// for of
for (let i of items) console.log(i);

// for in
for (let i in items) console.log(i); // 인덱스값 호출
for (let i in items) console.log(items[i]); // 값 호출
```

## 함수 호출
```javascript
// 첫번째 방법
// func(); // 함수 호출(선언하지 않으면 오류)
const func = function() {
    console.log("func() called");
};
func(); // 함수 호출

// 두번째 방법(호이스팅 가능)
func2(); // 선언하지 않아도 작동
function func2() {
    console.log("func2() called");
};
func2();

function f(x = 1, y = 1) { // 자료형 없이 매개변수 선언
    return x * x;
}

console.log(f(3)); // 매개변수 개수가 달라도 작동

// 콜백 함수
function callTenTimes(callback) {
    for (let i=0; i<10; i++) callback();
};

const callback = function() {
    console.log('callback() called');
};

callTenTimes(callback);
```

### 객체
```javascript
const obj = {
    a: 1,
    b: 2,
    c: 3
}; // 객체 선언

console.log(obj.a); // 1
console.log(obj['b']); // 2

for (let key in obj) console.log(key, obj[key]);

const obj = {
    a: 1,
    b: 2,
    c: 3,
    getAge: function() {
        return this.a;
    }
};

var person = {
    name: '윤인성',
    eat: function(food) {
        console.log(this.name + '이 ' + food + '을/를 먹습니다.');
    }
};
person.eat('밥');
```

## 선택자
- name으로 선택
```javascript
const form = document.checkForm;
const checkId = form.checkId;
checkId.value = 'hong'; // checkID의 값을 채움
```

- id로 선택
```javascript
document.getElementById("checkId").value = 'hong2';
document.getElementById("checkForm").style.display = 'none';
```

- jquery dom library
```javascript
$('#checkId').val('hong3'); // $(선택자).함수;
$('#checkForm').hide();
$('#checkForm').show();
```

- querySelector
```javascript
const userid = document.querySelector('#userid');
document.querySelector('#checkId').value = 'hong4';
document.querySelector('h1').style.backgroundColor = 'red';
```

### 스타일 변경
```javascript
// 내장 함수
window.onload = function() {
    document.querySelector('h1').style.backgroundColor = 'red';
    document.querySelector('h2').style.color = 'green';
};

window.onload = function() {
    $("h1").css("backgroundColor", "yellow");
    $("h2").css("color", "yellow");
};

// jquery 함수
$(document).ready(function(){
    document.querySelector('h1').style.backgroundColor = 'yellow';
    document.querySelector('h2').style.color = 'green';
});

$(document).ready(function(){
    $("h1").css("backgroundColor", "yellow");
    $("h2").css("color", "yellow");
});

// jquery 함수(단축)
$(function(){
    document.querySelector('h1').style.backgroundColor = 'yellow';
    document.querySelector('h2').style.color = 'green';
});

$(function(){
    $("h1").css("backgroundColor", "yellow");
    $("h2").css("color", "yellow");
});
```

### HTML 적용
```javascript
window.onload = function() {
    let tr = '';
    tr += '<tr>';
    tr += '<td>1</td><td>2</td><td>3</td>';
    tr += '</tr>';

    const table = document.querySelector('#list');
    table.innerHTML = tr;
};

$(function() {
    $('h1').css('background','red');
    $('h1').css('color', 'orange');
    $('h1').html('From JavaScript');
    
    let tr = '';
    tr += '<tr>';
    tr += '<td>1</td><td>2</td><td>3</td>';
    tr += '</tr>';

    $('#list').html(tr);;
});
```

## 객체 클래스 상속
```javascript
// 생성자 선언
function Animal(type, name, sound) {
    this.type = type;
    this.name = name;
    this.sound = sound;
};

// 생성자 추가
Animal.prototype.say = function() {
    console.log(this.sound);
};

function Dog(name, sound) {
    Animal.call(this, '개', name, sound);
};
Dog.prototype = Animal.prototype;

const dog = new Dog('멍멍이', '멍멍');
dog.say(); // 멍멍

// 클래스 상속
class Animal2 {
    constructor(type, name, sound) {
        this.type = type;
        this.name = name;
        this.sound = sound;
    };

    say() {
        console.log(this.sound);
    };
};

const dog2 = new Animal2('dog', '멍멍이', '멍멍');
dog2.say(); // 멍멍

class Dog2 extends Animal2 {
    constructor(name, sound) {
        super('개', name, sound);
    };
};

const dog3 = new Dog2('댕댕이', '댕댕');
dog3.say(); // 댕댕
```

## 이벤트 함수
```javascript
// onload 함수
window.onload = function() {
    const btn4 = document.querySelector('#btn4')
    btn4.onclick = function() {
        document.querySelector("#cnt").innerHTML = 1000;
    };
    
    const btn5 = document.querySelector('#btn5')
    btn5.addEventListener('click', function() {
        document.querySelector("#cnt").innerHTML = 10000;
    });

    const divBox = document.querySelector('#box');
    divBox.addEventListener('click', function(e) {
        console.dir(e);
    });
};

// JQuery
$(function() {
    let cnt = 0;
    $('#btn1').click(function() {
        $(this).text(++cnt);
        $('#cnt').text(cnt);
    });

    $("#box").css({
        width: 100,
        height: 100,
        background: 'orange'
    })
    .on('click', function(e) {
        $(this).css('background', 'red');
    })
    .on('mouseenter', function(e) {
        $(this).css('background', 'blue');
    })
    .on('mouseleave', function(e) {
        $(this).css('background', 'orange');
    });
});
```

## 범위
함수 내에서 선언한 변수는 함수 내에서만 적용
```javascript
function func() {
    a = 10;
}
var a = 100;
console.log(a); // 100

function outerFunc() {
    var x = 10;
    var innerFunc = function() {console.log(x)};
    return innerFunc
}
var inner = outerFunc();
inner(); // 10
```

## 억음 부호
```javascript
const first = 'hong';
const last = 'gildong';

let tr = '<tr><td>' + first + '</td><td>' + last + '</td></tr>';
let tr2 = `<tr><td>${first}</td><td>${last}</td></tr>`

console.log(tr); // <tr><td>hong</td><td>gildong</td></tr>
console.log(tr2); // <tr><td>hong</td><td>gildong</td></tr>

const ironMan = {
    name: '토니 스타크',
    actor: '로버트 다우니 주니어',
    alias: '아이언맨'
};

function print({name, actor, alias}) {
    const text = `${alias}(${name}) 역할을 맡는 배우는 ${actor}입니다`;
    console.log(text); // 아이언맨(토니 스타크) 역할을 맡는 배우는 로버트 다우니 주니어입니다
};
```

## 화살표 함수
```javascript
const pow = function(x) {return x*x};
console.log(pow(10)); // 100

const pow2 = x => x*x;
console.log(pow2(100)); // 10000

const arr = [1, 2, 3];
let pow3 = arr.map(function(x) {
    return x*x;
});
console.log(pow3); // [1, 4, 9]

let pow4 = arr.map(x => x*x);
console.log(pow4); // [1, 4, 9]

$(function() {
    $('#dog1').on('click', () => { // 클릭 시 실행
        loadImg(0);
    });
});
```