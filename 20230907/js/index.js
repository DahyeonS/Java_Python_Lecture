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
/*
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

function print(hero) {
    const text = `${hero.alias}(${hero.name}) 역할을 맡은 배우는 ${hero.actor}입니다.`;
    console.log(text);
}
print(ironMan); // 아이언맨(토니 스타크) 역할을 맡은 배우는 로버트 다우니 주니어입니다.
print(captainAmerica); // 캡틴 아메리카(스티브 로저스) 역할을 맡은 배우는 크리스 에반스입니다.

function print(hero) {
    const {alias, name, actor} = hero;
    const text = `${alias}(${name}) 역할을 맡은 배우는 ${actor}입니다.`;
    console.log(text);
}
print(ironMan); // 아이언맨(토니 스타크) 역할을 맡은 배우는 로버트 다우니 주니어입니다.
print(captainAmerica); // 캡틴 아메리카(스티브 로저스) 역할을 맡은 배우는 크리스 에반스입니다.

function print({alias, name, actor}) {
    const text = `${alias}(${name}) 역할을 맡은 배우는 ${actor}입니다.`;
    console.log(text);
}
print(ironMan); // 아이언맨(토니 스타크) 역할을 맡은 배우는 로버트 다우니 주니어입니다.
print(captainAmerica); // 캡틴 아메리카(스티브 로저스) 역할을 맡은 배우는 크리스 에반스입니다.

const dog = {
    name: '멍멍이',
    sound: '멍멍!',
    say: function say() {
        console.log(this.sound);
    }
};
dog.say(); // 멍멍!

const dog = {
    name: '멍멍이',
    sound: '멍멍!',
    say: function() {
        console.log(this.sound);
    }
};
dog.say(); // 멍멍!

const numbers = {
    a: 1,
    b: 2
};
numbers['a'] = 5;
console.log(numbers); // { a: 5, b: 2 }

const numbers = {
    a: 1,
    b: 2,
    get sum() {
        console.log('sum 함수가 실행됩니다!');
        return this.a + this.b;
    }
};
console.log(numbers['sum']); // 3
numbers['b'] = 5;
console.log(numbers.sum); // 6

const numbers = {
    _a: 1,
    _b: 2,
    sum: 3,
    calculate() {
        console.log('calculate');
        this.sum = this._a + this._b;
    },
    get a() {
        return this._a;
    },
    get b() {
        return this._b;
    },
    set a(value) {
        console.log('a가 바뀝니다.');
        this._a = value;
        this.calculate();
    },
    set b(value) {
        console.log('b가 바뀝니다.');
        this._b = value;
        this.calculate();
    }
};
console.log(numbers['sum']); // 3
numbers.a = 5;
console.log(numbers.sum); // 7
numbers.b = 7;
console.log(numbers.sum); // 12
numbers.a = 9;
console.log(numbers.sum); // 16
*/

// 07
/*
const array = [1, 2, 3, 4, 5];
const objects = [{name: '멍멍이'}, {name: '야옹이'}];
console.log(objects); // [ { name: '멍멍이' }, { name: '야옹이' } ]
console.log(objects[0]); // { name: '멍멍이' }
console.log(objects[1]); // { name: '야옹이' }

const objects = [{name: '멍멍이'}, {name: '야옹이'}];
objects.push({
    name: '멍뭉이'
});
console.log(objects); // [ { name: '멍멍이' }, { name: '야옹이' }, { name: '멍뭉이' } ]

const objects = [{name: '멍멍이'}, {name: '야옹이'}];
console.log(objects.length); // 2

objects.push({
    name: '멍뭉이'
});
console.log(objects.length); // 3
*/

// 08
/*
for (let i=0; i<10; i++) console.log(i); // 0 ~ 9까지 출력
for (let i=10; i>0; i--) console.log(i); // 10 ~ 1까지 출력

const names = ['멍멍이', '야옹이', '멍뭉이'];
for (let i=0; i<names.length; i++) console.log(names[i]); // 멍멍이, 야옹이, 멍뭉이

let i=0;
while (i<10) {
    console.log(i);
    i++;
} // 0 ~ 9까지 출력(while문은 반드시 중괄호 사용)

let numbers = [10, 20, 30, 40, 50];
for (let number of numbers) console.log(number); // 10, 20, 30, 40, 50

const doggy = {
    name: '멍멍이',
    sound: '멍멍',
    age: 2
};
console.log(Object.entries(doggy)); // [ [ 'name', '멍멍이' ], [ 'sound', '멍멍' ], [ 'age', 2 ] ]
console.log(Object.keys(doggy)); // [ 'name', 'sound', 'age' ]
console.log(Object.values(doggy)); // [ '멍멍이', '멍멍', 2 ]

for (let key in doggy) console.log(`${key}: ${doggy[key]}`); // name: 멍멍이, sound: 멍멍, age: 2

for (let i=0; i<10; i++) {
    if (i === 2) continue; // 다음 루프를 실행
    console.log(i);
    if (i ===5) break; // 반복문을 끝내기
} // 0, 1, 3, 4, 5

function sumOf(numbers) {
    let sum = 0;
    for (let i=0; i<numbers.length; i++) sum += numbers[i];
    return sum;
}
const result = sumOf([1, 2, 3, 4, 5]);
console.log(result); // 15

// 3보다 큰 숫자로만 이루어진 새 배열 만들기
function biggerThanThree(numbers) {
    let newNum = [];
    for (let i=0; i<numbers.length; i++) {
        if (numbers[i] > 3) newNum.push(numbers[i])
    }
    return newNum;
}

const numbers = [1, 2, 3, 4, 5, 6, 7];
console.log(biggerThanThree(numbers)); // [4, 5, 6, 7]
*/

// 09
/*
const superheros = ['아이언맨', '캡틴 아메리카', '토르', '닥터 스트레인지'];

for (let i=0; i<superheros.length; i++) console.log(superheros[i]);
superheros.forEach(hero => {
    console.log(hero);
});

const array = [1, 2, 3, 4, 5, 6, 7, 8];
const squared = [];

for (let i=0; i<array.length; i++) squared.push(array[i]**2);
console.log(squared); // [1,  4,  9, 16, 25, 36, 49, 64]

const array = [1, 2, 3, 4, 5, 6, 7, 8];
const squared = [];

array.forEach(n => {
    squared.push(n ** 2);
});
console.log(squared); // [1,  4,  9, 16, 25, 36, 49, 64]

const array = [1, 2, 3, 4, 5, 6, 7, 8];
const square = n => n ** 2;
const squared = array.map(square);
console.log(squared); // [1,  4,  9, 16, 25, 36, 49, 64]

const array = [1, 2, 3, 4, 5, 6, 7, 8];
const squared = array.map(n => n * n);
console.log(squared); // [1,  4,  9, 16, 25, 36, 49, 64]

const superheros = ['아이언맨', '캡틴 아메리카', '토르', '닥터 스트레인지'];
const index = superheros.indexOf('토르');
console.log(index); // 2

const todos = [
    {
        id: 1,
        text: '자바스크립트 입문',
        done: true
    },
    {
        id: 2,
        text: '함수 배우기',
        done: true
    },
    {
        id: 3,
        text: '객체와 배열 배우기',
        done: true
    },
    {
        id: 4,
        text: '배열 내장함수 배우기',
        done: false
    }
];
const index = todos.findIndex(todo => todo.id === 3);
console.log(index); // 2
const todo = todos.find(todo => todo.id === 3);
console.log(todo); // { id: 3, text: '객체와 배열 배우기', done: true }
const taskNotDone = todos.filter(todo => todo.done === false);
console.log(taskNotDone); // [ { id: 4, text: '배열 내장함수 배우기', done: false } ]
const tasksNotDone2 = todos.filter(todo => !todo.done);
console.log(tasksNotDone2); // const tasksNotDone = todos.filter(todo => !todo.done);

const numbers = [10, 20, 30, 40];
const index = numbers.indexOf(30);
numbers.splice(index, 1); // index부터 1개 원소 제거
console.log(numbers); // [ 10, 20, 40 ]

const numbers = [10, 20, 30, 40];
const sliced = numbers.slice(0, 2); // 0 ~ 2번째 인덱스의 원소 제거
console.log(sliced); // [ 10, 20 ]
console.log(numbers); // [ 10, 20, 30, 40 ]

const value = numbers.shift(); // 첫번째 원소 추출(pop 함수와 비슷)
console.log(value); // 10
console.log(numbers); // [ 20, 30, 40 ]

const numbers = [10, 20, 30, 40];
numbers.unshift(5); // 맨 앞에 새 원소를 추가
console.log(numbers); // [ 5, 10, 20, 30, 40 ]
*/
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const concated = arr1.concat(arr2);
console.log(concated); // [ 1, 2, 3, 4, 5, 6 ]

const array = [1, 2, 3, 4, 5];
console.log(array.join()); // 1,2,3,4,5
console.log(array.join(' ')); // 1 2 3 4 5
console.log(array.join(', ')); // 1, 2, 3, 4, 5

const numbers = [1, 2, 3, 4, 5];
let sum = 0;
numbers.forEach(n => {sum += n});
console.log(sum); // 15

sum = array.reduce((accumulator, current) => accumulator + current, 0);
console.log(sum); // 15

sum = array.reduce((accumulator, current) => {
    console.log({accumulator, current});
    return accumulator + current;
}, 0);
console.log(sum); // 누적합과 총합계

let avg = array.reduce((accumulator, current, index, array) => {
    if (index === array.length - 1) return (accumulator + current) / array.length;
    return accumulator + current;
}, 0); // 평균
console.log(avg); // 3

// 10보다 큰 숫자의 개수
// 첫번째 방법
function countBiggerThanTen(numbers) {
    let cnt = 0;
    for (let i=0; i<numbers.length; i++) {
        if (numbers[i] > 10) cnt++;
    }
    return cnt;
}

// 두번째 방법
function countBiggerThanTen(numbers) {
    /* 구현해보세요 */
    let count = 0;
    numbers.forEach(n => {
        if (n > 10) {
        count++;
        }
    });
    return count;
}

// 세번째 방법
function countBiggerThanTen(numbers) {
    return numbers.filter(n => n > 10).length;
}

// 네번째 방법
function countBiggerThanTen(numbers) {
    return numbers.reduce((acc, current) => {
        if (current > 10) {
            return acc + 1;
        } else {
        return acc;
        }
    }, 0);
}

const count = countBiggerThanTen([1, 2, 3, 5, 10, 20, 30, 40, 50, 60]);
console.log(count); // 5