package com.epam.infohandling.interpreter;

public class NonterminalExpression implements Expression {
	
	private double number;
	
	public NonterminalExpression(double number) {
		this.number = number;
	}

    @Override
    public void interpret(Context context) {
    	context.pushValue(number);
    }
    @Override
    public String toString() {
    	return String.valueOf(number);
    }
}