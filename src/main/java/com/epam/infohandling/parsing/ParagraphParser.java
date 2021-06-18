package com.epam.infohandling.parsing;

import java.util.ArrayList;
import java.util.List;

import com.epam.infohandling.model.Composite;

public class ParagraphParser extends AbstractParser {

	public ParagraphParser(Parser successor) {
		super(successor);
	}
	
	@Override
	public Composite parse(String paragraphValue) {
		paragraphValue = paragraphValue.trim();

		int endOfSenstnce = paragraphValue.indexOf(".", 0);
		int lastIndex = 0;
		List<String> sentences = new ArrayList<String>();
		while (endOfSenstnce > 0) {
			String sentence = paragraphValue.substring(lastIndex, endOfSenstnce+1);
			lastIndex = endOfSenstnce +1;
			endOfSenstnce = paragraphValue.indexOf(".", lastIndex + 1);
			sentences.add(sentence);
		}
		
		Composite composite = new Composite("Paragraph", paragraphValue);
		for (String sentence : sentences){
			Composite inner = getSuccessor().parse(sentence);  
    		composite.add(inner);
		}
        return composite;
	}
}
