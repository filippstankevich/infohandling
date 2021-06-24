package com.epam.infohandling;

import com.epam.infohandling.model.Component;
import com.epam.infohandling.model.Composite;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String txt = getText("text.txt");
        TextProcessor processor = new TextProcessor();
        Component composite = processor.parseText(txt);
        System.out.println(composite);
    }


    private static String getText(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
}
