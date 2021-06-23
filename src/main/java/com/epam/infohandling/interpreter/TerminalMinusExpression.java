package com.epam.infohandling.interpreter;

public class TerminalMinusExpression implements Expression {

	@Override
	public void interpret(Context context) {
		Double last = context.popValue();
		Double previous =context.popValue(); 
		context.pushValue(previous - last);

	}

}
