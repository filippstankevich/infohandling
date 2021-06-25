package com.epam.infohandling.logic;

import com.epam.infohandling.interpreter.ExpressionCalculator;
import com.epam.infohandling.logic.comparator.LexemeComparatorAlphabetical;
import com.epam.infohandling.logic.comparator.SentenceComparatorByLexemeCount;
import com.epam.infohandling.model.Composite;
import com.epam.infohandling.model.Leaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextLogic {
    private static final Logger logger = LogManager.getLogger(TextLogic.class);
    private TextLogic(){}

    public static Composite calculate(Composite text) {

        List<Composite> sentences = getSentences(text);

        for (Composite sentence: sentences) {
            int start = -1;
            int end = -1;
            boolean takeExpression = false;
            StringBuilder expression = new StringBuilder();
            for (int i = 0; i < sentence.childSize(); i++) {
                if (sentence.getChild(i).toString().contains("[")){
                    //start of expression
                    start = i;
                    takeExpression = true;
                }
                if (sentence.getChild(i).toString().contains("]")){
                    //end of expression
                    end = i;
                    expression.append(sentence.getChild(i));
                    replaceExpression(sentence, expression.toString(), start, end);
                  //  i = start;
                    takeExpression = false;
                }
                if (takeExpression){
                    expression.append(sentence.getChild(i)).append(" ");
                }

            }
        }
        return text;
    }

    private static void replaceExpression(Composite sentence, String expression, int start, int end){
        expression = expression.replaceAll("\\[", "");
        expression = expression.replaceAll("]", "");
        ExpressionCalculator calc = new ExpressionCalculator();
        Integer expressionResult = calc.calculate(expression);

        List<Leaf> lexemes = getLexemes(sentence);
        for (Leaf lexeme: lexemes) {
            sentence.remove(lexeme);
        }
        for (int i = start; i <= end; i++) {
            lexemes.remove(start);
        }
        lexemes.add(start, new Leaf(expressionResult.toString()));
        for (int i = start +1; i <= end ; i++) {
            lexemes.add(start +1, new Leaf(""));
        }
        for (Leaf lexeme: lexemes) {
            sentence.add(lexeme);
        }
    }


    ////////////////////////////////////////////
    public static String restore(Composite text) {
        logger.info("restoring text");
        return text.toString();
    }

    // sentences which have two or more equal words
    public static int countSentencesWithEqualWords(Composite text){
        logger.info("countSentencesWithEqualWords");
        int result = 0;
        //get Sentences
        List<Composite> sentences = getSentences(text);
        for (Composite sentence: sentences) {
            if(sentenceHasEqualWords(sentence)){
                result++;
            }
        }
        return result;
    }

    private static boolean sentenceHasEqualWords(Composite sentence){
        logger.info("sentenceHasEqualWords");
        Set<Leaf> words = new HashSet<>();
        for (int i = 0; i < sentence.childSize(); i++) {
            if (!words.add((Leaf) sentence.getChild(i))){
                return true;
            }
        }
        return false;
    }

    private static List<Composite> getSentences(Composite text){
        logger.info("getSentences");
        List<Composite> sentences = new ArrayList<>();
        for (int i = 0; i < text.childSize(); i++) {
            Composite sentenceCandidate = (Composite)text.getChild(i);
            if (sentenceCandidate.getDelimiter().equals(".")){//delimiter that defines sentences. Sentences are children of that object
                for (int j = 0; j < sentenceCandidate.childSize(); j++) {
                    sentences.add((Composite) sentenceCandidate.getChild(j));
                }
                continue;
            }else {
                sentences.addAll(getSentences(sentenceCandidate)) ;
            }

        }
        return sentences;
    }

    public static List<Composite> sortSentencesByLexemeCountAscending(Composite text){
        logger.info("sortSentencesByLexemeCountAscending");
        List<Composite> sentences = getSentences(text);
        sentences.sort(new SentenceComparatorByLexemeCount());
        return sentences;
    }

    public static List<Composite> sortSentencesByLexemeCountDescending(Composite text){
        logger.info("sortSentencesByLexemeCountDescending");
        List<Composite> sentences = getSentences(text);
        Comparator c = Collections.reverseOrder(new SentenceComparatorByLexemeCount());
        sentences.sort(c);
        return sentences;
    }
    public static List<Leaf> sortLexemes(Composite sentence){
        logger.info("sortLexemes");
        List<Leaf> lexemes = getLexemes(sentence);
        lexemes.sort(new LexemeComparatorAlphabetical());
        return lexemes;
    }

    private static List<Leaf> getLexemes(Composite text){
        logger.info("getLexemes");
        List<Leaf> lexemes = new ArrayList<>();

        if (text.getDelimiter().equals(" ")){
            for (int j = 0; j < text.childSize(); j++) {
                lexemes.add((Leaf) text.getChild(j));
            }
        }
        else{
            for (int i = 0; i < text.childSize(); i++) {
                Composite sentenceCandidate = (Composite)text.getChild(i);
                if (sentenceCandidate.getDelimiter().equals(" ")){//delimiter that defines words. Lexemes are children of that object
                    for (int j = 0; j < sentenceCandidate.childSize(); j++) {
                        lexemes.add((Leaf) sentenceCandidate.getChild(j));
                    }
                    continue;
                }else {
                    lexemes.addAll(getLexemes(sentenceCandidate)) ;
                }

            }
        }


        return lexemes;
    }

    public static void swapFirstAndLastLexemes(Composite txt){
        logger.info("swapFirstAndLastLexemes");
        List<Composite> sentences = getSentences(txt);
        for (Composite sentence: sentences) {
            List<Leaf> lexemes = getLexemes(sentence);
            if (lexemes.size() > 1){
                Leaf tmp = lexemes.get(0);
                lexemes.remove(0);
                lexemes.add(0,lexemes.get(lexemes.size() - 1));
                lexemes.remove(lexemes.size() - 1);
                lexemes.add(tmp);

                for (Leaf lexeme: lexemes) {
                    sentence.remove(lexeme);
                }
                for (Leaf lexeme: lexemes) {
                    sentence.add(lexeme);
                }
            }


        }
    }
}
