// 01
/*
console.log('Hello JavaScript!');
console.log(1 + 2 + 3 + 4);

console.log('안녕하세요!');
console.log('JavaScript를 배워봅시다');
*/

// 02
/*
let value = 1;
console.log(value);
value = 2;
console.log(value);
// let value = 2;

const a = 1;
// a = 2;
*/
/*
let value = 1;
let text = 'hello';
let name = '자봐스크립트';
let good = true;
let loading = false;

const friend = null;
let criminal; // undefined
console.log(criminal);
*/

// 03
/*
let value = 1; // 변수 선언
value = 2; // 대입 연산자

let a = 1 + 2;
console.log(a); // 3

let a = 1 + 2 - (3 * 4) / 4;
console.log(a); // 0

let a = 1;
a++;
++a;
console.log(a); // 3

let a = 1;
console.log(a++); // 1
console.log(++a); // 3

let a = 1;
a--;
console.log(a); // 0

let a = 1;
a = a + 3; 
console.log(a); // 4

let a = 1;
a += 3;
console.log(a); // 4

let a = 1;
a += 3;
a -= 3;
a *= 3;
a /= 3;
console.log(a); // 1

const a = !true;
console.log(a); // false

const b = !false;
console.log(b); // true

const a = true && true;
console.log(a); // true

let f  = false && false; // false
f = false && true; // false
f = true && false; // false

let t = true || false; // true
t = false || true; // true
t = true || true; // true
let f = false || false; // false

const value = !((true && false) || (true && false) || !false); // !(false || false || true) -> !(true)
console.log(value); // false

const a = 1;
const b = 1;
const equals = a === b;
console.log(equals); // true

const a = 1;
const b = 1;
const equals = a == b;
console.log(equals); // true(타입검사 X)

const a = 1;
const b = '1';
const equals = a == b;
console.log(equals); // true

const a = 0;
const b = false;
const equals = a == b;
console.log(equals); // true

const a = null;
const b = undefined;
const equals = a == b;
console.log(equals); // true

const value = 'a' !== 'b'; // true

console.log(1 != '1'); // false
console.log(1 !== '1'); // true

const a = 10;
const b = 15;
const c = 15;

console.log(a < b); // true
console.log(b > a); // true
console.log(b >= c); // true
console.log(a <= c); // true
console.log(b < c); // false

const a = '안녕';
const b = '하세요';
console.log(a + b); // 안녕하세요
*/

// 04
/*
const a = 1;
if (a + 1 === 2) console.log('a + 1이 2입니다.');

const a = 0;
if (a + 1 === 2) console.log('a + 1이 2입니다.');

const a = 1;
if (true) {
    const a = 2;
    console.log('if문 안의 a 값은 ' + a);
}
console.log('if문의 밖의 a 값은 ' + a);

const a = 10;
if (a > 15) console.log('a가 15보다 큽니다.');
else console.log('a가 15보다 크지 않습니다.');

// const a = 10;
// const a = 5;
const a = 7;
if (a === 5) console.log('5입니다!');
else if (a === 10) console.log('10입니다!');
else console.log('5도 아니고 10도 아닙니다.');

// const device = 'iphone';
// const device = 'ipad';
// const device = 'galaxy note';
const device = 'macbook';
switch (device) {
    case 'iphone': console.log('아이폰!'); break;
    case 'ipad': console.log('아이패드!'); break;
    case 'galaxy note': console.log('갤럭시 노트!'); break;
    default: console.log('모르겠네요..');
}
*/

// 05
/*
const a = 1;
const b = 2;
const sum = a + b;
console.log(sum); // 3

function add(a, b) {
    return a + b;
}
const sum = add(1, 2);
console.log(sum); // 3

function add(a, b) {
    return a + b;
    console.log('호출이 되지 않는 코드!');
}
const sum = add(1, 2);
console.log(sum); // 3

function hello(name) {
    console.log('Hello, ' + name + '!');
}
hello('velopert'); // Hello, velopert

function hello(name) {
    console.log(`Hello, ${name}`);
}
hello('velopert'); // Hello, velopert

function getGrade(score) {
    if (score === 100) return 'A+';
    else if (score >= 90) return 'A';
    else if (score === 89) return 'B+';
    else if (score >= 80) return 'B';
    else if (score === 79) return 'C+';
    else if (score >= 70) return 'C';
    else if (score === 69) return 'D+';
    else if (score >= 60) return 'D';
    else 'F';
}
const grade = getGrade(90);
console.log(grade); // A

const add = (a, b) => {
    return a + b;
}
console.log(add(1, 2)); // 3

const add = (a, b) => a + b;
console.log(add(1, 2)); // 3

const getGrade = score => {
    if (score === 100) return 'A+';
    else if (score >= 90) return 'A';
    else if (score === 89) return 'B+';
    else if (score >= 80) return 'B';
    else if (score === 79) return 'C+';
    else if (score >= 70) return 'C';
    else if (score === 69) return 'D+';
    else if (score >= 60) return 'D';
    else return 'F';
}
const grade = getGrade(90);
console.log(grade); // A
*/
// 06

const dog = {
    name: '멍멍이',
    age: 2
};
console.log(dog.name); // 멍멍이
console.log(dog.age); // 2

const sample = {
    'key with space': true
}
console.log(sample["key with space"]); // true

const ironMan = {
    name: '토니 스타크',
    actor: '로버트 다우니 주니어',
    alias: '아이언맨'
}
const captainAmerica = {
    name: '스티브 로저스',
    actor: '크리스 에반스',
    alias: '캡틴 아메리카'
}
console.log(ironMan); // { name: '토니 스타크', actor: '로버트 다우니 주니어', alias: '아이언맨' }
console.log(captainAmerica); // { name: '스티브 로저스', actor: '크리스 에반스', alias: '캡틴 아메리카' }