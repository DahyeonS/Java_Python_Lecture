$(function() {
    // $('#header').css('background','red');
    // $('#header').css('color', 'orange');
    // $('#header').html('From JavaScript'); // innerText => text()
    $('h1').css('background','red');
    $('h1').css('color', 'orange');
    $('h1').html('From JavaScript');
    
    let tr = '';
    tr += '<tr>';
    tr += '<td>1</td><td>2</td><td>3</td>';
    tr += '</tr>';

    $('#list').html(tr);;
});