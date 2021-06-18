package com.epam.infohandling.parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;

public class SentenceParser extends AbstractParser {
	
	private static final String SPLITTER = "\\s";
	private static final String  MATH_SPLITTER = "\\[([a-z|0-9|+|-|*/|–|\\s]+)\\]";
			
	public SentenceParser(Parser successor) {
		super(null);
	}

	@Override
	public Composite parse(String sentenceValue) {
		sentenceValue = sentenceValue.trim();
		Composite sentenceNoda = new Composite("Sentence", sentenceValue);
		
		Pattern pattern = Pattern.compile(MATH_SPLITTER);
		Matcher matcher = pattern.matcher(sentenceValue);
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(0);
		while (matcher.find()) {
			marks.add(matcher.start());
			marks.add(matcher.end());
		}
		marks.add(sentenceValue.length());
		List<String> splits = new ArrayList<String>();
		for (int i = 0; i < marks.size() - 1; i++) {
			String split = sentenceValue.substring(marks.get(i), marks.get(i+1));
			splits.add(split);
		}
		
		for (String split : splits) {
			if (Pattern.matches(MATH_SPLITTER, split)) {
				Leaf leafNoda = new Leaf("Word", split);
				sentenceNoda.add(leafNoda);
			} else {
				String[] simpleWords = split.split(SPLITTER);
				for (String simpleWord : simpleWords) {
					if(!simpleWord.isEmpty()) {
						Leaf leafNoda = new Leaf("Word", simpleWord);
						sentenceNoda.add(leafNoda);
					}
				}
			}
		}
		return sentenceNoda;	
	}
}
