package com.epam.infohandling.model;

import java.util.Objects;

public class Leaf implements Component {
  //this is worlds/lexems
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

    @Override
    public String toString(){
        return lexeme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return Objects.equals(lexeme, leaf.lexeme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexeme);
    }
}