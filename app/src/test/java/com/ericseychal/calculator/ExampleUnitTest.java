package com.ericseychal.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    CalculatorManager calculatorManager;
    @Test
//    public void addition_isCorrect(){
//        assertEquals(4, 2 + 2);
//    }

    @Before
    public void before() {
        calculatorManager = new CalculatorManager();
    }

    @Test
    public void shouldDoAdditionWhenUseEqual() {
        calculatorManager.addition(5.0);
//        calculatorManager.sum();
        calculatorManager.addition(5d);
        double result = calculatorManager.sum();
        assert(result == 10.0);
    }

    @Test
    public void shouldDoSubstractionWhenUseEqual() {
        calculatorManager.substraction(8d);
        calculatorManager.substraction(4d);
        double result = calculatorManager.sum();
        assert(result == 4d);
    }

    @Test
    public void shouldDoMultiplicationWhenUseEqual() {
        calculatorManager.multiplication(8d);
        calculatorManager.multiplication(5d);
        double result = calculatorManager.sum();
        assert(result == 40d);
    }

}