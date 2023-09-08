function buttonClick() {
    alert("click button");
}

function buttonClick(obj) {
    console.dir(obj);
    if (obj.id == 'btn1') {
        obj.innerHTML = '클릭1';
    } else {
        obj.value = '클릭2';
        obj.disabled = true;
    }
}

let cnt = 0;
function count(obj) {
    obj.value = ++cnt;
    document.querySelector("#cnt").innerHTML = cnt;
};

window.onload = function() {
    const btn4 = document.querySelector('#btn4')
    btn4.onclick = function() {
        document.querySelector("#cnt").innerHTML = 1000;
    };
    
    const btn5 = document.querySelector('#btn5')
    btn5.addEventListener('click', function() {
        document.querySelector("#cnt").innerHTML = 10000;
    });
};