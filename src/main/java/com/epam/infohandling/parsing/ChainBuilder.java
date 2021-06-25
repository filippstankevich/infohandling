package com.epam.infohandling.parsing;

public class ChainBuilder {

    public Parser build(){

        return new ParagraphParser(new SentenceParser(new WordParser(null)));
    }
}
