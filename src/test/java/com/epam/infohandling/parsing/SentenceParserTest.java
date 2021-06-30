package com.epam.infohandling.parsing;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import static  org.mockito.Matchers.anyString;
import static  org.mockito.Mockito.when;

public class SentenceParserTest {
	
	@Test
	public void SentenceParserTest() {
		
		Parser successor = Mockito.mock(Parser.class);
		
		when(successor.parse(anyString())).thenAnswer(invocation -> {
			String argument = (String) invocation.getArguments()[0];
			return new Leaf(argument);
		});
		
		SentenceParser sentenceParser = new SentenceParser(successor);
		Composite composite = (Composite) sentenceParser.parse("I want to eat, you want to [13 6 +] eat");
		Assert.assertEquals(new Leaf("I"), composite.getChild(0));
		Assert.assertEquals(new Leaf("[13 6 +]"), composite.getChild(7));
	}
}
