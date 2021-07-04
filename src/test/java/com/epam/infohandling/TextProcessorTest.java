package com.epam.infohandling;

import com.epam.infohandling.logic.TextLogic;
import com.epam.infohandling.model.Composite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class TextProcessorTest {

    @Test
    public void parseTextTest() throws FileNotFoundException, IOException {
     
        File file = new File("src/test/resources/text.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String expected = new String(data, "UTF-8");
        //System.out.println("__________expected_____________");
        //System.out.println(expected);

        TextProcessor textProcessor = new TextProcessor();
        Composite actualParse = textProcessor.parseText(expected);
        TextLogic textLogic = new TextLogic();
        String actual = textLogic.restore(actualParse);
        //System.out.println("__________actual_____________");
        //System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}
