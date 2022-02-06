package edu.escuelaing.edu.calculator;

/**
 * Class that allows conversion between temperatures.
 */
public class TemperatureCalculator {
    /**
     *Converts from degrees Celsius to degrees Fahrenheit.
     * @param celsius - temperature to be converted to degrees fahrenheit.
     * @return equivalent temperature in degrees fahrenheit.
     */
    public static Double convertCelsiusToFahrenheit(Celsius celsius) {
        Double fahrenheit;
        fahrenheit = (1.8) * celsius.getValue() + 32;
        return fahrenheit;
    }

    /**
     *Converts from degrees Fahrenheit to degrees Celsius .
     * @param fahrenheit - temperature to be converted to degrees fahrenheit.
     * @return equivalent temperature in degrees celsius.
     */
    public static Double convertFahrenheitToCelsius(Fahrenheit fahrenheit){
        Double celsius;
        celsius = (fahrenheit.getValue() - 32) / 1.8;
        return celsius;
    }

}
