package com.epam.infohandling.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
	
	private Deque<Integer> contexValue = new ArrayDeque<>();
	
	public Integer popValue() {
		return contexValue.pop();
	}
	
	public void pushValue(Integer value) {
		this.contexValue.push(value);
	}
	

}