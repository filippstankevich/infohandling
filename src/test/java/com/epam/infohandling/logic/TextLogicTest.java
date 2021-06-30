package com.epam.infohandling.logic;

import java.io.IOException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.epam.infohandling.TextProcessor;
import com.epam.infohandling.model.Composite;

public class TextLogicTest {
	
	@Test
	public void textLogicCalculateTest() throws IOException {
		TextProcessor textProcessor = new TextProcessor();
		Composite composite = (Composite) textProcessor.parseText("Text_sample.txt");
		TextLogic logic = new TextLogic();
		Composite actualResult = (Composite) logic.calculate(composite);
		
		Assert.assertNotNull(actualResult);
		Assert.assertEquals("[20.0, 8.0, -3.0, 19.0, 145.0, 840.0]", actualResult.toString());
	}
	
	@Test
	public void textLogicRestore() throws IOException {
		String expectedResult = "I have one nose. \n\t\tYou have long hair.";
		
		TextProcessor textProcessor = new TextProcessor();
		Composite composite = (Composite) textProcessor.parseText("message.txt");
		TextLogic logic = new TextLogic();
		String actualResult = logic.restore(composite);
		
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(expectedResult, actualResult.toString().trim());
	}
	
	@Test
	public void textLogicRemove4LettersWordsTest() throws IOException {
		String expectedResult = "I one nose. \n\t\tYou hair.";
		
		TextProcessor textProcessor = new TextProcessor();
		Composite composite = (Composite) textProcessor.parseText("message.txt");
		TextLogic logic = new TextLogic();
		String actualResult = logic.remove4LettersWords(composite);
		
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(expectedResult, actualResult.toString().trim());
	}
	
	@Test
	public void textLogicRemoveWordsStartFrowLetterTest() throws IOException {
		String expectedResult = "I one nose. \n\t\tYou long";               
		
		TextProcessor textProcessor = new TextProcessor();
		Composite composite = (Composite) textProcessor.parseText("message.txt");
		TextLogic logic = new TextLogic();
		String actualResult = logic.removeWordsStartFrowLetter(composite);
		
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(expectedResult, actualResult.toString().trim());
	}
	
	@Test
	public void  textLogicSwapLexemsTest() throws IOException {
		String expectedResult = "nose have one I. \nhair have long You.";               
		
		TextProcessor textProcessor = new TextProcessor();
		Composite composite = (Composite) textProcessor.parseText("message.txt");
		TextLogic logic = new TextLogic();
		String actualResult = logic.swapLexems(composite);
		
		Assert.assertNotNull(actualResult);
		Assert.assertEquals(expectedResult, actualResult.toString());
	}
}

 