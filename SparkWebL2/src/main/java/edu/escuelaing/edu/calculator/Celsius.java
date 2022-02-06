package edu.escuelaing.edu.calculator;

/**
 * Class representing a temperature in degrees Celsius.
 */
public class Celsius {

    private Double value = Double.valueOf(0);

    public Celsius(Double value){
        this.value = value;
    }

    /**
     * Returns the degrees.
     * @return the celsius degrees.
     */
    public Double getValue() {
        return value;
    }

    /**
     *  Update the degrees.
     * @param value - new degrees value.
     */
    public void setValue(Double value) {
        this.value = value;
    }
}
