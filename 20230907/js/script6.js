// 내장 함수
window.onload = function() {
    document.querySelector('h1').style.backgroundColor = 'red';
    document.querySelector('h2').style.color = 'green';
};

// jquery 함수
$(document).ready(function(){
    document.querySelector('h1').style.backgroundColor = 'yellow';
    document.querySelector('h2').style.color = 'green';
});

// jquery 함수(단축)
$(function(){
    document.querySelector('h1').style.backgroundColor = 'yellow';
    document.querySelector('h2').style.color = 'green';
});

window.onload = function() {
    $("h1").css("backgroundColor", "yellow");
    $("h2").css("color", "yellow");
};

$(document).ready(function(){
    $("h1").css("backgroundColor", "yellow");
    $("h2").css("color", "yellow");
});

$(function(){
    $("h1").css("backgroundColor", "yellow");
    $("h2").css("color", "yellow");
});