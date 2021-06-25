package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParagraphParserTest {

    private String txt ="first\n\nsecond\n\nthird";
    @Test
    public void testParse(){
        Parser parser = new ParagraphParser(new WordParser(null));
        Composite composite = parser.parse(txt);
        assertTrue(composite.childSize() == 3);
        assertEquals(composite.getChild(0).toString(), "first");
        assertEquals(composite.getChild(1).toString(), "second");
        assertEquals(composite.getChild(2).toString(), "third");
    }
}
