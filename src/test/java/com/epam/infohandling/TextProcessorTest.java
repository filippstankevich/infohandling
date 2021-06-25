package com.epam.infohandling;

import com.epam.infohandling.model.Composite;
import com.epam.infohandling.parsing.Parser;
import com.epam.infohandling.parsing.WordParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextProcessorTest {
    private String txt ="First paragraph first sentence. First paragraph second sentence second." +
            "\n\nSecond paragraph first sentence. Second paragraph second sentence sentence.";
    @Test
    public void testParseText(){
        TextProcessor textProcessor = new TextProcessor();
        Composite composite = textProcessor.parseText(txt);


        assertTrue(composite.childSize() == 2);
        assertEquals(composite.getChild(0).toString(), "First paragraph first sentence. First paragraph second sentence second.");
        assertEquals(composite.getChild(1).toString(), "Second paragraph first sentence. Second paragraph second sentence sentence.");

    }


}
