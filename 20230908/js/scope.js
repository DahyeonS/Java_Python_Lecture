function func() {
    a = 10;
}

var a = 100;

console.log(a);

function outerFunc() {
    var x = 10;
    var innerFunc = function() {console.log(x)};
    return innerFunc
}
var inner = outerFunc();
inner();