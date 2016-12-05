package com.ericseychal.calculator;

/**
 * Created by ericseychal on 18/11/2016.
 */

public class CalculatorManager {
    private double sum;
    private String operator=" ";

    public double sum () {
        return sum;
    }

    public double addition(double number) {
        if (operator.equals(" ")) {
            sum = number;
        } else {
            sum = sum + number;
        }
        operator = "+";
        return sum;
    }

    public double clear() {
        sum = 0;
        operator = " ";
        return sum;
    }

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

    public double multiplication(double number) {
        if (operator.equals(" ")) {
            sum = number;
        } else {
            sum = sum * number;
        }
        operator = "*";
        return sum;
    }

    public double substraction (double number) {
        if (operator.equals(" ")) {
            sum = number;
        } else {
            sum = sum - number;
        }
        operator = "-";
        return sum;
    }

    public double racine (double number) {
        if (number == 0) {
            number = sum;
        }
        sum = number * number;
        operator = "=";
        return sum;
    }

}
