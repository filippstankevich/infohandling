package com.epam.infohandling.logic.comparator;

import com.epam.infohandling.model.Leaf;

import java.util.Comparator;

public class LexemeComparatorAlphabetical implements Comparator<Leaf> {
    @Override
    public int compare(Leaf leaf, Leaf t1) {
        return leaf.toString().compareTo(t1.toString());
    }
}
