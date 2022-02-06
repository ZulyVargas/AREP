package edu.escuelaing.edu.calculator;

public class Fahrenheit {

    private Double value = Double.valueOf(0);


    public Fahrenheit(Double value){
        this.value = value;
    }

    /**
     * Returns the degrees.
     * @return the fahrenheit degrees.
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
