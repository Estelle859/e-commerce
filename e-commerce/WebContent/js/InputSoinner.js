//$("input[type='number']").InputSpinner();

var myVar = document.getElementById('num').innerText;

$.ajax({
    url: 'panier',
    data: {
        myPostVar: myVar
    },
    type: 'GET'
});


