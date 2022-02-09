var buttonCelsius = document.getElementById('button-celsius');
buttonCelsius.addEventListener('click', function () {
    var celsiusValue = document.getElementById('celsiusValue').value;
	//var url1 = 'http://localhost:4567/convert/toFahrenheit/'+celsiusValue;
	var url1 = 'https://calm-earth-36734.herokuapp.com/convert/toFahrenheit/'+celsiusValue;
    axios.get(url1)
        .then(res => {
            var obj = JSON.parse(res.data);
            $("#fahrenheitResult").text("Fahrenheit : " + obj + "°F");
            console.log(obj);
        })
        .catch(function (error) {
            console.log(error);
        })
});

var buttonFahrenheit = document.getElementById('button-fahrenheit');
buttonFahrenheit.addEventListener('click', function () {
    var fahrenheitValue = document.getElementById('fahrenheitValue').value;
    //var url2 = 'http://localhost:4567/convert/toCelsius/' + fahrenheitValue;
	var url2 = 'https://calm-earth-36734.herokuapp.com/convert/toCelsius/'+ fahrenheitValue;
    axios.get(url2)
        .then(res => {
            var obj2 = JSON.parse(res.data);
            $("#celsiusResult").text("Celsius: " + obj2 + "°C");
            console.log(obj2);
        })
        .catch(function (error) {
            console.log(error);
        })
});