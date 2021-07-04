package com.epam.infohandling.model;

public interface Component {

    void add(Component component);

    Object getChild(int index);

    void restoreText(StringBuilder text);

    void calculateExp();

    void removeWithGivLen(int length);

    void removeWithGivLetter(char ch);

    void reversLexemes();

    void remove(Component component);
}
