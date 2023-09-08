// 객체 class 상속
//  1.
/*
const obj1 = {
    id: 'hong',
    pw: '1111',
    name: '홍길동',
    age: 20
};
*/
/*
function Animal(type, name, sound) {
    this.type = type;
    this.name = name;
    this.sound = sound;
    this.say = function() {
        console.log(this.sound);
    };
};
*/
function Animal(type, name, sound) {
    this.type = type;
    this.name = name;
    this.sound = sound;
};

// 생성자 추가
Animal.prototype.say = function() {
    console.log(this.sound);
};

Animal.prototype.sharedValue = 1;

/*
const dog = new Animal('dog', '멍멍이', '멍멍');
const cat = new Animal('cat', '야옹이', '야옹');

dog.say();
cat.say();
*/

function Dog(name, sound) {
    Animal.call(this, '개', name, sound);
};
Dog.prototype = Animal.prototype;

const Cat = {
    name: '야옹이',
    sound: '야옹'
};

/*
// const tmp = new Object();
console.dir(Animal);
console.dir(Dog);
console.dir(Cat);
*/

const dog = new Dog('멍멍이', '멍멍');
dog.say();

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
dog2.say();

class Dog2 extends Animal2 {
    constructor(name, sound) {
        super('개', name, sound);
    };
};

const dog3 = new Dog2('댕댕이', '댕댕');
dog3.say();