package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;
//we dont need this parser. it was just an example
public class TextParser extends AbstractParser {

    private String splitter = "\n";

    public TextParser(Parser successor){
        super(successor);
    }
    @Override
    public Composite parse(String text) {
        Composite composite = new Composite();
        composite.setDelimiter(splitter);
        String[] strings = text.split(splitter);
        for (String s: strings) {
            Component inner = getSuccessor().parse(s.trim());
            composite.add(inner);
        }
        return  composite;
    }
}
