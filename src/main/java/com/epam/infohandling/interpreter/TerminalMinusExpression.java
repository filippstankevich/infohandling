package com.epam.infohandling.interpreter;

public class TerminalMinusExpression implements Expression{
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() - context.popValue());
    }
}
