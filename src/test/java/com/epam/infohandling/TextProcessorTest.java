package com.epam.infohandling;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import com.epam.infohandling.model.Composite;

public class TextProcessorTest {
	
	@Test
	public void textProcessorTest() throws IOException {
		TextProcessor textProcessor = new TextProcessor();
		Composite composite = (Composite) textProcessor.parseText("message.txt");
		
		assertTrue(composite.childrenCount() == 2);
        assertEquals("I have one nose.", composite.getChild(0).toString());
        assertEquals("You have long hair.", composite.getChild(1).toString());
	}
}
 