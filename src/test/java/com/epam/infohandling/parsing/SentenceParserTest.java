package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {

    @Test
    public void parsTest() {
        SentenceParser sentenceParser = new SentenceParser(null);
        Composite composite = sentenceParser.parse("Hello world");
        Object object = composite.getChild(1);
        Leaf leaf = (Leaf) object;
        String actual = leaf.getLexeme();
        String expected = "world";
        Assert.assertEquals(expected, actual);
    }
}
