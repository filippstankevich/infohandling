package com.epam.infohandling.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.epam.infohandling.parsing.SentenceParser.MATH_SPLITTER;
import com.epam.infohandling.interpreter.ExpressionCalculator;
import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;

public class TextLogic {
	ExpressionCalculator calculator = new ExpressionCalculator( ); 
	Map<String, Double> myVariables = new HashMap<String, Double>();
	
	public TextLogic() {
		myVariables.put("x", 7.0);
		myVariables.put("y", 2.0);
	}
	
    public Composite calculate(Composite tree) {
    	System.out.println("Finding math expressions in the tree...");
    	List<String> expressions = new ArrayList();
    	populatNodesInTree(tree, expressions);
    	
    	List<Double> result = calculateExpressions(expressions);
    	Composite compositeResult = wrapWithComposit(result);
    	System.out.println("Variables are:");
    	for (Map.Entry<String, Double> myVariable :myVariables.entrySet()) {
    		System.out.println(myVariable.getKey() + "=" + myVariable.getValue());
    	}
    	System.out.println("Results are:");
    	for (Double resultValue : result) {
    		System.out.println(resultValue);
    	}
		return compositeResult;
    }


	private List<Double> calculateExpressions(List<String> strMathExpressions) {
		List<Double> result = null;
		if (strMathExpressions != null) {
			result = new ArrayList<Double>();
			for (String strMathExpression : strMathExpressions) {
				Double value = calculator.calculate(strMathExpression, myVariables);
				result.add(value);
			}
		}
		return result;
	}
	
	private Composite wrapWithComposit(List<Double> result) {
		Composite root = new Composite("formula root", result.toString());
		for (Double leafResult: result) {
			Leaf leaf = new Leaf("Formula results", String.valueOf(leafResult));
			root.add(leaf);
		}
		return root;
	}

	public void populatNodesInTree(Composite tree, List<String> expressions) {
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
    	StringBuilder sb = new StringBuilder();
		for(int i = 0; i < tree.childrenCount(); i++) {
			Composite child = (Composite)tree.getChild(i);
			sb.append("\t");
			for(int j = 0; j < child.childrenCount(); j++) {
				Composite childLevel2 =  (Composite)child.getChild(j);
				for(int z = 0; z < childLevel2.childrenCount(); z++) {
					Leaf childLevel3 =  (Leaf)childLevel2.getChild(z);
					sb.append(childLevel3.getValue()).append(" ");
				}
				sb.append("\n");
			}
		}
		return sb.toString();
        
    }
    
    public Composite reverse(Composite text) {
		return text;
    	
    }
}
