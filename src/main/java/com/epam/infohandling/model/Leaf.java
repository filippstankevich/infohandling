package com.epam.infohandling.model;

import com.epam.infohandling.interpreter.ExpressionCalculator;

public class Leaf implements Component {

    String lexeme;

    public Leaf(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public void add(Component component) {
        throw new Error("Logic error");
    }

    @Override
    public Object getChild(int index) {
        return null;
    }

    @Override
    public void restoreText(StringBuilder text) {
        text.append(lexeme + " ");
    }

    @Override
    public void calculateExp() {
        if (lexeme.charAt(0)=='['){
            lexeme = lexeme.substring(1, lexeme.length()-1);
            ExpressionCalculator expression = new ExpressionCalculator();
            int result = expression.calculate(lexeme);
            lexeme = Integer.toString(result);
        }
    }

    @Override
    public void remove(Component component) {
        throw new Error("Logic error");
    }

}
