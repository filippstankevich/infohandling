package com.epam.infohandling.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
	
	private Deque<Double> contexValue = new ArrayDeque<>();
	
	public Double popValue() {
		return contexValue.pop();
	}
	
	public void pushValue(Double value) {
		this.contexValue.push(value);
	}
	

}