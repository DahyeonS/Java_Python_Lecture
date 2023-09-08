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
