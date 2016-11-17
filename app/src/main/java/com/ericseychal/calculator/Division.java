package com.ericseychal.calculator;

/**
 * Created by ericseychal on 17/11/2016.
 */

public class Division extends Sum {
    public double division (double number) {
        if (number!=0) {
            if (operator.equals(" ")) {
                sum = number;
            } else {
                sum = sum / number;
            }
            operator = "/";
        }
        return sum;
    }
}
