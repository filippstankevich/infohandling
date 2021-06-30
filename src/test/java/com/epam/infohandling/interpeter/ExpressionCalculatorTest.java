package com.epam.infohandling.interpeter;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.epam.infohandling.interpreter.ExpressionCalculator;

public class ExpressionCalculatorTest {
	private Map<String, Double> variables = new HashMap<String, Double>(); 
	
	public ExpressionCalculatorTest() {
		variables.put("x", 7.0);
	}
	
	@Test
	public void expressionCalculatorTestWithPositiveNumbers() {
		final String expression = "[3 x +]";
		
		ExpressionCalculator expressionCalculator = new ExpressionCalculator();
		Double actualResult = expressionCalculator.calculate(expression, variables);
		
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(10.0, actualResult, 0.01);
	}
	
	@Test
	public void expressionCalculatorTestWithNegativeNumbers() {
		final String expression = "[-3 x +]";
		
		ExpressionCalculator expressionCalculator = new ExpressionCalculator();
		Double actualResult = expressionCalculator.calculate(expression, variables);
		
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(4.0, actualResult, 0.01);
	}
}
