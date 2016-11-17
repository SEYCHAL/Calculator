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

    CalculatorManager calculatorManager = new CalculatorManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();

    }

    private void initialView() {
        textView = (TextView) findViewById(R.id.result_textview);
        textView.setText("0");

        clearButton = (Button) findViewById(R.id.clear_button);
        buttonPoint = (Button) findViewById(R.id.point_button);

        additionButton = (Button) findViewById(R.id.addition_button);
        substractionButton = (Button) findViewById(R.id.substraction_button);
        multiplicationButton = (Button) findViewById(R.id.multilication_button);
        divisionButton = (Button) findViewById(R.id.division_button);
        equalButton = (Button) findViewById(R.id.equal_button);

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
                textView.setText(calculatorManager.managerButtonOperator("+"));
            }
        });
        substractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButtonOperator("-"));
            }
        });
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButtonOperator("*"));
            }
        });
        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButtonOperator("/"));
            }
        });
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButtonOperator("="));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("1"));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("2"));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("3"));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("4"));
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("5"));
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("6"));
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("7"));
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("8"));
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("9"));
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButton1to9("0"));
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButtonClear());
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(calculatorManager.managerButtonPoint());
            }
        });
    }
}
