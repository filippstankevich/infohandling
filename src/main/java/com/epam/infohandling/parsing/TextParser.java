package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;

public class TextParser extends AbstractParser {

    private final String SPLITTER = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite("");
        String[] parts = text.split(SPLITTER);
        for (String part : parts) {
            Composite inner = getSuccessor().parse(part);
            composite.add(inner);
        }
        return composite;
    }
}
