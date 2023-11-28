# AJAX
비동기식 자바스크립트 XML의 약자

- JavaScript로 처리
- 페이지의 새로고침 없이 실행이 가능(비동기 방식)
- 현재는 JSON의 자료를 다룸
```javascript
const xhr = new XMLHttpRequest();
xhr.open('GET', '/data/test.json');
xhr.send();
xhr.onreadystatechange = function(e) {
    if(xhr.readyState !== XMLHttpRequest.DONE) return; // 요청
    if(xhr.status === 200) { // 요청 성공 시
        const data = JSON.parse(xhr.responseText);
        console.dir(data);
        const {name, gender, age} = data; // 각 요소를 변수로 담음
    }
};

// JQuery
function getJson(param) { // 함수 정의
    $.ajax({
        contentType: 'application/json',
        type: 'GET', // GET/POST 중 선택
        url: '/data/test.json', // JSON을 불러올 URL
        dataType: 'json', // 데이터 타입 - JSON
        success: function(data) { // 요청 성공 시 쿼리 실행
            console.log(data);
            const {name, gender, age} = data;
        },
        error: function(xhr, status, error) { // 요청 실패 시 에러 로그 전송
            console.log(xhr, status, error);
        }
    });
};
```