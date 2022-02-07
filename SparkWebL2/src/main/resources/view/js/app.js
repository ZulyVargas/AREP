var buttonCelsius = document.getElementById('button-celsius');
buttonCelsius.addEventListener('click', function () {
    var cels = document.getElementById('celsius').value;
    console.log(cels);
	var url1 = 'http://localhost:4567/convert/toFahrenheit/';
    axios.post(url1, cels)
        .then(res => {
            var obj = JSON.parse(res.data);
            $("#fahrenheit").text("Fahrenheit : " + obj);
            console.log(obj);
        })
        .catch(function (error) {
            console.log(error);
        })
});