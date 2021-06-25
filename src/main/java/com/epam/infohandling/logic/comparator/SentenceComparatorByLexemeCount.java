package com.epam.infohandling.logic.comparator;

import com.epam.infohandling.model.Composite;

import java.util.Comparator;

public class SentenceComparatorByLexemeCount implements Comparator<Composite> {
    @Override
    public int compare(Composite o, Composite o1) {
        return Integer.compare(o.childSize(),o1.childSize());
    }
}
