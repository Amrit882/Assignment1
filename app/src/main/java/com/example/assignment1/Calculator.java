package com.example.assignment1;

import android.util.Log;

public class Calculator {

    char[] equation;

    void push(String value) {
        value = value.replaceAll("\\s+","");
        equation = new char[value.length()];
        for(int i = 0; i < value.length(); i++)
        {

            equation[i] = value.charAt(i);
        }
    }

    int calculate() {
        int result = 0;
        for(Integer i = 0; i < equation.length - 2; i+=2)
        {
            int q;
            Integer firstOperand;
            Integer secondOperand;
            char operator;

            if(i == 0) {
                firstOperand = Character.getNumericValue(equation[i]);
                secondOperand = Character.getNumericValue(equation[i + 2]);
                operator = equation[i + 1];
                i++;
            }
            else {
                firstOperand = result;
                secondOperand = Character.getNumericValue(equation[i + 1]);
                operator = equation[i];
            }
            switch (operator) {
                    case '+':
                        q = firstOperand + secondOperand;
                        result = q;
                        break;
                    case '-':
                        q = firstOperand - secondOperand;
                        result = q;
                        break;
                    case '*':
                        q = firstOperand * secondOperand;
                        result = q;
                        break;
                    case '/':
                        q = firstOperand / secondOperand;
                        result = q;
                        break;
            }
        }
        return result;
    }


}
