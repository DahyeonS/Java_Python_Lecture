// jqevent.js
$(function() {
    let cnt = 0;
    $('#btn1').click(function() {
        $(this).text(++cnt);
        $('#cnt').text(cnt);
    });
});