package com.ericseychal.calculator;

/**
 * Created by ericseychal on 17/11/2016.
 */

public class Multiplication extends Sum{
    public double multiplication(double number) {
        if (operator.equals(" ")) {
            sum = number;
        } else {
            sum = sum * number;
        }
        operator = "*";
        return sum;
    }
}
