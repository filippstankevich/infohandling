package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Leaf;

public class ChainBuilder {

    public Parser build(){

        //return new TextParser(new ParagraphParser(new SentenceParser(null)));//TOdo add LEAF parser for words
        return new ParagraphParser(new SentenceParser(new WordParser(null)));//TOdo add LEAF parser for words
    }
}
