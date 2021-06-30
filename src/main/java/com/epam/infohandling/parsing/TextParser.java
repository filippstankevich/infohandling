package com.epam.infohandling.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

public class TextParser extends AbstractParser {
	private static Logger logger = LogManager.getLogger();
	
	private static final String SPLITTER = "\n\t";
	private static final String root = "Root"; 
	
	public TextParser(Parser successor) {
		super(successor);	
		logger.info("# textParser was created #");
	}

    @Override
    public Component parse(String text) {
    	text = text.trim();
    	Composite composite = new Composite(root, text);
    	String [] paragraphValues = text.trim().split(SPLITTER);
    	for (String paragraph : paragraphValues){
    		Component inner = getSuccessor().parse(paragraph);
    		composite.add(inner);
    	}
		logger.info("# composite was created #");
    	return composite;
    }
}
