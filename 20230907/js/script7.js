window.onload = function() {
    // const header = document.querySelector('#header');
    const headers = document.querySelectorAll('h1');
    console.log(headers.length);
    
    for(let i=0; i<headers.length; i++) {
        let header = headers[i];
        header.style.background = 'red';
        header.style.color = 'orange';
        header.innerHTML = 'From JavaScript';
    }

    const header = document.querySelector('#header');
    console.dir(header);

    // header.style.background = 'red';
    // header.style.color = 'orange';
    // header.innerHTML = 'From JavaScript';
    // header.innerHTML = "<input type='checkbox'>";
    // header.innerText = "<input type='checkbox'>";
    
    let tr = '';
    tr += '<tr>';
    tr += '<td>1</td><td>2</td><td>3</td>';
    tr += '</tr>';

    const table = document.querySelector('#list');
    table.innerHTML = tr;
};