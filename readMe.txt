Intro to OOP

Contents:
Design patterns
UML class diagram
Info handling task + Composite pattern
Chain of Responsibility + Interpreter

Task:
Implement an application that can parse text from file. Implement method that can calculate expressions in the text. Implement method that can build parsed text into String. The application also should be able to do three of the following operations:

1 Count sentences with equals words i.e. sentences that have two or more equal words
2 Sort sentences by lexeme count in ascending or descending order
3 In each sentence swap first and last lexeme
4 Sort lexeme inside a sentence in alphabetical order
5 Sort lexeme inside a sentence by letter count in ascending or descending order
6 Remove all words of the given length
7 Remove all words that starts from a given letter
8 Reverse lexemes in sentences
9 lexeme is either word or a mathematical expression

Requirements:

1 The text should be parsed into an object. This object should be a tree containing paragraphs, sentences, lexemes. The lexeme is either word or math expression. Use Composite pattern
Model classes should have no logic
2 You should be able to restore text from the object. Multiple spaces or table could be one space after restoration
3 Use regular expression to parse the text. In your code regular expressions should be constants.
4 Use Chain of Responsibility when parsing the text
5 Your parsers should be stateless, do not create unnecessary parser object, ideally you should have only one parser object (do not use singleton pattern).
6 You should be able to calculate math expressions . Использовать Interpreter.
7 Use Log4J2 for logging.
8 Should implements 3 additional logical operations on the text (see above)
9 No main class should be added. Use unit tests