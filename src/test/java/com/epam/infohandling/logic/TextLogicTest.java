package com.epam.infohandling.logic;

import com.epam.infohandling.TextProcessor;
import com.epam.infohandling.model.Composite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TextLogicTest {
    @Test
    public void restoreTest() throws FileNotFoundException, IOException{
        File file = new File("src/test/resources/text.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String expectedRestore = new String(data, "UTF-8");

        TextProcessor textProcessor = new TextProcessor();
        Composite actualParse = textProcessor.parseText(expectedRestore);
        //actualParse.calculateExp();
        TextLogic textLogic = new TextLogic();
        String actualRestore = textLogic.restore(actualParse);
        Assert.assertEquals(expectedRestore, actualRestore);       
    }
    @Test
    public void calculateTest(){
        String text = new String("[13 2 *] [2 2 +]");
        TextProcessor textProcessor = new TextProcessor();
        Composite actualParse = textProcessor.parseText(text);
        
        actualParse.calculateExp();
        
        StringBuilder sb = new StringBuilder();
        actualParse.restoreText(sb);
        String actualCalc = sb.toString();
        String expectedCalc = "26 4.";
        
        Assert.assertEquals(expectedCalc, actualCalc);
    }
    @Test
    public void removeWithGivLenTest(){
        String text = new String("Winter Abc");
        TextProcessor textProcessor = new TextProcessor();
        Composite actualParse = textProcessor.parseText(text);
        TextLogic textLogic = new TextLogic();

        textLogic.removeWithGivLen(actualParse, 6);
        
        StringBuilder sb = new StringBuilder();
        actualParse.restoreText(sb);
        String actualCalc = sb.toString();
        String expectedCalc = "Abc.";
        
        Assert.assertEquals(expectedCalc, actualCalc);
    }
    @Test
    public void removeWithGivLetterTest(){
        String text = new String("Winter Abc");
        TextProcessor textProcessor = new TextProcessor();
        Composite actualParse = textProcessor.parseText(text);
        TextLogic textLogic = new TextLogic();
        
        textLogic.removeWithGivLetter(actualParse, 'A');
        
        StringBuilder sb = new StringBuilder();
        actualParse.restoreText(sb);
        String actual = sb.toString();
        String expected = "Winter.";
        
        Assert.assertEquals(expected, actual);
    }
 @Test
    public void reversLexemesTest(){
        String text = new String("Winter abc");
        TextProcessor textProcessor = new TextProcessor();
        Composite actualParse = textProcessor.parseText(text);
        TextLogic textLogic = new TextLogic();
        
        textLogic.reversLexemes(actualParse);
        
        StringBuilder sb = new StringBuilder();
        actualParse.restoreText(sb);
        String actual = sb.toString();
        String expected = "retniW cba.";
        
        Assert.assertEquals(expected, actual);
    }
    
}
