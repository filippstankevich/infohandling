package com.epam.infohandling.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.epam.infohandling.parsing.SentenceParser.MATH_SPLITTER;
import com.epam.infohandling.interpreter.ExpressionCalculator;
import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;

public class TextLogic {
	private static Logger logger = LogManager.getLogger();

	ExpressionCalculator calculator = new ExpressionCalculator( ); 
	Map<String, Double> myVariables = new HashMap<String, Double>();

	public TextLogic() {
		myVariables.put("x", 7.0);
		myVariables.put("y", 2.0);
	}

	public Component calculate(Composite tree) {
		List<String> expressions = new ArrayList();
		populatNodesInTree(tree, expressions);

		List<Double> result = calculateExpressions(expressions);
		Composite compositeResult = wrapInComposit(result);
		System.out.println("Variables are:");
		for (Map.Entry<String, Double> myVariable :myVariables.entrySet()) {
			System.out.println(myVariable.getKey() + "=" + myVariable.getValue());
		}
		System.out.println("Results are:");
		for (Double resultValue : result) {
			System.out.println(resultValue);
		}
		logger.info("# composite with expressions was calculated #");
		return compositeResult;
	}


	private List<Double> calculateExpressions(List<String> strMathExpressions) {
		List<Double> result = null;
		if (strMathExpressions != null) {
			result = new ArrayList<Double>();
			for (String strMathExpression : strMathExpressions) {
				Double value = calculator.calculate(strMathExpression, myVariables);
				logger.debug("# expression value is #" + value);
				result.add(value);
			}
		}
		logger.info("# list<Double> with results was filled #");
		return result;
	}

	private Composite wrapInComposit(List<Double> result) {
		Composite root = new Composite("formula root", result.toString());
		for (Double leafResult: result) {
			Leaf leaf = new Leaf("Formula results", String.valueOf(leafResult));
			root.add(leaf);
		}
		return root;
	}

	private void populatNodesInTree(Composite tree, List<String> expressions) {
		for (int i = 0; i < tree.childrenCount(); i++) {
			Component child = (Component)tree.getChild(i);
			if (child.isLeaf()) {
				String value = (String)child.getValue();
				if (value.matches(MATH_SPLITTER)) {
					expressions.add(value);
					System.out.println("Math expression found:" + value);	
				}
			} else {
				populatNodesInTree((Composite)child, expressions);
			}
		}
	}

	public String restore(Composite tree) {
		StringBuilder sbForRestoringText = new StringBuilder();
		restoringTextFromTree(tree, sbForRestoringText);
		String result = sbForRestoringText.toString().replace("\n\n", "\n");
		System.out.println(result);
		logger.info("# text was restored from tree #");
		return result;
	}

	private void restoringTextFromTree(Composite tree, StringBuilder sb) {
		for (int i = 0; i < tree.childrenCount(); i++) {
			Component child = (Component)tree.getChild(i);
			if (child.isLeaf()) {
				sb.append((String)child.getValue()).append(" ");
			} else {
				sb.append("\t");
				restoringTextFromTree((Composite) tree.getChild(i), sb);
				sb.append("\n");
			}
		}
	}

	public String remove4LettersWords(Composite tree) {
		StringBuilder sBuilder = new StringBuilder();
		removeWords(tree, sBuilder);
		System.out.println(sBuilder.toString());
		String result = sBuilder.toString().replace("\n\n", "\n");
		logger.info("# words contains 4 letters was deleted #");
		System.out.println(result);
		return result;
	}

	private void removeWords(Composite tree, StringBuilder sb) {
		for (int i = 0; i < tree.childrenCount(); i++) {
			Component child = (Component)tree.getChild(i);
			if (child.isLeaf()) {
				String value = (String)child.getValue();
				if(value.length() == 4) {
				}else {
					sb.append((String)child.getValue()).append(" ");
				}
			} else {
				sb.append("\t");
				removeWords((Composite) tree.getChild(i), sb);
				sb.append("\n");
			}
		}
	}


	public String removeWordsStartFrowLetter(Composite tree) {
		String partucularLetter = "h";
		StringBuilder sbRemoveWords = new StringBuilder();
		removePartucularWords(tree, sbRemoveWords,partucularLetter);
		System.out.println(sbRemoveWords.toString());
		String result = sbRemoveWords.toString().replace("\n\n", "\n");
		logger.info("# words starts with \"h\" was deleted #");
		System.out.println(result);
		return result;
	}

	private void removePartucularWords(Composite tree, StringBuilder sb, String letter) {
		for (int i = 0; i < tree.childrenCount(); i++) {
			Component child = (Component)tree.getChild(i);
			if (child.isLeaf()) {
				String value = (String)child.getValue();
				if(value.toLowerCase().startsWith(letter)) {
				}else {
					sb.append((String)child.getValue()).append(" ");
				}
			} else {
				sb.append("\t");
				removePartucularWords((Composite) tree.getChild(i), sb, letter);
				sb.append("\n");
			}
		}
	}

	public String swapLexems(Composite tree) {
		List<Composite> sentencies = new ArrayList<>();
		findSentence(tree, sentencies);
		for(int i = 0; i < sentencies.size();i++) {
			Composite sentence = sentencies.get(i);
			Leaf firstChild = (Leaf) sentence.getChild(0);
			Leaf lastChild = (Leaf) sentence.getChild(sentence.childrenCount() -1);
			sentence.setChild(0, new Leaf(lastChild.getValue().toString().replace(".", "")));
			sentence.setChild(sentence.childrenCount() - 1, new Leaf(firstChild.getValue().toString() + "."));
		}
		StringBuilder resultBuilder = new StringBuilder();
		for(Composite element : sentencies) {
			resultBuilder.append(restore(element)).append("\n");
		}
		logger.info("# lexems were swapped in each sentence #");
		System.out.println("result\n" + resultBuilder.toString());
		return resultBuilder.toString().trim();
	} 

	private void findSentence(Composite tree, List<Composite> sentencies) {
		for (int i = 0; i < tree.childrenCount(); i++) {
			Component child = (Component)tree.getChild(i);
			if (child.isLeaf()) {
				Composite parentSentence = child.getParent();
				if(!sentencies.contains(parentSentence)) {
					sentencies.add(child.getParent());
				}
			} else {
				findSentence((Composite) tree.getChild(i), sentencies);
			}
		}
	}
}

