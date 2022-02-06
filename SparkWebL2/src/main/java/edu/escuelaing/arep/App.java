package edu.escuelaing.arep;

import edu.escuelaing.edu.calculator.Celsius;
import edu.escuelaing.edu.calculator.Fahrenheit;
import edu.escuelaing.edu.calculator.TemperatureCalculator;

import static spark.Spark.*;
import com.google.gson.Gson;
/**
 * Web class with spark implementation
 * @author Zuly Valentina Vargas Ramirez
 */

public class App 
{
    public static void main(String[] args) {

        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        path("/convert",()->{
            get("/toFahrenheit/:value", (req, res)->{
                res.type("application/json");
                return new Gson().toJson(TemperatureCalculator.convertCelsiusToFahrenheit(new Celsius(Double.valueOf(req.params(":value")))));
            });
            get("/toCelsius/:value", (req, res)->{
                res.type("application/json");
                return new Gson().toJson(TemperatureCalculator.convertFahrenheitToCelsius(new Fahrenheit(Double.valueOf(req.params(":value")))));
            });

        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}