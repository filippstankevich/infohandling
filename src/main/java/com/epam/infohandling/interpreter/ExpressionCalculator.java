package com.epam.infohandling.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpressionCalculator {
	private static Logger logger = LogManager.getLogger();


	public List<Expression> parse(String expression, Map<String, Double> variables) {
		expression = expression.replace("[", "");
		expression = expression.replace("]", "");
		List<Expression> expressions = new ArrayList<>();
		for (String lexeme : expression.split("\\s")) {
			if (lexeme.isEmpty()) {
				continue;
			}
			//char temp = lexeme.charAt(0);
			switch (lexeme) {
			case "+":
				expressions.add(new TerminalPlusExpression());
				break;
			case "-":
				expressions.add(new TerminalMinusExpression());
				break;
			case "*":
				expressions.add(new TerminalMultiplyExpression());
				break;
			case "/":
				expressions.add(new TerminalDivideExpression());
				break;
			default:
				if (variables.containsKey(lexeme)) {
					expressions.add(new NonterminalExpression(variables.get(lexeme)));
				} else {
					Scanner scan = new Scanner(lexeme);
					if (scan.hasNextInt()) {
						expressions.add(
								new NonterminalExpression(scan.nextInt()));
					}
				}
			}
		}
		return expressions;
	}

	public Double calculate(String expression, Map<String, Double> variables) {
		Context contex = new Context();
		List<Expression> expressions = parse(expression, variables);
		for(Expression terminal : expressions) {
			terminal.interpret(contex);
		}
		return contex.popValue();
	}
}
