package com.epam.infohandling.logic;

import com.epam.infohandling.interpreter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<Expression> parse (String expression){
        List<Expression> expressions = new ArrayList<>();
        for (String lexeme: expression.split("\\s+")) {
            if (lexeme.isEmpty()){
                continue;
            }
            char tempt = lexeme.charAt(0);
            switch (tempt){
                case '+':
                    expressions.add(new TerminalPlusExpression());
                    break;
                case '-':
                    expressions.add(new TerminalMinusExpression());
                case '*':
                    expressions.add(new TerminalMultiplyExpression());
                case '/':
                    expressions.add(new TerminalDivideExpression());
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()){
                        expressions.add(new NonterminalExpression(scan.nextInt()));
                    }
            }
            
        }
        return expressions;
    }
    public int calculate(String expression){
        Context context = new Context();
        List<Expression> expressions = parse(expression);
        for (Expression terminal: expressions) {
            terminal.interpret(context);

        }
        return context.popValue();

    }
}
