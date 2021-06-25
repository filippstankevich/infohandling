package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SentenceParserTest {

    private String txt ="First sentence. Second sentence. Third sentence.";
    @Test
    public void testParse(){
        Parser parser = new SentenceParser(new WordParser(null));
        Composite composite = parser.parse(txt);
        assertTrue(composite.childSize() == 3);
        assertEquals(composite.getChild(0).toString(), "First sentence");
        assertEquals(composite.getChild(1).toString(), "Second sentence");
        assertEquals(composite.getChild(2).toString(), "Third sentence");
    }
}
