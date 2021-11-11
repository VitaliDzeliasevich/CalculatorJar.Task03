package by.epam.training.calculator.parser;

import by.epam.training.calculator.parser.impl.ExpressionParser;

public class ParserFactory {

    private ParserFactory() {}

    private static final ParserFactory instance = new ParserFactory();

    private final Parser stringParser = new ExpressionParser();

    public static ParserFactory getInstance() {
        return instance;
    }

    public Parser getParser() {
        return stringParser;
    }
}
