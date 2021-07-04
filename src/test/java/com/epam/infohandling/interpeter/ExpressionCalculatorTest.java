package com.epam.infohandling.interpeter;

import com.epam.infohandling.interpreter.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {
    @Test
    public void calculateTest(){
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int actualLexeme = expressionCalculator.calculate("13 2 *");
        int expectedLexeme = 26;
        Assert.assertEquals(expectedLexeme, actualLexeme);
    }
}
