package by.epam.training.calculator.impl;

import by.epam.training.calculator.Calculator;
import by.epam.training.calculator.parser.Parser;
import by.epam.training.calculator.parser.ParserFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public  class StringCalculator implements Calculator {

    public StringCalculator() {}

    public Double calculate(String expression) {
        ParserFactory factory = ParserFactory.getInstance();
        Parser parser = factory.getParser();
        List<String> parsedExpression = parser.parse(expression);
        Deque<Double> stack = new ArrayDeque<>();
        for (String x : parsedExpression) { //OPERATING PARSED STRING
            if (x.equals("sqrt")) stack.push(Math.sqrt(stack.pop()));
            else if (x.equals("cube")) {
                Double tmp = stack.pop();
                stack.push(tmp * tmp * tmp);
            }
            else if (x.equals("pow10")) stack.push(Math.pow(10, stack.pop()));
            else if (x.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (x.equals("-")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a - b);
            }
            else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (x.equals("/")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a / b);
            }
            else if (x.equals("u-")) stack.push(-stack.pop());
            else stack.push(Double.valueOf(x));
        }
        return stack.pop();
    }
}
