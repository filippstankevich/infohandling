package com.epam.infohandling.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator {

    public int calculate(String expression) {
        Context context = new Context();
        List<Expression> expressions = parse(expression);
        for (Expression terminal : expressions){
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private List<Expression> parse(String expression) {
        List<Expression> expressions = new ArrayList<>();
        for (String lexeme : expression.split("\\s+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    expressions.add(new TerminalPlusExpression());
                    break;
                case '-':
                    expressions.add(new TerminalMinusExpression());
                    break;
                case '*':
                    expressions.add(new TerminalMultiplyExpression());
                    break;
                case '/':
                    expressions.add(new TerminalDivideExpression());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()){
                        expressions.add(new NonterminalExpression(scan.nextInt()));
                        break;
                    }
                    // TODO: replace by variable value
                    expressions.add(new NonterminalExpression(0));
            }
        }
        return expressions;
    }

}
