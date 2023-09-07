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
/*
const obj = {
    a: 1,
    b: 2,
    c: 3
};

console.log(obj.a);
console.log(obj['b']);

for (let key in obj) console.log(key, obj[key]);
*/

const obj = {
    a: 1,
    b: 2,
    c: 3,
    getAge: function() {
        return this.a;
    }
};

console.log(obj.getAge());

// 함수 선언
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