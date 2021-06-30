package com.epam.infohandling.parsing;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import static  org.mockito.Matchers.anyString;
import static  org.mockito.Mockito.when;

public class ParagraphParserTest {
	
	@Test
	public void paragraphParserTest() {
		
		Parser successor = Mockito.mock(Parser.class);
		
		when(successor.parse(anyString())).thenAnswer(invocation -> {
			String argument = (String) invocation.getArguments()[0];
			return new Leaf(argument);
		});
		
		ParagraphParser paragraphParser = new ParagraphParser(successor);
		Composite composite = (Composite) paragraphParser.parse("First sentence. Second sentence.");
		Assert.assertEquals(new Leaf("First sentence."), composite.getChild(0));
		Assert.assertEquals(new Leaf("Second sentence."), composite.getChild(1));	
	}	
}
