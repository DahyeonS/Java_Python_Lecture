window.onload = function() {
    const clock = document.querySelector('#clock');
    setInterval(function() {
        const now = new Date();
        clock.innerHTML = now.toLocaleString();
    }, 1000); // milliseconds

    console.log('bbbb');
};