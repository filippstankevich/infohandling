package com.epam.infohandling.interpreter;

public class TerminalDivideExpression implements Expression {

    @Override
    public void interpret(Context context) {
    	Double last = context.popValue();
		Double previous =context.popValue();
    	context.pushValue(previous/last);
    }
}