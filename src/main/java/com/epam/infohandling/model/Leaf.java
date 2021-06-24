package com.epam.infohandling.model;

import java.util.ArrayList;
import java.util.List;

public class Leaf implements Component {
//this is worlds/lexems  really???
    private String lexeme;
    public Leaf(String lexeme){
        this.lexeme = lexeme;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("its final Leaf in Composite pattern");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("its final Leaf in Composite pattern");
    }

    @Override
    public void operation() {
        throw new UnsupportedOperationException("its final Leaf in Composite pattern");
    }

    @Override
    public Object getChild(int index) {
        throw new UnsupportedOperationException("its final Leaf in Composite pattern");
    }
}