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

var buttonFahrenheit = document.getElementById('button-fahrenheit');
buttonFahrenheit.addEventListener('click', function () {
    var fahr = document.getElementById('fahrenheitd').value;
    console.log(fahr);
	var url2 = 'http://localhost:4567/convert/toCelsius/';
    axios.post(url2, fahr)
        .then(res => {
            var obj2 = JSON.parse(res.data);
            $("#celsiusd").text("Celsius: " + obj2);
            console.log(obj2);
        })
        .catch(function (error) {
            console.log(error);
        })
});