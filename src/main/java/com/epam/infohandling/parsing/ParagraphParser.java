package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;

public class ParagraphParser extends AbstractParser {

    private final String SPLITTER = "[.|!|?]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite("\n");
        String[] parts = text.split(SPLITTER);
        for (String part : parts) {
            Composite inner = getSuccessor().parse(part);
            composite.add(inner);
        }
        return composite;
    }
}
