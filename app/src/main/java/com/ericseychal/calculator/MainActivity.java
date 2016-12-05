package com.ericseychal.calculator;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mattprecious.telescope.EmailLens;
import com.mattprecious.telescope.TelescopeLayout;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;

import static android.R.id.button1;
import static android.R.id.tabs;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnNormalFragmentListener {
    static final String RACINE_CARRE = "X^2";
    private TextView textView;

    private String bufferText = "0";
    final private String bufferPoint = ",";
    private String bufferOperator = " ";

    private CalculatorManager calculatorManager = new CalculatorManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Telescope
        TelescopeLayout telescopeLayout = (TelescopeLayout) findViewById(R.id.telescope);
        telescopeLayout.setLens(new EmailLens(this, "Buggs Calculator","eric.seychal@gmail.com"));

        initialView();
    }

    // Telescope
    @Override
    protected void onDestroy() {
        TelescopeLayout.cleanUp(this);
        super.onDestroy();
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

    private String managerButtonScientific(String operator) {
        double result = 0;
//        if (bufferOperator.equals(" ")) {
            bufferOperator = operator;
//        }
        result = Double.valueOf(bufferText);
        switch (bufferOperator) {
            case "X^2":
                result = calculatorManager.racine(result);
                operator = " ";
                break;
            default:
        }
//        bufferText = "0";
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
        int[] idButton = {R.id.clear_button, R.id.equal_button};

        for (int ids : idButton) {
            findViewById(ids).setOnClickListener(this);
        }

        // Intensation of Normal Fragment
        NormalFragment normalFragment = (NormalFragment) getSupportFragmentManager().findFragmentById(R.id.normal_fragment);
        normalFragment.setOnNormalFragmentListener(this);

        // Intensation of Scientific Fragment
        ScientificFragment scientificFragment = (ScientificFragment) getSupportFragmentManager().findFragmentById(R.id.scientific_fragment);
        if (scientificFragment != null) {
            scientificFragment.setOnNormalFragmentListener(this);
        }
    }

    private void treatmentButton(String button) {
        int touchAscii = (int) button.charAt(0);
        if (button.equals(RACINE_CARRE)) {
            textView.setText(managerButtonScientific(button));
        } else if (touchAscii == 44) {                            // point
            textView.setText(managerButtonPoint());
        } else if (touchAscii < 48 || touchAscii == 61 || touchAscii == 88) {                       //  operator
            textView.setText(managerButtonOperator(button));
        } else if (touchAscii < 58) {                       // 0 to 9
            textView.setText(managerButton1to9(button));
        } else {                                         // Clear
            textView.setText(managerButtonClear());
        }
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        treatmentButton( button.getText().toString());
    }



    @Override
    public void onClickButton(String button) {
        treatmentButton(button);
    }
}
