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
        staticFiles.location("/view");

        get("/inicio",(request,response)-> {
            response.redirect("/index.html");
            return null;
        });

            //Celsius a Fahrenheit
        path("/convert", ()-> {
                get("/toFahrenheit/:value", (req, res) -> {
                    res.status(200);
                    res.header("Access-Control-Allow-Origin", "*");
                    res.type("application/json");
                    return new Gson().toJson(TemperatureCalculator.convertCelsiusToFahrenheit(new Celsius(Double.valueOf(req.params(":value")))));
                });
                //Fahrenheit a Celsius
                get("/toCelsius/:value", (req, res) -> {
                    res.status(200);
                    res.header("Access-Control-Allow-Origin", "*");
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