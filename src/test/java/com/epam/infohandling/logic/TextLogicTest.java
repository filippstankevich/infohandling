package com.epam.infohandling.logic;

import com.epam.infohandling.TextProcessor;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextLogicTest {

    private String txt ="First paragraph first sentence. First paragraph second sentence second." +
            "\n\nSecond paragraph first sentence. Second paragraph second sentence sentence.";

    @Test
    public void testRestore(){
        TextProcessor textProcessor = new TextProcessor();
        Composite composite = textProcessor.parseText(txt);
        String restoredText = TextLogic.restore(composite);
        assertEquals(txt,restoredText);
    }

    @Test
    public void testCountSentencesWithEqualWords(){
        TextProcessor textProcessor = new TextProcessor();
        Composite composite = textProcessor.parseText(txt);
        int result = TextLogic.countSentencesWithEqualWords(composite);
        assertTrue(2 == result);

    }
    @Test
    public void testSortSentencesByLexemeCountAscending(){
        TextProcessor textProcessor = new TextProcessor();
        Composite composite = textProcessor.parseText(txt);

        List<Composite> result = TextLogic.sortSentencesByLexemeCountAscending(composite);
        assertTrue(4 == result.size());
        assertEquals(result.get(0).toString(), "First paragraph first sentence");
        assertEquals(result.get(1).toString(), "Second paragraph first sentence");
        assertEquals(result.get(2).toString(), "First paragraph second sentence second");
        assertEquals(result.get(3).toString(), "Second paragraph second sentence sentence");

    }

    @Test
    public void testSortSentencesByLexemeCountDescending(){
        TextProcessor textProcessor = new TextProcessor();
        Composite composite = textProcessor.parseText(txt);

        List<Composite> result = TextLogic.sortSentencesByLexemeCountDescending(composite);
        assertTrue(4 == result.size());
        assertEquals(result.get(2).toString(), "First paragraph first sentence");
        assertEquals(result.get(3).toString(), "Second paragraph first sentence");
        assertEquals(result.get(0).toString(), "First paragraph second sentence second");
        assertEquals(result.get(1).toString(), "Second paragraph second sentence sentence");

    }

    @Test
    public void testSortLexemes(){
        String lexemes = "A. aa abababa cccscsdfs.";
        TextProcessor textProcessor = new TextProcessor();
        Composite composite = textProcessor.parseText(lexemes);

        List<Leaf> result = TextLogic.sortLexemes(composite);
        assertTrue(4 == result.size());
        assertEquals(result.get(0), new Leaf("A"));
        assertEquals(result.get(1), new Leaf("aa"));
        assertEquals(result.get(2), new Leaf("abababa"));
        assertEquals(result.get(3), new Leaf("cccscsdfs"));
    }

    @Test
    public void testSwapFirstAndLastLexemes(){

        String expected = "sentence paragraph first First. second paragraph second sentence First." +
                "\n\nsentence paragraph first Second. sentence paragraph second sentence Second.";

        TextProcessor textProcessor = new TextProcessor();
        Composite composite = textProcessor.parseText(txt);

        TextLogic.swapFirstAndLastLexemes(composite);

        assertEquals(composite.toString(), expected);

    }

    @Test
    public void testCalculate(){
        String original = "Fifteen [5 3 *]. Sum 6 [3 3 +]. Minus [3 2 -]. Division [3 9 /].";
        String expected = "Fifteen 15 . Sum 6 6 . Minus -1 . Division 3 .";

        TextProcessor textProcessor = new TextProcessor();
        Composite composite = textProcessor.parseText(original);

        TextLogic.calculate(composite);

        assertEquals(composite.toString(), expected);
    }

}
