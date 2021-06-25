package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordParserTest {
    private String txt ="First second third.";
    @Test
    public void testParse(){
        Parser parser = new WordParser(null);
        Composite composite = parser.parse(txt);
        assertTrue(composite.childSize() == 3);
        assertEquals(composite.getChild(0).toString(), "First");
        assertEquals(composite.getChild(1).toString(), "second");
        assertEquals(composite.getChild(2).toString(), "third.");
    }
}
