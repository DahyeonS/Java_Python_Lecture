// 1. element selector(form - name)
const form = document.checkForm;
const checkId = form.checkId;
checkId.value = 'hong';
// console.dir(checkId);

// 2. ID가 있을 때
// const checkId2 = document.getElementById('checkId');
// console.dir(checkId2);
document.getElementById("checkId").value = 'hong2';
document.getElementById("checkForm").style.display = 'none';


// 3. jquery dom library
// const checkId3 = $('#checkId');
$('#checkId').val('hong3'); // $(선택자).함수;
$('#checkForm').hide();
$('#checkForm').show();

// 4. querySelector
document.querySelector('#checkId').value = 'hong4';

// document.querySelector('h1').style.backgroundColor = 'red';
// document.querySelector('h2').style.color = 'green';

/*
h1.outerText = "Hello h1"
h2.outerText = "Hello h2"

alert(h1.outerText);
alert(h2.outerText);

const el = h1.nextElementSibling;
console.log(el);
console.log(el.nodeName);

console.log(h1.localName);
console.dir(h1);

h1.style.backgroundColor = 'red';
*/