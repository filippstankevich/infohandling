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
    public Component parse(String text) {
        Component composite = new Composite();
        String[] strings = text.split(splitter);
        for (String s: strings) {
            Component inner = new Leaf(s);
            composite.add(inner);
        }
        return  composite;
    }
}
