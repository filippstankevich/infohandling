package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

public class SentenceParser extends AbstractParser {

    private String splitter = "\\.";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite();
        composite.setDelimiter(splitter);
        composite.setLastDelimiterRequired(true);
        String[] strings = text.split(splitter);
        for (String s: strings) {
            Component inner = getSuccessor().parse(s.trim());
            composite.add(inner);
        }
        return  composite;
    }
}
