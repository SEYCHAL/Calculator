package com.ericseychal.calculator;

/**
 * Created by ericseychal on 16/11/2016.
 */

public class Addition extends Sum {

    public double addition(double number) {
        if (operator.equals(" ")) {
            sum = number;
        } else {
            sum = sum + number;
        }
        operator = "+";
        return sum;
    }
}
