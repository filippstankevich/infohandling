package com.epam.infohandling.parsing;

import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite(". ");
        text = text.trim();
        Pattern pattern = Pattern.compile("(?:(\\[.*?\\]))|(\\S+)");
        Matcher matcher = pattern.matcher(text);
        List<String> result = new ArrayList<>();
        System.out.println("______LEXEMES_______");
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                System.out.println(matcher.group(1));
                composite.add(new Leaf(matcher.group(1)));
            }
            if (matcher.group(2) != null) {
                composite.add(new Leaf(matcher.group(2)));
            }
        }

        return composite;
    }
}
