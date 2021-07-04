package com.epam.infohandling.parsing;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

public class ParagraphParserTest {

    @Captor
    private ArgumentCaptor<String> captor;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void parsTest() {
        SentenceParser parser = Mockito.mock(SentenceParser.class);
        ParagraphParser paragraphParser = new ParagraphParser(parser);

        String text = "Hello. World";
        paragraphParser.parse(text);
        verify(parser, times(2)).parse(captor.capture());

        List<String> expected = new ArrayList();
        expected.add("Hello");
        expected.add(" World");
        Assert.assertEquals(expected, captor.getAllValues());
    }
}
