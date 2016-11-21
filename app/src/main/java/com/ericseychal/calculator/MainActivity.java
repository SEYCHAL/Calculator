package com.ericseychal.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;

import static android.R.id.button1;
import static android.R.id.tabs;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
//    private Button clearButton;
////    private List<Button> tabButton  = new ArrayList<>();
//
//    private Button additionButton;
//    private Button substractionButton;
//    private Button multiplicationButton;
//    private Button divisionButton;
//    private Button equalButton;
//
//    private Button button1;
//    private Button button2;
//    private Button button3;
//    private Button button4;
//    private Button button5;
//    private Button button6;
//    private Button button7;
//    private Button button8;
//    private Button button9;
//    private Button button0;
//    private Button buttonPoint;

    private String bufferText = "0";
    final private String bufferPoint = ",";
    private String bufferOperator = " ";

    private CalculatorManager calculatorManager = new CalculatorManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
    }

    private String managerButton1to9(String number) {
        if (bufferText.equals("0")) {
            bufferText = number;
        } else {
            bufferText = bufferText + number;
        }
        return treatmentPoint(bufferText);
    }

    private String managerButtonOperator(String operator) {
        double result = 0;
        if (bufferOperator.equals(" ")) {
            bufferOperator = operator;
        }
        result = Double.valueOf(bufferText);
        switch (bufferOperator) {
            case "+":
                result = calculatorManager.addition(result);
                break;
            case "-":
                result = calculatorManager.substraction(result);
                break;
            case "X":
                result = calculatorManager.multiplication(result);
                break;
            case "/":
                result = calculatorManager.division(result);
                break;
            case "=":
                result = calculatorManager.sum();
                break;
            default:

        }
        bufferText = "0";
        bufferOperator = operator;
        return treatmentPoint(String.valueOf(result));
    }

    private String managerButtonClear() {
        bufferOperator = " ";
        return treatmentPoint(String.valueOf(calculatorManager.clear()));
    }

    private String managerButtonPoint() {
        if (!bufferText.contains(".")) {
            bufferText = bufferText + ".";
        }
        return treatmentPoint(bufferText);
    }

    private String treatmentPoint(String buffer) {
        if (!bufferPoint.equals(".")) {
            int index = buffer.indexOf(".");
            if (index >= 0) {
                String string = buffer.substring(index);
                if (buffer.substring(index).equals(".0")) {
                    buffer = buffer.substring(0, index);
                }
                buffer = buffer.replace(".", ",");
            }
        }
        return buffer;
    }

    @DebugLog
    private void initialView() {
        textView = (TextView) findViewById(R.id.result_textview);
        textView.setText("0");
        int[] idButton = {R.id.clear_button, R.id.addition_button, R.id.division_button, R.id.equal_button, R.id.multilication_button, R.id.point_button, R.id.substraction_button, R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9};

        for (int ids : idButton) {
            findViewById(ids).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String touch = button.getText().toString();
        int touchAscii = (int) touch.charAt(0);

        if (touchAscii == 44) {                            // point
            textView.setText(managerButtonPoint());
        } else if (touchAscii < 48 || touchAscii == 61 || touchAscii == 88) {                       //  operator
            textView.setText(managerButtonOperator(touch));
        } else if (touchAscii < 58) {                       // 0 to 9
            textView.setText(managerButton1to9(touch));
        } else {                                            // Clear
            textView.setText(managerButtonClear());
        }
    }
}
