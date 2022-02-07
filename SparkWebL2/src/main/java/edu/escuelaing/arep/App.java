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

        get("/convert",(request,response)-> {
            response.redirect("/index.html");
            return null;
        });

        //Celsius a Fahrenheit
        post("/convert/toFahrenheit/", (req, res)->{
            res.status(200);
            res.type("application/json");
            return new Gson().toJson(TemperatureCalculator.convertCelsiusToFahrenheit(new Celsius(Double.valueOf(req.body()))));
        });
        //Fahrenheit a Celsius
        post("/convert/toCelsius/", (req, res)->{
            res.status(200);
            res.type("application/json");
            return new Gson().toJson(TemperatureCalculator.convertFahrenheitToCelsius(new Fahrenheit(Double.valueOf(req.body()))));
        });

    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}