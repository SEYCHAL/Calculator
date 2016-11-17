package com.ericseychal.calculator;

/**
 * Created by ericseychal on 17/11/2016.
 */

public class CalculatorManager {
    private String bufferText = "0";
    private final String bufferPoint = ",";
    private String bufferOperator = " ";

    private Addition addition = new Addition();
    private Substraction substraction = new Substraction();
    private Multiplication multiplication = new Multiplication();
    private Division division = new Division();
    private Clear clear = new Clear();





    public String managerButton1to9(String number) {
        if (bufferText.equals("0")) {
            bufferText = number;
        } else {
            bufferText = bufferText + number;
        }
        return treatmentPoint(bufferText);
    }

    public String managerButtonOperator(String operator) {
        double result = 0;
        if (bufferOperator.equals(" ")) {
            bufferOperator = operator;
        }
        result = Double.valueOf(bufferText);
        switch (bufferOperator) {
            case "+":
                result = addition.addition(result);
                break;
            case "-":
                result = substraction.substraction(result);
                break;
            case "*":
                result = multiplication.multiplication(result);
                break;
            case "/":
                result = division.division(result);
                break;
            case "=":
                result = addition.sum();
        }
        bufferText = "0";
        bufferOperator = operator;
        return treatmentPoint(String.valueOf(result));
    }

    public String managerButtonPoint() {
        if (!bufferText.contains(".")) {
            bufferText = bufferText + ".";
        }
        return treatmentPoint(bufferText);
    }

    public String managerButtonClear() {
        bufferOperator = " ";
        return String.valueOf(clear.clear());
    }

    public String treatmentPoint(String buffer) {
        if (!bufferPoint.equals(".")) {
            int index = buffer.indexOf(".");
            if (index >= 0) {
                String string = buffer.substring(index);
                if (buffer.substring(index).equals(".0")){
                    buffer = buffer.substring(0,index);
                }
                buffer = buffer.replace(".",",");
            }
        }
        return buffer;
    }
}
