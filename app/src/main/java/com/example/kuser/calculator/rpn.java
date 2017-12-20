package com.example.kuser.calculator;

/**
 * Created by kuser on 11/10/17.
 * http://rosettacode.org/wiki/Parsing/RPN_calculator_algorithm#Java_2
 */

import java.util.LinkedList;

public final class rpn {
    private rpn () {}

    public static String eval(String expr) {

        String result = null;
        String cleanExpr = cleanExpr(expr);
        LinkedList<Double> stack = new LinkedList<Double>();


        for(String token:cleanExpr.split("\\s")) {

            Double tokenNum = null;
            try {
                tokenNum = Double.parseDouble(token);
            } catch (NumberFormatException e) {
            }

            if (tokenNum != null)
                stack.push(Double.parseDouble(token + ""));
            else {
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                if (token.equals("*"))
                    stack.push(firstOperand * secondOperand);
                else if (token.equals("/"))
                    stack.push(firstOperand / secondOperand);
                else if (token.equals("-"))
                    stack.push(firstOperand - secondOperand);
                else if (token.equals("+"))
                    stack.push(firstOperand + secondOperand);
                else if (token.equals("^"))
                    stack.push(Math.pow(firstOperand, secondOperand));
                else
                    return "Error"; //just in case
            }
            result = stack.toString();
        }
        return result;
    }

    private static String cleanExpr(String expr){
        //remove all non-operators, non-whitespace, and non digit chars
        return expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
    }
}
