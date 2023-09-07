// 함수
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

// 객체
var product = {
    제품명: '7D 건조 망고',
    유형: '당절임',
    성분: '망고, 설탕, 메타충아황산나트륨, 치자황색소',
    원산지: '필리핀'
}; // 객체 선언
for (var i in product) console.log(i + ': ' + product[i]) // 출력

var person = {
    name: '윤인성',
    eat: function(food) {
        console.log(this.name + '이 ' + food + '을/를 먹습니다.');
    }
};
person.eat('밥');