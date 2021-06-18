package com.epam.infohandling.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpressionCalculator {

	private List<Expression> parse(String expression) {
		List<Expression> expressions = new ArrayList<>();
		for (String lexeme : expression.split("\\s")) {
			if (lexeme.isEmpty() || (lexeme.equals("[") || lexeme.equals("]"))) {
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
				if (scan.hasNextInt()) {
					expressions.add(
							new NonterminalExpression(scan.nextInt()));
				}
			}
		}
		return expressions;
	}
	
	public int calculate(String expression, Map<String, Double> variables) {
		Context contex = new Context();
		List<Expression> expressions = parse(expression);
		for(Expression terminal : expressions) {
			terminal.interpret(contex);
		}
		return contex.popValue();
	}
}
