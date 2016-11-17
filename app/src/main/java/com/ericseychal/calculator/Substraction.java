package com.ericseychal.calculator;

/**
 * Created by ericseychal on 17/11/2016.
 */

public class Substraction extends Sum {
    public double substraction (double number) {
        if (operator.equals(" ")) {
            sum = number;
        } else {
            sum = sum - number;
        }
        operator = "-";
        return sum;
    }

}
