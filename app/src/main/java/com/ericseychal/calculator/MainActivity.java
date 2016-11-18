package com.ericseychal.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button clearButton;

    Button additionButton;
    Button substractionButton;
    Button multiplicationButton;
    Button divisionButton;
    Button equalButton;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonPoint;

    String bufferText = "0";
    final String bufferPoint = ",";
    String bufferOperator = " ";

    CalculatorManager calculatorManager = new CalculatorManager();

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
                case "*":
                    result = calculatorManager.multiplication(result);
                    break;
                case "/":
                    result = calculatorManager.division(result);
                    break;
                case "=":
                    result = calculatorManager.sum();
                    break;
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
                if (buffer.substring(index).equals(".0")){
                    buffer = buffer.substring(0,index);
                }
                buffer = buffer.replace(".",",");
            }
        }
        return buffer;
    }

    private void initialView() {
        textView = (TextView) findViewById(R.id.result_textview);
        textView.setText("0");

        buttonPoint = (Button) findViewById(R.id.point_button);

        additionButton = (Button) findViewById(R.id.addition_button);
        substractionButton = (Button) findViewById(R.id.substraction_button);
        multiplicationButton = (Button) findViewById(R.id.multilication_button);
        divisionButton = (Button) findViewById(R.id.division_button);
        equalButton = (Button) findViewById(R.id.equal_button);
        clearButton = (Button) findViewById(R.id.clear_button);

        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);
        button4 = (Button) findViewById(R.id.button_4);
        button5 = (Button) findViewById(R.id.button_5);
        button6 = (Button) findViewById(R.id.button_6);
        button7 = (Button) findViewById(R.id.button_7);
        button8 = (Button) findViewById(R.id.button_8);
        button9 = (Button) findViewById(R.id.button_9);
        button0 = (Button) findViewById(R.id.button_0);
        

        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButtonOperator("+"));
            }
        });
        substractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButtonOperator("-"));
            }
        });
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButtonOperator("*"));
            }
        });
        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButtonOperator("/"));
            }
        });
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButtonOperator("="));
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButtonClear());
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("1"));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("2"));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("3"));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("4"));
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("5"));
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("6"));
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("7"));
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("8"));
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("9"));
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButton1to9("0"));
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(managerButtonPoint());
            }
        });
    }
}
