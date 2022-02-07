package edu.escuelaing.arep;

import edu.escuelaing.edu.calculator.Celsius;
import edu.escuelaing.edu.calculator.Fahrenheit;
import edu.escuelaing.edu.calculator.TemperatureCalculator;


import org.junit.*;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Celsius should be converted to Fahrenheit.
     */
    @Test
    public void shouldPassCelsiusToFahrenheit(){
        Assert.assertEquals(TemperatureCalculator.convertCelsiusToFahrenheit(new Celsius(234.0)),453.2,0);
        Assert.assertEquals(TemperatureCalculator.convertCelsiusToFahrenheit(new Celsius(121.0)),249.8,0);
        Assert.assertEquals(TemperatureCalculator.convertCelsiusToFahrenheit(new Celsius(98.0)),208.4,0);
        Assert.assertEquals(TemperatureCalculator.convertCelsiusToFahrenheit(new Celsius(22.0)),71.6,0);
    }

    /**
     * Celsius should be converted to Fahrenheit (border).
     */
    @Test
    public void shouldPassCelsiusToFahrenheitLimit(){
        Celsius c = new Celsius(0.0);
        Assert.assertEquals(TemperatureCalculator.convertCelsiusToFahrenheit(c),32,0);
    }

    /**
     * Fahrenheit should be converted to Celsius.
     */
    @Test
    public void shouldPassFahrenheitToCelsius(){
        Assert.assertEquals(TemperatureCalculator.convertFahrenheitToCelsius(new Fahrenheit(95.0)),35,0);
        Assert.assertEquals(TemperatureCalculator.convertFahrenheitToCelsius(new Fahrenheit(104.0)),40,0);
        Assert.assertEquals(TemperatureCalculator.convertFahrenheitToCelsius(new Fahrenheit(95.0)),35,0);
        Assert.assertEquals(TemperatureCalculator.convertFahrenheitToCelsius(new Fahrenheit(132.5)),55.83333333333333,0);
    }

    /**
     * Fahrenheit should be converted to Celsius.
     */
    @Test
    public void shouldPassFahrenheitToCelsiusLimit(){
        Fahrenheit f = new Fahrenheit(0.0);
        Assert.assertEquals(TemperatureCalculator.convertFahrenheitToCelsius(f),-17.77777777777778,0);
    }
}
