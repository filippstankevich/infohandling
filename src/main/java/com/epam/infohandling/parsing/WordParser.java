package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;

public class WordParser extends AbstractParser {

    private String splitter = " ";

    public WordParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite();
        composite.setDelimiter(splitter);
        String[] strings = text.split(splitter);
        for (String s: strings) {
            Component inner = new Leaf(s.trim());
            composite.add(inner);
        }
        return  composite;
    }
}
