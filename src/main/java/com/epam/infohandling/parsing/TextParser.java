package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;

public class TextParser extends AbstractParser {
	
	private static final String SPLITTER = "\n\t";
	
	public TextParser(Parser successor) {
		super(successor);	
	}

    @Override
    public Composite parse(String text) {
    	text = text.trim();
    	Composite composite = new Composite("Root", text);
    	String [] paragraphValues = text.trim().split(SPLITTER);
    	for (String paragraph : paragraphValues){
    		Composite inner = getSuccessor().parse(paragraph);
    		composite.add(inner);
    	}
    	return composite;
    }
}
