package com.epam.infohandling.interpreter;

public class TerminalDivideExpression implements Expression {

    @Override
    public void interpret(Context context) {
       context.pushValue(context.popValue() / context.popValue());
    }
}