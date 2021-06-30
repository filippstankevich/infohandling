package com.epam.infohandling.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

public class ParagraphParser extends AbstractParser {
	private static Logger logger = LogManager.getLogger();

	private static final String SPLITTER = "\\.";
	private static final String dot = ".";
	private static final String paragraph = "Paragraph";

	public ParagraphParser(Parser successor) {
		super(successor);
		logger.info("# paragraphParser was created #");
	}

	@Override
	public Component parse(String paragraphValue) {
		paragraphValue = paragraphValue.trim();

		Composite composite = new Composite(paragraph, paragraphValue);

		String[] parts = paragraphValue.split(SPLITTER);

		for (int i = 0; i < parts.length; i++){
			String value = parts[i] + dot;
			Component inner = getSuccessor().parse(value.trim());  
			composite.add(inner);
		}
		logger.info("# composite with paragraph was created #");
		return composite;
	}
}
