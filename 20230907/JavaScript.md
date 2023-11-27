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

// 키-값
const obj = {
    a: 1,
    b: 2,
    c: 3
};

console.log(obj.a);
console.log(obj['b']);

for (let key in obj) console.log(key, obj[key]);
```