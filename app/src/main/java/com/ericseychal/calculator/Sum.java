package com.ericseychal.calculator;

/**
 * Created by ericseychal on 16/11/2016.
 */

public class Sum {
    static protected double sum;
    static protected double operating;
    static protected String operator=" ";

    public static double getSum() {
        return sum;
    }

    public static void setSum(double sum) {
        Sum.sum = sum;
    }

    public static String getOperator() {
        return operator;
    }

    public static void setOperator(String operator) {
        Sum.operator = operator;
    }

    public static double getOperating() {
        return operating;
    }

    public static void setOperating(double operating) {
        Sum.operating = operating;
    }

    public double sum () {
        return sum;
    }

}
