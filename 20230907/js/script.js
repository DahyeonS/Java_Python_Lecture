/*
var a = 10;
var b = 20;
var c = 30;

// window.document.forms[0]
// console.log(a, b, c);
// console.log(this);
console.dir(this);
// alert(a);
*/

// 변수
o = 10; // 전역변수(지역변수가 아님)
var a = 10; // 지역변수가 아님
let b = 10; // 블록 단위에 들어가면 지역변수가 됨(권장)
const c = 10; // 상수

// 조건문
if (273 < 52) {
    console.log('273 < 52');
}

// 날짜 함수
const date = new Date();
const year = date.getFullYear();
const month = date.getMonth();
const day = date.getDay();
const hours = date.getHours();
const minutes = date.getMinutes();
const seconds = date.getSeconds();
/*
if (hours < 12) {
    console.log("오전");
}

if (hours >= 12) {
    console.log("오후");
}

if (hours < 12) {
    console.log("오전");
} else {
    console.log("오후");
}
*/
if (hours < 12) console.log("오전");
else console.log("오후");

// 하루 일정 출력
// Date 객체 선언
var date_ = new Date();
var hours_ = date_.getHours();

// 조건문
if (hours_ < 5) {
    console.log('잠을 자렴....');
} else if (hours_ < 7) {
    console.log('준비');
} else if (hours_ < 9) {
    console.log('출근');
} else if (hours_ < 12) {
    console.log('빈둥빈둥');
} else if (hours_ < 14) {
    console.log('식사');
} else {
    console.log('여러 가지 업무를 수행합니다.');
}


// 배열 생성과 배열 요소 접근
// 변수 선언
var array = ['가', '나', '다', '라'];

// 배열 요소 선언
array[0] = '윤';

console.log(array[0]);
console.log(array[1]);
console.log(array[2]);
console.log(array[3]);

// 배열 요소 개수
array = [10, 20, 30, 40, 50];
console.log(array.length);

// 반복문
array = ['가', '나', '다'];
for (var i=0; i<3; i++) console.log(i + "번째 출력: " + array[i])

var output = 0;
for (var i=0; i<=100; i++) output += i;
console.log(output);