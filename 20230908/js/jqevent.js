// jqevent.js
$(function() {
    let cnt = 0;
    $('#btn1').click(function() {
        $(this).text(++cnt);
        $('#cnt').text(cnt);
    });

    // img
    // $('img').attr("src", "../imgs/cat/cat1.jpg");
    // $("img").attr("alt", "고양이");
    // $('img').arrr("width", "100");
    $('img').attr({
        src:"../imgs/cat/cat1.jpg",
        alt:"고양이",
        width:"100"
    });

    // div#box
    /*
    const style = {
        width: 100, height: 100, background: 'orange'
    }
    $("#box").css(style);
    */
    $("#box").css({
        width: 100,
        height: 100,
        background: 'orange'
    })
    .on('click', function(e) {
        $(this).css('background', 'red');
    })
    .on('mouseenter', function(e) {
        $(this).css('background', 'blue');
    })
    .on('mouseleave', function(e) {
        $(this).css('background', 'orange');
    });
});