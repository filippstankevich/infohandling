package com.epam.infohandling.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Composite implements Component {

    private List<Component> chields = new ArrayList<Component>();
    private String end;

    public Composite(String end) {
        this.end = end;
    }

    @Override
    public void add(Component component) {
        chields.add(component);
    }

    @Override
    public Object getChild(int index) {
        return chields.get(index);
    }

    @Override
    public void restoreText(StringBuilder text) {
        for (Component component : chields) {
            component.restoreText(text);
        }
        text.deleteCharAt(text.length() - 1);
        text.append(end);
    }

    @Override
    public void calculateExp() {
        for (Component component : chields) {
            component.calculateExp();
        }
    }

    @Override
    public void remove(Component component) {
        chields.remove(component);
    }

    @Override
    public void removeWithGivLen(int length) {
        if (!chields.isEmpty() && chields.get(0) instanceof Leaf) {
            ListIterator<Component> iter = chields.listIterator();
            while (iter.hasNext()) {
                Component component = iter.next();
                Leaf leaf = (Leaf) component;
                if (leaf.getLexeme().length() == length) {
                    iter.remove();
                }
            }
            return;
        }
        for (Component component : chields) {
            component.removeWithGivLen(length);
        }
    }

    @Override
    public void removeWithGivLetter(char ch) {
        if (!chields.isEmpty() && chields.get(0) instanceof Leaf) {
            ListIterator<Component> iter = chields.listIterator();
            while (iter.hasNext()) {
                Component component = iter.next();
                Leaf leaf = (Leaf) component;
                if (leaf.getLexeme().charAt(0) == ch) {
                    iter.remove();
                }
            }
            return;
        }
        for (Component component : chields) {
            component.removeWithGivLetter(ch);
        }
    }

    @Override
    public void reversLexemes() {
        if (!chields.isEmpty() && chields.get(0) instanceof Leaf) {
            ListIterator<Component> iter = chields.listIterator();
            while (iter.hasNext()) {
                Component component = iter.next();
                Leaf leaf = (Leaf) component;
                StringBuilder sb = new StringBuilder();
                for (int i = leaf.lexeme.length() - 1; i >= 0; i--) {
                    sb.append(leaf.lexeme.charAt(i));
                }
                leaf.lexeme = sb.toString();
            }
            return;
        }
        for (Component component : chields) {
            component.reversLexemes();
        }

    }
}